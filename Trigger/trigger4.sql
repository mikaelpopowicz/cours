ALTER TABLE pilote ADD REVENU_TOTAL decimal(10,2), ADD REVENU_ANNUEL decimal(10,2);
UPDATE pilote 
SET revenu_total = salaire+comm, revenu_annuel = revenu_total*12
WHERE revenu_total IS NULL
AND revenu_annuel IS NULL;

Delimiter @@
CREATE TRIGGER revenu
BEFORE INSERT ON pilote
FOR EACH ROW
BEGIN
	SET new.revenu_total = new.salaire+new.comm;
	SET new.revenu_annuel = new.revenu_total*12;
END @@

Delimiter ;