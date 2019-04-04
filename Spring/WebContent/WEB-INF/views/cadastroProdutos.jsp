<%@ page language="java" contentType="text/html; charset=UTF-8"		pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
	
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Cadastro de Produtos em Spring</title>
	</head>
	<body bgcolor="#474747">
		<form method="post" action="/Spring/registerProductRedirection">
			<div>
				<label for="title">Título</label>
				<input type="text" name="title" id="title"></input>
			</div>
			<div>
				<label for="description">Descrição</label>
				<input type="text" name="description" id="description"></input>
			</div>
			<!-- <div>
				<label for="description">Valor</label>
				<input type="text" name="value" id="value"></input>
			</div> -->
			<div>
				<label for="pages">Número de páginas</label>
				<input type="text" name="pages" id="pages"></input>
			</div>
			<div>
				<input type="submit" value="Enviar"></input>
			</div>
			
			<c:forEach items="${listInsertedProducts}" var="book" varStatus="status">
				<div>
					<label for="title">Books</label>
					
					<input	type="text">${book.title} - ${book.description} - ${book.pages}</input>
				</div>
			</c:forEach>
		</form>
		<br>
		<br>
		<br>
		<table>
			<tr>
				<td>
					Book Title
				</td>
				<td>
					Description
				</td>
			</tr>
			<c:if test="${not empty listProducts}">
				<c:forEach items="${listProducts}" var="product">
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
			<c:if test="${empty listProducts}">
				<tr>
					<td>
						There is no Books to be listed
					</td>
					<td> - </td>
				</tr>
			</c:if>
			<!-- 
				<c:if test="${product == null || !product.hasAnyAttributeValid()}">
					<tr>
						<td>
							The Product is Null or has no Valid Attributes
						</td>
						<td> - </td>
					</tr>
				</c:if>
				<c:if test="${product != null && product.hasAnyAttributeValid()}">
					<tr>
						<td>
							The Product is Not Null
							<br>
							${product.title}
						</td>
						<td>${product.description}</td>
					</tr>
				</c:if>
			-->
		</table>
		<f:view>
		</f:view>
	</body>
</html>