//
//  main.cpp
//  compte
//
//  Created by Mikael Popowicz on 16/10/13.
//  Copyright (c) 2013 Mikael Popowicz. All rights reserved.
//

#include <iostream>
#include <string>
using namespace std;


class compte {
    
private:
    int numero;
    float solde;
    string nom, prenom;
    
    
public:
    /*
     *  @@ Constructeur
     */
    
    compte() {
        this->setNumero(0);
        this->setSolde(0.0);
        this->setNom("");
        this->setPrenom("");
    }
    
    
    
    /*
     *  @@ Getters
     */
    
    int getNumero() { return this->numero; }
    float getSolde() { return this->solde; }
    string getNom() { return this->nom; }
    string getPrenom() { return this->prenom; }
    
    
    
    /*
     *  @@ Setters
     */
    
    void setNumero(int numero) {
        this->numero = numero;
    }
    
    void setSolde(float solde) {
        this->solde = solde;
    }
    
    void setNom(string nom) {
        this->nom = nom;
    }
    
    void setPrenom(string prenom) {
        this->prenom = prenom;
    }
    
    
    
    /*
     *  @@ Fonctions supplémentaires
     */
    
    void ouvrir() {
        int numero;
        float solde;
        string nom, prenom;
        
        system("clear");
        cout<<"\n\t-------------------------------------";
        cout<<"\n\t-------- Ouverture de compte --------";
        cout<<"\n\t-------------------------------------";
        cout<<"\n\n\tSaisir votre numéro de compte\n\t";
        cin>>numero;
        this->setNumero(numero);

        cout<<"\n\tSaisir votre solde\n\t";
        cin>>solde;
        this->setSolde(solde);

        cout<<"\n\tSaisir votre nom\n\t";
        cin>>nom;
        this->setNom(nom);

        cout<<"\n\tSaisir votre prénom\n\t";
        cin>>nom;
        this->setNom(nom);
        
        cout<<"\n\n\tMerci de votre inscription";
        getchar();
        getchar();
    }
    
    void menu() {
        int choix;
        
        do {
            system("clear");
            cout<<"\n\t--------------------------------------";
            cout<<"\n\t---------------- Menu ----------------";
            cout<<"\n\t- 1 - Ouvrir un compte               -";
            cout<<"\n\t- 2 - Afficher le compte             -";
            cout<<"\n\t- 3 - Faire un dépot                 -";
            cout<<"\n\t- 4 - Faire un retrait               -";
            cout<<"\n\t- 5 - Dévcouvert ?                   -";
            cout<<"\n\t- 0 - Quitter                        -";
            cout<<"\n\t--------------------------------------";
            cout<<"\n\n\tVotre choix -> ";
            cin>>choix;
            switch (choix) {
                case 1: this->ouvrir(); break;
                case 2: this->afficher();getchar();getchar(); break;
                case 3: {
                    float montant;
                    cout<<"\n\tSaisir un montant à déposer \n";
                    cin>>montant;
                    this->deposer(montant);
                    getchar();
                    getchar();
                }break;
                case 4: {
                    float montant;
                    cout<<"\n\tSaisir un montant à retirer \n";
                    cin>>montant;
                    this->retirer(montant);
                    getchar();
                    getchar();
                }break;
                case 5: {
                    if (this->estEnDecouvert() == false) {
                        cout<<"\n\tVotre compte n'est pas en découvert";
                        getchar();
                        getchar();
                    } else {
                        cout<<"\n\tVotre compte est en découvert";
                        getchar();
                        getchar();
                    }
                }
            }
        } while (choix != 0);
    }
    
    void afficher() {
        cout<<"\nCompte n° "<<this->getNumero();
        cout<<"\n"<<this->getNom()<<" "<<this->getPrenom();
        cout<<"\nSolde : "<<this->getSolde()<<" €";
    }
    
    void deposer(float montant) {
        this->setSolde(this->getSolde()+montant);
    }
    
    void retirer(float montant) {
        this->setSolde(this->getSolde()-montant);
    }
    
    bool estEnDecouvert() {
        if (this->getSolde() < 0) {
            return true;
        } else {
            return false;
        }
    }
};

int main(int argc, const char * argv[])
{
    compte test;
    test.menu();
    return 0;
}

