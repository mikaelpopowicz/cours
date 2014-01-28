#Etude de cas - Trelis

#####1] En observant le code fourni, expliquer les causes des dysfonctionnements actuels de la méthode toXML() de la classe Message.
Il manque la description dans la classe message, et dans la boucle ne va pas au bout de la collection

```
Fonction toXML() : chaîne
	resultat : chaîne 
	i : entier //variable de boucle
	nbDiffusions : entier
début
	resultat ← "<message>"
	// le + indique la concaténation de chaîne de caractères
	resultat ← resultat + "<code>" + code 
	__resultat ← resultat + "</code>"__
	__resultat ← resultat + "<description>" + description__
	resultat ← resultat + "</description>"
	resultat ← resultat + "<durée>" + duree.enChaine() 
	resultat ← resultat + "</durée>"
	i ← 1
	nbDiffusions ← lesDiffusions.cardinal()
	TantQue i <__=__ nbDiffusions Faire
		resultat ← resultat + lesDiffusions.extraireObjet(i).toXML()
		i ← i+1
	FTQ
	resultat ← resultat + "</message>"
	retourner resultat
fin
// la fonction enChaine()convertit un entier en chaîne de caractères

```
