-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Matriculas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Matriculas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Matriculas` DEFAULT CHARACTER SET utf8 ;
USE `Matriculas` ;

-- -----------------------------------------------------
-- Table `Matriculas`.`matricula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Matriculas`.`matricula` (
  `idmatricula` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(75) NOT NULL,
  `fullAge` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `adress` VARCHAR(100) NOT NULL,
  `cep` VARCHAR(15) NULL,
  `phone` VARCHAR(45) NULL,
  `obs` VARCHAR(150) NULL,
  `active` TINYINT NOT NULL,
  `user` VARCHAR(75) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `course` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idmatricula`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
