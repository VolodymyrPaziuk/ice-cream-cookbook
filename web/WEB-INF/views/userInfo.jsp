
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="constants.PathToPage" %>
<html>
<head>
    <title>About user</title>
    <link href="createRecipeCSS.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="${PathToPage.HOME_PATH}" method="post">
        <div class="row">
            <div class="col-25">
                <label for="uname">Name </label>
            </div>
            <div class="col-75"> <input type="text" value="${(user.getName())}" id="uname" name="userName" placeholder="Enter name"></div>
        </div>


        <div class="row">
            <div class="col-25">
                <label for="uSurname">Surname </label>
            </div>
            <div class="col-75">
                <input type="text" value="${(user.getSurname())}" id="uSurname" name="userSurname" placeholder="Enter surname">
            </div>
        </div>

        <div class="row">
            <input type="submit" value="Submit">
        </div>
    </form>
</div>
</body>
</html>
