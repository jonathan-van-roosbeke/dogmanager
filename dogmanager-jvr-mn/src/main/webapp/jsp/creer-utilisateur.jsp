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
    <title>Creation de compte</title>
</head>

<body>
    <div class="container">
        <h3>Creation de compte</h3>
        <form action="inscription" method="post">
        
            <p>nom : <input class="form-control" name="nom" type="text" placeholder="nom" pattern="[a-zA-Z]{3,}" required></p>
            <p>prenom : <input class="form-control" name="prenom"  type="text" placeholder="prenom" pattern="[a-zA-Z]{3,}" required></p>
            <p>pseudo : <input class="form-control" name="login" type="text" placeholder="pseudo" pattern="[0-9a-zA-Z]{4,}"  required></p>
            <p>password : <input class="form-control" name="password" type="password" pattern=".{6,}" required></p>
    	<span style="color: red;"><c:out value="${erreur}"/></br></span>
            <button class="btn btn-success" type="submit">valider</button>
           <button class="btn btn-danger" type="submit">reset</button>
           
        </form>
    </div>
</body>

</html>