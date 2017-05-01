DROP DATABASE `2017319`;
CREATE DATABASE `2017319`;
USE `2017319`;
/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : 2017319

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-04-24 15:23:59
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for `itcast_department`
-- ----------------------------
DROP TABLE IF EXISTS `itcast_department`;
CREATE TABLE `itcast_department` (
  `id`          BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(255)        DEFAULT NULL,
  `description` VARCHAR(255)        DEFAULT NULL,
  `parentId`    BIGINT(20)          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB56F87C7729C9286` (`parentId`),
  CONSTRAINT `FKB56F87C7729C9286` FOREIGN KEY (`parentId`) REFERENCES `itcast_department` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of itcast_department
-- ----------------------------
INSERT INTO `itcast_department` VALUES ('1', '111', '11', NULL);
INSERT INTO `itcast_department` VALUES ('2', '项目部', '111', '1');
INSERT INTO `itcast_department` VALUES ('3', '财务部', '111', NULL);

-- ----------------------------
-- Table structure for `itcast_mianfei`
-- ----------------------------
DROP TABLE IF EXISTS `itcast_mianfei`;
CREATE TABLE `itcast_mianfei` (
  `id`      BIGINT(20) NOT NULL AUTO_INCREMENT,
  `title`   VARCHAR(255)        DEFAULT NULL,
  `addtime` VARCHAR(255)        DEFAULT NULL,
  `userid`  VARCHAR(255)        DEFAULT NULL,
  `tel`     VARCHAR(255)        DEFAULT NULL,
  `state`   VARCHAR(255)        DEFAULT NULL,
  `text`    VARCHAR(255)        DEFAULT NULL,
  `cid`     BIGINT(20)          DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of itcast_mianfei
-- ----------------------------
INSERT INTO `itcast_mianfei` VALUES ('1', '免费测试', '2017-04-08', '3', '188', '确认', '188', '1');
INSERT INTO `itcast_mianfei` VALUES ('2', '免费测试01', '2017-04-09', NULL, '189189', '确认', '25655', '2');
INSERT INTO `itcast_mianfei` VALUES ('3', '免费测试01', '2017-04-09', NULL, '134', '确认', '1341234', '2');
INSERT INTO `itcast_mianfei` VALUES ('5', '哈哈', '2017-04-13', NULL, '111', '确认', '111', '3');
INSERT INTO `itcast_mianfei` VALUES ('6', '1111111', '2017-04-14', NULL, '11111111', '确认', '111111', '1');
INSERT INTO `itcast_mianfei` VALUES ('7', '233', '2017-04-23', NULL, '123', '确认', '123', '3');
INSERT INTO `itcast_mianfei` VALUES ('8', '12345', '2017-04-23', NULL, '1234', '确认', '1234', '4');
INSERT INTO `itcast_mianfei` VALUES ('9', '112344', '2017-04-24', '3', '1234', '申请中', '1234', '4');

-- ----------------------------
-- Table structure for `itcast_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `itcast_privilege`;
CREATE TABLE `itcast_privilege` (
  `id`       BIGINT(20) NOT NULL AUTO_INCREMENT,
  `url`      VARCHAR(255)        DEFAULT NULL,
  `name`     VARCHAR(255)        DEFAULT NULL,
  `parentId` BIGINT(20)          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2A54CF9CE7D51427` (`parentId`),
  CONSTRAINT `FK2A54CF9CE7D51427` FOREIGN KEY (`parentId`) REFERENCES `itcast_privilege` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 38
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of itcast_privilege
-- ----------------------------
INSERT INTO `itcast_privilege` VALUES ('1', NULL, '系统管理', NULL);
INSERT INTO `itcast_privilege` VALUES ('2', '/role_list', '岗位管理', '1');
INSERT INTO `itcast_privilege` VALUES ('3', '/department_list', '部门管理', '1');
INSERT INTO `itcast_privilege` VALUES ('4', '/user_list', '用户管理', '1');
INSERT INTO `itcast_privilege` VALUES ('5', '/role_list', '岗位列表', '2');
INSERT INTO `itcast_privilege` VALUES ('6', '/role_delete', '岗位删除', '2');
INSERT INTO `itcast_privilege` VALUES ('7', '/role_add', '岗位添加', '2');
INSERT INTO `itcast_privilege` VALUES ('8', '/role_edit', '岗位修改', '2');
INSERT INTO `itcast_privilege` VALUES ('9', '/department_list', '部门列表', '3');
INSERT INTO `itcast_privilege` VALUES ('10', '/department_delete', '部门删除', '3');
INSERT INTO `itcast_privilege` VALUES ('11', '/department_add', '部门添加', '3');
INSERT INTO `itcast_privilege` VALUES ('12', '/department_edit', '部门修改', '3');
INSERT INTO `itcast_privilege` VALUES ('13', '/user_list', '用户列表', '4');
INSERT INTO `itcast_privilege` VALUES ('14', '/user_delete', '用户删除', '4');
INSERT INTO `itcast_privilege` VALUES ('15', '/user_add', '用户添加', '4');
INSERT INTO `itcast_privilege` VALUES ('16', '/user_edit', '用户修改', '4');
INSERT INTO `itcast_privilege` VALUES ('17', '/user_initPassword', '初始化密码', '4');
INSERT INTO `itcast_privilege` VALUES ('18', '', '信息管理', NULL);
INSERT INTO `itcast_privilege` VALUES ('19', '/sf_add', '信息增加', '22');
INSERT INTO `itcast_privilege` VALUES ('20', '/sf_edit', '信息更新', '22');
INSERT INTO `itcast_privilege` VALUES ('21', '/sf_delete', '信息删除', '22');
INSERT INTO `itcast_privilege` VALUES ('22', '/sf_list', '收费信息列表', '18');
INSERT INTO `itcast_privilege` VALUES ('23', '/mf_list', '免费信息列表', '18');
INSERT INTO `itcast_privilege` VALUES ('24', '/mf_add', '信息增加', '23');
INSERT INTO `itcast_privilege` VALUES ('25', '/mf_edit', '信息更新', '23');
INSERT INTO `itcast_privilege` VALUES ('26', '/mf_delete', '信息删除', '23');
INSERT INTO `itcast_privilege` VALUES ('27', NULL, '个人页面', NULL);
INSERT INTO `itcast_privilege` VALUES ('28', '/user_one', '个人信息', '27');
INSERT INTO `itcast_privilege` VALUES ('29', '/user_sf', '个人收费信息', '27');
INSERT INTO `itcast_privilege` VALUES ('30', '/user_mf', '个人免费信息', '27');
INSERT INTO `itcast_privilege` VALUES ('31', '/user_edit', '更新个人信息', '28');
INSERT INTO `itcast_privilege` VALUES ('32', '/sf_add', '添加免费信息', '30');
INSERT INTO `itcast_privilege` VALUES ('33', '/mf_add', '添加收费信息', '29');
INSERT INTO `itcast_privilege` VALUES ('34', '/ct_list', '信息分类', '18');
INSERT INTO `itcast_privilege` VALUES ('35', '/ct_add', '信息增加', '34');
INSERT INTO `itcast_privilege` VALUES ('36', '/ct_edit', '信息更新', '34');
INSERT INTO `itcast_privilege` VALUES ('37', '/ct_delete', '信息删除', '34');

-- ----------------------------
-- Table structure for `itcast_role`
-- ----------------------------
DROP TABLE IF EXISTS `itcast_role`;
CREATE TABLE `itcast_role` (
  `id`          BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(255)        DEFAULT NULL,
  `description` VARCHAR(255)        DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of itcast_role
-- ----------------------------
INSERT INTO `itcast_role` VALUES ('5', '超级管理员', '');

-- ----------------------------
-- Table structure for `itcast_role_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `itcast_role_privilege`;
CREATE TABLE `itcast_role_privilege` (
  `roleId`      BIGINT(20) NOT NULL,
  `privilegeId` BIGINT(20) NOT NULL,
  PRIMARY KEY (`privilegeId`, `roleId`),
  KEY `FK350BD81DB0E19C6E` (`privilegeId`),
  KEY `FK350BD81DBB0AE3B6` (`roleId`),
  CONSTRAINT `FK350BD81DB0E19C6E` FOREIGN KEY (`privilegeId`) REFERENCES `itcast_privilege` (`id`),
  CONSTRAINT `FK350BD81DBB0AE3B6` FOREIGN KEY (`roleId`) REFERENCES `itcast_role` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of itcast_role_privilege
-- ----------------------------

-- ----------------------------
-- Table structure for `itcast_shoufei`
-- ----------------------------
DROP TABLE IF EXISTS `itcast_shoufei`;
CREATE TABLE `itcast_shoufei` (
  `id`      BIGINT(20) NOT NULL AUTO_INCREMENT,
  `title`   VARCHAR(255)        DEFAULT NULL,
  `addtime` VARCHAR(255)        DEFAULT NULL,
  `userid`  VARCHAR(255)        DEFAULT NULL,
  `tel`     VARCHAR(255)        DEFAULT NULL,
  `price`   VARCHAR(10)         DEFAULT NULL,
  `state`   VARCHAR(255)        DEFAULT NULL,
  `text`    TEXT,
  `cid`     BIGINT(20)          DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of itcast_shoufei
-- ----------------------------
INSERT INTO `itcast_shoufei` VALUES ('1', '人才网', '2017-04-08', '3', '188', '100', '驳回', NULL, '1');
INSERT INTO `itcast_shoufei` VALUES ('2', 'test1', '2017-04-08', '4', '100', '200', '确认', NULL, '1');
INSERT INTO `itcast_shoufei` VALUES ('3', 'test02', '2017-04-08', '3', '1888', '100', '申请中', 'tttt', '1');

-- ----------------------------
-- Table structure for `itcast_user`
-- ----------------------------
DROP TABLE IF EXISTS `itcast_user`;
CREATE TABLE `itcast_user` (
  `id`           BIGINT(20) NOT NULL AUTO_INCREMENT,
  `loginName`    VARCHAR(255)        DEFAULT NULL,
  `password`     VARCHAR(255)        DEFAULT NULL,
  `name`         VARCHAR(255)        DEFAULT NULL,
  `gender`       VARCHAR(255)        DEFAULT NULL,
  `phoneNumber`  VARCHAR(255)        DEFAULT NULL,
  `email`        VARCHAR(255)        DEFAULT NULL,
  `description`  VARCHAR(255)        DEFAULT NULL,
  `departmentId` BIGINT(20)          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4ADEC00F49BC32E` (`departmentId`),
  CONSTRAINT `FK4ADEC00F49BC32E` FOREIGN KEY (`departmentId`) REFERENCES `itcast_department` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of itcast_user
-- ----------------------------
INSERT INTO `itcast_user` VALUES ('3', 'admin', '21232f297a57a5a743894a0e4a801fc3', '超级管理员', NULL, '', '', '', NULL);
INSERT INTO `itcast_user` VALUES ('4', 'user01', '81dc9bdb52d04dc20036dbd8313ed055', '李华', '男', '21', '21', '32', NULL);
INSERT INTO `itcast_user`
VALUES ('5', '001', '81dc9bdb52d04dc20036dbd8313ed055', '333', '男', '13304029458', '3929929@qq.com', '', '2');
INSERT INTO `itcast_user`
VALUES ('6', '002', '81dc9bdb52d04dc20036dbd8313ed055', '321', '男', '13304029458', '2321321', '32121', '3');
INSERT INTO `itcast_user` VALUES ('7', '003', '81dc9bdb52d04dc20036dbd8313ed055', '003', '男', '003', '003', '', NULL);
INSERT INTO `itcast_user`
VALUES ('9', '23333', '81dc9bdb52d04dc20036dbd8313ed055', '张三', '男', '12123', '1231@123.com', '11', '2');

-- ----------------------------
-- Table structure for `itcast_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `itcast_user_role`;
CREATE TABLE `itcast_user_role` (
  `userId` BIGINT(20) NOT NULL,
  `roleId` BIGINT(20) NOT NULL,
  PRIMARY KEY (`roleId`, `userId`),
  KEY `FK9C95CD55BB0AE3B6` (`roleId`),
  KEY `FK9C95CD55C0603920` (`userId`),
  CONSTRAINT `FK9C95CD55BB0AE3B6` FOREIGN KEY (`roleId`) REFERENCES `itcast_role` (`id`),
  CONSTRAINT `FK9C95CD55C0603920` FOREIGN KEY (`userId`) REFERENCES `itcast_user` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of itcast_user_role
-- ----------------------------
INSERT INTO `itcast_user_role` VALUES ('4', '5');

-- ----------------------------
-- Table structure for `t_category`
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id`   BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255)        DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('1', '物品求购');
INSERT INTO `t_category` VALUES ('2', '物品出售');
INSERT INTO `t_category` VALUES ('3', '招聘信息');
INSERT INTO `t_category` VALUES ('4', '求职信息');
INSERT INTO `t_category` VALUES ('6', '房屋出租');
INSERT INTO `t_category` VALUES ('7', '婚姻介绍');

-- ----------------------------
-- Table structure for `t_infos`
-- ----------------------------
DROP TABLE IF EXISTS `t_infos`;
CREATE TABLE `t_infos` (
  `id`       BIGINT(20) NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(255)        DEFAULT NULL,
  `cid`      BIGINT(20)          DEFAULT NULL,
  `title`    VARCHAR(255)        DEFAULT NULL,
  `addtime`  VARCHAR(255)        DEFAULT NULL,
  `user`     VARCHAR(255)        DEFAULT NULL,
  `tel`      VARCHAR(255)        DEFAULT NULL,
  `state`    VARCHAR(255)        DEFAULT NULL,
  `infos`    VARCHAR(255)        DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of t_infos
-- ----------------------------
