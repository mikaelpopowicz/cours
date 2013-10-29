ALTER TABLE medicament add PRIXTTC decimal(10,2);
UPDATE medicament SET PRIXTTC = PRIXM * 1.196 WHERE PRIXTTC IS NULL;

Delimiter @@
CREATE TRIGGER calculttc
BEFORE INSERT ON medicament 
FOR EACH ROW
BEGIN
	SET new.prixttc = new.prixm*1.196;
END @@
Delimiter ;