<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="ressource/css/pizza.css">
<title>pizza</title>
</head>
<body>
	<c:import url="menu.jsp"></c:import>
	<h1>Pizza</h1>
	<div id="pizza">


		<c:forEach items="${pizza }" var="pizza">
			<div class="pizza1">

				<div class="nom">${pizza.libelle }</div>
				<div>
				<a href="info_pizza?id=${pizza.id }"><img src="${pizza.urlImage }"></a>
					
				</div>
				<div class="list">${pizza.reference }<br> ${pizza.numero }<br>${pizza.description }<br> ${pizza.prix}&euro;</div>
			</div>
		</c:forEach>
	</div>
	<a href="ajouter-pizza"><button type="button">Ajouter</button></a>
</body>
</html>