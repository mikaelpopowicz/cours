package Library;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import Entities.Constructeur;
import Entities.Vehicule;

public class ConstructeurManager extends Manager{

	public ConstructeurManager(BDD uneBDD) {
		super(uneBDD);
	}

	public LinkedList<Constructeur> getList() {
		LinkedList<Constructeur> liste = new LinkedList<Constructeur>();
		this.setSql("SELECT * FROM constructeur;");
		
		try {
			// Connexion à la BDD
			this.getConnexion().seConnecter();
			
			// Execution de la requête
			Statement state = this.getConnexion().getMaConnexion().createStatement();
			ResultSet result = state.executeQuery(this.getSql());
			
			// Boucle pour remplir le tableau avec de nouveau véhicules
			while(result.next()) {
				int id = result.getInt("id_const");
				String nom = result.getString("nom");
				String debut = result.getString("debut");
				String temp [] = debut.split("-");
				String fin = result.getString("fin");
				String prixFactureMO = result.getString("prixFactureMO");
				Projet projet = new Projet(id, nom, pays, statut);
				liste.add(constructeur);
			}
			
			// Fermeture de la connexion, de l'état et du résultat
			this.getConnexion().seDeconnecter();
			state.close();
			result.close();
			
		} catch (SQLException e) {
			//System.out.println("\nErreur de construction du tableau : "+e.getMessage());
		}
		
		return liste;
	}
}
