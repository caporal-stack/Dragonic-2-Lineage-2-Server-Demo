/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2023-03-17 20:39:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `rank_pvp_system_rpc_reward`
-- ----------------------------
DROP TABLE IF EXISTS `rank_pvp_system_rpc_reward`;
CREATE TABLE `rank_pvp_system_rpc_reward` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `item_id` int(10) NOT NULL,
  `item_amount` int(10) NOT NULL,
  `rpc` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rank_pvp_system_rpc_reward
-- ----------------------------
INSERT INTO `rank_pvp_system_rpc_reward` VALUES ('1', '57', '1000000', '10');
INSERT INTO `rank_pvp_system_rpc_reward` VALUES ('2', '57', '10000000', '100');
INSERT INTO `rank_pvp_system_rpc_reward` VALUES ('3', '57', '100000000', '1000');
INSERT INTO `rank_pvp_system_rpc_reward` VALUES ('4', '6622', '1', '10');
INSERT INTO `rank_pvp_system_rpc_reward` VALUES ('5', '5592', '100', '10');
INSERT INTO `rank_pvp_system_rpc_reward` VALUES ('6', '1538', '100', '10');
INSERT INTO `rank_pvp_system_rpc_reward` VALUES ('7', '6577', '1', '50');
INSERT INTO `rank_pvp_system_rpc_reward` VALUES ('8', '6578', '1', '25');
INSERT INTO `rank_pvp_system_rpc_reward` VALUES ('9', '6569', '1', '30');
INSERT INTO `rank_pvp_system_rpc_reward` VALUES ('10', '6570', '1', '15');
