<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous" />
<link rel="stylesheet" href="css/style.css">
<title>Liste chien</title>
</head>
<body>
	<div class="container">
		<table class="table table-hover" id="myTable">
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
				<c:forEach items="${chiens}" var="chien">
					<tr class="hand" data-href='#'>
						<td class="user-select-none id-chien">${chien.idPuceChien}</td>
						<td><c:out value="${chien.race.nomRace}" /></td>
						<td><c:out value="${chien.nomChien}" /></td>
						<td><c:out value="${chien.couleur.couleur}" /></td>
						<td><c:out value="${chien.ageChien}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="container">
			<div class="row">

				<div class="col-10">
					<nav aria-label="Page navigation example">
						<ul class="pagination">

							<c:set var="count" value="0" scope="page" />
							<c:if test="${ idPage gt 1}">
								<li class="page-item"><a class="page-link"
									href="liste-utilisateur?page=${idPage - 1}">Precedent</a></li>
							</c:if>
							<c:forEach begin="1" end="${nombrePage}" var="page">
								<c:set var="count" value="${count + 1}" scope="page" />
								<li class="page-item"><a class="page-link"
									href="liste-utilisateur?page=${count}">${count}</a></li>
							</c:forEach>

							<c:if test="${ idPage lt nombrePage}">
								<li class="page-item"><a class="page-link"
									href="liste-utilisateur?page=${idPage + 1}">Suivant</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
				<div class="col-2">

					<form action="ajouter-chien">
						<button class="btn btn-success" type="submit">Ajouter un
							chien</button>
					</form>
				</div>
			</div>
		</div>



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

	<script src="js/select.js"></script>
</body>
</html>