-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.31-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para tragaperras
CREATE DATABASE IF NOT EXISTS `tragaperras` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `tragaperras`;

-- Volcando estructura para procedimiento tragaperras.Añadir_Saldo
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `Añadir_Saldo`(
	IN `Saldo_Sum` DOUBLE,
	IN `DNI` VARCHAR(9)




)
BEGIN
DECLARE Saldo_T DOUBLE;
DECLARE saldo_act  DOUBLE;
 SET Saldo_T = (SELECT saldo FROM tragaperras.usuarios WHERE `DNI`=DNI);
 Set saldo_act=Saldo_t+Saldo_Sum;
UPDATE tragaperras.usuarios SET saldo=saldo_act WHERE `DNI`=DNI;
SELECT saldo FROM tragaperras.usuarios;
END//
DELIMITER ;

-- Volcando estructura para tabla tragaperras.maquina
CREATE TABLE IF NOT EXISTS `maquina` (
  `ID` int(4) NOT NULL,
  `DNI` varchar(9) NOT NULL,
  `Dinero Perdido` double NOT NULL,
  `Dinero Ganado` double NOT NULL,
  `Total_Apostado` double NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `maquina_usuarios` (`DNI`),
  CONSTRAINT `maquina_usuarios` FOREIGN KEY (`DNI`) REFERENCES `usuarios` (`DNI`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para procedimiento tragaperras.Restar_Saldo
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `Restar_Saldo`(
	IN `Saldo_Rest` DOUBLE


,
	IN `DNI` VARCHAR(9)



)
BEGIN
DECLARE Saldo_T DOUBLE;
DECLARE saldo_act  DOUBLE;
 SET Saldo_T = (SELECT saldo FROM tragaperras.usuarios WHERE `DNI`=DNI);
 Set saldo_act=Saldo_t-Saldo_Rest;
UPDATE tragaperras.usuarios SET saldo=saldo_act WHERE `DNI`=DNI;
SELECT saldo FROM tragaperras.usuarios;
END//
DELIMITER ;

-- Volcando estructura para tabla tragaperras.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `DNI` varchar(9) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Saldo` double NOT NULL,
  `1ºApellido` varchar(50) NOT NULL,
  `2ºApellido` varchar(50) NOT NULL,
  `UserName` varchar(10) NOT NULL,
  `Telefono` int(9) NOT NULL,
  `E-mail` varchar(50) NOT NULL,
  `Contraseña` varchar(50) NOT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
