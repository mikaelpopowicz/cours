import java.util.LinkedList;


public class Ecole {

	
	private String nom;
	private LinkedList<Filiere> mesFilieres;
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public LinkedList<Filiere> getMesFilieres() {
		return this.mesFilieres;
	}
	public void setMesFilieres(LinkedList<Filiere> mesFilieres) {
		this.mesFilieres = mesFilieres;
	}
	
	
	public Ecole() {
		this.setNom("");
		this.setMesFilieres(new LinkedList<Filiere>());
	}
	
	public Ecole(String nom) {
		this.setNom(nom);
		this.setMesFilieres(new LinkedList<Filiere>());
	}
	
	public void saisir() {
		System.out.println("\nDonnez le nom : ");
		this.setNom(Console.saisirString());
	}
	
	public void afficher() {
		System.out.println("\nNom : " + this.getNom());
	}
	
	public String toString() {
		String result = "";
		result += "\n\t\t\t\tEcole : " + this.getNom();
		for(int i = 0; i < this.getMesFilieres().size(); i++) {
			result += this.getMesFilieres().get(i).toString();
		}
		return result;
	}
	
	public String toXml() {
		String xml = "";
		xml += "<?xml version='1.0' encoding='iso-8859-1' ?>";
		xml += "\n<Ecole>";
		xml += "\n\t<nom>";
		xml += "\n\t" + this.getNom();
		xml += "\n\t</nom>";
		xml += "\n\t<filieres>";
		for(int i = 0; i < this.getMesFilieres().size(); i++) {
			xml += this.getMesFilieres().get(i).toXml();
		}
		xml += "\n\t</filieres>";
		xml += "\n</Ecole>";
		return xml;
	}
	
	public void ajouter() {
		Filiere uneF = new Filiere();
		uneF.saisir();
		this.getMesFilieres().add(uneF);
		System.out.println("\nUpdate success !");
	}
	
	public void menu() {
		int choix;
		do {
			System.out.println("\n------------ MENU ------------");
			System.out.println("\n-- 1 - Saisir               --");
			System.out.println("\n-- 2 - Afficher             --");
			System.out.println("\n-- 3 - Ajouter une filiere  --");
			System.out.println("\n-- 4 - Liste des filieres   --");
			System.out.println("\n-- 5 - Gerer une filiere    --");
			System.out.println("\n-- 6 - XML                  --");
			System.out.println("\n-- 0 - Quitter              --");
			System.out.println("\n------------------------------");
			choix = Console.saisirInt();
			switch (choix) {
			case 1:	this.saisir(); break;
			case 2: this.afficher(); break;
			case 3: this.ajouter(); break;
			case 4: System.out.println(this.toString()); break;
			case 5: {
				System.out.println("\nVeuillez donnez le numero de la filiere a gerer : ");
				this.getMesFilieres().get(Console.saisirInt()).menu();
			}
			case 6: System.out.println(this.toXml()); break;

			default:
				break;
			}
		} while (choix != 0);
	}
	
	public static void main(String args[]) {
		
		Ecole uneEcole = new Ecole();
		uneEcole.menu();
	}
}
