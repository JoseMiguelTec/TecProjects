<%@page import="es.tecdata.models.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Curso Spring Avanzado</title>

</head>

<body>
	<h1>Nuestro catalogo de productos</h1>

	<%
	List<Producto> lista = (List<Producto>) request.getAttribute("lista");
	%>

	<table border="1" align="center">
		<tr>
			<th>ID</th>
			<th>DESCRIPCION</th>
			<th>PRECIO</th>
			<th>CANTIDAD</th>
			<th>COMPRAR</th>
		</tr>
		<%
		for (Producto producto : lista) {
		%>
		<tr>
			<td><%=producto.getID()%></td>
			<td><%=producto.getDescripcion()%></td>
			<td><%=producto.getPrecio()%></td>

			<form action="comprar" method="post">
				<input type="hidden" name="id" value="<%=producto.getID()%>" />
				<td><input type="number" name="cantidad" /></td>
				<td><input type="submit" value="Agregar al carrito" /></td>
			</form>
		</tr>
		<%
		}
		%>

	</table>

</body>

</html>