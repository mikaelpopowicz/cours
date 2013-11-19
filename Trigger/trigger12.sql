DROP DATABASE IF EXISTS louer;
CREATE DATABASE IF NOT EXISTS louer;
USE louer;

CREATE TABLE IF NOT EXISTS personne(
	id_p INT NOT NULL,
	PRIMARY KEY (id_p)
);

CREATE TABLE IF NOT EXISTS appartement(
	id_a VARCHAR(5) NOT NULL,
	id_p INT,
	PRIMARY KEY (id_a),
	FOREIGN KEY (id_p) references personne (id_p)
);

CREATE TABLE IF NOT EXISTS cave(
	id_c VARCHAR(5) NOT NULL,
	id_p INT,
	PRIMARY KEY (id_c),
	FOREIGN KEY (id_p) references personne (id_p)
);
INSERT INTO personne VALUES(0);
INSERT INTO personne VALUES(1);
INSERT INTO personne VALUES(2);
INSERT INTO personne VALUES(3);
INSERT INTO personne VALUES(4);
INSERT INTO personne VALUES(5);

INSERT INTO appartement VALUES('A1', 0);
INSERT INTO appartement VALUES('A2', 0);
INSERT INTO appartement VALUES('A3', 0);
INSERT INTO appartement VALUES('B1', 0);
INSERT INTO appartement VALUES('B2', 0);
INSERT INTO appartement VALUES('B3', 0);

INSERT INTO cave VALUES('A1_C', 0);
INSERT INTO cave VALUES('A2_C', 0);
INSERT INTO cave VALUES('A3_C', 0);
INSERT INTO cave VALUES('B1_C', 0);
INSERT INTO cave VALUES('B2_C', 0);
INSERT INTO cave VALUES('B3_C', 0);

Delimiter @@

CREATE TRIGGER insertAppart
AFTER INSERT ON appartement
FOR EACH ROW
BEGIN
INSERT INTO cave
VALUES(concat(new.id_a, '_C'), 0);
END @@

CREATE TRIGGER updateAppart
AFTER UPDATE ON appartement
FOR EACH ROW
BEGIN
UPDATE cave
SET id_p = new.id_p
WHERE id_c = concat(new.id_a, '_C');
END @@

CREATE TRIGGER deleteAppart
BEFORE DELETE ON appartement
FOR EACH ROW
BEGIN
DELETE FROM cave
WHERE id_c = concat(old.id_a, '_C');
END @@

CREATE TRIGGER deletePers
BEFORE DELETE ON personne
FOR EACH ROW
BEGIN
UPDATE appartement
SET id_p = 0
WHERE id_p = old.id_p;
UPDATE cave
SET id_p = 0
WHERE id_p = old.id_p;
END @@

Delimiter ;




