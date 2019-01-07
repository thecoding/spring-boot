/*
Navicat MySQL Data Transfer
Source Server         : 本地
Source Host           : localhost:3307
Source Database       : spring_root  / user: spring_user psd: spring_root
Target Server Type    : MYSQL
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `book_name` varchar(32) DEFAULT NULL COMMENT '书名',
  `book_title` varchar(32) DEFAULT NULL COMMENT '标题',
  `book_size` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;