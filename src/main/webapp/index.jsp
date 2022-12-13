<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="assets/css/style.css">
<title>Ponto Eletrônico</title>

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

</head>

<body>
	<a href="login_administrador.jsp">Login como administrador</a>
	<br>
	<a href="login_funcionario.jsp">Login como funcionário</a>
	<br><br>
	<form action="/pontoeletronico/CookieServlet" method="get">
		<label for="cor_fundo">Escolha a cor de fundo:</label>
		<select name="cor_fundo" id="cor_fundo">
			<option value="red">Vermelho</option>
			<option value="orange">Laranja</option>
			<option value="yellow">Amarelo</option>
			<option value="green">Verde</option>
			<option value="blue">Azul</option>
			<option value="white">Branco</option>
			<option value="black">Preto</option>
		</select>
		<label for="cor_fonte">Escolha a cor da fonte:</label>
		<select name="cor_fonte" id="cor_fonte">
			<option value="red">Vermelho</option>
			<option value="orange">Laranja</option>
			<option value="yellow">Amarelo</option>
			<option value="green">Verde</option>
			<option value="blue">Azul</option>
			<option value="white">Branco</option>
			<option value="black">Preto</option>
		</select>
		<input type="submit" value="Trocar cor">
	</form>
	
	<% Cookie cookies[] = request.getCookies();
	String cor_fundo = null;
	String cor_fonte = null;

	if ( cookies != null ){
		for ( Cookie c : cookies ) {
			if (c.getName().equals("cor_fundo")){
				cor_fundo = c.getValue();
			}
			if (c.getName().equals("cor_fonte")){
				cor_fonte = c.getValue();
			}
		}
	}
	%>
</body>
</html>