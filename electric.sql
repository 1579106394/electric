/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : electric

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2019-03-10 21:26:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_user` int(11) DEFAULT NULL,
  `comment_time` varchar(30) DEFAULT NULL,
  `comment_content` mediumtext,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '19', '2019-03-10 18:30:07', '测试一下反馈信息\r\n');
INSERT INTO `comment` VALUES ('2', '19', '2019-03-10 18:42:40', '啛啛喳喳');
INSERT INTO `comment` VALUES ('3', '19', '2019-03-10 18:42:45', '哈哈哈哈');
INSERT INTO `comment` VALUES ('4', '20', '2019-03-10 18:42:58', 'sdfs ');
INSERT INTO `comment` VALUES ('5', '20', '2019-03-10 18:43:00', 'gsdfhg');
INSERT INTO `comment` VALUES ('6', '20', '2019-03-10 18:43:04', 'sgerger');
INSERT INTO `comment` VALUES ('7', '20', '2019-03-10 18:43:07', 'mthmtt');
INSERT INTO `comment` VALUES ('8', '20', '2019-03-10 18:43:09', 'ytmty');
INSERT INTO `comment` VALUES ('9', '20', '2019-03-10 18:43:11', 'jyrj');
INSERT INTO `comment` VALUES ('10', '20', '2019-03-10 18:43:13', 'jnrym');
INSERT INTO `comment` VALUES ('11', '20', '2019-03-10 18:43:16', 'yukuyk');
INSERT INTO `comment` VALUES ('12', '20', '2019-03-10 18:43:22', 'rjryjy');

-- ----------------------------
-- Table structure for `meter`
-- ----------------------------
DROP TABLE IF EXISTS `meter`;
CREATE TABLE `meter` (
  `meter_id` int(11) NOT NULL AUTO_INCREMENT,
  `meter_user` int(11) DEFAULT NULL COMMENT '用户',
  `meter_start_num` double DEFAULT NULL COMMENT '本月月初电表始码',
  `meter_current_num` double DEFAULT NULL COMMENT '本月当前电表止码',
  `meter_num` double DEFAULT NULL COMMENT '本月当前用电量',
  `meter_money` double DEFAULT NULL COMMENT '本月当前电费',
  PRIMARY KEY (`meter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meter
-- ----------------------------
INSERT INTO `meter` VALUES ('1', '19', '41', '42', '1', '4');
INSERT INTO `meter` VALUES ('3', '20', '41', '42', '1', '4');
INSERT INTO `meter` VALUES ('4', '21', '1', '2', '1', '4');
INSERT INTO `meter` VALUES ('5', '22', '1', '2', '1', '4');
INSERT INTO `meter` VALUES ('6', '23', '1', '2', '1', '4');
INSERT INTO `meter` VALUES ('7', '24', '1', '2', '1', '4');
INSERT INTO `meter` VALUES ('8', '25', '1', '2', '1', '4');
INSERT INTO `meter` VALUES ('9', '26', '1', '2', '1', '4');
INSERT INTO `meter` VALUES ('10', '27', '1', '2', '1', '4');
INSERT INTO `meter` VALUES ('11', '28', '1', '2', '1', '4');
INSERT INTO `meter` VALUES ('12', '29', '1', '2', '1', '4');
INSERT INTO `meter` VALUES ('13', '30', '1', '2', '1', '4');

-- ----------------------------
-- Table structure for `money`
-- ----------------------------
DROP TABLE IF EXISTS `money`;
CREATE TABLE `money` (
  `money_id` int(11) NOT NULL AUTO_INCREMENT,
  `money_user` int(11) DEFAULT NULL,
  `money_time` varchar(30) DEFAULT NULL,
  `money_money` double DEFAULT NULL,
  PRIMARY KEY (`money_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of money
-- ----------------------------
INSERT INTO `money` VALUES ('1', '19', '2019-03', '100');
INSERT INTO `money` VALUES ('2', '19', '2019-03', '100');
INSERT INTO `money` VALUES ('3', '19', '2019-03', '200');
INSERT INTO `money` VALUES ('4', '20', '2019-03', '100');
INSERT INTO `money` VALUES ('5', '20', '2019-03', '200');
INSERT INTO `money` VALUES ('6', null, '2019-03', '10');
INSERT INTO `money` VALUES ('7', null, '2019-03', '10');
INSERT INTO `money` VALUES ('8', '19', '2019-03', '20');
INSERT INTO `money` VALUES ('9', '20', '2019-03', '23');

-- ----------------------------
-- Table structure for `price`
-- ----------------------------
DROP TABLE IF EXISTS `price`;
CREATE TABLE `price` (
  `price_id` int(11) NOT NULL AUTO_INCREMENT,
  `price_money` double DEFAULT NULL COMMENT '电价',
  `price_month` varchar(30) DEFAULT NULL COMMENT '月份',
  PRIMARY KEY (`price_id`),
  UNIQUE KEY `price_month` (`price_month`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of price
-- ----------------------------
INSERT INTO `price` VALUES ('1', '4', '2019-03');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `user_age` int(3) DEFAULT NULL,
  `user_sex` int(1) DEFAULT NULL COMMENT '1男2女',
  `user_phone` varchar(13) DEFAULT NULL,
  `user_money` double DEFAULT '0' COMMENT '电费',
  `user_flag` int(2) DEFAULT NULL COMMENT '身份，1普通用户，2管理员',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '超级管理员', '23', '1', '18296662232', '0', '2');
INSERT INTO `user` VALUES ('19', 'test1', 'test1', '测试电表2', '18', '2', '18296662234', '252', '1');
INSERT INTO `user` VALUES ('20', 'test2', 'test2', '测试2号', '18', '1', '13123123', '155', '1');
INSERT INTO `user` VALUES ('21', '1', '1', '1', '1', '1', '1', '-38', '1');
INSERT INTO `user` VALUES ('22', '2', '2', '2', '2', '1', '2', '-36', '1');
INSERT INTO `user` VALUES ('23', '3', '3', '3', '3', '1', '3', '-58', '1');
INSERT INTO `user` VALUES ('24', '4', '4', '4', '4', '1', '4', '-242', '1');
INSERT INTO `user` VALUES ('25', '5', '5', '5', '5', '1', '5', '-8', '1');
INSERT INTO `user` VALUES ('26', '6', '6', '6', '6', '1', '6', '-112', '1');
INSERT INTO `user` VALUES ('27', '7', '7', '7', '7', '1', '7', '-51', '1');
INSERT INTO `user` VALUES ('28', '8', '8', '8', '8', '1', '8', '-83', '1');
INSERT INTO `user` VALUES ('29', '9', '9', '9', '9', '1', '9', '-44', '1');
INSERT INTO `user` VALUES ('30', '0', '0', '0', '0', '1', '0', '-89', '1');

-- ----------------------------
-- Table structure for `use_log`
-- ----------------------------
DROP TABLE IF EXISTS `use_log`;
CREATE TABLE `use_log` (
  `use_id` int(11) NOT NULL AUTO_INCREMENT,
  `use_user` int(11) DEFAULT NULL,
  `use_money` double DEFAULT NULL COMMENT '电费费用',
  `use_number` double DEFAULT NULL COMMENT '用电多少度',
  `use_time` varchar(30) DEFAULT NULL COMMENT '月份',
  PRIMARY KEY (`use_id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of use_log
-- ----------------------------
INSERT INTO `use_log` VALUES ('2', '20', '20', '5', '2019-03');
INSERT INTO `use_log` VALUES ('3', '19', '12', '3', '2019-03');
INSERT INTO `use_log` VALUES ('4', '20', '12', '3', '2019-03');
INSERT INTO `use_log` VALUES ('5', '19', '12', '3', '2019-03');
INSERT INTO `use_log` VALUES ('6', '20', '12', '3', '2019-03');
INSERT INTO `use_log` VALUES ('7', '19', '12', '3', '2019-03');
INSERT INTO `use_log` VALUES ('8', '20', '12', '3', '2019-03');
INSERT INTO `use_log` VALUES ('9', '19', '12', '3', '2019-03');
INSERT INTO `use_log` VALUES ('10', '20', '12', '3', '2019-03');
INSERT INTO `use_log` VALUES ('11', '19', '12', '3', '2019-03');
INSERT INTO `use_log` VALUES ('12', '20', '12', '3', '2019-03');
INSERT INTO `use_log` VALUES ('13', '19', '12', '3', '2019-03');
INSERT INTO `use_log` VALUES ('14', '20', '12', '3', '2019-03');
INSERT INTO `use_log` VALUES ('15', '19', '12', '3', '2019-03');
INSERT INTO `use_log` VALUES ('16', '20', '12', '3', '2019-03');
INSERT INTO `use_log` VALUES ('17', '19', '12', '3', '2019-03');
INSERT INTO `use_log` VALUES ('18', '20', '12', '3', '2019-03');
INSERT INTO `use_log` VALUES ('19', '19', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('20', '20', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('21', '19', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('22', '20', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('23', '19', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('24', '20', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('25', '19', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('26', '20', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('27', '19', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('28', '20', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('29', '19', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('30', '20', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('31', '19', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('32', '20', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('33', '19', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('34', '20', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('35', '19', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('36', '20', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('37', '19', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('38', '20', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('39', '19', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('40', '20', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('41', '21', '0', '0', '2019-03');
INSERT INTO `use_log` VALUES ('42', '22', '0', '0', '2019-03');
INSERT INTO `use_log` VALUES ('43', '23', '0', '0', '2019-03');
INSERT INTO `use_log` VALUES ('44', '24', '0', '0', '2019-03');
INSERT INTO `use_log` VALUES ('45', '25', '0', '0', '2019-03');
INSERT INTO `use_log` VALUES ('46', '26', '0', '0', '2019-03');
INSERT INTO `use_log` VALUES ('47', '27', '0', '0', '2019-03');
INSERT INTO `use_log` VALUES ('48', '28', '0', '0', '2019-03');
INSERT INTO `use_log` VALUES ('49', '29', '0', '0', '2019-03');
INSERT INTO `use_log` VALUES ('50', '30', '0', '0', '2019-03');
INSERT INTO `use_log` VALUES ('51', '19', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('52', '20', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('53', '21', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('54', '22', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('55', '23', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('56', '24', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('57', '25', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('58', '26', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('59', '27', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('60', '28', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('61', '29', '4', '1', '2019-03');
INSERT INTO `use_log` VALUES ('62', '30', '4', '1', '2019-03');
