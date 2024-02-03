-- MySQL Script generated by MySQL Workbench
-- Thu Feb  1 21:30:40 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema base_reserva
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema base_reserva
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `base_reserva` DEFAULT CHARACTER SET utf8 ;
USE `base_reserva` ;

-- -----------------------------------------------------
-- Table `base_reserva`.`habitacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `base_reserva`.`habitacion` (
  `idhabitacion` INT NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(4) NOT NULL,
  `piso` VARCHAR(2) NOT NULL,
  `descripcion` VARCHAR(512) NULL,
  `caracteristicas` VARCHAR(512) NULL,
  `precio_diario` DECIMAL(7,2) NOT NULL,
  `estado` VARCHAR(15) NOT NULL,
  `tipo_habitacion` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idhabitacion`),
  UNIQUE INDEX `numero_UNIQUE` (`numero` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `base_reserva`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `base_reserva`.`persona` (
  `idpersona` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NOT NULL,
  `apellido` VARCHAR(20) NOT NULL,
  `tipo_documento` VARCHAR(20) NOT NULL,
  `numero_documento` VARCHAR(8) NOT NULL,
  `direccion` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`idpersona`),
  UNIQUE INDEX `numero_documento_UNIQUE` (`numero_documento` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `base_reserva`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `base_reserva`.`cliente` (
  `idpersona` INT NOT NULL AUTO_INCREMENT,
  `codigo_cliente` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idpersona`),
  CONSTRAINT `fk_persona_cliente`
    FOREIGN KEY (`idpersona`)
    REFERENCES `base_reserva`.`persona` (`idpersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `base_reserva`.`trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `base_reserva`.`trabajador` (
  `idpersona` INT NOT NULL AUTO_INCREMENT,
  `sueldo` DECIMAL(7,2) NOT NULL,
  `acceso` VARCHAR(20) NOT NULL,
  `login` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `estado` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`idpersona`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) ,
  CONSTRAINT `fk_persona_trabajador`
    FOREIGN KEY (`idpersona`)
    REFERENCES `base_reserva`.`persona` (`idpersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `base_reserva`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `base_reserva`.`producto` (
  `idproducto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `descripcion` VARCHAR(255) NULL,
  `unidad_medida` VARCHAR(20) NOT NULL,
  `precio_venta` DECIMAL(7,2) NOT NULL,
  PRIMARY KEY (`idproducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `base_reserva`.`reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `base_reserva`.`reserva` (
  `idreserva` INT NOT NULL AUTO_INCREMENT,
  `idhabitacion` INT NOT NULL,
  `idcliente` INT NOT NULL,
  `idtrabajador` INT NOT NULL,
  `tipo_reserva` VARCHAR(30) NOT NULL,
  `fecha_reserva` DATE NOT NULL,
  `fecha_ingreso` DATE NOT NULL,
  `fecha_salida` DATE NOT NULL,
  `costo_alojamiento` DECIMAL(7,2) NOT NULL,
  `observacion` VARCHAR(512) NULL,
  `estado` VARCHAR(20) NULL,
  PRIMARY KEY (`idreserva`),
  INDEX `fk_reserva_habitacion_idx` (`idhabitacion` ASC) ,
  INDEX `fk_reserva_cliente_idx` (`idcliente` ASC) ,
  INDEX `fk_reserva_trabajador_idx` (`idtrabajador` ASC) ,
  CONSTRAINT `fk_reserva_habitacion`
    FOREIGN KEY (`idhabitacion`)
    REFERENCES `base_reserva`.`habitacion` (`idhabitacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_cliente`
    FOREIGN KEY (`idcliente`)
    REFERENCES `base_reserva`.`cliente` (`idpersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_trabajador`
    FOREIGN KEY (`idtrabajador`)
    REFERENCES `base_reserva`.`trabajador` (`idpersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `base_reserva`.`consumo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `base_reserva`.`consumo` (
  `idconsumo` INT NOT NULL AUTO_INCREMENT,
  `idreserva` INT NOT NULL,
  `idproducto` INT NOT NULL,
  `cantidad` DECIMAL(7,2) NOT NULL,
  `precio_venta` DECIMAL(7,2) NOT NULL,
  `estado` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idconsumo`),
  INDEX `fk_consumo_producto_idx` (`idproducto` ASC) ,
  INDEX `fk_consumo_reserva_idx` (`idreserva` ASC) ,
  CONSTRAINT `fk_consumo_producto`
    FOREIGN KEY (`idproducto`)
    REFERENCES `base_reserva`.`producto` (`idproducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_consumo_reserva`
    FOREIGN KEY (`idreserva`)
    REFERENCES `base_reserva`.`reserva` (`idreserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `base_reserva`.`pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `base_reserva`.`pago` (
  `idpago` INT NOT NULL AUTO_INCREMENT,
  `idreserva` INT NOT NULL,
  `tipo_comprobante` VARCHAR(20) NOT NULL,
  `num_comprobante` VARCHAR(12) NOT NULL,
  `igv` DECIMAL(4,2) NOT NULL,
  `total_pago` DECIMAL(9,2) NOT NULL,
  `fecha_emision` DATE NOT NULL,
  `fecha_pago` DATE NOT NULL,
  `estado` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idpago`),
  INDEX `fk_pago_reserva_idx` (`idreserva` ASC) ,
  CONSTRAINT `fk_pago_reserva`
    FOREIGN KEY (`idreserva`)
    REFERENCES `base_reserva`.`reserva` (`idreserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;