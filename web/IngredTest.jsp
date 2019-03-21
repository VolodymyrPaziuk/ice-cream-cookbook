<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Jquery Suggestags - Amsify42</title>

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
        <h4 class="header center orange-text">Jquery Suggestags</h4>
        <div class="row center">
            <input type="text" class="form-control" name="country"/>
        </div>
        <br/>
        <div class="row center">
            <h5>Already Selected</h5>
            <input type="text" class="form-control" name="color" value="Orange,Black"/>
        </div>
        <div class="row center">
            <h5>White Listed</h5>
            <input type="text" class="form-control" name="planets" value="Earth,Mars"/>
        </div>
    </div>
</div>




<footer>
    <div class="container">
        <h4 class="text-left">Usage</h4>
        <pre>
			<code>
				$('input[name="country"]').amsifySuggestags({
					type : 'materialize'
				});
				$('input[name="color"]').amsifySuggestags({
					type : 'materialize',
					suggestions: ['Black', 'White', 'Red', 'Blue', 'Green', 'Orange']
				});
				$('input[name="planets"]').amsifySuggestags({
					type : 'materialize',
					suggestions: ['Mercury', 'Venus', 'Earth', 'Mars', 'Jupitor', 'Uranus', 'Neptune', 'Pluto'],
					whiteList: true
				});
			</code>
		</pre>
    </div>
</footer>
<!-- -->
<script type="text/javascript">
    $('input[name="country"]').amsifySuggestags({
        type : 'materialize'
    });
    $('input[name="color"]').amsifySuggestags({
        type : 'materialize',
        suggestions: ['Black', 'White', 'Red', 'Blue', 'Green', 'Orange']
    });
    $('input[name="planets"]').amsifySuggestags({
        type : 'materialize',
        suggestions: ['Mercury', 'Venus', 'Earth', 'Mars', 'Jupitor', 'Uranus', 'Neptune', 'Pluto'],
        whiteList: true
    });
</script>
</body>
</html>