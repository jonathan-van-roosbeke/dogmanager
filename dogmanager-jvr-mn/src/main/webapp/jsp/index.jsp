<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8" />
<title>Document</title>
</head>
<body>

	<form action="login" method="post">
		<label for="inputName">Username</label>
		<input class="form-control" name="login" type="text"  required>
		<label for="inputName">Password</label>
		<input class="form-control" name="password" type="password" required>
		<input type="submit" value="Login">
	</form>

</body>
</html>
