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
	if (request.getMethod().equals("POST") && request.getParameter("reservaBeans") != null) {
	%>
	<jsp:useBean id="reservaBean" scope="request" 
		class="org.iesalixar.servidor.models.Reserva">
		<jsp:setProperty name="reservaBeans" property="*" />
	</jsp:useBean>
	<%
	}
	%>
	<jsp:include page="barra.jsp"></jsp:include>
	<h1 style="color: blue">RESERVA CONFIRMADA</h1>
	<p>Fecha inicio: </p>
</body>
</html>