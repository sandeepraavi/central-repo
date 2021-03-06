<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admission Form</title>
</head>
<body>
	<h1>Student admission for new Courses</h1>
	<h2>${common}</h2>
	<form:errors path="student.*" />
	<form action="/FirstSpringDemo/submitAdmissionForm.html" method="POST">
		<table>
			<tr>
				<td>Student's Name:</td>
				<td><input type="text" name="studentName" /></td>
			</tr>
			<tr>
				<td>Student's Hobby:</td>
				<td><input type="text" name="studentHobby" /></td>
			</tr>
			<tr>
				<td>Student's Mobile:</td>
				<td><input type="text" name="mobileNo" /></td>
			</tr>
			<tr>
				<td>Student's Date of birth (MM-dd-yyyy):</td>
				<td><input type="text" name="dob" /></td>
			</tr>
			<tr>
				<td>Student's Skills:</td>
				<td><select name="studentSkills" multiple="multiple">
						<option value="Java core">Java Core</option>
						<option value="Full Stack">Full Stack</option>
						<option value="Front end">Front end</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit this form"></td>
			</tr>
		</table>
	</form>
	<form action="/FirstSpringDemo/submitAdmissionForm1.html" method="POST">
		<table>
			<tr>
				<td>Student's Name:</td>
				<td><input type="text" name="studentName" /></td>
			</tr>
			<tr>
				<td>Student's Hobby:</td>
				<td><input type="text" name="studentHobby" /></td>
			</tr>
			<tr>
				<td>Student's Mobile:</td>
				<td><input type="text" name="mobileNo" /></td>
			</tr>
			<tr>
				<td>Student's Date of birth:</td>
				<td><input type="text" name="dob" /></td>
			</tr>
			<tr>
				<td>Student's Skills:</td>
				<td><select name="studentSkills" multiple="multiple">
						<option value="Java core">Java Core</option>
						<option value="Full Stack">Full Stack</option>
						<option value="Front end">Front end</option>
				</select></td>
			</tr>
			<tr>
				<td>Student's Address Details</td>
			</tr>
			<tr>
				<td>Street:</td>
				<td><input type="text" name="address.street" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="address.city" /></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type="text" name="address.country" /></td>
			</tr>
			<tr>
				<td>Zip Code:</td>
				<td><input type="text" name="address.zipCode" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit this form"></td>
			</tr>
		</table>
	</form>
</body>
</html>