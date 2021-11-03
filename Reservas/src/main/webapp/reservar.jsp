<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="barra.jsp"></jsp:include>
	<h1 style="color: blue;">DATOS DE LA RESERVA</h1>
	<form method="post">
		<label for="fechaInicio">Fecha de Inicio: </label> <input
			name="fechaInicio" id="fechaInicio" type="date" required></input><br>
		<br> <label for="fechaFin">Fecha de fin: </label> <input
			name="fechaFin" id="fechaFin" type="date" required></input><br>
		<br> <label for="personas">Numero de personas: </label> <input
			name="personas" id="personas" type="number" required></input><br>
		<br>

		<h3 style="color: blue;">Servicios</h3>
		<p>
			<label for="checkbox"></label><br> <input type="checkbox"
				name="checkbox" value="Wifi">Wifi</input> <input type="checkbox"
				name="checkbox" value="Toallas">Toallas</input><br> <input
				type="checkbox" name="checkbox" value="Desayuno">Desayuno</input> <input
				type="checkbox" name="checkbox" value="Limpieza">Limpieza</input><br>
			<input type="checkbox" name="checkbox" value="Ruta guiada">Ruta
			guiada</input> <input type="checkbox" name="checkbox" value="Sauna">Sauna</input>

		</p>

		<input type="submit" value="Reservar" name="Reservar"></input>
	</form>
</body>
</html>