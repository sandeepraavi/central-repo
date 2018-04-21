<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<h1>${headerMessage}</h1>
	<h3>STUDENT ADMISSION FORM FOR ENGINEERING COURSES</h3>

	<form:errors path="student1.*" />

	<form action="/Registration/submitAdmissionForm.html"
		method="post">
		<table>
			<tr>
				<td>Student's Name :</td>
				<td><input type="text" name="studentName" /></td>
			</tr>
			<tr>
				<td>Student's Mobile :</td>
				<td><input type="text" name="studentMobile" /></td>
			</tr>

		</table>
		<table>
			<tr>
				<td>Student's Address :</td>
			</tr>
			<tr>
				<td>country: <input type="text" name="studentAddress.country" /></td>
				<td>city: <input type="text" name="studentAddress.city" /></td>
				<td>street: <input type="text" name="studentAddress.street" /></td>
				<td>Zipcode:<input type="text" name="studentAddress.zipcode" /></td>
			</tr>

			<tr>
				<td><input type="submit"
					value="Submit this form by clicking here" /></td>
			</tr>
		</table>

	</form>
</body>
</html>

