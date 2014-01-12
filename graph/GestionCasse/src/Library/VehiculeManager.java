package Library;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import Entities.Vehicule;

public class VehiculeManager extends Manager {
	
	public VehiculeManager(BDD uneBdd) {
		super(uneBdd);
	}

	public void add(Vehicule veh) {
		// Requ�te d'insertion
		this.setSql("INSERT INTO vehicule (id_const ,matricule, couleur, km) VALUES " +
				"("+veh.getId_const()+",'"+veh.getMatricule()+"','"+veh.getCouleur()+"',"+veh.getNbKm()+");");
		try {
			// Connexion � la BDD
			this.getConnexion().seConnecter();
			
			// Execution de la requ�te
			Statement state = this.getConnexion().getMaConnexion().createStatement();
			state.execute(this.getSql());
			
			// Fermeture de la connexion et de l'�tat
			this.getConnexion().seDeconnecter();
			state.close();
		
		} catch (SQLException e) {
			System.out.println("Erreur : "+e.getMessage());
		}
	}
	
	public LinkedList<Vehicule> getList() {
		LinkedList<Vehicule> liste = new LinkedList<Vehicule>();
		this.setSql("SELECT * FROM vehicule;");
		
		try {
			// Connexion � la BDD
			this.getConnexion().seConnecter();
			
			// Execution de la requ�te
			Statement state = this.getConnexion().getMaConnexion().createStatement();
			ResultSet result = state.executeQuery(this.getSql());
			
			// Boucle pour remplir le tableau avec de nouveau v�hicules
			while(result.next()) {
				int id = result.getInt("id_veh");
				String matricule = result.getString("matricule");
				String couleur = result.getString("couleur");
				int nbKm = result.getInt("km");
				int id_const = result.getInt("id_const");
				Vehicule vehicule = new Vehicule(id, matricule, couleur, nbKm, id_const);
				liste.add(vehicule);
			}
			
			// Fermeture de la connexion, de l'�tat et du r�sultat
			this.getConnexion().seDeconnecter();
			state.close();
			result.close();
			
		} catch (SQLException e) {
			//System.out.println("\nErreur de construction du tableau : "+e.getMessage());
		}
		
		return liste;
	}
	
	public void del(Vehicule veh) {
		this.setSql("DELETE FROM vehicule WHERE id_veh = '"+veh.getId()+"';");
		try {
			this.getConnexion().seConnecter();
			Statement unState = this.getConnexion().getMaConnexion().createStatement();
			unState.execute(this.getSql());
			this.getConnexion().seDeconnecter();
			unState.close();
		} catch (SQLException exp) {
			System.out.println("La suppression n'a pas fonctionn�e :"+exp.getMessage());
		}
	}
		

}
