<?php

class produit {
	
	private $_ref, $_qte, $_prix, $_designation;
			
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
	
	public function ref() { return $this->_ref; }
	public function qte() { return $this->_qte; }
	public function prix() { return $this->_prix; }
	public function des() { return $this->_designation; }
	
	
	
	/*
		@@ Setters
	*/
	
	public function setRef($ref) {
		$this->_ref = (int)$ref;
	}
	
	public function setQte($qte) {
		$this->_qte = (int)$qte;
	}
	
	public function setPrix($prix) {
		if (is_float($prix)) {
			$this->_prix = $prix;
		} else {
			trigger_error('Le prix doit être un float', E_USER_WARNING);
			return;
		}
	}
	
	public function setDes($des) {
		if (is_string($des)) {
			$this->_designation = $des;
		} else {
			trigger_error('La désignation doit être une chaine de caractère', E_USER_WARNING);
			return;
		}
	}
	
	
	
	/*
		@@ Fonctions supplémentaires
	*/
	
	public function afficher() {
		$aff = "";
		$aff .= "Référence : ".$this->ref()."</br>";
		$aff .= "Quantité en stock: ".$this->qte()."</br>";
		return $aff;
	}
	public function total_prix() {
		return $this->_qte*$this->_prix;
	}
	
	public function approvisionner($qte) {
		if (is_int($qte)) {
			$this->setQte($this->qte()+$qte);
		} else {
			trigger_error('La quantité doit être un entier', E_USER_WARNING);
			return;
		}
		
	}
	
	public function vendre($qte) {
		if ($qte <= $this->_qte) {
			$this->setQte($this->qte()-$qte);
			$message = "<p>La vente a eu lieu</p>";
			return $message;
		} else {
			trigger_error('Vous ne pouvez pas vendre plus que vous n\'avez', E_USER_WARNING);
			return;
		}
		
	}
}
?>