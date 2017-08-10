<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>App Home Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<style type="text/css">

/* body {
	background:
		url(https://s-media-cache-ak0.pinimg.com/originals/ba/a3/aa/baa3aa1cca168dac8ad8fe2c20bef1f5.jpg)
		no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
} */

h2{
font-size: 2.0rem;
	font-weight: bold;
	color: #2c3e50;
	width: 50%;
  border: 20px solid #bdc3c7;
  padding: 20px;
  margin: 250px 650px;
  max-width: 700px;
}

.list {
	font-size: medium;
	font-weight: 700;
}
</style>

</head>
<body>


	<nav class="navbar nav-inverse">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#mobileDisplay"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="#" class="navbar-brand">PPNH</a>
		</div>
		<div class="collapse navbar-collapse" id="mobileDisplay">
			<ul class="nav navbar-nav ">
				<li class="list"><a href="${pageContext.request.contextPath}/saveUser/about">About</a></li>
				<li class="list"><a href="${pageContext.request.contextPath}/saveUser/contact">Contact</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="list"><a href="${pageContext.request.contextPath}/saveUser/otp">Transfer Funds</a></li>
				<li class="list"><a href="${pageContext.request.contextPath}/saveUser/accountSummary">Account Summary</a></li>
				<li class="list"><a href="${pageContext.request.contextPath}/saveUser/transactions">Transactions</a></li>
				<li class="list"><a href="${pageContext.request.contextPath}/saveUser/update">Change Credentials</a></li>
				<li class="list"><a href="${pageContext.request.contextPath}/saveUser/thanksForVisit">Logout</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<script src="https://code.jquery.com/jquery-3.2.1.js"
		integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>


</body>
</html>

