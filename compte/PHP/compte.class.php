<?php
class compte {
	
	/*
		@@ Attributs
	*/
	
	private $_nom, $_prenom, $_numero, $_solde;
	
	
	
	/*
		@@ Constructeur
	*/
	
	public function __construct(array $donnees) {
		$this->hydrate($donnees);
	}
	
	
	
	/*
		@@ Hydratation
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
		@@ Getters
	*/
	
	public function getNom() { return $this->_nom; }
	public function getPrenom() { return $this->_prenom; }
	public function getNumero() { return $this->_numero; }
	public function getSolde() { return $this->_solde; }
	
	
	
	/*
		@@ Setters
	*/
	
	public function setNom($nom) {
		if (is_string($nom)) {
			$this->_nom = $nom;
		} else {
			trigger_error('Le nom n\'est pas correct', E_USER_WARNING);
			return;
		}
	}
	
	public function setPrenom($prenom) {
		if (is_string($prenom)) {
			$this->_prenom = $prenom;
		} else {
			trigger_error('Le prénom n\'est pas correct', E_USER_WARNING);
			return;
		}
	}
	
	public function setNumero($numero) {
		$this->_numero = (int)$numero;
	}
	
	public function setSolde($solde) {
		$this->_solde = (float)$solde;
	}
	
	
	
	/*
		@@ Fonctions supplémentaires
	*/
	
	public function consulter() {
		$cons = "";
		$cons .= "Numéro de compte : ".$this->getNumero()."<br/>";
		$cons .= $this->getNom()." ".$this->getPrenom()."<br/><br/>";
		$cond .= "Solde : ".$this->getSolde()."<br/>";
		return $cons;
	}
	
	public function deposer($euro) {
		$this->setSolde($this->getSolde()+(float)$euro);
	}
	public function retirer($euro) {
		$this->setSolde($this->getSolde()-(float)$euro);
	}
	
	public function estEnDecouvert() {
		if ($this->getSolde() < 0 ) {
			return "badge-important";
		} else if ($this->getSolde() == 0 ) {
			return "badge-info";
		} else {
			return "badge-success";
		}
	}	
}
?>