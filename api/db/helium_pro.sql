/*
 Navicat Premium Data Transfer

 Source Server         : 183.6.57.245
 Source Server Type    : MySQL
 Source Server Version : 50651
 Source Host           : 183.6.57.245:3356
 Source Schema         : helium_pro

 Target Server Type    : MySQL
 Target Server Version : 50651
 File Encoding         : 65001

 Date: 10/03/2022 19:28:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for business_anagement_machine
-- ----------------------------
DROP TABLE IF EXISTS `business_anagement_machine`;
CREATE TABLE `business_anagement_machine`  (
  `mm_id` bigint(20) NOT NULL COMMENT '编号',
  `mm_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `network_segment` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网段',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`mm_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理机' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of business_anagement_machine
-- ----------------------------

-- ----------------------------
-- Table structure for business_group
-- ----------------------------
DROP TABLE IF EXISTS `business_group`;
CREATE TABLE `business_group`  (
  `group_id` bigint(100) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `mm_id` int(11) NULL DEFAULT NULL COMMENT '管理机',
  `group_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  PRIMARY KEY (`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '分组管理' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of business_group
-- ----------------------------
INSERT INTO `business_group` VALUES (2, NULL, 'cdlz1', '', 1, '2022-03-08 16:04:07', 1);

-- ----------------------------
-- Table structure for business_hotspotty
-- ----------------------------
DROP TABLE IF EXISTS `business_hotspotty`;
CREATE TABLE `business_hotspotty`  (
  `hotspotty_id` bigint(100) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `private_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内网IP',
  `public_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公网IP',
  `brand` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '品牌',
  `room` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '房间',
  `online` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '设备状态',
  `country` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '国家',
  `city` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '城市',
  `street` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '街道',
  `Hex` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'Hex',
  `total24h` double(10, 4) NULL DEFAULT NULL COMMENT '24小时收益',
  `total1d` double(10, 4) NULL DEFAULT NULL COMMENT '7天收益',
  `total30d` double(10, 4) NULL DEFAULT NULL COMMENT '30天收益',
  `owner` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '钱包地址',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '设备地址',
  `remarks` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  PRIMARY KEY (`hotspotty_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '设备管理' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of business_hotspotty
-- ----------------------------
INSERT INTO `business_hotspotty` VALUES (1, 'magnificent-shadow-weasel', NULL, NULL, NULL, NULL, 'online', 'China', 'Taian', 'Feicheng', '88319bac01fffff', 0.8703, NULL, NULL, '14AhgRBQewe9CJwW6fQ9Dz1NEniUxP2bZem7wmPwsXobfDSHXob', '11MMnG9XhuEzqPwSW2JRXWsmxaqP8srv95MLwFZfy8EQwqjENy8', NULL, 1, '2022-03-08 21:48:44', '2022-03-10 19:00:07', 1);
INSERT INTO `business_hotspotty` VALUES (12, 'festive-golden-salmon', NULL, NULL, NULL, NULL, 'online', 'China', 'Taian', 'Feicheng', '88319bacc7fffff', 0.8176, NULL, NULL, '14AhgRBQewe9CJwW6fQ9Dz1NEniUxP2bZem7wmPwsXobfDSHXob', '1121zZ3g4NeaudpoHNXfnEbyG2cZksGNExWCqF3fg9Y7s8UkGiAc', NULL, NULL, '2022-03-09 02:30:00', '2022-03-10 19:00:15', 1);
INSERT INTO `business_hotspotty` VALUES (13, 'electric-raisin-swan', NULL, NULL, NULL, NULL, 'online', 'China', 'Dezhou', 'Decheng District', '88319d2a1bfffff', 0.6962, NULL, NULL, '14AhgRBQewe9CJwW6fQ9Dz1NEniUxP2bZem7wmPwsXobfDSHXob', '11yhGTP2JX2Nr812Wk8F9Sn5YEpfXG3SCK79VnhYDA1hmtvHWhv', NULL, NULL, '2022-03-09 02:30:01', '2022-03-10 19:00:18', 1);
INSERT INTO `business_hotspotty` VALUES (14, 'raspy-wooden-yak', NULL, NULL, NULL, NULL, 'online', 'China', 'Dezhou', 'Decheng District', '88319d2b69fffff', 0.8746, NULL, NULL, '14AhgRBQewe9CJwW6fQ9Dz1NEniUxP2bZem7wmPwsXobfDSHXob', '112MXj5qjhXnhdBjxPb1DUB8prbgvPaNJwQ6bqdKRJmHGR2vkKrY', NULL, NULL, '2022-03-09 02:30:02', '2022-03-10 19:00:21', 1);
INSERT INTO `business_hotspotty` VALUES (15, 'energetic-slate-duck', NULL, NULL, NULL, NULL, 'online', 'China', 'Dezhou', 'Decheng District', '88319d2913fffff', 0.8422, NULL, NULL, '14AhgRBQewe9CJwW6fQ9Dz1NEniUxP2bZem7wmPwsXobfDSHXob', '11B4hhvuj5y7LEnpa69xrxmV4kUUuTLKpyoMdHQHkhf6gfX1qiR', NULL, NULL, '2022-03-09 02:30:03', '2022-03-10 19:00:25', 1);

-- ----------------------------
-- Table structure for business_mode
-- ----------------------------
DROP TABLE IF EXISTS `business_mode`;
CREATE TABLE `business_mode`  (
  `group_id` bigint(100) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `group_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  PRIMARY KEY (`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '模板' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of business_mode
-- ----------------------------

-- ----------------------------
-- Table structure for business_wallet
-- ----------------------------
DROP TABLE IF EXISTS `business_wallet`;
CREATE TABLE `business_wallet`  (
  `wallet_id` bigint(100) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `group_id` int(10) NULL DEFAULT NULL COMMENT '分组',
  `owner` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '钱包地址',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  PRIMARY KEY (`wallet_id`) USING BTREE,
  UNIQUE INDEX `username`(`owner`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '钱包管理' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of business_wallet
-- ----------------------------
INSERT INTO `business_wallet` VALUES (1, 2, '14AhgRBQewe9CJwW6fQ9Dz1NEniUxP2bZem7wmPwsXobfDSHXob', '', 1, '2022-03-08 21:16:34', 1);

-- ----------------------------
-- Table structure for hotspotty_bak
-- ----------------------------
DROP TABLE IF EXISTS `hotspotty_bak`;
CREATE TABLE `hotspotty_bak`  (
  `hotspotty_id` bigint(100) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `owner` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '钱包地址',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '设备地址',
  `online` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '设备状态',
  `country` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '国家',
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '城市',
  `street` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '街道',
  `Hex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'Hex',
  `total24h` double(10, 4) NULL DEFAULT NULL COMMENT '24小时收益',
  `total1d` double(10, 4) NULL DEFAULT NULL COMMENT '7天收益',
  `total30d` double(10, 4) NULL DEFAULT NULL COMMENT '30天收益',
  `private_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内网IP',
  `public_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公网IP',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `brand` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '品牌',
  `management_machine` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '管理机',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `group_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分组',
  `room` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '房间',
  PRIMARY KEY (`hotspotty_id`) USING BTREE,
  UNIQUE INDEX `username`(`owner`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '设备管理备份' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hotspotty_bak
-- ----------------------------
INSERT INTO `hotspotty_bak` VALUES (1, NULL, '13cWKUT4FPQUh5WWihjz5Q2fYDgi6epbPn1GqvPAmjVbkL4RrrC', '112WsyGBHyPWgadjVZQMkCZgFP5XXAEWSNGgspmM7GVbdfF41ZEh', 'online', 'Poland', 'Goleam Izvor, Razgrad', '1', NULL, 1231.0000, NULL, NULL, NULL, NULL, 1, '2017-03-23 22:37:41', '2022-03-07 17:00:23', 1, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `BLOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `SCHED_NAME`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CRON_EXPRESSION` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TIME_ZONE_ID` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ENTRY_ID` varchar(95) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `ENTRY_ID`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TRIG_INST_NAME`(`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY`(`SCHED_NAME`, `INSTANCE_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_FT_J_G`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_T_G`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TG`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_DURABLE` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_UPDATE_DATA` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_J_REQ_RECOVERY`(`SCHED_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_J_GRP`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', NULL, 'io.renren.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597372002E696F2E72656E72656E2E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200074C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000017F61508FC07874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000174000672656E72656E74000CE58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LOCK_NAME` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `LOCK_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('RenrenScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('RenrenScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('RenrenScheduler', '90d7f37548521646859480677', 1646911704252, 15000);
INSERT INTO `qrtz_scheduler_state` VALUES ('RenrenScheduler', 'DESKTOP-STSL8U41646894490146', 1646911700505, 15000);

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `STR_PROP_1` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_2` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_3` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `INT_PROP_1` int(11) NULL DEFAULT NULL,
  `INT_PROP_2` int(11) NULL DEFAULT NULL,
  `LONG_PROP_1` bigint(20) NULL DEFAULT NULL,
  `LONG_PROP_2` bigint(20) NULL DEFAULT NULL,
  `DEC_PROP_1` decimal(13, 4) NULL DEFAULT NULL,
  `DEC_PROP_2` decimal(13, 4) NULL DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
  `PRIORITY` int(11) NULL DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_TYPE` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) NULL DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) NULL DEFAULT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_J`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_C`(`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_T_G`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_STATE`(`SCHED_NAME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_STATE`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_G_STATE`(`SCHED_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NEXT_FIRE_TIME`(`SCHED_NAME`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST`(`SCHED_NAME`, `TRIGGER_STATE`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', 'TASK_1', 'DEFAULT', NULL, 1646911800000, 1646910000000, 5, 'WAITING', 'CRON', 1646635278000, 0, NULL, 2, 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597372002E696F2E72656E72656E2E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200074C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000017F61508FC07874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000174000672656E72656E740012E8AEBEE5A487E4BFA1E681AFE69BB4E696B0737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job`  (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'spring bean名称',
  `params` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定时任务' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES (1, 'testTask', 'renren', '0 0/30 * * * ?', 0, '设备信息更新', '2022-03-07 06:19:04');

-- ----------------------------
-- Table structure for schedule_job_log
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
CREATE TABLE `schedule_job_log`  (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'spring bean名称',
  `params` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`) USING BTREE,
  INDEX `job_id`(`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 145 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定时任务日志' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of schedule_job_log
-- ----------------------------
INSERT INTO `schedule_job_log` VALUES (1, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-07 15:00:01');
INSERT INTO `schedule_job_log` VALUES (2, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-07 15:30:00');
INSERT INTO `schedule_job_log` VALUES (3, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-07 16:00:00');
INSERT INTO `schedule_job_log` VALUES (4, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-07 16:30:00');
INSERT INTO `schedule_job_log` VALUES (5, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-07 17:00:00');
INSERT INTO `schedule_job_log` VALUES (6, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-07 18:00:00');
INSERT INTO `schedule_job_log` VALUES (7, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-07 18:30:00');
INSERT INTO `schedule_job_log` VALUES (8, 1, 'testTask', 'renren', 0, NULL, 1, '2022-03-07 19:00:00');
INSERT INTO `schedule_job_log` VALUES (9, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-07 19:30:00');
INSERT INTO `schedule_job_log` VALUES (10, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-07 20:00:00');
INSERT INTO `schedule_job_log` VALUES (11, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-07 20:30:00');
INSERT INTO `schedule_job_log` VALUES (12, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-07 21:00:00');
INSERT INTO `schedule_job_log` VALUES (13, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-07 21:30:00');
INSERT INTO `schedule_job_log` VALUES (14, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-07 22:00:00');
INSERT INTO `schedule_job_log` VALUES (15, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-07 22:30:00');
INSERT INTO `schedule_job_log` VALUES (16, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-07 23:00:00');
INSERT INTO `schedule_job_log` VALUES (17, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-07 23:30:00');
INSERT INTO `schedule_job_log` VALUES (18, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 01:00:00');
INSERT INTO `schedule_job_log` VALUES (19, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 01:30:00');
INSERT INTO `schedule_job_log` VALUES (20, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 02:00:00');
INSERT INTO `schedule_job_log` VALUES (21, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 02:30:00');
INSERT INTO `schedule_job_log` VALUES (22, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 03:00:00');
INSERT INTO `schedule_job_log` VALUES (23, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 03:30:00');
INSERT INTO `schedule_job_log` VALUES (24, 1, 'testTask', 'renren', 0, NULL, 1, '2022-03-08 04:00:00');
INSERT INTO `schedule_job_log` VALUES (25, 1, 'testTask', 'renren', 0, NULL, 1, '2022-03-08 04:30:00');
INSERT INTO `schedule_job_log` VALUES (26, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 05:00:00');
INSERT INTO `schedule_job_log` VALUES (27, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 05:30:00');
INSERT INTO `schedule_job_log` VALUES (28, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 06:00:00');
INSERT INTO `schedule_job_log` VALUES (29, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 06:30:00');
INSERT INTO `schedule_job_log` VALUES (30, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 07:00:01');
INSERT INTO `schedule_job_log` VALUES (31, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 07:30:00');
INSERT INTO `schedule_job_log` VALUES (32, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 08:00:00');
INSERT INTO `schedule_job_log` VALUES (33, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 08:30:00');
INSERT INTO `schedule_job_log` VALUES (34, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 09:00:00');
INSERT INTO `schedule_job_log` VALUES (35, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 09:30:00');
INSERT INTO `schedule_job_log` VALUES (36, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 10:00:00');
INSERT INTO `schedule_job_log` VALUES (37, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 10:30:00');
INSERT INTO `schedule_job_log` VALUES (38, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 11:00:00');
INSERT INTO `schedule_job_log` VALUES (39, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 11:30:00');
INSERT INTO `schedule_job_log` VALUES (40, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 12:30:00');
INSERT INTO `schedule_job_log` VALUES (41, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 13:00:00');
INSERT INTO `schedule_job_log` VALUES (42, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 13:30:00');
INSERT INTO `schedule_job_log` VALUES (43, 1, 'testTask', 'renren', 0, NULL, 0, '2022-03-08 14:00:00');
INSERT INTO `schedule_job_log` VALUES (44, 1, 'testTask', 'renren', 0, NULL, 42, '2022-03-08 14:24:30');
INSERT INTO `schedule_job_log` VALUES (45, 1, 'testTask', 'renren', 0, NULL, 16, '2022-03-08 14:30:00');
INSERT INTO `schedule_job_log` VALUES (46, 1, 'testTask', 'renren', 0, NULL, 15, '2022-03-08 15:00:00');
INSERT INTO `schedule_job_log` VALUES (47, 1, 'testTask', 'renren', 0, NULL, 63, '2022-03-08 15:30:00');
INSERT INTO `schedule_job_log` VALUES (48, 1, 'testTask', 'renren', 0, NULL, 2346, '2022-03-08 15:34:19');
INSERT INTO `schedule_job_log` VALUES (49, 1, 'testTask', 'renren', 0, NULL, 1427, '2022-03-08 15:36:22');
INSERT INTO `schedule_job_log` VALUES (50, 1, 'testTask', 'renren', 0, NULL, 2205, '2022-03-08 15:41:03');
INSERT INTO `schedule_job_log` VALUES (51, 1, 'testTask', 'renren', 0, NULL, 1260, '2022-03-08 15:41:56');
INSERT INTO `schedule_job_log` VALUES (52, 1, 'testTask', 'renren', 0, NULL, 4023, '2022-03-08 16:00:00');
INSERT INTO `schedule_job_log` VALUES (53, 1, 'testTask', 'renren', 0, NULL, 3938, '2022-03-08 16:30:00');
INSERT INTO `schedule_job_log` VALUES (54, 1, 'testTask', 'renren', 0, NULL, 2386, '2022-03-08 17:00:00');
INSERT INTO `schedule_job_log` VALUES (55, 1, 'testTask', 'renren', 0, NULL, 71266, '2022-03-08 17:20:34');
INSERT INTO `schedule_job_log` VALUES (56, 1, 'testTask', 'renren', 0, NULL, 82758, '2022-03-08 17:30:00');
INSERT INTO `schedule_job_log` VALUES (57, 1, 'testTask', 'renren', 0, NULL, 73746, '2022-03-08 18:30:00');
INSERT INTO `schedule_job_log` VALUES (58, 1, 'testTask', 'renren', 0, NULL, 228724, '2022-03-08 19:00:00');
INSERT INTO `schedule_job_log` VALUES (59, 1, 'testTask', 'renren', 0, NULL, 10557, '2022-03-08 21:25:40');
INSERT INTO `schedule_job_log` VALUES (60, 1, 'testTask', 'renren', 0, NULL, 10810, '2022-03-08 21:29:09');
INSERT INTO `schedule_job_log` VALUES (61, 1, 'testTask', 'renren', 1, 'java.lang.reflect.InvocationTargetException', 3564, '2022-03-08 21:31:10');
INSERT INTO `schedule_job_log` VALUES (62, 1, 'testTask', 'renren', 1, 'java.lang.reflect.InvocationTargetException', 5490, '2022-03-08 21:33:26');
INSERT INTO `schedule_job_log` VALUES (63, 1, 'testTask', 'renren', 1, 'java.lang.reflect.InvocationTargetException', 9360, '2022-03-08 21:45:47');
INSERT INTO `schedule_job_log` VALUES (64, 1, 'testTask', 'renren', 1, 'java.lang.reflect.InvocationTargetException', 8858, '2022-03-08 21:48:37');
INSERT INTO `schedule_job_log` VALUES (65, 1, 'testTask', 'renren', 1, 'java.lang.reflect.InvocationTargetException', 8058, '2022-03-08 22:00:00');
INSERT INTO `schedule_job_log` VALUES (66, 1, 'testTask', 'renren', 1, 'java.lang.reflect.InvocationTargetException', 8319, '2022-03-08 22:30:00');
INSERT INTO `schedule_job_log` VALUES (67, 1, 'testTask', 'renren', 1, 'java.lang.reflect.InvocationTargetException', 6761, '2022-03-08 23:00:00');
INSERT INTO `schedule_job_log` VALUES (68, 1, 'testTask', 'renren', 1, 'java.lang.reflect.InvocationTargetException', 3848, '2022-03-08 23:30:00');
INSERT INTO `schedule_job_log` VALUES (69, 1, 'testTask', 'renren', 1, 'java.lang.reflect.InvocationTargetException', 3268, '2022-03-09 02:00:00');
INSERT INTO `schedule_job_log` VALUES (70, 1, 'testTask', 'renren', 1, 'java.lang.reflect.InvocationTargetException', 3950, '2022-03-09 02:27:35');
INSERT INTO `schedule_job_log` VALUES (71, 1, 'testTask', 'renren', 0, NULL, 5759, '2022-03-09 02:29:57');
INSERT INTO `schedule_job_log` VALUES (72, 1, 'testTask', 'renren', 0, NULL, 5584, '2022-03-09 02:30:00');
INSERT INTO `schedule_job_log` VALUES (73, 1, 'testTask', 'renren', 0, NULL, 9176, '2022-03-09 03:00:00');
INSERT INTO `schedule_job_log` VALUES (74, 1, 'testTask', 'renren', 0, NULL, 23549, '2022-03-09 03:30:00');
INSERT INTO `schedule_job_log` VALUES (75, 1, 'testTask', 'renren', 0, NULL, 8820, '2022-03-09 04:00:00');
INSERT INTO `schedule_job_log` VALUES (76, 1, 'testTask', 'renren', 0, NULL, 8427, '2022-03-09 04:30:00');
INSERT INTO `schedule_job_log` VALUES (77, 1, 'testTask', 'renren', 0, NULL, 8381, '2022-03-09 05:00:00');
INSERT INTO `schedule_job_log` VALUES (78, 1, 'testTask', 'renren', 0, NULL, 8906, '2022-03-09 05:30:00');
INSERT INTO `schedule_job_log` VALUES (79, 1, 'testTask', 'renren', 0, NULL, 8958, '2022-03-09 06:00:00');
INSERT INTO `schedule_job_log` VALUES (80, 1, 'testTask', 'renren', 0, NULL, 7447, '2022-03-09 06:30:00');
INSERT INTO `schedule_job_log` VALUES (81, 1, 'testTask', 'renren', 0, NULL, 6948, '2022-03-09 07:00:00');
INSERT INTO `schedule_job_log` VALUES (82, 1, 'testTask', 'renren', 0, NULL, 12207, '2022-03-09 07:30:02');
INSERT INTO `schedule_job_log` VALUES (83, 1, 'testTask', 'renren', 0, NULL, 7383, '2022-03-09 08:00:00');
INSERT INTO `schedule_job_log` VALUES (84, 1, 'testTask', 'renren', 0, NULL, 8282, '2022-03-09 08:30:00');
INSERT INTO `schedule_job_log` VALUES (85, 1, 'testTask', 'renren', 0, NULL, 9441, '2022-03-09 09:00:00');
INSERT INTO `schedule_job_log` VALUES (86, 1, 'testTask', 'renren', 0, NULL, 12023, '2022-03-09 09:30:00');
INSERT INTO `schedule_job_log` VALUES (87, 1, 'testTask', 'renren', 0, NULL, 10021, '2022-03-09 10:00:00');
INSERT INTO `schedule_job_log` VALUES (88, 1, 'testTask', 'renren', 0, NULL, 10082, '2022-03-09 10:30:00');
INSERT INTO `schedule_job_log` VALUES (89, 1, 'testTask', 'renren', 0, NULL, 9403, '2022-03-09 11:30:00');
INSERT INTO `schedule_job_log` VALUES (90, 1, 'testTask', 'renren', 0, NULL, 20212, '2022-03-09 11:46:23');
INSERT INTO `schedule_job_log` VALUES (91, 1, 'testTask', 'renren', 0, NULL, 20465, '2022-03-09 12:00:00');
INSERT INTO `schedule_job_log` VALUES (92, 1, 'testTask', 'renren', 0, NULL, 23469, '2022-03-09 13:00:00');
INSERT INTO `schedule_job_log` VALUES (93, 1, 'testTask', 'renren', 0, NULL, 22607, '2022-03-09 13:30:00');
INSERT INTO `schedule_job_log` VALUES (94, 1, 'testTask', 'renren', 0, NULL, 23030, '2022-03-09 14:00:00');
INSERT INTO `schedule_job_log` VALUES (95, 1, 'testTask', 'renren', 0, NULL, 10971, '2022-03-09 17:00:00');
INSERT INTO `schedule_job_log` VALUES (96, 1, 'testTask', 'renren', 0, NULL, 64715, '2022-03-09 17:30:00');
INSERT INTO `schedule_job_log` VALUES (97, 1, 'testTask', 'renren', 0, NULL, 36057, '2022-03-09 18:00:00');
INSERT INTO `schedule_job_log` VALUES (98, 1, 'testTask', 'renren', 0, NULL, 46880, '2022-03-09 18:30:00');
INSERT INTO `schedule_job_log` VALUES (99, 1, 'testTask', 'renren', 0, NULL, 14433, '2022-03-09 19:00:01');
INSERT INTO `schedule_job_log` VALUES (100, 1, 'testTask', 'renren', 0, NULL, 12190, '2022-03-09 19:30:01');
INSERT INTO `schedule_job_log` VALUES (101, 1, 'testTask', 'renren', 0, NULL, 11792, '2022-03-09 20:00:04');
INSERT INTO `schedule_job_log` VALUES (102, 1, 'testTask', 'renren', 0, NULL, 10879, '2022-03-09 20:30:01');
INSERT INTO `schedule_job_log` VALUES (103, 1, 'testTask', 'renren', 0, NULL, 24731, '2022-03-09 21:00:00');
INSERT INTO `schedule_job_log` VALUES (104, 1, 'testTask', 'renren', 0, NULL, 25957, '2022-03-09 22:00:00');
INSERT INTO `schedule_job_log` VALUES (105, 1, 'testTask', 'renren', 0, NULL, 28085, '2022-03-09 22:30:00');
INSERT INTO `schedule_job_log` VALUES (106, 1, 'testTask', 'renren', 0, NULL, 28069, '2022-03-09 23:00:00');
INSERT INTO `schedule_job_log` VALUES (107, 1, 'testTask', 'renren', 0, NULL, 11609, '2022-03-09 23:30:00');
INSERT INTO `schedule_job_log` VALUES (108, 1, 'testTask', 'renren', 0, NULL, 11062, '2022-03-10 00:00:01');
INSERT INTO `schedule_job_log` VALUES (109, 1, 'testTask', 'renren', 0, NULL, 9241, '2022-03-10 00:30:00');
INSERT INTO `schedule_job_log` VALUES (110, 1, 'testTask', 'renren', 0, NULL, 9365, '2022-03-10 01:00:00');
INSERT INTO `schedule_job_log` VALUES (111, 1, 'testTask', 'renren', 0, NULL, 12368, '2022-03-10 01:30:00');
INSERT INTO `schedule_job_log` VALUES (112, 1, 'testTask', 'renren', 0, NULL, 9638, '2022-03-10 02:00:00');
INSERT INTO `schedule_job_log` VALUES (113, 1, 'testTask', 'renren', 0, NULL, 12710, '2022-03-10 02:30:00');
INSERT INTO `schedule_job_log` VALUES (114, 1, 'testTask', 'renren', 0, NULL, 11487, '2022-03-10 03:00:00');
INSERT INTO `schedule_job_log` VALUES (115, 1, 'testTask', 'renren', 0, NULL, 13850, '2022-03-10 03:30:00');
INSERT INTO `schedule_job_log` VALUES (116, 1, 'testTask', 'renren', 0, NULL, 16873, '2022-03-10 04:00:00');
INSERT INTO `schedule_job_log` VALUES (117, 1, 'testTask', 'renren', 0, NULL, 27099, '2022-03-10 05:00:00');
INSERT INTO `schedule_job_log` VALUES (118, 1, 'testTask', 'renren', 0, NULL, 26152, '2022-03-10 05:30:00');
INSERT INTO `schedule_job_log` VALUES (119, 1, 'testTask', 'renren', 0, NULL, 20824, '2022-03-10 06:00:00');
INSERT INTO `schedule_job_log` VALUES (120, 1, 'testTask', 'renren', 0, NULL, 14497, '2022-03-10 06:30:00');
INSERT INTO `schedule_job_log` VALUES (121, 1, 'testTask', 'renren', 0, NULL, 23195, '2022-03-10 07:00:00');
INSERT INTO `schedule_job_log` VALUES (122, 1, 'testTask', 'renren', 0, NULL, 9299, '2022-03-10 07:30:00');
INSERT INTO `schedule_job_log` VALUES (123, 1, 'testTask', 'renren', 0, NULL, 22247, '2022-03-10 08:00:00');
INSERT INTO `schedule_job_log` VALUES (124, 1, 'testTask', 'renren', 0, NULL, 47447, '2022-03-10 08:30:00');
INSERT INTO `schedule_job_log` VALUES (125, 1, 'testTask', 'renren', 0, NULL, 56598, '2022-03-10 09:00:00');
INSERT INTO `schedule_job_log` VALUES (126, 1, 'testTask', 'renren', 0, NULL, 27998, '2022-03-10 09:30:00');
INSERT INTO `schedule_job_log` VALUES (127, 1, 'testTask', 'renren', 0, NULL, 9830, '2022-03-10 10:00:01');
INSERT INTO `schedule_job_log` VALUES (128, 1, 'testTask', 'renren', 0, NULL, 49744, '2022-03-10 10:30:00');
INSERT INTO `schedule_job_log` VALUES (129, 1, 'testTask', 'renren', 0, NULL, 17297, '2022-03-10 11:00:00');
INSERT INTO `schedule_job_log` VALUES (130, 1, 'testTask', 'renren', 0, NULL, 11241, '2022-03-10 11:30:00');
INSERT INTO `schedule_job_log` VALUES (131, 1, 'testTask', 'renren', 0, NULL, 58903, '2022-03-10 12:00:00');
INSERT INTO `schedule_job_log` VALUES (132, 1, 'testTask', 'renren', 0, NULL, 10869, '2022-03-10 12:30:00');
INSERT INTO `schedule_job_log` VALUES (133, 1, 'testTask', 'renren', 0, NULL, 22890, '2022-03-10 13:00:00');
INSERT INTO `schedule_job_log` VALUES (134, 1, 'testTask', 'renren', 0, NULL, 11621, '2022-03-10 13:30:00');
INSERT INTO `schedule_job_log` VALUES (135, 1, 'testTask', 'renren', 0, NULL, 9796, '2022-03-10 14:00:02');
INSERT INTO `schedule_job_log` VALUES (136, 1, 'testTask', 'renren', 0, NULL, 19451, '2022-03-10 15:00:00');
INSERT INTO `schedule_job_log` VALUES (137, 1, 'testTask', 'renren', 0, NULL, 24290, '2022-03-10 15:30:00');
INSERT INTO `schedule_job_log` VALUES (138, 1, 'testTask', 'renren', 0, NULL, 32223, '2022-03-10 16:00:00');
INSERT INTO `schedule_job_log` VALUES (139, 1, 'testTask', 'renren', 0, NULL, 17813, '2022-03-10 16:30:00');
INSERT INTO `schedule_job_log` VALUES (140, 1, 'testTask', 'renren', 0, NULL, 18786, '2022-03-10 17:00:00');
INSERT INTO `schedule_job_log` VALUES (141, 1, 'testTask', 'renren', 0, NULL, 32126, '2022-03-10 17:30:00');
INSERT INTO `schedule_job_log` VALUES (142, 1, 'testTask', 'renren', 0, NULL, 27267, '2022-03-10 18:00:00');
INSERT INTO `schedule_job_log` VALUES (143, 1, 'testTask', 'renren', 0, NULL, 20399, '2022-03-10 18:30:00');
INSERT INTO `schedule_job_log` VALUES (144, 1, 'testTask', 'renren', 0, NULL, 24958, '2022-03-10 19:00:00');

-- ----------------------------
-- Table structure for sys_captcha
-- ----------------------------
DROP TABLE IF EXISTS `sys_captcha`;
CREATE TABLE `sys_captcha`  (
  `uuid` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'uuid',
  `code` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '验证码',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统验证码' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_captcha
-- ----------------------------
INSERT INTO `sys_captcha` VALUES ('013a8a7f-44d2-4d83-80ac-c0032d1c9a60', '2aeep', '2022-03-10 04:06:45');
INSERT INTO `sys_captcha` VALUES ('069723e6-9af9-44a5-81df-c7fd39c9e4ee', '8786n', '2022-03-10 14:47:28');
INSERT INTO `sys_captcha` VALUES ('0b4eb0f8-9089-4f16-8fdf-13ff3417712e', '5cpye', '2022-03-10 17:07:23');
INSERT INTO `sys_captcha` VALUES ('0c5e7f41-37ce-44db-833c-24e67046b0cd', 'b2n2a', '2022-03-10 04:07:10');
INSERT INTO `sys_captcha` VALUES ('14a9bc4f-6b95-4c1e-8339-35b666ecab61', '4aadg', '2022-03-10 04:04:37');
INSERT INTO `sys_captcha` VALUES ('2fde4849-5e4b-4a6f-87fa-2671a4c775ee', 'fc82g', '2022-03-10 04:02:52');
INSERT INTO `sys_captcha` VALUES ('39a62add-1eb5-42d7-8abd-dd0b5747f8c1', 'c2f8d', '2022-03-10 14:47:28');
INSERT INTO `sys_captcha` VALUES ('4402daff-d6b0-415c-890c-55475229306e', 'y8wex', '2022-03-07 17:28:55');
INSERT INTO `sys_captcha` VALUES ('4dd3d867-806e-41c9-8e1e-8d684acefebf', 'b32m3', '2022-03-10 04:02:52');
INSERT INTO `sys_captcha` VALUES ('58011772-c686-4cd6-8e9f-c57c133d4381', '8d335', '2022-03-10 04:02:52');
INSERT INTO `sys_captcha` VALUES ('6fd41265-dfac-4689-8c04-5fbe7226d5a9', 'eyf6f', '2022-03-10 17:07:17');
INSERT INTO `sys_captcha` VALUES ('7d57bfbf-3657-40a6-840e-6165d148a056', 'awg7f', '2022-03-10 04:02:53');
INSERT INTO `sys_captcha` VALUES ('831714c5-a72d-48ac-8c7f-248f2b5cb466', '7455x', '2022-03-10 04:02:52');
INSERT INTO `sys_captcha` VALUES ('8e83e726-25e1-49f7-81ad-1adae44295b6', 'p6c42', '2022-03-10 04:07:10');
INSERT INTO `sys_captcha` VALUES ('b8dd04fc-ee8f-4aed-8197-ad838bc347d9', 'df3pn', '2022-03-07 17:34:40');
INSERT INTO `sys_captcha` VALUES ('d3775014-1354-4b82-8b61-428800e4b0cf', '35w7w', '2022-03-10 04:07:10');
INSERT INTO `sys_captcha` VALUES ('d9dcb47d-81f5-4e27-8ba8-421cdcdd8abe', '6cx5b', '2022-03-10 04:43:42');
INSERT INTO `sys_captcha` VALUES ('ea230334-736e-4f2b-8ae6-3e406f85aed5', '2444d', '2022-03-10 04:02:51');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `param_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'key',
  `param_value` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) NULL DEFAULT 1 COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `param_key`(`param_key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统配置信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, 'CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', 0, '云存储配置信息');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统日志' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1, 'admin', '保存角色', 'io.renren.modules.sys.controller.SysRoleController.save()', '[{\"roleId\":1,\"roleName\":\"AA\",\"remark\":\"\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,-666666],\"createTime\":\"Mar 8, 2022 12:42:10 PM\"}]', 833, '0:0:0:0:0:0:0:1', '2022-03-08 12:42:11');
INSERT INTO `sys_log` VALUES (2, 'admin', '立即执行任务', 'io.renren.modules.job.controller.ScheduleJobController.run()', '[[1]]', 124, '0:0:0:0:0:0:0:1', '2022-03-08 14:24:30');
INSERT INTO `sys_log` VALUES (3, 'admin', '立即执行任务', 'io.renren.modules.job.controller.ScheduleJobController.run()', '[[1]]', 104, '0:0:0:0:0:0:0:1', '2022-03-08 15:34:18');
INSERT INTO `sys_log` VALUES (4, 'admin', '立即执行任务', 'io.renren.modules.job.controller.ScheduleJobController.run()', '[[1]]', 123, '0:0:0:0:0:0:0:1', '2022-03-08 15:36:08');
INSERT INTO `sys_log` VALUES (5, 'admin', '立即执行任务', 'io.renren.modules.job.controller.ScheduleJobController.run()', '[[1]]', 110, '0:0:0:0:0:0:0:1', '2022-03-08 15:41:03');
INSERT INTO `sys_log` VALUES (6, 'admin', '立即执行任务', 'io.renren.modules.job.controller.ScheduleJobController.run()', '[[1]]', 112, '0:0:0:0:0:0:0:1', '2022-03-08 15:41:56');
INSERT INTO `sys_log` VALUES (7, 'admin', '暂停定时任务', 'io.renren.modules.job.controller.ScheduleJobController.pause()', '[[1]]', 96, '0:0:0:0:0:0:0:1', '2022-03-08 15:42:08');
INSERT INTO `sys_log` VALUES (8, 'admin', '恢复定时任务', 'io.renren.modules.job.controller.ScheduleJobController.resume()', '[[1]]', 105, '0:0:0:0:0:0:0:1', '2022-03-08 15:42:17');
INSERT INTO `sys_log` VALUES (9, 'admin', '立即执行任务', 'io.renren.modules.job.controller.ScheduleJobController.run()', '[[1]]', 99, '0:0:0:0:0:0:0:1', '2022-03-08 17:20:34');
INSERT INTO `sys_log` VALUES (10, 'admin', '立即执行任务', 'io.renren.modules.job.controller.ScheduleJobController.run()', '[[1]]', 70, '0:0:0:0:0:0:0:1', '2022-03-08 21:25:40');
INSERT INTO `sys_log` VALUES (11, 'admin', '立即执行任务', 'io.renren.modules.job.controller.ScheduleJobController.run()', '[[1]]', 76, '0:0:0:0:0:0:0:1', '2022-03-08 21:29:09');
INSERT INTO `sys_log` VALUES (12, 'admin', '立即执行任务', 'io.renren.modules.job.controller.ScheduleJobController.run()', '[[1]]', 85, '0:0:0:0:0:0:0:1', '2022-03-08 21:31:06');
INSERT INTO `sys_log` VALUES (13, 'admin', '立即执行任务', 'io.renren.modules.job.controller.ScheduleJobController.run()', '[[1]]', 100, '0:0:0:0:0:0:0:1', '2022-03-08 21:33:15');
INSERT INTO `sys_log` VALUES (14, 'admin', '立即执行任务', 'io.renren.modules.job.controller.ScheduleJobController.run()', '[[1]]', 83, '0:0:0:0:0:0:0:1', '2022-03-08 21:45:47');
INSERT INTO `sys_log` VALUES (15, 'admin', '立即执行任务', 'io.renren.modules.job.controller.ScheduleJobController.run()', '[[1]]', 125, '0:0:0:0:0:0:0:1', '2022-03-08 21:48:37');
INSERT INTO `sys_log` VALUES (16, 'admin', '立即执行任务', 'io.renren.modules.job.controller.ScheduleJobController.run()', '[[1]]', 89, '0:0:0:0:0:0:0:1', '2022-03-09 02:27:33');
INSERT INTO `sys_log` VALUES (17, 'admin', '立即执行任务', 'io.renren.modules.job.controller.ScheduleJobController.run()', '[[1]]', 72, '0:0:0:0:0:0:0:1', '2022-03-09 02:29:57');
INSERT INTO `sys_log` VALUES (18, 'admin', '立即执行任务', 'io.renren.modules.job.controller.ScheduleJobController.run()', '[[1]]', 92, '0:0:0:0:0:0:0:1', '2022-03-09 11:46:23');
INSERT INTO `sys_log` VALUES (19, 'admin', '修改定时任务', 'io.renren.modules.job.controller.ScheduleJobController.update()', '[{\"jobId\":1,\"beanName\":\"testTask\",\"params\":\"renren\",\"cronExpression\":\"0 0/30 * * * ?\",\"status\":0,\"remark\":\"设备信息更新\"}]', 301, '0:0:0:0:0:0:0:1', '2022-03-09 11:47:37');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单管理' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', NULL, NULL, 0, 'system', 0);
INSERT INTO `sys_menu` VALUES (2, 1, '管理员列表', 'sys/user', NULL, 1, 'admin', 1);
INSERT INTO `sys_menu` VALUES (3, 1, '角色管理', 'sys/role', NULL, 1, 'role', 2);
INSERT INTO `sys_menu` VALUES (4, 1, '菜单管理', 'sys/menu', NULL, 1, 'menu', 3);
INSERT INTO `sys_menu` VALUES (5, 1, 'SQL监控', 'http://localhost:8080/fast-api/druid/sql.html', NULL, 1, 'sql', 4);
INSERT INTO `sys_menu` VALUES (6, 1, '定时任务', 'job/schedule', NULL, 1, 'job', 5);
INSERT INTO `sys_menu` VALUES (7, 6, '查看', NULL, 'sys:schedule:list,sys:schedule:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (8, 6, '新增', NULL, 'sys:schedule:save', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (9, 6, '修改', NULL, 'sys:schedule:update', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (10, 6, '删除', NULL, 'sys:schedule:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (11, 6, '暂停', NULL, 'sys:schedule:pause', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (12, 6, '恢复', NULL, 'sys:schedule:resume', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (13, 6, '立即执行', NULL, 'sys:schedule:run', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (14, 6, '日志列表', NULL, 'sys:schedule:log', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (15, 2, '查看', NULL, 'sys:user:list,sys:user:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (16, 2, '新增', NULL, 'sys:user:save,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (17, 2, '修改', NULL, 'sys:user:update,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (18, 2, '删除', NULL, 'sys:user:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (19, 3, '查看', NULL, 'sys:role:list,sys:role:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (20, 3, '新增', NULL, 'sys:role:save,sys:menu:list', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (21, 3, '修改', NULL, 'sys:role:update,sys:menu:list', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (22, 3, '删除', NULL, 'sys:role:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (23, 4, '查看', NULL, 'sys:menu:list,sys:menu:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (24, 4, '新增', NULL, 'sys:menu:save,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (25, 4, '修改', NULL, 'sys:menu:update,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (26, 4, '删除', NULL, 'sys:menu:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (27, 1, '参数管理', 'sys/config', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', 1, 'config', 6);
INSERT INTO `sys_menu` VALUES (29, 1, '系统日志', 'sys/log', 'sys:log:list', 1, 'log', 7);
INSERT INTO `sys_menu` VALUES (30, 1, '文件上传', 'oss/oss', 'sys:oss:all', 1, 'oss', 6);
INSERT INTO `sys_menu` VALUES (31, 0, '业务管理', NULL, NULL, 0, 'system', 0);
INSERT INTO `sys_menu` VALUES (32, 31, '管理机', 'business/businessanagementmachine', NULL, 1, 'config', 3);
INSERT INTO `sys_menu` VALUES (33, 32, '查看', NULL, 'business:businessanagementmachine:list,business:businessanagementmachine:info', 2, NULL, 3);
INSERT INTO `sys_menu` VALUES (34, 32, '新增', NULL, 'business:businessanagementmachine:save', 2, NULL, 3);
INSERT INTO `sys_menu` VALUES (35, 32, '修改', NULL, 'business:businessanagementmachine:update', 2, NULL, 3);
INSERT INTO `sys_menu` VALUES (36, 32, '删除', NULL, 'business:businessanagementmachine:delete', 2, NULL, 3);
INSERT INTO `sys_menu` VALUES (37, 31, '钱包管理', 'business/businesswallet', NULL, 1, 'config', 5);
INSERT INTO `sys_menu` VALUES (38, 37, '查看', NULL, 'business:businesswallet:list,business:businesswallet:info', 2, NULL, 5);
INSERT INTO `sys_menu` VALUES (39, 37, '新增', NULL, 'business:businesswallet:save', 2, NULL, 5);
INSERT INTO `sys_menu` VALUES (40, 37, '修改', NULL, 'business:businesswallet:update', 2, NULL, 5);
INSERT INTO `sys_menu` VALUES (41, 37, '删除', NULL, 'business:businesswallet:delete', 2, NULL, 5);
INSERT INTO `sys_menu` VALUES (42, 31, '分组管理', 'business/businessgroup', NULL, 1, 'config', 4);
INSERT INTO `sys_menu` VALUES (43, 42, '查看', NULL, 'business:businessgroup:list,business:businessgroup:info', 2, NULL, 4);
INSERT INTO `sys_menu` VALUES (44, 42, '新增', NULL, 'business:businessgroup:save', 2, NULL, 4);
INSERT INTO `sys_menu` VALUES (45, 42, '修改', NULL, 'business:businessgroup:update', 2, NULL, 4);
INSERT INTO `sys_menu` VALUES (46, 42, '删除', NULL, 'business:businessgroup:delete', 2, NULL, 4);
INSERT INTO `sys_menu` VALUES (47, 31, '设备管理', 'business/businesshotspotty', NULL, 1, 'config', 6);
INSERT INTO `sys_menu` VALUES (48, 47, '查看', NULL, 'business:businesshotspotty:list,business:businesshotspotty:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (49, 47, '新增', NULL, 'business:businesshotspotty:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (50, 47, '修改', NULL, 'business:businesshotspotty:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (51, 47, '删除', NULL, 'business:businesshotspotty:delete', 2, NULL, 6);

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文件上传' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_oss
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'AA', '', 1, '2022-03-08 12:42:10');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色与菜单对应关系' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1, 1);
INSERT INTO `sys_role_menu` VALUES (2, 1, 2);
INSERT INTO `sys_role_menu` VALUES (3, 1, 15);
INSERT INTO `sys_role_menu` VALUES (4, 1, 16);
INSERT INTO `sys_role_menu` VALUES (5, 1, 17);
INSERT INTO `sys_role_menu` VALUES (6, 1, 18);
INSERT INTO `sys_role_menu` VALUES (7, 1, 3);
INSERT INTO `sys_role_menu` VALUES (8, 1, 19);
INSERT INTO `sys_role_menu` VALUES (9, 1, 20);
INSERT INTO `sys_role_menu` VALUES (10, 1, 21);
INSERT INTO `sys_role_menu` VALUES (11, 1, 22);
INSERT INTO `sys_role_menu` VALUES (12, 1, 4);
INSERT INTO `sys_role_menu` VALUES (13, 1, 23);
INSERT INTO `sys_role_menu` VALUES (14, 1, 24);
INSERT INTO `sys_role_menu` VALUES (15, 1, 25);
INSERT INTO `sys_role_menu` VALUES (16, 1, 26);
INSERT INTO `sys_role_menu` VALUES (17, 1, 5);
INSERT INTO `sys_role_menu` VALUES (18, 1, 6);
INSERT INTO `sys_role_menu` VALUES (19, 1, 7);
INSERT INTO `sys_role_menu` VALUES (20, 1, 8);
INSERT INTO `sys_role_menu` VALUES (21, 1, 9);
INSERT INTO `sys_role_menu` VALUES (22, 1, 10);
INSERT INTO `sys_role_menu` VALUES (23, 1, 11);
INSERT INTO `sys_role_menu` VALUES (24, 1, 12);
INSERT INTO `sys_role_menu` VALUES (25, 1, 13);
INSERT INTO `sys_role_menu` VALUES (26, 1, 14);
INSERT INTO `sys_role_menu` VALUES (27, 1, 27);
INSERT INTO `sys_role_menu` VALUES (28, 1, 29);
INSERT INTO `sys_role_menu` VALUES (29, 1, 30);
INSERT INTO `sys_role_menu` VALUES (30, 1, 31);
INSERT INTO `sys_role_menu` VALUES (31, 1, 32);
INSERT INTO `sys_role_menu` VALUES (32, 1, 33);
INSERT INTO `sys_role_menu` VALUES (33, 1, 34);
INSERT INTO `sys_role_menu` VALUES (34, 1, 35);
INSERT INTO `sys_role_menu` VALUES (35, 1, 36);
INSERT INTO `sys_role_menu` VALUES (36, 1, 37);
INSERT INTO `sys_role_menu` VALUES (37, 1, 38);
INSERT INTO `sys_role_menu` VALUES (38, 1, 39);
INSERT INTO `sys_role_menu` VALUES (39, 1, 40);
INSERT INTO `sys_role_menu` VALUES (40, 1, 41);
INSERT INTO `sys_role_menu` VALUES (41, 1, 42);
INSERT INTO `sys_role_menu` VALUES (42, 1, 43);
INSERT INTO `sys_role_menu` VALUES (43, 1, 44);
INSERT INTO `sys_role_menu` VALUES (44, 1, 45);
INSERT INTO `sys_role_menu` VALUES (45, 1, 46);
INSERT INTO `sys_role_menu` VALUES (46, 1, 47);
INSERT INTO `sys_role_menu` VALUES (47, 1, 48);
INSERT INTO `sys_role_menu` VALUES (48, 1, 49);
INSERT INTO `sys_role_menu` VALUES (49, 1, 50);
INSERT INTO `sys_role_menu` VALUES (50, 1, 51);
INSERT INTO `sys_role_menu` VALUES (51, 1, -666666);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '盐',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统用户' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', 'root@renren.io', '13612345678', 1, 1, '2016-11-11 11:11:11');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户与角色对应关系' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token`  (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'token',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `token`(`token`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统用户Token' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token` VALUES (1, '07cf85395a7a6398f6b6c015634ae724', '2022-03-09 14:33:34', '2022-03-09 02:33:34');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'mark', '13612345678', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2017-03-23 22:37:41');

SET FOREIGN_KEY_CHECKS = 1;
