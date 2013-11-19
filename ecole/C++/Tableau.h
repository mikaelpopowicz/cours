//
//  Tableau.h
//  template.complexe
//
//  Created by Mikael Popowicz on 12/11/2013.
//  Copyright (c) 2013 Mikael Popowicz. All rights reserved.
//

#ifndef __template_complexe__Tableau__
#define __template_complexe__Tableau__

#include <iostream>
#include <string>

using namespace std;



template <class monType>

class Tableau
{
private:
    monType tab[20];
    int nbelements;
    string nomType;
    
public:
    /*
    Tableau() {
        this->setNbelements(0);
        this->nomType = "rien";
    }*/
    
    Tableau(string type) {
        this->setNbelements(0);
        this->setType(type);
    }
    
    void setNbelements(int nbelements) {
        this->nbelements = nbelements;
    }
    
    int getNbelements() {
        return this->nbelements;
    }
    
    void setTab(monType unObjet, int nbelements)
    {
        this->tab[nbelements] = unObjet;
    }
    
    monType getTab(int position) {
        return this->tab[position];
    }
    
    void setType(string type) {
        this->nomType = type;
    }
    
    string getType() {
        return this->nomType;
    }
    
    void ajouter() {
        monType unObjet;
        unObjet.saisir();
        this->setTab(unObjet, this->getNbelements());
        this->setNbelements(this->getNbelements()+1);
    }
    
    void afficher() {
        for (int i(0); i < this->getNbelements(); ++i) {
            this->getTab(i).afficher();
        }
    }
    
    int rechercher(string cle) {
        int i(0);
        bool trouver = false;
        while (i < this->getNbelements() && trouver == false) {
            if (tab[i].getNom() == cle) {
                trouver = true;
            } else {
                ++i;
            }
        }
        return i;
    }
    
    void remplacer(int i, monType unElement) {
        this->tab[i] = unElement;
    }
    
    void menu() {
        int choix;
        do {
            system("clear");
            cout << "\n\t=====================================" << endl;
            cout << "\t=============== MENU ================" << endl;
            cout << "\t== 1 - Afficher " << this->getType() << "             ==" << endl;
            cout << "\t== 2 - Ajouter " << this->getType() << "              ==" << endl;
            cout << "\t== 0 - Quitter                     ==" << endl;
            cout << "\t=====================================\n\t";
            cin >> choix;
            switch (choix) {
                case 1: this->afficher(); break;
                case 2: this->ajouter(); break;
                    
                default:
                    break;
            }
        } while (choix != 0);
    }
};


#endif /* defined(__template_complexe__Tableau__) */
