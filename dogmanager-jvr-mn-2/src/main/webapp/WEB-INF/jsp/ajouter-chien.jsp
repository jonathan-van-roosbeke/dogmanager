<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous" />
<title>Ajouter un chien</title>
</head>

<body>
	<div class="container">
		<h3>Ajouter un chien</h3>
		<form action="ajouter-chien" method="post">
			<p>
				numero-puce : <input class="form-control" name="numero-puce"
					value="numero-puce" type="number" pattern="[0-9]" min="1" max="99999"
					placeholder="numero-puce" required>
			</p>
			<label class="my-1 mr-2" for="inlineFormCustomSelectPref">Race</label>
			<select class="custom-select my-1 mr-sm-2" id="race" name="race">
				<c:forEach items="${races}" var="races">
					<option value="${races.idRace}">${races.nomRace}</option>
				</c:forEach>
			</select>
			<p>
				nom : <input class="form-control" name="nom-chien" value="Douggy"
					type="text" placeholder="nom-chien" pattern="[a-zA-Z]{1,20}" required>
			</p>

			<label class="my-1 mr-2" for="inlineFormCustomSelectPref">couleur</label>

			<select class="custom-select my-1 mr-sm-2" id="couleur"
				name="couleur">
				<c:forEach items="${couleurs}" var="couleurs">
					<option value="${couleurs.idCouleur}">${couleurs.couleur}</option>
				</c:forEach>
			</select>
			<p>
				age : <input class="form-control" name="age" value="age-chien"
					type="number" placeholder="age-chien" pattern="[0-9]{1,2}" min="0"
					max="30" required>
			</p>
			<button class="btn btn-success" type="submit">valider</button>
		</form>
		<span style="color: red;"><c:out value="${erreur}" /></br></span>
	</div>
</body>

</html>