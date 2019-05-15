-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 15-Maio-2019 às 18:45
-- Versão do servidor: 10.1.39-MariaDB
-- versão do PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sid`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `cria_admin` (IN `user_account` VARCHAR(250), IN `email` VARCHAR(250), IN `palavra` VARCHAR(250))  NO SQL
BEGIN
SET @funcao = CONCAT('CREATE USER ', user_account ,'@''localhost'' IDENTIFIED BY  ''', palavra, '''');
PREPARE method FROM @funcao; 
EXECUTE method;

SET @funcao = CONCAT('GRANT ALL PRIVILEGES ON sid.* TO ''', user_account, '''@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;

INSERT INTO sid_user(`user_name`, `user_password`, `email`) VALUES (user_account , palavra , email);
INSERT INTO sid_user_permissoes(`username`, `permissao`) VALUES (user_account , 'administrador');
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `cria_auditor` (IN `user_account` VARCHAR(250), IN `palavra` VARCHAR(250), IN `email` VARCHAR(250))  BEGIN
SET @funcao = CONCAT('CREATE USER ', user_account ,'@''localhost'' IDENTIFIED BY  ''', palavra, '''');
PREPARE method FROM @funcao; 
EXECUTE method;

SET @funcao = CONCAT('GRANT SELECT ON sid.sid_log TO ''', user_account, '''@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;

SET @funcao = CONCAT('GRANT SELECT ON sid2.sid_log TO ''', user_account, '''@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;

INSERT INTO sid_user(`user_name`, `user_password`, `email`) VALUES (user_account , palavra , email);
INSERT INTO sid_user_permissoes(`username`, `permissao`) VALUES (user_account , 'auditor');
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `cria_migrador` (IN `user_account` VARCHAR(250), IN `palavra` VARCHAR(250), IN `email` VARCHAR(250))  NO SQL
BEGIN
SET @funcao = CONCAT('CREATE USER ', user_account ,'@''localhost'' IDENTIFIED BY  ''', palavra, '''');
PREPARE method FROM @funcao; 
EXECUTE method;

SET @funcao = CONCAT('GRANT SELECT, UPDATE ON sid.sid_log TO ''', user_account, '''@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;

SET @funcao = CONCAT('GRANT INSERT ON sid2.sid_log TO ''', user_account, '''@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;

SET @funcao = CONCAT('GRANT INSERT ON sid.medicoes TO ''', user_account, '''@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;

SET @funcao = CONCAT('GRANT INSERT ON sid.alertas TO ''', user_account, '''@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;

SET @funcao = CONCAT('GRANT INSERT ON sid.valores_estranhos TO ''', user_account, '''@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;

INSERT INTO sid_user(`user_name`, `user_password`, `email`) VALUES (user_account , palavra , email);
INSERT INTO sid_user_permissoes(`username`, `permissao`) VALUES (user_account , 'migrador');
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `cria_user` (IN `user_account` VARCHAR(50), IN `palavra` VARCHAR(250), IN `email` VARCHAR(250))  MODIFIES SQL DATA
BEGIN
SET @funcao = CONCAT('CREATE USER ', user_account ,'@''localhost'' IDENTIFIED BY  ''', palavra, '''');
PREPARE method FROM @funcao; 
EXECUTE method;
SET @funcao = CONCAT('GRANT INSERT, UPDATE, DELETE ON sid.variaveis TO ''', user_account, '''@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;
SET @funcao = CONCAT('GRANT INSERT, UPDATE, DELETE, SELECT ON sid.variaveis_medidas TO ''', user_account, '''@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;
SET @funcao = CONCAT('GRANT INSERT, UPDATE ON sid.cultura TO ''', user_account, '''@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;
SET @funcao = CONCAT('GRANT INSERT, DELETE, SELECT ON sid.medicoes TO ''', user_account, '''@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;
SET @funcao = CONCAT('GRANT UPDATE ON sid.sid_user TO ''', user_account, '''@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;
INSERT INTO sid_user(`user_name`, `user_password`, `email`) VALUES (user_account , palavra , email);
INSERT INTO investigador(`email`, `nome`, `categoria_profissional`) VALUES (email , user_account , 'investigador');
INSERT INTO sid_user_permissoes(`username`, `permissao`) VALUES (user_account , 'investigador');
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `cultura_select` (IN `id_user` INT UNSIGNED)  MODIFIES SQL DATA
    SQL SECURITY INVOKER
BEGIN
INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao,username) values (SYSDATE(), 'select na tabela cultura', 'select',CURRENT_USER);
select * from cultura;
    END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `investigador_select` (IN `id_user` INT UNSIGNED)  MODIFIES SQL DATA
    SQL SECURITY INVOKER
BEGIN
INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao,username) values (SYSDATE(), 'select na tabela investigador', 'select',CURRENT_USER);
select * from investigador;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `medicoes_select` (IN `id_user` INT)  MODIFIES SQL DATA
    SQL SECURITY INVOKER
BEGIN
INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao,username) values (SYSDATE(), 'select na tabela medicoes', 'select',CURRENT_USER);
select * from id_user;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `migracaoMongo` ()  MODIFIES SQL DATA
INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao, username) values (SYSDATE(), 'Migracao Concluida', 'migracao', CURRENT_USER)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `migracao_parcial` ()  READS SQL DATA
BEGIN
SELECT * FROM sid_log WHERE migracao IS NULL;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `migracao_total` ()  READS SQL DATA
BEGIN
SELECT * from sid_log;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `migracao_update` ()  MODIFIES SQL DATA
BEGIN 
    UPDATE sid_log
    SET migracao = 1                    
    WHERE  migracao IS NULL ; 

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sid_log_select` (IN `id_user` INT UNSIGNED)  MODIFIES SQL DATA
    SQL SECURITY INVOKER
BEGIN
INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao,username) values (SYSDATE(), 'select na tabela sid_log', 'select',CURRENT_USER);
select * from sid_log;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sid_permissoes_select` (IN `id_user` INT UNSIGNED)  MODIFIES SQL DATA
    SQL SECURITY INVOKER
BEGIN
INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao,username) values (SYSDATE(), 'select na tabela sid_permissoes', 'select',CURRENT_USER);
select * from sid_permissoes;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sid_user_permissoes` (IN `id_user` INT UNSIGNED)  MODIFIES SQL DATA
    SQL SECURITY INVOKER
BEGIN
INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao,username) values (SYSDATE(), 'select na tabela sid_user_permissoes', 'select',CURRENT_USER);
select * from sid_user_permissoes;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sid_user_selectParcial` (IN `id_user_procurador` INT, IN `termo` TEXT)  MODIFIES SQL DATA
    SQL SECURITY INVOKER
BEGIN
INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao,username) values (SYSDATE(), CONCAT('select na tabela sid_user para procurar por ', termo), 'select',CURRENT_USER);
SELECT * FROM sid_user
WHERE email LIKE termo
   OR id_user LIKE termo
   OR user_password LIKE termo
   OR user_name LIKE termo;
    END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sid_user_selectTotal` (IN `id_user` INT)  MODIFIES SQL DATA
    SQL SECURITY INVOKER
BEGIN
INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao,username) values (SYSDATE(), 'select na tabela sid_user', 'select',CURRENT_USER);
select * from sid_user;
    END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `torna_admin` (IN `user_account` VARCHAR(250))  NO SQL
BEGIN
SET @funcao = CONCAT('REVOKE ALL PRIVILEGES, GRANT OPTION FROM ', user_account ,'@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;
SET @funcao = CONCAT('GRANT ALL PRIVILEGES ON sid.* TO ''', user_account, '''@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;
SET @funcao = CONCAT('UPDATE sid_user_permissoes SET permissao=''administrador'' WHERE username = ''', user_account, '''');
PREPARE method FROM @funcao; 
EXECUTE method;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `torna_Investigador` (IN `user_account` VARCHAR(250), IN `email` VARCHAR(250))  NO SQL
BEGIN
SET @funcao = CONCAT('REVOKE ALL PRIVILEGES, GRANT OPTION FROM ', user_account ,'@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;
SET @funcao = CONCAT('GRANT INSERT, UPDATE, DELETE ON sid.variaveis TO ''', user_account, '''@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;
SET @funcao = CONCAT('GRANT INSERT, UPDATE, DELETE, SELECT ON sid.variaveis_medidas TO ''', user_account, '''@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;
SET @funcao = CONCAT('GRANT INSERT, UPDATE ON sid.cultura TO ''', user_account, '''@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;
SET @funcao = CONCAT('GRANT INSERT, DELETE, SELECT ON sid.medicoes TO ''', user_account, '''@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;
SET @funcao = CONCAT('GRANT UPDATE ON sid.sid_user TO ''', user_account, '''@''localhost''');
PREPARE method FROM @funcao; 
EXECUTE method;
SET @funcao = CONCAT('UPDATE sid_user_permissoes SET permissao=''investigador'' WHERE username = ''', user_account, '''');
PREPARE method FROM @funcao; 
EXECUTE method;
INSERT INTO investigador(`email`, `nome`, `categoria_profissional`) VALUES (email , user_account , 'investigador');
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `variaveis_medidas_select` (IN `id_user` INT UNSIGNED)  MODIFIES SQL DATA
    SQL SECURITY INVOKER
BEGIN
INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao,username) values (SYSDATE(), 'select na tabela variaveis_medidas', 'select',CURRENT_USER);
select * from variaveis_medidas;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `variaveis_select` (IN `id_user` INT UNSIGNED)  MODIFIES SQL DATA
    SQL SECURITY INVOKER
BEGIN
INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao,username) values (SYSDATE(), 'select na tabela variaveis', 'select',CURRENT_USER);
select * from variaveis;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `alertas`
--

CREATE TABLE `alertas` (
  `data_hora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valor_medicao` decimal(10,2) NOT NULL,
  `id_cultura` int(11) NOT NULL,
  `id_variavel` int(11) NOT NULL,
  `numero_medicao` int(11) NOT NULL,
  `limite_inferior` decimal(10,0) NOT NULL,
  `limite_superior` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cultura`
--

CREATE TABLE `cultura` (
  `id_cultura` int(11) NOT NULL,
  `nome_cultura` varchar(100) NOT NULL,
  `descricao_cultura` longtext,
  `responsavel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Acionadores `cultura`
--
DELIMITER $$
CREATE TRIGGER `cultura_delete` AFTER DELETE ON `cultura` FOR EACH ROW BEGIN
	INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao, username) values (SYSDATE(), CONCAT('id_cultura: ', OLD.id_cultura , ' nome_cultura: ' , OLD.nome_cultura), 'delete', CURRENT_USER);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `cultura_insert` AFTER INSERT ON `cultura` FOR EACH ROW BEGIN
	INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao, username) values (SYSDATE(), CONCAT('id_cultura: ', NEW.id_cultura , ' nome_cultura: ' ,NEW.nome_cultura), 'insert', CURRENT_USER);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `cultura_update` AFTER UPDATE ON `cultura` FOR EACH ROW BEGIN  
	IF  OLD.nome_cultura <> NEW.nome_cultura THEN 
		SET @tipo = 'nome_cultura';
        SET @antigo = OLD.nome_cultura;
        SET @novo = NEW.nome_cultura;
	ELSEIF OLD.descricao_cultura <> NEW.descricao_cultura  THEN 
		SET @tipo = 'descricao_cultura';
        SET @antigo = OLD.descricao_cultura;
        SET @novo = NEW.descricao_cultura;
    ELSEIF OLD.responsavel <> NEW.responsavel  THEN 
		SET @tipo = 'responsavel';
        SET @antigo = OLD.responsavel;
        SET @novo = NEW.responsavel;
	END IF;    
	INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao, username) values (SYSDATE(), concat('Campo: ' , @tipo, 'alterado de ', @antigo, ' para ', @novo), 'update', CURRENT_USER);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `investigador`
--

CREATE TABLE `investigador` (
  `id_investigador` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `categoria_profissional` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `investigador`
--

INSERT INTO `investigador` (`id_investigador`, `email`, `nome`, `categoria_profissional`) VALUES
(1, 'user', 'user', 'investigador');

--
-- Acionadores `investigador`
--
DELIMITER $$
CREATE TRIGGER `investigador_delete` AFTER DELETE ON `investigador` FOR EACH ROW BEGIN
	INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao, username) values (SYSDATE(), CONCAT('id_investigador: ', OLD.id_investigador , ' email: ' , OLD.email), 'delete', CURRENT_USER);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `investigador_insert` AFTER INSERT ON `investigador` FOR EACH ROW BEGIN
	INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao, username) values (SYSDATE(), CONCAT('id_investigador: ', NEW.id_investigador , ' email: ' ,NEW.email), 'insert', CURRENT_USER);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `investigador_update` AFTER UPDATE ON `investigador` FOR EACH ROW BEGIN
	IF  OLD.id_investigador <> NEW.id_investigador THEN 
		SET @field = 'id_investigador';
        SET @antigo = OLD.id_investigador;
        SET @novo = NEW.id_investigador;
	ELSEIF OLD.email   <> NEW.email  THEN 
		SET @field = 'email';
        SET @antigo = OLD.email;
        SET @novo = NEW.email;
    ELSEIF OLD.nome  <> NEW.nome  THEN 
		SET @field = 'nome';
        SET @antigo = OLD.nome;
        SET @novo = NEW.nome;
    ELSEIF OLD.categoria_profissional   <> NEW.categoria_profissional   THEN 
		SET @field = 'categoria_profissional';
        SET @antigo = OLD.categoria_profissional;
        SET @novo = NEW.categoria_profissional;
	END IF; 
	INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao, username) values (SYSDATE(), concat('Campo: ' , @field, 'alterado de ', @antigo, ' para ', @novo), 'update', CURRENT_USER);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `medicoes`
--

CREATE TABLE `medicoes` (
  `numero_medicao` int(11) NOT NULL,
  `data_hora_medicao` datetime NOT NULL,
  `valor_medicao` decimal(10,4) NOT NULL,
  `id_cultura` int(11) NOT NULL,
  `id_variavel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Acionadores `medicoes`
--
DELIMITER $$
CREATE TRIGGER `medicoes_delete` AFTER DELETE ON `medicoes` FOR EACH ROW BEGIN
	INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao, username) values (SYSDATE(), CONCAT('numero_medicao: ', OLD.numero_medicao, ' data_hora_medicao: ' ,OLD.data_hora_medicao, ' valor_medicao: ' ,OLD.valor_medicao, ' id_cultura: ' ,OLD.id_cultura, ' id_variavel: ' ,OLD.id_variavel), 'delete', CURRENT_USER);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `medicoes_insert` AFTER INSERT ON `medicoes` FOR EACH ROW BEGIN
	INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao, username) values (SYSDATE(), CONCAT('numero_medicao: ', NEW.numero_medicao, ' data_hora_medicao: ' ,NEW.data_hora_medicao, ' valor_medicao: ' ,NEW.valor_medicao, ' id_cultura: ',NEW.id_cultura, ' id_variavel: ' ,NEW.id_variavel), 'insert', CURRENT_USER);    
    
SET @LIMITESUPERIOR = (SELECT LIMITE_SUPERIOR 
										FROM VARIAVEIS_MEDIDAS 
										WHERE ID_CULTURA = NEW.ID_CULTURA 
										AND ID_VARIAVEL = NEW.ID_VARIAVEL); 
                                        
SET @LIMITEINFERIOR = (SELECT LIMITE_INFERIOR 
										FROM VARIAVEIS_MEDIDAS 
										WHERE ID_CULTURA = NEW.ID_CULTURA 
										AND ID_VARIAVEL = NEW.ID_VARIAVEL); 
    
IF (NEW.VALOR_MEDICAO NOT BETWEEN @LIMITEINFERIOR AND @LIMITESUPERIOR) THEN
	SET @ultimoValor = (SELECT VALOR_MEDICAO   
	FROM medicoes 
	WHERE id_cultura = NEW.id_cultura 
	AND id_variavel = NEW.id_variavel
	ORDER BY data_hora_medicao DESC LIMIT 1);
    
	SET @valormaximo = @ultimoValor * 1.25;
	SET @valorminimo = @ultimovalor * 0.75;
	IF (NEW.VALOR_MEDICAO NOT BETWEEN @valorminimo and @valormaximo)THEN
		INSERT INTO valores_estranhos(data_hora, id_cultura, id_variavel, numero_medicao, valor_medicao) 
		VALUES 	(NEW.data_hora_medicao,NEW.id_cultura,NEW.id_variavel,NEW.numero_medicao,NEW.valor_medicao);
	ELSE
		INSERT INTO alertas(data_hora, valor_medicao, id_cultura, id_variavel, numero_medicao, limite_inferior, limite_superior) 
		VALUES (NEW.data_hora_medicao,NEW.numero_medicao,NEW.id_cultura,NEW.id_variavel,NEW.numero_medicao,@LIMITEINFERIOR,@LIMITESUPERIOR);
	END IF;
ELSE 
	SET @valor_aviso_superior = @LIMITESUPERIOR * 0.9;
	SET @valor_aviso_inferior = @LIMITEINFERIOR + @LIMITESUPERIOR - @valor_aviso_superior;
	IF (NEW.valor_medicao NOT BETWEEN @valor_aviso_inferior and @valor_aviso_superior) THEN
	INSERT INTO alertas(data_hora, valor_medicao, id_cultura, id_variavel, numero_medicao, limite_inferior, limite_superior) 
		VALUES (NEW.data_hora_medicao,NEW.valor_medicao,NEW.id_cultura,NEW.id_variavel,NEW.numero_medicao,@LIMITEINFERIOR,@LIMITESUPERIOR);
        END IF; 
END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `sid_log`
--

CREATE TABLE `sid_log` (
  `momento_criacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `mensagem` varchar(500) DEFAULT NULL,
  `operacao` varchar(25) DEFAULT NULL,
  `username` text,
  `migracao` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `sid_log`
--

INSERT INTO `sid_log` (`momento_criacao`, `mensagem`, `operacao`, `username`, `migracao`) VALUES
('2019-05-15 16:07:49', ' user_name : admin email : admin', 'insert', 'root@localhost', NULL),
('2019-05-15 16:07:49', 'username: admin id_permissao: administrador', 'insert', 'root@localhost', NULL),
('2019-05-15 16:08:01', ' user_name : auditor email : auditor', 'insert', 'root@localhost', NULL),
('2019-05-15 16:08:01', 'username: auditor id_permissao: auditor', 'insert', 'root@localhost', NULL),
('2019-05-15 16:08:11', ' user_name : migrador email : migrador', 'insert', 'root@localhost', NULL),
('2019-05-15 16:08:11', 'username: migrador id_permissao: migrador', 'insert', 'root@localhost', NULL),
('2019-05-15 16:08:19', ' user_name : user email : user', 'insert', 'root@localhost', NULL),
('2019-05-15 16:08:19', 'id_investigador: 1 email: user', 'insert', 'root@localhost', NULL),
('2019-05-15 16:08:19', 'username: user id_permissao: investigador', 'insert', 'root@localhost', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `sid_user`
--

CREATE TABLE `sid_user` (
  `id_user` int(11) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `sid_user`
--

INSERT INTO `sid_user` (`id_user`, `user_name`, `user_password`, `email`) VALUES
(1, 'admin', 'admin', 'admin'),
(2, 'auditor', 'auditor', 'auditor'),
(3, 'migrador', 'migrador', 'migrador'),
(4, 'user', 'user', 'user');

--
-- Acionadores `sid_user`
--
DELIMITER $$
CREATE TRIGGER `sid_user_delete` AFTER DELETE ON `sid_user` FOR EACH ROW BEGIN
	INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao, username) values (SYSDATE(), CONCAT(' user_name : ' , OLD.user_name, ' email : ' ,OLD.email), 'delete', CURRENT_USER);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `sid_user_insert` AFTER INSERT ON `sid_user` FOR EACH ROW BEGIN
	INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao, username) values (SYSDATE(), CONCAT(' user_name : ' ,NEW.user_name, ' email : ' ,NEW.email), 'insert', CURRENT_USER);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `sid_user_update` AFTER UPDATE ON `sid_user` FOR EACH ROW BEGIN  
	IF  OLD.id_user <> NEW.id_user THEN 
		SET @tipo = 'id_user';
        SET @antigo = OLD.id_user;
        SET @novo = NEW.id_user;
	ELSEIF OLD.user_name <> NEW.user_name  THEN 
		SET @tipo = 'user_name';
        SET @antigo = OLD.user_name;
        SET @novo = NEW.user_name;
    ELSEIF OLD.user_password <> NEW.user_password  THEN 
		SET @tipo = 'user_password changed';
        SET @antigo = ' ';
        SET @novo = ' ';
    ELSEIF OLD.email <> NEW.email  THEN 
		SET @tipo = 'email';
        SET @antigo = OLD.email;
        SET @novo = NEW.email;
	END IF;    
	INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao, username) values (SYSDATE(), concat('Campo: ' , @tipo, 'alterado de ', @antigo, ' para ', @novo), 'update', CURRENT_USER);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `sid_user_permissoes`
--

CREATE TABLE `sid_user_permissoes` (
  `username` varchar(250) DEFAULT NULL,
  `permissao` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `sid_user_permissoes`
--

INSERT INTO `sid_user_permissoes` (`username`, `permissao`) VALUES
('admin', 'administrador'),
('auditor', 'auditor'),
('migrador', 'migrador'),
('user', 'investigador');

--
-- Acionadores `sid_user_permissoes`
--
DELIMITER $$
CREATE TRIGGER `sid_user_permissoes_delete` AFTER DELETE ON `sid_user_permissoes` FOR EACH ROW BEGIN
	INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao, username) values (SYSDATE(), CONCAT('username: ', OLD.username,' id_permissao: ' ,OLD.permissao), 'delete', CURRENT_USER);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `sid_user_permissoes_insert` AFTER INSERT ON `sid_user_permissoes` FOR EACH ROW BEGIN
	INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao, username) values (SYSDATE(), CONCAT('username: ', NEW.username,' id_permissao: ' ,NEW.permissao), 'insert', CURRENT_USER);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `sid_user_permissoes_update` AFTER UPDATE ON `sid_user_permissoes` FOR EACH ROW BEGIN  
	IF  OLD.permissao <> NEW.permissao THEN 
		SET @tipo = 'permissao';
        SET @antigo = OLD.permissao;
        SET @novo = NEW.permissao;
	ELSEIF OLD.username <> NEW.username THEN 
		SET @tipo = 'username';
        SET @antigo = OLD.username ;
        SET @novo = NEW.username ;
	END IF;    
	INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao, username) values (SYSDATE(), CONCAT('Campo: ' , @tipo , 'alterado de ' , @antigo , ' para ', @novo), 'update' , CURRENT_USER);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `valores_estranhos`
--

CREATE TABLE `valores_estranhos` (
  `data_hora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id_cultura` int(11) NOT NULL,
  `id_variavel` int(11) NOT NULL,
  `numero_medicao` int(11) NOT NULL,
  `valor_medicao` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `variaveis`
--

CREATE TABLE `variaveis` (
  `id_variavel` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Acionadores `variaveis`
--
DELIMITER $$
CREATE TRIGGER `variaveis_delete` AFTER DELETE ON `variaveis` FOR EACH ROW BEGIN
	INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao, username) values (SYSDATE(), CONCAT('id_variavel : ', OLD.id_variavel  , ' nome  : ' , OLD.nome ), 'delete', CURRENT_USER);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `variaveis_insert` AFTER INSERT ON `variaveis` FOR EACH ROW BEGIN
	INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao,username) values (SYSDATE(), CONCAT('id_variavel : ', NEW.id_variavel  , ' nome : ' ,NEW.nome ), 'insert',CURRENT_USER);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `variaveis_update` AFTER UPDATE ON `variaveis` FOR EACH ROW BEGIN
	IF  OLD.id_variavel  <> NEW.id_variavel  THEN 
		SET @field = 'id_variavel';
        SET @antigo = OLD.id_variavel;
        SET @novo = NEW.id_variavel;
	ELSEIF OLD.nome    <> NEW.nome   THEN 
		SET @field = 'nome';
        SET @antigo = OLD.nome;
        SET @novo = NEW.nome;
	END IF;    
	INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao, username) values (SYSDATE(), concat('Campo: ' , @field, 'alterado de ', @antigo, ' para ', @novo), 'update', CURRENT_USER);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `variaveis_medidas`
--

CREATE TABLE `variaveis_medidas` (
  `limite_inferior` decimal(10,2) NOT NULL,
  `limite_superior` decimal(10,2) NOT NULL,
  `id_variavel` int(11) NOT NULL,
  `id_cultura` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Acionadores `variaveis_medidas`
--
DELIMITER $$
CREATE TRIGGER `variaveis_medidas_delete` AFTER DELETE ON `variaveis_medidas` FOR EACH ROW BEGIN
	INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao, username) values (SYSDATE(), CONCAT('limite_inferior: ', OLD.limite_inferior , ' limite_superior: ' ,OLD.limite_superior, ' id_variavel: ', OLD.id_variavel , ' id_cultura: ' ,OLD.id_cultura), 'delete', CURRENT_USER);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `variaveis_medidas_insert` AFTER INSERT ON `variaveis_medidas` FOR EACH ROW BEGIN
	INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao, username) values (SYSDATE(), CONCAT('limite_inferior: ', NEW.limite_inferior , ' limite_superior: ' ,NEW.limite_superior, ' id_variavel: ', NEW.id_variavel , ' id_cultura: ' ,NEW.id_cultura), 'insert',CURRENT_USER);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `variaveis_medidas_update` AFTER UPDATE ON `variaveis_medidas` FOR EACH ROW BEGIN  
	IF  OLD.limite_inferior <> NEW.limite_inferior THEN 
		SET @tipo = 'limite_inferior';
        SET @antigo = OLD.limite_inferior;
        SET @novo = NEW.limite_inferior;
	ELSEIF OLD.limite_superior <> NEW.limite_superior  THEN 
		SET @tipo = 'limite_superior';
        SET @antigo = OLD.limite_superior;
        SET @novo = NEW.limite_superior;
    ELSEIF OLD.id_variavel <> NEW.id_variavel  THEN 
		SET @tipo = 'id_variavel';
        SET @antigo = OLD.id_variavel;
        SET @novo = NEW.id_variavel;
	ELSEIF OLD.id_cultura <> NEW.id_cultura  THEN 
		SET @tipo = 'id_cultura';
        SET @antigo = OLD.id_cultura;
        SET @novo = NEW.id_cultura;
	END IF;    
	INSERT INTO SID.SID_LOG (momento_criacao,mensagem,operacao, username) values (SYSDATE(), concat('Campo: ' , @tipo, 'alterado de ', @antigo, ' para ', @novo), 'update', CURRENT_USER);
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cultura`
--
ALTER TABLE `cultura`
  ADD PRIMARY KEY (`id_cultura`),
  ADD KEY `responsavel` (`responsavel`);

--
-- Indexes for table `investigador`
--
ALTER TABLE `investigador`
  ADD PRIMARY KEY (`id_investigador`),
  ADD KEY `email` (`email`);

--
-- Indexes for table `medicoes`
--
ALTER TABLE `medicoes`
  ADD PRIMARY KEY (`numero_medicao`),
  ADD KEY `id_variavel` (`id_variavel`),
  ADD KEY `id_cultura` (`id_cultura`);

--
-- Indexes for table `sid_user`
--
ALTER TABLE `sid_user`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `email` (`email`);

--
-- Indexes for table `variaveis`
--
ALTER TABLE `variaveis`
  ADD PRIMARY KEY (`id_variavel`);

--
-- Indexes for table `variaveis_medidas`
--
ALTER TABLE `variaveis_medidas`
  ADD KEY `id_variavel` (`id_variavel`) USING BTREE,
  ADD KEY `id_cultura` (`id_cultura`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `investigador`
--
ALTER TABLE `investigador`
  MODIFY `id_investigador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `medicoes`
--
ALTER TABLE `medicoes`
  MODIFY `numero_medicao` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sid_user`
--
ALTER TABLE `sid_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cultura`
--
ALTER TABLE `cultura`
  ADD CONSTRAINT `responsavel` FOREIGN KEY (`responsavel`) REFERENCES `investigador` (`id_investigador`) ON UPDATE CASCADE;

--
-- Limitadores para a tabela `investigador`
--
ALTER TABLE `investigador`
  ADD CONSTRAINT `email` FOREIGN KEY (`email`) REFERENCES `sid_user` (`email`) ON UPDATE CASCADE;

--
-- Limitadores para a tabela `medicoes`
--
ALTER TABLE `medicoes`
  ADD CONSTRAINT `id_cultura` FOREIGN KEY (`id_cultura`) REFERENCES `variaveis_medidas` (`id_cultura`) ON UPDATE CASCADE,
  ADD CONSTRAINT `id_variavel` FOREIGN KEY (`id_variavel`) REFERENCES `variaveis_medidas` (`id_variavel`) ON UPDATE CASCADE;

--
-- Limitadores para a tabela `variaveis_medidas`
--
ALTER TABLE `variaveis_medidas`
  ADD CONSTRAINT `id_cultura2` FOREIGN KEY (`id_cultura`) REFERENCES `cultura` (`id_cultura`) ON UPDATE CASCADE,
  ADD CONSTRAINT `id_variavel2` FOREIGN KEY (`id_variavel`) REFERENCES `variaveis` (`id_variavel`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
