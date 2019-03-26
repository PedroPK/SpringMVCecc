<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
	
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Cadastro de Produtos em Spring</title>
	</head>
	<body bgcolor="#474747">
		<form method="post" action="/Spring/registerProduct">
			<div>
				<label for="title">Título</label>
				<input type="title" name="title" id="title"> </input>
			</div>
			<div>
				<label for="description">Descrição</label>
				<input type="text" name="description" id="description"></input>
			</div>
			
			<c:forEach items="${types}" var="bookType" varStatus="status">
				<div>
					<label for="price_${bookType}">${bookType}</label>
					
					<input	type="text" 
							name="prices[${status.index}].value"
							id="price_${bookType}">						</input>
					
					<input	type="hidden"
							name="prices[${status.index}].bookType"
							value="${bookType}">						</input>
				</div>
			</c:forEach>
			
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
		</form>
		<f:view>
		</f:view>
	</body>
</html>