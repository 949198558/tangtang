/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : tangtang

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2019-03-20 09:43:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` varchar(64) NOT NULL COMMENT '部门id',
  `parent_id` varchar(64) DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(64) DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(64) DEFAULT '' COMMENT '部门名称',
  `order_num` int(12) DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(25) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(12) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `status` char(2) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(2) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dept_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_role`;
CREATE TABLE `sys_dept_role` (
  `dept_id` varchar(64) NOT NULL COMMENT '部门ID',
  `role_id` varchar(64) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和部门关联表';

-- ----------------------------
-- Records of sys_dept_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` varchar(64) NOT NULL COMMENT '菜单ID',
  `menu_name` varchar(64) NOT NULL COMMENT '菜单名称',
  `parent_id` varchar(64) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(12) DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(255) DEFAULT '#' COMMENT '请求地址',
  `menu_type` char(2) DEFAULT '' COMMENT '菜单类型（1目录 2菜单 3按钮）',
  `visible` char(2) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(125) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(125) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '1', '0', '0', '#', '1', '0', 'user:add', '#', '', null, '', null, '');
INSERT INTO `sys_menu` VALUES ('2', '2', '0', '0', '#', '1', '0', 'user:update', '#', '', null, '', null, '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` varchar(64) NOT NULL COMMENT '角色ID',
  `role_name` varchar(64) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限关键字',
  `role_sort` int(4) DEFAULT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限）',
  `status` char(2) DEFAULT NULL COMMENT '角色状态（0正常使用 1停用）',
  `del_flag` char(2) DEFAULT '1' COMMENT '是否删除（0：已删除  1：未删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '1', 'aa', '1', '1', '1', '1', '', null, '', null, null);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` varchar(64) NOT NULL COMMENT '角色ID',
  `menu_id` varchar(64) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '2');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `dept_id` varchar(64) DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `nick_name` varchar(64) DEFAULT NULL COMMENT '昵称',
  `phone` varchar(12) DEFAULT '' COMMENT '手机号',
  `sex` char(2) DEFAULT '0' COMMENT '性别（0：女 1：男 2：保密）',
  `del_flag` char(2) DEFAULT '1' COMMENT '是否删除（0：删除 1：保存）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '11', '1', '1', '我是昵称', '18888888888', '0', '1', '我是创建人', '2019-03-15 14:12:38', '我是更新人', '2019-03-15 14:12:49', '我是备注');
INSERT INTO `sys_user` VALUES ('2', '22', '2', '2', '昵称2', '15888888888', '0', '1', '创建人2', '2019-03-15 14:16:45', '更新人2', '2019-03-15 14:16:57', '备注2');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `role_id` varchar(64) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2');
