<?php
include 'Bateau.class.php';
class BateauVoyageur extends Bateau
{
	private $vitesseBatVoy,
	$imageBatVoy,
	$lesEquipements;
	
	
	public function setVitesseBatVoy($vitesse)
	{
		$this->vitesseBatVoy = $vitesse;
	}
	
	public function setImageBatVoy($image)
	{
		$this->imageBatVoy = $image;
	}
	
	public function setLesEquipements(array $equip)
	{
		$this->lesEquipements = $equip;
	}
	
	public function vitesseBatVoy() { return $this->vitesseBatVoy; }
	public function imageBatVoy() { return $this->imageBatVoy; }
	public function lesEquipements() { return $this->lesEquipements; }
	
	public function toString()
	{
		$string = "";
		foreach (get_object_vars($this) as $attribut => $value) {
			if($attribut != "idBat") {
				if($attribut != "lesEquipements") {
					$string .= $attribut.": ".$value."<br>";
				}
				else {
					$string .= $attribut.": <ol>";
					if(is_array($value) && !empty($value)) {
						foreach ($value as $equipements) {
							$string .= "<li>".$equipements."</li>";
						}
					}
					$string .= "</ol>";
				}
			}
		}
		return $string;
	}
}
$bat = new BateauVoyageur(array(
	"id" => 1,
	"nomBat" => "Bateau de fou",
	"longueurBat" => 12,
	"largeurBat" => 6,
	"vitesseBatVoy" => 120,
	"imageBatVoy" => "Belle-image.jpg",
	"lesEquipements" => array(
		"Accès Handicapé",
		"Bar"
	)
));
?>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	<h1>Dossier Atlantik</h1>
	<p>
		Test d'un bateau voyageur</br>
		<?php
			echo $bat->toString();
		?>
	</p>
</body>
</html>