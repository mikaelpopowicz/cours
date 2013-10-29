
public class Utilitaire extends Vehicule {
	
	private float poidVide, charge;
	
	
	public float getPoidVide() {
		return this.poidVide;
	}


	public void setPoidVide(float poidVide) {
		this.poidVide = poidVide;
	}


	public float getCharge() {
		return this.charge;
	}


	public void setCharge(float charge) {
		this.charge = charge;
	}

	public Utilitaire()
	{
		this.setMarque("");
		this.setMatricule("");
		this.setPoidVide(0);
		this.setCharge(0);
	}
	
	public Utilitaire(String marque, String matricule, float poidVide, float charge)
	{
		this.setMarque(marque);
		this.setMatricule(matricule);
		this.setPoidVide(poidVide);
		this.setCharge(charge);
	}
	
	public void saisir()
	{
		super.saisir();
		super.saisir();
		System.out.println("\nSaisir le poids a vide -> ");
        this.setPoidVide(Console.saisirFloat());
        System.out.println("\nSaisir la charge -> ");
        this.setCharge(Console.saisirFloat());
	}
	
	public void afficher()
	{
		super.afficher();
		System.out.println("\n\tPoids ˆ vide : " + this.getPoidVide());
		System.out.println("\n\tCharge : " + this.getCharge());
	}

	public String toXML()
	{
		String xml = "";
		xml += "<?xml version='1.0' encoding='iso-8859-1' ?>\n";
		xml += "<informations>\n";
		xml += "\t<marque>\n";
		xml += "\t\t" + this.getMarque() + "\n";
		xml += "\t</marque>\n";
		xml += "\t<matricule>\n";
		xml += "\t\t" + this.getMatricule() + "\n";
		xml += "\t</matricule>\n";
		xml += "\t<poids-a-vide>\n";
		xml += "\t\t" + this.getPoidVide() + "\n";
		xml += "\t</poids-a-vide>\n";
		xml += "\t<charge>\n";
		xml += "\t\t" + this.getCharge() + "\n";
		xml += "\t</charge>\n";
		xml += "</informations>";
		return xml;
	}

}
