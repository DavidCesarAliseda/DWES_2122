<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conversor euro a dolar</title>
</head>
<body>
	<form method="post">
		<label for="euro">Euro: </label> 
		<input id="euro" type="number" name="euro"/><br> 
		
		<input type="submit" value="Enviar"/>
	</form>
	
	<%
	if(request.getMethod().equals("POST")){
		double valor = 1.16;
		double dolar = Integer.parseInt(request.getParameter("euro"))*valor;
		%>
		 <h1><%= request.getParameter("euro") %> euros en dolares es: <%= dolar %></h1>
		<%
	}
	%>
	
</body>
</html>