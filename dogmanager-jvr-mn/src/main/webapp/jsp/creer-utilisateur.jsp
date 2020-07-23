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
            <p>nom : <input class="form-control" name="nom" type="text" placeholder="nom" pattern="[a-zA-Z]+" required></p>
            <p>prenom : <input class="form-control" name="prenom"  type="text" placeholder="prenom" pattern="[a-zA-Z]+" required></p>
            <p>pseudo : <input class="form-control" name="login" type="text" placeholder="pseudo" pattern="[a-zA-Z]+" required></p>
            <p>password : <input class="form-control" name="password" type="password" required></p>
            <button class="btn btn-success" type="submit">valider</button>
           <button class="btn btn-danger" type="submit">reset</button>
        </form>
    </div>
</body>

</html>