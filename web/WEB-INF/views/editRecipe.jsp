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
                <li class="nav-item" role="presentation"><a class="nav-link" href=${PathToPage.SEARCH_RECIPE_PATH}>search</a></li>
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
                    <form action="/editRecipe" method="post" enctype="multipart/form-data">

                    <h3>Edit recipe</h3>
                    <div class="post-info"><span>You are admin</span></div>

                    <p >  <img class="img-fluid d-block mx-auto" src=<c:out value="${recipe.getImage()}"/> > </p>

                        <div class="form-group"><input class="ion-android-radio-button-off" name="image_uploads"
                                                type="file"
                                                accept=".jpg, .jpeg, .png" style="height: 30px;width: 100%;"></div>

                        <div class="form-group"><label>Recipe name</label><input class="form-control" type="text" value="${(recipe.getName())}" name="recipeName" placeholder="Enter recipe name" style="height: 30px;width: 100%;"></div>
                        <div class="form-group"><label>Preparation time</label><input class="form-control" type="number" value="${(recipe.getPreparationTime())}"name="prepTime" placeholder="Enter preparation time"  style="height: 30px;width: 100%;"></div>
                        <div class="form-group"><label>Cooking time</label><input class="form-control" type="number" value="${(recipe.getCookingTime())}" name="cookTime" placeholder="Enter cooking time" style="height: 30px;width: 100%;"></div>
                        <div class="form-group"><label>Description</label><textarea class="form-control"  type="text" value="${(recipe.getDescription())}"  name="instruction" placeholder="Write instruction" style="height: 190px;width: 100%;"> ${(recipe.getDescription())}</textarea></div>



                        <div class="form-group"><button class="btn btn-success btn-block" type="submit">Save</button></div>
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