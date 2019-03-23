<%@ page import="constants.PathToPage" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Register - Brand</title>
    <link rel="stylesheet" href="../../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="../../assets/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="../../assets/css/smoothproducts.css">
</head>

<body>
    <nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
        <div class="container"><a class="navbar-brand logo" href=${PathToPage.LOGIN_PATH}><img src="../../assets/img/logo.png"></a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div
                class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item" role="presentation"><a class="nav-link" href=${PathToPage.LOGIN_PATH}>login</a></li>
              </ul>
        </div>
        </div>
    </nav>
    <main class="page registration-page">
        <section class="clean-block clean-form dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Registration</h2>
                    <p>Enter your information</p>
                </div>
                <form action="registration" method="POST">
                    <div class="form-group"><label for="login">Username</label>
                        <input class="form-control item" type="text" id = "login" placeholder="Enter login" name="login" required>

                    <div class="form-group"><label for="password">Password</label>
                        <input class="form-control item" type="password" id = "password" placeholder="Enter Password" name="password" required></div>

                    <div class="form-group"><label for="name">Name</label>
                        <input class="form-control item" type="text" placeholder="Enter Name" id = "name" name="name" ></div>

                    <div class="form-group"><label for="surname">Surname</label>
                        <input class="form-control item" type="text" placeholder="Enter Surname" id = "surname" name="surname" >

                    </div><button class="btn btn-primary btn-block" type="submit">Sign Up</button></div></form>
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
            <p>© 2018 vse sam production</p>
        </div>
    </footer>
    <script src="../../assets/js/jquery.min.js"></script>
    <script src="../../assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="../../assets/js/smoothproducts.min.js"></script>
    <script src="../../assets/js/theme.js"></script>
</body>

</html>