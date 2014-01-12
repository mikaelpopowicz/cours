

import java.util.HashMap;

public class Mission {

	private String nom, description;
	private int nbHeuresPrevues;
	private HashMap<Date, Integer> releveHoraire;
	private Intervenant executant;
	
	public Mission() {
		this.setNom("");
		this.setDescription("");
		this.setNbHeuresPrevues(0);
		this.setReleveHoraire(new HashMap<Date, Integer>());
		this.setExecutant(new Intervenant());
	}
	
	public Mission(String nom, String desc, int nbh, HashMap<Date, Integer> releve, Intervenant executant) {
		this.setNom(nom);
		this.setDescription(desc);
		this.setNbHeuresPrevues(nbh);
		this.setReleveHoraire(releve);
		this.setExecutant(executant);
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public void setNbHeuresPrevues(int nbh) {
		this.nbHeuresPrevues = nbh;
	}
	
	public void setReleveHoraire(HashMap<Date, Integer> releve) {
		this.releveHoraire = releve;
	}
	
	public void setExecutant(Intervenant executant) {
		this.executant = executant;
	}
	
	public String getNom() { return this.nom; }
	public String getDescription() { return this.description; }
	public int getNbHeuresPrevues() { return this.nbHeuresPrevues; }
	public HashMap<Date, Integer> getReleveHoraire() { return this.releveHoraire; }
	public Intervenant getExecutant() { return this.executant; }
	
	public void ajoutReleve(Date uneDate, int nbh) {
		if (this.releveHoraire.containsKey(uneDate) == true) {
			nbh += this.releveHoraire.get(uneDate);
		}
		if (nbh <= 8) {
			this.releveHoraire.put(uneDate, new Integer(nbh));
		} else {
			this.releveHoraire.put(uneDate, new Integer(8));
		}
	}

	public int nbHeuresEffectuees() {
		int nbh = 0;
		for (Date uneDate : this.releveHoraire.keySet()) {
			nbh += this.releveHoraire.get(uneDate);
		}
		return nbh;
	}
}
