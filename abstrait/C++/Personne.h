//
//  Personne.h
//  05.11.2013
//
//  Created by Mikael Popowicz on 05/11/2013.
//  Copyright (c) 2013 Mikael Popowicz. All rights reserved.
//

#ifndef ___5_11_2013__Personne__
#define ___5_11_2013__Personne__

#include <iostream>
#include <string>

using namespace std;

class Personne
{
private:
    string nom, prenom;
    
public:
    Personne(string nom, string prenom)
    {
        this->setNom(nom);
        this->setPrenom(nom);
    }
    
    void setNom(string nom)
    {
        this->nom = nom;
    }
    
    string getNom()
    {
        return this->nom;
    }
    
    void setPrenom(string prenom)
    {
        this->prenom = prenom;
    }
    
    string getPrenom()
    {
        return this->prenom;
    }
    
    void saisir()
    {
        string temp;
        cout << "\n\tDonner le nom : ";
        cin >> temp;
        this->setNom(temp);
        cout << "\n\tDonner le prénom : ";
        cin >> temp;
        this->setPrenom(temp);
    }
    
    virtual void afficher()=0;
    
    
};

void Personne::afficher()
{
    cout << "\nNom : " << this->getNom() << endl;
    cout << "\nPrénom : " << this->getPrenom() << endl;
}






#endif /* defined(___5_11_2013__Personne__) */
