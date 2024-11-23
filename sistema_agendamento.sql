-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 24-Nov-2024 às 00:47
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

DROP DATABASE IF EXISTS `sistema_agendamento`;
CREATE DATABASE `sistema_agendamento`
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;
USE `sistema_agendamento`;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `sistema_agendamento`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `agendamento`
--

CREATE TABLE `agendamento` (
  `idAgenda` int(11) NOT NULL,
  `dataAgenda` date NOT NULL,
  `horaAgenda` time NOT NULL,
  `cpf_pac_FK` varchar(11) NOT NULL,
  `cpf_med_FK` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `agendamento`
--

INSERT INTO `agendamento` (`idAgenda`, `dataAgenda`, `horaAgenda`, `cpf_pac_FK`, `cpf_med_FK`) VALUES
(4, '2024-11-26', '09:00:00', '11077259093', '12537957032'),
(5, '2024-11-26', '09:00:00', '47327255036', '88819988070'),
(6, '2024-11-26', '09:00:00', '94680359056', '51891498037');

-- --------------------------------------------------------

--
-- Estrutura da tabela `especialidade`
--

CREATE TABLE `especialidade` (
  `idEsp` int(11) NOT NULL,
  `nomeEsp` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `especialidade`
--

INSERT INTO `especialidade` (`idEsp`, `nomeEsp`) VALUES
(6, 'Ortopedia'),
(7, 'Oftalmologia'),
(8, 'Neurologia'),
(9, 'Dermatologia'),
(10, 'Pediatria');

-- --------------------------------------------------------

--
-- Estrutura da tabela `medico`
--

CREATE TABLE `medico` (
  `cpfMed` varchar(11) NOT NULL,
  `nomeMed` varchar(50) NOT NULL,
  `endMed` varchar(200) NOT NULL,
  `telMed` varchar(11) NOT NULL,
  `crmMed` varchar(11) NOT NULL,
  `id_esp_FK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `medico`
--

INSERT INTO `medico` (`cpfMed`, `nomeMed`, `endMed`, `telMed`, `crmMed`, `id_esp_FK`) VALUES
('12537957032', 'Vera Moraes', 'Rua Guanabara 726', '44444444444', '444444', 10),
('51891498037', 'Amanda Vila', 'Rua São Luís 51', '55555555555', '555555', 6),
('75739619017', 'Sandro Furtado', 'Avenida Nilza 34', '33333333333', '333333', 8),
('88819988070', 'Joaquim Lemos', 'Rua Baker', '22222222222', '222222', 7),
('91188633023', 'Sandro Menezes', 'Rua aqui perto', '11111111111', '111111', 9);

-- --------------------------------------------------------

--
-- Estrutura da tabela `paciente`
--

CREATE TABLE `paciente` (
  `cpfPac` varchar(11) NOT NULL,
  `nomePac` varchar(50) NOT NULL,
  `endPac` varchar(200) NOT NULL,
  `telPac` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `paciente`
--

INSERT INTO `paciente` (`cpfPac`, `nomePac`, `endPac`, `telPac`) VALUES
('11077259093', 'Diego Belluci', 'Rua Sete de Setembro 77', '22222222222'),
('35827021032', 'Osvaldo Fonseca', 'Rua Dezoito de Novembro 89', '44444444444'),
('41995748080', 'Aline Nazário', 'Rua Francisco Madruga Filho 42', '55555555555'),
('47327255036', 'Kelly Nascimento', 'Rua Nepoziano Jordão 34', '11111111111'),
('94680359056', 'Geraldo Caetano', 'Passagem Maria Aguiar 22', '33333333333');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `agendamento`
--
ALTER TABLE `agendamento`
  ADD PRIMARY KEY (`idAgenda`),
  ADD KEY `cpf_med_FK` (`cpf_med_FK`),
  ADD KEY `cpf_pac_FK` (`cpf_pac_FK`);

--
-- Índices para tabela `especialidade`
--
ALTER TABLE `especialidade`
  ADD PRIMARY KEY (`idEsp`);

--
-- Índices para tabela `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`cpfMed`),
  ADD KEY `id_esp_FK` (`id_esp_FK`);

--
-- Índices para tabela `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`cpfPac`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `agendamento`
--
ALTER TABLE `agendamento`
  MODIFY `idAgenda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `especialidade`
--
ALTER TABLE `especialidade`
  MODIFY `idEsp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `agendamento`
--
ALTER TABLE `agendamento`
  ADD CONSTRAINT `agendamento_ibfk_1` FOREIGN KEY (`cpf_med_FK`) REFERENCES `medico` (`cpfMed`),
  ADD CONSTRAINT `agendamento_ibfk_2` FOREIGN KEY (`cpf_pac_FK`) REFERENCES `paciente` (`cpfPac`);

--
-- Limitadores para a tabela `medico`
--
ALTER TABLE `medico`
  ADD CONSTRAINT `medico_ibfk_1` FOREIGN KEY (`id_esp_FK`) REFERENCES `especialidade` (`idEsp`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
