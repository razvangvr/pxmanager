# MySQL-Front 4.2  (Build 1.25)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: dirigentie
# ------------------------------------------------------
# Server version 5.0.51b-community-nt

#
# Table structure for table absente
#

DROP TABLE IF EXISTS `absente`;
CREATE TABLE `absente` (
  `id` bigint(20) unsigned NOT NULL auto_increment,
  `id_elev` bigint(20) NOT NULL default '0',
  `id_an` bigint(20) unsigned NOT NULL default '0',
  `motivat` int(10) default NULL,
  `nemotivat` int(1) default NULL,
  `semestru` enum('s1','s2') default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Dumping data for table absente
#
LOCK TABLES `absente` WRITE;
/*!40000 ALTER TABLE `absente` DISABLE KEYS */;

/*!40000 ALTER TABLE `absente` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table anscolar
#

DROP TABLE IF EXISTS `anscolar`;
CREATE TABLE `anscolar` (
  `Id` int(11) NOT NULL auto_increment,
  `den` varchar(10) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

#
# Dumping data for table anscolar
#
LOCK TABLES `anscolar` WRITE;
/*!40000 ALTER TABLE `anscolar` DISABLE KEYS */;

INSERT INTO `anscolar` VALUES (1,'2007/2008');
INSERT INTO `anscolar` VALUES (2,'2006/2007');
/*!40000 ALTER TABLE `anscolar` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table clasa
#

DROP TABLE IF EXISTS `clasa`;
CREATE TABLE `clasa` (
  `id` bigint(20) unsigned NOT NULL auto_increment,
  `id_an` bigint(20) default NULL,
  `id_profil` bigint(20) default NULL,
  `id_specializare` bigint(20) default NULL,
  `den` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Dumping data for table clasa
#
LOCK TABLES `clasa` WRITE;
/*!40000 ALTER TABLE `clasa` DISABLE KEYS */;

/*!40000 ALTER TABLE `clasa` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table disciplina
#

DROP TABLE IF EXISTS `disciplina`;
CREATE TABLE `disciplina` (
  `id` bigint(20) unsigned NOT NULL auto_increment,
  `id_an` bigint(20) unsigned NOT NULL default '0',
  `den` varchar(50) NOT NULL default '',
  `profesor` varchar(50) default '',
  `ore` bigint(3) unsigned default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Dumping data for table disciplina
#
LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;

/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table elev
#

DROP TABLE IF EXISTS `elev`;
CREATE TABLE `elev` (
  `id` bigint(20) unsigned NOT NULL auto_increment,
  `matr` bigint(10) unsigned NOT NULL default '0',
  `nume` varchar(50) NOT NULL default '',
  `datan` date default '0000-00-00',
  `sex` enum('M','F') default NULL,
  `adr` varchar(60) default '',
  `loc` varchar(30) default '',
  `jud` varchar(30) default '',
  `codp` int(6) default NULL,
  `tel` varchar(16) default '',
  `email` varchar(100) default NULL,
  `statut` enum('Casatorit','Necasatorit','Divortat','Tutore') default 'Casatorit',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Dumping data for table elev
#
LOCK TABLES `elev` WRITE;
/*!40000 ALTER TABLE `elev` DISABLE KEYS */;

INSERT INTO `elev` VALUES (1,11,'gheorghe mihai','0000-00-00',NULL,'','','',NULL,'',NULL,'Casatorit');
/*!40000 ALTER TABLE `elev` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table media
#

DROP TABLE IF EXISTS `media`;
CREATE TABLE `media` (
  `id` bigint(20) unsigned NOT NULL auto_increment,
  `id_elev` bigint(20) unsigned NOT NULL default '0',
  `id_disc` bigint(20) unsigned NOT NULL default '0',
  `id_an` bigint(20) unsigned NOT NULL default '0',
  `media` decimal(10,2) default NULL,
  `semestru` enum('s1','s2') default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Dumping data for table media
#
LOCK TABLES `media` WRITE;
/*!40000 ALTER TABLE `media` DISABLE KEYS */;

/*!40000 ALTER TABLE `media` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table parinte
#

DROP TABLE IF EXISTS `parinte`;
CREATE TABLE `parinte` (
  `id` bigint(20) unsigned NOT NULL auto_increment,
  `id_elev` bigint(20) default NULL,
  `nume` varchar(50) default '',
  `profesie` varchar(50) default '',
  `loc_munca` varchar(50) default '',
  `statut` enum('Casatorit','Necasatorit','Divortat','Tutore') NOT NULL default 'Casatorit',
  `localitate` varchar(50) default '',
  `adr` varchar(60) default '',
  `tel` varchar(16) default '',
  `obs` varchar(255) default '',
  `email` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Dumping data for table parinte
#
LOCK TABLES `parinte` WRITE;
/*!40000 ALTER TABLE `parinte` DISABLE KEYS */;

/*!40000 ALTER TABLE `parinte` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table profil
#

DROP TABLE IF EXISTS `profil`;
CREATE TABLE `profil` (
  `Id` int(11) NOT NULL auto_increment,
  `den` varchar(55) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

#
# Dumping data for table profil
#
LOCK TABLES `profil` WRITE;
/*!40000 ALTER TABLE `profil` DISABLE KEYS */;

INSERT INTO `profil` VALUES (2,'Constructii de Masini');
INSERT INTO `profil` VALUES (4,'Agricol si Agromontan');
/*!40000 ALTER TABLE `profil` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table specializare
#

DROP TABLE IF EXISTS `specializare`;
CREATE TABLE `specializare` (
  `Id` int(11) NOT NULL auto_increment,
  `den` varchar(55) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

#
# Dumping data for table specializare
#
LOCK TABLES `specializare` WRITE;
/*!40000 ALTER TABLE `specializare` DISABLE KEYS */;

INSERT INTO `specializare` VALUES (2,'Tractoare si Combine');
/*!40000 ALTER TABLE `specializare` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table users
#

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(16) NOT NULL default '',
  `userpassword` varchar(16) NOT NULL default '',
  `usertype` enum('ADMIN','UTILIZATOR') default NULL,
  `name` varchar(50) default NULL,
  `address1` varchar(250) default NULL,
  `address2` varchar(250) default NULL,
  `city` varchar(30) default NULL,
  `country` varchar(50) default NULL,
  `phone` varchar(20) default NULL,
  `email` varchar(120) default NULL,
  `lastLogin` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `chatuserid` int(10) unsigned default NULL,
  PRIMARY KEY  (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Dumping data for table users
#
LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` VALUES ('a','a','ADMIN','goge','q','','','','234432','','2008-07-19 12:04:45',0);
INSERT INTO `users` VALUES ('admin','admin','ADMIN','didi','','','sb','ro','111','','2007-05-07 16:18:00',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
