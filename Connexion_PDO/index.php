<?php
session_start();
require 'Membre.class.php';
require 'GestMembre.class.php';
require 'Verification.php';
?>
<html>
<head>
	<meta charset="UTF-8">
	<title>Module membre</title>
	<link href="bootstrap.min.css" rel="stylesheet">
	<link href="signin.css" rel="stylesheet">
</head>
<body>
<?php
if(isset($_SESSION['auth']) && $_SESSION['auth'] == true)
{
		
}
else
{
?>
	<div class="jumbotron">
		<div class="container">
			<h1>Module de connexion</h1>
			<p>Création d'un module de connexion avec PDO</p>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-1">
				<h2 class="text-center text-primary">Vous êtes inscris ?</h2>
				<div class="well">
					<div class="alert alert-info">
						<span class="text-center">Connectez-vous à l'aide de votre login et mot de passe</span>
					</div>	
					<form class="form-signin" role="login" method="post">
						<input type="text" class="form-control" placeholder="Utilisateur" name="login" required="" autofocus="">
						<input type="password" class="form-control" placeholder="Password" name="password" required="">
						<button class="btn btn-lg btn-primary btn-block" name="go" type="submit">Connexion</button>
					</form>
				</div>
			</div>
			<div class="col-md-4 col-md-offset-2">
				<h2 class="text-center text-primary">Inscivez-vous !</h2>
				<div class="well">
					<form class="form-horizontal" role="subscribe" method="post">
						<div class="form-group">
							<label for="email" class="col-sm-4 control-label">Email</label>
							<div class="col-sm-8">
								<input type="email" class="form-control" id="email" placeholder="Votre adresse email">
							</div>
						</div>
						<div class="form-group">
							<label for="nom" class="col-sm-4 control-label">Nom</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="nom" name="nom" placeholder="Votre nom">
							</div>
						</div>
						<div class="form-group">
							<label for="prenom" class="col-sm-4 control-label">Prénom</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="prenom" name="prenom" placeholder="Votre prénom">
							</div>
						</div>
						<div class="form-group">
							<label for="mdp1" class="col-sm-4 control-label">Password</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="mdp1" name="mdp1" placeholder="********">
							</div>
						</div>
						<div class="form-group">
							<label for="mdp2" class="col-sm-4 control-label">Confirmation</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="mdp2" name="mdp2" placeholder="********">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-8 col-md-offset-4">
								<button type="submit" class="btn btn-primary" name="register">Inscription</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
<?php
}	
?>
<script src="/bootstrap.min.js"></script>
</body>
</html>