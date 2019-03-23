<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Login  Cookbook</title>
    <link rel="stylesheet" href="../../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="../../assets/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="../../assets/css/smoothproducts.css">
</head>

<body>
<nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
    <div class="container"><a class="navbar-brand logo" href="/"><img src="../../assets/img/logo.png"></a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span
                class="navbar-toggler-icon"></span></button>
        <div
                class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item" role="presentation"><a class="nav-link" href="/registration">registration</a></li>
            </ul>
        </div>
    </div>
</nav>
<main class="page login-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Log In</h2>
                <p>Enter username and password</p>
            </div>


            <form action="${pageContext.request.contextPath}/login" method="post">

                <div class="form-group">
                    <label for="inputUsername" >Username</label>
                    <input class="form-control" type="text" id="inputUsername"name="login" placeholder="Enter Login"></div>

                <div class="form-group">
                    <label for="inputPassword">Password</label>
                    <input class="form-control" type="password" id="inputPassword" name="password"
                           placeholder="Password">
                </div>

                <div class="form-group">
                    <input type="checkbox" name="rememberMe" value="Y"> Remember me<BR>
                </div>


                    <div id="submit" style="text-align: right">
                        <button type="submit" class="btn btn-success" role="button">Sign In</button>
                        <a href="/registration" class="btn btn-primary" role="button">Sign Up</a>
                    </div>


            </form>
        </div>
    </section>
</main>

<br><br><br><br>
<footer class="page-footer dark">
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <ul></ul>
            </div>
        </div>
    </div>

    <div class="footer-copyright">
        <p>© 2019 vse sam production</p>
    </div>
</footer>
<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
<script src="../../assets/js/smoothproducts.min.js"></script>
<script src="../../assets/js/theme.js"></script>
</body>

</html>