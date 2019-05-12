-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 09-Maio-2019 às 20:57
-- Versão do servidor: 10.1.38-MariaDB
-- versão do PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sid2`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `log_select` ()  READS SQL DATA
    SQL SECURITY INVOKER
BEGIN
SELECT * FROM sid_log;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `procura_log` (IN `termo` TEXT)  READS SQL DATA
    SQL SECURITY INVOKER
BEGIN
SELECT * FROM sid_log
WHERE momento_criacao LIKE termo
   OR mensagem LIKE termo
   OR operacao LIKE termo
   OR migracao LIKE termo;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `sid_log`
--
-- Error reading structure for table sid2.sid_log: #1932 - Table 'sid2.sid_log' doesn't exist in engine
-- Error reading data for table sid2.sid_log: #1064 - Você tem um erro de sintaxe no seu SQL próximo a 'FROM `sid2`.`sid_log`' na linha 1
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
