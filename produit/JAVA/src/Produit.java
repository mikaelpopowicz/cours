import java.util.Scanner;

public class Produit {
	private int ref, qte;
	private String designation;
	private float prix;

	
	/*
	 *  @@ Constructeur
	 */
	
	public Produit(int ref, int qte, float prix, String des) {
		this.setRef(ref);
		this.setQte(qte);
		this.setPrix(prix);
		this.setDes(des);
	}
	
	
	/*
	 *  @@ Getters
	 */
	
	public int ref() { return this.ref; }
	public int qte() { return this.qte; }
	public String des() { return this.designation; }
	public float prix() { return this.prix; }
	
	
	/*
	 *  @@ Setters
	 */
	
	public void setRef(int ref) {
		this.ref = ref;
	}
	
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	public void setDes(String des) {
		this.designation = des;
	}
	
	public void setPrix(Float prix) {
		this.prix = prix;
	}
	
	
	
	/*
	 *  @@ Fonctions suppl�mentaires
	 */
	
	void saisir() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nSaisir une r�f�rence -> ");
		this.setRef(sc.nextInt());
		System.out.println("\nSaisir une quantit� -> ");
		this.setQte(sc.nextInt());
		System.out.println("\nSaisir une d�signation -> ");
		this.setDes(sc.next());
		System.out.println("\nSaisir un prix -> ");
		this.setPrix(sc.nextFloat());
	}
	
	void menu() {
		int choix;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n\t--------------- Menu ---------------");
			System.out.println("\n\t- 1 - Saisie d'un nouveau produit  -");
			System.out.println("\n\t- 2 - Afficher                     -");
			System.out.println("\n\t- 3 - Total CA                     -");
			System.out.println("\n\t- 4 - Approvisionner               -");
			System.out.println("\n\t- 5 - Vendre                       -");
			System.out.println("\n\t- 0 - Quitter                      -");
			System.out.println("\n\t------------------------------------");
			System.out.println("\n\n\tVotre choix -> ");
			choix = sc.nextInt();
			switch (choix) {
				case 1: this.saisir();break;
				case 2: System.out.println(this.afficher());break;
				case 3: System.out.println("Le total du CA est de : "+this.total_prix()+" �");break;
				case 4: {
					System.out.println("Saisir une valeur � approvisioner \n");
					this.approvisionner(sc.nextInt());
				}break;
				case 5: {
					System.out.println("Saisir une quantit� � vendre \n");
					System.out.println(this.vendre(sc.nextInt()));
				}
			}
		} while (choix != 0);
	}
	
	public String afficher() {
		String aff = "";
		aff += "R�f�rence: "+this.ref()+"\n";
		aff += "Quantit�: "+this.qte()+"\n";
		aff += "Description: "+this.des()+"\n";
		aff += "Prix: "+this.prix()+"\n";
		return aff;
	}
	
	public float total_prix() {
		float total = this.prix()*this.qte();
		return total;
	}
	
	public void approvisionner(int qte) {
		this.setQte(this.qte()+qte);
	}
	
	public String vendre(int qte) {
		if (qte < this.qte()) {
			this.setQte(this.qte()-qte);
			return "\nLa vente a eu lieu";
		}
		return "\nLa vente n'a pas eu lieu";
	}
	
	public static void main(String[] args) {
		//Creation d'un objet Produit
		Produit test = new Produit(1, 15, 575, "Un produit de fou");
		
		//Affichage du menu
		test.menu();
	}
}

