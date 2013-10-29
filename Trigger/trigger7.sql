CREATE TABLE ACTION (
	idaction INTEGER,
	nom_acion ENUM('Insert', 'Update', 'Delete'),
	date_action DATE,
	utilisateur VARCHAR(40),
	PRIMARY KEY (idaction)
	);

Delimiter @@

CREATE TRIGGER verifInsert
AFTER INSERT ON vol
FOR EACH ROW
BEGIN
	DECLARE idA INT;
	SELECT MAX(idaction) into idA
	FROM action;
	IF idA IS NULL
		THEN
		set idA = 0;
	END IF;
	SET idA = idA +1;
	INSERT INTO action VALUES
	(idA, 'Insert', CURDATE(), USER());
	
END @@

Delimiter ;

Delimiter @@

CREATE TRIGGER verifUpdate
AFTER Update ON vol
FOR EACH ROW
BEGIN
	DECLARE idA INT;
	SELECT MAX(idaction) into idA
	FROM action;
	IF idA IS NULL
		THEN
		set idA = 0;
	END IF;
	SET idA = idA +1;
	INSERT INTO action VALUES
	(idA, 'Update', CURDATE(), USER());
	
END @@

Delimiter ;

Delimiter @@

CREATE TRIGGER verifDelete
AFTER Delete ON vol
FOR EACH ROW
BEGIN
	DECLARE idA INT;
	SELECT MAX(idaction) into idA
	FROM action;
	IF idA IS NULL
		THEN
		set idA = 0;
	END IF;
	SET idA = idA +1;
	INSERT INTO action VALUES
	(idA, 'Delete', CURDATE(), USER());
	
END @@

Delimiter ;