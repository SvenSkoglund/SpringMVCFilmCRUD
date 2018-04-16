<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
</head>
<body>
	<c:if test="${ filmEdited }">
		<h1>Film Edited</h1>
	</c:if>
	<c:if test="${! empty film }">
		<h1>Film Found</h1>
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
				<td>Category</td>
				<td>${film.category }</td>
			</tr>
			<tr>
				<td>Cast</td>
				<td>${film.cast }</td>
			</tr>
		</table>
		<form action="deleteFilm.do">
			Which Film ID would you like to delete<input type="text"
				name="filmId">
			<button name="delete" type="submit" value="delete">Delete</button>
		</form>
		<form action="editFilm.do">
			What is the ID of the film you would like to edit <input type="text"
				name="id" /> <input type="submit" value="Edit Film" />
		</form>
	</c:if>
	<c:if test="${empty film }">
		<h2>Film Not Found</h2>
	</c:if>
	<!--  -->

	<a href="index.html"><button name="goHome" type="button"
			class="btn btn-primary btn-lg" value="goHome">Go Back to
			Homepage</button></a>

</body>
</html>