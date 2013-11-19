//
//  main.cpp
//  template.complexe
//
//  Created by Mikael Popowicz on 12/11/2013.
//  Copyright (c) 2013 Mikael Popowicz. All rights reserved.
//
#include "Filiere.h"

#include <iostream>
#include <string>

using namespace std;


int main(int argc, const char * argv[])
{
    Filiere * uneFiliere = new Filiere("Test");
    
    uneFiliere->menu();
    
    
    return 0;
}

