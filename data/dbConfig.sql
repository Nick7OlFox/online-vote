-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: polling-db
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `options`
--

DROP TABLE IF EXISTS `options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `options` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Primary key of the table',
  `poll` int NOT NULL COMMENT 'The id of the poll this answer is for',
  `text` varchar(255) NOT NULL COMMENT 'The text of the option',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `poll_idx` (`poll`),
  CONSTRAINT `poll` FOREIGN KEY (`poll`) REFERENCES `questions` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=233 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Table that will store all the options and link them to their poll';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `options`
--

LOCK TABLES `options` WRITE;
/*!40000 ALTER TABLE `options` DISABLE KEYS */;
INSERT INTO `options` VALUES (1,16,'Option 1'),(2,16,'Option 2'),(3,17,'Option 1'),(4,17,'Option 2'),(5,18,'Option 1'),(6,18,'Option 2'),(7,19,'Manchester City'),(8,19,'Arsenal'),(9,19,'Liverpool'),(10,19,'Tottenham'),(11,19,'Chelsea'),(12,19,'Manchester United'),(13,19,'Other'),(14,20,'England'),(15,20,'France'),(16,20,'Germany'),(17,20,'Portugal'),(18,20,'Spain'),(19,20,'Italy'),(20,20,'Other'),(21,21,'England'),(22,21,'France'),(23,21,'Germany'),(24,21,'Portugal'),(25,21,'Spain'),(26,21,'Italy'),(27,21,'Other'),(28,22,'England'),(29,22,'France'),(30,22,'Germany'),(31,22,'Portugal'),(32,22,'Spain'),(33,22,'Italy'),(34,22,'Other'),(35,23,'England'),(36,23,'France'),(37,23,'Germany'),(38,23,'Portugal'),(39,23,'Spain'),(40,23,'Italy'),(41,23,'Other'),(42,24,'England'),(43,24,'France'),(44,24,'Germany'),(45,24,'Portugal'),(46,24,'Spain'),(47,24,'Italy'),(48,24,'Other'),(49,25,'England'),(50,25,'France'),(51,25,'Germany'),(52,25,'Portugal'),(53,25,'Spain'),(54,25,'Italy'),(55,25,'Other'),(56,26,'England'),(57,26,'France'),(58,26,'Germany'),(59,26,'Portugal'),(60,26,'Spain'),(61,26,'Italy'),(62,26,'Other'),(63,27,'England'),(64,27,'France'),(65,27,'Germany'),(66,27,'Portugal'),(67,27,'Spain'),(68,27,'Italy'),(69,27,'Other'),(70,28,'England'),(71,28,'France'),(72,28,'Germany'),(73,28,'Portugal'),(74,28,'Spain'),(75,28,'Italy'),(76,28,'Other'),(77,29,'England'),(78,29,'France'),(79,29,'Germany'),(80,29,'Portugal'),(81,29,'Spain'),(82,29,'Italy'),(83,29,'Other'),(84,30,'England'),(85,30,'France'),(86,30,'Germany'),(87,30,'Portugal'),(88,30,'Spain'),(89,30,'Italy'),(90,30,'Other'),(91,31,'England'),(92,31,'France'),(93,31,'Germany'),(94,31,'Portugal'),(95,31,'Spain'),(96,31,'Italy'),(97,31,'Other'),(98,32,'England'),(99,32,'France'),(100,32,'Germany'),(101,32,'Portugal'),(102,32,'Spain'),(103,32,'Italy'),(104,32,'Other'),(105,33,'England'),(106,33,'France'),(107,33,'Germany'),(108,33,'Portugal'),(109,33,'Spain'),(110,33,'Italy'),(111,33,'Other'),(112,34,'England'),(113,34,'France'),(114,34,'Germany'),(115,34,'Portugal'),(116,34,'Spain'),(117,34,'Italy'),(118,34,'Other'),(119,35,'England'),(120,35,'France'),(121,35,'Germany'),(122,35,'Portugal'),(123,35,'Spain'),(124,35,'Italy'),(125,35,'Other'),(126,36,'England'),(127,36,'France'),(128,36,'Germany'),(129,36,'Portugal'),(130,36,'Spain'),(131,36,'Italy'),(132,36,'Other'),(133,37,'England'),(134,37,'France'),(135,37,'Germany'),(136,37,'Portugal'),(137,37,'Spain'),(138,37,'Italy'),(139,37,'Other'),(140,38,'England'),(141,38,'France'),(142,38,'Germany'),(143,38,'Portugal'),(144,38,'Spain'),(145,38,'Italy'),(146,38,'Other'),(147,39,'England'),(148,39,'France'),(149,39,'Germany'),(150,39,'Portugal'),(151,39,'Spain'),(152,39,'Italy'),(153,39,'Other'),(154,40,'England'),(155,40,'France'),(156,40,'Germany'),(157,40,'Portugal'),(158,40,'Spain'),(159,40,'Italy'),(160,40,'Other'),(161,41,'England'),(162,41,'France'),(163,41,'Germany'),(164,41,'Portugal'),(165,41,'Spain'),(166,41,'Italy'),(167,41,'Other'),(168,42,'England'),(169,42,'France'),(170,42,'Germany'),(171,42,'Portugal'),(172,42,'Spain'),(173,42,'Italy'),(174,42,'Other'),(175,43,'England'),(176,43,'France'),(177,43,'Germany'),(178,43,'Portugal'),(179,43,'Spain'),(180,43,'Italy'),(181,43,'Other'),(182,44,'Option 1'),(183,44,'Option 2'),(184,44,'Option 3'),(185,44,'Option 4'),(186,44,'Option 5'),(187,44,'Option 6'),(188,44,'Option 7'),(189,45,'England'),(190,45,'France'),(191,45,'Germany'),(192,45,'Portugal'),(193,45,'Spain'),(194,45,'Italy'),(195,45,'Other'),(196,46,'England'),(197,46,'France'),(198,46,'Germany'),(199,46,'Portugal'),(200,46,'Spain'),(201,46,'Italy'),(202,46,'Other'),(203,47,'England'),(204,47,'France'),(205,47,'Germany'),(206,47,'Portugal'),(207,47,'Spain'),(208,47,'Italy'),(209,47,'Other'),(210,48,'England'),(211,48,'France'),(212,48,'Germany'),(213,48,'Portugal'),(214,48,'Spain'),(215,48,'Italy'),(216,48,'Other'),(217,49,'England'),(218,49,'France'),(219,49,'Germany'),(220,49,'Portugal'),(221,49,'Spain'),(222,49,'Italy'),(223,49,'Other'),(224,50,'England'),(225,50,'France'),(226,50,'Germany'),(227,50,'Portugal'),(228,50,'Spain'),(229,50,'Italy'),(230,50,'Other'),(231,51,'Yes'),(232,51,'No');
/*!40000 ALTER TABLE `options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Primary key of the table',
  `question` varchar(255) NOT NULL COMMENT 'The text of the question that will be presented to the user',
  `end_time` timestamp(6) NULL DEFAULT NULL COMMENT 'The time at which this poll will end. Can be null',
  `is_active` tinyint NOT NULL DEFAULT '0' COMMENT 'A flag that will indicate if this question is live or not. If nothing goes wrong, all entries shall be false except for the one active question',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idpoll_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='The table responsible for storing the questions';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'Test Question 1','2024-12-31 00:00:00.000000',0),(5,'Test Question 2','2024-12-31 00:00:00.000000',0),(6,'Test Question 3','2024-12-31 00:00:00.000000',0),(7,'Test Question 4','2024-12-31 00:00:00.000000',0),(8,'Test Question 5','2024-12-31 00:00:00.000000',0),(9,'Test Question 6','2024-12-31 01:02:03.000000',0),(10,'Test Question 7',NULL,0),(11,'Test Question 6','2024-12-31 01:02:03.000000',0),(12,'Test Question 6','2024-12-31 01:02:03.000000',0),(13,'Test Question 6','2024-12-31 01:02:03.000000',0),(14,'Test Question 6','2024-12-31 01:02:03.000000',0),(15,'Test Question 6','2024-12-31 01:02:03.000000',0),(16,'Test Question 6','2024-12-31 01:02:03.000000',0),(17,'Test Question 6','2024-12-31 01:02:03.000000',0),(18,'Test Question 6','2024-12-31 01:02:03.000000',0),(19,'Which team will win the premier league 2024/2025?','2025-05-25 17:45:00.000000',0),(20,'Which team will win Euro 2024?','2025-09-01 00:00:00.000000',0),(21,'Which team will win Euro 2024?','2024-08-25 21:10:00.000000',0),(22,'Which team will win Euro 2024?','2024-08-25 21:11:00.000000',0),(23,'Which team will win Euro 2024?','2024-08-25 21:12:00.000000',0),(24,'Which team will win Euro 2024?','2024-08-25 21:16:00.000000',0),(25,'Which team will win Euro 2024?','2024-08-25 21:16:00.000000',0),(26,'Which team will win Euro 2024?','2024-08-25 21:16:00.000000',0),(27,'Which team will win Euro 2024?','2024-08-25 21:16:00.000000',0),(28,'Which team will win Euro 2024?','2024-08-25 20:19:00.000000',0),(29,'Which team will win Euro 2024?','2024-08-25 20:21:00.000000',0),(30,'Which team will win Euro 2024?','2024-08-25 20:23:00.000000',0),(31,'Which team will win Euro 2024?','2024-08-25 20:23:00.000000',0),(32,'Which team will win Euro 2024?','2024-08-25 20:23:00.000000',0),(33,'Which team will win Euro 2024?','2024-08-25 21:25:00.000000',0),(34,'Which team will win Euro 2024?','2024-08-25 21:25:00.000000',0),(35,'Which team will win Euro 2024?','2024-08-25 21:34:00.000000',0),(36,'Which team will win Euro 2024?','2024-08-25 20:39:00.000000',0),(37,'Which team will win Euro 2024?','2024-08-25 20:39:00.000000',0),(38,'Which team will win Euro 2024?','2024-08-25 21:30:00.000000',0),(39,'Which team will win Euro 2024?','2024-08-25 21:40:00.000000',0),(40,'Which team will win Euro 2024?','2024-08-25 21:43:00.000000',0),(41,'Which team will win Euro 2024?','2024-08-25 22:45:00.000000',0),(42,'Which team will win Euro 2024?','2024-08-25 21:45:00.000000',0),(43,'Which team will win Euro 2024?','2024-08-26 09:13:00.000000',0),(44,'Test Question','2024-08-26 10:00:00.000000',0),(45,'Which team will win Euro 2024?','2024-08-26 09:30:00.000000',0),(46,'Which team will win Euro 2024?',NULL,0),(47,'Which team will win Euro 2024?','2024-08-26 11:32:00.000000',0),(48,'Which team will win Euro 2024?','2024-08-26 11:37:00.000000',0),(49,'Which team will win Euro 2024?',NULL,0),(50,'Which team will win Euro 2028?','2024-08-26 12:55:00.000000',0),(51,'Did Spain deserve to win Euro 2024?','2024-08-26 13:05:00.000000',1);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `votes`
--

DROP TABLE IF EXISTS `votes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `votes` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Primary key of the table',
  `answer` int NOT NULL COMMENT 'The id of the answer that was voted for',
  `time` timestamp(6) NOT NULL COMMENT 'The time at which the vote was cast',
  PRIMARY KEY (`id`),
  KEY `vote_idx` (`answer`),
  CONSTRAINT `vote` FOREIGN KEY (`answer`) REFERENCES `options` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='This table will store the votes for the polls';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `votes`
--

LOCK TABLES `votes` WRITE;
/*!40000 ALTER TABLE `votes` DISABLE KEYS */;
INSERT INTO `votes` VALUES (1,140,'2024-08-25 21:07:43.464000'),(2,140,'2024-08-25 21:07:58.195000'),(3,142,'2024-08-25 21:12:13.476000'),(4,144,'2024-08-25 21:12:16.449000'),(5,144,'2024-08-25 21:28:07.767000'),(6,144,'2024-08-25 21:28:09.199000'),(7,144,'2024-08-25 21:28:10.182000'),(8,144,'2024-08-25 21:28:11.031000'),(9,144,'2024-08-25 21:28:11.865000'),(10,146,'2024-08-25 21:28:20.180000'),(11,146,'2024-08-25 21:28:22.084000'),(12,147,'2024-08-25 21:38:18.929000'),(13,147,'2024-08-25 21:38:20.579000'),(14,149,'2024-08-25 21:38:24.641000'),(15,154,'2024-08-25 21:41:54.120000'),(16,154,'2024-08-25 21:41:55.975000'),(17,154,'2024-08-25 21:42:02.801000'),(18,154,'2024-08-25 21:42:03.666000'),(19,161,'2024-08-25 21:44:21.523000'),(20,161,'2024-08-25 21:44:24.240000'),(21,168,'2024-08-25 21:44:40.858000'),(22,168,'2024-08-25 21:44:42.067000'),(23,168,'2024-08-25 21:44:43.234000'),(24,168,'2024-08-25 21:44:59.842000'),(25,217,'2024-08-26 11:39:57.340000'),(26,217,'2024-08-26 11:47:00.161000'),(27,220,'2024-08-26 11:50:31.324000'),(28,220,'2024-08-26 11:52:14.949000'),(29,221,'2024-08-26 11:52:35.378000'),(30,220,'2024-08-26 11:54:48.662000'),(31,219,'2024-08-26 11:55:09.375000'),(32,218,'2024-08-26 11:56:50.759000'),(33,221,'2024-08-26 11:56:54.812000'),(34,218,'2024-08-26 11:56:58.240000'),(35,218,'2024-08-26 12:00:36.543000'),(36,218,'2024-08-26 12:02:03.969000'),(37,217,'2024-08-26 12:02:08.013000'),(38,223,'2024-08-26 12:02:11.699000'),(39,217,'2024-08-26 12:11:48.205000'),(40,217,'2024-08-26 12:13:30.284000'),(41,220,'2024-08-26 12:13:44.280000'),(42,220,'2024-08-26 12:13:55.778000'),(43,217,'2024-08-26 12:15:02.357000'),(44,220,'2024-08-26 12:15:14.379000'),(45,220,'2024-08-26 12:27:07.562000'),(46,220,'2024-08-26 12:27:08.478000'),(47,220,'2024-08-26 12:27:09.086000'),(48,218,'2024-08-26 12:27:09.645000'),(49,217,'2024-08-26 12:27:13.804000'),(50,217,'2024-08-26 12:27:35.046000'),(51,217,'2024-08-26 12:28:42.233000'),(52,217,'2024-08-26 12:29:23.171000'),(53,220,'2024-08-26 12:29:32.905000'),(54,217,'2024-08-26 12:30:02.415000'),(55,220,'2024-08-26 12:31:15.538000'),(56,220,'2024-08-26 12:31:53.034000'),(57,220,'2024-08-26 12:32:12.668000'),(58,220,'2024-08-26 12:39:11.811000'),(59,220,'2024-08-26 12:39:29.443000'),(60,220,'2024-08-26 12:40:01.274000'),(61,220,'2024-08-26 12:47:33.536000'),(62,220,'2024-08-26 12:47:51.428000'),(63,220,'2024-08-26 12:51:32.323000'),(64,220,'2024-08-26 12:53:16.562000'),(65,227,'2024-08-26 12:53:56.706000'),(66,224,'2024-08-26 12:54:00.754000'),(67,224,'2024-08-26 12:54:03.991000'),(68,228,'2024-08-26 12:54:07.283000'),(69,224,'2024-08-26 12:54:10.196000'),(70,227,'2024-08-26 12:54:14.894000'),(71,231,'2024-08-26 13:02:37.092000'),(72,231,'2024-08-26 13:02:44.126000'),(73,232,'2024-08-26 13:02:47.371000'),(74,231,'2024-08-26 13:02:56.005000'),(75,232,'2024-08-26 13:02:59.222000'),(76,231,'2024-08-26 13:03:01.896000'),(77,231,'2024-08-26 13:03:44.210000'),(78,232,'2024-08-26 13:03:49.084000'),(79,232,'2024-08-26 13:03:52.478000'),(80,231,'2024-08-26 13:03:56.284000'),(81,232,'2024-08-26 13:03:59.392000'),(82,231,'2024-08-26 13:04:05.972000'),(83,232,'2024-08-26 13:04:09.456000'),(84,232,'2024-08-26 13:04:13.937000'),(85,231,'2024-08-26 13:04:17.412000'),(86,231,'2024-08-26 13:04:20.520000'),(87,231,'2024-08-26 13:04:25.579000'),(88,231,'2024-08-26 13:04:29.924000'),(89,231,'2024-08-26 13:04:37.527000'),(90,231,'2024-08-26 13:04:48.664000');
/*!40000 ALTER TABLE `votes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-26 14:06:07
