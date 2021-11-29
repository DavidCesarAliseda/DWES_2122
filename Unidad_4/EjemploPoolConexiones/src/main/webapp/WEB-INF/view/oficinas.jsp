<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="./include/bootstrap.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">

			<div class="col-10">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>officeCode</th>
							<th>city</th>
							<th>phone</th>
							<th>addressLine1</th>
							<th>postalCode</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${oficinas}" var="oficina">
							<tr>
								<td>${oficina.officeCode}</td>
								<td>${oficina.city}</td>
								<td>${oficina.phone}</td>
								<td>${oficina.addressLine1}</td>
								<td>${oficina.territory}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>