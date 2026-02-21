/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2023-03-17 20:38:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `rank_pvp_system_pvp`
-- ----------------------------
DROP TABLE IF EXISTS `rank_pvp_system_pvp`;
CREATE TABLE `rank_pvp_system_pvp` (
  `killer_id` int(10) NOT NULL,
  `victim_id` int(10) NOT NULL,
  `kills` int(10) NOT NULL DEFAULT '0',
  `kills_today` int(10) NOT NULL DEFAULT '0',
  `kills_legal` int(10) NOT NULL DEFAULT '0',
  `kills_today_legal` int(10) NOT NULL DEFAULT '0',
  `rank_points` bigint(18) NOT NULL DEFAULT '0',
  `rank_points_today` bigint(18) NOT NULL DEFAULT '0',
  `kill_time` bigint(18) NOT NULL DEFAULT '0',
  `kill_day` bigint(18) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rank_pvp_system_pvp
-- ----------------------------
