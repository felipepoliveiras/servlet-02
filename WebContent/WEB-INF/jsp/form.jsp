<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="raiz" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servlet 02</title>
</head>
<body>
	<a href="${raiz}">Menu principal</a>
	<c:if test="${not empty erros}">
		<ul>
			<c:forEach items="${erros}" var="erro">
				<li>${erro }</li>
			</c:forEach>
		</ul>
	</c:if>
	<form action="${raiz}salvar" method="post">
		<input type="hidden" name="id" value="${usuario.id}">
		<input type="text" name="nome" value="${usuario.nome}"><br/>
		<textarea name="endereco" >${usuario.endereco}</textarea><br/>
		<c:forEach items="${sexos}" var="sexo">	
			<input type="radio" name="sexo" value="${sexo}" ${usuario.sexo eq sexo ? 'checked' : '' }>${sexo.label}</input>
		</c:forEach>
		<input type="checkbox" name="temFilhos" ${usuario.temFilhos ? 'checked' : '' }>Tem filhos?<br/> 
		<button type="submit">Salvar</button>
	</form>
</body>
</html>