-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: mibd
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cartelera`
--

DROP TABLE IF EXISTS `cartelera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cartelera` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `informarcion` varchar(255) DEFAULT NULL,
  `subtitulo` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `dueño_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhgncjkisb7g4vs0daso06jwt3` (`dueño_id`),
  CONSTRAINT `FKhgncjkisb7g4vs0daso06jwt3` FOREIGN KEY (`dueño_id`) REFERENCES `usuario` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartelera`
--

LOCK TABLES `cartelera` WRITE;
/*!40000 ALTER TABLE `cartelera` DISABLE KEYS */;
INSERT INTO `cartelera` VALUES (1,'ut sollicitudin velit pretium sit amet. Mauris imperdiet ','subtitulo1','titulo1',2),(2,'ut sollicitudin velit pretium sit amet. Mauris imperdiet ','subtitulo2','titulo2',2),(3,'ut sollicitudin velit pretium sit amet. Mauris imperdiet ','subtitulo3','titulo3',3),(4,'ut sollicitudin velit pretium sit amet. Mauris imperdiet ','subtitulo4','titulo4',3),(7,'informacion extra ','subtitulo6','titulo6',2);
/*!40000 ALTER TABLE `cartelera` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-14 18:10:35
