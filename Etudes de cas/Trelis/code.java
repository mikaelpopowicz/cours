void afficherUnMessage(Annonceur unAnnonceur)
{
	if(unAnnonceur.existe(zoneCode.getText()) == true)
	{
		vueXML.setText(unAnnonceur.getMessage(code).toXML());
	}
	else
	{
		vueXML.setText("Erreur, aucun résultat");
	}
}