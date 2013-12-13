package Library;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;;


public class BDD {

	private String host, dbname, user, pass;
	private Connection maConnexion;
	
	
	public BDD() {
		this.setHost("");
		this.setDbname("");
		this.setUser("");
		this.setPass("");
		this.setMaConnexion(null);
	}
	
	public BDD(String host, String db, String user, String pass) {
		this.setHost(host);
		this.setDbname(db);
		this.setUser(user);
		this.setPass(pass);
		this.setMaConnexion(null);
	}

	
	public String getHost() { return this.host; }
	public String getDbname() { return this.dbname; }
	public String getUser() { return this.user; }
	public String getPass() { return this.pass; }
	public Connection getMaConnexion() { return this.maConnexion; }
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public void setDbname(String db) {
		this.dbname = db;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public void setMaConnexion(Connection connection) {
		this.maConnexion = connection;
	}
	
	public void chargerPilote() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException exp) {
			System.out.println("Erreur du chargement du pilote");
		}
	}
	
	/**
	 * Ouverture d'une connexion avec la BDD
	 */
	public void seConnecter() {
		this.chargerPilote();
		String url = "jdbc:mysql://"+this.getHost()+"/"+this.getDbname();
		try {
			this.setMaConnexion(DriverManager.getConnection(url, this.getUser(), this.getPass()));
		} catch (SQLException sql) {
			System.out.println("Erreur de connexion à la BDD");
		}
	}
	
	/**
	 * Fermeture de la connexion avec la BDD
	 */
	public void seDeconnecter() {
		try {
		this.getMaConnexion().close();
		} catch (SQLException sql) {
			System.out.println("Erreur de déconnexion");
		}
	}
}
