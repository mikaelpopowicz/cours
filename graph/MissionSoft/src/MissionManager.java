import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;



public class MissionManager extends Manager {

	public MissionManager(BDD uneBdd) {
		super(uneBdd);
		
	}
	
	public LinkedList<Mission> getList() {
		LinkedList<Mission> liste = new LinkedList<Mission>();
		
		try {
			// Connexion à la BDD
			this.getConnexion().seConnecter();
			
			// Execution de la requête
			Statement state = this.getConnexion().getMaConnexion().createStatement();
			ResultSet result = state.executeQuery(this.getSql());
			
			// Boucle pour remplir le tableau avec de nouveau véhicules
			while(result.next()) {
				int id = result.getInt("id_m");
				String nom = result.getString("nom");
				String desc = result.getString("description");
				int nbh = result.getInt("nbHeuresPrevues");
				int inter = result.getInt("id_i");
				Mission mission = new Mission(id, nom, desc, nbh, inter);
				liste.add(mission);
				liste.
			}
			
			// Fermeture de la connexion, de l'état et du résultat
			this.getConnexion().seDeconnecter();
			state.close();
			result.close();
			
		} catch (SQLException e) {
			//System.out.println("\nErreur de construction du tableau : "+e.getMessage());
			System.out.println(e.getMessage());
		}
		
		return liste;
	}

}
