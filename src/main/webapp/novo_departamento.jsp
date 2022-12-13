<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	<h1>Registrar novo departamento</h1>
		<form action="/pontoeletronico/AdicionarDepartamentoServlet" method="post">
			<label for="nome">Nome: </label>
				<input type="text" name="nome"><br>
			<input type="submit" value="Registrar">
			
			<a href="ListarFuncionarioServlet">Voltar</a>
		</form>
</body>
</html>