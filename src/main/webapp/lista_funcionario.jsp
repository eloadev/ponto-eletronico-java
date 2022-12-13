<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link rel="stylesheet" href="assets/css/style.css">
<meta http-equiv="content-Type" content="text/html charset=ISO-8859-1">
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
	<h1>Lista de funcionários</h1>
	
	<p>id da session: ${cookieSession}</p>
		
	<a href="/pontoeletronico/ListarDepartamentoServlet?nextPage=novo_funcionario.jsp">Novo Funcionário</a>
	<a href="novo_departamento.jsp">Novo Departamento</a>

	<table border=1>
		<tr>
			<th>Nome</th>
			<th>Cpf</th>
			<th>Email</th>
			<th>Senha</th>
			<th>Departamento</th>
		</tr>
		
		<c:forEach var="funcionario" items="${funcionarios}">
			<tr>
				<td>${funcionario.nome}</td>
				<td>${funcionario.cpf}</td>
				<td>${funcionario.email}</td>
				<td>${funcionario.senha}</td>
				<td>${funcionario.departamento.nome}</td>
				<td><a href="/pontoeletronico/MostrarFormularioEdicaoServlet?id=${funcionario.id}">Editar</a></td>
				<td><a href="/pontoeletronico/ExcluirFuncionarioServlet?id=${funcionario.id}">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
	
	${mensagem_editar}
	${mensagem_excluir}
</body>
</html>