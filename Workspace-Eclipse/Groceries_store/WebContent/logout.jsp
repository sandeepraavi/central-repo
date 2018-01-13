<%@page import="com.groceries.model.UserManager"%>
<%@ page import="com.groceries.model.User"%>
<!-- To disable automatic session creation when accessing jsp page -->
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout Page</title>
</head>
<body>
	<%
	 response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
		response.setHeader("Pragma","no-cache"); //HTTP 1.0 
		response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
		
	   if (request.getSession(false)!=null) {
	      HttpSession httpSession=request.getSession();
	      httpSession.removeAttribute("user");
	      httpSession.invalidate();
	      System.out.print("invalidated");
	   }
	%>
	<jsp:include page="reg_login.jsp" />
</body>
</html>