-- MySQL Script generated by MySQL Workbench
-- Wed May 15 14:44:24 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema triplay
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema triplay
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `triplay` DEFAULT CHARACTER SET utf8 ;
USE `triplay` ;

-- -----------------------------------------------------
-- Table `triplay`.`member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `triplay`.`member` ;

CREATE TABLE IF NOT EXISTS `triplay`.`member` (
  `member_id` VARCHAR(255) NOT NULL,
  `member_pw` VARCHAR(255) NOT NULL,
  `member_name` VARCHAR(255) NOT NULL,
  `member_email` VARCHAR(255) NOT NULL,
  `salt` VARCHAR(255) NOT NULL,
  `token` VARCHAR(1000) NOT NULL,
  `member_status` VARCHAR(255) default 'ACTIVE',
  `score` INT NULL DEFAULT 0,
  check (member_status in ('ACTIVE', 'WITHDRAWN')),
  PRIMARY KEY (`member_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `triplay`.`game`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `triplay`.`game` ;

CREATE TABLE IF NOT EXISTS `triplay`.`game` (
  `game_id` INT NOT NULL AUTO_INCREMENT,
  `seed_id` INT NOT NULL,
  `member_id` VARCHAR(255) NOT NULL,
  `difficulty` VARCHAR(45) NULL,
  `game_title` VARCHAR(255) NULL,
  check (difficulty in ('EASY', 'HARD', null)),
  PRIMARY KEY (`game_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `triplay`.`seed`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `triplay`.`seed` ;

CREATE TABLE IF NOT EXISTS `triplay`.`seed` (
  `seed_id` INT NOT NULL AUTO_INCREMENT,
  `keyword` VARCHAR(255) NOT NULL,
  `count` INT NOT NULL,
  `seed_info` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`seed_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `triplay`.`file`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `triplay`.`file` ;

CREATE TABLE IF NOT EXISTS `triplay`.`file` (
  `file_id` INT NOT NULL AUTO_INCREMENT,
  `save_folder` VARCHAR(255) NOT NULL,
  `original_folder` VARCHAR(255) NOT NULL,
  `save_file` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`file_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `triplay`.`plan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `triplay`.`plan` ;

CREATE TABLE IF NOT EXISTS `triplay`.`plan` (
  `plan_id` INT NOT NULL AUTO_INCREMENT,
  `plan_title` VARCHAR(255) NOT NULL,
  `member_id` VARCHAR(255) NOT NULL,
  `plan_content` VARCHAR(1000) NULL,
  `seed_id` VARCHAR(45) NOT NULL,
  `estimate_time` VARCHAR(45) NOT NULL,
  `distance` VARCHAR(45) NOT NULL,
  `hit` INT NOT NULL DEFAULT 0,
  `file_id` INT NULL,
  `register_time` DATETIME NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY (`plan_id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


