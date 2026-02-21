/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2023-03-17 20:38:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `rank_pvp_system_rank_reward`
-- ----------------------------
DROP TABLE IF EXISTS `rank_pvp_system_rank_reward`;
CREATE TABLE `rank_pvp_system_rank_reward` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `item_id` int(10) NOT NULL,
  `item_amount` int(10) NOT NULL,
  `rank_id` int(4) NOT NULL,
  `is_pvp` varchar(5) NOT NULL DEFAULT 'false' COMMENT 'true or false',
  `is_level` varchar(5) NOT NULL DEFAULT 'true' COMMENT 'true or false',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rank_pvp_system_rank_reward
-- ----------------------------
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('1', '57', '1000', '1', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('2', '57', '2000', '2', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('3', '57', '3000', '3', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('4', '57', '4000', '4', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('5', '57', '5000', '5', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('6', '57', '6000', '6', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('7', '57', '7000', '7', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('8', '57', '8000', '8', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('9', '57', '9000', '9', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('10', '57', '10000', '10', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('11', '57', '11000', '11', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('12', '57', '12000', '12', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('13', '57', '13000', '13', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('14', '57', '14000', '14', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('15', '57', '15000', '15', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('16', '57', '16000', '16', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('17', '57', '17000', '17', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('18', '57', '18000', '18', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('19', '57', '19000', '19', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('20', '57', '20000', '20', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('21', '57', '21000', '21', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('22', '57', '22000', '22', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('23', '57', '23000', '23', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('24', '57', '24000', '24', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('25', '57', '25000', '25', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('26', '57', '26000', '26', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('27', '57', '27000', '27', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('28', '57', '28000', '28', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('29', '57', '29000', '29', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('30', '57', '30000', '30', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('31', '57', '31000', '31', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('32', '57', '32000', '32', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('33', '57', '33000', '33', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('34', '57', '34000', '34', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('35', '57', '35000', '35', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('36', '57', '36000', '36', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('37', '57', '37000', '37', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('38', '57', '38000', '38', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('39', '57', '39000', '39', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('40', '57', '40000', '40', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('41', '57', '41000', '41', 'true', 'true');
INSERT INTO `rank_pvp_system_rank_reward` VALUES ('42', '57', '42000', '42', 'true', 'true');
