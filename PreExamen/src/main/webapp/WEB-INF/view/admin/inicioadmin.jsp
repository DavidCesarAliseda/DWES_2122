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
<body>

	<div class="container">

		<div class="col-12 text-end">
			<p class="bg-primary text-white p-2">
				<a class="text-white" href="${pageContext.request.contextPath}/Admin/Inicio">Inicio</a>
				<c:out
					value="Esta usted logeado como: ${sessionScope.nombre} ${sessionScope.apellido} " />
				<a class="text-white"
					href="${pageContext.request.contextPath}/LogOut">Salir</a>
			</p>
		</div>

		<div class="row justify-content-center">

			<div class="col-10">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>productName</th>
							<th>productCode</th>
							<th>productLine</th>
							<th>quantityInStock</th>
							<th>buyPrice</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${productos}" var="producto">
							<tr>
								<td>${producto.productName}</td>
								<td>${producto.productCode}</td>
								<td>${producto.productLine}</td>
								<td>${producto.quantityInStock}</td>
								<td>${producto.buyPrice}</td>
								<td><a href="EditarProduct?pc=${producto.productCode}"><i
										class="bi bi-eye"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>