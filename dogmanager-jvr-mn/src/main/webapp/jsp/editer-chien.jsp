<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link
    rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
    integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
    crossorigin="anonymous"
  />
    <title>Editer un chien</title>
</head>

<body>
    <div class="container">
        <h3>Editer un chien</h3>
        <form action="EditionChien" method="post">
            
            <p>numero-puce : <input class="form-control" name="numero-puce" value="numero-puce" type="text" placeholder="numero-puce"></p>
			  <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Race</label>
			      <select class="custom-select my-1 mr-sm-2" id="race" name ="race">
			    	<c:forEach items="${races}" var="races">
			        <option value="${races.idRace}">${races.nomRace}</option>
			    	</c:forEach>
			  	</select>
            <p>nom : <input class="form-control" name="nom-chien" value="nom-chien" type="text" placeholder="nom-chien" pattern="[a-zA-Z]+" required></p>
            
            <label class="my-1 mr-2" for="inlineFormCustomSelectPref">couleur</label>
			  
			  <select class="custom-select my-1 mr-sm-2" id="couleur" name ="couleur">
			    <c:forEach items="${couleurs}" var="couleurs">
			        <option value="${couleurs.idCouleur}">${couleurs.couleur}</option>
			    </c:forEach>
			</select>
            <p>age : <input class="form-control" name="age" value="age-chien" type="number" placeholder="age-chien" pattern="[0-9]+" required></p>
           <button class="btn btn-success" type="submit">valider</button>
           <button class="btn btn-danger" type="submit">reset</button>
        </form>
    </div>
</body>
</html>