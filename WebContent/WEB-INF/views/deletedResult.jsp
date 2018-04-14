
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Deleted Film</title>
</head>

<body>

	<c:if test="${ifDeleted }">
		<h1>Deleted Film:</h1>
		<table>

			<tr>
				<td>ID</td>
				<td>${film.id }</td>
			</tr>

			<tr>
				<td>Title</td>
				<td>${film.title }</td>
			</tr>

			<tr>
				<td>Description</td>
				<td>${film.description }</td>
			</tr>

			<tr>
				<td>Release Year</td>
				<td>${film.releaseYear }</td>
			</tr>

			<tr>
				<td>Language ID</td>
				<td>${film.languageId }</td>
			</tr>

			<tr>
				<td>Rental Duration</td>
				<td>${film.rentalDuration }</td>
			</tr>

			<tr>
				<td>Rental Rate</td>
				<td>${film.rentalRate }</td>
			</tr>

			<tr>
				<td>Length</td>
				<td>${film.length }</td>
			</tr>

			<tr>
				<td>Replacement Cost</td>
				<td>${film.replacementCost }</td>
			</tr>

			<tr>
				<td>Rating</td>
				<td>${film.rating }</td>
			</tr>

			<tr>
				<td>Special Features</td>
				<td>${film.specialFeatures }</td>
			</tr>

			<tr>
				<td>Cast</td>
				<td>${film.cast }</td>
			</tr>
		</table>
	</c:if>
	<c:if test="${not ifDeleted }">
		<h1>Could not delete film</h1>
	</c:if>
	<a href="index.html"><button name="goHome" type="submit"
			value="goHome">Go Back to Homepage</button></a>
</body>
</html>