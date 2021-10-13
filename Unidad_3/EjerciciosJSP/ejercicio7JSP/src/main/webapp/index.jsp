<!--   Realiza una aplicación que pinte una pirámide. La altura se pedirá en un  formulario. La pirámide estará hecha de bolitas, ladrillos o cualquier otra
  imagen. -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Introduzca la altura de la piramide:</p>
	<form method="post">
		<label for="h">Numero: </label> 
		<input id="h" type="number" name="h" />
		<br> <input type="submit" value="Enviar" />
	</form>
	<%
	if (request.getMethod().equals("POST")) {
		for(int altura = 1; altura<=Integer.parseInt(request.getParameter("h")); altura++){
            //Espacios en blanco
            for(int blancos = 1; blancos<=Integer.parseInt(request.getParameter("h"))-altura; blancos++){
                %>
					<img alt="" src="img/blanco.jpg">
                <%
            }
            //Piramide
            for(int asteriscos=1; asteriscos<=(altura*2)-1; asteriscos++){
            	%>
            		<img alt="" src="img/ladr.jpg">
            	<%
            }
            %>
        	<br>
        	<%
        }
	}
	%>
</body>
</html>