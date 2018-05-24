CREATE DEFINER=`root`@`localhost` PROCEDURE `Restar_Saldo`(
	IN `DNI1` VARCHAR(9)





,
	IN `Saldo_Rest` DOUBLE




)
LANGUAGE SQL
NOT DETERMINISTIC
CONTAINS SQL
SQL SECURITY DEFINER
COMMENT ''
BEGIN
DECLARE Saldo_T DOUBLE;
DECLARE saldo_act  DOUBLE;
 SET Saldo_T = (SELECT saldo.Saldo_Total FROM tragaperras.saldo WHERE `DNI`=DNI1);
 Set saldo_act=Saldo_t-Saldo_Rest;
UPDATE tragaperras.saldo SET saldo.Saldo_Total=saldo_act WHERE `DNI`=DNI1;
UPDATE tragaperras.saldo SET saldo.Saldo_Gastado=saldo_Rest WHERE `DNI`=DNI1;
SELECT Saldo_Total FROM tragaperras.saldo;
Select saldo.Saldo_Gastado from tragaperras.saldo;
END