<%@ page language="java" contentType="text/html; charset=UTF-8"		pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	<title>Products List page</title>
	</head>
	<body>
		<table>
			<tr>
				<td>
					Book Title
				</td>
				<td>
					Description
				</td>
			</tr>
			<c:if test="${not empty listInsertedProducts}">
				<c:forEach items="${listInsertedProducts}" var="product">
					<tr>
						<td>
							${product.title}
						</td>
						<td>
							${product.description}
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty listInsertedProducts}">
				<tr>
					<td>
						There is no Books to be listed
					</td>
					<td> - </td>
				</tr>
			</c:if>
			<c:if test="${product == null}">
				<tr>
					<td>
						The Product is Null
					</td>
					<td> - </td>
				</tr>
			</c:if>
			<c:if test="${product != null}">
				<tr>
					<td>
						The Product is Not Null
						<br>
						${product.title}
					</td>
					<td>${product.description}</td>
				</tr>
			</c:if>
		</table>
	</body>
</html>