<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="afterloginHomePage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactions</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>Bank Of India</h1>
		</div>
	</div>

	<div id=container>
		<h3>Recent Transactions committed from your Account.</h3>
		<h4>We appreciate you, Thanks for using our service.</h4>
		<table border=1px>
			<tr>
				<td>Transaction Id</td>
				<td>Your Username</td>
				<td>Your Account Number</td>
				<td>Recipient Name</td>
				<td>Recipient Account Number</td>
				<td>Amount Transferred</td>
				<td>Transaction Status</td>
			</tr>
			<c:forEach var="transUserList" items="${transUserList}">

				<tr>
					<td>${transUserList.transactionId}</td>
					<td>${transUserList.payer}</td>
					<td>${transUserList.payerAccountNumber}</td>
					<td>${transUserList.recipientName}</td>
					<td>${transUserList.recipientAccountNumber}</td>
					<td>${transUserList.amount}</td>
					<td>${transUserList.fundsTransferred}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>