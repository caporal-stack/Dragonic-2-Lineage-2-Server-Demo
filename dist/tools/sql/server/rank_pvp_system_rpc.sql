/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2023-03-17 20:38:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `rank_pvp_system_rpc`
-- ----------------------------
DROP TABLE IF EXISTS `rank_pvp_system_rpc`;
CREATE TABLE `rank_pvp_system_rpc` (
  `player_id` int(10) NOT NULL,
  `rpc_total` bigint(20) NOT NULL DEFAULT '0',
  `rpc_current` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rank_pvp_system_rpc
-- ----------------------------
