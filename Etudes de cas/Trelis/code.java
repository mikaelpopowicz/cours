void afficherUnMessage(Annonceur unAnnonceur)
{
	String code;
	code = zoneCode.getText();
	
	if(unAnnonceur.existe(code) == true)
	{
		vueXML.setText(unAnnonceur.getMessage(code).toXML());
	}
	else
	{
		vueXML.setText("Erreur, aucun résultat");
	}
}