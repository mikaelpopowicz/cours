<?php
class tableau {
	
	private $_tab = array(), $_nbelements;
	
	
	/*
	*	@@Constructeur
	*/
	
	public function __construct(array $donnees) {
		$this->hydrate($donnees);
	}
	
	
	
	/*
	*	@@ Hydratation
	*/
	
	public function hydrate(array $donnees) {
		foreach ($donnees as $key => $value) {
			// On récupère le nom du setter correspondant à l'attribut.
			$method = 'set'.ucfirst($key);
         
			// Si le setter correspondant existe.
			if (method_exists($this, $method))
		    {
		      // On appelle le setter.
		      $this->$method($value);
		    }
		}
	}
	
	
	
	/*
	*	@@ Getters
	*/
	
	public function getTab() { return $this->_tab; }
	public function getNbelements() { return $this->_nbelements; }
	
	
	
	/*
	*	@@ Setters
	*/
	
	public function setNbelements($nb) {
		$this->_nbelements = (int)$nb;
	}
	
	public function setTab(array $tab) {
		if (is_array($tab)) {
			for ($i = 0; $i < $this->getNbelements(); $i++) {
				$this->_tab[] = $tab[$i];
			}
		}
	}
	
	
	
	/*
	*	@@ Fonctions supplémentaires
	*/
	
	public function rechercher($value) {
		$j = 0;
		for ($i = 0; $i < $this->getNbelements(); $i++) {
			if ($this->getTab()[$i] == $value) {
				$found[] = $i;
				$j++;
			}
		}
		if ($found != 0) {
			return $found;
		}
		return false;
	}
	
	public function supprimer($num) {
		if ($num > -1 && $num < $this->getNebelements()) {
			for ($i = $num+1; $i < $this->getNbelements(); $i++) {
				$this->_tab[$i-1] = $this->_tab[$i];
			}
			unset($this->_tab[$this->getNbelements()-1]);
		}
	}
	
	public function trier($ordre) {
		$ordre = (int)$ordre;
		switch ($ordre) {
			case 1:
			$croissant = clone $this->getTab();
			do {
				$permut = false;
				for ($i=0; $i < count($croissant)-1; $i++) { 
					if ($croissant[$i] > $croissant[$i+1]) {
						$temp = $croissant[$i];
						$croissant[$i] = $croissant[$i+1];
						$croissant[$i+1] = $temp;
						$permut = true;
					}
				}
			} while ($permut == true);
			return $croissant;
				break;
			case 2:
			$decroissant = clone $this->getTab();
			do {
				$permut = false;
				for ($i=0; $i < count($decroissant)-1; $i++) { 
					if ($decroissant[$i] < $decroissant[$i+1]) {
						$temp = $decroissant[$i];
						$decroissant[$i] = $decroissant[$i+1];
						$decroissant[$i+1] = $temp;
						$permut = true;
					}
				}
			} while ($permut == true);
			return $decroissant;
				break;
		}
	}
	
	public function moyenne() {
		$moyenne = 0;
		for ($i = 0; $i < $this->getNbelements()-1; $i++) {
			$moyenne += $this->getTab()[$i];
		}
		return $moyenne /= $this->getNbelements();
	}
	
	public function min_max() {
		$tab = $this->trier(1);
		$etendue = array(
			"min" => $tab[0],
			"max" => $tab[count($tab)-1]
		);
		return $etendue;
	}
}
?>