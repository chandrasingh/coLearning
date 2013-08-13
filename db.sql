delimiter $$
delimiter $$

CREATE DATABASE `co_learning` /*!40100 DEFAULT CHARACTER SET latin1 */$$


CREATE TABLE `user_course_map` (
  `course_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `data` text,
  `bookmark` int(11) DEFAULT NULL,
  `user_course_mapcol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`course_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$

delimiter $$

CREATE TABLE `user_details` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `email_id` varchar(45) NOT NULL,
  `screen_name` varchar(45) DEFAULT NULL,
  `session_name` varchar(100) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `email_id_UNIQUE` (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$

delimiter $$

CREATE TABLE `course_details` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `data` text,
  `title` varchar(500) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  UNIQUE KEY `course_id_UNIQUE` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$

