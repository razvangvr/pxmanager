/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50147
Source Host           : localhost:3306
Source Database       : expensemanager

Target Server Type    : MYSQL
Target Server Version : 50147
File Encoding         : 65001

Date: 2010-09-03 00:23:05
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `IdAccount` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key, Unique id',
  `IdUser` bigint(20) NOT NULL,
  `debit` float DEFAULT NULL,
  `credit` float DEFAULT NULL,
  PRIMARY KEY (`IdAccount`),
  KEY `IdUser` (`IdUser`),
  CONSTRAINT `IdUser` FOREIGN KEY (`IdUser`) REFERENCES `users` (`IdUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of account
-- ----------------------------

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `IdCategory` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`IdCategory`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for `expenses`
-- ----------------------------
DROP TABLE IF EXISTS `expenses`;
CREATE TABLE `expenses` (
  `IdExpense` bigint(20) NOT NULL AUTO_INCREMENT,
  `IdUser` bigint(20) NOT NULL,
  `IdAccount` bigint(20) NOT NULL,
  `IdCategory` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `description` text,
  `amount` float DEFAULT NULL,
  PRIMARY KEY (`IdExpense`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of expenses
-- ----------------------------

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `IdUser` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IdUser`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'razvan', 'admin');
INSERT INTO `users` VALUES ('2', null, null);
INSERT INTO `users` VALUES ('3', 'zzz', 'xxx');
