CREATE DATABASE  IF NOT EXISTS `ordini` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ordini`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ordini
-- ------------------------------------------------------
-- Server version	5.6.38-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bolle`
--

DROP TABLE IF EXISTS `bolle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bolle` (
  `idBolla` int(8) NOT NULL,
  `stato` tinyint(4) DEFAULT NULL,
  `idContenuto1` int(50) DEFAULT NULL,
  `idContenuto2` int(50) DEFAULT NULL,
  `position` int(8) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idBolla`),
  UNIQUE KEY `idBolla_UNIQUE` (`idBolla`),
  UNIQUE KEY `position_UNIQUE` (`position`),
  KEY `id_contenuto1_idx` (`idContenuto1`),
  KEY `id_contenuto2_idx` (`idContenuto2`),
  CONSTRAINT `id_contenuto1` FOREIGN KEY (`idContenuto1`) REFERENCES `contenuti` (`idContenuto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_contenuto2` FOREIGN KEY (`idContenuto2`) REFERENCES `contenuti` (`idContenuto`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bolle`
--

LOCK TABLES `bolle` WRITE;
/*!40000 ALTER TABLE `bolle` DISABLE KEYS */;
INSERT INTO `bolle` VALUES (4273551,1,14541,14484,3),(15748591,1,14503,14485,11),(19171656,1,14476,14477,1),(30047667,1,14475,14474,2),(39646788,0,14489,14471,6),(39711021,0,14479,14471,7),(50220038,1,14497,14487,8),(69272389,1,14486,14478,4),(76750507,1,14488,14540,13),(86790833,1,14482,14543,9),(90005120,1,14480,14498,12),(96582755,1,14495,14492,5),(98687684,1,14548,14493,10);
/*!40000 ALTER TABLE `bolle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contenuti`
--

DROP TABLE IF EXISTS `contenuti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contenuti` (
  `idContenuto` int(50) NOT NULL AUTO_INCREMENT,
  `idProdotto` int(10) NOT NULL,
  `nomeWarehouse` varchar(45) DEFAULT NULL,
  `stato` tinyint(4) NOT NULL,
  PRIMARY KEY (`idContenuto`),
  KEY `nome_warehouse_idx` (`nomeWarehouse`),
  KEY `id_prodotto_idx` (`idProdotto`),
  CONSTRAINT `id_prodotto` FOREIGN KEY (`idProdotto`) REFERENCES `prodotti` (`idProdotto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `nome_warehouse` FOREIGN KEY (`nomeWarehouse`) REFERENCES `warehouses` (`nomeWarehouse`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14559 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contenuti`
--

LOCK TABLES `contenuti` WRITE;
/*!40000 ALTER TABLE `contenuti` DISABLE KEYS */;
INSERT INTO `contenuti` VALUES (14459,11,NULL,0),(14460,13,NULL,0),(14461,10,NULL,0),(14462,9,NULL,0),(14463,8,NULL,0),(14464,3,NULL,0),(14465,2,NULL,0),(14466,4,NULL,0),(14467,12,NULL,0),(14468,14,NULL,0),(14469,1,NULL,0),(14470,15,NULL,0),(14471,5,NULL,0),(14472,16,NULL,0),(14473,7,NULL,0),(14474,5,'warehouseA',0),(14475,16,'warehouseA',0),(14476,7,'warehouseA',0),(14477,15,'warehouseA',0),(14478,15,'warehouseA',0),(14479,7,'warehouseA',0),(14480,7,'warehouseA',0),(14481,7,'warehouseA',1),(14482,15,'warehouseA',0),(14483,16,'warehouseA',1),(14484,8,'warehouseA',0),(14485,8,'warehouseA',0),(14486,9,'warehouseA',0),(14487,9,'warehouseA',0),(14488,9,'warehouseA',0),(14489,4,'warehouseA',0),(14490,1,'warehouseA',1),(14491,1,'warehouseA',1),(14492,3,'warehouseA',0),(14493,2,'warehouseA',0),(14494,1,'warehouseA',1),(14495,12,'warehouseA',0),(14496,12,'warehouseA',1),(14497,4,'warehouseA',0),(14498,14,'warehouseA',0),(14499,14,'warehouseA',1),(14500,1,'warehouseA',1),(14501,12,'warehouseA',1),(14502,3,'warehouseA',1),(14503,4,'warehouseA',0),(14504,2,'warehouseA',1),(14505,2,'warehouseA',1),(14506,3,'warehouseA',1),(14507,12,'warehouseA',1),(14508,3,'warehouseA',1),(14509,3,'warehouseA',1),(14510,12,'warehouseA',1),(14511,4,'warehouseA',1),(14512,4,'warehouseA',1),(14513,14,'warehouseA',1),(14514,12,'warehouseA',1),(14515,3,'warehouseA',1),(14516,1,'warehouseA',1),(14517,2,'warehouseA',1),(14518,2,'warehouseA',1),(14519,1,'warehouseA',1),(14520,12,'warehouseA',1),(14521,1,'warehouseA',1),(14522,12,'warehouseA',1),(14523,4,'warehouseA',1),(14524,2,'warehouseA',1),(14525,2,'warehouseA',1),(14526,2,'warehouseA',1),(14527,3,'warehouseA',1),(14528,4,'warehouseA',1),(14529,12,'warehouseA',1),(14530,14,'warehouseA',1),(14531,4,'warehouseA',1),(14532,2,'warehouseA',1),(14533,1,'warehouseA',1),(14534,4,'warehouseA',1),(14535,12,'warehouseA',1),(14536,3,'warehouseA',1),(14537,2,'warehouseA',1),(14538,3,'warehouseA',1),(14539,13,'warehouseA',1),(14540,11,'warehouseA',0),(14541,10,'warehouseA',0),(14542,11,'warehouseA',1),(14543,10,'warehouseA',0),(14544,3,'warehouseA',1),(14545,13,'warehouseA',1),(14546,9,'warehouseA',1),(14547,16,'warehouseA',1),(14548,15,'warehouseA',0),(14549,1,'warehouseB',1),(14550,5,'warehouseB',1),(14551,13,'warehouseB',1),(14552,8,'warehouseB',1),(14553,8,'warehouseB',1),(14554,1,'warehouseB',1),(14555,4,'warehouseB',1),(14556,16,'warehouseB',1),(14557,15,'warehouseB',1),(14558,4,'warehouseB',1);
/*!40000 ALTER TABLE `contenuti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodotti`
--

DROP TABLE IF EXISTS `prodotti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prodotti` (
  `idProdotto` int(10) NOT NULL AUTO_INCREMENT,
  `marcaProdotto` varchar(45) NOT NULL,
  `modelloProdotto` varchar(45) NOT NULL,
  `tipoProdotto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProdotto`),
  KEY `tipo_prodotto_idx` (`tipoProdotto`),
  CONSTRAINT `tipo_prodotto` FOREIGN KEY (`tipoProdotto`) REFERENCES `tipo_prodotti` (`tipoProdotto`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotti`
--

LOCK TABLES `prodotti` WRITE;
/*!40000 ALTER TABLE `prodotti` DISABLE KEYS */;
INSERT INTO `prodotti` VALUES (1,'Samsung','Galaxy S8','Smartphone'),(2,'Apple','iPhone X','Smartphone'),(3,'Apple','iPhone 8','Smartphone'),(4,'Asus','Zenfone 4','Smartphone'),(5,'LG','SUPER UHD','Televisore'),(7,'Samsung','QLED Smart Ultra HD','Televisore'),(8,'Samsung','Addwash','Lavatrice'),(9,'Bosch','Serie 2','Lavatrice'),(10,'Whirlpool','No Frost','Frigorifero'),(11,'Samsung','Side by Side','Frigorifero'),(12,'Samsung','Galaxy NOTE 8','Smartphone'),(13,'Whirlpool','6th Sense','Frigorifero'),(14,'Samsung','Galaxy S7','Smartphone'),(15,'LG','Smart TV','Televisore'),(16,'Panasonic','FULL HD','Televisore');
/*!40000 ALTER TABLE `prodotti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_prodotti`
--

DROP TABLE IF EXISTS `tipo_prodotti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_prodotti` (
  `tipoProdotto` varchar(45) NOT NULL,
  PRIMARY KEY (`tipoProdotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_prodotti`
--

LOCK TABLES `tipo_prodotti` WRITE;
/*!40000 ALTER TABLE `tipo_prodotti` DISABLE KEYS */;
INSERT INTO `tipo_prodotti` VALUES ('Frigorifero'),('Lavatrice'),('Smartphone'),('Televisore');
/*!40000 ALTER TABLE `tipo_prodotti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouses`
--

DROP TABLE IF EXISTS `warehouses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warehouses` (
  `nomeWarehouse` varchar(45) NOT NULL,
  PRIMARY KEY (`nomeWarehouse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouses`
--

LOCK TABLES `warehouses` WRITE;
/*!40000 ALTER TABLE `warehouses` DISABLE KEYS */;
INSERT INTO `warehouses` VALUES ('warehouseA'),('warehouseB');
/*!40000 ALTER TABLE `warehouses` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-30 17:37:30
