<?php
include "compte.class.php";
session_start();
ob_start();
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
if (isset($_SESSION['compte'])) {
?>

	<div class="container-narrow">
		<div class="masthead">
			<ul class="nav nav-pills pull-right">
				<li class="active"><a href="index.php">Accueil</a></li>
				<li><a href="retrait.php">Retrait</a></li>
				<li><a href="depot.php">Dépot</a></li>
			</ul>
			<form method="post">
				<h3 class="muted">POO Bank   |  <button class="btn btn-danger" type="submit" name="supprimer">Supprimer le compte</button></h3>
			</form>
		</div>
		<hr>
		<div class="page-header">
			<h1>Compte bancaire <small>n° <?php echo $_SESSION['compte']->getNumero();?></small></h1>
		</div>
		<dl class="dl-horizontal">
			<dt>
				Nom
			</dt>
			<dd>
				<?php echo $_SESSION['compte']->getNom();?>
			</dd>
			<dt>
				Prénom
			</dt>
			<dd>
				<?php echo $_SESSION['compte']->getPrenom();?>
			</dd>
			<dt>
				Situation
			</dt>
			<dd>
<?php
?>
				<span class='badge <?php echo $_SESSION['compte']->estEnDecouvert();?>'>
					<?php echo $_SESSION['compte']->getSolde();?> €
				</span>
			</dd>
		</dl>
		<br />
		<br />
		<dl class="dl-horizontal">
			<dt>
				Légende :
			</dt>
			<dd>
				<span class="badge badge-important">A découvert</span>    <span class="badge badge-info">Vide</span>   <span class="badge badge-success">En santé</span>
			</dd>
		</dl>
		<hr>
	    <div class="footer">
	      <p>&copy; POO Bank 2013</p>
	    </div>
	</div>
<?php
if (isset($_POST['supprimer'])) {
	$_SESSION = array();
	session_destroy();
	header('Location: index.php');
}
?>
<?php
} else {
?>
<div class="container-narrow">
	<div class="masthead">
		<ul class="nav nav-pills pull-right">
			<li class="active"><a href="index.php">Accueil</a></li>
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
ob_flush();
?>
</body>
</html>