public class Epargne extends Compte {
	private float taux;

	/**
	 * Constructeur
	 */
	public Epargne() {
		super();
		this.setTaux(0);
		
	}
	
	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}
	
	
}
