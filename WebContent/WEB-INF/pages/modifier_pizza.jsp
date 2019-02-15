<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier Pizza</title>
</head>
<body>
<c:import url="menu.jsp"></c:import>
<h1>Modifier Pizza</h1>

<h1>Ajouter pizza</h1>
<form action="Modifier_pizza" method="post">
<fieldset>
<legend>Nouvelle Pizza</legend>

<input type="text" id="id" name="id" value="${pizza.id }" class="info" hidden="hidden" ><br><br>

<label for="numero">Numero :</label>
<input type="text" id="numero" name="numero" value="${pizza.numero }" class="info"><br><br>

<label for="libelle">Libelle :</label>
<input type="text" id="libelle" name="libelle" value="${pizza.libelle }" class="info"><br><br>

<label for="reference">Reference :</label>
<input type="text" id="reference" name="reference" value="${pizza.reference }" class="info"><br><br>

<label for="prix">Prix :</label>
<input type="text" id="prix" name="prix" value="${pizza.prix }" class="info"><br><br>

<label for="description">description :</label>
<input type="text" id="description" name="description" value="${pizza.description }" class="info"><br><br>

<label for="urlImage">Url Image :</label>
<input type="text" id="urlImage" name="urlImage" value="${pizza.urlImage }" class="info"><br><br>

<input type="submit" value="envoye" class="v_n">
<input type="reset" value="Annuler" class="v_n">

</fieldset>
</form>

</body>
</html>