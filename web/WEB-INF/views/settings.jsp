
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="constants.PathToPage" %>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Settings</title>
    <link rel="stylesheet" href="../../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="../../assets/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="../../assets/css/smoothproducts.css">
</head>

<body>
    <nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
        <div class="container"><a class="navbar-brand logo" href=${PathToPage.HOME_PATH}><img src="../../assets/img/logo.png"></a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div
                class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav ml-auto">

                    <li class="nav-item" role="presentation"><a class="nav-link" href=${PathToPage.HOME_PATH}>Home</a></li>

                    <c:if test = "${sessionScope.loginedUser.isAdmin()}">
                        <li class="nav-item" role="presentation"><a class="nav-link" href=${PathToPage.CREATE_RECIPE_PATH}>create</a></li>
                    </c:if>

                    <li class="nav-item" role="presentation"><a class="nav-link" href=${PathToPage.SEARCH_RECIPE_PATH}>search</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href=${PathToPage.USER_INFO}>settings</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href=${PathToPage.LOGOUT_PATH}>log out</a></li>
                </ul>
        </div>
        </div>
    </nav>
    <main class="page contact-us-page">
        <section class="clean-block clean-form dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Settings</h2>
                    <p>You can update your info</p>
                </div>
                <form action="${PathToPage.USER_INFO}" method="post">

                    <div class="form-group"><label>Name</label> <input class="form-control" type="text"value="${(user.getName())}" id="uname" name="userName" placeholder="Enter name"></div>
                    <div class="form-group"><label>Surname</label> <input class="form-control" type="text"value="${(user.getSurname())}" id="uSurname" name="userSurname" placeholder="Enter surname"></div>

                    <div class="form-group"><button class="btn btn-success btn-block" type="submit">Save</button></div>


                </form>
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