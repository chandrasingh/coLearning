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
  `description` varchar(1000) DEFAULT NULL,
  `datecreated` timestamp NULL DEFAULT NULL,
  `datemodified` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`course_oid`),
  UNIQUE KEY `course_id_UNIQUE` (`course_oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course_details` */

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_details` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
