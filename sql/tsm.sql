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

 Date: 19/06/2021 23:52:11
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
  `number` int(10) UNSIGNED NOT NULL COMMENT '楼号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '楼名称',
  `buildingType` enum('pedagogical','experimental','other') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '楼类型， pedagogical教学楼，experimental实验楼,other其他',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_building
-- ----------------------------
INSERT INTO `t_building` VALUES (1, 13, '大数据与人工智能学院', 'pedagogical');
INSERT INTO `t_building` VALUES (2, 11, '艺术学院', 'pedagogical');
INSERT INTO `t_building` VALUES (3, 12, '财会与金融学院', 'pedagogical');
INSERT INTO `t_building` VALUES (5, 14, '电子工程学院', 'pedagogical');
INSERT INTO `t_building` VALUES (6, 1, '土木与环境工程学院-A', 'pedagogical');
INSERT INTO `t_building` VALUES (7, 2, '土木与环境工程学院-B', 'pedagogical');
INSERT INTO `t_building` VALUES (8, 7, '国际教育学院', 'pedagogical');
INSERT INTO `t_building` VALUES (9, 7, '文化与新闻传播学院', 'pedagogical');

-- ----------------------------
-- Table structure for t_clazz
-- ----------------------------
DROP TABLE IF EXISTS `t_clazz`;
CREATE TABLE `t_clazz`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `specialized` int(11) UNSIGNED NOT NULL COMMENT '所属院系',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_clazz_REF_specialized`(`specialized`) USING BTREE,
  CONSTRAINT `FK_clazz_REF_specialized` FOREIGN KEY (`specialized`) REFERENCES `t_specialized` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_clazz
-- ----------------------------
INSERT INTO `t_clazz` VALUES (1, 1, '19计应1班');
INSERT INTO `t_clazz` VALUES (2, 2, '19通信2班');
INSERT INTO `t_clazz` VALUES (3, 2, '测试');
INSERT INTO `t_clazz` VALUES (4, 2, '测试');
INSERT INTO `t_clazz` VALUES (5, 2, '测试');
INSERT INTO `t_clazz` VALUES (6, 1, 'test');
INSERT INTO `t_clazz` VALUES (7, 1, 'test');
INSERT INTO `t_clazz` VALUES (8, 1, 'test');
INSERT INTO `t_clazz` VALUES (9, 1, 'test');
INSERT INTO `t_clazz` VALUES (10, 1, 'test');

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
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_course_REF_clazz`(`clazz`) USING BTREE,
  INDEX `FK_course_REF_teacher`(`teacher`) USING BTREE,
  CONSTRAINT `FK_course_REF_clazz` FOREIGN KEY (`clazz`) REFERENCES `t_clazz` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_course_REF_teacher` FOREIGN KEY (`teacher`) REFERENCES `t_teacher` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES (1, 'Java', '4', 2, 1);
INSERT INTO `t_course` VALUES (2, '数据库', '2', 2, 2);
INSERT INTO `t_course` VALUES (3, '微机原理', '2', 2, 2);
INSERT INTO `t_course` VALUES (4, '现代通信技术', '2', 2, 2);
INSERT INTO `t_course` VALUES (13, 'HTML', '1', 1, 3);
INSERT INTO `t_course` VALUES (25, 'AAA', '2', 1, 1);
INSERT INTO `t_course` VALUES (33, '1', '1', 1, 3);
INSERT INTO `t_course` VALUES (34, '1', '1', 1, 3);
INSERT INTO `t_course` VALUES (35, 'XX', '2', 1, 1);

-- ----------------------------
-- Table structure for t_course_info
-- ----------------------------
DROP TABLE IF EXISTS `t_course_info`;
CREATE TABLE `t_course_info`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `course` int(11) UNSIGNED NOT NULL COMMENT 'course ID',
  `courseType` enum('theory','practice') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程类型 \'theory\',\'practice\' 理论课 实验课',
  `weekType` enum('sgl','dbl','all') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '周次 \'sgl\',\'dbl\',\'all\' 单周 双周 不限',
  `startWeek` tinyint(4) UNSIGNED NOT NULL COMMENT '起始周',
  `endWeek` tinyint(4) UNSIGNED NOT NULL COMMENT '结束周',
  `weekDay` enum('Monday','Tuesday','Wednesday','Thursday','Friday','Saturday','Sunday') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '星期',
  `begin` tinyint(4) UNSIGNED NOT NULL COMMENT '起始节',
  `length` tinyint(4) UNSIGNED NOT NULL COMMENT '持续节',
  `address` int(11) UNSIGNED NOT NULL COMMENT '上课地点',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_course_info_REF_course`(`course`) USING BTREE,
  INDEX `FK_course_info_REF_room`(`address`) USING BTREE,
  CONSTRAINT `FK_course_info_REF_course` FOREIGN KEY (`course`) REFERENCES `t_course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_course_info_REF_room` FOREIGN KEY (`address`) REFERENCES `t_room` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_course_info
-- ----------------------------
INSERT INTO `t_course_info` VALUES (1, 25, 'theory', 'sgl', 1, 1, 'Saturday', 1, 1, 1);
INSERT INTO `t_course_info` VALUES (2, 25, 'theory', 'all', 1, 1, 'Saturday', 1, 1, 1);
INSERT INTO `t_course_info` VALUES (7, 34, 'theory', 'sgl', 1, 1, 'Saturday', 1, 1, 1);
INSERT INTO `t_course_info` VALUES (8, 34, 'theory', 'all', 1, 1, 'Saturday', 1, 1, 1);
INSERT INTO `t_course_info` VALUES (9, 33, 'theory', 'sgl', 1, 1, 'Saturday', 1, 1, 1);
INSERT INTO `t_course_info` VALUES (10, 35, 'theory', 'sgl', 1, 1, 'Friday', 1, 1, 1);

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
  INDEX `FK_elective_REF_course`(`course`) USING BTREE,
  UNIQUE INDEX `UI_student_course`(`student`, `course`) USING BTREE,
  CONSTRAINT `FK_elective_REF_course` FOREIGN KEY (`course`) REFERENCES `t_course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_elective_REF_student` FOREIGN KEY (`student`) REFERENCES `t_student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_elective
-- ----------------------------
INSERT INTO `t_elective` VALUES (1, 1, 1, NULL);
INSERT INTO `t_elective` VALUES (2, 2, 1, NULL);
INSERT INTO `t_elective` VALUES (3, 3, 2, 2);
INSERT INTO `t_elective` VALUES (4, 4, 2, NULL);
INSERT INTO `t_elective` VALUES (5, 5, 2, NULL);
INSERT INTO `t_elective` VALUES (6, 4, 3, NULL);
INSERT INTO `t_elective` VALUES (7, 5, 3, NULL);
INSERT INTO `t_elective` VALUES (8, 3, 4, 88);
INSERT INTO `t_elective` VALUES (9, 4, 4, NULL);
INSERT INTO `t_elective` VALUES (10, 5, 4, NULL);
INSERT INTO `t_elective` VALUES (11, 6, 4, NULL);
INSERT INTO `t_elective` VALUES (12, 7, 4, NULL);
INSERT INTO `t_elective` VALUES (13, 8, 4, NULL);
INSERT INTO `t_elective` VALUES (14, 9, 4, NULL);
INSERT INTO `t_elective` VALUES (15, 10, 4, NULL);
INSERT INTO `t_elective` VALUES (16, 11, 4, NULL);
INSERT INTO `t_elective` VALUES (17, 12, 4, NULL);
INSERT INTO `t_elective` VALUES (18, 13, 4, NULL);
INSERT INTO `t_elective` VALUES (19, 14, 4, NULL);
INSERT INTO `t_elective` VALUES (20, 15, 4, NULL);
INSERT INTO `t_elective` VALUES (21, 16, 4, NULL);
INSERT INTO `t_elective` VALUES (22, 17, 4, NULL);
INSERT INTO `t_elective` VALUES (23, 18, 4, NULL);
INSERT INTO `t_elective` VALUES (24, 19, 4, NULL);
INSERT INTO `t_elective` VALUES (25, 20, 4, NULL);
INSERT INTO `t_elective` VALUES (26, 21, 4, NULL);
INSERT INTO `t_elective` VALUES (27, 22, 4, NULL);
INSERT INTO `t_elective` VALUES (28, 23, 4, NULL);
INSERT INTO `t_elective` VALUES (29, 24, 4, NULL);
INSERT INTO `t_elective` VALUES (30, 25, 4, NULL);
INSERT INTO `t_elective` VALUES (31, 26, 4, NULL);
INSERT INTO `t_elective` VALUES (32, 27, 4, NULL);
INSERT INTO `t_elective` VALUES (33, 28, 4, NULL);
INSERT INTO `t_elective` VALUES (34, 29, 4, NULL);
INSERT INTO `t_elective` VALUES (35, 30, 4, NULL);
INSERT INTO `t_elective` VALUES (36, 31, 4, NULL);
INSERT INTO `t_elective` VALUES (37, 32, 4, NULL);
INSERT INTO `t_elective` VALUES (38, 33, 4, NULL);
INSERT INTO `t_elective` VALUES (39, 34, 4, NULL);
INSERT INTO `t_elective` VALUES (40, 35, 4, NULL);
INSERT INTO `t_elective` VALUES (41, 36, 4, NULL);
INSERT INTO `t_elective` VALUES (42, 37, 4, NULL);
INSERT INTO `t_elective` VALUES (43, 38, 4, NULL);
INSERT INTO `t_elective` VALUES (44, 39, 4, NULL);
INSERT INTO `t_elective` VALUES (45, 40, 4, NULL);
INSERT INTO `t_elective` VALUES (46, 41, 4, NULL);
INSERT INTO `t_elective` VALUES (47, 42, 4, NULL);
INSERT INTO `t_elective` VALUES (48, 43, 4, NULL);
INSERT INTO `t_elective` VALUES (49, 44, 4, NULL);
INSERT INTO `t_elective` VALUES (50, 45, 4, NULL);
INSERT INTO `t_elective` VALUES (51, 46, 4, NULL);
INSERT INTO `t_elective` VALUES (52, 47, 4, NULL);
INSERT INTO `t_elective` VALUES (53, 48, 4, NULL);
INSERT INTO `t_elective` VALUES (54, 49, 4, NULL);
INSERT INTO `t_elective` VALUES (55, 50, 4, NULL);
INSERT INTO `t_elective` VALUES (56, 51, 4, NULL);
INSERT INTO `t_elective` VALUES (57, 52, 4, NULL);
INSERT INTO `t_elective` VALUES (58, 53, 4, NULL);
INSERT INTO `t_elective` VALUES (59, 54, 4, NULL);
INSERT INTO `t_elective` VALUES (60, 55, 4, NULL);
INSERT INTO `t_elective` VALUES (61, 56, 4, NULL);
INSERT INTO `t_elective` VALUES (62, 57, 4, NULL);
INSERT INTO `t_elective` VALUES (63, 58, 4, NULL);
INSERT INTO `t_elective` VALUES (64, 59, 4, NULL);
INSERT INTO `t_elective` VALUES (65, 60, 4, NULL);
INSERT INTO `t_elective` VALUES (66, 61, 4, NULL);
INSERT INTO `t_elective` VALUES (67, 62, 4, NULL);
INSERT INTO `t_elective` VALUES (68, 63, 4, NULL);
INSERT INTO `t_elective` VALUES (69, 64, 4, NULL);

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
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UI_number_building`(`building`, `number`) USING BTREE,
  CONSTRAINT `FK_room_REF_building` FOREIGN KEY (`building`) REFERENCES `t_building` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_room
-- ----------------------------
INSERT INTO `t_room` VALUES (1, 1, 401, '计算机应用技术实验基地');
INSERT INTO `t_room` VALUES (2, 1, 402, '计算机网络实训基地');
INSERT INTO `t_room` VALUES (3, 2, 308, '动漫设计');

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
  `clazz` int(11) UNSIGNED NOT NULL COMMENT '所属班级',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_student_REF_clazz`(`clazz`) USING BTREE,
  CONSTRAINT `FK_student_REF_clazz` FOREIGN KEY (`clazz`) REFERENCES `t_clazz` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (1, '是世昌', b'1', '2000-11-13', '1', 1);
INSERT INTO `t_student` VALUES (2, '表梓晨', b'0', '2000-10-10', '1', 1);
INSERT INTO `t_student` VALUES (3, '东门夏沫', b'0', '2001-12-22', '1', 2);
INSERT INTO `t_student` VALUES (4, '候璟春', b'1', '2000-11-15', '1', 2);
INSERT INTO `t_student` VALUES (5, '湛耘郗', b'0', '2000-12-23', '1', 2);
INSERT INTO `t_student` VALUES (6, '班奕玮', b'1', '2000-11-13', '1', 1);
INSERT INTO `t_student` VALUES (7, '夹谷东硕', b'0', '2000-10-10', '1', 1);
INSERT INTO `t_student` VALUES (8, '常千', b'0', '2001-12-22', '1', 2);
INSERT INTO `t_student` VALUES (9, '穆晓', b'1', '2000-11-15', '1', 2);
INSERT INTO `t_student` VALUES (10, '项蓝月', b'0', '2000-12-23', '1', 2);
INSERT INTO `t_student` VALUES (11, '孔树人', b'1', '2000-11-13', '1', 1);
INSERT INTO `t_student` VALUES (12, '麴柯一', b'0', '2000-10-10', '1', 1);
INSERT INTO `t_student` VALUES (13, '宁熙', b'0', '2001-12-22', '1', 2);
INSERT INTO `t_student` VALUES (14, '城晟华', b'1', '2000-11-15', '1', 2);
INSERT INTO `t_student` VALUES (15, '烟睿', b'0', '2000-12-23', '1', 2);
INSERT INTO `t_student` VALUES (16, '相羽铮', b'1', '2000-11-13', '1', 1);
INSERT INTO `t_student` VALUES (17, '廖雪', b'0', '2000-10-10', '1', 1);
INSERT INTO `t_student` VALUES (18, '山亚捷', b'0', '2001-12-22', '1', 2);
INSERT INTO `t_student` VALUES (19, '洛子轩', b'1', '2000-11-15', '1', 2);
INSERT INTO `t_student` VALUES (20, '覃景川', b'1', '2000-11-13', '1', 1);
INSERT INTO `t_student` VALUES (21, '翦羽', b'1', '2000-10-10', '1', 1);
INSERT INTO `t_student` VALUES (22, '祖一然', b'0', '2001-12-22', '1', 2);
INSERT INTO `t_student` VALUES (23, '丹树涵', b'1', '2000-11-15', '1', 2);
INSERT INTO `t_student` VALUES (24, '叶爱丹', b'0', '2000-12-23', '1', 2);
INSERT INTO `t_student` VALUES (25, '别浩毅', b'1', '2000-11-13', '1', 1);
INSERT INTO `t_student` VALUES (26, '程小秋', b'0', '2000-10-10', '1', 1);
INSERT INTO `t_student` VALUES (27, '尉迟恒宇', b'0', '2001-12-22', '1', 2);
INSERT INTO `t_student` VALUES (28, '顾圣贤', b'1', '2000-11-15', '1', 2);
INSERT INTO `t_student` VALUES (29, '蓝树源', b'1', '2000-11-13', '1', 1);
INSERT INTO `t_student` VALUES (30, '居涵舒', b'0', '2000-10-10', '1', 1);
INSERT INTO `t_student` VALUES (31, '苗熙苒', b'0', '2001-12-22', '1', 2);
INSERT INTO `t_student` VALUES (32, '佛千', b'1', '2000-11-15', '1', 2);
INSERT INTO `t_student` VALUES (33, '房玉惠', b'0', '2000-12-23', '1', 2);
INSERT INTO `t_student` VALUES (34, '刑明哲', b'1', '2000-11-13', '1', 1);
INSERT INTO `t_student` VALUES (35, '娄柯汝', b'0', '2000-10-10', '1', 1);
INSERT INTO `t_student` VALUES (36, '真林莹', b'0', '2001-12-22', '1', 2);
INSERT INTO `t_student` VALUES (37, '司空洪滨', b'1', '2000-11-15', '1', 2);
INSERT INTO `t_student` VALUES (38, '巢楠', b'1', '2000-11-13', '1', 1);
INSERT INTO `t_student` VALUES (39, '祢东慧', b'0', '2000-10-10', '1', 1);
INSERT INTO `t_student` VALUES (40, '费梓童', b'0', '2001-12-22', '1', 2);
INSERT INTO `t_student` VALUES (41, '东文博', b'1', '2000-11-15', '1', 2);
INSERT INTO `t_student` VALUES (42, '松誉馨', b'0', '2000-12-23', '1', 2);
INSERT INTO `t_student` VALUES (43, '甄一诺', b'1', '2000-11-13', '1', 1);
INSERT INTO `t_student` VALUES (44, '慕馨阳', b'0', '2000-10-10', '1', 1);
INSERT INTO `t_student` VALUES (45, '曲筱萌', b'0', '2001-12-22', '1', 2);
INSERT INTO `t_student` VALUES (46, '阴宇硕', b'1', '2000-11-15', '1', 2);
INSERT INTO `t_student` VALUES (47, '丁睿', b'1', '2000-11-13', '1', 1);
INSERT INTO `t_student` VALUES (48, '诺阳阳', b'0', '2000-10-10', '1', 1);
INSERT INTO `t_student` VALUES (49, '势羽墨', b'0', '2001-12-22', '1', 2);
INSERT INTO `t_student` VALUES (50, '零珞', b'1', '2000-11-15', '1', 2);
INSERT INTO `t_student` VALUES (51, '养恩贝', b'0', '2000-12-23', '1', 2);
INSERT INTO `t_student` VALUES (52, '茂阳', b'1', '2000-11-13', '1', 1);
INSERT INTO `t_student` VALUES (53, '傅慧青', b'0', '2000-10-10', '1', 1);
INSERT INTO `t_student` VALUES (54, '阙篷璐', b'0', '2001-12-22', '1', 2);
INSERT INTO `t_student` VALUES (55, '紫爱豪', b'1', '2000-11-15', '1', 2);
INSERT INTO `t_student` VALUES (56, '钊轩', b'1', '2000-11-13', '1', 1);
INSERT INTO `t_student` VALUES (57, '师钰岩', b'0', '2000-10-10', '1', 1);
INSERT INTO `t_student` VALUES (58, '业冰杰', b'0', '2001-12-22', '1', 2);
INSERT INTO `t_student` VALUES (59, '雪旭', b'1', '2000-11-15', '1', 2);
INSERT INTO `t_student` VALUES (60, '逮淑怡', b'0', '2000-12-23', '1', 2);
INSERT INTO `t_student` VALUES (61, '空子晨', b'1', '2000-11-13', '1', 1);
INSERT INTO `t_student` VALUES (62, '皇柯佳', b'0', '2000-10-10', '1', 1);
INSERT INTO `t_student` VALUES (63, '苏晴', b'0', '2001-12-22', '1', 2);
INSERT INTO `t_student` VALUES (64, '郜淇轩', b'1', '2000-11-15', '1', 2);
INSERT INTO `t_student` VALUES (65, '唐芳宁', b'0', '2000-12-23', '1', 2);

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

SET FOREIGN_KEY_CHECKS = 1;
