<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>trile</title>
</head>
<body>
	<%
	
	      int bolita = (int)(Math.random() * 3);
	      int cubilete = Integer.parseInt(request.getParameter("cubilete"));
	      String imagen[] = {"img/cubilete_sin_bola.png", "img/cubilete_sin_bola.png", "img/cubilete_sin_bola.png"};
	      imagen[bolita] = "img/cubilete_con_1bola.png";
	      
	      String mensaje;
	      if (bolita == cubilete) {
	        mensaje = "¡Enhorabuena! ¡Has acertado!";
	      } else {
	        mensaje = "Lo siento, has perdido.";
	      }
	    %>
	    <table>
	      <tr>
	        <td><img src="<%= imagen[0] %>"></td>
	        <td><img src="<%= imagen[1] %>"></td>
	        <td><img src="<%= imagen[2] %>"></td>
	      </tr>
	    </table>
	      <p><%= mensaje %></p>
	      <p><a href="index.jsp"><button>Volver a jugar</button></a></p>
	
</body>
</html>