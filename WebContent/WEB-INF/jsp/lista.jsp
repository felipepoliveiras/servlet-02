<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="raiz" value="/" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servlet 02</title>
</head>
<body>
	<h1>Lista de usu�rios</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Endere�o</th>
				<th>Sexo</th>
				<th>Possu� filhos</th>
			</tr>
		</thead>
		<tbody>
			<!-- Usa o JSTL para fazer la�o de repeti��o para pegar cada usu�rio enviado
			pelo servlet UsuarioListarServlet -->
			<c:forEach var="usuario" items="${usuarios}">
				<tr>
					<td>${usuario.id}</td>
					<td>${usuario.nome}</td>
					<td>${usuario.endereco}</td>
					<td>${usuario.sexo}</td>
					<td>${usuario.temFilhos}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>