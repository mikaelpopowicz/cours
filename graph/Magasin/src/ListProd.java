
public enum ListProd {

	A1("LX_01", "Montre en Or", "Luxe", 199.95, 4, false, 0, 0),
	A2("LX_02", "uPhone", "Luxe", 199.95, 4, false, 0, 0),
	A3("LX_03", "UPad", "Luxe", 199.95, 4, false, 0, 0),
	A4("LX_04", "WindoPhone", "Luxe", 199.95, 4, false, 0, 0),
	A5("LX_05", "Nom", "Luxe", 199.95, 4, false, 0, 0),
	A6("LX_06", "Nom", "Luxe", 199.95, 4, false, 0, 0),
	A7("LX_07", "Nom", "Luxe", 199.95, 4, false, 0, 0),
	A8("LX_08", "Nom", "Luxe", 199.95, 4, false, 0, 0),
	A9("LX_09", "Nom", "Luxe", 199.95, 4, false, 0, 0),
	B1("MY_01", "Nom", "Moyen", 199.95, 4, false, 0, 0),
	B2("MY_02", "Nom", "Moyen", 199.95, 4, false, 0, 0),
	B3("MY_03", "Nom", "Moyen", 199.95, 4, false, 0, 0),
	B4("MY_04", "Nom", "Moyen", 199.95, 4, false, 0, 0),
	B5("MY_05", "Nom", "Moyen", 199.95, 4, false, 0, 0),
	B6("MY_06", "Nom", "Moyen", 199.95, 4, false, 0, 0),
	B7("MY_07", "Nom", "Moyen", 199.95, 4, false, 0, 0),
	B8("MY_08", "Nom", "Moyen", 199.95, 4, false, 0, 0),
	B9("MY_09", "Nom", "Moyen", 199.95, 4, false, 0, 0),
	C1("PR_01", "Nom", "Pourri", 199.95, 4, false, 0, 0),
	C2("PR_02", "Nom", "Pourri", 199.95, 4, false, 0, 0),
	C3("PR_03", "Nom", "Pourri", 199.95, 4, false, 0, 0),
	C4("PR_04", "Nom", "Pourri", 199.95, 4, false, 0, 0),
	C5("PR_05", "Nom", "Pourri", 199.95, 4, false, 0, 0),
	C6("PR_06", "Nom", "Pourri", 199.95, 4, false, 0, 0),
	C7("PR_07", "Nom", "Pourri", 199.95, 4, false, 0, 0),
	C8("PR_08", "Nom", "Pourri", 199.95, 4, false, 0, 0),
	C9("PR_09", "Nom", "Pourri", 199.95, 4, false, 0, 0);
	
	
	private String ref, name, cat;
	private double prix, note;
	private boolean solde;
	private double percent, pourri;
	
	ListProd(String ref, String name, String cat, double prix, double note, boolean solde, double percent, double pourri) {
		this.ref = ref;
		this.name = name;
		this.cat = cat;
		this.prix = prix;
		this.note = note;
		this.solde = solde;
		this.percent = percent;
		this.pourri = pourri;
	}
	
	public String getRef() { return this.ref; }
	public String getName() { return this.name; }
	public String getCat() { return this.cat; }
	public double getPrix() { return this.prix; }
	public double getNote() { return this.note; }
	public boolean getSolde() { return this.solde; }
	public double getPercent() { return this.percent; }
	public double getPourri() { return this.pourri; }
	
}
