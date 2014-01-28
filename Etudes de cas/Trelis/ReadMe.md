#Etude de cas - Trelis

####1] En observant le code fourni, expliquer les causes des dysfonctionnements actuels de la méthode toXML() de la classe Message.
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
	resultat ← resultat + "</code>"
```

**resultat ← resultat + "`<description>`" + description**  
**resultat ← resultat + "`</description>`"**

```
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


####2] Écrire la procédure afficherUnMessage() en prenant appui sur la description du cas d’utilisation
Instructions :
  
- Récupérer le code de zoneCode
- Vérifier s'il y un message avec ce code
- Si il y a un message, récupérer son XML et le placer dans la vue XML, sinon afficher une notification erreur dans le vueXML

Résultat : [Voir le fichier Code.java](https://github.com/miko91/cours/blob/master/Etudes%20de%20cas/Trelis/code.java)


####3]  Ecrire l'entête de la fonction estDiffusée() : nom de la fonction, nom(s) et type(s) des arguments éventuels, type de retour, le corps de cette fonction.

Résultat : [Voir le fichier Message.java](https://github.com/miko91/cours/blob/master/Etudes%20de%20cas/Trelis/message.java)

####4] Écrire la méthode messagesAyantDiffusions() de la classe Annonceur.

Résultat : [Voir le fichier Annonceur.java](https://github.com/miko91/cours/blob/master/Etudes%20de%20cas/Trelis/message.java)