//
//  main.cpp
//  tableau
//
//  Created by Mikael Popowicz on 16/10/13.
//  Copyright (c) 2013 Mikael Popowicz. All rights reserved.
//

#include <iostream>
#include <string>
#include <vector>
using namespace std;


class Tableau {
    
private:
    unsigned long nbelements;
    vector<long int> tab;
    
public:
    /*
     *  @@ Constructeur
     */
    
    Tableau(vector<int> tab) {
        this->setNbelements(tab.size());
        this->setTab(tab, tab.size());
    }
    
    
    
    /*
     *  @@ Getters
     */
    
    vector<long int> getTab() {
        return this->tab;
    }
    
    unsigned long getNbelements() {
        return this->nbelements;
    }
    
    
    
    /*
     *  @@ Setters
     */
    
    void setTab(vector<int> tab, unsigned long size) {
        this->tab.clear();
        for (int i(0); i < size; ++i) {
            this->tab.push_back(tab[i]);
        }
    }
    
    void setNbelements(unsigned long nbelements) {
        this->nbelements = nbelements;
    }
    
    
    
    /*
     *  @@ Fonctions supplémentaires
     */
    
    void saisir() {
        int nb;
        
        system("clear");
        cout<<"\n\t-------------------------------------";
        cout<<"\n\t--------- Saisir le tableau ---------";
        cout<<"\n\t-------------------------------------";
        cout<<"\n\n\tSaisir le nombre d'élements (1 à 20) -> ";
        cin >> nb;
        this->setNbelements(nb);
        
        vector<int> tab(this->getNbelements());
        
        for (int i(0); i < this->getNbelements(); ++i) {
            system("clear");
            cout<<"\n\t-------------------------------------";
            cout<<"\n\t--------- Saisir le tableau ---------";
            cout<<"\n\t-------------------------------------";
            cout<<"\n\n\tSaisir une valeur pour la case " << i << " -> ";
            cin >> tab[i];
        }
        this->setTab(tab, this->getNbelements());
        cout << "\t";
        getchar();
    }
    
    void menu() {
        int choix;
        
        do {
            system("clear");
            cout<<"\n\t--------------------------------------";
            cout<<"\n\t---------------- Menu ----------------";
            cout<<"\n\t- 1 - Saisir le tableau              -";
            cout<<"\n\t- 2 - Afficher le tableau            -";
            cout<<"\n\t- 3 - Rechercher une valeur          -";
            cout<<"\n\t- 4 - Trier                          -";
            cout<<"\n\t- 5 - Supprimer une valeur           -";
            cout<<"\n\t- 6 - Moyenne                        -";
            cout<<"\n\t- 7 - Min - Max                      -";
            cout<<"\n\t- 0 - Quitter                        -";
            cout<<"\n\t--------------------------------------";
            cout<<"\n\n\tVotre choix -> ";
            cin>>choix;
            switch (choix) {
                case 1: this->saisir();break;
                case 2: this->afficher();break;
                case 3: this->rechercher();break;
                case 4: this->trier();break;
                case 5: this->supprimer();break;
                case 6: this->moyenne();break;
                case 7: this->min_max();break;
            }
        } while (choix != 0);
    }
    
    void afficher() {
        system("clear");
        cout<<"\n\t-------------------------------------";
        cout<<"\n\t------- Affichage du tableau --------";
        cout<<"\n\t-------------------------------------\n\n\t";
        for (int i(0); i < this->getTab().size(); ++i) {
            cout << " |Tab[" << i << "] = " << this->getTab()[i] << "| ";
            if ((i+1)%4 == 0 && i != 0) {
                cout << "\n\t";
            }
        }
        cout << "\t";
        getchar();
        getchar();
    }
    
    void rechercher() {
        int nb;
        int j(0);
        vector<int> resultat;
        
        system("clear");
        cout<<"\n\t-------------------------------------";
        cout<<"\n\t------- Rechercher une valeur -------";
        cout<<"\n\t-------------------------------------";
        cout<<"\n\n\tSaisir une valeur à rechercher -> ";
        cin >> nb;
        cout << "\n\n\t La valeur recherchée se trouve dans :" << endl;
        for (int i(0); i < this->getNbelements(); ++i) {
            if (this->getTab()[i] == nb) {
                cout << "\t @ la case " << i << endl;
                ++j;
            }
        }
        if (j == 0) {
            cout << "\t @ aucune case" << endl;
        }
        cout << "\t";
        getchar();
        getchar();
    }
    
    void trier() {
        bool permut;
        long int temp;
        vector<long int> tri = this->getTab();
        do {
            permut = false;
            for (int i(0); i < tri.size()-1; ++i) {
                if (tri[i] > tri[i+1]) {
                    temp = tri[i];
                    tri[i] = tri[i+1];
                    tri[i+1] = temp;
                    permut = true;
                }
            }
        } while (permut == true);
        
        system("clear");
        cout<<"\n\t-------------------------------------";
        cout<<"\n\t----- Tableau trié (croissant) ------";
        cout<<"\n\t-------------------------------------\n\n\t";
        for (int i(0); i < tri.size(); ++i) {
            cout << " |Tab[" << i << "] = " << tri[i] << "| ";
            if ((i+1)%4 == 0 && i != 0) {
                cout << "\n\t";
            }
        }
        cout << "\t";
        getchar();
        getchar();
    }
    
    void supprimer() {
        int nb;

        system("clear");
        cout<<"\n\t-------------------------------------";
        cout<<"\n\t------- Supprimer une valeur --------";
        cout<<"\n\t-------------------------------------";
        cout<<"\n\n\tSaisir le numéro de la case à supprimer -> ";
        cin >> nb;
        if (nb < this->getTab().size()) {
            this->tab.erase(this->tab.begin()+nb);
            cout << "\n\tLa case " << nb << " a bien été supprimée" << endl;
        } else {
            cout << "\n Votre choix -> " << nb << " est plus grand que la taille du tableau" << endl;
        }
        cout << "\t";
        getchar();
        getchar();
    }
    
    void moyenne() {
        double moyenne(0);
        
        for (int i(0); i < this->getTab().size(); ++i) {
            moyenne += this->getTab()[i];
        }
        moyenne /= this->getTab().size();
        cout << "\n\tLa moyenne des valeurs du tableau est " << moyenne << endl;
        cout << "\t";
        getchar();
        getchar();
    }
    
    void min_max() {
        long int min, max, temp;
        vector<long int> min_max;
        min_max = this->getTab();
        bool permut;
        do {
            permut = false;
            for (int i(0); i < min_max.size()-1; ++i) {
                if (min_max[i] > min_max[i+1]) {
                    temp = min_max[i];
                    min_max[i] = min_max[i+1];
                    min_max[i+1] = temp;
                    permut = true;
                }
            }
        } while (permut == true);
        min = min_max[0];
        max = min_max[min_max.size()-1];
        cout << "\n\tLe tableau contient des valeurs comprises entre " << min << " et " << max << endl;
        cout << "\t";
        getchar();
        getchar();
    }
    
};


int main(int argc, const char * argv[])
{
    vector<int> tab(10, 1);
    Tableau t(tab);
    t.menu();
    return 0;
}

