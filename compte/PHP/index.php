<?php
session_start();
?>
<html>
<head>
	<meta charset="UTF-8">
	<meta author="Popowicz">
	<meta description="Classe compte">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="../../ressources/bootstrap2/css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="../../ressources/bootstrap2/css/narrow.css" rel="stylesheet" type="text/css">

</head>
<body>
<?php
include 'compte.class.php';
if (isset($_SESSION['compte'])) {
	echo '<pre>';print_r($_SESSION);echo '</pre>';
?>

	<div class="container-narrow">
		<div class="masthead">
			<ul class="nav nav-pills pull-right">
				<li class="active"><a href="#">Accueil</a></li>
				<li><a href="">Retrait</a></li>
				<li><a href="">Dépot</a></li>
				<li></li>
				<li>
					<form method="post">
						<button class="btn btn-small btn-danger" type="submit" name="supprimer">Détruite le compte</button>
					</form>
				</li>
			</ul>
			<h3 class="muted">POO Bank</h3>
		</div>

		<hr>

		<div class="jumbotron">
			<h1>Votre compte à la POO Bank</h1>
			<p class="lead">Vous n'avez pas encore de compte chez nous, alors n'attendez plus</p>
			<a class="btn btn-large btn-success" href="inscription.php">S'inscrire maintenant</a>
		</div>

		<hr>
	
	    <div class="footer">
	      <p>&copy; POO Bank 2013</p>
	    </div>
	</div>
<?php
if (isset($_POST['supprimer'])) {
	$_SESSION = array();
	session_destroy();
	echo "Le compte a bien été détruit";
}
?>
<?php
} else {
?>
<div class="container-narrow">
	<div class="masthead">
		<ul class="nav nav-pills pull-right">
			<li class="active"><a href="#">Accueil</a></li>
			<li><a href="inscription.php">Inscription</a></li>
		</ul>
		<h3 class="muted">POO Bank</h3>
	</div>

	<hr>

	<div class="jumbotron">
		<h1>Votre compte à la POO Bank</h1>
		<p class="lead">Vous n'avez pas encore de compte chez nous, alors n'attendez plus</p>
		<a class="btn btn-large btn-success" href="inscription.php">S'inscrire maintenant</a>
	</div>

	<hr>
	
    <div class="footer">
      <p>&copy; POO Bank 2013</p>
    </div>
</div>
<?php	
}
?>
</body>
</html>