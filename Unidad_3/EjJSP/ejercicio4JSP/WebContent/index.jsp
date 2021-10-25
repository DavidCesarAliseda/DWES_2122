<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<label for="euro">Euro: </label> 
		<input id="euro" type="number" step="any" name="euro"/><br> 
		
		<label for="dollar">Dollar: </label> 
		<input id="dollar" type="number" step="any" name="dollar"/><br> 
		
		<input type="submit" value="Enviar"/>
	</form>
	
	<%
	if(request.getMethod().equals("POST")){
		double valor = 1.16;
				
		if(request.getParameter("euro").length()==0){
			double e = Double.parseDouble(request.getParameter("dollar"))/valor;
			%>
			 <h1><%= request.getParameter("dollar") %> dolares en euros es: <%= e %></h1>
			<%
		}else{
			double d = Double.parseDouble(request.getParameter("euro"))*valor;
			%>
			 <h1><%= request.getParameter("euro") %> euros en dolares es: <%= d %></h1>
			<%
		}
		%>
		 
		<%
	}
	%>
</body>
