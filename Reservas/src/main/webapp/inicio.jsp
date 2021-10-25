<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(session.isNew()){ %>
	<h1 style="color:blue;">CENTRAL DE VIAJES</h1>
	<form method="post">
		<label for="user" >Usuario: </label>
		<input name="user" id="user" type="text" required></input><br>
		
		<label for="password" >Password: </label>
		<input name="password" id="password" type="password" required></input><br>
		
		<label for="confirmpass" >Confirmar password: </label>
		<input name="confirmpass" id="confirmpass" type="password" required></input><br>
		
		<label for="email" >E-mail: </label>
		<input name="email" id="email" type=email required></input><br><br>
		
		<input type="submit" value="Registrar" name="SingIn"></input>
	</form>
	<%}else{ %>
		<jsp:include page="barra.jsp"></jsp:include>
		<img alt="" src="img/cubilete.png"></img>
	<%} %>
</body>
</html>