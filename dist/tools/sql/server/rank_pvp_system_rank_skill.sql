/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2023-03-17 20:38:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `rank_pvp_system_rank_skill`
-- ----------------------------
DROP TABLE IF EXISTS `rank_pvp_system_rank_skill`;
CREATE TABLE `rank_pvp_system_rank_skill` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `skill_id` int(10) NOT NULL,
  `skill_level` int(10) NOT NULL,
  `rank_id` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rank_pvp_system_rank_skill
-- ----------------------------
INSERT INTO `rank_pvp_system_rank_skill` VALUES ('1', '1323', '1', '2');
