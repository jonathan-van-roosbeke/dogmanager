<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Editer un chien</title>
</head>

<body>
	<div class="container">
		<h3>Editer un chien</h3>
		<form action="EditionChien" method="post">
			<p>
				numero-puce : <input class="form-control" id="puce-chien"
					name="numero-puce" value="${chien.idPuceChien}" type="number"
					placeholder="numero-puce" pattern="[0-9]+" min="1"
					placeholder="numero-puce">
			</p>
			<label class="my-1 mr-2" for="inlineFormCustomSelectPref">Race</label>
			<select class="custom-select my-1 mr-sm-2" id="race" name="race">
				<c:forEach items="${races}" var="races">
					<option value="${races.idRace}">${races.nomRace}</option>
				</c:forEach>
			</select>
			<p>
				nom : <input class="form-control" id="nom-chien" name="nom-chien"
					value="${chien.nomChien}" type="text" pattern="[a-zA-Z]+" required />
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
					type="number" placeholder="age-chien" pattern="[0-9]+" min="0"
					max="30" required>
			</p>

			<button class="btn btn-success" type="submit">valider</button>
			<input type="button" class="btn btn-secondary" name="reset"
				value="Reset" id="reset123" onclick="customReset();" /> <input
				type="button" class="btn btn-danger" name="Delete" value="Delete"
				id="delete123" onclick="customDelete(${chien.idPuceChien});" />
		</form>
		<span style="color: red;"><c:out value="${erreur}" /></br></span>
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
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="js/reset.js"></script>

</body>
</html>