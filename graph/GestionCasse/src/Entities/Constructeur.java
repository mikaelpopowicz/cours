package Entities;

public class Constructeur {

	private int id;
	private String nom, pays, statut;
	
	public Constructeur() {
		this.setId(0);
		this.setNom("");
		this.setPays("");
		this.setStatut("");
	}
	
	public Constructeur(String nom, String pays, String statut) {
		this.setNom(nom);
		this.setPays(pays);
		this.setStatut(statut);
	}

	public int getId() { return this.id; }
	public String getNom() { return this.nom; }
	public String getPays() { return this.pays; }
	public String getStatut() { return this.statut; }
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	public void setStatut(String statut) {
		this.statut = statut;
	}
	
}
