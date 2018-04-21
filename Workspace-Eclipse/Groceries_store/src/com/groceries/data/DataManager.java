package com.groceries.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.groceries.model.Product;

public class DataManager {

	public static synchronized Map<String, String> getPurchasehistoryMapFor(String email) {
		Map<String, String> map = new HashMap<String, String>();

		ResultSet resultSet = getResultSet("SELECT * FROM purchase_history_table as p INNER JOIN "
				+ "users_table as u ON  p.user_id=u.user_id where u.email='" + email + "'");

		try {
			while (resultSet.next()) {
				map.put("purchase_one", resultSet.getString("last_one_purchase_category"));
				map.put("purchase_two", resultSet.getString("last_two_purchase_category"));
				map.put("purchase_three", resultSet.getString("last_three_purchase_category"));
			}
		} catch (SQLException e) {
		}

		return map;
	}

	public static synchronized List<Product> getProductList() {
		List<Product> productList = new ArrayList<Product>();
		ResultSet resultSet = getResultSet("SELECT * FROM products_table");
		try {
			while (resultSet.next()) {
				productList.add(new Product(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

	public static ResultSet getResultSet(String query) {
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		try {
			preparedStatement = ConnectionManager.getConnection().prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
}
