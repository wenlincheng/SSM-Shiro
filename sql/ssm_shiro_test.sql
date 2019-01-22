/*
SQLyog Ultimate v8.32 
MySQL - 5.5.49 : Database - ssm_shiro_test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ssm_shiro_test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ssm_shiro_test`;

/*Table structure for table `t_permission` */

DROP TABLE IF EXISTS `t_permission`;

CREATE TABLE `t_permission` (
  `permission_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '权限 ID',
  `permission_name` varchar(20) NOT NULL COMMENT '权限名称,中文名称',
  `permission_str` varchar(40) NOT NULL COMMENT '权限,Shiro通配符表示，shiro根据通配符进行匹配',
  `permission_url` varchar(40) NOT NULL COMMENT '权限对应的url资源',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8 COMMENT='权限表';

/*Data for the table `t_permission` */

insert  into `t_permission`(`permission_id`,`permission_name`,`permission_str`,`permission_url`) values (1,'系统管理','admin:*','/admin/**'),(2,'用户管理','user:*','/admin/user/**'),(3,'用户添加','user:add','/admin/user/add'),(4,'用户删除','user:delete','/admin/user/delete'),(5,'用户批量删除','user:dels','/admin/user/dels'),(6,'用户修改','user:edit','/admin/user/edit'),(7,'用户保存','user:save','/admin/user/save'),(8,'用户列表','user:list','/admin/user/list'),(9,'用户分页查询','user:page','/admin/user/page'),(10,'用户状态更改','user:status','/admin/user/status'),(11,'用户资源查询','user:resources','/admin/user/resources'),(12,'用户根据id查询','user:getById','/admin/user/getById'),(13,'用户总数查询','user:total','/admin/user/total'),(14,'学生管理','student:*','/admin/student/**'),(15,'学生添加','student:add','/admin/student/add'),(16,'学生删除','student:delete','/admin/student/delete'),(17,'学生批量删除','student:dels','/admin/student/dels'),(18,'学生修改','student:edit','/admin/student/edit'),(19,'学生保存','student:save','/admin/student/save'),(20,'学生列表','student:list','/admin/student/list'),(21,'学生分页查询','student:page','/admin/student/page'),(22,'学生总数查询','student:total','/admin/student/total'),(23,'简历查询','resume:see','/admin/resume/see'),(24,'企业管理','company:*','/admin/company/**'),(25,'企业添加','company:add','/admin/company/add'),(26,'企业删除','company:delete','/admin/company/delete'),(27,'企业批量删除','company:dels','/admin/company/dels'),(28,'企业修改','company:edit','/admin/company/edit'),(29,'企业保存','company:save','/admin/company/save'),(30,'企业列表','company:list','/admin/company/list'),(31,'企业分页查询','company:page','/admin/company/page'),(32,'企业总数查询','company:total','/admin/company/total'),(33,'企业根据id查询','company:getById','/admin/company/getById'),(34,'职位管理','job:*','/admin/job/**'),(35,'职位添加','job:add','/admin/job/add'),(36,'职位删除','job:delete','/admin/job/delete'),(37,'职位批量删除','job:dels','/admin/job/dels'),(38,'职位修改','job:edit','/admin/job/edit'),(39,'职位保存','job:save','/admin/job/save'),(40,'职位列表','job:list','/admin/job/list'),(41,'职位分页查询','job:page','/admin/job/page'),(42,'职位总数查询','job:total','/admin/job/total'),(43,'职位根据id查询','job:getById','/admin/job/getById'),(44,'职位详情查看','job:getContext','/admin/job/getContext'),(45,'职位状态修改','job:changeStatus','/admin/job/changeStatus'),(46,'角色管理','role:*','/admin/role/**'),(47,'角色添加','role:add','/admin/role/add'),(48,'角色删除','role:delete','/admin/role/delete'),(49,'角色批量删除','role:dels','/admin/role/dels'),(50,'角色修改','role:edit','/admin/role/edit'),(51,'角色保存','role:save','/admin/role/save'),(52,'角色列表','role:list','/admin/role/list'),(53,'角色分页查询','role:page','/admin/role/page'),(54,'角色权限查询','role:auth','/admin/role/auth'),(55,'角色权限修改','role:changeAuth','/admin/role/changeAuth'),(56,'权限管理','resource:*','/admin/resource/**'),(57,'权限添加','resource:add','/admin/resource/add'),(58,'权限删除','resource:delete','/admin/resource/delete'),(59,'权限批量删除','resource:dels','/admin/resource/dels'),(60,'权限修改','resource:edit','/admin/resource/edit'),(61,'权限保存','resource:save','/admin/resource/save'),(62,'权限列表','resource:list','/admin/resource/list'),(63,'权限分页查询','resource:page','/admin/resource/page'),(64,'通知管理','notice:*','/admin/notice/**'),(65,'通知添加','notice:add','/admin/notice/add'),(66,'通知删除','notice:delete','/admin/notice/delete'),(67,'通知批量删除','notice:dels','/admin/notice/dels'),(68,'通知修改','notice:edit','/admin/notice/edit'),(69,'通知保存','notice:save','/admin/notice/save'),(70,'通知列表','notice:list','/admin/notice/list'),(71,'通知分页查询','notice:page','/admin/notice/page'),(72,'通知根据id查询','notice:getById','/admin/notice/getById'),(73,'消息管理','message:*','/admin/message/**'),(74,'消息添加','message:add','/admin/message/add'),(75,'消息删除','message:delete','/admin/message/delete'),(76,'消息批量删除','message:dels','/admin/message/dels'),(77,'消息修改','message:edit','/admin/message/edit'),(78,'消息保存','message:save','/admin/message/save'),(79,'消息列表','message:list','/admin/message/list'),(80,'消息分页查询','message:page','/admin/message/page');

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `role_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名字',
  `role_str` varchar(255) DEFAULT NULL COMMENT '角色字符串',
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `t_role` */

insert  into `t_role`(`role_id`,`role_name`,`role_str`) values (1,'管理员','admin'),(2,'学生','student'),(3,'企业','company'),(4,'半个管理员','half_admin'),(5,'游客','guest');

/*Table structure for table `t_role_permission` */

DROP TABLE IF EXISTS `t_role_permission`;

CREATE TABLE `t_role_permission` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色权限关联 ID',
  `role_id` int(10) NOT NULL COMMENT '角色 id',
  `permission_id` int(10) NOT NULL COMMENT '权限 id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';

/*Data for the table `t_role_permission` */

insert  into `t_role_permission`(`id`,`role_id`,`permission_id`) values (1,1,1),(28,2,19),(29,2,23),(30,2,31),(32,2,33),(34,2,41),(37,2,71),(50,3,71),(51,3,23),(57,3,80),(58,3,72),(59,2,72),(60,2,80),(61,2,78),(62,3,24),(63,3,34);

/*Table structure for table `t_system_log` */

DROP TABLE IF EXISTS `t_system_log`;

CREATE TABLE `t_system_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `description` varchar(100) DEFAULT NULL COMMENT '方法描述',
  `method` varchar(100) DEFAULT NULL COMMENT '方法名',
  `request_type` varchar(100) DEFAULT NULL COMMENT '请求方式',
  `request_username` varchar(100) DEFAULT NULL COMMENT '请求用户',
  `request_ip` varchar(100) DEFAULT NULL COMMENT '请求ip',
  `request_uri` varchar(100) DEFAULT NULL COMMENT '请求路径',
  `exception_code` varchar(255) DEFAULT NULL COMMENT '异常code',
  `exception_detail` varchar(255) DEFAULT NULL COMMENT '异常描述',
  `params` varchar(255) DEFAULT NULL COMMENT '请求参数',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2717 DEFAULT CHARSET=utf8 COMMENT='系统日志';

/*Data for the table `t_system_log` */

insert  into `t_system_log`(`id`,`description`,`method`,`request_type`,`request_username`,`request_ip`,`request_uri`,`exception_code`,`exception_detail`,`params`,`create_date`) values (2669,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','admin','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 1960841725, userId=null, userName=admin, userPassword=123456, userTrueName=null, user','2019-01-22 22:25:00'),(2670,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','admin','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 1619422605, userId=null, userName=admin, userPassword=123456, userTrueName=null, user','2019-01-22 22:28:36'),(2671,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','admin','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 1031736183, userId=null, userName=admin, userPassword=123456, userTrueName=null, user','2019-01-22 22:29:45'),(2672,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','admin','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 846072157, userId=null, userName=admin, userPassword=123456, userTrueName=null, userS','2019-01-22 22:31:29'),(2673,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-22 22:33:01'),(2674,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','admin','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 1129633632, userId=null, userName=admin, userPassword=123456, userTrueName=null, user','2019-01-22 22:33:07'),(2675,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','admin','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 328081315, userId=null, userName=admin, userPassword=123456, userTrueName=null, userS','2019-01-22 22:34:07'),(2676,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','admin','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 1813403892, userId=null, userName=admin, userPassword=123456, userTrueName=null, user','2019-01-22 23:15:06'),(2677,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-22 23:16:36'),(2678,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','xiaoxiao','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 716142042, userId=null, userName=xiaoxiao, userPassword=123456, userTrueName=null, us','2019-01-22 23:17:25'),(2679,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-22 23:21:29'),(2680,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-22 23:21:31'),(2681,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-22 23:22:23'),(2682,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','admin','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 1505763749, userId=null, userName=admin, userPassword=123456, userTrueName=null, user','2019-01-22 23:23:11'),(2683,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-22 23:25:56'),(2684,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-22 23:26:00'),(2685,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','admin','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 889925541, userId=null, userName=admin, userPassword=123456, userTrueName=null, userS','2019-01-22 23:26:07'),(2686,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-22 23:27:58'),(2687,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-22 23:28:00'),(2688,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','admin','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 2134383478, userId=null, userName=admin, userPassword=123456, userTrueName=null, user','2019-01-22 23:28:18'),(2689,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-22 23:30:01'),(2690,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','admin','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 973172405, userId=null, userName=admin, userPassword=123456, userTrueName=null, userS','2019-01-22 23:30:07'),(2691,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','admin','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 771409144, userId=null, userName=admin, userPassword=123456, userTrueName=null, userS','2019-01-22 23:31:27'),(2692,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','xiaoxiao','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 1121982953, userId=null, userName=xiaoxiao, userPassword=123456, userTrueName=null, u','2019-01-23 00:00:05'),(2693,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-23 00:00:49'),(2694,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','admin','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 1105506078, userId=null, userName=admin, userPassword=123456, userTrueName=null, user','2019-01-23 00:00:56'),(2695,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','admin','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 1782791299, userId=null, userName=admin, userPassword=123456, userTrueName=null, user','2019-01-23 00:10:37'),(2696,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','admin','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 1504525003, userId=null, userName=admin, userPassword=123456, userTrueName=null, user','2019-01-23 00:14:34'),(2697,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','xiaoxiao','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 187974498, userId=null, userName=xiaoxiao, userPassword=123456, userTrueName=null, us','2019-01-23 00:21:21'),(2698,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-23 00:21:30'),(2699,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','admin','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 967934381, userId=null, userName=admin, userPassword=123456, userTrueName=null, userS','2019-01-23 00:21:37'),(2700,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-23 00:21:55'),(2701,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-23 00:21:58'),(2702,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','xiaoxiao','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 364738930, userId=null, userName=xiaoxiao, userPassword=123456, userTrueName=null, us','2019-01-23 00:22:15'),(2703,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-23 00:25:31'),(2704,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','xiaoxiao','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 684780485, userId=null, userName=xiaoxiao, userPassword=123456, userTrueName=null, us','2019-01-23 00:26:16'),(2705,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-23 00:27:44'),(2706,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','xiaoxiao','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 718330963, userId=null, userName=xiaoxiao, userPassword=123456, userTrueName=null, us','2019-01-23 00:28:07'),(2707,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-23 00:28:09'),(2708,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','xiaoxiao','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 657125593, userId=null, userName=xiaoxiao, userPassword=123456, userTrueName=null, us','2019-01-23 00:28:15'),(2709,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','xiaoxiao','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 706517975, userId=null, userName=xiaoxiao, userPassword=123456, userTrueName=null, us','2019-01-23 00:35:47'),(2710,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-23 00:36:00'),(2711,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','admin','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 1098751566, userId=null, userName=admin, userPassword=123456, userTrueName=null, user','2019-01-23 00:44:44'),(2712,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-23 00:44:51'),(2713,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','admin','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 456541940, userId=null, userName=admin, userPassword=123456, userTrueName=null, userS','2019-01-23 00:44:58'),(2714,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-23 00:45:17'),(2715,'用户登录','com.wenlincheng.ssm.controller.LoginController.login()','POST','xiaoxiao','0:0:0:0:0:0:0:1','/login/submit',NULL,NULL,'TUser [Hash = 841907362, userId=null, userName=xiaoxiao, userPassword=123456, userTrueName=null, us','2019-01-23 00:46:01'),(2716,'用户退出登录','com.wenlincheng.ssm.controller.LoginController.logout()','GET','游客','0:0:0:0:0:0:0:1','/login/logout',NULL,NULL,'ModelAndView: reference to view with name \'login\'; model is null','2019-01-23 00:46:19');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(255) DEFAULT NULL COMMENT '密码',
  `user_true_name` varchar(255) DEFAULT NULL COMMENT '真实名字',
  `user_sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `user_email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `user_avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `user_register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `user_last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `user_status` int(2) DEFAULT '1' COMMENT '0 未激活 1 激活 2 在线 ',
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `t_user` */

insert  into `t_user`(`user_id`,`user_name`,`user_password`,`user_true_name`,`user_sex`,`user_email`,`user_avatar`,`user_register_time`,`user_last_login_time`,`user_status`) values (1,'admin','a66abb5684c45962d887564f08346e8d','管理员','男','admin@163.com','a.jpg','2018-07-26 13:14:18','2018-07-26 13:14:18',1),(2,'xiaoxiao','1e4d7bff58116f3119cc457d05c03d33','小小','男','xiaoxiao@163.com','b.jpg','2018-07-26 13:14:18','2018-07-26 13:14:18',1),(3,'xiaowang','2d0f78d4a104434a820c8c1fa7d8e6e8','小王','男','xiaowang@163.com','c.jpg','2018-07-26 13:14:18','2018-07-26 13:14:18',1),(4,'tutu','d52cf325b80c43523ac3c6a5bec02332','兔兔','女','tutu@163.com','a.jpg','2018-07-26 13:14:18','2018-07-26 13:14:18',1),(5,'lele','641407fc65778ace3923f0b85d19907b','乐乐','男','lele@163.com','b.jpg','2018-07-26 13:14:18','2018-07-26 13:14:18',1),(6,'zizi','8e034a5d004634302f8902441a4115dc','滋滋','女','zizi@163.com','c.jpg','2018-07-26 13:14:18','2018-07-26 13:14:18',1),(7,'mingming','cd4fec56d2b21856e45fd6ed7e599912','明明','男','mingming@163.com','a.jpg','2018-07-26 13:14:18','2018-07-26 13:14:18',1),(8,'fafa','ac722855eaf5a6a1dd91040f03b81e52','发发','男','fafa@163.com','a.jpg','2018-07-26 13:14:18','2018-07-26 13:14:18',1),(9,'huanhuan','a5e984a1b7c6c4fed8c93085d8bd2a65','焕焕','男','huanhuan@163.com','a.jpg','2018-07-26 13:14:18','2018-07-26 13:14:18',1),(10,'chengcheng','70e026a4fb578b33bdbc3e237331fe35','诚诚','男','chengcheng@163.com','a.jpg','2018-07-26 13:14:18','2018-07-26 13:14:18',1),(11,'xiaoliu','9321d90c5852e5e00b33087027a8dba3','小刘','男','xiaoliu@163.com','b.jpg','2018-07-26 13:14:18','2018-07-26 13:14:18',1),(12,'xiaocao','2e2966949f1c3153cbaea8f1189d03d7','小曹','男','xiaocao@163.com','b.jpg','2018-07-26 13:14:18','2018-07-26 13:14:18',1),(13,'xiaoma','cc5ef2b7c235bad3ecfa17c91ca3fbb2','小马','男','xiaoma@163.com','b.jpg','2018-07-26 13:14:18','2018-07-26 13:14:18',1),(14,'xiaoding','8671ef56e9d2d65b1aa98d75d9a54b74','小丁','男','xiaoding@163.com','b.jpg','2018-07-26 13:14:18','2018-07-26 13:14:18',1),(24,'haha','8c7e1f3b1b787ec9f24fcc01e243e072','哈哈','男','haha@163.com','b.jpg','2018-07-26 13:14:18','2018-07-26 13:14:18',1),(25,'hehe','f9703eeba357eccc5fb7f98c039c366e','呵呵','男','hehe@163.com','b.jpg','2018-07-26 13:14:18','2018-07-26 13:14:18',1),(26,'sisi','e522bfc20c4afcdcb9d9f99be5abff53','思思','女','sisi@163.com','/avatar/a.jpg','2018-11-01 00:17:51','2018-11-01 00:17:51',1),(31,'aa','8a6f2805b4515ac12058e79e66539be9','啊啊','女','aa@163.com','/avatar/a.jpg','2018-11-18 23:48:47','2018-11-18 23:48:47',1),(30,'jj','aaec1fdbb6b2a2410e1cfaa41cb4bbce','吉吉','男','13@134.com','/avatar/a.jpg','2018-11-18 23:47:28','2018-11-18 23:47:28',1),(32,'bb','95b722835cc2b2c059e5fab5121dfd31','宝宝','女','21@163.com','/avatar/a.jpg','2018-11-18 23:56:13','2018-11-18 23:56:13',1),(33,'wlc','1fd0a90164337ad7a0ba37e72ce778b6','wlc','男','wlc@163.com','/avatar/a.jpg','2018-11-27 19:44:38','2018-11-27 19:44:38',1),(34,'xiaozhang','8b373ce7099c2429e1de2b9b49b5e067','小张','男','xiaozhang@163.com','/avatar/a.jpg','2018-11-27 19:52:39','2018-11-27 19:52:39',1);

/*Table structure for table `t_user_role` */

DROP TABLE IF EXISTS `t_user_role`;

CREATE TABLE `t_user_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户角色关联表 ID',
  `user_id` int(10) NOT NULL,
  `role_id` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

/*Data for the table `t_user_role` */

insert  into `t_user_role`(`id`,`user_id`,`role_id`) values (1,1,1),(2,2,2),(3,3,3),(4,5,2),(5,7,2),(6,8,2),(7,9,2),(8,10,2),(9,24,2),(10,6,3),(11,11,3),(12,12,3),(13,13,3),(14,14,3),(15,25,3),(16,26,3),(17,28,2),(18,30,3),(19,31,2),(20,32,3),(21,33,2),(22,34,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
