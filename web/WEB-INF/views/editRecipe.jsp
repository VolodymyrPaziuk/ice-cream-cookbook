<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="constants.PathToPage" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Edit</title>
    <link rel="stylesheet" href="../../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="../../assets/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="../../assets/css/smoothproducts.css">
</head>
<body>
<nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
    <div class="container"><a class="navbar-brand logo" href="/"><img src="../../assets/img/logo.png"></a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item" role="presentation"><a class="nav-link" href=${PathToPage.HOME_PATH}>Home</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href=${PathToPage.CREATE_RECIPE_PATH}>create</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href=${PathToPage.USER_INFO}>settings</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href=${PathToPage.LOGOUT_PATH}>log out</a></li>
            </ul>
        </div>
    </div>
</nav>

<main class="page blog-post">
    <section class="clean-block clean-post dark">
        <div class="container">

            <div class="block-content">
                <div class="post-body">
                    <form action="/editRecipe" method="post">
                    <h3>Edit recipe</h3>
                    <div class="post-info"><span>By John Smith</span></div>

                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna, dignissim nec auctor in, mattis vitae leo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna, dignissim nec auctor in, mattis vitae
                        leo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna, dignissim nec auctor in, mattis vitae leo. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                    <div class="row" style="height: 30px;padding-bottom: 60px;">
                        <div class="col-xl-4">
                            <p>Recipe name</p>
                        </div>
                        <div class="col"><input type="text" value="${(recipe.getName())}" name="recipeName" placeholder="Enter recipe name" style="height: 30px;width: 100%;"></div>
                    </div>
                    <div class="row" style="height: 30px;padding-bottom: 60px;">
                        <div class="col-xl-4">
                            <p>Preparation time</p>
                        </div>
                        <div class="col"><input type="number" value="${(recipe.getPreparationTime())}"name="prepTime" placeholder="Enter preparation time"  style="height: 30px;width: 100%;"></div>
                    </div>
                    <div class="row" style="height: 30px;padding-bottom: 60px;">
                        <div class="col-xl-4">
                            <p>Cooking time</p>
                        </div>
                        <div class="col"><input type="number" value="${(recipe.getCookingTime())}" name="cookTime" placeholder="Enter cooking time" style="height: 30px;width: 100%;"></div>
                    </div>
                    <div class="row" style="height: 200px;padding-bottom: 60px;">
                        <div class="col-xl-4">
                            <p>Description</p>
                        </div>
                        <div class="col"><input  type="text" value="${(recipe.getDescription())}"  name="instruction" placeholder="Write instruction" style="height: 190px;width: 100%;"></div>
                    </div>
                        <div class="form-group"><button class="btn btn-primary btn-block" type="submit">Save</button></div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</main>
<footer class="page-footer dark">
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <ul></ul>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <p> 2019 vse sam production</p>
    </div>
</footer>
<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
<script src="../../assets/js/smoothproducts.min.js"></script>
<script src="../../assets/js/theme.js"></script>


</body>
</html>