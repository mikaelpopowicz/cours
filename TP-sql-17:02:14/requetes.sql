# 1 - Donnez la liste des numéros et des dates de toutes les pannes.
SELECT GROUP_CONCAT(num_panne,' ') AS 'Liste des pannes', date_panne FROM panne GROUP BY date_panne;

# 2 - Donnez la liste des équipements (numéro des équipements) qui n'ont jamais été empruntés.
SELECT num_equipement FROM portable
WHERE num_equipement NOT IN (
	SELECT num_equipement
	FROM pret
);

# 3 - Donnez la liste des numéros des équipements dont le nombre de pannes est inférieur à 3
SELECT e.num_equipement
FROM equipement e
LEFT JOIN panne p ON p.num_equipement = e.num_equipement
GROUP BY num_equipement
HAVING count(p.num_panne) < 3;

# 4 - Donnez la liste des ordinateurs portables de marque DELL qui ont été empruntés au moins une fois en 2010
SELECT num_equipement e
FROM portable e
INNER JOIN pret p ON p.num_equipement = e.num_equipement
WHERE YEAR(p.date_pret) = "2010"
AND e.marque like "Dell";

# 5 - Donnez la liste des ordinateurs portables dont l'écran est de type LED qui ont subi une panne au moins une fois en 2011

SELECT num_equipement e
FROM portable e
INNER JOIN panne p ON p.num_equipement = e.num_equipement
WHERE e.type_ecran_portable = "LED"
AND YEAR(p.date_panne) = "2011";

# 6 - Donnez la liste des écrans présents dans la base. Ordonnez le résultat par ordre croissant des prix
SELECT *
FROM ecran
ORDER BY prix_achat ASC;

# 7 - Donnez le nombre d'ordinateurs de bureau par marque
SELECT COUNT(num_equipement), marque
FROM ordinateur
GROUP BY marque;

# 8 - Donnez la liste des intervenants (nom et téléphone) ayant intervenu dans des opérations de réparation et de contrôle d'ordinateurs portables
SELECT CONCAT(i.nom_intervenant, i.tel_intervenant) AS "Liste des intervenants"
FROM intervenant i
INNER JOIN operation o ON o.nom_intervenant = i.nom_intervenant;


SELECT NOMPIL, IF(SALAIRE>COMM, CONCAT('Salaire supérieur à la com : ', SALAIRE, ' €'), 0) AS "S+", IF(SALAIRE<COMM, CONCAT('Commision supérieur au salaire : ', COMM, ' €'), 0) AS "S-", IF(SALAIRE=COMM, CONCAT('Salaire égal à la commission qui est de : ', salaire, ' €'), 0) AS "S=C" FROM pilote;

SELECT NOMPIL, CASE WHEN SALAIRE > COMM THEN CONCAT('Salaire supérieur à la com : ',SALAIRE,' €') WHEN SALAIRE < COMM THEN CONCAT('Commision supérieur au salaire : ',COMM,' €') WHEN SALAIRE = COMM THEN CONCAT('Salaire égal à la commission qui est de : ',salaire,' €') END AS "COM SAL" FROM pilote;