/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2023-03-17 20:38:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `rank_pvp_system_pvp_summary`
-- ----------------------------
DROP TABLE IF EXISTS `rank_pvp_system_pvp_summary`;
CREATE TABLE `rank_pvp_system_pvp_summary` (
  `killer_id` int(10) NOT NULL,
  `pvp_exp` bigint(20) NOT NULL DEFAULT '0',
  `max_rank_id` int(10) NOT NULL DEFAULT '0',
  `total_war_kills` int(10) NOT NULL DEFAULT '0',
  `total_war_kills_legal` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`killer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rank_pvp_system_pvp_summary
-- ----------------------------
