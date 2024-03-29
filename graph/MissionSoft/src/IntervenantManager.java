import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;



public class IntervenantManager extends Manager {

	public IntervenantManager(BDD uneBdd) {
		super(uneBdd);
		
	}
	
	public LinkedList<Intervenant> getList() {
		LinkedList<Intervenant> liste = new LinkedList<Intervenant>();
		
		try {
			// Connexion � la BDD
			this.getConnexion().seConnecter();
			
			// Execution de la requ�te
			Statement state = this.getConnexion().getMaConnexion().createStatement();
			ResultSet result = state.executeQuery(this.getSql());
			
			// Boucle pour remplir le tableau avec de nouveau v�hicules
			while(result.next()) {
				int id = result.getInt("id_m");
				String nom = result.getString("nom");
				String prenom = result.getString("prenom");
				float taux = result.getFloat("tauxHoraire");
				Intervenant inter = new Intervenant(id, nom, prenom, taux);
				liste.add(inter);
			}
			
			// Fermeture de la connexion, de l'�tat et du r�sultat
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
