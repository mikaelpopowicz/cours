DROP DATABASE IF EXISTS mariage;
CREATE DATABASE IF NOT EXISTS mariage;
USE mariage;

CREATE TABLE IF NOT EXISTS personne(
	id_p INT NOT NULL,
	nom VARCHAR(128),
	prenom VARCHAR(128),
	sexe VARCHAR(2),
	PRIMARY KEY (id_p)
);

CREATE TABLE IF NOT EXISTS marier(
	p1 INT NOT NULL,
	p2 INT NOT NULL,
	PRIMARY KEY (p1, p2),
	FOREIGN KEY (p1) references personne (id_p),
	FOREIGN KEY (p2) references personne (id_p)
);

INSERT INTO personne VALUES(1, 'TEST', 'Mikael', 'm');
INSERT INTO personne VALUES(2, 'TATA', 'Camille', 'f');
INSERT INTO personne VALUES(3, 'TITI', 'Axel', 'm');
INSERT INTO personne VALUES(4, 'TOTO', 'Isabelle', 'f');

Delimiter @@

CREATE TRIGGER verifMar
BEFORE INSERT ON marier
FOR EACH ROW
BEGIN
Declare s1 varchar;
Declare s2 varchar;

if new.p1 = new.p2
then
	DELETE FROM marier where 2 = 0;
else
	SELECT sexe into s1
	FROM personne
	where id_p = new.p1;

	SELECT sexe into s2
	FROM personne
	WHERE id_p = new.p2;
	
	if s1 = s2
	then
		DELETE FROM marier where 2 = 0;
	end if;
end if;
END @@

CREATE TRIGGER upMar
BEFORE UPDATE ON marier
FOR EACH ROW
BEGIN
Declare s1 varchar;
Daclare s2 varchar;

if new.p1 = new.p2
then
	DELETE FROM marier WHERE 2 = 0;
else
	SELECT sexe into s1
	FROM personne
	where id_p = new.p1;

	SELECT sexe into s2
	FROM personne
	WHERE id_p = new.p2;
	
	if s1 = s2
	then
		DELETE FROM marier where 2 = 0;
	end if;
end if;
END @@

Delimiter ;