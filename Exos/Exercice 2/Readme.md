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

Bon courage