/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MariaDB
 Source Server Version : 100412
 Source Host           : localhost:8000
 Source Schema         : dentist_data

 Target Server Type    : MariaDB
 Target Server Version : 100412
 File Encoding         : 65001

 Date: 17/05/2020 18:12:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for doktor
-- ----------------------------
DROP TABLE IF EXISTS `doktor`;
CREATE TABLE `doktor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adi` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  `soyadi` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  `ihtisas` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  `telefon` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doktor
-- ----------------------------
INSERT INTO `doktor` VALUES (2, 'Tolga', 'Demiralp', 'Prof', '1111111111');
INSERT INTO `doktor` VALUES (3, 'Soner', 'Çevik', 'Prof', '5342964881');
INSERT INTO `doktor` VALUES (7, 'Cengiz', 'Çevikkk', 'Opr', '123456789');
INSERT INTO `doktor` VALUES (12, 'sfsdfsd', 'sdfsdf', 'sdsdfsdf', '111111111');

-- ----------------------------
-- Table structure for doktor_hasta
-- ----------------------------
DROP TABLE IF EXISTS `doktor_hasta`;
CREATE TABLE `doktor_hasta`  (
  `doktor_id` int(11) NOT NULL,
  `hasta_id` int(11) NOT NULL,
  PRIMARY KEY (`doktor_id`, `hasta_id`) USING BTREE,
  INDEX `hasta_id`(`hasta_id`) USING BTREE,
  CONSTRAINT `doktor_hasta_ibfk_1` FOREIGN KEY (`doktor_id`) REFERENCES `doktor` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `doktor_hasta_ibfk_2` FOREIGN KEY (`hasta_id`) REFERENCES `hasta` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doktor_hasta
-- ----------------------------

-- ----------------------------
-- Table structure for envanter
-- ----------------------------
DROP TABLE IF EXISTS `envanter`;
CREATE TABLE `envanter`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aciklama` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `adet` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of envanter
-- ----------------------------
INSERT INTO `envanter` VALUES (2, 'Neşter', 100);

-- ----------------------------
-- Table structure for hasta
-- ----------------------------
DROP TABLE IF EXISTS `hasta`;
CREATE TABLE `hasta`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adi` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  `soyadi` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  `telefon` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  `tckimlikno` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hasta
-- ----------------------------
INSERT INTO `hasta` VALUES (2, 'Tolga', 'Demiralp', '234234234', '1231231231');
INSERT INTO `hasta` VALUES (3, 'Recep', 'Çevik', '38972374', '12313123');

-- ----------------------------
-- Table structure for muayene
-- ----------------------------
DROP TABLE IF EXISTS `muayene`;
CREATE TABLE `muayene`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `doktor_id` int(11) NOT NULL,
  `hasta_id` int(11) NOT NULL,
  `randevu_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `doktor_id`(`doktor_id`) USING BTREE,
  INDEX `hasta_id`(`hasta_id`) USING BTREE,
  CONSTRAINT `muayene_ibfk_1` FOREIGN KEY (`doktor_id`) REFERENCES `doktor` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `muayene_ibfk_2` FOREIGN KEY (`hasta_id`) REFERENCES `hasta` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of muayene
-- ----------------------------

-- ----------------------------
-- Table structure for muayene_envanter
-- ----------------------------
DROP TABLE IF EXISTS `muayene_envanter`;
CREATE TABLE `muayene_envanter`  (
  `muayene_id` int(11) NOT NULL,
  `envanter_id` int(11) NOT NULL,
  PRIMARY KEY (`muayene_id`, `envanter_id`) USING BTREE,
  INDEX `envanter_id`(`envanter_id`) USING BTREE,
  CONSTRAINT `muayene_envanter_ibfk_1` FOREIGN KEY (`muayene_id`) REFERENCES `muayene` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `muayene_envanter_ibfk_2` FOREIGN KEY (`envanter_id`) REFERENCES `envanter` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of muayene_envanter
-- ----------------------------

-- ----------------------------
-- Table structure for muayene_tedavi
-- ----------------------------
DROP TABLE IF EXISTS `muayene_tedavi`;
CREATE TABLE `muayene_tedavi`  (
  `muayene_id` int(11) NOT NULL,
  `tedavi_id` int(11) NOT NULL,
  PRIMARY KEY (`muayene_id`, `tedavi_id`) USING BTREE,
  INDEX `tedavi_id`(`tedavi_id`) USING BTREE,
  CONSTRAINT `muayene_tedavi_ibfk_1` FOREIGN KEY (`muayene_id`) REFERENCES `muayene` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `muayene_tedavi_ibfk_2` FOREIGN KEY (`tedavi_id`) REFERENCES `tedavi` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of muayene_tedavi
-- ----------------------------

-- ----------------------------
-- Table structure for randevu
-- ----------------------------
DROP TABLE IF EXISTS `randevu`;
CREATE TABLE `randevu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `doktor_id` int(11) NOT NULL,
  `hasta_id` int(11) NOT NULL,
  `tarih_saat` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `doktor_id`(`doktor_id`) USING BTREE,
  INDEX `hasta_id`(`hasta_id`) USING BTREE,
  CONSTRAINT `randevu_ibfk_1` FOREIGN KEY (`doktor_id`) REFERENCES `doktor` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `randevu_ibfk_2` FOREIGN KEY (`hasta_id`) REFERENCES `hasta` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of randevu
-- ----------------------------

-- ----------------------------
-- Table structure for tedavi
-- ----------------------------
DROP TABLE IF EXISTS `tedavi`;
CREATE TABLE `tedavi`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aciklama` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tedavi
-- ----------------------------
INSERT INTO `tedavi` VALUES (1, 'Dolgu');
INSERT INTO `tedavi` VALUES (3, 'Diş Çekimi');
INSERT INTO `tedavi` VALUES (4, 'Kanal Tedavi');

SET FOREIGN_KEY_CHECKS = 1;
