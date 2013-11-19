//
//  Groupe.h
//  template.complexe
//
//  Created by Mikael Popowicz on 12/11/2013.
//  Copyright (c) 2013 Mikael Popowicz. All rights reserved.
//

#ifndef __template_complexe__Groupe__
#define __template_complexe__Groupe__

#include <iostream>
#include <string>
#include "Tableau.h"
#include "Eleve.h"

using namespace std;

class Groupe {
    
private:
    string nom;
    Tableau <Eleve> *mesEleves;
    
public:
    Groupe() {
        this->setNom("");
        this ->mesEleves = new Tableau<Eleve>("élève");
        
    }
    
    Groupe(string nom) {
        this->setNom(nom);
        this ->mesEleves = new Tableau<Eleve>("élève");
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
    
    void gererUnEleve(string eleve) {
        int i = this->mesEleves->rechercher(eleve);
        Eleve unEleve = this->mesEleves->getTab(i);
        unEleve.menu();
        this->mesEleves->remplacer(i, unEleve);
    }
    
    void menu() {
        int choix;
        do {
            system("clear");
            cout << "\n\t     GROUPE " << this->getNom() << endl;
            cout << "\t=====================================" << endl;
            cout << "\t================ MENU ===============" << endl;
            cout << "\t== 1 - Saisir                      ==" << endl;
            cout << "\t== 2 - Afficher                    ==" << endl;
            cout << "\t== 3 - Gérer les élèves            ==" << endl;
            cout << "\t== 4 - Gérer un élève              ==" << endl;
            cout << "\t== 0 - Quitter                     ==" << endl;
            cout << "\t=====================================\n\t"; 
            cin >> choix;
            switch (choix) {
                case 1: this->saisir(); break;
                case 2: this->afficher(); break;
                case 3: this->mesEleves->menu(); break;
                case 4:{
                    string temp;
                    cout << "\n\tDonnez le nom de l'élève : ";
                    cin >> temp;
                    this->gererUnEleve(temp);
                }; break;
                    
                default:
                    break;
            }
        } while (choix != 0);
    }
    
};

#endif /* defined(__template_complexe__Groupe__) */
