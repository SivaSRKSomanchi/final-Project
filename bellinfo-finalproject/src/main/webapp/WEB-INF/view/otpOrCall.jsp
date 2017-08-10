<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="otp1">
		<label>Please Select one of the ways to verify your Account- </label>
		<label>Text<input type="checkbox" Value = "TEXT" name = "mode"></label>
		<label>Call<input type="checkbox" Value = "CALL" name ="mode"/></label>
		<input type = "submit" />
		
	</form:form>
</body>
</html>