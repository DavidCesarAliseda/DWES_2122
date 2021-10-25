<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<label for="n1">Numero 1: </label> 
		<input id="n1" type="number" name="n1"/><br> 
		<label for="n2">Numero 2: </label> 
		<input id="n2" type="number" name="n2"/><br> 
		<label for="n3">Numero 3: </label> 
		<input id="n3" type="number" name="n3"/><br> 
		
		<input type="submit" value="Enviar"/>
		
	</form>
	
	<%
	if(request.getMethod().equals("POST")){
		int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));
		int n3 = Integer.parseInt(request.getParameter("n3"));
		double media = (n1+n2+n3)/3;
		%>
		<h1>La nota media es: <%= media %></h1>
		<%
	}
	%>
	

</body>
</html>