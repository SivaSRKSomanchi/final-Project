<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h1>Bank Of India</h1>
		</div>
	</div>

	<div id="container">
		<h3>Update Your Details Here..</h3>
	</div>
	<form:form action="savedata"
		modelAttribute="userRegis" method="POST">
		
		<!-- NEED TO ASSOCIATE WITH THE CUSOTMER ID -->
		<form:hidden path = "id"/> 
		<table>
			<tbody>
				<tr>
					<td><label>Account Number:</label></td>
					<td><form:input path="accountNumber"/></td>
				</tr>
				<tr>
					<td><label>CIF Number:</label></td>
					<td><form:input path="cifNumber" /></td>
				</tr>
				<tr>
					<td><label>BranchCode:</label></td>
					<td><form:input path="branchCode" /></td>
				</tr>

				<tr>
					<td><label>Country:</label></td>
					<td><form:input path="country" /></td>
				</tr>

				<tr>
					<td><label>PhoneNumber:</label></td>
					<td><form:input path="phoneNumber" /></td>
				</tr>
				<tr>
					<td><label>Username:</label></td>
					<td><form:input path="username"/></td>
				</tr>
				<tr>
					<td><label>Password:</label></td>
					<td><form:input path="password" /></td>
				</tr>
				<tr>
					<td><label>First Name:</label></td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td><label>Last Name:</label></td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td><label>Monthly Salary:</label></td>
					<td><form:input path="salary" /></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save"/></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>