package Library;

public class Manager {

	private BDD connexion;
	private String sql;
	
	public Manager(BDD uneBdd) {
		this.setConnexion(uneBdd);
		this.setSql("");
	}
	
	public BDD getConnexion() { return this.connexion; }
	public String getSql() { return this.sql; }
	
	public void setConnexion(BDD uneBdd) {
		this.connexion = uneBdd;
	}
	
	public void setSql(String sql) {
		this.sql = "";
		this.sql =sql;
	}

}
