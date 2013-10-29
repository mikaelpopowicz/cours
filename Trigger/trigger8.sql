delimiter @@

/**
*	Trigger insertion étudiant
**/
CREATE TRIGGER insert_etudiant
	BEFORE INSERT ON etudiant
	FOR EACH ROW
BEGIN
	DECLARE nba int;
	/**
	*	Vérifier si l'étudiant est aussi dans la table adhérent, si oui on ne fait rien sinon on l'ajoute
	**/
	Select COUNT(id_ad) into nba
	From adherent
	Where id_ad = new.id_ad;
	if nba = 0
		then
		INSERT INTO adherent VALUES
		(new.id_ad, new.nom, new.prenom);
	else
		Delete from `: Adherent existe`;
	end if;
	/**
	*	Verifier si l'étudiant existe dans la table salarie, si oui on ne l'ajoute pas, sinon c'est bon.
	**/
	Select COUNT(id_ad) into nba
	From salarie
	Where id_ad = new.id_ad;
	if nba > 0
		then
		Delete from etudiant where 2 = 0;
	end if;
END @@

/**
*	Trigger insertion étudiant
**/
CREATE TRIGGER insert_salarie
	BEFORE INSERT ON salarie
	FOR EACH ROW
BEGIN
	DECLARE nbs int;
	Select COUNT(id_ad) into nbs
	From adherent
	Where id_ad = new.id_ad;
	if nbs = 0
		then
		INSERT INTO adherent VALUES
		(new.id_ad, new.nom, new.prenom);
	else
		Delete from `: Adherent existe`;
	end if;
	Select COUNT(id_ad) into nbs
	From etudiant
	Where id_ad = new.id_ad;
	if nbs > 0
		then
		Delete from salarie where 2 = 0;
	end if;
END @@

/**
*	Trigger update étudiant
**/
CREATE TRIGGER update_etudiant
	BEFORE UPDATE ON etudiant
	FOR EACH ROW
BEGIN
	Update adherent SET id_ad = new.id_ad, nom = new.nom, prenom = new.prenom Where id_ad = old.id_ad;
END @@


/**
*	Trigger update salarie
**/
CREATE TRIGGER update_salarie
	BEFORE UPDATE ON salarie
	FOR EACH ROW
BEGIN
	Update adherent SET id_ad = new.id_ad, nom = new.nom, prenom = new.prenom Where id_ad = old.id_ad;
END @@


CREATE TRIGGER delete_etudiant
	BEFORE DELETE ON etudiant
	FOR EACH ROW
BEGIN
	Delete from adherent where id_ad = old.id_ad;
END @@

CREATE TRIGGER delete_salarie
	BEFORE DELETE ON salarie
	FOR EACH ROW
BEGIN
	Delete from adherent where id_ad = old.id_ad;
END @@


Delimiter ;