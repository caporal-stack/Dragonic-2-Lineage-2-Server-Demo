/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2023-03-17 20:38:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `rank_pvp_system_options`
-- ----------------------------
DROP TABLE IF EXISTS `rank_pvp_system_options`;
CREATE TABLE `rank_pvp_system_options` (
  `option_id` int(11) NOT NULL AUTO_INCREMENT,
  `option_name` varchar(30) DEFAULT NULL,
  `option_value_long` bigint(20) DEFAULT NULL,
  `option_value_string` varchar(100) DEFAULT NULL,
  `option_description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`option_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rank_pvp_system_options
-- ----------------------------
INSERT INTO `rank_pvp_system_options` VALUES ('1', 'top_update_time', '1679002898234', null, 'If option_value_long = 0 then on server start top list will be updated.');
