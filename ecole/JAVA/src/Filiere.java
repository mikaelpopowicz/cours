import java.util.LinkedList;


public class Filiere {
	
	private String responsable, nom, diplome;
	private LinkedList<Groupe> mesGroupes;
	public String getResponsable() {
		return this.responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDiplome() {
		return this.diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public LinkedList<Groupe> getMesGroupes() {
		return this.mesGroupes;
	}
	public void setMesGroupes(LinkedList<Groupe> mesGroupes) {
		this.mesGroupes = mesGroupes;
	}
	
	
	
	public Filiere() {
		this.setNom("");
		this.setResponsable("");
		this.setDiplome("");
		this.setMesGroupes(new LinkedList<Groupe>());
	}
	
	public Filiere(String nom, String responsable, String diplome) {
		this.setNom(nom);
		this.setResponsable(responsable);
		this.setDiplome(diplome);
		this.setMesGroupes(new LinkedList<Groupe>());
	}
	
	
	public void saisir() {
		System.out.println("\nDonner le nom de la filiere : ");
		this.setNom(Console.saisirString());
		System.out.println("\nDonner le nom du responsable : ");
		this.setResponsable(Console.saisirString());
		System.out.println("\nDonner le diplome : ");
		this.setDiplome(Console.saisirString());
	}
	
	public void afficher() {
		System.out.println("\nNom : " + this.getNom());
		System.out.println("\nResponsable : " + this.getResponsable());
		System.out.println("\nDiplome : " + this.getDiplome());
		System.out.println("\nNombre de groupe : " + this.getMesGroupes().size());
	}
	
	public String toString() {
		String result = "";
		result += "\n\t\tFiliere " + this.getNom() + " (" + this.getDiplome() + ")";
		for(int i = 0; i < this.getMesGroupes().size(); i++) {
			result += this.getMesGroupes().get(i).toString();
		}
		return result;
	}
	
	public String toXml() {
		String xml = "";
		xml += "\n\t\t<filiere>";
		xml += "\n\t\t\t<nom>";
		xml += "\n\t\t\t\t" + this.getNom();
		xml += "\n\t\t\t</nom>";
		xml += "\n\t\t\t<responsable>";
		xml += "\n\t\t\t\t" + this.getResponsable();
		xml += "\n\t\t\t</responsable>";
		xml += "\n\t\t\t<diplome>";
		xml += "\n\t\t\t\t" + this.getDiplome();
		xml += "\n\t\t\t</diplome>";
		xml += "\n\t\t\t<groupes>";
		for(int i = 0; i < this.getMesGroupes().size(); i++) {
			this.getMesGroupes().get(i).toXml();
		}
		xml += "\n\t\t\t</groupes>";
		xml += "\n\t\t</filiere>";
		return xml;
	}

}
