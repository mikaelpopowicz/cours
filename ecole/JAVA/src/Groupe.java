import java.util.LinkedList;


public class Groupe {

	private String nom, salle;
	private int idGroupe;
	private LinkedList<Eleve> mesEleves;	
	
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSalle() {
		return this.salle;
	}

	public void setSalle(String salle) {
		this.salle = salle;
	}

	public int getIdGroupe() {
		return this.idGroupe;
	}

	public void setIdGroupe(int idGroupe) {
		this.idGroupe = idGroupe;
	}

	public LinkedList<Eleve> getMesEleves() {
		return this.mesEleves;
	}

	public void setMesEleves(LinkedList<Eleve> mesEleves) {
		this.mesEleves = mesEleves;
	}

	public Groupe() {
		this.setNom("");
		this.setSalle("");
		this.setIdGroupe(0);
		this.setMesEleves(new LinkedList<Eleve>());
	}
	
	public Groupe(String nom, String prenom, int id) {
		this.setNom(nom);
		this.setSalle(salle);
		this.setIdGroupe(id);
		this.setMesEleves(new LinkedList<Eleve>());
	}
	
	public void saisir() {
		System.out.println("\nDonnez l'ID du groupe : ");
		this.setIdGroupe(Console.saisirInt());
		System.out.println("\nDonnez le nom : ");
		this.setNom(Console.saisirString());
		System.out.println("\nDonnez la salle : ");
		this.setSalle(Console.saisirString());
		
	}
	
	public void afficher() {
		System.out.println("\nId groupe : " + this.getIdGroupe());
		System.out.println("\nNom : " + this.getNom());
		System.out.println("Salle : " + this.getSalle());
		System.out.println("Nombre d'eleves : " + this.getMesEleves().size());
	}

	String toXml() {
		String xml = "";
		xml += "\n\t\t\t<groupe>";
		xml += "\n\t\t\t\t<nom>";
		xml += "\n\t\t\t\t\t"+this.getNom();
		xml += "\n\t\t\t\t</nom>";
		xml += "\n\t\t\t\t<salle>";
		xml += "\n\t\t\t\t</salle>";
		xml += "\n\t\t\t\t<id>";
		xml += "\n\t\t\t\t</id>";
		xml += "\n\t\t\t\t<eleves>";
		for (int i = 0; i < this.mesEleves.size(); i++) {
			xml += this.getMesEleves().get(i).toXml();
		}
		xml += "\n\t\t\t\t</eleves>";
		xml += "\n\t\t\t<groupe>";
		return xml;
	}
	
}