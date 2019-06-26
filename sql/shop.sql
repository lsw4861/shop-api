/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.23 : Database - ffast
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ffast` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

USE `ffast`;

/*Table structure for table `b_shop_owner` */

DROP TABLE IF EXISTS `b_shop_owner`;

CREATE TABLE `b_shop_owner` (
  `shop_owner_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `shop_owner_name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '真实姓名',
  `login_name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '登录用户名',
  `password` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `remark` text COLLATE utf8mb4_unicode_ci COMMENT '简介',
  `status` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT '1' COMMENT '状态：待审核（1），有效（1），无效（2）',
  `create_by` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`shop_owner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商家用户';

/*Data for the table `b_shop_owner` */

insert  into `b_shop_owner`(`shop_owner_id`,`shop_owner_name`,`login_name`,`password`,`remark`,`status`,`create_by`,`create_time`,`update_by`,`update_time`) values (1,NULL,'admin','e10adc3949ba59abbe56e057f20f883e',NULL,'1','','2019-06-26 15:37:00','','2019-06-26 15:37:00');

/*Table structure for table `sys_captcha` */

DROP TABLE IF EXISTS `sys_captcha`;

CREATE TABLE `sys_captcha` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `uuid` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT 'uuid',
  `code` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '验证码',
  `expire_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='验证码表';

/*Data for the table `sys_captcha` */

insert  into `sys_captcha`(`id`,`uuid`,`code`,`expire_time`) values (1,'isjfv','6525','2019-06-26 15:29:18'),(2,'isjfv87458','2ea8','2019-06-26 15:29:40'),(3,'d034d57a-6dee-4668-82b6-5635c5941ee2','658a','2019-06-26 15:42:55');

/*Table structure for table `sys_token` */

DROP TABLE IF EXISTS `sys_token`;

CREATE TABLE `sys_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `source_id` int(11) DEFAULT NULL COMMENT '主键ID',
  `token` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'token值',
  `expire_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='认证Token表';

/*Data for the table `sys_token` */

insert  into `sys_token`(`id`,`source_id`,`token`,`expire_time`,`update_time`) values (1,1,'441f16cf2909ad1be5ac54c423b3065d','2019-06-27 03:39:24','2019-06-26 15:39:24');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
