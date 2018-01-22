<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="raiz"  />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servlet 02</title>
</head>
<body>
	<c:if test="${not empty erros}">
		<ul>
			<c:forEach items="${erros}" var="erro">
				<li>${erro }</li>
			</c:forEach>
		</ul>
	</c:if>
	<form action="${raiz}cadastrar" method="post">
		<input type="hidden" name="id">
		<input type="text" name="nome"><br/>
		<textarea name="endereco"></textarea><br/>
		<input type="radio" name="sexo" value="FEMININO">Feminino</input>
		<input type="radio" name="sexo" value="MASCULINO">Masculino</input>
		<input type="checkbox" name="temFilhos">Tem filhos?<br/>
		<button type="submit">Cadastrar usuário</button> 
	</form>
</body>
</html>