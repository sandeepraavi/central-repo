package com.groceries.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groceries.model.User;
import com.groceries.model.UserManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/home")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean isAuthenticated = UserManager.authenticateUser(email, password);
		if (isAuthenticated) {
			User user = UserManager.getUserByEmail(email);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			// TODO create a data bean for banner slide for this user
			response.sendRedirect("home.jsp");
		} else {
			request.setAttribute("login-error-message", "Entered Email/Password is invalid");
			RequestDispatcher dispatcher = request.getRequestDispatcher("reg_login.jsp");
			dispatcher.forward(request, response);
		}
		out.close();
	}
}
