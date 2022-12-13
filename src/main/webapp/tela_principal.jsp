<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="assets/css/style.css">
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

	<h3>Bem-vindo(a) ${funcionario.nome}</h3>
	
	<p>id da session: ${cookieSession}</p>
	
	<a href="/pontoeletronico/AdicionarPontoServlet?id=${funcionario.id}">Bater ponto</a>
	
	<table border=1>
		<tr>
			<th>id</th>
			<th>data</th>
			<th>hora</th>
		</tr>
		<c:forEach var="ponto" items="${pontos}">
			<tr>
				<td>${ponto.id}</td>
				<td>${ponto.data}</td>
				<td>${ponto.hora}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>