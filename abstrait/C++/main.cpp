//
//  main.cpp
//  05.11.2013
//
//  Created by Mikael Popowicz on 05/11/2013.
//  Copyright (c) 2013 Mikael Popowicz. All rights reserved.
//

#include <iostream>
#include <string>
#include "Enfant.h"

using namespace std;


int main(int argc, const char * argv[])
{

    Enfant *enfant = new Enfant("Popowicz", "Mikael", 12);
    enfant->afficher();
    enfant->saisir();
    enfant->afficher();
    return 0;
}

