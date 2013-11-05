DROP DATABASE IF EXISTS exclu;

CREATE DATABASE IF NOT EXISTS exclu;
USE exclu;
# -----------------------------------------------------------------------------
#       TABLE : client
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS client
 (
   id_cli INTEGER NOT NULL  ,
   nom_cli VARCHAR(128) NULL  
   , PRIMARY KEY (id_cli) 
 );

# -----------------------------------------------------------------------------
#       TABLE : entreprise
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS entreprise
 (
   id_cli INTEGER NOT NULL  ,
   nom_cli VARCHAR(128) NULL  ,
   siret VARCHAR(128) NULL
   , PRIMARY KEY (id_cli) 
 );

# -----------------------------------------------------------------------------
#       TABLE : particulier
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS particulier
 (
   id_cli INTEGER NOT NULL  ,
   nom_cli VARCHAR(128) NULL  ,
   prenom VARCHAR(128) NULL  
   , PRIMARY KEY (id_cli) 
 );