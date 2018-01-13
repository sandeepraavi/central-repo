<%@page import="com.groceries.data.DataManager"%>
<%@page import="com.groceries.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- To disable automatic session creation when accessing jsp page -->
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles/top_nav.css">
</head>
<body>
	<div class='navv'>
		<div class='nav-left'>
			<a href='home.jsp'><img
				src='https://cdn.colorlib.com/wp/wp-content/uploads/sites/2/2014/02/Olympic-logo.png'
				id='logo' width='150px' /></a>
		</div>
		<div class='nav-right'>
			<div class='nav-right-top'>
				<input type='text' id='search-input'> <input type='button'
					value='Search' id='search-button'>
				<div class='welcome-note'>
					<%
						if (request.getSession(false) != null) {
					%>
					<p class='p'>
						Welcome <b><%=((User) request.getSession().getAttribute("user")).getFirstName()%></b>
						<a href='logout.jsp' id='login-button'>Logout</a>
					</p>
					<%
						} else {
					%>
					<p class='p'>
						Welcome guest <a href='reg_login.jsp' id='login-button'>
							Login/Signup</a>
					</p>
					<%
						}
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>