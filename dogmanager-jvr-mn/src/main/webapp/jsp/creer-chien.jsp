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
    <title>Ajouter un chien</title>
</head>

<body>
    <div class="container">
        <h3>Ajouter un chien</h3>
        <form action="EditChienServlet" method="post">
            <p>numero-puce : <input class="form-control" name="numero-puce" value="numero-puce" type="text" placeholder="numero-puce"></p>
            <p>race : <input class="form-control" name="race" value="race" type="text" placeholder="race" pattern="[a-zA-Z]+" required></p>
            <p>nom : <input class="form-control" name="race" value="nom-chien" type="text" placeholder="nom-chien" pattern="[a-zA-Z]+" required></p>
            <p>couleur : <input class="form-control" name="couleur" value="couleur-chien" type="text" placeholder="couleur-chien" pattern="[a-zA-Z]+" required></p>
            <p>age : <input class="form-control" name="age" value="age-chien" type="number" placeholder="age-chien" pattern="[0-9]+" required></p>
           <button class="btn btn-success" type="submit">valider</button>
           <button class="btn btn-danger" type="submit">reset</button>
        </form>
    </div>
</body>

</html>