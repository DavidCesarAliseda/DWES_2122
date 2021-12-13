<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/bootstrap.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<div class="container">

	<div class="col-12 text-end">
		<p class="bg-primary text-white p-2">
			<a class="text-white" href="${pageContext.request.contextPath}/Home">Inicio</a>
			<a class="text-white" href="${pageContext.request.contextPath}/Admin/Empleados">Mostrar Empleados</a>
			<a class="text-white" href="${pageContext.request.contextPath}/Admin/AddEmpleado">Añadir Empleado</a>
			<span>Zona de administracion</span> <a class="text-white"
				href="${pageContext.request.contextPath}/LogOut">Salir</a>
		</p>
	</div>
	<div class="row justify-content-end">
		<div class="col-2">
			<a class="btn btn-primary w-100" href="${pageContext.request.contextPath}/Admin/AddEmpleado">AÑADIR EMPLEADO</a>
		</div>
	</div>
	<div class="row justify-content-center">

		<div class="col-10">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>employeeNumber</th>
						<th>lastName</th>
						<th>firstName</th>
						<th>extension</th>
						<th>email</th>
						<th>officeCode</th>
						<th>reportsTo</th>
						<th>jobTitle</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${empleados}" var="empleado">
						<tr>
							<td>${empleado.employeeNumber}</td>
							<td>${empleado.lastName}</td>
							<td>${empleado.firstName}</td>
							<td>${empleado.extension}</td>
							<td>${empleado.email}</td>
							<td>${empleado.officeCode}</td>
							<td>${empleado.reportsTo}</td>
							<td>${empleado.jobTitle}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>