/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2023-03-18 02:29:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `character_variables`
-- ----------------------------
DROP TABLE IF EXISTS `character_variables`;
CREATE TABLE `character_variables` (
  `obj_id` int(11) NOT NULL DEFAULT '0',
  `type` varchar(86) NOT NULL DEFAULT '0',
  `name` varchar(86) CHARACTER SET utf8 NOT NULL DEFAULT '0',
  `value` varchar(4000) CHARACTER SET utf8 NOT NULL DEFAULT '0',
  `expire_time` bigint(20) NOT NULL DEFAULT '0',
  UNIQUE KEY `prim` (`obj_id`,`type`,`name`),
  KEY `obj_id` (`obj_id`),
  KEY `type` (`type`),
  KEY `name` (`name`),
  KEY `value` (`value`(333)),
  KEY `expire_time` (`expire_time`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of character_variables
-- ----------------------------
	