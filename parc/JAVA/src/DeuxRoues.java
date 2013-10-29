
public class DeuxRoues extends Vehicule{

	private int cylindre;

	public int getCylindre() {
		return this.cylindre;
	}

	public void setCylindre(int cylindre) {
		this.cylindre = cylindre;
	}
	
	public DeuxRoues()
	{
		this.setMarque("");
		this.setMatricule("");
		this.setCylindre(0);
	}
	
	public DeuxRoues(String marque, String matricule, int cylindre)
	{
		this.setMarque(marque);
		this.setMatricule(matricule);
		this.setCylindre(cylindre);
	}
	
	public void saisir()
	{
		super.saisir();
		System.out.println("\nSaisir la cylindre -> ");
        this.setCylindre(Console.saisirInt());
	}
	
	public void afficher()
	{
		super.afficher();
		System.out.println("\n\tCylindre : " + this.getCylindre());
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
		xml += "\t<cylindre>\n";
		xml += "\t\t" + this.getCylindre() + "\n";
		xml += "\t</cylindre>\n";
		xml += "</informations>";
		return xml;
	}
}
