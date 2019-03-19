
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8;>
        <title>Tour Agency</title>
    </head>

    <body bgcolor="#ff69b4">

    <h1> Choose ingredient: </h1>

    <select value="Ingredient" name="ingredientSelect" size="1">
        <c:forEach var="ingredientList" items="${ingredient}">
            <option>${ingredientList.getName()}</option>
        </c:forEach>
    </select>


    <h1 style="text-align: center"> Hotels: </h1>


    </body>
    </html>
</div>