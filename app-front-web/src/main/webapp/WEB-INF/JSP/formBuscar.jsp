<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario buscar</title>
</head>
<body>
	<sf:form method="POST" action="buscar" modelAttribute="prod">
		<sf:label path="ID">Introduce ID:</sf:label>
		<sf:input path="ID" />
		<input type="submit" value="Buscar producto" />
	</sf:form>
</body>
</html>