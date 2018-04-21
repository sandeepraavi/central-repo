 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admission Success</title>
</head>
<body>
<h2>Welcome back, ${name}</h2>
<h2>${common}</h2>
<h3>${msg}</h3>
<table>
<tr><td>${msg}</td></tr>
<tr><td>Student Name: </td><td>${student.studentName}</td></tr>
<tr><td>Student Hobby:</td><td>${student.studentHobby}</td></tr>
<tr><td>Student Mobile:</td><td>${student.mobileNo}</td></tr>
<tr><td>Student DOB:</td><td>${student.dob}</td></tr>
<tr><td>Student Skills:</td><td>${student.studentSkills}</td></tr>
<tr><td>Student Address:</td></tr>
<tr><td>Street:</td><td>${student.address.street}</td></tr>
<tr><td>City:</td><td>${student.address.city}</td></tr>
<tr><td>Country:</td><td>${student.address.country}</td></tr>
<tr><td>Zip Code:</td><td>${student.address.zipCode}</td></tr>
</table>
</body>
</html>