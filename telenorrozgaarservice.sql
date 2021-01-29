-- MySQL dump 10.13  Distrib 8.0.22, for Linux (x86_64)
--
-- Host: localhost    Database: telenorrozgaarservice
-- ------------------------------------------------------
-- Server version	8.0.22-0ubuntu0.20.04.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Bookmark`
--

DROP TABLE IF EXISTS `Bookmark`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Bookmark` (
  `bookmark_id` int NOT NULL AUTO_INCREMENT,
  `Cellno` varchar(20) NOT NULL,
  `BookmarkName` varchar(20) NOT NULL,
  PRIMARY KEY (`bookmark_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bookmark`
--

LOCK TABLES `Bookmark` WRITE;
/*!40000 ALTER TABLE `Bookmark` DISABLE KEYS */;
/*!40000 ALTER TABLE `Bookmark` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content`
--

DROP TABLE IF EXISTS `content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `content` (
  `ContentId` int NOT NULL AUTO_INCREMENT,
  `ContentName` varchar(20) NOT NULL,
  PRIMARY KEY (`ContentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content`
--

LOCK TABLES `content` WRITE;
/*!40000 ALTER TABLE `content` DISABLE KEYS */;
/*!40000 ALTER TABLE `content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_box`
--

DROP TABLE IF EXISTS `menu_box`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_box` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `menu_type` int DEFAULT NULL,
  `max_seg` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=251 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_box`
--

LOCK TABLES `menu_box` WRITE;
/*!40000 ALTER TABLE `menu_box` DISABLE KEYS */;
INSERT INTO `menu_box` VALUES (1,'Profession',1,8),(2,'JobExperience',2,5),(3,'Gender',3,2),(4,'Location',4,7),(5,'Age',5,5);
/*!40000 ALTER TABLE `menu_box` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_segment`
--

DROP TABLE IF EXISTS `menu_segment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_segment` (
  `id` int NOT NULL DEFAULT '0',
  `title` varchar(255) DEFAULT NULL,
  `menu_id` int DEFAULT NULL,
  `parent_id` int DEFAULT NULL,
  `parent_title` varchar(255) DEFAULT NULL,
  `seg_type` int DEFAULT NULL,
  `seg_sql` text,
  `seg_file` varchar(255) DEFAULT NULL,
  `seg_order` int DEFAULT NULL,
  `seg_file_1` varchar(255) DEFAULT NULL,
  `seg_file_2` varchar(255) DEFAULT NULL,
  `seg_file_3` varchar(255) DEFAULT NULL,
  `seg_file_4` varchar(255) DEFAULT NULL,
  `seg_file_5` varchar(255) DEFAULT NULL,
  `seg_file_6` varchar(255) DEFAULT NULL,
  `seg_file_7` varchar(255) DEFAULT NULL,
  `seg_file_8` varchar(255) DEFAULT NULL,
  `seg_file_9` varchar(255) DEFAULT NULL,
  `status` int DEFAULT '100',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_segment`
--

LOCK TABLES `menu_segment` WRITE;
/*!40000 ALTER TABLE `menu_segment` DISABLE KEYS */;
INSERT INTO `menu_segment` VALUES (0,'Profession',1,NULL,NULL,1,'SELECT \'P1\' as seg_file, \'5556110\' as val1',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(1,'Profession2',1,NULL,NULL,2,'SELECT \'P2\' as seg_file, \'5556110\' as val1',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(2,'Profession3',1,NULL,NULL,3,'SELECT \'P3\' as seg_file, \'5556110\' as val1',NULL,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(3,'Profession4',1,NULL,NULL,4,'SELECT \'P4\' as seg_file, \'5556110\' as val1',NULL,4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(4,'Profession5',1,NULL,NULL,5,'SELECT \'P5\' as seg_file, \'5556110\' as val1',NULL,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(5,'Profession6',1,NULL,NULL,6,'SELECT \'P6\' as seg_file, \'5556110\' as val1',NULL,6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(6,'Profession7',1,NULL,NULL,7,'SELECT \'P7\' as seg_file, \'5556110\' as val1',NULL,7,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(7,'Profession8',1,NULL,NULL,8,'SELECT \'P8\' as seg_file, \'5556110\' as val1',NULL,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(8,'JobExperience1',2,NULL,NULL,9,'SELECT \'J1\' as seg_file',NULL,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(9,'JobExperience2',2,NULL,NULL,10,'SELECT \'J2\' as seg_file',NULL,10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(10,'JobExperience3',2,NULL,NULL,11,'SELECT \'J3\' as seg_file',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(11,'JobExperience4',2,NULL,NULL,12,'SELECT \'J4\' as seg_file',NULL,12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(12,'JobExperience5',2,NULL,NULL,13,'SELECT \'J5\' as seg_file',NULL,13,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(13,'Gender1',3,NULL,NULL,14,'SELECT \'G1\' as seg_file',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(14,'Gender2',3,NULL,NULL,15,'SELECT \'G2\' as seg_file',NULL,15,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(15,'Location1',4,NULL,NULL,16,'SELECT \'L1\' as seg_file',NULL,16,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(16,'Location2',4,NULL,NULL,17,'SELECT \'L2\' as seg_file',NULL,17,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(17,'Location3',4,NULL,NULL,18,'SELECT \'L3\' as seg_file',NULL,18,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(18,'Location4',4,NULL,NULL,19,'SELECT \'L4\' as seg_file',NULL,19,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(19,'Location5',4,NULL,NULL,20,'SELECT \'L5\' as seg_file',NULL,20,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(20,'Location6',4,NULL,NULL,21,'SELECT \'L6\' as seg_file',NULL,21,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(21,'Location7',4,NULL,NULL,22,'SELECT \'L7\' as seg_file',NULL,22,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(22,'Age1',5,NULL,NULL,23,'SELECT \'A1\' as seg_file',NULL,23,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(23,'Age2',5,NULL,NULL,24,'SELECT \'A2\' as seg_file',NULL,24,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(24,'Age3',5,NULL,NULL,25,'SELECT \'A3\' as seg_file',NULL,25,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(25,'Age4',5,NULL,NULL,26,'SELECT \'A4\' as seg_file',NULL,26,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(26,'Age5',5,NULL,NULL,27,'SELECT \'A5\' as seg_file',NULL,27,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100);
/*!40000 ALTER TABLE `menu_segment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_segment_validity`
--

DROP TABLE IF EXISTS `menu_segment_validity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_segment_validity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `seg_id` int DEFAULT NULL,
  `validity_sql` text,
  `validity_sql_order` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_segment_validity`
--

LOCK TABLES `menu_segment_validity` WRITE;
/*!40000 ALTER TABLE `menu_segment_validity` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu_segment_validity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_details` (
  `User_id` int NOT NULL AUTO_INCREMENT,
  `Cellno` varchar(20) NOT NULL,
  `Profession` varchar(20) NOT NULL,
  `JobExperience` varchar(20) NOT NULL,
  `JobWorkplace` varchar(20) NOT NULL,
  `Age` varchar(20) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  PRIMARY KEY (`User_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_details`
--

LOCK TABLES `user_details` WRITE;
/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;
INSERT INTO `user_details` VALUES (1,'77889','SecurityGuard','NOExperience','IslamabadRawalpindi','18-25','male');
/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-29 17:36:00
