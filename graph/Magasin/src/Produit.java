
public abstract class Produit {

	private String ref;
	private String nom;
	private double prixBase;
	private double prixFinal;
	
	public Produit() {
		this.setRef("");
		this.setNom("");
		this.setPrixBase(0);
		this.setPrixFinal(0);
	}
	
	public Produit(String ref, String nom, double prix, double prixF) {
		this.setRef(ref);
		this.setNom(nom);
		this.setPrixBase(prix);
		this.setPrixFinal(prixF);
	}
	
	public void setRef(String ref) {
		this.ref = ref;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPrixBase(double prixBase) {
		this.prixBase = prixBase;
		this.prixBase = (double) Math.round(this.prixBase * 100) / 100;
	}
	
	public void setPrixFinal(double prixFinal) {
		this.prixFinal = prixFinal;
		this.prixFinal = (double) Math.round(this.prixFinal * 100) / 100;
	}
	
	public String getRef() { return this.ref; }
	public String getNom() { return this.nom; }
	public double getPrixBase() { return this.prixBase; }
	public double getPrixFinal() { return this.prixFinal; }
	
	
	public String toString() {
		String chaine = "";
		
		chaine += "\nProduit n� : "+this.getRef()+"\n";
		int temp = chaine.length() - 2;
		for(int i = 0; i < temp; i++) {
			chaine += "-";
		}
		chaine += "\nNom : "+this.getNom();
		chaine += "\nPrix de base : "+this.getPrixBase()+" �";
		
		return chaine;
	}
	
}
