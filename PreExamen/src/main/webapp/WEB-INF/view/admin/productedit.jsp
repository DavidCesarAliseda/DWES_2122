<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/bootstrap.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-5">

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
			<div class="col-6 mt-5">
				<form method="post">
					<label for="productCode" class="form-label">productCode</label> 
					<input name="productCode" value="${producto.productCode}" type="text" class="form-control" id="productCode" readonly> 
					
					<label for="productName" class="form-label">productName</label>
					<input name="productName" value="${producto.productName}" type="text" class="form-control" id="productCode" required> 
					
					<label for="productLine" class="form-label">productLine</label> 
					
					<select class="form-select" id="customerNumber" name="customerNumber">
						<c:forEach  items="${productLines}" var="pl">
							<c:choose>
								<c:when test="${pl.productLine ==producto.productLine}">
									<option value="${producto.productLine}" selected>${producto.productLine}</option>
								</c:when>
								<c:otherwise>
									<option value="${pl.productLine}">${pl.productLine}</option>
								</c:otherwise>
							</c:choose>							
						</c:forEach>					
					</select>
					
					<label for="quantityInStock" class="form-label">quantityInStock</label> 
					<input name="quantityInStock" value="${producto.quantityInStock}" type="text" class="form-control" id="quantityInStock"> 
						
					<label for="buyPrice" class="form-label">buyPrice</label> 
					<input name="buyPrice" value="${producto.buyPrice}" type="text" class="form-control" id="buyPrice"> 
						
					<input type="submit" value="Actualizar" class="btn btn-primary w-100 mt-5">
			
				</form>
			</div>
		</div>
	</div>
</body>
</html>