<?php
//Inclusion de la classe
include "compte.class.php";
$error = "";
session_start();
ob_start(); 
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
<?php
if (isset($_POST['retirer'])) {
	//Vérification de la valeur entrée
	$verif = "#^[1-9]+\d*\.?\d*$#";
	if (preg_match($verif, $_POST['retrait']) == 1) {
		//Utilisation de la méthode retirer
		$_SESSION['compte']->retirer($_POST["retrait"]);

		//Redirection vers la page d'accueil
		header("Location: index.php");
	} else {
		header("Location: retrait.php");
	}	
} else {
?>
	<div class="container-narrow">
		<div class="masthead">
			<ul class="nav nav-pills pull-right">
				<li><a href="index.php">Accueil</a></li>
				<li class="active"><a href="retrait.php">Retrait</a></li>
				<li><a href="depot.php">Dépot</a></li>
			</ul>
			<h3 class="muted">POO Bank</h3>
		</div>

		<hr>

		<div class="page-header">
			<h1>Retrait sur le compte <small>n° <?php echo $_SESSION['compte']->getNumero();?></small></h1>
		</div>
		<form method="post" class="form-horizontal">
			<!-- Prénom -->
			<div class="control-group">
				<label class="control-label" for="Retrait">Montant</label>
				<div class="controls">
					<input type="text" id="Retrait" name="retrait">
				</div>
			</div>
			<!-- Boutons -->
			<div class="control-group">
				<div class="controls">
					<button class="btn" type="reset">Réinitialiser</button>
					<button class="btn btn-primary" type="submit" name="retirer">Effectuer retrait</button>
				</div>
			</div>
		</form>
		<hr>
	    <div class="footer">
	      <p>&copy; POO Bank 2013</p>
	    </div>
	</div>
<?php
}
ob_flush();
?>
</body>
</html>