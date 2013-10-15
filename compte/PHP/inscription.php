<?php
session_start();
//echo '<pre>';print_r($_SESSION);echo '</pre>';
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
	<div class="container-narrow">
		<div class="masthead">
			<ul class="nav nav-pills pull-right">
				<li><a href="index.php">Accueil</a></li>
				<li class="active"><a href="#">Inscription</a></li>
			</ul>
			<h3 class="muted">POO Bank</h3>
		</div>

		<hr>

		<div class="page-header">
			<h1>Formulaire d'ouverture de compte</h1>
		</div>
		<form method="post" class="form-horizontal">
			<!-- Nom -->
			<div class="control-group">
				<label class="control-label" for="Nom">Nom</label>
				<div class="controls">
					<input type="text" id="Nom" name="nom">
				</div>
			</div>
			<!-- Prénom -->
			<div class="control-group">
				<label class="control-label" for="Prenom">Prénom</label>
				<div class="controls">
					<input type="text" id="Prenom" name="prenom">
				</div>
			</div>
			<!-- Boutons -->
			<div class="control-group">
				<div class="controls">
					<button class="btn" type="reset">Réinitialiser</button>
					<button class="btn btn-primary" type="submit" name="inscrire">S'inscrire</button>
				</div>
			</div>
		</form>
		<hr>
	    <div class="footer">
	      <p>&copy; POO Bank 2013</p>
	    </div>
	</div>
</body>
</html>