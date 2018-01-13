<%@page import="com.groceries.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.groceries.data.DataManager"%>
<%@page import=" java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- To disable automatic session creation when accessing jsp page -->
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
th, td {
	padding: 10px;
}

input {
	cursor: auto;
	border: none;
	border-radius: 10px;
	padding: 10px;
	margin: 10px;
	font-size: 20px;
	background: #1ab188;
	color: white;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="top_nav.jsp" />
	<table style='margin-top: 100px;'>
		<thead>
			<tr>
				<th>Item name</th>
				<th>Unit price</th>
				<th># of items</th>
				<th>Total price</th>
			</tr>
		</thead>
		<tbody>
			<%
				Enumeration<String> keys = request.getParameterNames();
				List<Product> productList = DataManager.getProductList();
				double sum = 0;
				while (keys.hasMoreElements()) {
					String current = (String) keys.nextElement();
			%>
			<tr>
				<%
					for (Product product : productList) {
							int itemCount;
							if (product.getProductId().equals(current)
									&& (itemCount = (int) Math.floor(Double.parseDouble(request.getParameter(current)))) >= 1) {
				%>
				<td><%=product.getProductName()%></td>
				<td>$ <%=product.getProductPrice()%></td>
				<td>x <%=itemCount%></td>
				<td>$ <%=itemCount * Float.parseFloat(product.getProductPrice())%></td>
				<%
					sum += itemCount * Float.parseFloat(product.getProductPrice());
							}
						}
				%>

				<%
					}
				%>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><b>Total</b></td>
				<td><b><%=sum%></b></td>
			</tr>
		</tbody>
	</table>
	<input type="hidden" id="fromconfirm" name="fromconfirm" value="fromconfirm"></input>
	<%
	request.setAttribute("fromconfirm",request.getParameter("fromconfirm"));
	 %>
	<% 
	String signupcheck = (String)request.getAttribute("signupcheck");
	String logincheck = (String)request.getAttribute("logincheck");
	if(signupcheck == null || logincheck == null){
	 %>
	 <a href="reg_login.jsp"><input type='button' value="Proceed"></a>
	 <%
	 }else{
	  %>
	<a href="details.jsp"><input type='button' value="Proceed"></a>
	<%
	}
	 %>
</body>
</html>