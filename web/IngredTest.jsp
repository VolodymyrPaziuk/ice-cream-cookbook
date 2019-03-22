<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Search</title>

    <!-- CDN links -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css"/>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
    <link rel="stylesheet" type="text/css" href="assets/css/amsify.suggestags.css">

    <!-- Amsify Plugin -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script type="text/javascript" src="assets/js/jquery.amsify.suggestags.js"></script>
</head>


<body>


<div class="section no-pad-bot" id="index-banner">
    <div class="container">
        <br><br>



        <br/>

        <div class="row center">
            <h5>Choose ingredient</h5>
            <input type="text" class="form-control" name="planets" value=""/>
        </div>
    </div>
</div>



<!-- -->
<script type="text/javascript">


    $('input[name="planets"]').amsifySuggestags({
        type : 'materialize',
        suggestions: ['Ice', 'Milk', 'Banana', 'Apple', 'Juice', 'Cream', 'Vanilla', 'Sugar'],
        afterAdd: function(value) {
            console.info(value);
        },

        whiteList: true
    });
</script>
</body>
</html>