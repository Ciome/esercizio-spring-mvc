<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<style>
	.error {color:red}
</style>
</head>
<body>
	<a href="/spring-mvc-test/">Index</a><br><br>
	<form:form action="registerAccount" modelAttribute="account">
		
		Username: <form:input path="username"/><br>
		<form:errors path="username" cssClass="error"/><br>
		
		Password: <form:password path="password"/><br>
		<form:errors path="password" cssClass="error"/><br>
		
		<input type="submit" value="Login" /><br>
	</form:form>
	<br>
	${registerErrorMessage}

</body>
</html>