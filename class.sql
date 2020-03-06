# Host: 127.0.0.1  (Version: 5.5.15)
# Date: 2020-03-06 11:26:42
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES gb2312 */;

#
# Structure for table "address_book"
#

DROP TABLE IF EXISTS `address_book`;
CREATE TABLE `address_book` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `studyNumber` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nativePlace` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `qqNumber` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "address_book"
#

INSERT INTO `address_book` VALUES (1,'14408200328','张三','湖南','13223232323','343422223','湖南');

#
# Structure for table "class_info"
#

DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createtime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "class_info"
#

INSERT INTO `class_info` VALUES (2,'admin','2','34444233','2020-03-04 20:21:43');

#
# Structure for table "class_photo"
#

DROP TABLE IF EXISTS `class_photo`;
CREATE TABLE `class_photo` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `uploadtime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "class_photo"
#

INSERT INTO `class_photo` VALUES (3,'2222','158324965717401a71258db6515a801219c77c17097.jpg@1280w_1l_2o_100sh.png','2020-03-03 23:33:09'),(4,'2','158329109539301f3ca5a219f74a801216e8d1e9e9b.png@1280w_1l_2o_100sh.png','2020-03-04 11:04:56'),(5,'22','1583292761925122222.jpg','2020-03-04 11:32:42'),(6,'i','1583292795161微信图片_20190107105420.png','2020-03-04 11:33:16'),(7,'333','1583292868715微信图片_20190107105420.png','2020-03-04 11:34:29'),(8,'fdas','158329289335001b92b58a42880a801219c776ab757.png','2020-03-04 11:34:54'),(9,'测试','158330041043601deee595f33aea8012193a3d7baa1.png','2020-03-04 13:40:11');

#
# Structure for table "message"
#

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createtime` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "message"
#

INSERT INTO `message` VALUES (3,'admin','2','2020-03-04 17:16:29','1'),(4,'zmy','333','2020-03-06 10:13:30','333');

#
# Structure for table "money_in"
#

DROP TABLE IF EXISTS `money_in`;
CREATE TABLE `money_in` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `count` double(11,2) DEFAULT NULL,
  `in_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "money_in"
#

INSERT INTO `money_in` VALUES (5,'zmy',100.00,'2020-03-06');

#
# Structure for table "money_out"
#

DROP TABLE IF EXISTS `money_out`;
CREATE TABLE `money_out` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `count` double(11,2) DEFAULT NULL,
  `out_time` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `left_money` double(11,2) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "money_out"
#

INSERT INTO `money_out` VALUES (12,'聚餐',50.00,'2020-03-05 21:31:17','admin',249.99),(13,'聚餐',100.00,'2020-03-06 10:27:20','admin',249.99);

#
# Structure for table "permission"
#

DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `desc_` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

#
# Data for table "permission"
#

INSERT INTO `permission` VALUES (2,'角色管理','角色管理','listRole',31),(3,'权限管理','权限管理','listPermission',31),(31,'系统管理','系统管理','',0),(35,'业务管理','业务管理','',0),(62,'用户管理','用户管理','listUser',31),(67,'班级消息','班级消息','listClassInfo',35),(68,'学习交流论坛','学习交流论坛','listStudyInfo',35),(69,'留言板','留言板','listMessage',35),(70,'通讯录','通讯录','listAddressBook',35),(71,'班费支出','班费支出','listMoneyOut',35),(72,'班级相册','班级相册','listPhoto',35),(73,'留言板管理','留言板管理','listMessageManage',31),(74,'学习交流论坛管理','学习交流论坛管理','listStudyInfoManage',31),(75,'班级消息管理','班级消息管理','listClassInfoManage',31),(76,'班费支出管理','班费支出管理','listMoneyOutManage',31),(77,'班费缴纳管理','班费缴纳管理','listMoneyInManage',31),(78,'班级相册管理','班级相册管理','listPhotoManage',31),(81,'通讯录管理','通讯录管理','listAddressBookManage',31);

#
# Structure for table "role"
#

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `desc_` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "role"
#

INSERT INTO `role` VALUES (2,'管理员','管理员'),(4,'注册会员','注册会员'),(5,'一般会员','一般会员');

#
# Structure for table "role_permission"
#

DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rid` bigint(20) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=855 DEFAULT CHARSET=utf8;

#
# Data for table "role_permission"
#

INSERT INTO `role_permission` VALUES (912,5,35),(913,5,67),(914,4,35),(915,4,67),(916,4,68),(917,4,69),(918,4,70),(919,4,71),(920,4,72),(921,2,31),(922,2,2),(923,2,3),(924,2,62),(925,2,73),(926,2,74),(927,2,75),(928,2,76),(929,2,77),(930,2,78),(933,2,81),(934,2,35),(935,2,67),(936,2,68),(937,2,69),(938,2,70),(939,2,71),(940,2,72);

#
# Structure for table "study_info"
#

DROP TABLE IF EXISTS `study_info`;
CREATE TABLE `study_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createtime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "study_info"
#

INSERT INTO `study_info` VALUES (1,'admin','测试','测试','2020-03-06 10:12:03'),(2,'zmy','测试','测试','2020-03-06 10:13:23');

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `realname` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `money` double(11,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'admin','admin','18573903136','管理员','男',83.33),(2,'hehuan','123123','123','何欢','女',83.33),(3,'zmy','zmy','1','曾梦瑶','男',83.33);

#
# Structure for table "user_role"
#

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `rid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;

#
# Data for table "user_role"
#

INSERT INTO `user_role` VALUES (95,1,2),(100,3,4),(102,2,5);
