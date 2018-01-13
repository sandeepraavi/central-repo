package com.groceries.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groceries.model.User;
import com.groceries.model.UserManager;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		User user = new User(firstName, lastName, email, phone, password, gender);
		boolean result = UserManager.registerUser(user);
		if (result) {
			request.setAttribute("signup-success", "Signup successful - Login now");
			RequestDispatcher dispatcher = request.getRequestDispatcher("reg_login.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("sign-up-error-message", "The mail id is already registered with us");
			RequestDispatcher dispatcher = request.getRequestDispatcher("reg_login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
