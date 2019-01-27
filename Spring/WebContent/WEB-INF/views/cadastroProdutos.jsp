<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html" version="2.0">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<jsp:text>
		<![CDATA[ <?xml version="1.0" encoding="UTF-8" ?> ]]>
	</jsp:text>
	<jsp:text>
		<![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
	</jsp:text>
	<html xmlns="http://www.w3.org/1999/xhtml">
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
			<title>Cadastro de Produtos em Spring</title>
		</head>
		<body>
			<form method="post" action="/Spring/produtos">
				<div>
					<label for="title">
						Título
					</label>
					<input type="title" name="title" id="title"> </input>
				</div>
				<div>
					<label for="description">Descrição</label>
					<textarea rows="10" cols="20" name="description" id="description"></textarea>
				</div>
				<div>
					<label for="pages">Número de páginas</label>
					<input type="text" name="pages" id="pages"></input>
				</div>
				<div>
					<input type="submit" value="Enviar">
				</div>
			</form>
			<f:view>
			</f:view>
		</body>
	</html>
</jsp:root>