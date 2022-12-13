<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="assets/css/style.css">
<meta charset="UTF-8">
<title>Ponto Eletrônico</title>
</head>

<style>
	body{
		background-color: ${cor_fundo};
		color: ${cor_fonte};
	}
	a{
		color: ${cor_fonte};
	}
	a:hover{
		color: purple;
	}
</style>

<body>
	<h1>Login funcionário</h1>
	
	<form action="/pontoeletronico/LoginFuncionarioServlet" method="post">
		<label for="email">E-mail: </label><input type="email" name="email"><br/>
		<label for="senha">Senha: </label><input type="password" name="senha"><br/><br/>
		<input type="submit" value="Login">
	</form>
	<br>
	<p> ${erro} </p>
</body>
</html>