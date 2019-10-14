-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: travelline
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `booking_tbl`
--

DROP TABLE IF EXISTS `booking_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking_tbl` (
  `booking_id` int(11) NOT NULL,
  `date_of_journey` date NOT NULL,
  `fare` bigint(20) NOT NULL,
  `no_of_passengers` int(11) NOT NULL,
  `service_id` varchar(255) NOT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `FK4e33fqfplykkv54igfa59xkbh` (`service_id`),
  CONSTRAINT `FK4e33fqfplykkv54igfa59xkbh` FOREIGN KEY (`service_id`) REFERENCES `service_tbl` (`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_tbl`
--

LOCK TABLES `booking_tbl` WRITE;
/*!40000 ALTER TABLE `booking_tbl` DISABLE KEYS */;
REPLACE INTO `booking_tbl` VALUES (3,'2019-10-12',1200,1,'101'),(4,'2019-10-08',1200,1,'101'),(5,'2019-10-08',2400,2,'101'),(6,'2019-10-12',1200,1,'101'),(7,'2019-10-12',2800,2,'102'),(9,'2019-10-23',2800,2,'102'),(10,'2019-10-26',2800,2,'102'),(11,'2019-10-19',2400,2,'101'),(12,'2019-10-18',2400,2,'101'),(13,'2019-10-19',1200,1,'101'),(14,'2019-10-19',1200,1,'101'),(15,'2019-10-19',2400,2,'101'),(16,'2019-10-19',2400,2,'101'),(17,'2019-10-25',2400,2,'101'),(18,'2019-10-20',4800,4,'101'),(19,'2019-10-24',6000,5,'101'),(20,'2019-10-22',3600,3,'101'),(21,'2019-10-15',2400,2,'101'),(22,'2019-10-08',2400,2,'101'),(25,'2019-10-15',4200,3,'102'),(32,'2019-10-19',2400,2,'101'),(36,'2019-10-25',2400,2,'101'),(40,'2019-10-25',2400,2,'101'),(41,'2019-10-13',2400,2,'101'),(47,'2019-10-25',2000,1,'105'),(51,'2019-10-23',1200,2,'104'),(66,'2019-10-01',1200,1,'101'),(67,'2019-10-31',1200,1,'101'),(68,'2019-10-01',1200,1,'101'),(70,'2019-10-24',2800,2,'102'),(74,'2019-10-25',2000,1,'105'),(83,'2019-10-23',3600,3,'101');
/*!40000 ALTER TABLE `booking_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bus_tbl`
--

DROP TABLE IF EXISTS `bus_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bus_tbl` (
  `bus_id` int(11) NOT NULL,
  `bus_type` varchar(255) NOT NULL,
  `capacity` int(11) NOT NULL,
  `company` varchar(255) NOT NULL,
  `service_id` varchar(255) NOT NULL,
  PRIMARY KEY (`bus_id`),
  KEY `FKs72be6704jr2hhdar9i5xufqx` (`service_id`),
  CONSTRAINT `FKs72be6704jr2hhdar9i5xufqx` FOREIGN KEY (`service_id`) REFERENCES `service_tbl` (`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus_tbl`
--

LOCK TABLES `bus_tbl` WRITE;
/*!40000 ALTER TABLE `bus_tbl` DISABLE KEYS */;
REPLACE INTO `bus_tbl` VALUES (1,'AC',40,'Orange Travels','101'),(2,'NON_AC',40,'RedBus','101');
/*!40000 ALTER TABLE `bus_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city_tbl`
--

DROP TABLE IF EXISTS `city_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city_tbl` (
  `city_id` int(11) NOT NULL,
  `city_name` varchar(255) NOT NULL,
  `state_id` int(11) NOT NULL,
  PRIMARY KEY (`city_id`),
  KEY `FKn5f0wvot49x4hv8klgltumuea` (`state_id`),
  CONSTRAINT `FKn5f0wvot49x4hv8klgltumuea` FOREIGN KEY (`state_id`) REFERENCES `state_tbl` (`state_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city_tbl`
--

LOCK TABLES `city_tbl` WRITE;
/*!40000 ALTER TABLE `city_tbl` DISABLE KEYS */;
REPLACE INTO `city_tbl` VALUES (1,'hyderabad',1),(2,'lb nagar',1),(3,'Navalur',2),(4,'Chennai',2),(5,'thiruvnantpuram',3),(6,'Delhi',4),(7,'Kolkata',5);
/*!40000 ALTER TABLE `city_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback_tbl`
--

DROP TABLE IF EXISTS `feedback_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback_tbl` (
  `feedback_id` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  `booking_id` int(11) NOT NULL,
  PRIMARY KEY (`feedback_id`),
  KEY `FKtkjyrlyhn1brxopwqj740fs0j` (`booking_id`),
  CONSTRAINT `FKtkjyrlyhn1brxopwqj740fs0j` FOREIGN KEY (`booking_id`) REFERENCES `booking_tbl` (`booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback_tbl`
--

LOCK TABLES `feedback_tbl` WRITE;
/*!40000 ALTER TABLE `feedback_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
REPLACE INTO `hibernate_sequence` VALUES (87),(87),(87),(87),(87),(87),(87),(87),(87);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger_tbl`
--

DROP TABLE IF EXISTS `passenger_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passenger_tbl` (
  `passenger_id` int(11) NOT NULL,
  `passenger_name` varchar(255) NOT NULL,
  `seat_number` int(11) NOT NULL,
  `booking_id` int(11) NOT NULL,
  PRIMARY KEY (`passenger_id`),
  KEY `FKjximyfen80qvs7vlsu5pvdfej` (`booking_id`),
  CONSTRAINT `FKjximyfen80qvs7vlsu5pvdfej` FOREIGN KEY (`booking_id`) REFERENCES `booking_tbl` (`booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger_tbl`
--

LOCK TABLES `passenger_tbl` WRITE;
/*!40000 ALTER TABLE `passenger_tbl` DISABLE KEYS */;
REPLACE INTO `passenger_tbl` VALUES (1,'nikhil',1,13),(2,'varun',2,13),(23,'a',3,22),(24,'b',4,22),(26,'varun',1,25),(27,'nikhil',2,25),(28,'yaseer',3,25),(29,'a',4,25),(30,'b',5,25),(31,'c',6,25),(33,'nikhil1',5,32),(34,'nikhil2',6,32),(37,'nickel',7,36),(38,'nikhil',8,36),(42,'ante',9,41),(43,'aantee',10,41),(48,'varun',1,47),(52,'n',1,51),(53,'v',2,51),(54,'n',1,51),(55,'v',2,51),(56,'n',1,51),(57,'v',2,51),(58,'n',1,51),(59,'v',2,51),(60,'n',1,51),(61,'v',2,51),(62,'n',1,51),(63,'v',2,51),(71,'varun',7,70),(72,'nikhil',8,70),(75,'g',2,74),(82,'a',3,74),(84,'a',11,83),(85,'v',12,83),(86,'b',13,83);
/*!40000 ALTER TABLE `passenger_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_tbl`
--

DROP TABLE IF EXISTS `payment_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_tbl` (
  `payment_id` int(11) NOT NULL,
  `card_type` varchar(255) NOT NULL,
  `booking_id` int(11) NOT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `FKcoej3ul517l7w6dt9g5mek4w4` (`booking_id`),
  CONSTRAINT `FKcoej3ul517l7w6dt9g5mek4w4` FOREIGN KEY (`booking_id`) REFERENCES `booking_tbl` (`booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_tbl`
--

LOCK TABLES `payment_tbl` WRITE;
/*!40000 ALTER TABLE `payment_tbl` DISABLE KEYS */;
REPLACE INTO `payment_tbl` VALUES (35,'credit',32),(39,'credit',36),(44,'credit',41),(49,'credit',47),(73,'credit',70),(76,'credit',74),(77,'credit',74),(78,'credit',74),(79,'credit',74),(80,'credit',74),(81,'credit',74);
/*!40000 ALTER TABLE `payment_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_tbl`
--

DROP TABLE IF EXISTS `role_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_tbl` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`role_id`),
  KEY `FKreiys87dwjaeush70sh93dbd5` (`user_name`),
  CONSTRAINT `FKreiys87dwjaeush70sh93dbd5` FOREIGN KEY (`user_name`) REFERENCES `user_tbl` (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_tbl`
--

LOCK TABLES `role_tbl` WRITE;
/*!40000 ALTER TABLE `role_tbl` DISABLE KEYS */;
REPLACE INTO `role_tbl` VALUES (1,'ROLE_ADMIN','admin@admin.com'),(2,'ROLE_USER','varun@varun.com'),(8,'ROLE_ADMIN','p@p.com'),(45,'ROLE_ADMIN','yasir@yasir.com'),(46,'ROLE_ADMIN','yasir@yasir.com'),(50,'ROLE_ADMIN','nikhil@nikhil.com'),(64,'ROLE_ADMIN','md@md.com'),(65,'ROLE_USER','nikhil@nikhil.com'),(69,'ROLE_ADMIN','yasir@yasir.com');
/*!40000 ALTER TABLE `role_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route_tbl`
--

DROP TABLE IF EXISTS `route_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route_tbl` (
  `route_id` int(11) NOT NULL,
  `distance` int(11) NOT NULL,
  `fare` bigint(20) NOT NULL,
  `destination` int(11) NOT NULL,
  `source` int(11) NOT NULL,
  PRIMARY KEY (`route_id`),
  KEY `FKaot2r5sok48hq00wni5dqc8ni` (`destination`),
  KEY `FK75n1u6kbjxrtdy9si1pwymn76` (`source`),
  CONSTRAINT `FK75n1u6kbjxrtdy9si1pwymn76` FOREIGN KEY (`source`) REFERENCES `city_tbl` (`city_id`),
  CONSTRAINT `FKaot2r5sok48hq00wni5dqc8ni` FOREIGN KEY (`destination`) REFERENCES `city_tbl` (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route_tbl`
--

LOCK TABLES `route_tbl` WRITE;
/*!40000 ALTER TABLE `route_tbl` DISABLE KEYS */;
REPLACE INTO `route_tbl` VALUES (1,240,1200,1,3),(2,280,1400,4,2),(3,1900,2000,1,4),(4,500,600,2,3),(5,1000,2000,4,6),(6,900,1500,5,7),(7,400,500,4,6),(8,2000,2000,7,1);
/*!40000 ALTER TABLE `route_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_tbl`
--

DROP TABLE IF EXISTS `service_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_tbl` (
  `service_id` varchar(255) NOT NULL,
  `departure_time` varchar(255) NOT NULL,
  `journey_time` varchar(255) NOT NULL,
  `route_id` int(11) NOT NULL,
  `email_id` varchar(255) NOT NULL,
  PRIMARY KEY (`service_id`),
  UNIQUE KEY `UK_l5kphjejvv4pesap6cbdc69w6` (`route_id`),
  KEY `FK2emf8uvgjy37qfhjt69p7q1s5` (`email_id`),
  CONSTRAINT `FK2emf8uvgjy37qfhjt69p7q1s5` FOREIGN KEY (`email_id`) REFERENCES `user_tbl` (`email_id`),
  CONSTRAINT `FKaxrfc4en3dvimhxu9lq0r1s2v` FOREIGN KEY (`route_id`) REFERENCES `route_tbl` (`route_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_tbl`
--

LOCK TABLES `service_tbl` WRITE;
/*!40000 ALTER TABLE `service_tbl` DISABLE KEYS */;
REPLACE INTO `service_tbl` VALUES ('101','3','5',1,'admin@admin.com'),('102','2','1',2,'admin@admin.com'),('103','3','5',3,'admin@admin.com'),('104','5','5',4,'admin@admin.com'),('105','8','8',5,'admin@admin.com'),('106','7','8',6,'admin@admin.com'),('107','8','8',7,'admin@admin.com');
/*!40000 ALTER TABLE `service_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state_tbl`
--

DROP TABLE IF EXISTS `state_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state_tbl` (
  `state_id` int(11) NOT NULL,
  `state_name` varchar(255) NOT NULL,
  PRIMARY KEY (`state_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state_tbl`
--

LOCK TABLES `state_tbl` WRITE;
/*!40000 ALTER TABLE `state_tbl` DISABLE KEYS */;
REPLACE INTO `state_tbl` VALUES (1,'Telangana'),(2,'TamilNadu'),(3,'Kerela'),(4,'Delhi'),(5,'West bengal');
/*!40000 ALTER TABLE `state_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_tbl`
--

DROP TABLE IF EXISTS `user_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_tbl` (
  `email_id` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_tbl`
--

LOCK TABLES `user_tbl` WRITE;
/*!40000 ALTER TABLE `user_tbl` DISABLE KEYS */;
REPLACE INTO `user_tbl` VALUES ('admin@admin.com','$2a$10$2bhZcPFxyNOLj5Mm.Fn69.2478PWHUdOfY0JsET4sL7/OBwhetgFy','admin'),('md@md.com','$2a$10$B57eXeJe8ld7ftxmhVhws.MA.mCyJbbOA8AX1lcIYif0RJ6IFNJu6','md'),('nikhil@nikhil.com','$2a$10$qvoUTi5GhnTO0HH5Vk6/HuRh32WFczPIHlpAgDuvrYPui0T6IaEVO','nikhil'),('p@p.com','$2a$10$F38plI9WPDkF.8HK8UfJ0OkE247TK5/bAz7BzXi7bG0uo5Ljme7u2','pritish'),('varun@varun.com','$2a$10$1h8fauAAKUxKdQcAymgg1uu/63p9JT8ebbhU3aFVA5WE/a7Mnj0jq','varun'),('yasir@yasir.com','$2a$10$c/7Ymd5eHHnZN.Oz5Qs/lu2g72khRC6Ow2amfofvz7nVKOQaOBtTq','yasir');
/*!40000 ALTER TABLE `user_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'travelline'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-15  0:21:27
