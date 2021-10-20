-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema seap
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema seap
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `seap` DEFAULT CHARACTER SET utf8 ;
USE `seap` ;

-- -----------------------------------------------------
-- Table `seap`.`Lotacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `seap`.`Lotacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` NVARCHAR(400) NULL,
  `descricao` NVARCHAR(200) NULL,
  `data_cadastro` DATETIME NULL DEFAULT now(),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `seap`.`Servidor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `seap`.`Servidor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `matricula` NVARCHAR(30) NOT NULL,
  `nome` NVARCHAR(400) NULL,
  `data_cadastro` DATETIME NULL DEFAULT now(),
  `lotacao_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Servidor_Lotacao_idx` (`lotacao_id` ASC) VISIBLE,
  CONSTRAINT `fk_Servidor_Lotacao`
    FOREIGN KEY (`lotacao_id`)
    REFERENCES `seap`.`Lotacao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
