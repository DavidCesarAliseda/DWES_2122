<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> El nombre introducido es <%= request.getAttribute("simple") %></h1>
	<h1> El checkbox introducido es <%= request.getAttribute("checkbox") %></h1>
	<h1> El select introducido es <%= request.getAttribute("select") %></h1>
</body>
</html>