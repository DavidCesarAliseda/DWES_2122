<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Búsqueda de Productos</title>
<jsp:include page="include/bootstrap.jsp" />
</head>
<body>
	<div class="container">
		<jsp:include page="include/barra.jsp" />
		
		<div class="row justify-content-center">
			<div class="col-6 mt-5">
				<form method="post">
					<label for="office" class="form-label">Oficina</label> 
					<select class="form-select" id="office" name="office">
						<c:forEach  items="${oficinas}" var="o">
							<option value="${o.city}">${o.city}</option>
						</c:forEach>					
					</select>
					<input type="submit" value="Obtener Datos" class="btn btn-primary w-100 mt-5">
				</form>
			</div>
		</div>
		
		<div class="row justify-content-center">
			<div class="col-8">
			<p></p>
			<p>Datos de la oficina de ${ofi.city}</p>
			<p>Code: ${ofi.officeCode}</p>
			<p>Ciudad: ${ofi.city}</p>
			<p>Teléfono: ${ofi.phone}</p>
			<p>${ofi.addressLine1}</p>
			<p>${ofi.addressLine2}</p>
			<p>${ofi.state}</p>
			<p>${ofi.country}</p>
			<p>${ofi.postalCode}</p>
			<p>${ofi.territory}</p>
			</div>
		</div>
		
	</div>
</body>
</html>