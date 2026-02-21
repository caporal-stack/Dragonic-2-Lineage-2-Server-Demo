/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2023-03-17 20:39:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `rank_pvp_system_top_table`
-- ----------------------------
DROP TABLE IF EXISTS `rank_pvp_system_top_table`;
CREATE TABLE `rank_pvp_system_top_table` (
  `table_id` int(2) NOT NULL DEFAULT '0',
  `position` int(6) NOT NULL,
  `player_id` int(10) NOT NULL,
  `value` bigint(20) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rank_pvp_system_top_table
-- ----------------------------
