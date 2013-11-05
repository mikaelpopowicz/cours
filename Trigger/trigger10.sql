Delimiter @@

/**
*	Trigger insertion particulier
**/

CREATE TRIGGER insert_part
	BEFORE INSERT ON particulier
	FOR EACH ROW
BEGIN
	Declare nba int;
	
	Select MAX(id_cli) into nba
	from client;
	
	/*
	*	Auto-incrément
	*/
	if nba is NULL
	then
		SET nba = 0;
	end if;
	if new.id_cli = 0
	then
		SET new.id_cli = nba + 1;
	end if;
		
	/*
	*	Insertion du particulier dans client si il n'existe pas
	*/
	Select COUNT(id_cli) into nba
	FROM client
	WHERE id_cli = new.id_cli;
	
	if nba = 0
	then
		Insert into client VALUES
		(new.id_cli, new.nom_cli);
	else
		Delete from `: Client existe`;
	end if;
	
	/*
	*	Verifier si le particulier est déja 'entreprise'
	*/
	Select COUNT(id_cli) into nba
	From entreprise
	Where id_cli = new.id_cli;
	if nba > 0
		then
		Delete from particulier where 2 = 0;
	end if;
	
END @@


/**
*	Trigger insertion entreprise
**/

CREATE TRIGGER insert_ent
	BEFORE INSERT ON entreprise
	FOR EACH ROW
BEGIN
	Declare nba int;
	
	Select MAX(id_cli) into nba
	from client;
	
	/*
	*	Auto-incrément
	*/
	if nba is NULL
	then
		SET nba = 0;
	end if;
	if new.id_cli = 0
	then
		SET new.id_cli = nba + 1;
	end if;
		
	/*
	*	Insertion de l'entreprise dans client si elle n'existe pas
	*/
	Select COUNT(id_cli) into nba
	FROM client
	WHERE id_cli = new.id_cli;
	
	if nba = 0
	then
		Insert into client VALUES
		(new.id_cli, new.nom_cli);
	else
		Delete from `: Client existe`;
	end if;
	
	/*
	*	Verifier si le particulier est déja 'particulier'
	*/
	Select COUNT(id_cli) into nba
	From particulier
	Where id_cli = new.id_cli;
	if nba > 0
		then
		Delete from entreprise where 2 = 0;
	end if;
	
END @@


/**
*	Trigger update particulier
**/

CREATE TRIGGER update_part
	BEFORE UPDATE ON particulier
	FOR EACH ROW
BEGIN
	Update client SET id_cli = new.id_cli, nom_cli = new.nom_cli Where id_cli = old.id_cli;
END @@


/**
*	Trigger update entreprise
**/

CREATE TRIGGER update_ent
	BEFORE UPDATE ON entreprise
	FOR EACH ROW
BEGIN
	Update client SET id_cli = new.id_cli, nom_cli = new.nom_cli Where id_cli = old.id_cli;
END @@


/**
*	Trigger delete particulier
**/

CREATE TRIGGER delete_part
	BEFORE DELETE ON particulier
	FOR EACH ROW
BEGIN
	Delete from client where id_cli = old.id_cli;
END @@


/**
*	Trigger delete entreprise
**/

CREATE TRIGGER delete_ent
	BEFORE DELETE ON entreprise
	FOR EACH ROW
BEGIN
	Delete from client where id_cli = old.id_cli;
END @@

Delimiter ;