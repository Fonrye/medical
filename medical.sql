/*
 Navicat Premium Data Transfer

 Source Server         : fonrye
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : medical

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 27/05/2021 14:00:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `role_menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `menu_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`role_menu_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  INDEX `menu_id`(`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 145 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (69, 4, 1);
INSERT INTO `role_menu` VALUES (70, 4, 12);
INSERT INTO `role_menu` VALUES (71, 4, 13);
INSERT INTO `role_menu` VALUES (72, 4, 14);
INSERT INTO `role_menu` VALUES (73, 4, 15);
INSERT INTO `role_menu` VALUES (74, 4, 16);
INSERT INTO `role_menu` VALUES (75, 4, 17);
INSERT INTO `role_menu` VALUES (97, 1, 1);
INSERT INTO `role_menu` VALUES (98, 1, 2);
INSERT INTO `role_menu` VALUES (99, 1, 3);
INSERT INTO `role_menu` VALUES (100, 1, 4);
INSERT INTO `role_menu` VALUES (101, 1, 5);
INSERT INTO `role_menu` VALUES (102, 1, 6);
INSERT INTO `role_menu` VALUES (103, 1, 7);
INSERT INTO `role_menu` VALUES (104, 1, 8);
INSERT INTO `role_menu` VALUES (105, 1, 9);
INSERT INTO `role_menu` VALUES (106, 1, 10);
INSERT INTO `role_menu` VALUES (107, 1, 11);
INSERT INTO `role_menu` VALUES (108, 1, 24);
INSERT INTO `role_menu` VALUES (109, 1, 12);
INSERT INTO `role_menu` VALUES (110, 1, 13);
INSERT INTO `role_menu` VALUES (111, 1, 14);
INSERT INTO `role_menu` VALUES (112, 1, 15);
INSERT INTO `role_menu` VALUES (113, 1, 16);
INSERT INTO `role_menu` VALUES (114, 1, 17);
INSERT INTO `role_menu` VALUES (115, 1, 25);
INSERT INTO `role_menu` VALUES (116, 1, 18);
INSERT INTO `role_menu` VALUES (117, 1, 19);
INSERT INTO `role_menu` VALUES (118, 5, 1);
INSERT INTO `role_menu` VALUES (119, 5, 2);
INSERT INTO `role_menu` VALUES (120, 5, 3);
INSERT INTO `role_menu` VALUES (121, 5, 4);
INSERT INTO `role_menu` VALUES (122, 5, 5);
INSERT INTO `role_menu` VALUES (123, 5, 6);
INSERT INTO `role_menu` VALUES (124, 5, 7);
INSERT INTO `role_menu` VALUES (125, 5, 8);
INSERT INTO `role_menu` VALUES (126, 5, 9);
INSERT INTO `role_menu` VALUES (127, 5, 10);
INSERT INTO `role_menu` VALUES (128, 5, 11);
INSERT INTO `role_menu` VALUES (129, 5, 24);
INSERT INTO `role_menu` VALUES (130, 2, 1);
INSERT INTO `role_menu` VALUES (131, 2, 12);
INSERT INTO `role_menu` VALUES (132, 2, 13);
INSERT INTO `role_menu` VALUES (133, 2, 14);
INSERT INTO `role_menu` VALUES (134, 2, 15);
INSERT INTO `role_menu` VALUES (135, 2, 16);
INSERT INTO `role_menu` VALUES (136, 2, 17);
INSERT INTO `role_menu` VALUES (137, 2, 25);
INSERT INTO `role_menu` VALUES (138, 3, 1);
INSERT INTO `role_menu` VALUES (139, 3, 2);
INSERT INTO `role_menu` VALUES (140, 3, 18);
INSERT INTO `role_menu` VALUES (141, 3, 19);
INSERT INTO `role_menu` VALUES (142, 6, 1);
INSERT INTO `role_menu` VALUES (143, 6, 18);
INSERT INTO `role_menu` VALUES (144, 6, 19);

-- ----------------------------
-- Table structure for t_area
-- ----------------------------
DROP TABLE IF EXISTS `t_area`;
CREATE TABLE `t_area`  (
  `area_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `area_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `grade` int(3) NULL DEFAULT NULL,
  PRIMARY KEY (`area_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_area
-- ----------------------------
INSERT INTO `t_area` VALUES ('450421', '苍梧县', 1);
INSERT INTO `t_area` VALUES ('45042101', '龙圩镇', 2);
INSERT INTO `t_area` VALUES ('4504210101', '龙圩镇恩义村', 3);
INSERT INTO `t_area` VALUES ('450421010101', '龙圩镇恩义村多一组', 4);
INSERT INTO `t_area` VALUES ('45042102', '新地镇', 2);
INSERT INTO `t_area` VALUES ('4504210201', '新地村', 3);
INSERT INTO `t_area` VALUES ('450421020101', '新地村多一组', 4);
INSERT INTO `t_area` VALUES ('4504210202', '新地2', 3);
INSERT INTO `t_area` VALUES ('45042103', '新小镇', 2);
INSERT INTO `t_area` VALUES ('4504210301', '新村', 3);
INSERT INTO `t_area` VALUES ('450421030101', '新组', 4);

-- ----------------------------
-- Table structure for t_chronicdis
-- ----------------------------
DROP TABLE IF EXISTS `t_chronicdis`;
CREATE TABLE `t_chronicdis`  (
  `ill_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ill_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `py_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wb_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ill_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '慢性病' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_chronicdis
-- ----------------------------
INSERT INTO `t_chronicdis` VALUES ('A15.001', '肺结核，显微镜检证实', 'fjhxwjjzs', 'wb');
INSERT INTO `t_chronicdis` VALUES ('C00-C97>', '恶性肿瘤', 'exzl', 'wb');
INSERT INTO `t_chronicdis` VALUES ('D56.001', 'α型地中海贫血', 'xdzhpx', 'wb');
INSERT INTO `t_chronicdis` VALUES ('D61.905', '再生障碍性贫血 NOS', 'zszaxpx', 'wb');
INSERT INTO `t_chronicdis` VALUES ('D66 02', '血友病', 'xyb', 'wb');
INSERT INTO `t_chronicdis` VALUES ('E05.901', '甲状腺机能亢进', 'jzxjnkj', 'wb');
INSERT INTO `t_chronicdis` VALUES ('E14.901', '糖尿病 NOS', 'tnb', 'wb');
INSERT INTO `t_chronicdis` VALUES ('F29 01', '精神病', 'jsb', 'wb');
INSERT INTO `t_chronicdis` VALUES ('G20 02', '帕金森氏病', 'pjssb', 'wb');
INSERT INTO `t_chronicdis` VALUES ('I09.901', '风湿性心脏病(RHD)', 'fsxxzb', 'wb');
INSERT INTO `t_chronicdis` VALUES ('I10 04', '高血压Ⅱ', 'gxye', 'wb');
INSERT INTO `t_chronicdis` VALUES ('I10 05', '高血压Ⅲ', 'gxys', 'wb');
INSERT INTO `t_chronicdis` VALUES ('I25.101', '冠心病', 'gxb', 'wb');
INSERT INTO `t_chronicdis` VALUES ('K74.151', '肝硬化', 'gyh', 'wb');
INSERT INTO `t_chronicdis` VALUES ('M06.991', '类风湿性关节炎 NOS', 'lfsxgjy', 'wb');
INSERT INTO `t_chronicdis` VALUES ('M32.901', '系统性红斑狼疮 NOS', 'xtxhblc', 'wb');
INSERT INTO `t_chronicdis` VALUES ('N03.903', '慢性肾炎', 'mxsy', 'wb');
INSERT INTO `t_chronicdis` VALUES ('N04.903', '肾病综合征', 'sbzhz', 'wb');
INSERT INTO `t_chronicdis` VALUES ('zmqsb', '终末期肾病（尿毒症）', 'zmqsb', 'wb');

-- ----------------------------
-- Table structure for t_chronicdis_set
-- ----------------------------
DROP TABLE IF EXISTS `t_chronicdis_set`;
CREATE TABLE `t_chronicdis_set`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年度',
  `ill_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '慢性病名称',
  `money_capping` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封顶线',
  `percentage` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报销比例',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '慢性病政策' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_chronicdis_set
-- ----------------------------
INSERT INTO `t_chronicdis_set` VALUES (11, '2020', '恶性肿瘤', '2000', '0.3');
INSERT INTO `t_chronicdis_set` VALUES (12, '2020', 'α型地中海贫血', '2000', '0.3');
INSERT INTO `t_chronicdis_set` VALUES (13, '2020', '再生障碍性贫血 NOS', '2000', '0.3');
INSERT INTO `t_chronicdis_set` VALUES (14, '2020', '血友病', '2000', '0.3');
INSERT INTO `t_chronicdis_set` VALUES (15, '2020', '甲状腺机能亢进', '2000', '0.3');
INSERT INTO `t_chronicdis_set` VALUES (16, '2020', '糖尿病 NOS', '2000', '0.3');
INSERT INTO `t_chronicdis_set` VALUES (17, '2020', '精神病', '2000', '0.3');
INSERT INTO `t_chronicdis_set` VALUES (18, '2020', '帕金森氏病', '2000', '0.3');
INSERT INTO `t_chronicdis_set` VALUES (19, '2020', '风湿性心脏病(RHD)', '2000', '0.3');
INSERT INTO `t_chronicdis_set` VALUES (20, '2020', '高血压Ⅱ', '1200', '0.3');
INSERT INTO `t_chronicdis_set` VALUES (21, '2020', '高血压Ⅲ', '2000', '0.3');
INSERT INTO `t_chronicdis_set` VALUES (22, '2020', '冠心病', '2000', '0.3');
INSERT INTO `t_chronicdis_set` VALUES (23, '2020', '肝硬化', '2000', '0.3');
INSERT INTO `t_chronicdis_set` VALUES (24, '2020', '类风湿性关节炎 NOS', '1200', '0.3');
INSERT INTO `t_chronicdis_set` VALUES (25, '2020', '系统性红斑狼疮 NOS', '2000', '0.3');
INSERT INTO `t_chronicdis_set` VALUES (26, '2020', '慢性肾炎', '2000', '0.3');
INSERT INTO `t_chronicdis_set` VALUES (27, '2020', '肾病综合征', '2000', '0.3');
INSERT INTO `t_chronicdis_set` VALUES (28, '2020', '终末期肾病（尿毒症）', '2000', '0.3');
INSERT INTO `t_chronicdis_set` VALUES (29, '2020', '肺结核，显微镜检证实', '2000', '0.3');

-- ----------------------------
-- Table structure for t_family
-- ----------------------------
DROP TABLE IF EXISTS `t_family`;
CREATE TABLE `t_family`  (
  `xjbh` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '县级编号',
  `xzbh` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '乡镇编号',
  `cbh` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '村编号',
  `zbh` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组编号',
  `jtbh` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '家庭编号',
  `hsx` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户属性',
  `hzxm` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户主姓名',
  `jtrks` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭人口数',
  `nyrks` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '农业人口数',
  `jtdz` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭住址',
  `cjdasj` date NULL DEFAULT NULL COMMENT '创建档案时间',
  `djy` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登记员',
  PRIMARY KEY (`jtbh`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '户口' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_family
-- ----------------------------
INSERT INTO `t_family` VALUES ('450421', '45042101', '4504210101', '450421010101', '4504210101010003', '农村', '颂乐', '5', '5', '首尔', '2020-06-01', '');
INSERT INTO `t_family` VALUES ('450421', '45042103', '4504210301', '450421030101', '4504210301010001', '农村', '52222', '2', '2', '首尔5555', '2020-06-16', '玟星');

-- ----------------------------
-- Table structure for t_familyhold
-- ----------------------------
DROP TABLE IF EXISTS `t_familyhold`;
CREATE TABLE `t_familyhold`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jtbh` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭编号',
  `nhzh` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '农合证号',
  `ylzkh` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医疗证卡号',
  `hnbh` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户内编号',
  `xm` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `yhzgx` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '与户主关系',
  `sfzh` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `xb` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `jkzk` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '健康状况',
  `mz` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '民族',
  `whcd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文化程度',
  `nl` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年龄',
  `csrq` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出生日期',
  `rysx` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '人员属性',
  `sfnchk` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否农村户口',
  `zy` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业',
  `gzdw` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作单位',
  `lxdh` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `czdz` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '常住地址',
  `money_state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参合缴费状态:0未交费，1已缴费',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '户口家庭成员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_familyhold
-- ----------------------------
INSERT INTO `t_familyhold` VALUES (50, '4504210101010003', '987654321', '987654', '01', '颂乐', '户主', '450199102215596', '女', '健康', '无', '本科', NULL, '1991-02-21', '无', '是', '组合', '首尔', '无', '无', '0');
INSERT INTO `t_familyhold` VALUES (51, '4504210101010003', '987654321', '9876544', '02', '玟星E', '夫妻', '4501991022155966', '女', '患病', '无', '本科', NULL, '1991-12-22', '无', '是', '组合', '首尔', '无', '无', '0');
INSERT INTO `t_familyhold` VALUES (52, '4504210101010003', '987654321', '98765444', '03', '辉人', '儿女', '450421995041755596', '女', '患病', '无', '本科', '0', '1995-04-17', '无', '是', '组合', '首尔', '无', '无', '0');
INSERT INTO `t_familyhold` VALUES (54, '4504210101010003', '987654321', '987654444', '04', '华莎', '儿女', '450421199507235596', '女', '患病', '无', '本科', '0', '1995-07-23', '无', '是', '组合', '首尔', '无', '无', '0');
INSERT INTO `t_familyhold` VALUES (55, '4504210301010001', '4504210101010048095222', '98765444422', '01', '555', '户主', '450421995041755596555', '男', '健康', '无', '小学', NULL, '2020-06-20', '无', '是', '组合', '首尔', '无', '无', '0');
INSERT INTO `t_familyhold` VALUES (56, '4504210301010001', '450421010101004809777', '555', '02', '华莎', '夫妻', '450421995041755596222', '男', '健康', '无', '初中', '0', '2020-06-03', '无', '是', '组合', '首尔', '无', '无', '0');

-- ----------------------------
-- Table structure for t_illcard
-- ----------------------------
DROP TABLE IF EXISTS `t_illcard`;
CREATE TABLE `t_illcard`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `xm` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `illcard_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nhzh` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '农合证号',
  `sfzh` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `illname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '疾病名称',
  `start_time` date NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` date NULL DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '慢性病管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_illcard
-- ----------------------------
INSERT INTO `t_illcard` VALUES (12, '颂乐', '987654321450199102215596', '987654321', '450199102215596', '血友病', '2021-10-26', '2021-11-10');
INSERT INTO `t_illcard` VALUES (13, '辉人', '987654321450421995041755596', '987654321', '450421995041755596', '冠心病', '2021-06-09', '2021-09-14');
INSERT INTO `t_illcard` VALUES (14, '华莎', '987654321450421199507235596', '987654321', '450421199507235596', '高血压Ⅱ', '2021-04-01', '2021-04-29');

-- ----------------------------
-- Table structure for t_institution
-- ----------------------------
DROP TABLE IF EXISTS `t_institution`;
CREATE TABLE `t_institution`  (
  `area_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `agen_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `agen_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `grade` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`area_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '农合机构' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_institution
-- ----------------------------
INSERT INTO `t_institution` VALUES ('450421', '667022793', '苍梧县新农合管理中心', 1);
INSERT INTO `t_institution` VALUES ('45042101', 'H001', '龙圩镇合管办', 2);
INSERT INTO `t_institution` VALUES ('450421030101', '222222222222', '新租测试一组', 4);

-- ----------------------------
-- Table structure for t_medical
-- ----------------------------
DROP TABLE IF EXISTS `t_medical`;
CREATE TABLE `t_medical`  (
  `jgbm` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机构编码',
  `zzjgbm` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织机构编码',
  `jgmc` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构名称',
  `dqbm` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地区编码',
  `areacode` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政区域编码',
  `lsgx` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '隶属关系',
  `jgjb` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构级别',
  `sbddlx` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申报定点类型',
  `pzddlx` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批准定点类型',
  `ssjjlx` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属经济类型',
  `wsjgdl` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卫生机构大类',
  `wsjgxl` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卫生机构小类',
  `zgdw` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主管单位',
  `kysj` date NULL DEFAULT NULL COMMENT '开业时间',
  `frdb` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 法人代表',
  `zczj` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册资金',
  PRIMARY KEY (`jgbm`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_medical
-- ----------------------------
INSERT INTO `t_medical` VALUES ('ADD1', '222333', '测试机构1', '测试编码1', '44422', '省', '村卫生室', '综合定点', '综合定点', '国外投资股份有限公司', '护理院', '护理院', '测试1', '1997-04-19', '测试1', '100001.0');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `men_menu_id` int(11) NULL DEFAULT NULL,
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_mark` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`menu_id`) USING BTREE,
  INDEX `men_menu_id`(`men_menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, -1, '欢迎登陆慢性病系统', NULL, '1');
INSERT INTO `t_menu` VALUES (2, 1, '系统设置', NULL, '1');
INSERT INTO `t_menu` VALUES (3, 2, '角色管理', 'system/roleQuery', '1');
INSERT INTO `t_menu` VALUES (4, 2, '用户管理', 'system/userQuery', '1');
INSERT INTO `t_menu` VALUES (5, 2, '权限管理', 'system/menu?method=queryMenuList', '1');
INSERT INTO `t_menu` VALUES (6, 2, '菜单管理', 'aaaa/aaaa', '0');
INSERT INTO `t_menu` VALUES (7, 2, '行政区域管理', 'system/area?method=findArea&&index=1', '1');
INSERT INTO `t_menu` VALUES (8, 2, '农合机构管理', 'system/institution?method=findInstitution&&index=1', '1');
INSERT INTO `t_menu` VALUES (9, 2, '慢病分类管理', 'system/chronicdis?method=findChronicdis&&index=1', '1');
INSERT INTO `t_menu` VALUES (10, 2, '医疗机构管理', 'system/medical?method=findAllMedical&&index=1', '1');
INSERT INTO `t_menu` VALUES (11, 2, '慢病政策设置', 'system/chronicdisSet?method=findAll&index=1', '1');
INSERT INTO `t_menu` VALUES (12, 1, '业务办理', NULL, '1');
INSERT INTO `t_menu` VALUES (13, 12, '家庭档案管理', 'system/family?method=findAllFamily&index=1', '1');
INSERT INTO `t_menu` VALUES (14, 12, '农民档案管理', 'system/familyhold?method=allFamilyhold&index=1', '1');
INSERT INTO `t_menu` VALUES (15, 12, '参合缴费登记', 'system/participation?method=findAll&index=1', '1');
INSERT INTO `t_menu` VALUES (16, 12, '慢病证管理', 'system/illcard?method=findIllCard&index=1', '1');
INSERT INTO `t_menu` VALUES (17, 12, '慢病报销', 'view/system/reimbursement/reimbursement_list.jsp', '1');
INSERT INTO `t_menu` VALUES (18, 1, '报表统计', '	view/system/reimbursement/reimbursement_list.jsp	', '1');
INSERT INTO `t_menu` VALUES (19, 18, '慢性病报销情况', 'system/statistic?method=findAllReim&index=1', '1');
INSERT INTO `t_menu` VALUES (24, 2, '参合缴费设置', 'system/switch?method=findAllSwitch&&index=1', '1');
INSERT INTO `t_menu` VALUES (25, 12, '慢病报销审核', 'system/reimbursement?method=findAllReim&index=1', '1');

-- ----------------------------
-- Table structure for t_participation
-- ----------------------------
DROP TABLE IF EXISTS `t_participation`;
CREATE TABLE `t_participation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chzh` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参合证号',
  `chfph` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参合发票号',
  `jfje` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '缴费金额',
  `jfnd` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '缴费年度',
  `jfsj` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '缴费时间',
  `czy` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作员',
  `jtbh` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭编号',
  `sfzh` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `xm` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '参合缴费登记' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_participation
-- ----------------------------
INSERT INTO `t_participation` VALUES (48, '987654321', '20204504210101010003987654321', '600.0', '2020', '2020-06-17', '', '4504210101010003', '450199102215596', '颂乐');
INSERT INTO `t_participation` VALUES (49, '987654321', '20204504210101010003987654321', '600.0', '2020', '2020-06-17', '', '4504210101010003', '450421995041755596', '辉人');
INSERT INTO `t_participation` VALUES (50, '987654321', '20204504210101010003987654321', '600.0', '2020', '2020-06-18', '玟星', '4504210101010003', '450421199507235596', '华莎');

-- ----------------------------
-- Table structure for t_reim
-- ----------------------------
DROP TABLE IF EXISTS `t_reim`;
CREATE TABLE `t_reim`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `illcard_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '慢病证号',
  `sfzh` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份号',
  `nhzh` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '农合证号',
  `illname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '疾病名称',
  `illmoney` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医疗费用',
  `money` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本次报销金额',
  `yyfph` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医院发票号',
  `jzsj` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '就诊时间',
  `status` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0:未审核 1：已审核 2：已汇款 3：取消汇款·',
  `bxsj` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报销时间',
  `year` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '慢性病报销审核' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_reim
-- ----------------------------
INSERT INTO `t_reim` VALUES (21, '颂乐', '987654321450199102215596', '450199102215596', '987654321', '血友病', '600', '180.0', '9874556', '2020-06-17', '2', '2020-06-17', '2020');
INSERT INTO `t_reim` VALUES (22, '华莎', '987654321450421199507235596', '450421199507235596', '987654321', '高血压Ⅱ', '100', '30.0', '888800', '2020-06-18', '0', '2020-06-18', '2020');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_mark` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '超级管理员', '1');
INSERT INTO `t_role` VALUES (2, '县合管办领导', '1');
INSERT INTO `t_role` VALUES (3, '县合管办经纪人', '1');
INSERT INTO `t_role` VALUES (4, '乡镇农合经办人', '1');
INSERT INTO `t_role` VALUES (5, '测试角色', '0');
INSERT INTO `t_role` VALUES (6, '测试管理员22', '1');

-- ----------------------------
-- Table structure for t_s201
-- ----------------------------
DROP TABLE IF EXISTS `t_s201`;
CREATE TABLE `t_s201`  (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `itemcode` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目码',
  `itemname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名称',
  `type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目类型：\r\n1/隶属关系 \r\n2/机构级别 \r\n3/申报（批准）定点类型 \r\n4/机构所属经济类型 \r\n5/卫生机构类型\r\n',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 144 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_s201
-- ----------------------------
INSERT INTO `t_s201` VALUES (1, '10', '中央', '1');
INSERT INTO `t_s201` VALUES (2, '20', '省', '1');
INSERT INTO `t_s201` VALUES (3, '40', '市、地区', '1');
INSERT INTO `t_s201` VALUES (4, '50', '县', '1');
INSERT INTO `t_s201` VALUES (5, '61', '街道', '1');
INSERT INTO `t_s201` VALUES (6, '62', '镇', '1');
INSERT INTO `t_s201` VALUES (7, '63', '乡', '1');
INSERT INTO `t_s201` VALUES (8, '71', '居民委员会', '1');
INSERT INTO `t_s201` VALUES (9, '72', '村名委员会', '1');
INSERT INTO `t_s201` VALUES (10, '90', '其他', '1');
INSERT INTO `t_s201` VALUES (11, '1', '村卫生室', '2');
INSERT INTO `t_s201` VALUES (12, '2', '乡镇卫生院', '2');
INSERT INTO `t_s201` VALUES (13, '3', '县级医疗机构', '2');
INSERT INTO `t_s201` VALUES (14, '4', '地市级医疗机构', '2');
INSERT INTO `t_s201` VALUES (15, '5', '省级及以上医疗机构', '2');
INSERT INTO `t_s201` VALUES (16, '9', '其他医疗机构', '2');
INSERT INTO `t_s201` VALUES (17, '1', '综合定点', '3');
INSERT INTO `t_s201` VALUES (18, '2', '门诊定点', '3');
INSERT INTO `t_s201` VALUES (19, '3', '住院定点', '3');
INSERT INTO `t_s201` VALUES (20, '9', '其他定点', '3');
INSERT INTO `t_s201` VALUES (21, '10', '内资', '4');
INSERT INTO `t_s201` VALUES (22, '11', '国有全资', '4');
INSERT INTO `t_s201` VALUES (23, '12', '集体全资', '4');
INSERT INTO `t_s201` VALUES (24, '13', '股份合作', '4');
INSERT INTO `t_s201` VALUES (25, '14', '联营', '4');
INSERT INTO `t_s201` VALUES (26, '15', '有限责任公司', '4');
INSERT INTO `t_s201` VALUES (27, '16', '股份有限公司', '4');
INSERT INTO `t_s201` VALUES (28, '17', '私有', '4');
INSERT INTO `t_s201` VALUES (29, '19', '其他内资', '4');
INSERT INTO `t_s201` VALUES (30, '20', '港澳台投资', '4');
INSERT INTO `t_s201` VALUES (31, '21', '内地和港澳台合资', '4');
INSERT INTO `t_s201` VALUES (32, '22', '内地和港澳台合作', '4');
INSERT INTO `t_s201` VALUES (33, '23', '港澳台独资', '4');
INSERT INTO `t_s201` VALUES (34, '24', '港澳台投资股份有限公司', '4');
INSERT INTO `t_s201` VALUES (35, '29', '其他港澳台投资', '4');
INSERT INTO `t_s201` VALUES (36, '30', '国外投资', '4');
INSERT INTO `t_s201` VALUES (37, '31', '中外合资', '4');
INSERT INTO `t_s201` VALUES (38, '32', '中外合作', '4');
INSERT INTO `t_s201` VALUES (39, '33', '外资', '4');
INSERT INTO `t_s201` VALUES (40, '34', '国外投资股份有限公司', '4');
INSERT INTO `t_s201` VALUES (41, '39', '其他国外投资', '4');
INSERT INTO `t_s201` VALUES (42, '90', '其他', '4');
INSERT INTO `t_s201` VALUES (43, 'A', '医院', '5');
INSERT INTO `t_s201` VALUES (44, 'A100', '综合医院', '5');
INSERT INTO `t_s201` VALUES (45, 'A210', '中医医院', '5');
INSERT INTO `t_s201` VALUES (46, 'A300', '中西医结合医院', '5');
INSERT INTO `t_s201` VALUES (47, 'A400', '民族医院', '5');
INSERT INTO `t_s201` VALUES (48, 'A419', '其他民族医院', '5');
INSERT INTO `t_s201` VALUES (49, 'A5', '专科医院', '5');
INSERT INTO `t_s201` VALUES (50, 'A511', '口腔医院（包括牙科医院）', '5');
INSERT INTO `t_s201` VALUES (51, 'A514', '肿瘤医院', '5');
INSERT INTO `t_s201` VALUES (52, 'A518', '妇产（科）医院包括妇婴（儿）医院', '5');
INSERT INTO `t_s201` VALUES (53, 'A519', '儿童医院', '5');
INSERT INTO `t_s201` VALUES (54, 'A520', '精神病医院包括 20 张床位以上的精神卫生中心', '5');
INSERT INTO `t_s201` VALUES (55, 'A521', '传染病医院', '5');
INSERT INTO `t_s201` VALUES (56, 'A522', '皮肤病医院包括性病医院', '5');
INSERT INTO `t_s201` VALUES (57, 'A523', '结核病医院', '5');
INSERT INTO `t_s201` VALUES (58, 'A527', '康复医院', '5');
INSERT INTO `t_s201` VALUES (59, 'A600', '疗养院', '5');
INSERT INTO `t_s201` VALUES (60, 'A7', '护理院', '5');
INSERT INTO `t_s201` VALUES (61, 'B', '社区卫生服务中心（站）', '5');
INSERT INTO `t_s201` VALUES (62, 'B100', '社区卫生服务中心', '5');
INSERT INTO `t_s201` VALUES (63, 'B200', 'B200 社区卫生服务站', '5');
INSERT INTO `t_s201` VALUES (64, 'C', '卫生院', '5');
INSERT INTO `t_s201` VALUES (65, 'C100', '街道卫生院', '5');
INSERT INTO `t_s201` VALUES (66, 'C220', '乡镇卫生院', '5');
INSERT INTO `t_s201` VALUES (67, 'C210', '乡镇中心卫生院', '5');
INSERT INTO `t_s201` VALUES (68, 'D', '门诊部、诊所、医务室、村卫生室', '5');
INSERT INTO `t_s201` VALUES (69, 'D100', '门诊部', '5');
INSERT INTO `t_s201` VALUES (70, 'D120', '中医门诊部', '5');
INSERT INTO `t_s201` VALUES (71, 'D121', '中医(综合)门诊部', '5');
INSERT INTO `t_s201` VALUES (72, 'D122', '中医专科门诊部', '5');
INSERT INTO `t_s201` VALUES (73, 'D130', '中西医结合门诊部', '5');
INSERT INTO `t_s201` VALUES (74, 'D140', '民族医门诊部', '5');
INSERT INTO `t_s201` VALUES (75, 'D211', '普通诊所', '5');
INSERT INTO `t_s201` VALUES (76, 'D212', '中医诊所', '5');
INSERT INTO `t_s201` VALUES (77, 'D213', '中西医结合诊所', '5');
INSERT INTO `t_s201` VALUES (78, 'D214', '民族医诊所', '5');
INSERT INTO `t_s201` VALUES (79, 'D215', '口腔诊所', '5');
INSERT INTO `t_s201` VALUES (80, 'D300', '卫生所（室）', '5');
INSERT INTO `t_s201` VALUES (81, 'D400', '医务室', '5');
INSERT INTO `t_s201` VALUES (82, 'D500', '中小学卫生保健所', '5');
INSERT INTO `t_s201` VALUES (83, 'D600', '村卫生室', '5');
INSERT INTO `t_s201` VALUES (84, 'E', '急救中心（站）', '5');
INSERT INTO `t_s201` VALUES (85, 'E100', '急救中心', '5');
INSERT INTO `t_s201` VALUES (86, 'E200', '急救中心站', '5');
INSERT INTO `t_s201` VALUES (87, 'E300', '急救站', '5');
INSERT INTO `t_s201` VALUES (88, 'F', '采供血机构', '5');
INSERT INTO `t_s201` VALUES (89, 'F1', '血站', '5');
INSERT INTO `t_s201` VALUES (90, 'F2', '单采血浆站', '5');
INSERT INTO `t_s201` VALUES (91, 'G', '妇幼保健院（所、站）', '5');
INSERT INTO `t_s201` VALUES (92, 'G100', '妇幼保健院', '5');
INSERT INTO `t_s201` VALUES (93, 'G200', '妇幼保健所', '5');
INSERT INTO `t_s201` VALUES (94, 'G300', '妇幼保健站', '5');
INSERT INTO `t_s201` VALUES (95, 'G400', '生殖保健中心', '5');
INSERT INTO `t_s201` VALUES (96, 'H', '专科疾病防治院（所、站）', '5');
INSERT INTO `t_s201` VALUES (97, 'H111', '传染病防治院', '5');
INSERT INTO `t_s201` VALUES (98, 'H211', '结核病防治院', '5');
INSERT INTO `t_s201` VALUES (99, 'H100', '专科疾病防治院', '5');
INSERT INTO `t_s201` VALUES (100, 'H200', '专科疾病防治所（站、中心）', '5');
INSERT INTO `t_s201` VALUES (101, 'J', '疾病预防控制中心', '5');
INSERT INTO `t_s201` VALUES (102, 'J100', '疾病预防控制中心', '5');
INSERT INTO `t_s201` VALUES (103, 'J200', '卫生防疫站', '5');
INSERT INTO `t_s201` VALUES (104, 'J300', '卫生防病中心', '5');
INSERT INTO `t_s201` VALUES (105, 'J400', '预防保健中心', '5');
INSERT INTO `t_s201` VALUES (106, 'K', '卫生监督所', '5');
INSERT INTO `t_s201` VALUES (107, 'K100', '卫生监督所(局)', '5');
INSERT INTO `t_s201` VALUES (108, 'L', '卫生监督检验（监测、检测）所', '5');
INSERT INTO `t_s201` VALUES (109, 'L100', '卫生综合监督检验（监测、检测）所', '5');
INSERT INTO `t_s201` VALUES (110, 'L200', '环境卫生监督检验（监测、检测）所', '5');
INSERT INTO `t_s201` VALUES (111, 'L300', '放射卫生监督检验（监测、检测）所', '5');
INSERT INTO `t_s201` VALUES (112, 'L400', '职业卫生监督检验（监测、检测）所', '5');
INSERT INTO `t_s201` VALUES (113, 'L500', '食品卫生监督检验（监测、检测）所', '5');
INSERT INTO `t_s201` VALUES (114, 'L600', '学校卫生监督检验（监测、检测）所', '5');
INSERT INTO `t_s201` VALUES (115, 'L900', '其他卫生监督检验（监测、检测）所', '5');
INSERT INTO `t_s201` VALUES (116, 'M', '医学科学研究机构', '5');
INSERT INTO `t_s201` VALUES (117, 'M100', '医学科学研究院（所）', '5');
INSERT INTO `t_s201` VALUES (118, 'M121', '卫生学校', '5');
INSERT INTO `t_s201` VALUES (119, 'M124', '护士学校', '5');
INSERT INTO `t_s201` VALUES (120, 'M200', '预防医学研究院（所）', '5');
INSERT INTO `t_s201` VALUES (121, 'M300', '中医药研究院（所）', '5');
INSERT INTO `t_s201` VALUES (122, 'M400', '中西医结合研究所', '5');
INSERT INTO `t_s201` VALUES (123, 'M500', '民族医药学研究所', '5');
INSERT INTO `t_s201` VALUES (124, 'M600', '医学专科研究所', '5');
INSERT INTO `t_s201` VALUES (125, 'M700', '药学研究所', '5');
INSERT INTO `t_s201` VALUES (126, 'N', '医学教育机构', '5');
INSERT INTO `t_s201` VALUES (127, 'N100', '医学普通高中等学校', '5');
INSERT INTO `t_s201` VALUES (128, 'N200', '医学成人学校', '5');
INSERT INTO `t_s201` VALUES (129, 'N300', '医学在职培训机构', '5');
INSERT INTO `t_s201` VALUES (130, 'O', '健康教育所（站、中心）', '5');
INSERT INTO `t_s201` VALUES (131, 'O100', '健康教育所', '5');
INSERT INTO `t_s201` VALUES (132, 'O200', '健康教育站（中心）', '5');
INSERT INTO `t_s201` VALUES (133, 'P', '其他卫生机构', '5');
INSERT INTO `t_s201` VALUES (134, 'P100', '临床检验中心', '5');
INSERT INTO `t_s201` VALUES (135, 'P200', '卫生新闻出版社', '5');
INSERT INTO `t_s201` VALUES (136, 'P900', '其他卫生事业机构', '5');
INSERT INTO `t_s201` VALUES (137, 'Q', '卫生社会团体', '5');
INSERT INTO `t_s201` VALUES (138, 'Q100', '红十字会', '5');
INSERT INTO `t_s201` VALUES (139, 'Q200', '医学会', '5');
INSERT INTO `t_s201` VALUES (140, 'Q300', '卫生协会', '5');
INSERT INTO `t_s201` VALUES (141, 'Q900', '其他卫生社会团体', '5');
INSERT INTO `t_s201` VALUES (142, 'A526', '骨科医院', '5');
INSERT INTO `t_s201` VALUES (143, 'M614', '肿瘤(防治)研究所', '5');

-- ----------------------------
-- Table structure for t_switch
-- ----------------------------
DROP TABLE IF EXISTS `t_switch`;
CREATE TABLE `t_switch`  (
  `year` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '当前年度',
  `money` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设置的缴费金额',
  `start_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '缴费开始时间',
  `end_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '缴费结束时间',
  PRIMARY KEY (`year`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_switch
-- ----------------------------
INSERT INTO `t_switch` VALUES ('2020', '600.0', '2020-01-17', '2021-03-09');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_mark` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '方圆', 'admin', '123321', '1');
INSERT INTO `t_user` VALUES (11, '辉人', 'admin3', '11111', '0');
INSERT INTO `t_user` VALUES (12, '颂乐', 'admin4', '11111', '1');
INSERT INTO `t_user` VALUES (14, '华莎', 'admin2', '123456', '0');
INSERT INTO `t_user` VALUES (15, '测试', 'dd', '123456', '1');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`user_role_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (3, 11, 1);
INSERT INTO `user_role` VALUES (4, 12, 2);
INSERT INTO `user_role` VALUES (5, 13, 4);
INSERT INTO `user_role` VALUES (6, 14, 1);
INSERT INTO `user_role` VALUES (7, 15, 5);
INSERT INTO `user_role` VALUES (8, 16, 5);

SET FOREIGN_KEY_CHECKS = 1;
