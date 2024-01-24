<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Producto</title>
</head>
<body>
	<h2>Producto encontrado</h2>
	<jsp:useBean id="encontrado" class="es.tecdata.models.Producto"
		scope="request" />
	<ul>
		<li>ID: <jsp:getProperty property="ID" name="encontrado" /></li>
		<li>Descripcion: <jsp:getProperty property="descripcion"
				name="encontrado" /></li>
		<li>Precio: <jsp:getProperty property="precio" name="encontrado" /></li>
	</ul>
</body>
</html>