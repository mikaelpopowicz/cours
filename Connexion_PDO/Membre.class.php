<?php
class Membre
{
	private $id,
	$email,
	$nom,
	$prenom,
	$password,
	$token;
	
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
	
	public function setId($id)
	{
		$this->id = $id;
	}
	
	public function setEmail($email)
	{
		$this->email = $email;
	}
	
	public function setNom($nom)
	{
		$this->nom = $nom;
	}
	
	public function setPrenom($prenom)
	{
		$this->prenom = $prenom;
	}
	
	public function setPassword($password)
	{
		$this->password = $password;
	}
	
	public function setToken($token)
	{
		$this->token = $token;
	}
	
	public function setActive($active)
	{
		$this->active = $active;
	}
	
	public function id() { return $this->id; }
	public function email() { return $this->email; }
	public function nom() { return $this->nom; }
	public function prenom() { return $this->prenom; }
	public function password() { return $this->password; }
	public function token() { return $this->token; }
	public function active() { return $this->active; }
}
?>