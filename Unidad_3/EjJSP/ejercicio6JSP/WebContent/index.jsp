<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabla multiplicar</title>
</head>
<body>

	<p>Introduzca un numero para obtener la tabla de multiplicar:</p>
	<form method="post">
		<label for="n">Numero: </label> 
		<input id="n" type="number" name="n" />
		<br> <input type="submit" value="Enviar" />
	</form>


	<%
	if (request.getMethod().equals("POST")) {
	%>
	<table>
		<tbody>
			<%
			for (int i = 1; i <= 10; i++) {
				int v = i * Integer.parseInt(request.getParameter("n"));
			%>
			<tr>
				<td><%=request.getParameter("n")%> x <%=i%> = <%=v%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<%
	}
	%>

</body>
</html>