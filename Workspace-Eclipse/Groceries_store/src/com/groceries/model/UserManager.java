package com.groceries.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.groceries.data.ConnectionManager;

public class UserManager {

	public static synchronized boolean registerUser(User user) {
		Connection connection = ConnectionManager.getConnection();
		User existUser = getUserByEmail(user.getEmail());
		if (existUser != null) {
			return false;
		}
		try {
			PreparedStatement statement = connection.prepareStatement(
					"insert into users_table (first_name,last_name,email,phone,password,gender) values(?,?,?,?,?,?)");
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPhone());
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getGender());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static synchronized boolean authenticateUser(String email, String password) {
		User user = getUserByEmail(email);
		if (user != null)
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return true;
			}
		return false;
	}

	public static User getUserByEmail(String email) {
		Connection connection = ConnectionManager.getConnection();
		User user = null;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from users_table where email=?");
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String phone = resultSet.getString("phone");
				String password = resultSet.getString("password");
				String gender = resultSet.getString("gender");
				user = new User(firstName, lastName, email, phone, password, gender);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
