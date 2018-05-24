CREATE DEFINER=`root`@`localhost` PROCEDURE `Pulsaciones`(
	IN `Ganador` INT


,
	IN `DN1` VARCHAR(9)
,
	IN `Ganado` INT

)
LANGUAGE SQL
NOT DETERMINISTIC
CONTAINS SQL
SQL SECURITY DEFINER
COMMENT 'False=0, true=1'
BEGIN
if Ganador=0 then
UPDATE estadisticas SET Pulsaciones_Botón=Pulsaciones_Botón+1 WHERE `DNI`=DN1;
elseif Ganador=1 then
UPDATE estadisticas SET Pulsaciones_Botón=Pulsaciones_Botón+1 WHERE `DNI`=DN1;
UPDATE estadisticas SET Pulsaciones_Ganadoras=Pulsaciones_Ganadoras+1 WHERE `DNI`=DN1;
update saldo set Saldo_Ganado=Saldo_Ganado+Ganado WHERE `DNI`=DN1;
update saldo set Saldo_Total=Saldo_Total+Ganado WHERE `DNI`=DN1;
end if;
END