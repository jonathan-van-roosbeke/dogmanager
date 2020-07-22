<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous" />
<title>Liste chien</title>
</head>
<body>

	<div id="header" style="position: fixed;">
		<form action="" method="get">
			<button class="btn btn-success" type="submit">Ajouter un chien</button>
		</form>
	</div>

	<div class="container">
		<table class="table" id="myTable">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Race</th>
					<th scope="col">Nom</th>
					<th scope="col">Couleur</th>
					<th scope="col">Age</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${chiens}" var="chiens">
				<tr>
					<td>${chiens.idPuceChien}</td>
					<td>${chiens.idRace}</td>
					<td>${chiens.nomChien}</td>
					<td>${chiens.idCouleur}</td>
					<td>${chiens.ageChien}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>