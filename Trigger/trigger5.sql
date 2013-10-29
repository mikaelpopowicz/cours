Delimiter @@

CREATE TRIGGER archive
BEFORE DELETE ON consultation
FOR EACH ROW
BEGIN
	INSERT INTO ArchiveConsult VALUES
	(old.NUMC, old.NUMV, old.NUMA, old.DATEC, old.HEUREC, old.PRIXC, CURDATE(), USER()) ;
END @@

Delimiter ;
