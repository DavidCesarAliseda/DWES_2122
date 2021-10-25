<!--   Realiza un configurador del interior de un vehículo. El usuario puede  elegir, mediante un formulario, el color de la tapicería  blanco, negro
      o berenjena y el material de las molduras  madera o carbono. Se debe  mostrar el interior del coche tal y como lo quiere el usuario. -->

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
		Tapicería: <select name="tapiceria">
			<option value="negro" selected="selected">Cuero negro</option>
			<option value="berenjena">Color berenjena</option>
			<option value="blanco">Blanco marfil</option>
		</select> <br> <br> Tipo de moldura interior: <select name="moldura">
			<option value="carbono" selected="selected">Fibra de carbono</option>
			<option value="madera">Madera de nogal</option>
		</select> <br> <br> <input type="submit" value="Aceptar">
	</form>
	
	<%
	if (request.getMethod().equals("POST")) {
		out.print("Aqui tiene su coche: ");
		%><h1>Aquí tiene su coche.</h1><%
		String tapiceria = request.getParameter("tapiceria");
	    String moldura = request.getParameter("moldura");
	    String imagen = "img/"+tapiceria + moldura + ".jpg";
	    %><img src="<%= imagen %>"><%
	}
	
	%>
	
</body>
</html>