<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- To disable automatic session creation when accessing jsp page -->
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"
	type="text/javascript"></script>
<script type="text/javascript" src="scripts/form.js"></script>
<link rel="stylesheet" type="text/css" href="styles/form.css">

</head>
<body> 
<jsp:include page="top_nav.jsp" />
	<%
		response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1 
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
		response.setDateHeader("Expires", 0); //prevents caching at the proxy server 

		if (request.getSession(false) != null) {
	%>
	<p style='color: white'>
		It seems you already logged in. Go to <a href="home.jsp"
			style='text-decoration: none; color: red'>Home Page</a>
	</p>
	<%
		} else {
			String loginError = (String) request.getAttribute("login-error-message");
			String signupError = (String) request.getAttribute("sign-up-error-message");
			String signupSuccess = (String) request.getAttribute("signup-success");
	%>
	<div class="form">
		<ul class="tab-group">
			<%
				if (signupError != null) {
			%>
			<li class="tab"><a class='a' href="#login">Log In</a></li>
			<li class="tab active"><a class='a' href="#signup">Sign Up</a></li>
			<%
				} else {
			%>
			<li class="tab active"><a class='a' href="#login">Log In</a></li>
			<li class="tab"><a class='a' href="#signup">Sign Up</a></li>
			<%
				}
			%>
		</ul>

		<div class="tab-content">

			<%
				if (signupError == null) {
			%>
			<div id="login" style="display: block;">
				<%
					} else {
				%>
				<div id="login" style="display: none;">
					<%
						}
					%>
					<%
						if (signupSuccess != null) {
					%>
					<h1><%=signupSuccess%></h1>
					<input type="hidden" id="signupcheck" name="signupcheck" value="signupcheck"></input> 
					<%
					request.setAttribute("signupcheck", request.getParameter("signupcheck"));
					 %>					
					<%
						} else {
					%>
					<h1>Welcome Back!</h1>
					<input type="hidden" id="logincheck" name="logincheck" value="logincheck"></input> 
					<%
					request.setAttribute("logincheck", request.getParameter("logincheck"));
					 %>
					<%
						}
					%>
					<form action="home" method="post">
						<div class="field-wrap">
							<label> Email ID<span class="req">*</span>
							</label> <input class='input' type="email" required
								autocomplete="off" name="email" />
						</div>

						<div class="field-wrap">
							<label> Password<span class="req">*</span>
							</label> <input class='input' type="password" required autocomplete="off"
								name="password" />
						</div>

						<p class="forgot">
							<a class='a' href="#">Forgot Password?</a>
						</p>
						<%
							if (loginError != null) {
						%>
						<p style="color: red"><%=loginError%></p>
						<%
							}
						%>
						<%
String fromconfirm = (String) request.getAttribute("fromconfirm");
if(fromconfirm != null){
 %>
							
								<a href="details.jsp" class="button button-block"><input type='button' value="Continue to checkout"></a>
								<%
								}
								 else{
								  %>
						<button class="button button-block" type="submit">Log In</button>
						<%
						}
						 %>
					</form>
				</div>

				<%
					if (signupError != null) {
				%>
				<div id="signup" style="display: block;">
					<%
						} else {
					%>
					<div id="signup" style="display: none;">
						<%
							}
						%>
						<h1>Welcome!</h1>
						<form action="register" method="post">
							<div class="top-row">
								<div class="field-wrap">
									<label> First Name<span class="req">*</span>
									</label> <input class='input' type="text" required autocomplete="off"
										name="firstName" />
								</div>

								<div class="field-wrap">
									<label> Last Name<span class="req">*</span>
									</label> <input class='input' type="text" required autocomplete="off" name="lastName" />
								</div>
							</div>

							<div class="field-wrap">
								<label> Email Address<span class="req">*</span>
								</label> <input class='input' type="email" required autocomplete="off" name="email" />
							</div>

							<div class="field-wrap">
								<div class="field-wrap">
									<label> Phone Number<span class="req">*</span>
									</label> <input class='input' type="tel" required autocomplete="off" name="phone" />
								</div>
							</div>

							<div class="field-wrap">
								<label> Set A Password<span class="req">*</span>
								</label> <input class='input' type="password" required autocomplete="off"
									name="password" />
							</div>

							<div class="field-wrap">
								<label> Re-Enter Password<span class="req">*</span>
								</label> <input class='input' type="password" required autocomplete="off"
									name="rePassword" />
							</div>

							<div class="field-wrap">
								<input class='input' type="radio" id="radio01" name="gender" value="male" />
								<label class="radio" for="radio01"><span></span>Male</label> <input class='input'
									type="radio" id="radio02" name="gender" value="female" /> <label
									class="radio" for="radio02"><span></span>Female</label>
							</div>
							<%
								if (signupError != null) {
							%>
							<p style="color: red"><%=signupError%></p>
							<%
								}
							%>
<%
String fromconfirm1 = (String) request.getAttribute("fromconfirm");
if(fromconfirm1 != null){
 %>
							
								<a href="details.jsp" class="button button-block"><input type='button' value="Continue to checkout"></a>
								<%
								}
								 else{
								  %>
								  <button type="submit" class="button button-block">Sign
								Up</button>
								  <%
								  }
								   %>
						</form>
					</div>
				</div>
			</div>
			<%
				}
			%>
		
</body>
</html>