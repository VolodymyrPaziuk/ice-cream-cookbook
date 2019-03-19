<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 17.03.2019
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create recipe</title>
    <link href="createRecipeCSS.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="/createRecipe" method="post">
        <div class="row">
            <div class="col-25">
                <label for="rname">Recipe Name</label>
            </div>
            <div class="col-75">
                <input type="text" id="rname" name="recipeName" placeholder="Recipe name">
            </div>
        </div>


        <div class="row">
            <div class="col-25">
                <label for="ptime">Preperation time</label>
            </div>
            <div class="col-75">
                <input type="text" id="ptime" name="prepTime" placeholder="Cooking time">
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="ptime">Preperation time</label>
            </div>
            <div class="col-75">
                <input type="text" id="ctime" name="cookTime" placeholder="Cooking time">
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="subject">Description</label>
            </div>
            <div class="col-75">
                <textarea id="subject" name="instruction" placeholder="Write instruction.." style="height:200px"></textarea>
            </div>
        </div>
        <div class="row">
            <input type="submit" value="Submit">
        </div>
    </form>
</div>
</body>
</html>
