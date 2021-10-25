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

		<p>
			<label for="nombre">Introduce un nombre: </label> <input id="nombre"
				type="texto" name="nombre" required /><br>
		</p>
		<p>
			<label for="apellido">Introduce un apellido: </label> <input
				id="apellido" type="texto" name="apellido" required /><br>
		</p>
		<p>
			<label for="email">Introduce un mail: </label> <input id="email"
				type="email" name="email" required /><br>
		</p>
		<p>
		<p>Selecciona una opcion</p>
		<input type="radio" name="curso" id="curso"/> 
		<label for="curso" value="primero" required>Primero</label>
		<input type="radio" name="curso" id="curso"/> 
		<label for="curso" value="segundo" >Segundo</label><br />

		</p>
		<p>
			<p>Modulos</p>
			<select name="select" multiple required>
				<option>Seleccion A</option>
				<option>Seleccion B</option>
				<option>Seleccion C</option>
				<option>Seleccion D</option>
				<option>Seleccion E</option>
			</select>
		</p>

		<input type="submit" value="Enviar" />
	</form>
</body>
</html>