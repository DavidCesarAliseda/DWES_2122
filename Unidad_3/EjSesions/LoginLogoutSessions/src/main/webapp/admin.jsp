<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="barra.jsp" />
	<jsp:useBean id="usuariobean" class="org.iesalixar.servidor.model.Usuario" scope="request" />
	<h1>ZONA DE ADMIN</h1>
	<h2>Usuario pasado como BEAN</h2>
	<%=usuariobean.getNombre()%>
</body>
</html>