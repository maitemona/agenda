-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-04-2017 a las 12:32:08
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `agenda`
--
CREATE DATABASE IF NOT EXISTS `agenda` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `agenda`;

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `contactogetBymailing`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `contactogetBymailing` (IN `pcodigo` INT)  NO SQL
BEGIN

SELECT  con.email as email
FROM mailing as m
INNER JOIN categoria as c on m.idcategoria=c.idcategoria
INNER JOIN contacto as con on con.idcontactocategoria= c.idcategoria
INNER JOIN  newsletter as n on m.idnewslettermailing= n.idnewsletter
WHERE m.idnewslettermailing=pcodigo;

END$$

DROP PROCEDURE IF EXISTS `getContactosporCategoria`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getContactosporCategoria` (IN `pcodigo` INT)  NO SQL
BEGIN

SELECT ncontacto,email,
direccion,
    email ,
    idcontacto,
 	activo,
    cargo,
    poblacion,
    telefono,
    idcontactocategoria
FROM contacto as c
WHERE c.idcontactocategoria=pcodigo;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `idcategoria` int(11) NOT NULL AUTO_INCREMENT,
  `ncategoria` varchar(250) COLLATE utf8_bin NOT NULL,
  `activo` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`idcategoria`, `ncategoria`, `activo`) VALUES
(1, 'Bizkaia | Ayuntamiento', 1),
(2, 'Bizkaia | Hoteles', 1),
(23, 'Prueba categoria', 1),
(24, 'Prueba categoria', 1),
(25, 'Araba|Aula de Cultura ', 1),
(27, 'ss', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contacto`
--

DROP TABLE IF EXISTS `contacto`;
CREATE TABLE IF NOT EXISTS `contacto` (
  `idcontacto` int(11) NOT NULL AUTO_INCREMENT,
  `cargo` varchar(200) COLLATE utf8_bin NOT NULL,
  `email` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `ncontacto` varchar(200) COLLATE utf8_bin NOT NULL,
  `poblacion` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `direccion` varchar(250) COLLATE utf8_bin NOT NULL,
  `telefono` int(9) NOT NULL,
  `idcontactocategoria` int(11) DEFAULT NULL,
  `activo` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idcontacto`),
  KEY `idcontactocategoria` (`idcontactocategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `contacto`
--

INSERT INTO `contacto` (`idcontacto`, `cargo`, `email`, `ncontacto`, `poblacion`, `direccion`, `telefono`, `idcontactocategoria`, `activo`) VALUES
(1, 'Responsable', 'maitemonasterio@gmail.com', 'Maite', 'Munguia', '', 944661303, 1, 1),
(2, 'Responsable', 'maitemonasterio@gmail.com', 'Javier', 'Getxo', 'palacio gran via', 987456123, 2, 1),
(3, 'Nuevo', 'maitemonasterio@gmail.com', 'Nuevo', '', 'Nuevo', 0, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mailing`
--

DROP TABLE IF EXISTS `mailing`;
CREATE TABLE IF NOT EXISTS `mailing` (
  `idmailing` int(11) NOT NULL AUTO_INCREMENT,
  `idnewslettermailing` int(11) NOT NULL,
  `idcategoria` int(11) DEFAULT NULL,
  `titulo` varchar(250) COLLATE utf8_bin NOT NULL,
  `fenvio` date NOT NULL,
  PRIMARY KEY (`idmailing`),
  KEY `idnewsletter` (`idnewslettermailing`),
  KEY `idcontacto` (`idcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `mailing`
--

INSERT INTO `mailing` (`idmailing`, `idnewslettermailing`, `idcategoria`, `titulo`, `fenvio`) VALUES
(6, 1, 1, 'prueba1', '2017-04-11'),
(7, 2, 2, 'preuba2', '2017-04-11'),
(8, 1, 1, 'uu', '2017-04-13'),
(9, 1, 1, 's', '2017-04-13'),
(10, 1, 1, 's', '2017-04-13'),
(11, 1, 1, 's', '2017-04-15'),
(12, 1, 1, 'prueba', '2017-04-22'),
(13, 1, 1, 'ss', '2017-04-22'),
(14, 1, 2, 'e', '2017-04-22'),
(15, 1, 2, 'dd', '2017-04-22'),
(16, 1, 1, 'ff', '2017-04-22'),
(17, 1, 1, 'd', '2017-04-22'),
(18, 1, 1, 'dd', '2017-04-22');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `newsletter`
--

DROP TABLE IF EXISTS `newsletter`;
CREATE TABLE IF NOT EXISTS `newsletter` (
  `idnewsletter` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `body` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `fcreacion` date NOT NULL,
  `activo` tinyint(4) NOT NULL DEFAULT '1',
  `archivo` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`idnewsletter`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `newsletter`
--

INSERT INTO `newsletter` (`idnewsletter`, `titulo`, `body`, `fcreacion`, `activo`, `archivo`) VALUES
(1, 'Bienvenida la primavera', 'esto es una prueba', '2017-03-21', 1, ''),
(2, ' Se fue el invierno', 'prueba del se fue el invierno', '2017-03-22', 1, '');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `contacto`
--
ALTER TABLE `contacto`
  ADD CONSTRAINT `fk_contacto_categoria` FOREIGN KEY (`idcontactocategoria`) REFERENCES `categoria` (`idcategoria`);

--
-- Filtros para la tabla `mailing`
--
ALTER TABLE `mailing`
  ADD CONSTRAINT `fk_mailing_contacto` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`idcategoria`),
  ADD CONSTRAINT `fk_mailing_newsletter` FOREIGN KEY (`idnewslettermailing`) REFERENCES `newsletter` (`idnewsletter`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
