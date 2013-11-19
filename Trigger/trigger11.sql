Delimiter @@

CREATE TRIGGER update_emp
	AFTER UPDATE ON emprunter
	FOR EACH ROW
BEGIN
	if new.dateRet IS NOT NULL
	then
		update livres
		set emprunte = false
		where nl = new.nl;
	end if;
END @@


CREATE TRIGGER delete_emp
	BEFORE DELETE ON emprunter
	FOR EACH ROW
BEGIN
	if old.dateRet IS NULL
	then
		update livres
		set emprunte = false
		where nl = old.nl;
	end if;
END @@

Delimiter ;