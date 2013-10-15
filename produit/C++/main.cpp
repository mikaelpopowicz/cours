//
//  main.cpp
//  exo.08.10.13
//
//  Created by Mikael Popowicz on 08/10/13.
//  Copyright (c) 2013 Mikael Popowicz. All rights reserved.
//

#include <iostream>
#include <string>
using namespace std;

class produit {
    
    private:
        int ref, qte;
        float prix;
        string designation;
    
    public:
    
    /*
     *  @@ Constructeur
     */
    
    produit() {
        this->setRef(0);
        this->setQte(0);
        this->setPrix(0);
        this->setDesc("");
    }
    
    
    
    /*
     *  @@ Getters
     */
    
    int getRef() { return this->ref; }
    int getQte() { return this->qte; }
    float getPrix() { return this->prix; }
    string getDes() { return this->designation; }
    
    
    
    /*
     *  @@ Setters
     */
    
    void setRef(int ref) {
        this->ref = ref;
    }
    
    void setQte(int qte) {
        this->qte = qte;
    }
    
    void setPrix(float prix) {
        this->prix = prix;
    }
    
    void setDesc(string des) {
        this->designation = des;
    }
    
    
    
    /*
     *  @@ Fonctions supplémentaires
     */
    
    void saisir() {
        int ref, qte;
        float prix;
        string designation;
        
        system("clear");
        cout<<"Saisir une référence\n";
        cin>>ref;
        this->setRef(ref);
        
        cout<<"\nSaisir une désignation\n";
        cin>>designation;
        this->setDesc(designation);
        
        cout<<"\nSaisir un prix\n";
        cin>>prix;
        this->setPrix(prix);
        
        cout<<"\nSaisir une quantité\n";
        cin>>qte;
        this->setQte(qte);
        getchar();
        getchar();
    }
    
    void afficher() {
        system("clear");
        cout<<"\nProduit n° "<<this->getRef();
        cout<<"\nDésignation :\t"<<this->getDes();
        cout<<"\nPrix :\t"<<this->getPrix();
        cout<<"\nQuantité :\t"<<this->getQte();
        getchar();
        getchar();
        
    }
    void approvisionner(int qte) {
        this->setQte(this->getQte()+qte);
        getchar();
        getchar();
    }
    
    string vendre(int qte) {
        if (qte < this->getQte()) {
            this->setQte(this->getQte()-qte);
            return "\nLa vente a eu lieu";
        } else {
            return "\nLa vente n'a pas eu lieu";
        }
    }
    
    float total_prix() {
        return (this->getQte()*this->getPrix());
    }
    void menu() {
        int choix;
        
        do {
            system("clear");
            cout<<"\n\tMenu principal des produits\n";
            cout<<"\n\n\t1) Saisir un produit";
            cout<<"\t\t2) Afficher le produit";
            cout<<"\n\t3) Vendre un produit";
            cout<<"\t\t4) Total des produits";
            cout<<"\n\t5) Approvisionner";
            cout<<"\t\t0) Quitter\n\n";
            cout<<"\t\tFaites votres choix\n\t\t";
            cin>>choix;
            
            switch (choix) {
                case 1:
                    this->saisir();
                    break;
                case 2:
                    this->afficher();
                    break;
                case 3: {
                    system("clear");
                    int qte;
                    cout<<"\n\tVeulliez entrer une quantité à vendre -> ";
                    cin>>qte;
                    cout<<this->vendre(qte);
                } break;
                case 4:
                    cout<<"\n\t\tPrix total -> "<<this->total_prix();
                    getchar();
                    getchar();
                    break;
                case 5:{
                    int qte;
                    system("clear");
                    cout<<"\n\tVeuillez entrez une quantité à approvisionner -> ";
                    cin>>qte;
                    this->approvisionner(qte);
                } break;
                    
                default:
                    break;
            }
        } while (choix != 0);
        
    }
};

int main(int argc, const char * argv[])
{
    produit p;
    p.menu();
    return 0;
}