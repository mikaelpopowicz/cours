public class Compte {

	protected String nom, prenom;
	protected int numero;
	protected float solde;
	
	/*
	 *  @@ Constructeur
	 */
	public Compte() {
		this.setNom("");
		this.setPrenom("");
		this.setSolde(0);
		this.setNumero(0);
	}
	
	public Compte(String nom, String prenom, int numero, float solde) {
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setNumero(numero);
		this.setSolde(solde);
	}
	
	public Compte(Compte compte) {
		this.setNom(compte.getNom());
		this.setPrenom(compte.getPrenom());
		this.setNumero(compte.getNumero());
		this.setSolde(compte.getSolde());
	}
	
	
	
	/*
	 *  @@ Getters
	 */
	
	public String getNom() { return this.nom; }
	public String getPrenom() { return this.prenom; }
	public int getNumero() { return this.numero; }
	public float getSolde() {return this.solde; }
	
	
	
	/*
	 *  @@ Setters
	 */
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void setSolde(float solde) {
		this.solde = solde;
	}
	
	
	
	/*
	 *  @@ Fonctions supplémentaires
	 */
	
	public void ouvrir() {

		System.out.println("\nSaisir votre nom -> ");
		this.setNom(Console.saisirString());
		System.out.println("\nSaisir votre prénom -> ");
		this.setPrenom(Console.saisirString());
		System.out.println("\nSaisir votre numéro de compte -> ");
		this.setNumero(Console.saisirInt());
		System.out.println("\nSaisir votre solde -> ");
		this.setSolde(Console.saisirFloat());
	}
	
	public void menu() {
		int choix;
		do {
			System.out.println("\n\t--------------- Menu ---------------");
			System.out.println("\n\t- 1 - Saisie d'un nouveau compte   -");
			System.out.println("\n\t- 2 - Afficher                     -");
			System.out.println("\n\t- 3 - Faire un dépot               -");
			System.out.println("\n\t- 4 - Faire un retrait             -");
			System.out.println("\n\t- 5 - Découvert ?                  -");
			System.out.println("\n\t- 0 - Quitter                      -");
			System.out.println("\n\t------------------------------------");
			System.out.println("\n\n\tVotre choix -> ");
			choix = Console.saisirInt();
			switch (choix) {
				case 1: this.ouvrir();break;
				case 2: this.afficher();break;
				case 3: {
					System.out.println("Saisir un montant à déposer \n");
					this.deposer(Console.saisirFloat());
				}break;
				case 4: {
					System.out.println("Saisir un montant à retirer \n");
					this.retirer(Console.saisirFloat());
				}break;
				case 5: System.out.println(this.estEnDecouvert());break;
			}
		} while (choix != 0);
	}
	
	public void afficher() {
		String aff;
		aff = "";
		aff += "\nCompte n° "+this.getNumero()+"\n";
		aff += this.getNom()+" "+this.getPrenom()+"\n";
		aff += "Solde : "+this.getSolde()+"\n";
		System.out.println(aff);
	}
	
	public void deposer(float montant) {
		this.setSolde(this.getSolde()+montant);
	}
	
	public void retirer(float montant) {
		this.setSolde(this.getSolde()-montant);
	}
	
	public String estEnDecouvert() {
		if (this.getSolde() < 0) {
			return "Votre compte est en découvert";
		} else if (this.getSolde() == 0) {
			return "Votre compte est vide";
		} else {
			return "Votre compte est en santé";
		}
	}
	
	public static void main(String[] args) {
		//Création d'un compte vide
		Compte test = new Compte();
		
		test.menu();
	}
	
 }
