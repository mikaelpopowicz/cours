Delimiter //
Create trigger verifdate
BEFORE INSERT ON animal
	FOR EACH ROW
BEGIN
	if new.datenaissa > curdate()
		then
		DELETE FROM animal
		WHERE 2=0;
	end if;
END //
Delimiter ;