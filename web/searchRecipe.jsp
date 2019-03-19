
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search recipe</title>
    <link href="searchRecipeCSS.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="/userInfo" method="post">




        <input type="text" id="myInput"  onkeypress="addToArray()" onkeyup="myFunction()" placeholder="Search for ingredients..">

        <ul id="myUL">

            <li><a href="#">Ice</a></li>
            <li><a href="#">Cream</a></li>
            <li><a href="#">Vanilla</a></li>
            <li><a href="#">Apple</a></li>
            <li><a href="#">Sugar</a></li>
            <li><a href="#">Juice</a></li>
            <li><a onclick="addToList();" href="#">Bob</a></li>
            <li><a href="#">Candy</a></li>
            <li><a href="#">Pineapple</a></li>
        </ul>



        <script>
            var list
            function addToList() {
                
            }

            function myFunction() {
                var input, filter, ul, li, a, i, txtValue;
                input = document.getElementById('myInput');
                filter = input.value.toUpperCase();
                ul = document.getElementById("myUL");
                li = ul.getElementsByTagName('li');


                for (i = 0; i < li.length; i++) {
                    a = li[i].getElementsByTagName("a")[0];
                    txtValue = a.textContent || a.innerText;
                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                        li[i].style.display = "";
                    } else {
                        li[i].style.display = "none";
                    }
                }
            }

        </script>





        <div class="row">
            <input type="submit" value="Submit">
        </div>



    </form>
</div>
</body>
</html>
