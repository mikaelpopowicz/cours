<html>
<head>
	<meta charset="UTF-8">
	<meta author="Popowicz">
	<meta description="Cours sur la POO en PHP">
</head>
<body>
	<h1>Stock produit</h1>
	
<?php
include 'produit.class.php';

//Créer un objet de la classe
$unproduit = new produit(array(
	"ref" => 001,
	"qte" => 15,
	"prix" => 575.50,
	"des" => "Un PC"
));

//Affichage du résultat de la méthode afficher()
echo $unproduit->afficher();
echo "</br>Total du prix: ".$unproduit->total_prix()." €";

$unproduit->approvisionner(5);
echo '<br/>';
echo '<br/>';
echo $unproduit->afficher();
echo '<br/>';
echo '<br/>';
$unproduit->vendre(18);
echo $unproduit->afficher();
echo '<br/>';
echo '<br/>';
$unproduit->vendre(18);
?>
</body>
</html>