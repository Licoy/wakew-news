/*
Navicat MySQL Data Transfer

Source Server         : localhost-mysql
Source Server Version : 50557
Source Host           : localhost:3306
Source Database       : news

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2017-08-11 10:14:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '名称',
  `alias` varchar(50) DEFAULT NULL COMMENT '别名',
  `describe` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '默认分类', 'default', '默认分类');

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user` int(10) DEFAULT NULL COMMENT '用户',
  `text` varchar(255) NOT NULL COMMENT '内容',
  `issuedate` bigint(13) DEFAULT NULL COMMENT '提交时间',
  `news` int(10) DEFAULT NULL COMMENT '对应文章',
  `support` int(10) DEFAULT '0' COMMENT '赞',
  `contain` int(10) DEFAULT '0' COMMENT '是否包含其他评论',
  PRIMARY KEY (`id`),
  KEY `user` (`user`),
  KEY `news` (`news`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`news`) REFERENCES `news` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('1', '1', '我是第一条评论', '45454687', null, '22', '0');
INSERT INTO `comments` VALUES ('2', null, '我是第二条评论', '45454687', null, '22', '0');
INSERT INTO `comments` VALUES ('3', '1', '我是第三条评论', '45454687', null, '22', '0');
INSERT INTO `comments` VALUES ('4', null, '我是第4条评论', '45454687', null, '22', '0');
INSERT INTO `comments` VALUES ('5', null, '我是第5条评论&lt;', '45454687', null, '22', '0');
INSERT INTO `comments` VALUES ('6', null, '我是第6条评论', '45454687', null, '22', '0');

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '用户组名称',
  `level` varchar(255) NOT NULL COMMENT '权限列',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `group` VALUES ('1', '默认用户组', '1,2,6');
INSERT INTO `group` VALUES ('11', '用户组', '1,3,7,11,4');
INSERT INTO `group` VALUES ('12', '高管组', '1,2,3,4,5,6,7,10,11');

-- ----------------------------
-- Table structure for level
-- ----------------------------
DROP TABLE IF EXISTS `level`;
CREATE TABLE `level` (
  `id` int(2) NOT NULL COMMENT '权限ID',
  `name` varchar(50) NOT NULL COMMENT '权限名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of level
-- ----------------------------
INSERT INTO `level` VALUES ('1', '用户中心');
INSERT INTO `level` VALUES ('2', '新闻管理');
INSERT INTO `level` VALUES ('3', '新闻发布');
INSERT INTO `level` VALUES ('4', '评论管理');
INSERT INTO `level` VALUES ('5', '分类管理');
INSERT INTO `level` VALUES ('6', '用户管理');
INSERT INTO `level` VALUES ('7', '用户组管理');
INSERT INTO `level` VALUES ('10', '基本设置');
INSERT INTO `level` VALUES ('11', '站点设置');

-- ----------------------------
-- Table structure for nav
-- ----------------------------
DROP TABLE IF EXISTS `nav`;
CREATE TABLE `nav` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `type` int(1) NOT NULL COMMENT '导航类型',
  `name` varchar(50) NOT NULL COMMENT '导航名',
  `priority` int(10) DEFAULT '0' COMMENT '优先级',
  `types` int(1) NOT NULL COMMENT '导航类别',
  `category` int(10) DEFAULT NULL COMMENT '分类目录ID',
  `url` varchar(255) DEFAULT NULL COMMENT 'URL链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nav
-- ----------------------------

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL COMMENT '标题',
  `text` text NOT NULL COMMENT '内容',
  `author` int(10) DEFAULT NULL COMMENT '编辑',
  `impnews` int(1) DEFAULT '0' COMMENT '是否推送到要闻',
  `slide` int(1) DEFAULT '0' COMMENT '是否推送到幻灯',
  `slideImg` varchar(255) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL COMMENT '标签',
  `category` int(10) DEFAULT NULL COMMENT '分类',
  `views` int(10) DEFAULT '0' COMMENT '浏览次数',
  `searchs` int(10) DEFAULT '0' COMMENT '搜索次数',
  `created` bigint(13) DEFAULT NULL COMMENT '创建时间',
  `updated` bigint(13) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `authorId` (`author`),
  KEY `category` (`category`),
  CONSTRAINT `news_ibfk_1` FOREIGN KEY (`author`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `news_ibfk_2` FOREIGN KEY (`category`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('32', '欢迎使用瓦客新闻系统！', '<p>瓦客新闻系统</p><p>github：<a href=\"https://github.com/Licoy/wakew-news\" target=\"_blank\" style=\"background-color: rgb(255, 255, 255);\">https://github.com/Licoy/wakew-news</a></p><p>os-git：<a href=\"http://git.oschina.net/licoy/wakew-news\" target=\"_blank\">http://git.oschina.net/licoy/wakew-news</a><br></p><p>欢迎star</p>', '1', '0', '0', '', '', '1', '0', '0', '1502417555811', '1502417555811');

-- ----------------------------
-- Table structure for set
-- ----------------------------
DROP TABLE IF EXISTS `set`;
CREATE TABLE `set` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `key` varchar(255) NOT NULL COMMENT '键',
  `value` varchar(255) DEFAULT NULL COMMENT '值',
  `value_big` text COMMENT '大值',
  `type` int(1) DEFAULT NULL COMMENT '值类型',
  `created` bigint(13) DEFAULT NULL COMMENT '创建时间',
  `updated` bigint(13) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of set
-- ----------------------------
INSERT INTO `set` VALUES ('1', 'notice', '', '你已经成功安装wakew-news，请更改你的站点设置。', '1', '1482108540502', '1482108540502');
INSERT INTO `set` VALUES ('2', 'column-index-footer', '1', null, '0', null, null);
INSERT INTO `set` VALUES ('3', 'column-index-slidebar', '1', null, '0', null, null);
INSERT INTO `set` VALUES ('4', 'column-page-slidebar', '1', null, '0', null, null);
INSERT INTO `set` VALUES ('5', 'slide-max-number', '5', null, '0', null, null);
INSERT INTO `set` VALUES ('6', 'search-placeholder', '搜你所想，看你所看', null, '0', null, null);
INSERT INTO `set` VALUES ('7', 'footer', '', '<span>注：若页面中有内容侵犯到你的隐私或者其他方面的内容，请及时联系网站客服人员，我们将会在第一时间删除相关内容。</span>\r\n<p>© 2015-2016 <a href=\"#\">瓦客新闻网</a> Wakew Group. All Rights Reserved</p>', '1', null, null);
INSERT INTO `set` VALUES ('8', 'register-clause', null, '我是注册条款', '1', null, null);
INSERT INTO `set` VALUES ('9', 'site-title', '瓦客新闻网', null, '0', null, null);
INSERT INTO `set` VALUES ('10', 'site-keyword', '瓦客,新闻,news,最新新闻,实时报道', null, '0', null, null);
INSERT INTO `set` VALUES ('11', 'site-describe', '瓦客新闻网（news.wakew.cn）作为国内首家通过大数据以及云计算为你推荐你所想的内容的新闻网站，让你随时随地体验到实时新闻的资讯，任何时候第一了解国内外的事件等。', null, '0', null, null);
INSERT INTO `set` VALUES ('12', 'logo-url', '/app/img/logo.png', null, '0', null, null);
INSERT INTO `set` VALUES ('13', 'ico-url', '/app/img/favicon.png', null, '0', null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `usermail` varchar(50) NOT NULL COMMENT '用户邮箱',
  `password` varchar(50) NOT NULL COMMENT '用户密码',
  `usergroup` int(10) DEFAULT NULL COMMENT '用户组',
  `created` bigint(13) DEFAULT NULL COMMENT '创建时间',
  `updated` bigint(13) DEFAULT NULL COMMENT '修改时间',
  `lastlogin` bigint(13) DEFAULT NULL COMMENT '上次登录时间',
  `grava` varchar(255) DEFAULT NULL COMMENT '头像',
  `ip` varchar(255) DEFAULT NULL COMMENT 'IP',
  PRIMARY KEY (`id`),
  KEY `usergroup` (`usergroup`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`usergroup`) REFERENCES `group` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin@admin.cn', 'e10adc3949ba59abbe56e057f20f883e', '12', null, '1482673379281', '0', '/app/img/default-grava.jpg', '123.2.1.223');
