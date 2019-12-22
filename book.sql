/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : book

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-12-22 14:12:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cover` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `author` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `date` varchar(20) COLLATE utf8_unicode_ci DEFAULT '',
  `press` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `abs` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'https://i.loli.net/2019/04/10/5cadaa0d0759b.jpg', '且在人间', '余秀华', '2019-2-1', '湖南文艺出版社', '诗人余秀华中篇小说首次结集出版。\r\n\r\n        《且在人间》——以余秀华为生活原型，讲述一个残疾女人悲苦倔强、向死而生的故事。\r\n\r\n        女主人公周玉生活在乡村，患有“脑瘫”，她几乎被所有人漠视，甚至被整个社会抛弃，但是她渴望被当成一个普通的健康人,而不是带着怜悯或不屑，她只要求平等。爱情的缺 失，家庭的不幸，生活的种种际遇让周玉用诗歌的方式把 情感抒发出来，最终她用诗歌创作出了一个文学的世界，得到了人们的认可。', '1');
INSERT INTO `book` VALUES ('2', 'https://img14.360buyimg.com/n2/jfs/t1/67302/25/16133/270426/5ddc9cc9Eb6228495/fef4f8e4f4b95905.jpg!q80.webp', '庆余年', '网络小说', '2017-8-1', '人民文艺出版社', '庆余年·人在京都(卷二修订版 同名电视剧由陈道明、吴刚、张若昀、肖战、李沁等震撼出演）', '2');
INSERT INTO `book` VALUES ('3', 'https://img12.360buyimg.com/n2/jfs/t1/71192/11/9281/397188/5d7063e9E4e0e6e36/5da9240c33f9c3a1.jpg!q95.webp', '我的情绪小怪兽系列', ' 安娜.耶纳斯', '2016-2-1', '明天出版社', '我的情绪小怪兽系列（套装三册）儿童心理训练情绪管理系列图画书，赶走坏情绪学会正确表达情绪。', '3');
INSERT INTO `book` VALUES ('4', 'https://img14.360buyimg.com/n2/jfs/t1/73436/22/12534/179829/5d9e8a2cE3a1112b3/3b623dbb96209233.jpg!q95.webp', '世界美食清单', '澳大利亚Lonely', '2015-2-1', '中国地图出版社', 'Lonely Planet旅行读物系列的新成员《世界美食清单》是本系列第二本趣味书籍。全书一共列出了由铁杆美食迷和资深美食探险家选出的世界范围内500道美食佳肴，是一本精彩的美食探险汇编。', '4');
INSERT INTO `book` VALUES ('5', 'https://img11.360buyimg.com/n2/jfs/t1/91895/17/3177/499415/5ddcc6d0Eab9f4974/1e531b2ead97d5f0.jpg!q95.webp', '新概念英语1', '朗文·外研社', '2015-2-1', '外语教学与研究出版社', '朗文·外研社·新概念英语1 英语初阶 学生用书（全新版 附扫码音频）', '5');
INSERT INTO `book` VALUES ('6', 'https://img11.360buyimg.com/n2/jfs/t1/91954/38/2363/137496/5dd1f118E6f702323/70584940596a13ff.jpg!q95.webp', '5G+AI智能商业', '王宁 等', '2019-4-1', '电子工业出版社', '随着5G的商用，人类将进入一个将移动互联、人工智能、大数据、智能学习整合起来的智能互联网时代。在5G时代，人工智能、大数据和智能学习的能力将充分发挥，并整合成强大的超级智能体系。', '6');
INSERT INTO `book` VALUES ('7', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', ' 2008-1', '重庆出版社', '地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……，“三体文明”正苦苦挣扎——三颗无规则运行的太阳主导下的百余次毁灭与重生逼迫他们逃离母星。而恰在此时。\r\n他们接收到了地球发来的信息。在运用超技术锁死地球人的基础科学之后。三体人庞大的宇宙舰队开始向地球进发……人类的末日悄然来临。', '2');

-- ----------------------------
-- Table structure for bookcategory
-- ----------------------------
DROP TABLE IF EXISTS `bookcategory`;
CREATE TABLE `bookcategory` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of bookcategory
-- ----------------------------
INSERT INTO `bookcategory` VALUES ('1', '文学');
INSERT INTO `bookcategory` VALUES ('2', '流行');
INSERT INTO `bookcategory` VALUES ('3', '儿童');
INSERT INTO `bookcategory` VALUES ('4', '生活');
INSERT INTO `bookcategory` VALUES ('5', '教育');
INSERT INTO `bookcategory` VALUES ('6', '科技');

-- ----------------------------
-- Table structure for mybook
-- ----------------------------
DROP TABLE IF EXISTS `mybook`;
CREATE TABLE `mybook` (
  `id` int(11) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of mybook
-- ----------------------------
INSERT INTO `mybook` VALUES ('1', null);
