/*
SQLyog Community Edition- MySQL GUI v7.02 
MySQL - 5.5.27 : Database - co_learning
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`co_learning` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `co_learning`;

/*Table structure for table `course_details` */

DROP TABLE IF EXISTS `course_details`;

CREATE TABLE `course_details` (
  `course_oid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `data` text,
  `title` varchar(50) NOT NULL,
  `live` bit(1) DEFAULT b'0',
  `description` varchar(1000) DEFAULT NULL,
  `datecreated` timestamp NULL DEFAULT NULL,
  `datemodified` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`course_oid`),
  UNIQUE KEY `course_id_UNIQUE` (`course_oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course_details` */

<<<<<<< Updated upstream
=======
insert  into `course_details`(`course_oid`,`data`,`title`,`description`,`create_ts`,`modify_ts`) values (3,'Course Data REcent Changes to DB','Course Titile first Course','Course Descrip fo First Course','2013-08-21 18:13:21','2013-08-21 18:13:21'),(10,'sadfsdfasdfsafdas','asdfsafsafasfdasfas','sadfsafsadfsadfsdafsdafsad','2013-08-21 19:15:33','2013-08-21 19:15:33'),(19,'Course Upload Data','Course Upload Data','Course Upload Data','2013-08-22 14:41:17','2013-08-22 14:41:17'),(21,'Test With Course Few','Test With Course Few','Test With Course Few','2013-08-22 17:56:47','2013-08-22 17:56:47'),(23,'Secound UPload Course','Secound UPload Course','Secound UPload Course','2013-08-22 18:13:17','2013-08-22 18:13:17'),(27,'Upload course test 23 08','Upload course test 23 08','Upload course test 23 08','2013-08-23 10:40:03','2013-08-23 10:40:03'),(28,'Upload course test 23 08','Upload course test 23 08','Upload course test 23 08','2013-08-23 10:40:27','2013-08-23 10:40:27'),(29,'Upload course test 23 08','Upload course test 23 08','Upload course test 23 08','2013-08-23 10:46:15','2013-08-23 10:46:15'),(30,'Upload course test 23 08','Upload course test 23 08','Upload course test 23 08','2013-08-23 10:47:13','2013-08-23 10:47:13'),(31,'Upload course test 23 08','Upload course test 23 08','Upload course test 23 08','2013-08-23 10:48:22','2013-08-23 10:48:22'),(32,'Upload course test 23 08','Upload course test 23 08','Upload course test 23 08','2013-08-23 10:48:57','2013-08-23 10:48:57'),(34,'Upload course test 12 28','Upload course test 12 28','Upload course test 12 28','2013-08-23 12:28:53','2013-08-23 12:28:53'),(35,'Upload course test 12 32','Upload course test 12 32','Upload course test 12 32','2013-08-23 12:32:10','2013-08-23 12:32:10'),(36,'Adding course 3 rd','Adding course 3 rd','Adding course 3 rd','2013-08-23 14:49:07','2013-08-23 14:49:07'),(38,'bjhkjkhk','bjhkjkhk','bjhkjkhk','2013-08-23 15:22:49','2013-08-23 15:22:49'),(39,'bjhkjkhk','bjhkjkhk','bjhkjkhk','2013-08-23 15:24:00','2013-08-23 15:24:00'),(41,'bjhkjkhk','bjhkjkhk','bjhkjkhk','2013-08-23 15:26:18','2013-08-23 15:26:18'),(42,'sdfdsafds','asdfsdaf','asdfsaf','2013-08-23 17:42:41','2013-08-23 17:42:41'),(43,'asdf','asdfsdaf','sdf','2013-08-26 11:57:43','2013-08-26 11:57:43');

>>>>>>> Stashed changes
/*Table structure for table `user_details` */

DROP TABLE IF EXISTS `user_details`;

CREATE TABLE `user_details` (
  `user_oid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `email_id` varchar(50) NOT NULL,
  `screen_name` varchar(45) DEFAULT NULL,
  `session_name` varchar(100) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_oid`),
  UNIQUE KEY `user_id_UNIQUE` (`user_oid`),
  UNIQUE KEY `email_id_UNIQUE` (`email_id`)
<<<<<<< Updated upstream
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
=======
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `user_course_details` */

DROP TABLE IF EXISTS `user_course_details`;

CREATE TABLE `user_course_details` (
  `course_oid` bigint(20) unsigned NOT NULL,
  `user_oid` bigint(20) unsigned NOT NULL,
  `data` text,
  `bookmark` tinytext,
  `user_course_mapcol` varchar(45) DEFAULT NULL,
  `restriction_id` int(10) unsigned NOT NULL DEFAULT '10',
  `user_course_details_oid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`user_course_details_oid`),
  KEY `FK_user_course_details` (`course_oid`),
  KEY `FK_user_course_dtls_user_oid_user_dtls` (`user_oid`),
  CONSTRAINT `FK_user_course_details` FOREIGN KEY (`course_oid`) REFERENCES `course_details` (`course_oid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user_course_dtls_user_oid_user_dtls` FOREIGN KEY (`user_oid`) REFERENCES `user_details` (`user_oid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_course_details` */

insert  into `user_course_details`(`course_oid`,`user_oid`,`data`,`bookmark`,`user_course_mapcol`,`restriction_id`,`user_course_details_oid`) values (10,2,NULL,NULL,NULL,10,1);
>>>>>>> Stashed changes

/*Data for the table `user_details` */

/*Table structure for table `user_course_details` */

DROP TABLE IF EXISTS `user_course_details`;

CREATE TABLE `user_course_details` (
  `course_oid` bigint(20) unsigned NOT NULL,
  `user_oid` bigint(20) unsigned NOT NULL,
  `data` text,
  `bookmark` int(11) DEFAULT NULL,
  `user_course_mapcol` varchar(45) DEFAULT NULL,
  `restriction_id` int(10) unsigned NOT NULL,
  `course_user_details_oid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`course_user_details_oid`),
  KEY `FK_user_course_details` (`course_oid`),
  KEY `FK_user_course_dtls_user_oid_user_dtls` (`user_oid`),
  CONSTRAINT `FK_user_course_details` FOREIGN KEY (`course_oid`) REFERENCES `course_details` (`course_oid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user_course_dtls_user_oid_user_dtls` FOREIGN KEY (`user_oid`) REFERENCES `user_details` (`user_oid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_course_details` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
