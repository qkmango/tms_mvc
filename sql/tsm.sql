/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : tsm

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 21/07/2021 21:12:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` bit(1) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'admin', b'1', '1');

-- ----------------------------
-- Table structure for t_building
-- ----------------------------
DROP TABLE IF EXISTS `t_building`;
CREATE TABLE `t_building`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '楼id',
  `number` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '楼号,可以有英文结尾',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '楼名称',
  `buildingType` enum('j','s','q') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '楼类型， pedagogical教学楼，experimental实验楼,other其他',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UQ_number_buildingType`(`number`, `buildingType`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_building
-- ----------------------------
INSERT INTO `t_building` VALUES (1, '13', '大数据与人工智能学院', 'j');
INSERT INTO `t_building` VALUES (2, '11', '艺术学院', 'j');
INSERT INTO `t_building` VALUES (3, '12', '财会与金融学院', 'j');
INSERT INTO `t_building` VALUES (5, '14', '电子工程学院', 'j');
INSERT INTO `t_building` VALUES (6, '1', '土木与环境工程学院-A', 'j');
INSERT INTO `t_building` VALUES (7, '2', '土木与环境工程学院-B1', 'j');
INSERT INTO `t_building` VALUES (8, '7A', '国际教育学院', 'j');
INSERT INTO `t_building` VALUES (9, '7B', '文化与新闻传播学院', 'j');

-- ----------------------------
-- Table structure for t_clazz
-- ----------------------------
DROP TABLE IF EXISTS `t_clazz`;
CREATE TABLE `t_clazz`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `specialized` int(11) UNSIGNED NOT NULL COMMENT '所属院系',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `clazzYear` int(4) UNSIGNED NOT NULL COMMENT '所属级，如2020级',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_clazz_REF_specialized`(`specialized`) USING BTREE,
  INDEX `FK_clazz_REF_year`(`clazzYear`) USING BTREE,
  CONSTRAINT `FK_clazz_REF_specialized` FOREIGN KEY (`specialized`) REFERENCES `t_specialized` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `FK_clazz_REF_year` FOREIGN KEY (`clazzYear`) REFERENCES `t_year` (`year`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_clazz
-- ----------------------------
INSERT INTO `t_clazz` VALUES (1, 1, '20计应1班', 2020);
INSERT INTO `t_clazz` VALUES (2, 2, '20通信2班', 2020);

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `credit` enum('1','2','3','4') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学分',
  `clazz` int(11) UNSIGNED NOT NULL COMMENT '所属班级',
  `teacher` int(11) UNSIGNED NOT NULL COMMENT '授课老师',
  `courseYear` int(4) UNSIGNED NOT NULL COMMENT '年度',
  `term` bit(1) NOT NULL COMMENT '学期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_course_REF_teacher`(`teacher`) USING BTREE,
  INDEX `FK_course_REF_year`(`courseYear`) USING BTREE,
  INDEX `FK_course_REF_clazz`(`clazz`) USING BTREE,
  CONSTRAINT `FK_course_REF_clazz` FOREIGN KEY (`clazz`) REFERENCES `t_clazz` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `FK_course_REF_teacher` FOREIGN KEY (`teacher`) REFERENCES `t_teacher` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `FK_course_REF_year` FOREIGN KEY (`courseYear`) REFERENCES `t_year` (`year`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES (1, '1Java', '4', 1, 1, 2021, b'0');
INSERT INTO `t_course` VALUES (2, '2SQLServer数据库', '2', 1, 1, 2021, b'0');
INSERT INTO `t_course` VALUES (3, '2微机原理', '2', 1, 2, 2021, b'1');
INSERT INTO `t_course` VALUES (4, '2通信技术', '2', 1, 2, 2021, b'1');
INSERT INTO `t_course` VALUES (5, '1HTML', '1', 1, 2, 2021, b'1');
INSERT INTO `t_course` VALUES (6, '计算机基础', '2', 1, 7, 2020, b'1');
INSERT INTO `t_course` VALUES (7, '高等数学', '1', 1, 5, 2020, b'0');
INSERT INTO `t_course` VALUES (8, 'HTML网站设计', '2', 2, 5, 2020, b'0');
INSERT INTO `t_course` VALUES (9, 'MySQL数据库', '2', 2, 5, 2020, b'0');
INSERT INTO `t_course` VALUES (10, '英语', '3', 1, 3, 2020, b'0');
INSERT INTO `t_course` VALUES (11, '数字逻辑电路', '3', 1, 3, 2020, b'0');
INSERT INTO `t_course` VALUES (12, '模拟电路', '3', 1, 3, 2020, b'0');
INSERT INTO `t_course` VALUES (13, 'PHP动态网站开发', '3', 1, 3, 2020, b'0');
INSERT INTO `t_course` VALUES (14, 'spring', '3', 1, 3, 2020, b'0');
INSERT INTO `t_course` VALUES (15, 'springmvc', '2', 1, 1, 2020, b'0');
INSERT INTO `t_course` VALUES (16, 'Mybatis', '2', 1, 1, 2020, b'0');
INSERT INTO `t_course` VALUES (17, 'Office', '3', 1, 8, 2020, b'1');

-- ----------------------------
-- Table structure for t_course_info
-- ----------------------------
DROP TABLE IF EXISTS `t_course_info`;
CREATE TABLE `t_course_info`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `course` int(11) UNSIGNED NOT NULL COMMENT 'course ID',
  `courseType` enum('theory','practice') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程类型 \'theory\',\'practice\' 理论课 实验课',
  `weekType` enum('sgl','dbl','all') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '周次 \'sgl\',\'dbl\',\'all\' 单周 双周 不限',
  `beginWeek` tinyint(4) UNSIGNED NOT NULL COMMENT '起始周',
  `lengthWeek` tinyint(4) UNSIGNED NOT NULL COMMENT '持续周',
  `weekDay` enum('Monday','Tuesday','Wednesday','Thursday','Friday','Saturday','Sunday') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '星期',
  `begin` tinyint(4) UNSIGNED NOT NULL COMMENT '起始节',
  `length` tinyint(4) UNSIGNED NOT NULL COMMENT '持续节',
  `address` int(11) UNSIGNED NOT NULL COMMENT '上课地点',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_course_info_REF_course`(`course`) USING BTREE,
  INDEX `FK_course_info_REF_room`(`address`) USING BTREE,
  CONSTRAINT `FK_course_info_REF_course` FOREIGN KEY (`course`) REFERENCES `t_course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_course_info_REF_room` FOREIGN KEY (`address`) REFERENCES `t_room` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_course_info
-- ----------------------------
INSERT INTO `t_course_info` VALUES (1, 6, 'theory', 'sgl', 1, 1, 'Thursday', 1, 1, 1);
INSERT INTO `t_course_info` VALUES (2, 7, 'theory', 'sgl', 2, 2, 'Sunday', 2, 2, 2);
INSERT INTO `t_course_info` VALUES (3, 8, 'theory', 'all', 1, 1, 'Saturday', 1, 1, 3);
INSERT INTO `t_course_info` VALUES (4, 9, 'theory', 'all', 1, 1, 'Saturday', 1, 1, 3);
INSERT INTO `t_course_info` VALUES (5, 10, 'theory', 'all', 1, 1, 'Sunday', 1, 1, 3);
INSERT INTO `t_course_info` VALUES (6, 11, 'theory', 'all', 1, 1, 'Sunday', 1, 1, 3);
INSERT INTO `t_course_info` VALUES (9, 16, 'theory', 'all', 1, 1, 'Sunday', 1, 1, 3);
INSERT INTO `t_course_info` VALUES (10, 16, 'theory', 'all', 2, 2, 'Saturday', 2, 2, 2);
INSERT INTO `t_course_info` VALUES (11, 17, 'theory', 'sgl', 1, 15, 'Saturday', 2, 2, 3);
INSERT INTO `t_course_info` VALUES (12, 17, 'practice', 'dbl', 2, 16, 'Friday', 5, 4, 1);

-- ----------------------------
-- Table structure for t_elective
-- ----------------------------
DROP TABLE IF EXISTS `t_elective`;
CREATE TABLE `t_elective`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `student` int(11) UNSIGNED NOT NULL,
  `course` int(11) UNSIGNED NOT NULL,
  `score` int(11) NULL DEFAULT NULL COMMENT '成绩',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UI_student_course`(`student`, `course`) USING BTREE,
  INDEX `FK_elective_REF_course`(`course`) USING BTREE,
  CONSTRAINT `FK_elective_REF_course` FOREIGN KEY (`course`) REFERENCES `t_course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_elective_REF_student` FOREIGN KEY (`student`) REFERENCES `t_student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 348 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_elective
-- ----------------------------
INSERT INTO `t_elective` VALUES (178, 2, 1, NULL);
INSERT INTO `t_elective` VALUES (179, 3, 1, NULL);
INSERT INTO `t_elective` VALUES (180, 4, 1, NULL);
INSERT INTO `t_elective` VALUES (181, 5, 1, NULL);
INSERT INTO `t_elective` VALUES (182, 6, 1, NULL);
INSERT INTO `t_elective` VALUES (183, 7, 1, NULL);
INSERT INTO `t_elective` VALUES (184, 8, 1, NULL);
INSERT INTO `t_elective` VALUES (185, 9, 1, NULL);
INSERT INTO `t_elective` VALUES (186, 10, 1, NULL);
INSERT INTO `t_elective` VALUES (187, 11, 1, NULL);
INSERT INTO `t_elective` VALUES (188, 12, 1, NULL);
INSERT INTO `t_elective` VALUES (189, 13, 1, 98);
INSERT INTO `t_elective` VALUES (190, 14, 1, NULL);
INSERT INTO `t_elective` VALUES (191, 15, 1, NULL);
INSERT INTO `t_elective` VALUES (192, 16, 1, NULL);
INSERT INTO `t_elective` VALUES (193, 17, 1, NULL);
INSERT INTO `t_elective` VALUES (194, 18, 1, NULL);
INSERT INTO `t_elective` VALUES (195, 19, 1, NULL);
INSERT INTO `t_elective` VALUES (196, 20, 1, NULL);
INSERT INTO `t_elective` VALUES (197, 21, 1, 0);
INSERT INTO `t_elective` VALUES (198, 22, 1, NULL);
INSERT INTO `t_elective` VALUES (199, 23, 1, NULL);
INSERT INTO `t_elective` VALUES (200, 24, 1, NULL);
INSERT INTO `t_elective` VALUES (201, 25, 1, NULL);
INSERT INTO `t_elective` VALUES (202, 26, 1, NULL);
INSERT INTO `t_elective` VALUES (203, 27, 1, NULL);
INSERT INTO `t_elective` VALUES (204, 28, 1, NULL);
INSERT INTO `t_elective` VALUES (205, 29, 1, NULL);
INSERT INTO `t_elective` VALUES (206, 30, 1, NULL);
INSERT INTO `t_elective` VALUES (208, 2, 5, 77);
INSERT INTO `t_elective` VALUES (209, 3, 5, NULL);
INSERT INTO `t_elective` VALUES (210, 4, 5, NULL);
INSERT INTO `t_elective` VALUES (211, 5, 5, NULL);
INSERT INTO `t_elective` VALUES (212, 6, 5, NULL);
INSERT INTO `t_elective` VALUES (213, 7, 5, NULL);
INSERT INTO `t_elective` VALUES (214, 8, 5, NULL);
INSERT INTO `t_elective` VALUES (215, 9, 5, NULL);
INSERT INTO `t_elective` VALUES (216, 10, 5, NULL);
INSERT INTO `t_elective` VALUES (217, 11, 5, 87);
INSERT INTO `t_elective` VALUES (218, 12, 5, NULL);
INSERT INTO `t_elective` VALUES (219, 13, 5, NULL);
INSERT INTO `t_elective` VALUES (220, 14, 5, NULL);
INSERT INTO `t_elective` VALUES (221, 15, 5, NULL);
INSERT INTO `t_elective` VALUES (222, 16, 5, NULL);
INSERT INTO `t_elective` VALUES (223, 17, 5, NULL);
INSERT INTO `t_elective` VALUES (224, 18, 5, NULL);
INSERT INTO `t_elective` VALUES (225, 19, 5, NULL);
INSERT INTO `t_elective` VALUES (226, 20, 5, NULL);
INSERT INTO `t_elective` VALUES (227, 21, 5, NULL);
INSERT INTO `t_elective` VALUES (228, 22, 5, NULL);
INSERT INTO `t_elective` VALUES (229, 23, 5, NULL);
INSERT INTO `t_elective` VALUES (230, 24, 5, NULL);
INSERT INTO `t_elective` VALUES (231, 25, 5, NULL);
INSERT INTO `t_elective` VALUES (232, 26, 5, NULL);
INSERT INTO `t_elective` VALUES (233, 27, 5, NULL);
INSERT INTO `t_elective` VALUES (234, 28, 5, NULL);
INSERT INTO `t_elective` VALUES (235, 29, 5, NULL);
INSERT INTO `t_elective` VALUES (236, 30, 5, NULL);
INSERT INTO `t_elective` VALUES (237, 31, 3, NULL);
INSERT INTO `t_elective` VALUES (238, 32, 4, NULL);
INSERT INTO `t_elective` VALUES (239, 33, 2, NULL);
INSERT INTO `t_elective` VALUES (240, 34, 3, NULL);
INSERT INTO `t_elective` VALUES (241, 35, 4, NULL);
INSERT INTO `t_elective` VALUES (242, 36, 2, NULL);
INSERT INTO `t_elective` VALUES (243, 37, 3, NULL);
INSERT INTO `t_elective` VALUES (244, 38, 4, NULL);
INSERT INTO `t_elective` VALUES (245, 39, 2, NULL);
INSERT INTO `t_elective` VALUES (246, 40, 3, NULL);
INSERT INTO `t_elective` VALUES (247, 41, 4, NULL);
INSERT INTO `t_elective` VALUES (248, 42, 2, NULL);
INSERT INTO `t_elective` VALUES (249, 43, 3, NULL);
INSERT INTO `t_elective` VALUES (250, 44, 4, NULL);
INSERT INTO `t_elective` VALUES (251, 45, 2, NULL);
INSERT INTO `t_elective` VALUES (252, 46, 3, NULL);
INSERT INTO `t_elective` VALUES (253, 47, 4, NULL);
INSERT INTO `t_elective` VALUES (254, 48, 2, NULL);
INSERT INTO `t_elective` VALUES (255, 49, 3, NULL);
INSERT INTO `t_elective` VALUES (256, 50, 4, NULL);
INSERT INTO `t_elective` VALUES (257, 51, 2, NULL);
INSERT INTO `t_elective` VALUES (258, 52, 3, NULL);
INSERT INTO `t_elective` VALUES (259, 53, 4, NULL);
INSERT INTO `t_elective` VALUES (260, 54, 2, NULL);
INSERT INTO `t_elective` VALUES (261, 55, 3, NULL);
INSERT INTO `t_elective` VALUES (262, 56, 4, NULL);
INSERT INTO `t_elective` VALUES (263, 57, 2, NULL);
INSERT INTO `t_elective` VALUES (264, 58, 3, NULL);
INSERT INTO `t_elective` VALUES (265, 59, 4, NULL);
INSERT INTO `t_elective` VALUES (266, 60, 2, NULL);
INSERT INTO `t_elective` VALUES (333, 1, 12, NULL);
INSERT INTO `t_elective` VALUES (334, 1, 13, NULL);
INSERT INTO `t_elective` VALUES (335, 1, 14, NULL);
INSERT INTO `t_elective` VALUES (336, 1, 7, NULL);
INSERT INTO `t_elective` VALUES (337, 1, 6, NULL);
INSERT INTO `t_elective` VALUES (338, 1, 1, NULL);
INSERT INTO `t_elective` VALUES (339, 1, 2, NULL);
INSERT INTO `t_elective` VALUES (340, 1, 15, NULL);
INSERT INTO `t_elective` VALUES (341, 1, 16, NULL);
INSERT INTO `t_elective` VALUES (342, 1, 3, NULL);
INSERT INTO `t_elective` VALUES (343, 1, 4, NULL);
INSERT INTO `t_elective` VALUES (344, 1, 5, NULL);
INSERT INTO `t_elective` VALUES (345, 1, 10, NULL);
INSERT INTO `t_elective` VALUES (346, 1, 11, NULL);
INSERT INTO `t_elective` VALUES (347, 1, 17, NULL);

-- ----------------------------
-- Table structure for t_faculty
-- ----------------------------
DROP TABLE IF EXISTS `t_faculty`;
CREATE TABLE `t_faculty`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '院系名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_faculty
-- ----------------------------
INSERT INTO `t_faculty` VALUES (1, '大数据与人工智能学院');
INSERT INTO `t_faculty` VALUES (2, '电子通信学院');

-- ----------------------------
-- Table structure for t_room
-- ----------------------------
DROP TABLE IF EXISTS `t_room`;
CREATE TABLE `t_room`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '房间id',
  `building` int(11) UNSIGNED NOT NULL COMMENT '所属楼id',
  `number` int(11) UNSIGNED NOT NULL COMMENT '房间号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间名称，可以不指定',
  `capacity` int(11) UNSIGNED NOT NULL COMMENT '容纳人数',
  `roomType` enum('bz','jt','sy','sx','wj','1') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'bz标准教室\r\njt阶梯教室\r\nsy实验室\r\nsx实训教室\r\nwj微机教室\r\nq其他',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UI_number_building`(`building`, `number`) USING BTREE,
  CONSTRAINT `FK_room_REF_building` FOREIGN KEY (`building`) REFERENCES `t_building` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_room
-- ----------------------------
INSERT INTO `t_room` VALUES (1, 1, 402, '计算机网络实训基地', 50, 'sx');
INSERT INTO `t_room` VALUES (2, 2, 308, '动漫设计', 0, 'bz');
INSERT INTO `t_room` VALUES (3, 1, 401, '计算机组装与维护', 0, 'bz');

-- ----------------------------
-- Table structure for t_specialized
-- ----------------------------
DROP TABLE IF EXISTS `t_specialized`;
CREATE TABLE `t_specialized`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `faculty` int(11) UNSIGNED NOT NULL COMMENT '所属院系',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业名称',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_specialized_REF_faculty`(`faculty`) USING BTREE,
  CONSTRAINT `FK_specialized_REF_faculty` FOREIGN KEY (`faculty`) REFERENCES `t_faculty` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_specialized
-- ----------------------------
INSERT INTO `t_specialized` VALUES (1, 1, '计算机应用技术');
INSERT INTO `t_specialized` VALUES (2, 2, '通信工程');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '学号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` bit(1) NOT NULL COMMENT '性别，1男，0女',
  `birth` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生日',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `clazz` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '所属班级',
  `specialized` int(11) UNSIGNED NOT NULL COMMENT '所属专业',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_student_REF_clazz`(`clazz`) USING BTREE,
  INDEX `FK_student_REF_specialized`(`specialized`) USING BTREE,
  CONSTRAINT `FK_student_REF_clazz` FOREIGN KEY (`clazz`) REFERENCES `t_clazz` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `FK_student_REF_specialized` FOREIGN KEY (`specialized`) REFERENCES `t_specialized` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (1, '是世昌', b'1', '2000-11-13', '1', 1, 1);
INSERT INTO `t_student` VALUES (2, '表梓晨', b'0', '2000-10-10', '1', 1, 1);
INSERT INTO `t_student` VALUES (3, '东门夏沫', b'0', '2001-12-22', '1', 1, 1);
INSERT INTO `t_student` VALUES (4, '候璟春', b'1', '2000-11-15', '1', 1, 1);
INSERT INTO `t_student` VALUES (5, '湛耘郗', b'0', '2000-12-23', '1', 1, 1);
INSERT INTO `t_student` VALUES (6, '班奕玮', b'1', '2000-11-13', '1', 1, 1);
INSERT INTO `t_student` VALUES (7, '夹谷东硕', b'0', '2000-10-10', '1', 1, 1);
INSERT INTO `t_student` VALUES (8, '常千', b'0', '2001-12-22', '1', 1, 1);
INSERT INTO `t_student` VALUES (9, '穆晓', b'1', '2000-11-15', '1', 1, 1);
INSERT INTO `t_student` VALUES (10, '项蓝月', b'0', '2000-12-23', '1', 1, 1);
INSERT INTO `t_student` VALUES (11, '孔树人', b'1', '2000-11-13', '1', 1, 1);
INSERT INTO `t_student` VALUES (12, '麴柯一', b'0', '2000-10-10', '1', 1, 1);
INSERT INTO `t_student` VALUES (13, '宁熙', b'0', '2001-12-22', '1', 1, 1);
INSERT INTO `t_student` VALUES (14, '城晟华', b'1', '2000-11-15', '1', 1, 1);
INSERT INTO `t_student` VALUES (15, '烟睿', b'0', '2000-12-23', '1', 1, 1);
INSERT INTO `t_student` VALUES (16, '相羽铮', b'1', '2000-11-13', '1', 1, 1);
INSERT INTO `t_student` VALUES (17, '廖雪', b'0', '2000-10-10', '1', 1, 1);
INSERT INTO `t_student` VALUES (18, '山亚捷', b'0', '2001-12-22', '1', 1, 1);
INSERT INTO `t_student` VALUES (19, '洛子轩', b'1', '2000-11-15', '1', 1, 1);
INSERT INTO `t_student` VALUES (20, '覃景川', b'1', '2000-11-13', '1', 1, 1);
INSERT INTO `t_student` VALUES (21, '翦羽', b'1', '2000-10-10', '1', 1, 1);
INSERT INTO `t_student` VALUES (22, '祖一然', b'0', '2001-12-22', '1', 1, 1);
INSERT INTO `t_student` VALUES (23, '丹树涵', b'1', '2000-11-15', '1', 1, 1);
INSERT INTO `t_student` VALUES (24, '叶爱丹', b'0', '2000-12-23', '1', 1, 1);
INSERT INTO `t_student` VALUES (25, '别浩毅', b'1', '2000-11-13', '1', 1, 1);
INSERT INTO `t_student` VALUES (26, '程小秋', b'0', '2000-10-10', '1', 1, 1);
INSERT INTO `t_student` VALUES (27, '尉迟恒宇', b'0', '2001-12-22', '1', 1, 1);
INSERT INTO `t_student` VALUES (28, '顾圣贤', b'1', '2000-11-15', '1', 1, 1);
INSERT INTO `t_student` VALUES (29, '蓝树源', b'1', '2000-11-13', '1', 1, 1);
INSERT INTO `t_student` VALUES (30, '居涵舒', b'0', '2000-10-10', '1', 1, 1);
INSERT INTO `t_student` VALUES (31, '苗熙苒', b'0', '2001-12-22', '1', 2, 2);
INSERT INTO `t_student` VALUES (32, '佛千', b'1', '2000-11-15', '1', 2, 2);
INSERT INTO `t_student` VALUES (33, '房玉惠', b'0', '2000-12-23', '1', 2, 2);
INSERT INTO `t_student` VALUES (34, '刑明哲', b'1', '2000-11-13', '1', 2, 2);
INSERT INTO `t_student` VALUES (35, '娄柯汝', b'0', '2000-10-10', '1', 2, 2);
INSERT INTO `t_student` VALUES (36, '真林莹', b'0', '2001-12-22', '1', 2, 2);
INSERT INTO `t_student` VALUES (37, '司空洪滨', b'1', '2000-11-15', '1', 2, 2);
INSERT INTO `t_student` VALUES (38, '巢楠', b'1', '2000-11-13', '1', 2, 2);
INSERT INTO `t_student` VALUES (39, '祢东慧', b'0', '2000-10-10', '1', 2, 2);
INSERT INTO `t_student` VALUES (40, '费梓童', b'0', '2001-12-22', '1', 2, 2);
INSERT INTO `t_student` VALUES (41, '东文博', b'1', '2000-11-15', '1', 2, 2);
INSERT INTO `t_student` VALUES (42, '松誉馨', b'0', '2000-12-23', '1', 2, 2);
INSERT INTO `t_student` VALUES (43, '甄一诺', b'1', '2000-11-13', '1', 2, 2);
INSERT INTO `t_student` VALUES (44, '慕馨阳', b'0', '2000-10-10', '1', 2, 2);
INSERT INTO `t_student` VALUES (45, '曲筱萌', b'0', '2001-12-22', '1', 2, 2);
INSERT INTO `t_student` VALUES (46, '阴宇硕', b'1', '2000-11-15', '1', 2, 2);
INSERT INTO `t_student` VALUES (47, '丁睿', b'1', '2000-11-13', '1', 2, 2);
INSERT INTO `t_student` VALUES (48, '诺阳阳', b'0', '2000-10-10', '1', 2, 2);
INSERT INTO `t_student` VALUES (49, '势羽墨', b'0', '2001-12-22', '1', 2, 2);
INSERT INTO `t_student` VALUES (50, '零珞', b'1', '2000-11-15', '1', 2, 2);
INSERT INTO `t_student` VALUES (51, '养恩贝', b'0', '2000-12-23', '1', 2, 2);
INSERT INTO `t_student` VALUES (52, '茂阳', b'1', '2000-11-13', '1', 2, 2);
INSERT INTO `t_student` VALUES (53, '傅慧青', b'0', '2000-10-10', '1', 2, 2);
INSERT INTO `t_student` VALUES (54, '阙篷璐', b'0', '2001-12-22', '1', 2, 2);
INSERT INTO `t_student` VALUES (55, '紫爱豪', b'1', '2000-11-15', '1', 2, 2);
INSERT INTO `t_student` VALUES (56, '钊轩', b'1', '2000-11-13', '1', 2, 2);
INSERT INTO `t_student` VALUES (57, '师钰岩', b'0', '2000-10-10', '1', 2, 2);
INSERT INTO `t_student` VALUES (58, '业冰杰', b'0', '2001-12-22', '1', 2, 2);
INSERT INTO `t_student` VALUES (59, '雪旭', b'1', '2000-11-15', '1', 2, 2);
INSERT INTO `t_student` VALUES (60, '逮淑怡', b'0', '2000-12-23', '1', 2, 2);

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` bit(1) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `faculty` int(11) UNSIGNED NOT NULL COMMENT '所属院系',
  `profes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职称',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_teacher_REF_faculty`(`faculty`) USING BTREE,
  CONSTRAINT `FK_teacher_REF_faculty` FOREIGN KEY (`faculty`) REFERENCES `t_faculty` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES (1, '老师1', b'0', '1', 1, '教授');
INSERT INTO `t_teacher` VALUES (2, '老师2', b'1', '1', 2, '老师');
INSERT INTO `t_teacher` VALUES (3, '老师3', b'0', '1', 1, '教授');
INSERT INTO `t_teacher` VALUES (4, 'ls4', b'1', '1', 2, '老师');
INSERT INTO `t_teacher` VALUES (5, 'ls5', b'0', '1', 1, '教授');
INSERT INTO `t_teacher` VALUES (6, 'ls6', b'1', '1', 2, '老师');
INSERT INTO `t_teacher` VALUES (7, 'ls7', b'0', '1', 1, '教授');
INSERT INTO `t_teacher` VALUES (8, 'ls8', b'1', '1', 2, '老师');

-- ----------------------------
-- Table structure for t_year
-- ----------------------------
DROP TABLE IF EXISTS `t_year`;
CREATE TABLE `t_year`  (
  `year` int(4) UNSIGNED NOT NULL COMMENT '年度，如2019',
  `name` char(9) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '如2019-2020',
  PRIMARY KEY (`year`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_year
-- ----------------------------
INSERT INTO `t_year` VALUES (2012, '2012-2013');
INSERT INTO `t_year` VALUES (2013, '2013-2014');
INSERT INTO `t_year` VALUES (2014, '2014-2015');
INSERT INTO `t_year` VALUES (2015, '2015-2016');
INSERT INTO `t_year` VALUES (2016, '2016-2017');
INSERT INTO `t_year` VALUES (2017, '2017-2018');
INSERT INTO `t_year` VALUES (2018, '2018-2019');
INSERT INTO `t_year` VALUES (2019, '2019-2020');
INSERT INTO `t_year` VALUES (2020, '2020-2021');
INSERT INTO `t_year` VALUES (2021, '2021-2022');
INSERT INTO `t_year` VALUES (2022, '2022-2023');
INSERT INTO `t_year` VALUES (2023, '2023-2024');

SET FOREIGN_KEY_CHECKS = 1;
