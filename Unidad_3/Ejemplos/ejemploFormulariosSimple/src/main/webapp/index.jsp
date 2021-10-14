<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="<%= request.getContextPath() %>/Formularios">
		
		<p>
			<label for="simple">Introduce un nombre: </label> 
			<input id="simple" type="texto" name="simple"/><br> 
		</p>
		<p>
			<p>Selecciona varias opciones</p>
			<p><label for="checkbox">Campo de formulario checkbox</label></p>
			<input type="checkbox" value="A" name="checkbox">Opcion A<br>
			<input type="checkbox" value="B" name="checkbox">Opcion B<br>
			<input type="checkbox" value="C" name="checkbox">Opcion C<br>
			<input type="checkbox" value="D" name="checkbox">Opcion D<br>
			<input type="checkbox" value="E" name="checkbox">Opcion E<br>
		</p>
		<p>
			<select name="select" multiple>
				<option>Seleccion A</option>
				<option>Seleccion B</option>
				<option>Seleccion C</option>
				<option>Seleccion D</option>
				<option>Seleccion E</option>
			</select>
		</p>
		
		<input type="submit" value="Enviar"/>
	</form>
</body>
</html>