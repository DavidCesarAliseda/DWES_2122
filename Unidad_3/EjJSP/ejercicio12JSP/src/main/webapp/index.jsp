<!-- Realiza una aplicaci�n que muestre la tirada aleatoria de tres dados de  p�ker. Utiliza im�genes de dados reales. -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Esta aplicaci�n muestra la tirada aleatoria de tres dados de p�ker.</h1>
	<p>
        <%
          String[] cara = {"as.jpg", "j.jpg", "q.jpg", "k.jpg", "rojo.jpg", "negro.jpg"};
          for (int i = 0; i < 3; i++) {
            out.print("<img src=\"img/" + cara[(int)(Math.random()*6)] +"\">");
          }
        %>
      </p>

</body>
</html>