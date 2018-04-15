<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit</title>
</head>
<body>
	<h3>Edit Film</h3>

	<form action="filmEdited.do" method="GET">
		<table>
			<tr>
				<td>Title</td>
				<td>${film.title }</td>
				<td>Edit Title: <input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td>${film.description }</td>
				<td>Edit Description: <input type="text" name="description" /></td>
			</tr>
			<tr>
				<td>Release Year</td>
				<td>${film.releaseYear }</td>
				<td>Edit Release Year: <input type="text" name="releaseYear" /></td>
			</tr>
			<tr>
				<td>Language ID</td>
				<td>${film.languageId }</td>
				<td>Edit Language ID: <input type="text" name="languageId" /></td>

			</tr>
			<tr>
				<td>Rental Duration</td>
				<td>${film.rentalDuration }</td>
				<td>Edit Rental Duration: <input type="text"
					name="rentalDuration" /></td>
			</tr>
			<tr>
				<td>Rental Rate</td>
				<td>${film.rentalRate }</td>
				<td>Edit Rental Rate: <input type="text" name="rentalRate" /></td>
			</tr>
			<tr>
				<td>Length</td>
				<td>${film.length }</td>
				<td>Edit Length: <input type="text" name="length" /></td>
			</tr>
			<tr>
				<td>Replacement Cost</td>
				<td>${film.replacementCost }</td>
				<td>Edit Replacement Cost: <input type="text"
					name="replacementCost" /></td>
			</tr>
			<tr>
				<td>Rating</td>
				<td>${film.rating }</td>
				<td>Edit Rating: <select name=“rating”>
						<option value=“G”>G</option>
						<option value=“PG”>PG</option>
						<option value=“PG13”>PG13</option>
						<option value=“R”>R</option>
						<option value=“NC17”>NC17</option>
				</select></td>
			</tr>
		</table>
		<input type="hidden" name="id" value="${film.id}" /> <input
			type="submit" value="Edit Film" />
	</form>
</body>
</html>