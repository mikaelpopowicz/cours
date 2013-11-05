Delimiter @@

CREATE TRIGGER cascad_delete
	BEFORE DELETE ON categorie
	FOR EACH ROW
BEGIN
	
	Delete from facture
	Where code_cli IN
		(Select 
		code_cli
		From client
		Where code_cat = old.code_cat)
	;
	
	Delete from client
	Where code_cat = old.code_cat;
END @@

Delimiter ;