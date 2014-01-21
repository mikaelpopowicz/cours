<?php
class Bateau
{
	protected $idBat,
	$nomBat,
	$longueurBat,
	$largeurBat;
	
	public function __construct(array $donnees = array())
	{
		if (!empty($donnees))
		{
			$this->hydrate($donnees);
		}
	}
	
	public function hydrate(array $donnees)
	{
		foreach ($donnees as $attribut => $valeur)
		{
			$methode = 'set'.ucfirst($attribut);
       
			if (is_callable(array($this, $methode)))
			{
				$this->$methode($valeur);
			}
		}
	}
	
	public function setIdBat($id)
	{
		$this->idBat = $id;
	}
	
	public function setNomBat($nom)
	{
		$this->nomBat = $nom;
	}
	
	public function setLongueurBat($longueur)
	{
		$this->longueurBat = $longueur;
	}
	
	public function setLargeurBat($largeur)
	{
		$this->largeurBat = $largeur;
	}
	
	public function idBat() { return $this->idBat; }
	public function nomBat() { return $this->nomBat; }
	public function longueurBat() { return $this->longueurBat; }
	public function largeurBat() { return $this->largeurBat; }
	
	public function toString()
	{
		$string = "";
		foreach (get_object_vars($this) as $attribut => $value) {
			if($attribut != "idBat") {
				$string .= $attribut.": ".$value."<br>";
			}
		}
		return $string;
	}
}

?>