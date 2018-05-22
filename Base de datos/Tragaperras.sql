/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE IF NOT EXISTS `tragaperras` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `tragaperras`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `Añadir_Saldo`(
	IN `DNI1` VARCHAR(9),
	IN `Saldo_Sum` INT












)
BEGIN
DECLARE Saldo_T DOUBLE;
DECLARE saldo_act  DOUBLE;
 SET Saldo_T = (SELECT saldo.Saldo_Total FROM tragaperras.saldo WHERE `DNI`= DNI1);
 Set saldo_act=Saldo_t+Saldo_Sum;
UPDATE tragaperras.saldo SET saldo.Saldo_Total=saldo_act WHERE `DNI`= DNI1;
UPDATE tragaperras.saldo SET saldo.Saldo_Ingresado=saldo_Sum WHERE `DNI`= DNI1;
SELECT Saldo_Total FROM tragaperras.saldo WHERE `DNI`= DNI1;
Select saldo.Saldo_Ingresado from tragaperras.saldo WHERE `DNI`= DNI1;
END//
DELIMITER ;

CREATE TABLE IF NOT EXISTS `estadisticas` (
  `DNI` varchar(9) NOT NULL,
  `Pulsaciones_Botón` int(11) NOT NULL DEFAULT '0',
  `Pulsaciones_Ganadoras` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`DNI`),
  CONSTRAINT `User_Estadisticas` FOREIGN KEY (`DNI`) REFERENCES `usuarios` (`DNI`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `Pulsaciones`(
	IN `Ganador` INT


,
	IN `DN1` VARCHAR(9)
)
    COMMENT 'False=0, true=1'
BEGIN
if Ganador=0 then
UPDATE estadisticas SET Pulsaciones_Botón=Pulsaciones_Botón+1 WHERE `DNI`=DN1;
elseif Ganador=1 then
UPDATE estadisticas SET Pulsaciones_Botón=Pulsaciones_Botón+1 WHERE `DNI`=DN1;
UPDATE estadisticas SET Pulsaciones_Ganadoras=Pulsaciones_Ganadoras+1 WHERE `DNI`=DN1;
end if;
END//
DELIMITER ;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `Restar_Saldo`(
	IN `Saldo_Rest` DOUBLE


,
	IN `DNI1` VARCHAR(9)





)
BEGIN
DECLARE Saldo_T DOUBLE;
DECLARE saldo_act  DOUBLE;
 SET Saldo_T = (SELECT saldo.Saldo_Total FROM tragaperras.saldo WHERE `DNI`=DNI1);
 Set saldo_act=Saldo_t-Saldo_Rest;
UPDATE tragaperras.saldo SET saldo.Saldo_Total=saldo_act WHERE `DNI`=DNI1;
UPDATE tragaperras.saldo SET saldo.Saldo_Gastado=saldo_Rest WHERE `DNI`=DNI1;
SELECT Saldo_Total FROM tragaperras.saldo;
Select saldo.Saldo_Gastado from tragaperras.saldo;
END//
DELIMITER ;

CREATE TABLE IF NOT EXISTS `saldo` (
  `DNI` varchar(9) NOT NULL,
  `Saldo_Ingresado` double NOT NULL,
  `Saldo_Gastado` double NOT NULL,
  `Saldo_Ganado` double NOT NULL,
  `Saldo_Total` double NOT NULL,
  PRIMARY KEY (`DNI`),
  CONSTRAINT `saldo_usuario` FOREIGN KEY (`DNI`) REFERENCES `usuarios` (`DNI`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `usuarios` (
  `DNI` varchar(9) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `1ºApellido` varchar(50) NOT NULL,
  `2ºApellido` varchar(50) NOT NULL,
  `UserName` varchar(25) NOT NULL,
  `Contraseña` varchar(50) NOT NULL,
  `Telefono` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Tarjeta_Credito` varchar(16) NOT NULL,
  PRIMARY KEY (`DNI`),
  KEY `UserName` (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Hacer la tabla estadisticas\r\n';

SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `usuarios_after_insert` AFTER INSERT ON `usuarios` FOR EACH ROW BEGIN
INSERT INTO `tragaperras`.`saldo` (DNI) VALUES (new.DNI);
INSERT INTO `tragaperras`.`estadisticas` (DNI) VALUES (new.DNI);
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
