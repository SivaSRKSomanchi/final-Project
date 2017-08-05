<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@include file="afterloginHomePage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Funds Transfer Page</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>Bank Of India</h1>
		</div>
	</div>

	<div id=container>
		<h3>Transfer Funds to your Beneficiary</h3>
		<form:form action="paymentForm" modelAttribute="userList"
			method="POST">
			<table border=1px>
				<tr>
					<td>Select Recipient</td>
					<td>Account Number</td>
					<td>CIF Number</td>
					<td>Branch Code</td>
					<td>Country</td>
					<td>Phone Number</td>
					<td>User Name</td>
					<td>First Name</td>
					<td>Last Name</td>
				</tr>
				<c:forEach var="tempList" items="${userList}">
					
					<tr>
						<td><input type="radio" name="radioButton" value="${tempList.id}"/></td>
						<td>${tempList.accountNumber}</td>
						<td>${tempList.cifNumber}</td>
						<td>${tempList.branchCode}</td>
						<td>${tempList.country}</td>
						<td>${tempList.phoneNumber}</td>
						<td>${tempList.username}</td>
						<td>${tempList.firstName}</td>
						<td>${tempList.lastName}</td>
					</tr>
				</c:forEach>
			</table>
			<input type="text" name="amount" placeholder="EnterValue" />
			<br>
			<input type="submit" value="Pay Now" class="save" />
		</form:form>
	</div>
</body>
</html>
