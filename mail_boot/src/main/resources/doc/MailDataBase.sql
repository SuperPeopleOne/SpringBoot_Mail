CREATE DATABASE mail_boot;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` VARCHAR(255) DEFAULT NULL COMMENT '书名',
  `author` VARCHAR(255) DEFAULT NULL COMMENT '作者',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '深入理解Java虚拟机(第2版)', '周志明');
INSERT INTO `book` VALUES ('2', '深入分析JavaWeb技术内幕(修订版)', '许令波');


CREATE DATABASE mail_boot_data;


-- ----------------------------
-- Table structure for demo
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(255) DEFAULT NULL,
  `pwd` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo
-- ----------------------------
INSERT INTO `demo` VALUES ('1', '测试user', '测试pwd');
