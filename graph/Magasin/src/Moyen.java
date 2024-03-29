
public class Moyen extends Produit {

	private boolean solde;
	private double percent;
	
	public Moyen() {
		super();
		this.setSolde(false);
		this.setPercent(0);
	}

	public Moyen(String ref, String nom, double prix, double prixF, boolean solde, double percent) {
		super(ref, nom, prix, prixF);
		this.setSolde(solde);
		this.setPercent(percent);
		if(solde == true && percent > 0) {
			this.setPrixFinal(prix*(1-(percent/100)));
		} else {
			this.setPrixFinal(prix);
		}
	}
	
	public void setSolde(boolean solde) {
		this.solde = solde;
	}
	
	public void setPercent(double percent) {
		this.percent = percent;
	}
	
	public boolean getSolde() { return this.solde; }
	public double getPercent() { return this.percent; }
	
	
	public String toString() {
		String chaine = super.toString();
		
		chaine += "\nSolde : "+(this.getSolde() == true ? "Oui" : "Non");
		chaine += "\nPourcentage : "+this.getPercent()+" %";
		chaine += "\nPrix final : "+this.getPrixFinal()+" �";
		
		return chaine;
	}
}
