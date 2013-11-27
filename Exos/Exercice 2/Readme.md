## [Exercice 2 - POO]()

###Introduction

Nous allons créer une classe compte. Un compte a pour attribut : un numéro de compte, le nom du propriétaire, le prénom du propriétaire et un solde.
Nous devons pouvoir créer le compte, le modifier et le supprimer. Il faut pouvoir effectuer des retraits et des dépots.

Les retraits et dépots pourront soit être effectués sur la page principale, soit sur des pages à part.


###Arborescence

```
poo2/ (dossier racine)
├── index.php
├── library/
	├── compte.class.php
├── fichiers à créer pour les formulaires (à décider soi même)
```

###Rôle des fichiers

####		- [compte.class.php]()
Il contiendra la classe compte, avec ses attributs et ses méthodes.

####		- [index.php]()
Fichier principal, contiendra l'affichage des informations ainsi qu'un formulaire ou l'accès au différents formulaires pour modifier le compte.

####		- [les fichiers de traitements]()
Créer ses propres fichiers de traitements pour les divers formulaires

Au vu de l'exercie, dans un premier temps, il faut se concentrer sur la page principale qui affichera les informations du compte. Pourquoi pas faire un menu haut dans la page pour acceder aux autres services (modification du compte, retrait, dépôt)


###Méthode

####Modifier l'objet
Nous avons vu dans nos classes comment coder les Setters et Getters.
Lorsque l'on veut affciher un attribut nous utilision un getters : exemple php

```
<?php
echo $monObjet->getMonAttribut();
?>
```

Pour la modification, cela n'est guere plus compliqué, il faut utiliser un formulaire et récupérer le contenu de la variable $_POST ou $_GET

Exemple :
```
<!-- Formulaire html -->
<form action="fichier_de_traitement.php" method="post">
	<label for="monChamps">Champs 1</label>
	<input id="monChamps" name="champs_1" type="text" placeholder="Quelque chose" />
</form>

<?php
// Traitement
if(isset($_POST['champs_1']) && !empty($_POST['champs_1'])) {
	$monObjet->setMonAttribut($_POST['champs_1']);
}
?>
```

Bon courage