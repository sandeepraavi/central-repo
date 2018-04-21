<%@page import="com.groceries.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.groceries.data.DataManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- To disable automatic session creation when accessing jsp page -->
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="styles/home.css">
<script src="http://code.jquery.com/jquery-1.9.1.js"
	type="text/javascript"></script>
<script type="text/javascript" src="scripts/add_item.js"></script>
<style type="text/css">
.submit {
	background: url(images/cart.png) no-repeat;
	cursor: pointer;
	border: none;
	position: fixed;
	right: 0px;
	top: 100px;
	border-radius: 50%;
	width: 100px;
	height: 100px;
	background-size: 100px;
	background-position: 8px 7px;
	background-repeat: no-repeat;
	font-family: monospace;
	font-size: x-large;
	color: red;
}
</style>
</head>
<body>
	<jsp:include page="top_nav.jsp" />
	<form action="confirm.jsp" method="post">
		<table class="table">
			<tbody>
				<tr>
					<%
						int i = 0;
						List<Product> productList = DataManager.getProductList();
						for (Product product : productList) {
					%>
					<td><img src="images/<%=product.getProductName()%>.png"
						width='200px' height='300px'>
						<h2><%=product.getProductName()%></h2>
						<p>
							Price: $<%=product.getProductPrice()%></p>
						<div class="holder">
							<div style="display: block" class="add">
								<input type="button" value="Add" class='button'>
							</div>
							<div style="display: none" class="modify">
								<input type="button" value="-" style="margin-right: 10px"
									class="button">Qty: <input type="text"
									name="<%=product.getProductId()%>" disabled="disabled"
									style="width: 30px;" value="1" class="input"><input
									type="button" value="+" style="margin-left: 10px"
									class="button">
							</div>
						</div></td>
					<%
						if ((i = i + 1) % 3 == 0) {
					%>
				</tr>
				<tr>
					<%
						}
						}
					%>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="0" class="submit">
	</form>
</body>
</html>
