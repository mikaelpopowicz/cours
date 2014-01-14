/**
*	Question A
*/
public class MiniExcurtionPayante extends MiniExcurtion
{
	private float prix;
	
	public MiniExcurtionPayante(int unNumMiniExcursion, String unLibelleMiniExcursion, int unNombrePlaces, float prix)
	{
		super(unNumMiniExcursion, unLibelleMiniExcursion, unNombrePlaces);
		this.setPrix(prix);
	}
	
	public void setPrix(float prix) { this.setPrix(prix); }
	public float getPrix() { return this.prix; }
}

/**
*	Question B
*/
public class MiniExcurtionPlanifiee
{
	private MiniExcursion laMiniExcursion;
	private Heure heureDepart;
	private int nombreInscrits;
	
	public MiniExcurtionPlanifiee(MiniExcursion uneMiniExcursion, Heure uneHeureDepart)
	{
		this.setLaMiniExcursion(uneMiniExcursion);
		this.setHeureDepart(uneHeureDepart);
		this.setNombreInscrits(0);
	}
	
	public void setLaMiniExcursion(MiniExcursion uneMiniExcursion) { this.laMiniExcursion = uneMiniExcursion; }
	public void setHeureDepart(Heure uneHeureDepart) { this.heureDepart = uneHeureDepart; }
	public void setNombreInscrits(int nbI) { this.nombreInscrits = nbI; }
	
	public boolean estComplete()
	{
		if(this.laMiniExcursion.getNombrePlaces() == this.nombreInscrits) ? return true : false;
	}	
}

/**
*	Quesiton C
*/
public class MiniExcursion
{
	private int numMiniExcursion;
	private String libelleMiniExcursion;
	private int nombrePlaces;
	private LinkedList<Etape> lesEtapes;
	
	public MiniExcursion(int unNumMiniExcursion, String unLibelleMiniExcursion, int unNombrePlaces)
	{
		this.setNumMiniExcursion(unNumMiniExcursion);
		this.setLibelleMiniExcursion(unLibelleMiniExcursion);
		this.setNombrePlaces(unNombrePlaces);
		this.lesEtapes = new LinkedList<Etape>();
	}
	
	/**
	*	Setters & Getters
	*/
	
	public void setNumMiniExcursion(int num) { this.numMiniExcursion = num; }
	public void setLibelleMiniExcursion(String libelle) { this.libelleMiniExcursion = libelle; }
	public void setNombrePlaces(int nbP) { this.nombrePlaces = nbP; }
	
	public int getNombrePlaces() { return this.nombrePlaces; }
	
	
	
	/**
	*	Méthodes de la classe
	*/
	
	public void afficher_les_etapes()
	{
		for(Etape et : this.lesEtapes) {
			et.afficher();
		}
	}
	
	public Etape Etape_la_plus_longue()
	{
		int duree = 0;
		int index = 0;
		for(Etape uneEtape : this.lesEtapes) {
			if(uneEtape.getDureePrevue() > duree) {
				duree = uneEtape.getDureePrevue();
				index = this.lesEtapes.indexOf(uneEtape);
			}
		}
		return this.lesEtapes.get(index);
	}
	
	public donneDureePrevue()
	{
		int duree = 0;
		for(Etape et : this.lesEtapes) {
			duree += et.getDureePrevue();
		}
		return duree;
	}
	
	public String donneDureePrevuehhmm()
	{
		return Temps.conversion_hhmm(this.donneDureePrevue());
	}
	
	public boolean ajouteEtape(int unNumEtape, String uneDescription, int uneDureePrevue)
	{
		Etape uneEtape = new Etape(unNumEtape, uneDescription, uneDureePrevue);
		if(this.lesEtapes.contains(uneEtape)) {
			return false;
		} else {
			this.lesEtapes.add(uneEtape);
			return true;
		}
	}
	
}