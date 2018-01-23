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
	<a href="${raiz}">Menu principal</a>
	<c:if test="${not empty param.erro}">
		<c:choose>
			<c:when test="${param.erro eq 1}">
				<p>Informe o ID para remover o usu�rio</p>
			</c:when>
			<c:when test="${param.erro eq 2}">
				<p>O usu�rio com o ID informado n�o existe no banco de dados</p>
			</c:when>
			<c:when test="${param.erro eq 3}">
				<p>Informe o ID para alterar o usu�rio</p>
			</c:when>
			<c:when test="${param.erro eq 4}">
				<p>O usu�rio com o ID informado n�o existe no banco de dados</p>
			</c:when>
		</c:choose>
	</c:if>
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
					<td>${usuario.sexo.label}</td>
					<td>${usuario.temFilhos}</td>
					<td><a href="${raiz}editar?id=${usuario.id}">Editar</a></td>
					<td><a href="${raiz}remover?id=${usuario.id}">Remover</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>