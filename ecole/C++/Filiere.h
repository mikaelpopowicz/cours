//
//  Filiere.h
//  template.complexe
//
//  Created by Mikael Popowicz on 12/11/2013.
//  Copyright (c) 2013 Mikael Popowicz. All rights reserved.
//

#ifndef __template_complexe__Filiere__
#define __template_complexe__Filiere__

#include <iostream>
#include <string>
#include "Groupe.h"

using namespace std;

class Filiere {
    
private:
    string nom;
    Tableau <Groupe> *mesGroupes ;
    
public:
    Filiere() {
        this->setNom("");
        this->mesGroupes = new Tableau<Groupe>("groupe");
    }
    
    Filiere(string nom) {
        this->setNom(nom);
        this->mesGroupes = new Tableau<Groupe>("groupe");
    }
    
    void setNom(string nom) {
        this->nom = nom;
    }
    
    string getNom() {
        return this->nom;
    }
    
    void saisir() {
        string temp;
        cout << "\n\tDonner le nom : ";
        cin >> temp;
        this->setNom(temp);
        getchar();
        getchar();
    }
    
    void afficher() {
        cout << "\n\tNom : " << this->getNom();
        getchar();
        getchar();
    }
    
    void gererUnGroupe(string groupe) {
        int i = this->mesGroupes->rechercher(groupe);
        Groupe unGroupe = this->mesGroupes->getTab(i);
        unGroupe.menu();
        this->mesGroupes->remplacer(i, unGroupe);
    }
    
    void menu() {
        int choix;
        do {
            system("clear");
            cout << "\n\t     FILIERE " << this->getNom() << endl;
            cout << "\t=====================================" << endl;
            cout << "\t===============  MENU  ==============" << endl;
            cout << "\t== 1 - Saisir                      ==" << endl;
            cout << "\t== 2 - Afficher                    ==" << endl;
            cout << "\t== 3 - Gérer les groupes           ==" << endl;
            cout << "\t== 4 - Gérer un groupe             ==" << endl;
            cout << "\t== 0 - Quitter                     ==" << endl;
            cout << "\t=====================================\n\t";
            cin >> choix;
            switch (choix) {
                case 1: this->saisir(); break;
                case 2: this->afficher(); break;
                case 3: this->mesGroupes->menu(); break;
                case 4:{
                    string temp;
                    cout << "\n\tDonnez le nom du groupe : ";
                    cin >> temp;
                    this->gererUnGroupe(temp);
                }; break;
                    
                default:
                    break;
            }
        } while (choix != 0);
    }

};


#endif /* defined(__template_complexe__Filiere__) */
