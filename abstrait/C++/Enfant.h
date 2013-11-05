//
//  Enfant.h
//  05.11.2013
//
//  Created by Mikael Popowicz on 05/11/2013.
//  Copyright (c) 2013 Mikael Popowicz. All rights reserved.
//

#ifndef ___5_11_2013__Enfant__
#define ___5_11_2013__Enfant__

#include <iostream>
#include <string>
#include "Personne.h"

using namespace std;

class Enfant : public Personne
{
private:
    int age;
    
public:
    Enfant(string nom, string prenom, int age):Personne(nom, prenom)
    {
        this->setAge(age);
    }
    
    void setAge(int age)
    {
        this->age = age;
    }
    
    int getAge()
    {
        return this->age;
    }
    
    
    void saisir()
    {
        this->Personne::saisir();
        cout << "\n\tSaisir age : ";
        int temp;
        cin >> temp;
        this->setAge(temp);
    }
    
    void afficher()
    {
        this->Personne::afficher();
        cout << "\nAge : " << this->getAge() << endl;
    }
};

#endif /* defined(___5_11_2013__Enfant__) */
