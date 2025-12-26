/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2023-03-17 20:08:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `last_vote_kara`
-- ----------------------------
DROP TABLE IF EXISTS `last_vote_kara`;
CREATE TABLE `last_vote_kara` (
  `hwid` varchar(255) NOT NULL,
  `site` varchar(30) DEFAULT NULL,
  `lastReward` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`hwid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of last_vote_kara
-- ----------------------------
