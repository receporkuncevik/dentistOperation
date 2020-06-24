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

 Date: 25/06/2020 01:19:30
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
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doktor
-- ----------------------------
INSERT INTO `doktor` VALUES (2, 'Tolga', 'Demiralp', 'Prof', '1111111111');
INSERT INTO `doktor` VALUES (3, 'Soner', 'Çevik', 'Prof', '5342964881');
INSERT INTO `doktor` VALUES (7, 'Cengiz', 'Çevikkk', 'Opr', '123456789');
INSERT INTO `doktor` VALUES (15, 'Müjdat', 'fghfgh', 'Ordinaryüs', '234234');

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
INSERT INTO `doktor_hasta` VALUES (2, 3);

-- ----------------------------
-- Table structure for envanter
-- ----------------------------
DROP TABLE IF EXISTS `envanter`;
CREATE TABLE `envanter`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aciklama` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `adet` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hasta
-- ----------------------------
INSERT INTO `hasta` VALUES (2, 'Tolga', 'Demiralp', '123123', '12313123');
INSERT INTO `hasta` VALUES (3, 'Recep', 'Çevik', '38972374', '12313123');
INSERT INTO `hasta` VALUES (4, 'Tolga', 'Demiralp', '234234234', '1231231231');
INSERT INTO `hasta` VALUES (5, 'Recep', 'Çevik', '38972374', '12313123');
INSERT INTO `hasta` VALUES (6, 'Tolga', 'Demiralp', '234234234', '1231231231');
INSERT INTO `hasta` VALUES (7, 'Recep', 'Çevik', '38972374', '12313123');
INSERT INTO `hasta` VALUES (8, 'Tolga', 'Demiralp', '234234234', '1231231231');
INSERT INTO `hasta` VALUES (9, 'Recep', 'Çevik', '38972374', '12313123');
INSERT INTO `hasta` VALUES (10, 'Tolga', 'Demiralp', '234234234', '1231231231');
INSERT INTO `hasta` VALUES (13, 'Recep', 'Çevik', '38972374', '12313123');
INSERT INTO `hasta` VALUES (14, 'Tolga', 'Demiralp', '234234234', '1231231231');
INSERT INTO `hasta` VALUES (15, 'Recep', 'Çevik', '38972374', '12313123');
INSERT INTO `hasta` VALUES (16, 'Tolga', 'Demiralp', '234234234', '1231231231');
INSERT INTO `hasta` VALUES (17, 'Recep', 'Çevik', '38972374', '12313123');
INSERT INTO `hasta` VALUES (18, 'Tolga', 'Demiralp', '234234234', '1231231231');
INSERT INTO `hasta` VALUES (19, 'Recep', 'Çevik', '38972374', '12313123');

-- ----------------------------
-- Table structure for kullanici
-- ----------------------------
DROP TABLE IF EXISTS `kullanici`;
CREATE TABLE `kullanici`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kullanici_adi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sifre` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kullanici
-- ----------------------------
INSERT INTO `kullanici` VALUES (2, 'admin', '123');
INSERT INTO `kullanici` VALUES (5, 'tolga', '123');

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
  INDEX `randevu_id`(`randevu_id`) USING BTREE,
  CONSTRAINT `muayene_ibfk_1` FOREIGN KEY (`doktor_id`) REFERENCES `doktor` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `muayene_ibfk_2` FOREIGN KEY (`hasta_id`) REFERENCES `hasta` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of muayene
-- ----------------------------
INSERT INTO `muayene` VALUES (8, 3, 3, 6);
INSERT INTO `muayene` VALUES (11, 7, 2, 6);
INSERT INTO `muayene` VALUES (12, 7, 2, 6);
INSERT INTO `muayene` VALUES (13, 7, 2, 6);
INSERT INTO `muayene` VALUES (14, 7, 2, 6);
INSERT INTO `muayene` VALUES (15, 7, 2, 6);
INSERT INTO `muayene` VALUES (22, 7, 2, 6);
INSERT INTO `muayene` VALUES (26, 3, 4, 5);

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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of randevu
-- ----------------------------
INSERT INTO `randevu` VALUES (3, 2, 3, '2020-06-18 22:26:33');
INSERT INTO `randevu` VALUES (5, 15, 3, '2020-06-19 22:39:42');

-- ----------------------------
-- Table structure for rontgen
-- ----------------------------
DROP TABLE IF EXISTS `rontgen`;
CREATE TABLE `rontgen`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hasta_id` int(11) NOT NULL,
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `file_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `file_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rontgen
-- ----------------------------
INSERT INTO `rontgen` VALUES (12, 3, 'oliver-sjostrom-epRVcpr6yf8-unsplash.jpg', 'image/jpeg', 'UsersRecepOrkunupload');
INSERT INTO `rontgen` VALUES (16, 2, 'ardisik_komutlar.pdf', 'application/pdf', 'UsersRecepOrkunupload');

-- ----------------------------
-- Table structure for tedavi
-- ----------------------------
DROP TABLE IF EXISTS `tedavi`;
CREATE TABLE `tedavi`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aciklama` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tedavi
-- ----------------------------
INSERT INTO `tedavi` VALUES (6, 'Dolgu');

-- ----------------------------
-- View structure for muayene_liste
-- ----------------------------
DROP VIEW IF EXISTS `muayene_liste`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `muayene_liste` AS SELECT
	m.*,
	CONCAT( d.adi, ' ', d.soyadi ) AS doktor,
	CONCAT( h.adi, ' ', h.soyadi ) AS hasta,
	r.tarih_saat as randevu_tarih_saat
FROM
	muayene AS m
	INNER JOIN doktor as d ON d.id = m.doktor_id
	INNER JOIN hasta h ON h.id = m.hasta_id 
	LEFT JOIN randevu r ON r.id = m.randevu_id ;

SET FOREIGN_KEY_CHECKS = 1;
