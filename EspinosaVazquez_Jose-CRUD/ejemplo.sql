-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-05-2018 a las 15:05:33
-- Versión del servidor: 10.1.29-MariaDB
-- Versión de PHP: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ejemplo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamentos`
--

CREATE TABLE `departamentos` (
  `dept_no` tinyint(2) NOT NULL,
  `dnombre` varchar(15) DEFAULT NULL,
  `loc` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `departamentos`
--

INSERT INTO `departamentos` (`dept_no`, `dnombre`, `loc`) VALUES
(2, 'Rosan', 'Barcelona'),
(3, 'Josh', 'Madrid'),
(10, 'CONTABILIDAD', 'SEVILLA'),
(20, 'INVESTIGACIÓN', 'MADRID'),
(30, 'VENTAS', 'BARCELONA'),
(40, 'PRODUCCIÓN', 'BILBAO'),
(60, 'MARKETING', 'GUADALAJARA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `emp_no` smallint(4) NOT NULL,
  `apellido` varchar(10) DEFAULT NULL,
  `oficio` varchar(10) DEFAULT NULL,
  `dir` smallint(6) DEFAULT NULL,
  `fecha_alt` date DEFAULT NULL,
  `salario` float(6,2) DEFAULT NULL,
  `comision` float(6,2) DEFAULT NULL,
  `dept_no` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`emp_no`, `apellido`, `oficio`, `dir`, `fecha_alt`, `salario`, `comision`, `dept_no`) VALUES
(1234, 'VazEsp', 'DIREC', 4456, '2018-05-07', 0.00, 0.00, 10),
(1235, 'EspVaz', 'PROGRA', 1234, '2018-05-07', 0.00, 0.00, 10),
(4456, 'PEPE', 'VENDEDOR', 7499, '2018-01-15', 1500.00, 10.00, 10),
(4457, 'PEPE', 'VENDEDOR', 7499, '2018-01-15', 1500.00, 10.00, 10),
(7369, 'SÁNCHEZ', 'EMPLEADO', 7902, '1990-12-17', 3040.00, NULL, 30),
(7499, 'ARROYO', 'VENDEDOR', 7698, '1990-02-20', 1500.00, 390.00, 30),
(7521, 'SALA', 'VENDEDOR', 7698, '1991-02-22', 1625.00, 650.00, 30),
(7566, 'JIMÉNEZ', 'DIRECTOR', 7839, '1991-04-02', 2900.00, NULL, 20),
(7654, 'MARTÍN', 'VENDEDOR', 7698, '1991-09-29', 1600.00, 1020.00, 30),
(7698, 'NEGRO', 'DIRECTOR', 7839, '1991-05-01', 3005.00, NULL, 30),
(7782, 'CEREZO', 'DIRECTOR', 7839, '1991-06-09', 2885.00, NULL, 10),
(7788, 'GIL', 'ANALISTA', 7566, '1991-11-09', 3000.00, NULL, 20),
(7839, 'REY', 'PRESIDENTE', NULL, '1991-11-17', 4100.00, NULL, 10),
(7844, 'TOVAR', 'VENDEDOR', 7698, '1991-09-08', 1350.00, 0.00, 30),
(7876, 'ALONSO', 'EMPLEADO', 7788, '1991-09-23', 1430.00, NULL, 20),
(7900, 'JIMENO', 'EMPLEADO', 7698, '1991-12-03', 1335.00, NULL, 30),
(7902, 'FERNÁNDEZ', 'ANALISTA', 7566, '1991-12-03', 3000.00, NULL, 20),
(7934, 'MUÑOZ', 'EMPLEADO', 7782, '1992-01-23', 1690.00, NULL, 10);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `departamentos`
--
ALTER TABLE `departamentos`
  ADD PRIMARY KEY (`dept_no`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`emp_no`),
  ADD KEY `FK_DEP` (`dept_no`),
  ADD KEY `FK_DIR` (`dir`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `FK_DEP` FOREIGN KEY (`dept_no`) REFERENCES `departamentos` (`dept_no`),
  ADD CONSTRAINT `FK_DIR` FOREIGN KEY (`dir`) REFERENCES `empleados` (`emp_no`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
