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
	<h1>Registrar novo funcionário</h1>
		<form action="/pontoeletronico/AdicionarFuncionarioServlet" method="post">
			<label for="nome">Nome: </label>
				<input type="text" name="nome"><br>
			<label for="cpf">CPF: </label>
				<input type="text" name="cpf"><br>
			<label for="email">E-mail: </label>
				<input type="email" name="email"><br>
			<label for="senha">Senha: </label>
				<input type="text" name="senha"><br>
			<label for="departamento_id">Departamento:</label>
				<select name="departamento_id">
					<c:forEach var="departamento" items="${departamentos}">
						<option value="${departamento.id}">
							${departamento.nome}
						</option>
					</c:forEach>
				</select><br>
			<input type="submit" value="Registrar">
			
			<a href="ListarFuncionarioServlet">Voltar</a>
		</form>
</body>
</html>