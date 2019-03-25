<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="constants.PathToPage" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Recipe</title>
    <link rel="stylesheet" href="../../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="../../assets/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="../../assets/css/smoothproducts.css">
    <link rel="stylesheet" href="../../assets/css/checkboxStyle.css">
</head>

<body>
<nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
    <div class="container"><a class="navbar-brand logo" href=${PathToPage.HOME_PATH}><img
            src="../../assets/img/logo.png"></a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span
                class="navbar-toggler-icon"></span></button>
        <div
                class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item" role="presentation"><a class="nav-link" href=${PathToPage.HOME_PATH}>Home</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href=${PathToPage.SEARCH_RECIPE_PATH}>search</a>
                </li>
                <li class="nav-item" role="presentation"><a class="nav-link" href=${PathToPage.USER_INFO}>settings</a>
                </li>
                <li class="nav-item" role="presentation"><a class="nav-link" href=${PathToPage.LOGOUT_PATH}>log out</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<main class="page product-page">
    <section class="clean-block clean-product dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info"></h2>
                <p></p>
            </div>
            <div class="block-content">
                <div class="product-info">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="gallery">
                                <div class="sp-wrap"><a href=<c:out value="${recipe.getImage()}"/>>
                                    <img class="img-fluid d-block mx-auto" src=<c:out value="${recipe.getImage()}"/>>
                                </a></div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="info">
                                <h2><c:out value="${recipe.getName()}"/></h2>


                                <div class="summary">
                                    <p><h5><c:out
                                        value="${recipe.getDescription().substring(0,recipe.getDescription().indexOf('.'))}"/></h5></p>
                                </div>


                                <div class="summary">
                                    <p><h5>Preparation time: <c:out value="${recipe.getPreparationTime()}"/>
                                    min</h5></p>
                                </div>
                                <div class="summary">
                                    <p><h5>Cooking time: <c:out value="${recipe.getCookingTime()}"/> min</h5></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="product-info">
                    <div>
                        <ul class="nav nav-tabs" id="myTab">
                            <li class="nav-item"><a class="nav-link active" role="tab" data-toggle="tab"
                                                    href="#description" id="description-tab">Instruction</a></li>
                            <li class="nav-item"><a class="nav-link" role="tab" data-toggle="tab" href="#specifications"
                                                    id="specifications-tabs">Ingredients</a></li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane active fade show description" role="tabpanel" id="description">
                                <p style="white-space: pre-wrap;"><c:out value="${recipe.getDescription()}"/></p>
                                <div class="row">
                                    <div class="col-md-5">
                                        <figure class="figure"><img class="img-fluid figure-img" src=<c:out
                                                value="${recipe.getImage()}"/>></figure>
                                    </div>
                                    <div class="col-md-7">
                                        <h4>Lorem Ipsum</h4>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna,
                                            dignissim nec auctor in, mattis vitae leo. Lorem ipsum dolor sit amet,
                                            consectetur adipiscing elit.</p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-5">
                                        <figure class="figure"></figure>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade show specifications" role="tabpanel" id="specifications">

                                <c:forEach var="ingredient" items="${ingredientList}">

                                    <label>
                                        <input type="checkbox" name="ingredient" value="${ingredient.getId()}"></input>
                                        <span>${ingredient.getName()}</span>
                                    </label>
                                    <br>
                                </c:forEach>


                            </div>
                        </div>
                    </div>
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