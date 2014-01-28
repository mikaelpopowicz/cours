drop database if exists membre;

CREATE DATABASE membre;
USE membre;

CREATE TABLE IF NOT EXISTS membre (
	id INT NOT NULL AUTO_INCREMENT,
	email VARCHAR(50) NOT NULL,
	nom VARCHAR(50) NOT NULL,
	prenom VARCHAR(50) NULL,
	password VARCHAR(40) NOT NULL,
	token VARCHAR(40) NOT NULL,
	active BOOLEAN,
	PRIMARY KEY (id)
) ENGINE InnoDB;