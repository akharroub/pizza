<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>info pizza</title>
<link rel="stylesheet" href="ressource/css/pizzainfo.css">
</head>
<body>
<c:import url="menu.jsp"></c:import>


<h1 id="uti">Pizza</h1>
<div class="nom">${pizza.libelle }</div><br><br>
<div>
<img src="${pizza.urlImage }">
</div>
<div class="info">
${pizza.reference }<br>
${pizza.description }<br>
${pizza.numero }<br>
${pizza.prix }<br>

<a href="supprimer_pizza?id=${pizza.id}"><button type="button">Supprimer</button></a>
<a href="Modifier_pizza?id=${pizza.id}"><button type="button">Modifier</button></a>

</div>


</body>
</html>