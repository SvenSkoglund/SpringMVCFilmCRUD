<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete</title>
</head>
<body>
	<form:form action="delete.do" method="POST" modelAttribute="film">
		<form:label path="deleteId">Delete Film by ID:</form:label>
		<form:input path="deleteId" />
		<form:errors path="deleteId" />

		<input type="submit" value="Delete" />
	</form:form>

</body>
</html>