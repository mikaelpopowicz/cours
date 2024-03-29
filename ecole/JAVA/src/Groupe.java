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
	
	public void ajouter() {
		Eleve unE = new Eleve();
		unE.saisir();
		this.getMesEleves().add(unE);
		System.out.println("\nUpdate success !");
	}
	
	public void listerEleves() {
		System.out.println("\nListe des eleves : ");
		for(int i = 0; i < this.getMesEleves().size(); i++) {
			System.out.println("\n[" + i + "]");
			this.getMesEleves().get(i).afficher();
		}
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
	
	public String toString() {
		String result = "";
		result += "\n\tGroupe : " + this.getNom() + "(" + this.getIdGroupe() + ")";
		for(int i = 0; i < this.getMesEleves().size(); i++) {
			result += this.getMesEleves().get(i).toString();
		}
		return result;
	}

	public String toXml() {
		String xml = "";
		xml += "\n\t\t\t\t<groupe>";
		xml += "\n\t\t\t\t\t<nom>";
		xml += "\n\t\t\t\t\t\t"+this.getNom();
		xml += "\n\t\t\t\t\t</nom>";
		xml += "\n\t\t\t\t\t<salle>";
		xml += "\n\t\t\t\t\t\t" + this.getSalle();
		xml += "\n\t\t\t\t\t</salle>";
		xml += "\n\t\t\t\t\t<id>";
		xml += "\n\t\t\t\t\t\t" + this.getIdGroupe();
		xml += "\n\t\t\t\t\t</id>";
		xml += "\n\t\t\t\t\t<eleves>";
		for(int i = 0; i < this.mesEleves.size(); i++) {
			xml += this.getMesEleves().get(i).toXml();
		}
		xml += "\n\t\t\t\t\t</eleves>";
		xml += "\n\t\t\t\t<groupe>";
		return xml;
	}
	
	public void menu() {
		int choix;
		do {
			System.out.println("\n------------ MENU ------------");
			System.out.println("\n-- 1 - Saisir               --");
			System.out.println("\n-- 2 - Afficher             --");
			System.out.println("\n-- 3 - Liste des eleves     --");
			System.out.println("\n-- 4 - Gerer un eleve       --");
			System.out.println("\n-- 5 - XML                  --");
			System.out.println("\n-- 0 - Quitter              --");
			System.out.println("\n------------------------------");
			choix = Console.saisirInt();
			switch (choix) {
			case 1:	this.saisir(); break;
			case 2: this.afficher(); break;
			case 3: this.toString(); break;
			case 4: {
				System.out.println("\nVeuillez donnez le numero de la filiere a gerer : ");
				this.getMesEleves().get(Console.saisirInt()).menu();
			}
			case 5: this.toXml(); break;

			default:
				break;
			}
		} while (choix != 0);
	}
}
