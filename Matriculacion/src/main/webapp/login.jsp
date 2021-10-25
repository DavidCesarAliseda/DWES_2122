<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	if (session.isNew()) {
	%>
	<form method="post">
		<input type="submit" value="Entrar" name="boton"/>
	</form>

	<%
	} else {
	%>
	<a href="Logout"><input type="submit" value="Salir" name="boton"/></a>

	<%
	}
	%>

</body>
</html>