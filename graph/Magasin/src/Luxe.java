
public class Luxe extends Produit {
	
	
	private double note; //De 1 ˆ 5

	
	public Luxe() {
		super();
		this.setNote(0);
	}
	
	public Luxe(String ref, String nom, double prix, double prixF, double note) {
		super(ref, nom, prix, prixF);
		this.setNote(note);
		this.setPrixFinal(prix*(1+(note/10)));
	}
	
	public void setNote(double note) {
		this.note = note;
	}
	
	public double getNote() { return this.note; }
	
	public String toString() {
		String chaine = super.toString();
		
		chaine += "\nNote : "+this.getNote();
		chaine += "\nPrix final : "+this.getPrixFinal()+" Û";
		
		return chaine;
	}

}
