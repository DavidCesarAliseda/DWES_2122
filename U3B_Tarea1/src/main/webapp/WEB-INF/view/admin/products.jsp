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
	<jsp:include page="../include/barra.jsp" />
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
								<td><a href="UpdateProduct?pc=${producto.productCode}"><i class="bi bi-eye"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>