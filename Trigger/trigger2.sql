Delimiter //
CREATE TRIGGER verifprix
BEFORE INSERT ON soin
FOR EACH ROW
BEGIN
	if new.tarifs > (SELECT AVG(tarifs) FROM soin)
		then
		DELETE FROM soin
		WHERE 2=0;
	end if; 
END //
Delimiter ;