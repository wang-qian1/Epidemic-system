/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : project

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2021-03-24 15:08:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base
-- ----------------------------
DROP TABLE IF EXISTS `base`;
CREATE TABLE `base` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idCard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `age` int DEFAULT NULL,
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` bigint DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idCard` (`idCard`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for cities_daily
-- ----------------------------
DROP TABLE IF EXISTS `cities_daily`;
CREATE TABLE `cities_daily` (
  `provinceName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `cityName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `confirmedCount` int DEFAULT NULL COMMENT '累计确诊',
  `curedCount` int DEFAULT NULL COMMENT '治愈',
  `deadCount` int DEFAULT NULL COMMENT '死亡',
  `currentConfirmedCount` int DEFAULT NULL COMMENT '现存确诊',
  `suspectedCount` int DEFAULT NULL COMMENT '输入确诊'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for daily
-- ----------------------------
DROP TABLE IF EXISTS `daily`;
CREATE TABLE `daily` (
  `dateId` int NOT NULL,
  `countryName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `countryCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `confirmedCount` int DEFAULT NULL COMMENT '累计确诊',
  `curedCount` int DEFAULT NULL COMMENT '治愈',
  `deadCount` int DEFAULT NULL COMMENT '死亡',
  `seriousCount` int DEFAULT NULL COMMENT '无症状',
  `currentConfirmedCount` int DEFAULT NULL COMMENT '现存确诊',
  `suspectedCount` int DEFAULT NULL COMMENT '输入确诊',
  `currentConfirmedIncr` int DEFAULT NULL COMMENT '现存确诊较上日新增',
  `curedIncr` int DEFAULT NULL COMMENT '较上日治愈数',
  `confirmedIncr` int DEFAULT NULL COMMENT '新增确诊',
  `suspectedIncr` int DEFAULT NULL COMMENT '输入确诊较上日新增数',
  `deadIncr` int DEFAULT NULL COMMENT '新增死亡数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for goodsguides
-- ----------------------------
DROP TABLE IF EXISTS `goodsguides`;
CREATE TABLE `goodsguides` (
  `contentImgUrls` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `recordStatus` int DEFAULT NULL,
  `categoryName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `dateId` varchar(8) NOT NULL,
  `username` varchar(255) NOT NULL,
  `temperature1` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `temperature2` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `state` int DEFAULT NULL,
  `temperature` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `healthCode` int DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for provinces_daily
-- ----------------------------
DROP TABLE IF EXISTS `provinces_daily`;
CREATE TABLE `provinces_daily` (
  `dateId` int DEFAULT NULL,
  `provinceCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `provinceName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `confirmedCount` int DEFAULT NULL COMMENT '累计确诊',
  `curedCount` int DEFAULT NULL COMMENT '治愈',
  `deadCount` int DEFAULT NULL COMMENT '死亡',
  `seriousCount` int DEFAULT NULL COMMENT '无症状',
  `currentConfirmedCount` int DEFAULT NULL COMMENT '现存确诊',
  `suspectedCount` int DEFAULT NULL COMMENT '输入确诊',
  `currentConfirmedIncr` int DEFAULT NULL COMMENT '现存确诊较上日新增',
  `curedIncr` int DEFAULT NULL COMMENT '较上日治愈数',
  `confirmedIncr` int DEFAULT NULL COMMENT '新增确诊',
  `suspectedIncr` int DEFAULT NULL COMMENT '输入确诊较上日新增数',
  `deadIncr` int DEFAULT NULL COMMENT '新增死亡数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for recommends
-- ----------------------------
DROP TABLE IF EXISTS `recommends`;
CREATE TABLE `recommends` (
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `recordStatus` int DEFAULT NULL,
  `linkUrl` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `imgUrl` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `contentType` int DEFAULT NULL,
  `countryType` int DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for remarks
-- ----------------------------
DROP TABLE IF EXISTS `remarks`;
CREATE TABLE `remarks` (
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for rumors
-- ----------------------------
DROP TABLE IF EXISTS `rumors`;
CREATE TABLE `rumors` (
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `body` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `mainSummary` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `score` int DEFAULT NULL,
  `summary` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `rumorType` int DEFAULT NULL,
  `sourceUrl` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for statistics
-- ----------------------------
DROP TABLE IF EXISTS `statistics`;
CREATE TABLE `statistics` (
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `confirmedCount` int DEFAULT NULL COMMENT '累计确诊',
  `curedCount` int DEFAULT NULL COMMENT '治愈',
  `deadCount` int DEFAULT NULL COMMENT '死亡',
  `seriousCount` int DEFAULT NULL COMMENT '无症状',
  `currentConfirmedCount` int DEFAULT NULL COMMENT '现存确诊',
  `suspectedCount` int DEFAULT NULL COMMENT '输入确诊',
  `currentConfirmedIncr` int DEFAULT NULL COMMENT '现存确诊较上日新增',
  `curedIncr` int DEFAULT NULL COMMENT '较上日治愈数',
  `confirmedIncr` int DEFAULT NULL COMMENT '新增确诊',
  `suspectedIncr` int DEFAULT NULL COMMENT '输入确诊较上日新增数',
  `deadIncr` int DEFAULT NULL COMMENT '新增死亡数',
  `positionCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for timelines
-- ----------------------------
DROP TABLE IF EXISTS `timelines`;
CREATE TABLE `timelines` (
  `sourceUrl` varchar(255) DEFAULT NULL,
  `summary` varchar(56) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `infoSource` varchar(255) DEFAULT NULL,
  `pubDateStr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` int DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
