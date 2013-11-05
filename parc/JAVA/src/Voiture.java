
public class Voiture extends Vehicule {

	private int nbPlace;
	private String couleur;
	
	
	public int getNbPlace() {
		return this.nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public String getCouleur() {
		return this.couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Voiture()
	{
		this.setMarque("");
		this.setMatricule("");
		this.setNbPlace(0);
		this.setCouleur("");
	}
	
	public Voiture(String marque, String matricule, int nbPlace, String couleur)
	{
		this.setMarque(marque);
		this.setMatricule(matricule);
		this.setNbPlace(nbPlace);
		this.setCouleur(couleur);
	}
	
	public void saisir()
	{
		super.saisir();
		System.out.println("\nSaisir le nombre de place -> ");
        this.setNbPlace(Console.saisirInt());
        System.out.println("\nSaisir la couleur -> ");
        this.setCouleur(Console.saisirString());
	}
	
	public void afficher()
	{
		super.afficher();
		System.out.println("\n\tNombre de place : " + this.getNbPlace());
		System.out.println("\n\tCouleur : " + this.getCouleur());
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
		xml += "\t<nombre-de-place>\n";
		xml += "\t\t" + this.getNbPlace() + "\n";
		xml += "\t</nombre-de-place>\n";
		xml += "\t<couleur>\n";
		xml += "\t\t" + this.getCouleur() + "\n";
		xml += "\t</couleur>\n";
		xml += "</informations>";
		return xml;
	}
	
}