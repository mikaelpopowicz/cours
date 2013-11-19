//
//  Eleve.h
//  template.complexe
//
//  Created by Mikael Popowicz on 12/11/2013.
//  Copyright (c) 2013 Mikael Popowicz. All rights reserved.
//

#ifndef __template_complexe__Eleve__
#define __template_complexe__Eleve__

#include <iostream>
#include <string>

using namespace std;

class Eleve {
    
private:
    string nom, prenom;
    
public:
    Eleve() {
        this->setNom("");
        this->setPrenom("");
    }
    
    Eleve(string nom, string prenom) {
        this->setNom(nom);
        this->setPrenom(prenom);
    }
    
    void setNom(string nom) {
        this->nom = nom;
    }
    
    void setPrenom(string prenom) {
        this->prenom = prenom;
    }
    
    string getNom() {
        return this->nom;
    }
    
    string getPrenom() {
        return this->prenom;
    }
    
    void saisir() {
        string temp;
        cout << "\n\tDonner le nom : ";
        cin >> temp;
        this->setNom(temp);
        cout << "\n\tDonner le prénom : ";
        cin >> temp;
        this->setPrenom(temp);
        getchar();
        getchar();
    }
    
    
    void afficher() {
        cout << "\n\tNom : " << this->getNom();
        cout << "\n\tPrénom : " << this->getPrenom();
        getchar();
        getchar();
    }
    
    void menu() {
        int choix;
        do {
            system("clear");
            cout << "\n\t=============  ELEVE  =============" << endl;
            cout << "\t=====================================" << endl;
            cout << "\t=================MENU================" << endl;
            cout << "\t== 1 - Saisir                      ==" << endl;
            cout << "\t== 2 - Afficher                    ==" << endl;
            cout << "\t== 0 - Quitter                     ==" << endl;
            cout << "\t=====================================" << endl;
            cin >> choix;
            switch (choix) {
                case 1: this->saisir(); break;
                case 2: this->afficher(); break;
                    
                default:
                    break;
            }
        } while (choix != 0);
    }
};


#endif /* defined(__template_complexe__Eleve__) */