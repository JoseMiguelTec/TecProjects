<%@page import="es.tecdata.models.Pedido"%>
<%@page import="es.tecdata.models.Producto"%>
<%@page import="es.tecdata.models.Carrito"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrito</title>
</head>
<body>

	<%
	Carrito carrito = (Carrito) request.getAttribute("carrito");
	%>

	<table border="1" align="center">
		<tbody>
			<tr>
				<td>ID:</td>
				<td><%=carrito.getId()%></td>
			</tr>
			<tr>
				<td>USUARIO:</td>
				<td><%=carrito.getUsuario()%></td>
			</tr>
			<%
			for (Pedido pedido : carrito.getContenido()) {
			%>
			<tr>
				<form action="eliminar" method="post">
					<input type="hidden" name="id"
						value="<%=pedido.getProducto().getID()%>" />
					<td>Descripcion:</td>
					<td><%=pedido.getProducto().getDescripcion()%></td>
					<td><input type="submit" value="Eliminar del carrito" /></td>
				</form>

			</tr>
			<%
			}
			%>
			<tr>
				<td>IMPORTE:</td>
				<td><%=carrito.getImporte()%></td>
			</tr>
		</tbody>
	</table>

</body>
</html>