<?php
include "tableau.class.php";
session_start();
ob_start();
?>
<html>
<head>
	<meta charset="UTF-8">
	<meta author="Popowicz">
	<title>Tables foo</title>
	<meta description="Classe tableau">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="../../ressources/bootstrap2/css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="../../ressources/bootstrap2/css/narrow.css" rel="stylesheet" type="text/css">

</head>
<body>
<?php
if (isset($_SESSION['tableau'])) {
?>

<?php
} else {
?>
	<div class="container-narrow">
		<div class="masthead">
			<ul class="nav nav-pills pull-right">
				<li class="active"><a href="index.php">Accueil</a></li>
				<li><a href="inscription.php">Essayer</a></li>
			</ul>
			<h3 class="muted">Foo tables</h3>
		</div>

		<hr>

		<div class="jumbotron">
			<h1>Foo tables</h1>
			<p class="lead">Rien de plus amusant que les tableaux</p>
			<a class="btn btn-large btn-success" href="inscription.php">Essayer maintenant</a>
		</div>

		<hr>
	
	    <div class="footer">
	      <p>&copy; Foo tables 2013</p>
	    </div>
	</div>
<?php	
}
ob_flush();
?>
</body>
</html>