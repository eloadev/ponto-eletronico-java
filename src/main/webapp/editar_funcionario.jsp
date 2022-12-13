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
	<h1>Editar funcionário</h1>
	
	<form action="EditarFuncionarioServlet" method="get">
		<label for="id">id: </label>
			<input type="text" name="id" id="id" value="${funcionario.id}" readonly="readonly"><br>
		<label for="nome">nome: </label>
			<input type="text" name="nome" id="nome" value="${funcionario.nome}"><br>
		<label for="cpf">cpf: </label>
			<input type="text" name="cpf" id="cpf" value="${funcionario.cpf}"><br>
		<label for="email">email: </label>
			<input type="email" name="email" id="email" value="${funcionario.email}"><br>
		<label for="senha">senha: </label>
			<input type="text" name="senha" id="senha" value="${funcionario.senha}"><br>
		<label for="departamento">departamento:</label>
			<select name="departamento" id="departamento">
				<c:forEach var="departamento" items="${departamentos}">
					<option value="${departamento.id}" <c:if test="${funcionario.departamento.id == departamento.id}">selected</c:if>>
						${departamento.nome}
					</option>
				</c:forEach>
			</select><br>
			<input type="submit" value="Editar">
	</form>
</body>
</html>