
abstract public class Vehicule {

	protected String marque, matricule;
	
	
	/**
	 * Fonction Getter de la marque
	 * @return String marque La marque du vŽhicule
	 */
	public String getMarque() {
		return this.marque;
	}
	
	/**
	 * Setter de la marque
	 * @param marque String la marque a enregistrer
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	
	/**
	 * 	Constructeurs
	 **/
	public Vehicule()
	{
		this.setMarque("");
		this.setMatricule("");
	}
	
	public Vehicule(String marque, String matricule)
	{
		this.setMarque(marque);
		this.setMatricule(matricule);
	}
	
	
	public void saisir()
	{
		System.out.println("\nSaisir la marque -> ");
        this.setMarque(Console.saisirString());
        System.out.println("\nSaisir le matricule -> ");
        this.setMatricule(Console.saisirString());
	}
	
	public void afficher()
	{
		System.out.println("\n\tMarque : " + this.getMarque());
		System.out.println("\n\tMatricule : " + this.getMatricule());
	}
	
	abstract public String toXML();
	
}
