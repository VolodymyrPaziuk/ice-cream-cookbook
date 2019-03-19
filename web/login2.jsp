<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>SignIn</title>
    <style type="text/css">
        <%@include file="bootstrap.min.css" %>
        <%@include file="LogIn.css" %>
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="#">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav" id="superNavbar">
        </ul>
    </div>
</nav>
<div class="container-fluid h-100">
    <div class="row justify-content-center align-items-center h-100">
        <div class="col col-sm-6 col-md-6 col-lg-4 col-xl-3">
            <h1>Welcome<strong>guest</strong></h1>
            <footer class="blockquote-footer" style="text-align: right;">Everyone says that we are <strong>the
                Best...</strong></footer>
            <br>
            <form action="${pageContext.request.contextPath}/login" method="post">

                <div class="form-group">
                    <label for="inputUsername">Login</label>
                    <input type="text" class="form-control" id="inputUsername" name="login" placeholder="Enter Login">
                </div>
                <div class="form-group">
                    <label for="inputPassword">Password</label>
                    <input type="password" class="form-control" id="inputPassword" name="password"
                           placeholder="Password">
                </div>

                <div class="form-group">
                    <input type="checkbox" name="rememberMe" value="Y"> Remember me<BR>
                </div>

                <div id="submit" style="text-align: right">
                    <button type="submit" class="btn btn-success" role="button">Sign In</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>