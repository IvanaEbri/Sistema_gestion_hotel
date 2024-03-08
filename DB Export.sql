-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: base_reserva
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idpersona` int NOT NULL AUTO_INCREMENT,
  `codigo_cliente` varchar(10) NOT NULL,
  PRIMARY KEY (`idpersona`),
  CONSTRAINT `fk_persona_cliente` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (7,'123'),(9,'27');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumo`
--

DROP TABLE IF EXISTS `consumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consumo` (
  `idconsumo` int NOT NULL AUTO_INCREMENT,
  `idreserva` int NOT NULL,
  `idproducto` int NOT NULL,
  `cantidad` decimal(7,2) NOT NULL,
  `precio_venta` decimal(7,2) NOT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`idconsumo`),
  KEY `fk_consumo_producto_idx` (`idproducto`),
  KEY `fk_consumo_reserva_idx` (`idreserva`),
  CONSTRAINT `fk_consumo_producto` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`),
  CONSTRAINT `fk_consumo_reserva` FOREIGN KEY (`idreserva`) REFERENCES `reserva` (`idreserva`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumo`
--

LOCK TABLES `consumo` WRITE;
/*!40000 ALTER TABLE `consumo` DISABLE KEYS */;
INSERT INTO `consumo` VALUES (1,1,1,5.00,50.00,'Aceptado'),(2,2,1,8.00,50.00,'Cancelado'),(3,2,1,2.00,50.00,'Aceptado');
/*!40000 ALTER TABLE `consumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitacion`
--

DROP TABLE IF EXISTS `habitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `habitacion` (
  `idhabitacion` int NOT NULL AUTO_INCREMENT,
  `numero` varchar(4) NOT NULL,
  `piso` varchar(2) NOT NULL,
  `descripcion` varchar(512) DEFAULT NULL,
  `caracteristicas` varchar(512) DEFAULT NULL,
  `precio_diario` decimal(7,2) NOT NULL,
  `estado` varchar(15) NOT NULL,
  `tipo_habitacion` varchar(20) NOT NULL,
  PRIMARY KEY (`idhabitacion`),
  UNIQUE KEY `numero_UNIQUE` (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitacion`
--

LOCK TABLES `habitacion` WRITE;
/*!40000 ALTER TABLE `habitacion` DISABLE KEYS */;
INSERT INTO `habitacion` VALUES (3,'101','1','primer habitacion al salid del ascensor','una cama simple, cuenta con bañera',200.00,'Ocupada','Individual'),(5,'201','2','','',234.00,'Ocupada','Matrimonial'),(6,'202','2','','',500.00,'Disponible','Matrimonial');
/*!40000 ALTER TABLE `habitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago` (
  `idpago` int NOT NULL AUTO_INCREMENT,
  `idreserva` int NOT NULL,
  `tipo_comprobante` varchar(20) NOT NULL,
  `num_comprobante` varchar(12) NOT NULL,
  `impuestos` decimal(4,2) NOT NULL,
  `total_pago` decimal(9,2) NOT NULL,
  `fecha_emision` date NOT NULL,
  `fecha_pago` date NOT NULL,
  PRIMARY KEY (`idpago`),
  KEY `fk_pago_reserva_idx` (`idreserva`),
  CONSTRAINT `fk_pago_reserva` FOREIGN KEY (`idreserva`) REFERENCES `reserva` (`idreserva`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
INSERT INTO `pago` VALUES (3,2,'Boleta','4555',0.00,1000.00,'2024-03-13','2024-03-12'),(4,1,'Boleta','455',0.00,200.00,'2024-03-09','2024-03-09'),(6,4,'Boleta','0',0.00,5000.00,'2024-03-09','2024-03-09');
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `idpersona` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `tipo_documento` varchar(20) NOT NULL,
  `numero_documento` varchar(8) NOT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpersona`),
  UNIQUE KEY `numero_documento_UNIQUE` (`numero_documento`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (2,'Juan','Perez','DNI','12345','','',''),(3,'Juan','Perez','DNI','23456','','',''),(4,'Carlos','Diaz','DNI','89054','','',''),(5,'Mariana','Juana','DNI','48623','','',''),(7,'Nahuel','Ebri','DNI','15663','','',''),(8,'administrador','sist','DNI','0','','',''),(9,'Ivana','Ebri','DNI','565','','','');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idproducto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `unidad_medida` varchar(20) NOT NULL,
  `precio_venta` decimal(7,2) NOT NULL,
  PRIMARY KEY (`idproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'producto 1','probando','KG',50.00);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `idreserva` int NOT NULL AUTO_INCREMENT,
  `idhabitacion` int NOT NULL,
  `idcliente` int NOT NULL,
  `idtrabajador` int NOT NULL,
  `tipo_reserva` varchar(30) NOT NULL,
  `fecha_reserva` date NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `fecha_salida` date NOT NULL,
  `costo_alojamiento` decimal(7,2) NOT NULL,
  `observacion` varchar(512) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idreserva`),
  KEY `fk_reserva_habitacion_idx` (`idhabitacion`),
  KEY `fk_reserva_cliente_idx` (`idcliente`),
  KEY `fk_reserva_trabajador_idx` (`idtrabajador`),
  CONSTRAINT `fk_reserva_cliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idpersona`),
  CONSTRAINT `fk_reserva_habitacion` FOREIGN KEY (`idhabitacion`) REFERENCES `habitacion` (`idhabitacion`),
  CONSTRAINT `fk_reserva_trabajador` FOREIGN KEY (`idtrabajador`) REFERENCES `trabajador` (`idpersona`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (1,5,7,3,'Reserva','2024-03-02','2024-03-14','2024-03-16',200.00,NULL,'Pagada'),(2,6,9,8,'Reserva','2024-03-08','2024-03-10','2024-03-12',500.00,NULL,'Alquiler'),(4,6,7,8,'Reserva','2024-03-09','2024-03-16','2024-03-21',5000.00,NULL,'Pagada'),(5,5,7,8,'Reserva','2024-03-16','2024-03-15','2024-03-21',0.00,'prueba2','Alquiler');
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajador`
--

DROP TABLE IF EXISTS `trabajador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trabajador` (
  `idpersona` int NOT NULL AUTO_INCREMENT,
  `sueldo` decimal(7,2) NOT NULL,
  `acceso` varchar(20) NOT NULL,
  `login` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `estado` varchar(1) NOT NULL,
  PRIMARY KEY (`idpersona`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  CONSTRAINT `fk_persona_trabajador` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajador`
--

LOCK TABLES `trabajador` WRITE;
/*!40000 ALTER TABLE `trabajador` DISABLE KEYS */;
INSERT INTO `trabajador` VALUES (3,1000.00,'Administrador','JPerez','123456','A'),(4,134.00,'Administrador','Carlitos','prueba','I'),(5,400.00,'Empleado','MJuana','contraseña','A'),(8,0.00,'Administrador','admin','admin123','A');
/*!40000 ALTER TABLE `trabajador` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-07 21:02:36
