/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : 192.168.56.101:3306
 Source Schema         : petcelsius

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 28/04/2022 15:52:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth_group
-- ----------------------------
DROP TABLE IF EXISTS `auth_group`;
CREATE TABLE `auth_group`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_group
-- ----------------------------

-- ----------------------------
-- Table structure for auth_group_permissions
-- ----------------------------
DROP TABLE IF EXISTS `auth_group_permissions`;
CREATE TABLE `auth_group_permissions`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `group_id` int NOT NULL,
  `permission_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `auth_group_permissions_group_id_permission_id_0cd325b0_uniq`(`group_id` ASC, `permission_id` ASC) USING BTREE,
  INDEX `auth_group_permissio_permission_id_84c5c92e_fk_auth_perm`(`permission_id` ASC) USING BTREE,
  CONSTRAINT `auth_group_permissio_permission_id_84c5c92e_fk_auth_perm` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `auth_group_permissions_group_id_b120cbf9_fk_auth_group_id` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_group_permissions
-- ----------------------------

-- ----------------------------
-- Table structure for auth_permission
-- ----------------------------
DROP TABLE IF EXISTS `auth_permission`;
CREATE TABLE `auth_permission`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content_type_id` int NOT NULL,
  `codename` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `auth_permission_content_type_id_codename_01ab375a_uniq`(`content_type_id` ASC, `codename` ASC) USING BTREE,
  CONSTRAINT `auth_permission_content_type_id_2f476e4b_fk_django_co` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 88 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_permission
-- ----------------------------
INSERT INTO `auth_permission` VALUES (1, 'Can add log entry', 1, 'add_logentry');
INSERT INTO `auth_permission` VALUES (2, 'Can change log entry', 1, 'change_logentry');
INSERT INTO `auth_permission` VALUES (3, 'Can delete log entry', 1, 'delete_logentry');
INSERT INTO `auth_permission` VALUES (4, 'Can view log entry', 1, 'view_logentry');
INSERT INTO `auth_permission` VALUES (5, 'Can add permission', 2, 'add_permission');
INSERT INTO `auth_permission` VALUES (6, 'Can change permission', 2, 'change_permission');
INSERT INTO `auth_permission` VALUES (7, 'Can delete permission', 2, 'delete_permission');
INSERT INTO `auth_permission` VALUES (8, 'Can view permission', 2, 'view_permission');
INSERT INTO `auth_permission` VALUES (9, 'Can add group', 3, 'add_group');
INSERT INTO `auth_permission` VALUES (10, 'Can change group', 3, 'change_group');
INSERT INTO `auth_permission` VALUES (11, 'Can delete group', 3, 'delete_group');
INSERT INTO `auth_permission` VALUES (12, 'Can view group', 3, 'view_group');
INSERT INTO `auth_permission` VALUES (13, 'Can add user', 4, 'add_user');
INSERT INTO `auth_permission` VALUES (14, 'Can change user', 4, 'change_user');
INSERT INTO `auth_permission` VALUES (15, 'Can delete user', 4, 'delete_user');
INSERT INTO `auth_permission` VALUES (16, 'Can view user', 4, 'view_user');
INSERT INTO `auth_permission` VALUES (17, 'Can add content type', 5, 'add_contenttype');
INSERT INTO `auth_permission` VALUES (18, 'Can change content type', 5, 'change_contenttype');
INSERT INTO `auth_permission` VALUES (19, 'Can delete content type', 5, 'delete_contenttype');
INSERT INTO `auth_permission` VALUES (20, 'Can view content type', 5, 'view_contenttype');
INSERT INTO `auth_permission` VALUES (21, 'Can add session', 6, 'add_session');
INSERT INTO `auth_permission` VALUES (22, 'Can change session', 6, 'change_session');
INSERT INTO `auth_permission` VALUES (23, 'Can delete session', 6, 'delete_session');
INSERT INTO `auth_permission` VALUES (24, 'Can view session', 6, 'view_session');
INSERT INTO `auth_permission` VALUES (25, 'Can add user', 7, 'add_user');
INSERT INTO `auth_permission` VALUES (26, 'Can change user', 7, 'change_user');
INSERT INTO `auth_permission` VALUES (27, 'Can delete user', 7, 'delete_user');
INSERT INTO `auth_permission` VALUES (28, 'Can view user', 7, 'view_user');
INSERT INTO `auth_permission` VALUES (29, 'Can add file upload', 8, 'add_fileupload');
INSERT INTO `auth_permission` VALUES (30, 'Can change file upload', 8, 'change_fileupload');
INSERT INTO `auth_permission` VALUES (31, 'Can delete file upload', 8, 'delete_fileupload');
INSERT INTO `auth_permission` VALUES (32, 'Can view file upload', 8, 'view_fileupload');
INSERT INTO `auth_permission` VALUES (33, 'Can add 首页banner', 9, 'add_indexbanner');
INSERT INTO `auth_permission` VALUES (34, 'Can change 首页banner', 9, 'change_indexbanner');
INSERT INTO `auth_permission` VALUES (35, 'Can delete 首页banner', 9, 'delete_indexbanner');
INSERT INTO `auth_permission` VALUES (36, 'Can view 首页banner', 9, 'view_indexbanner');
INSERT INTO `auth_permission` VALUES (37, 'Can add 首页导航栏', 10, 'add_indexnavigate');
INSERT INTO `auth_permission` VALUES (38, 'Can change 首页导航栏', 10, 'change_indexnavigate');
INSERT INTO `auth_permission` VALUES (39, 'Can delete 首页导航栏', 10, 'delete_indexnavigate');
INSERT INTO `auth_permission` VALUES (40, 'Can view 首页导航栏', 10, 'view_indexnavigate');
INSERT INTO `auth_permission` VALUES (41, 'Can add 首页楼层', 11, 'add_indexfloor');
INSERT INTO `auth_permission` VALUES (42, 'Can change 首页楼层', 11, 'change_indexfloor');
INSERT INTO `auth_permission` VALUES (43, 'Can delete 首页楼层', 11, 'delete_indexfloor');
INSERT INTO `auth_permission` VALUES (44, 'Can view 首页楼层', 11, 'view_indexfloor');
INSERT INTO `auth_permission` VALUES (45, 'Can add index floor detail', 12, 'add_indexfloordetail');
INSERT INTO `auth_permission` VALUES (46, 'Can change index floor detail', 12, 'change_indexfloordetail');
INSERT INTO `auth_permission` VALUES (47, 'Can delete index floor detail', 12, 'delete_indexfloordetail');
INSERT INTO `auth_permission` VALUES (48, 'Can view index floor detail', 12, 'view_indexfloordetail');
INSERT INTO `auth_permission` VALUES (49, 'Can add 首页楼层图片', 13, 'add_indexfloorimage');
INSERT INTO `auth_permission` VALUES (50, 'Can change 首页楼层图片', 13, 'change_indexfloorimage');
INSERT INTO `auth_permission` VALUES (51, 'Can delete 首页楼层图片', 13, 'delete_indexfloorimage');
INSERT INTO `auth_permission` VALUES (52, 'Can view 首页楼层图片', 13, 'view_indexfloorimage');
INSERT INTO `auth_permission` VALUES (53, 'Can add pet info', 14, 'add_petinfo');
INSERT INTO `auth_permission` VALUES (54, 'Can change pet info', 14, 'change_petinfo');
INSERT INTO `auth_permission` VALUES (55, 'Can delete pet info', 14, 'delete_petinfo');
INSERT INTO `auth_permission` VALUES (56, 'Can view pet info', 14, 'view_petinfo');
INSERT INTO `auth_permission` VALUES (57, 'Can add heart detail', 15, 'add_heartdetail');
INSERT INTO `auth_permission` VALUES (58, 'Can change heart detail', 15, 'change_heartdetail');
INSERT INTO `auth_permission` VALUES (59, 'Can delete heart detail', 15, 'delete_heartdetail');
INSERT INTO `auth_permission` VALUES (60, 'Can view heart detail', 15, 'view_heartdetail');
INSERT INTO `auth_permission` VALUES (61, 'Can add 缅怀基本信息', 16, 'add_heartinfo');
INSERT INTO `auth_permission` VALUES (62, 'Can change 缅怀基本信息', 16, 'change_heartinfo');
INSERT INTO `auth_permission` VALUES (63, 'Can delete 缅怀基本信息', 16, 'delete_heartinfo');
INSERT INTO `auth_permission` VALUES (64, 'Can view 缅怀基本信息', 16, 'view_heartinfo');
INSERT INTO `auth_permission` VALUES (65, 'Can add hear detail image', 17, 'add_heardetailimage');
INSERT INTO `auth_permission` VALUES (66, 'Can change hear detail image', 17, 'change_heardetailimage');
INSERT INTO `auth_permission` VALUES (67, 'Can delete hear detail image', 17, 'delete_heardetailimage');
INSERT INTO `auth_permission` VALUES (68, 'Can view hear detail image', 17, 'view_heardetailimage');
INSERT INTO `auth_permission` VALUES (69, 'Can add 合作机构详情', 18, 'add_petcooperatedetail');
INSERT INTO `auth_permission` VALUES (70, 'Can change 合作机构详情', 18, 'change_petcooperatedetail');
INSERT INTO `auth_permission` VALUES (71, 'Can delete 合作机构详情', 18, 'delete_petcooperatedetail');
INSERT INTO `auth_permission` VALUES (72, 'Can view 合作机构详情', 18, 'view_petcooperatedetail');
INSERT INTO `auth_permission` VALUES (73, 'Can add 合作机构信息', 19, 'add_petcooperateinfo');
INSERT INTO `auth_permission` VALUES (74, 'Can change 合作机构信息', 19, 'change_petcooperateinfo');
INSERT INTO `auth_permission` VALUES (75, 'Can delete 合作机构信息', 19, 'delete_petcooperateinfo');
INSERT INTO `auth_permission` VALUES (76, 'Can view 合作机构信息', 19, 'view_petcooperateinfo');
INSERT INTO `auth_permission` VALUES (77, 'Can add 合作机构详情图片', 20, 'add_petcooperatedescimg');
INSERT INTO `auth_permission` VALUES (78, 'Can change 合作机构详情图片', 20, 'change_petcooperatedescimg');
INSERT INTO `auth_permission` VALUES (79, 'Can delete 合作机构详情图片', 20, 'delete_petcooperatedescimg');
INSERT INTO `auth_permission` VALUES (80, 'Can view 合作机构详情图片', 20, 'view_petcooperatedescimg');
INSERT INTO `auth_permission` VALUES (81, 'Can add 缅怀logo', 21, 'add_heartlogo');
INSERT INTO `auth_permission` VALUES (82, 'Can change 缅怀logo', 21, 'change_heartlogo');
INSERT INTO `auth_permission` VALUES (83, 'Can delete 缅怀logo', 21, 'delete_heartlogo');
INSERT INTO `auth_permission` VALUES (84, 'Can view 缅怀logo', 21, 'view_heartlogo');
INSERT INTO `auth_permission` VALUES (85, 'Can add 缅怀详情图片', 17, 'add_heartdetailimage');
INSERT INTO `auth_permission` VALUES (86, 'Can change 缅怀详情图片', 17, 'change_heartdetailimage');
INSERT INTO `auth_permission` VALUES (87, 'Can delete 缅怀详情图片', 17, 'delete_heartdetailimage');
INSERT INTO `auth_permission` VALUES (88, 'Can view 缅怀详情图片', 17, 'view_heartdetailimage');

-- ----------------------------
-- Table structure for auth_user
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_login` datetime(6) NULL DEFAULT NULL,
  `is_superuser` tinyint(1) NOT NULL,
  `username` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `first_name` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_name` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_staff` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `date_joined` datetime(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_user
-- ----------------------------
INSERT INTO `auth_user` VALUES (1, 'pbkdf2_sha256$320000$pSYjoaTKlVzIvxf64Ox9j4$hqxbifnkZjKp1A1IGJwi/bGQwXxFtj828oYcKEgzv1I=', '2022-04-26 05:34:31.156819', 1, 'lqs', '', '', '24235@qq.com', 1, 1, '2022-04-09 08:56:27.690154');

-- ----------------------------
-- Table structure for auth_user_groups
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_groups`;
CREATE TABLE `auth_user_groups`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `group_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `auth_user_groups_user_id_group_id_94350c0c_uniq`(`user_id` ASC, `group_id` ASC) USING BTREE,
  INDEX `auth_user_groups_group_id_97559544_fk_auth_group_id`(`group_id` ASC) USING BTREE,
  CONSTRAINT `auth_user_groups_group_id_97559544_fk_auth_group_id` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `auth_user_groups_user_id_6a12ed8b_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_user_groups
-- ----------------------------

-- ----------------------------
-- Table structure for auth_user_user_permissions
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_user_permissions`;
CREATE TABLE `auth_user_user_permissions`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `permission_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `auth_user_user_permissions_user_id_permission_id_14a6b632_uniq`(`user_id` ASC, `permission_id` ASC) USING BTREE,
  INDEX `auth_user_user_permi_permission_id_1fbb5f2c_fk_auth_perm`(`permission_id` ASC) USING BTREE,
  CONSTRAINT `auth_user_user_permi_permission_id_1fbb5f2c_fk_auth_perm` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `auth_user_user_permissions_user_id_a95ead1b_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_user_user_permissions
-- ----------------------------

-- ----------------------------
-- Table structure for cooperate_desc_img
-- ----------------------------
DROP TABLE IF EXISTS `cooperate_desc_img`;
CREATE TABLE `cooperate_desc_img`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `alter_time` datetime(6) NULL DEFAULT NULL,
  `del_mark` tinyint(1) NULL DEFAULT NULL,
  `desc_img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cooperate_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cooperate_desc_img_cooperate_id_5539269f_fk_cooperate_info_id`(`cooperate_id` ASC) USING BTREE,
  CONSTRAINT `cooperate_desc_img_cooperate_id_5539269f_fk_cooperate_info_id` FOREIGN KEY (`cooperate_id`) REFERENCES `cooperate_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cooperate_desc_img
-- ----------------------------
INSERT INTO `cooperate_desc_img` VALUES (2, '2022-04-22 07:10:19.766231', '2022-04-22 07:10:19.766231', 0, 'la1_AYltHRT.jpg', 1);
INSERT INTO `cooperate_desc_img` VALUES (3, '2022-04-22 07:24:07.212634', '2022-04-22 07:24:07.213610', 0, 'fire5_W0rfsO2.jpg', 1);

-- ----------------------------
-- Table structure for cooperate_info
-- ----------------------------
DROP TABLE IF EXISTS `cooperate_info`;
CREATE TABLE `cooperate_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `alter_time` datetime(6) NULL DEFAULT NULL,
  `del_mark` tinyint(1) NULL DEFAULT NULL,
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `logo` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `contact` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `desc` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cooperate_info
-- ----------------------------
INSERT INTO `cooperate_info` VALUES (1, '2022-04-20 11:46:48.423735', '2022-04-22 07:34:45.163543', 0, '金龙宠物医院', '纪念品4_NUqGNzc.png', '17398827615', '四川省成都市双流区正兴镇大安路818号', '市场经济环境下，宠物店经营者渐多。有志于向宠物店方向发展的投资者，不免对宠物店投资成本存在些许困惑，本文将为大家简要介绍宠物店的投资金额及相应收益。\r\n★基本条件：\r\n地理：附近要有一些收入水平较高的小区，确认有比较多的“好狗之徒”可以成为你的潜在目标客户。\r\n物业：宠物店铺的物业管理要求比较高，第一，不能让狗吠叫扰民，建议选择背靠住宅区，面向大马路的店面。第二，必须要准备效果好的通风器材，排出狗狗异味；第三，狗狗美容，还须准备排污口、消毒筒和紫光杀菌灯。\r\n面积：50到100平方米，市中心的年租金在7万到10万。\r\n手续：普通宠物用品店只需经过工商局批准；如果要做美容，要得到兽医卫生防疫站卫生防疫许可证。\r\n★投资收益估算：\r\n投入：租用店面一年85000元、布置一个美容间，有美容桌三张，每张各1000元，一套美容工具3000元，一个烘箱10000多元，另外的装修布置、物业设备、进货存储基本在15万到16万左右。\r\n产出：总体净利润在15%左右。其中，宠物粮食的利润最低为5%左右。宠物美容的利润较高，除了美容师的工资和美容工具外，几乎不需要其他成本。\r\n收回投资：按照市中心某家宠物店的经营状况，1年半左右收回成本，第二年开始能出现盈利。\r\n风险提示：投资宠物店的回报时间比普通投资项目时间要长至少半年。光卖宠物商品利润过低，主要还是依靠美容这块来实现盈利。所以，挑选美容师和提供优质的服务是宠物商店的生存之道。');
INSERT INTO `cooperate_info` VALUES (2, '2022-04-20 11:47:50.047246', '2022-04-22 07:34:20.778174', 0, '金龙宠物店', '火化2_OfZx28k.png', '17398827615', '四川省成都市双流区正兴镇大安路818号', '市场经济环境下，宠物店经营者渐多。有志于向宠物店方向发展的投资者，不免对宠物店投资成本存在些许困惑，本文将为大家简要介绍宠物店的投资金额及相应收益。\r\n★基本条件：\r\n地理：附近要有一些收入水平较高的小区，确认有比较多的“好狗之徒”可以成为你的潜在目标客户。\r\n物业：宠物店铺的物业管理要求比较高，第一，不能让狗吠叫扰民，建议选择背靠住宅区，面向大马路的店面。第二，必须要准备效果好的通风器材，排出狗狗异味；第三，狗狗美容，还须准备排污口、消毒筒和紫光杀菌灯。\r\n\r\n面积：50到100平方米，市中心的年租金在7万到10万。\r\n手续：普通宠物用品店只需经过工商局批准；如果要做美容，要得到兽医卫生防疫站卫生防疫许可证。\r\n★投资收益估算：\r\n投入：租用店面一年85000元、布置一个美容间，有美容桌三张，每张各1000元，一套美容工具3000元，一个烘箱10000多元，另外的装修布置、物业设备、进货存储基本在15万到16万左右。\r\n产出：总体净利润在15%左右。其中，宠物粮食的利润最低为5%左右。宠物美容的利润较高，除了美容师的工资和美容工具外，几乎不需要其他成本。\r\n收回投资：按照市中心某家宠物店的经营状况，1年半左右收回成本，第二年开始能出现盈利。\r\n风险提示：投资宠物店的回报时间比普通投资项目时间要长至少半年。光卖宠物商品利润过低，主要还是依靠美容这块来实现盈利。所以，挑选美容师和提供优质的服务是宠物商店的生存之道。');

-- ----------------------------
-- Table structure for django_admin_log
-- ----------------------------
DROP TABLE IF EXISTS `django_admin_log`;
CREATE TABLE `django_admin_log`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `action_time` datetime(6) NOT NULL,
  `object_id` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `object_repr` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `action_flag` smallint UNSIGNED NOT NULL,
  `change_message` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content_type_id` int NULL DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `django_admin_log_content_type_id_c4bce8eb_fk_django_co`(`content_type_id` ASC) USING BTREE,
  INDEX `django_admin_log_user_id_c564eba6_fk_auth_user_id`(`user_id` ASC) USING BTREE,
  CONSTRAINT `django_admin_log_content_type_id_c4bce8eb_fk_django_co` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `django_admin_log_user_id_c564eba6_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `django_admin_log_chk_1` CHECK (`action_flag` >= 0)
) ENGINE = InnoDB AUTO_INCREMENT = 156 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of django_admin_log
-- ----------------------------
INSERT INTO `django_admin_log` VALUES (1, '2022-04-11 12:03:09.131024', '1', 'FileUpload object (1)', 1, '[{\"added\": {}}]', 8, 1);
INSERT INTO `django_admin_log` VALUES (2, '2022-04-11 12:24:33.954957', '2', 'FileUpload object (2)', 1, '[{\"added\": {}}]', 8, 1);
INSERT INTO `django_admin_log` VALUES (3, '2022-04-11 12:26:07.818553', '3', 'FileUpload object (3)', 1, '[{\"added\": {}}]', 8, 1);
INSERT INTO `django_admin_log` VALUES (4, '2022-04-11 12:27:56.899820', '4', 'FileUpload object (4)', 1, '[{\"added\": {}}]', 8, 1);
INSERT INTO `django_admin_log` VALUES (5, '2022-04-11 12:38:53.817720', '1', 'IndexBanner object (1)', 1, '[{\"added\": {}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (6, '2022-04-11 12:42:16.265863', '2', 'User object (2)', 1, '[{\"added\": {}}]', 7, 1);
INSERT INTO `django_admin_log` VALUES (7, '2022-04-12 06:24:18.386639', '1', 'lqs', 3, '', 9, 1);
INSERT INTO `django_admin_log` VALUES (8, '2022-04-12 06:25:04.346902', '2', '宠物缅怀', 1, '[{\"added\": {}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (9, '2022-04-12 06:25:22.097880', '3', '宠物纪念品', 1, '[{\"added\": {}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (10, '2022-04-12 06:25:42.244778', '4', '宠物树葬', 1, '[{\"added\": {}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (11, '2022-04-12 06:26:48.649354', '5', '宠物服务', 1, '[{\"added\": {}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (12, '2022-04-12 06:27:10.009984', '6', '军犬风采', 1, '[{\"added\": {}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (13, '2022-04-12 12:33:04.709618', '1', 'IndexNavigate object (1)', 1, '[{\"added\": {}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (14, '2022-04-12 12:33:46.957489', '2', '预约记录', 1, '[{\"added\": {}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (15, '2022-04-12 12:34:12.735032', '3', '宠物专车', 1, '[{\"added\": {}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (16, '2022-04-12 12:34:51.773682', '4', '仪容整理', 1, '[{\"added\": {}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (17, '2022-04-12 12:35:25.029617', '5', '告别仪式', 1, '[{\"added\": {}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (18, '2022-04-12 12:35:52.721833', '6', '纪念物品', 1, '[{\"added\": {}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (19, '2022-04-13 08:52:14.015076', '1', '宠物火化', 1, '[{\"added\": {}}]', 11, 1);
INSERT INTO `django_admin_log` VALUES (20, '2022-04-13 08:52:53.852356', '2', '宠物树葬', 1, '[{\"added\": {}}]', 11, 1);
INSERT INTO `django_admin_log` VALUES (21, '2022-04-13 08:53:12.724280', '3', '仪容整理', 1, '[{\"added\": {}}]', 11, 1);
INSERT INTO `django_admin_log` VALUES (22, '2022-04-13 08:53:33.083996', '4', '纪念物品', 1, '[{\"added\": {}}]', 11, 1);
INSERT INTO `django_admin_log` VALUES (23, '2022-04-13 10:37:31.942748', '1', '火化', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (24, '2022-04-13 10:37:39.182107', '2', '树葬', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (25, '2022-04-13 10:37:47.010725', '3', '仪容', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (26, '2022-04-13 10:37:53.213470', '4', '纪念', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (27, '2022-04-13 10:38:34.509444', '5', '火化2', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (28, '2022-04-13 10:38:40.040542', '6', '火化3', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (29, '2022-04-13 10:38:46.891893', '7', '火化4', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (30, '2022-04-13 10:39:03.304524', '8', '纪念2', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (31, '2022-04-13 10:39:08.001929', '9', '纪念3', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (32, '2022-04-13 10:39:13.918445', '10', '纪念4', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (33, '2022-04-13 10:39:23.877083', '3', '仪容', 2, '[]', 12, 1);
INSERT INTO `django_admin_log` VALUES (34, '2022-04-13 10:39:32.822310', '11', '仪容2', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (35, '2022-04-13 10:39:37.212948', '12', '仪容3', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (36, '2022-04-13 10:39:41.355338', '13', '仪容4', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (37, '2022-04-13 10:40:02.361760', '14', '树葬2', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (38, '2022-04-13 10:40:05.690887', '15', '树葬2', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (39, '2022-04-13 10:40:12.894277', '15', '树葬3', 2, '[{\"changed\": {\"fields\": [\"\\u5360\\u4f4d\"]}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (40, '2022-04-13 10:40:16.899370', '16', '树葬3', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (41, '2022-04-13 10:40:22.059467', '16', '树葬4', 2, '[{\"changed\": {\"fields\": [\"\\u5360\\u4f4d\"]}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (42, '2022-04-13 10:40:35.681416', '1', 'IndexFloorImage object (1)', 1, '[{\"added\": {}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (43, '2022-04-13 10:40:52.574202', '2', 'IndexFloorImage object (2)', 1, '[{\"added\": {}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (44, '2022-04-13 10:41:06.384995', '3', 'IndexFloorImage object (3)', 1, '[{\"added\": {}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (45, '2022-04-13 10:41:18.338810', '4', 'IndexFloorImage object (4)', 1, '[{\"added\": {}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (46, '2022-04-13 10:45:44.518821', '2', 'IndexFloorImage object (2)', 2, '[{\"changed\": {\"fields\": [\"\\u6392\\u5e8f\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (47, '2022-04-13 10:45:48.073929', '3', 'IndexFloorImage object (3)', 2, '[{\"changed\": {\"fields\": [\"\\u6392\\u5e8f\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (48, '2022-04-13 10:45:51.397018', '3', 'IndexFloorImage object (3)', 2, '[]', 13, 1);
INSERT INTO `django_admin_log` VALUES (49, '2022-04-13 10:45:56.125753', '4', 'IndexFloorImage object (4)', 2, '[{\"changed\": {\"fields\": [\"\\u6392\\u5e8f\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (50, '2022-04-13 10:46:35.297827', '1', '宠物火化', 2, '[{\"changed\": {\"fields\": [\"\\u697c\\u5c42\\u793a\\u56fe\"]}}]', 11, 1);
INSERT INTO `django_admin_log` VALUES (51, '2022-04-13 10:46:47.220520', '2', '宠物树葬', 2, '[{\"changed\": {\"fields\": [\"\\u697c\\u5c42\\u793a\\u56fe\"]}}]', 11, 1);
INSERT INTO `django_admin_log` VALUES (52, '2022-04-13 10:47:04.670755', '3', '仪容整理', 2, '[{\"changed\": {\"fields\": [\"\\u697c\\u5c42\\u793a\\u56fe\"]}}]', 11, 1);
INSERT INTO `django_admin_log` VALUES (53, '2022-04-13 10:47:16.273260', '4', '纪念物品', 2, '[{\"changed\": {\"fields\": [\"\\u697c\\u5c42\\u793a\\u56fe\"]}}]', 11, 1);
INSERT INTO `django_admin_log` VALUES (54, '2022-04-13 10:48:24.494449', '5', 'IndexFloorImage object (5)', 1, '[{\"added\": {}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (55, '2022-04-13 10:48:42.322494', '6', 'IndexFloorImage object (6)', 1, '[{\"added\": {}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (56, '2022-04-13 10:48:59.383413', '7', 'IndexFloorImage object (7)', 1, '[{\"added\": {}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (57, '2022-04-13 10:49:09.171303', '8', 'IndexFloorImage object (8)', 1, '[{\"added\": {}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (58, '2022-04-13 10:49:30.314594', '8', 'IndexFloorImage object (8)', 2, '[{\"changed\": {\"fields\": [\"\\u6240\\u6709\\u5185\\u5bb9\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (59, '2022-04-13 10:49:46.784338', '9', 'IndexFloorImage object (9)', 1, '[{\"added\": {}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (60, '2022-04-13 10:49:56.440460', '10', 'IndexFloorImage object (10)', 1, '[{\"added\": {}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (61, '2022-04-13 10:50:09.926216', '11', 'IndexFloorImage object (11)', 1, '[{\"added\": {}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (62, '2022-04-13 10:50:23.607075', '12', 'IndexFloorImage object (12)', 1, '[{\"added\": {}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (63, '2022-04-13 10:50:35.135083', '13', 'IndexFloorImage object (13)', 1, '[{\"added\": {}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (64, '2022-04-13 10:50:46.995082', '14', 'IndexFloorImage object (14)', 1, '[{\"added\": {}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (65, '2022-04-13 10:52:06.491058', '12', 'IndexFloorImage object (12)', 2, '[{\"changed\": {\"fields\": [\"\\u6240\\u6709\\u5185\\u5bb9\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (66, '2022-04-13 10:52:53.321989', '15', 'IndexFloorImage object (15)', 1, '[{\"added\": {}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (67, '2022-04-13 10:53:03.954694', '16', 'IndexFloorImage object (16)', 1, '[{\"added\": {}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (68, '2022-04-14 07:21:05.996697', '1', 'IndexFloorImage object (1)', 2, '[{\"changed\": {\"fields\": [\"\\u697c\\u5c42\\u5185\\u5bb9\\u56fe\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (69, '2022-04-14 07:21:21.318780', '2', 'IndexFloorImage object (2)', 2, '[{\"changed\": {\"fields\": [\"\\u697c\\u5c42\\u5185\\u5bb9\\u56fe\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (70, '2022-04-14 07:21:34.721133', '3', 'IndexFloorImage object (3)', 2, '[{\"changed\": {\"fields\": [\"\\u697c\\u5c42\\u5185\\u5bb9\\u56fe\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (71, '2022-04-14 07:21:47.876337', '4', 'IndexFloorImage object (4)', 2, '[{\"changed\": {\"fields\": [\"\\u697c\\u5c42\\u5185\\u5bb9\\u56fe\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (72, '2022-04-14 07:22:14.753210', '5', 'IndexFloorImage object (5)', 2, '[{\"changed\": {\"fields\": [\"\\u697c\\u5c42\\u5185\\u5bb9\\u56fe\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (73, '2022-04-14 07:22:43.930349', '6', 'IndexFloorImage object (6)', 2, '[{\"changed\": {\"fields\": [\"\\u697c\\u5c42\\u5185\\u5bb9\\u56fe\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (74, '2022-04-14 07:22:51.485860', '7', 'IndexFloorImage object (7)', 2, '[{\"changed\": {\"fields\": [\"\\u697c\\u5c42\\u5185\\u5bb9\\u56fe\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (75, '2022-04-14 07:23:06.810970', '8', 'IndexFloorImage object (8)', 2, '[{\"changed\": {\"fields\": [\"\\u697c\\u5c42\\u5185\\u5bb9\\u56fe\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (76, '2022-04-14 07:23:16.573115', '9', 'IndexFloorImage object (9)', 2, '[{\"changed\": {\"fields\": [\"\\u697c\\u5c42\\u5185\\u5bb9\\u56fe\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (77, '2022-04-14 07:23:22.711788', '9', 'IndexFloorImage object (9)', 2, '[]', 13, 1);
INSERT INTO `django_admin_log` VALUES (78, '2022-04-14 07:23:36.975094', '10', 'IndexFloorImage object (10)', 2, '[{\"changed\": {\"fields\": [\"\\u697c\\u5c42\\u5185\\u5bb9\\u56fe\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (79, '2022-04-14 07:23:47.945989', '11', 'IndexFloorImage object (11)', 2, '[{\"changed\": {\"fields\": [\"\\u697c\\u5c42\\u5185\\u5bb9\\u56fe\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (80, '2022-04-14 07:23:57.731643', '13', 'IndexFloorImage object (13)', 2, '[{\"changed\": {\"fields\": [\"\\u697c\\u5c42\\u5185\\u5bb9\\u56fe\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (81, '2022-04-14 07:24:04.499625', '12', 'IndexFloorImage object (12)', 2, '[{\"changed\": {\"fields\": [\"\\u697c\\u5c42\\u5185\\u5bb9\\u56fe\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (82, '2022-04-14 07:24:15.420581', '14', 'IndexFloorImage object (14)', 2, '[{\"changed\": {\"fields\": [\"\\u697c\\u5c42\\u5185\\u5bb9\\u56fe\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (83, '2022-04-14 07:24:22.855574', '15', 'IndexFloorImage object (15)', 2, '[{\"changed\": {\"fields\": [\"\\u697c\\u5c42\\u5185\\u5bb9\\u56fe\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (84, '2022-04-14 07:24:28.980584', '16', 'IndexFloorImage object (16)', 2, '[{\"changed\": {\"fields\": [\"\\u697c\\u5c42\\u5185\\u5bb9\\u56fe\"]}}]', 13, 1);
INSERT INTO `django_admin_log` VALUES (85, '2022-04-20 02:12:27.872322', '1', '1', 1, '[{\"added\": {}}]', 15, 1);
INSERT INTO `django_admin_log` VALUES (86, '2022-04-20 02:12:30.991762', '2', '2', 1, '[{\"added\": {}}]', 15, 1);
INSERT INTO `django_admin_log` VALUES (87, '2022-04-20 02:12:33.630281', '3', '3', 1, '[{\"added\": {}}]', 15, 1);
INSERT INTO `django_admin_log` VALUES (88, '2022-04-20 02:12:36.283208', '4', '4', 1, '[{\"added\": {}}]', 15, 1);
INSERT INTO `django_admin_log` VALUES (89, '2022-04-20 02:12:39.365058', '5', '5', 1, '[{\"added\": {}}]', 15, 1);
INSERT INTO `django_admin_log` VALUES (90, '2022-04-20 02:12:42.365937', '6', '6', 1, '[{\"added\": {}}]', 15, 1);
INSERT INTO `django_admin_log` VALUES (91, '2022-04-20 02:12:46.519391', '7', '6', 1, '[{\"added\": {}}]', 15, 1);
INSERT INTO `django_admin_log` VALUES (92, '2022-04-20 02:12:49.357124', '8', '7', 1, '[{\"added\": {}}]', 15, 1);
INSERT INTO `django_admin_log` VALUES (93, '2022-04-20 02:12:52.043808', '9', '8', 1, '[{\"added\": {}}]', 15, 1);
INSERT INTO `django_admin_log` VALUES (94, '2022-04-20 02:12:54.822789', '10', '9', 1, '[{\"added\": {}}]', 15, 1);
INSERT INTO `django_admin_log` VALUES (95, '2022-04-20 02:13:08.027026', '7', '10', 2, '[{\"changed\": {\"fields\": [\"\\u5360\\u4f4d\"]}}]', 15, 1);
INSERT INTO `django_admin_log` VALUES (96, '2022-04-20 02:13:53.084358', '1', '神犬小七', 1, '[{\"added\": {}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (97, '2022-04-20 02:53:59.591217', '2', '尚书', 1, '[{\"added\": {}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (98, '2022-04-20 03:00:17.364915', '2', 'liqisong', 2, '[{\"changed\": {\"fields\": [\"\\u7535\\u8bdd\\u53f7\\u7801\"]}}]', 7, 1);
INSERT INTO `django_admin_log` VALUES (99, '2022-04-20 03:01:49.219186', '3', '锦', 1, '[{\"added\": {}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (100, '2022-04-20 03:02:25.311081', '4', 'lqs', 1, '[{\"added\": {}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (101, '2022-04-20 03:02:42.826717', '5', '苹果', 1, '[{\"added\": {}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (102, '2022-04-20 11:46:51.077950', '1', '金龙宠物医院', 1, '[{\"added\": {}}]', 19, 1);
INSERT INTO `django_admin_log` VALUES (103, '2022-04-20 11:47:50.518351', '2', '金龙宠物店', 1, '[{\"added\": {}}]', 19, 1);
INSERT INTO `django_admin_log` VALUES (104, '2022-04-22 06:32:40.112540', '2', '金龙宠物店', 2, '[{\"changed\": {\"fields\": [\"\\u673a\\u6784\\u8be6\\u60c5\\u63cf\\u8ff0\"]}}]', 19, 1);
INSERT INTO `django_admin_log` VALUES (105, '2022-04-22 06:32:49.096178', '1', '金龙宠物医院', 2, '[{\"changed\": {\"fields\": [\"\\u673a\\u6784\\u8be6\\u60c5\\u63cf\\u8ff0\"]}}]', 19, 1);
INSERT INTO `django_admin_log` VALUES (106, '2022-04-22 07:10:21.014954', '2', '金龙宠物医院', 1, '[{\"added\": {}}]', 20, 1);
INSERT INTO `django_admin_log` VALUES (107, '2022-04-22 07:24:07.387426', '3', '金龙宠物医院', 1, '[{\"added\": {}}]', 20, 1);
INSERT INTO `django_admin_log` VALUES (108, '2022-04-22 07:31:25.353519', '1', '金龙宠物医院', 2, '[{\"changed\": {\"fields\": [\"\\u673a\\u6784\\u8be6\\u60c5\\u63cf\\u8ff0\"]}}]', 19, 1);
INSERT INTO `django_admin_log` VALUES (109, '2022-04-22 07:34:20.786959', '2', '金龙宠物店', 2, '[{\"changed\": {\"fields\": [\"\\u673a\\u6784\\u8be6\\u60c5\\u63cf\\u8ff0\"]}}]', 19, 1);
INSERT INTO `django_admin_log` VALUES (110, '2022-04-22 07:34:45.164519', '1', '金龙宠物医院', 2, '[{\"changed\": {\"fields\": [\"\\u673a\\u6784\\u8be6\\u60c5\\u63cf\\u8ff0\"]}}]', 19, 1);
INSERT INTO `django_admin_log` VALUES (111, '2022-04-26 05:35:31.054459', '6', '纪念品管', 2, '[{\"changed\": {\"fields\": [\"\\u5bfc\\u822a\\u540d\\u79f0\", \"\\u5bfc\\u822a\\u56fe\\u7247\"]}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (112, '2022-04-26 05:35:58.677912', '1', '客户预约', 2, '[{\"changed\": {\"fields\": [\"\\u5bfc\\u822a\\u540d\\u79f0\", \"\\u5bfc\\u822a\\u56fe\\u7247\"]}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (113, '2022-04-26 05:36:23.609633', '2', '我的预约', 2, '[{\"changed\": {\"fields\": [\"\\u5bfc\\u822a\\u540d\\u79f0\", \"\\u5bfc\\u822a\\u56fe\\u7247\"]}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (114, '2022-04-26 05:36:34.531984', '3', '宠物专车', 2, '[{\"changed\": {\"fields\": [\"\\u5bfc\\u822a\\u56fe\\u7247\"]}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (115, '2022-04-26 06:12:20.620654', '5', '苹果', 2, '[{\"changed\": {\"fields\": [\"\\u6807\\u9898\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (116, '2022-04-26 06:12:27.211121', '4', 'lqs', 2, '[{\"changed\": {\"fields\": [\"\\u6807\\u9898\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (117, '2022-04-26 06:12:33.736903', '3', '锦', 2, '[{\"changed\": {\"fields\": [\"\\u6807\\u9898\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (118, '2022-04-26 06:12:42.684429', '2', '尚书', 2, '[{\"changed\": {\"fields\": [\"\\u6807\\u9898\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (119, '2022-04-26 06:12:49.430973', '1', '神犬小七', 2, '[{\"changed\": {\"fields\": [\"\\u6807\\u9898\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (120, '2022-04-26 06:13:37.777708', '1', '宠物狗', 1, '[{\"added\": {}}]', 21, 1);
INSERT INTO `django_admin_log` VALUES (121, '2022-04-26 06:13:49.702121', '2', '宠物猫', 1, '[{\"added\": {}}]', 21, 1);
INSERT INTO `django_admin_log` VALUES (122, '2022-04-26 06:14:01.412369', '3', '功勋犬', 1, '[{\"added\": {}}]', 21, 1);
INSERT INTO `django_admin_log` VALUES (123, '2022-04-26 07:26:21.011384', '6', '现场结尾', 1, '[{\"added\": {}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (124, '2022-04-26 07:33:35.542793', '6', '现场结尾', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u5c55\\u793a\\u56fe\\u7247\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (125, '2022-04-26 07:33:49.098447', '5', '苹果', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u5c55\\u793a\\u56fe\\u7247\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (126, '2022-04-26 07:33:57.225781', '4', 'lqs', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u5c55\\u793a\\u56fe\\u7247\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (127, '2022-04-26 07:34:08.005444', '3', '锦', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u5c55\\u793a\\u56fe\\u7247\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (128, '2022-04-26 07:34:15.942181', '2', '尚书', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u5c55\\u793a\\u56fe\\u7247\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (129, '2022-04-26 07:34:24.294777', '1', '神犬小七', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u5c55\\u793a\\u56fe\\u7247\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (130, '2022-04-26 07:56:34.096251', '6', '现场结尾', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u5c55\\u793a\\u56fe\\u7247\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (131, '2022-04-26 07:57:06.736885', '5', '苹果', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u5c55\\u793a\\u56fe\\u7247\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (132, '2022-04-26 07:57:28.372976', '4', 'lqs', 2, '[{\"changed\": {\"fields\": [\"\\u6807\\u9898\", \"\\u5ba0\\u7269\\u5c55\\u793a\\u56fe\\u7247\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (133, '2022-04-26 07:57:41.017924', '3', '锦', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u5c55\\u793a\\u56fe\\u7247\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (134, '2022-04-26 07:57:59.475423', '2', '尚书', 2, '[{\"changed\": {\"fields\": [\"\\u6807\\u9898\", \"\\u5ba0\\u7269\\u5c55\\u793a\\u56fe\\u7247\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (135, '2022-04-26 07:58:12.398972', '1', '神犬小七', 2, '[{\"changed\": {\"fields\": [\"\\u6807\\u9898\", \"\\u5ba0\\u7269\\u5c55\\u793a\\u56fe\\u7247\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (136, '2022-04-26 07:58:57.741820', '7', 'gtg', 1, '[{\"added\": {}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (137, '2022-04-26 08:06:39.096189', '4', '个人的', 1, '[{\"added\": {}}]', 21, 1);
INSERT INTO `django_admin_log` VALUES (138, '2022-04-26 10:34:00.383659', '2', '神犬小七', 1, '[{\"added\": {}}]', 17, 1);
INSERT INTO `django_admin_log` VALUES (139, '2022-04-26 10:35:16.783174', '3', '神犬小七', 1, '[{\"added\": {}}]', 17, 1);
INSERT INTO `django_admin_log` VALUES (140, '2022-04-27 00:52:16.629677', '1', '果果', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u540d\\u79f0\", \"\\u5ba0\\u7269\\u63cf\\u8ff0\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (141, '2022-04-27 00:52:33.375379', '3', '果果', 2, '[{\"changed\": {\"fields\": [\"\\u63cf\\u8ff0\\u56fe\\u7247\"]}}]', 17, 1);
INSERT INTO `django_admin_log` VALUES (142, '2022-04-27 00:52:42.630149', '2', '果果', 2, '[{\"changed\": {\"fields\": [\"\\u63cf\\u8ff0\\u56fe\\u7247\"]}}]', 17, 1);
INSERT INTO `django_admin_log` VALUES (143, '2022-04-27 00:53:18.291189', '1', '果果', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u63cf\\u8ff0\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (144, '2022-04-27 00:54:28.867255', '2', '尚书', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u63cf\\u8ff0\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (145, '2022-04-27 00:54:40.012599', '3', '锦', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u63cf\\u8ff0\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (146, '2022-04-27 00:54:51.730991', '4', 'lqs', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u63cf\\u8ff0\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (147, '2022-04-27 00:55:01.917356', '5', '苹果', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u63cf\\u8ff0\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (148, '2022-04-27 00:55:08.355512', '6', '现场结尾', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u63cf\\u8ff0\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (149, '2022-04-27 00:55:14.804679', '7', 'gtg', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u63cf\\u8ff0\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (150, '2022-04-27 00:55:26.355601', '7', '子弹', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u540d\\u79f0\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (151, '2022-04-27 00:55:39.314225', '6', '黑虎', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u540d\\u79f0\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (152, '2022-04-27 00:55:57.610122', '5', '调调', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u540d\\u79f0\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (153, '2022-04-27 00:56:12.130019', '4', '小菲', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u540d\\u79f0\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (154, '2022-04-27 00:56:27.112952', '3', '果酱', 2, '[{\"changed\": {\"fields\": [\"\\u5ba0\\u7269\\u540d\\u79f0\"]}}]', 16, 1);
INSERT INTO `django_admin_log` VALUES (155, '2022-04-28 06:50:06.112382', '3', '宠物纪念品', 2, '[{\"changed\": {\"fields\": [\"Banner\\u56fe\"]}}]', 9, 1);

-- ----------------------------
-- Table structure for django_content_type
-- ----------------------------
DROP TABLE IF EXISTS `django_content_type`;
CREATE TABLE `django_content_type`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `app_label` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `model` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `django_content_type_app_label_model_76bd3d3b_uniq`(`app_label` ASC, `model` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of django_content_type
-- ----------------------------
INSERT INTO `django_content_type` VALUES (1, 'admin', 'logentry');
INSERT INTO `django_content_type` VALUES (3, 'auth', 'group');
INSERT INTO `django_content_type` VALUES (2, 'auth', 'permission');
INSERT INTO `django_content_type` VALUES (4, 'auth', 'user');
INSERT INTO `django_content_type` VALUES (5, 'contenttypes', 'contenttype');
INSERT INTO `django_content_type` VALUES (6, 'sessions', 'session');
INSERT INTO `django_content_type` VALUES (8, 'userBack', 'fileupload');
INSERT INTO `django_content_type` VALUES (15, 'userBack', 'heartdetail');
INSERT INTO `django_content_type` VALUES (17, 'userBack', 'heartdetailimage');
INSERT INTO `django_content_type` VALUES (16, 'userBack', 'heartinfo');
INSERT INTO `django_content_type` VALUES (21, 'userBack', 'heartlogo');
INSERT INTO `django_content_type` VALUES (9, 'userBack', 'indexbanner');
INSERT INTO `django_content_type` VALUES (11, 'userBack', 'indexfloor');
INSERT INTO `django_content_type` VALUES (12, 'userBack', 'indexfloordetail');
INSERT INTO `django_content_type` VALUES (13, 'userBack', 'indexfloorimage');
INSERT INTO `django_content_type` VALUES (10, 'userBack', 'indexnavigate');
INSERT INTO `django_content_type` VALUES (20, 'userBack', 'petcooperatedescimg');
INSERT INTO `django_content_type` VALUES (18, 'userBack', 'petcooperatedetail');
INSERT INTO `django_content_type` VALUES (19, 'userBack', 'petcooperateinfo');
INSERT INTO `django_content_type` VALUES (14, 'userBack', 'petinfo');
INSERT INTO `django_content_type` VALUES (7, 'userBack', 'user');

-- ----------------------------
-- Table structure for django_migrations
-- ----------------------------
DROP TABLE IF EXISTS `django_migrations`;
CREATE TABLE `django_migrations`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `app` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `applied` datetime(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of django_migrations
-- ----------------------------
INSERT INTO `django_migrations` VALUES (1, 'contenttypes', '0001_initial', '2022-04-09 08:55:01.866794');
INSERT INTO `django_migrations` VALUES (2, 'auth', '0001_initial', '2022-04-09 08:55:02.249386');
INSERT INTO `django_migrations` VALUES (3, 'admin', '0001_initial', '2022-04-09 08:55:02.345065');
INSERT INTO `django_migrations` VALUES (4, 'admin', '0002_logentry_remove_auto_add', '2022-04-09 08:55:02.353818');
INSERT INTO `django_migrations` VALUES (5, 'admin', '0003_logentry_add_action_flag_choices', '2022-04-09 08:55:02.361660');
INSERT INTO `django_migrations` VALUES (6, 'contenttypes', '0002_remove_content_type_name', '2022-04-09 08:55:02.429979');
INSERT INTO `django_migrations` VALUES (7, 'auth', '0002_alter_permission_name_max_length', '2022-04-09 08:55:02.473999');
INSERT INTO `django_migrations` VALUES (8, 'auth', '0003_alter_user_email_max_length', '2022-04-09 08:55:02.525728');
INSERT INTO `django_migrations` VALUES (9, 'auth', '0004_alter_user_username_opts', '2022-04-09 08:55:02.534512');
INSERT INTO `django_migrations` VALUES (10, 'auth', '0005_alter_user_last_login_null', '2022-04-09 08:55:02.575529');
INSERT INTO `django_migrations` VALUES (11, 'auth', '0006_require_contenttypes_0002', '2022-04-09 08:55:02.580383');
INSERT INTO `django_migrations` VALUES (12, 'auth', '0007_alter_validators_add_error_messages', '2022-04-09 08:55:02.588216');
INSERT INTO `django_migrations` VALUES (13, 'auth', '0008_alter_user_username_max_length', '2022-04-09 08:55:02.648764');
INSERT INTO `django_migrations` VALUES (14, 'auth', '0009_alter_user_last_name_max_length', '2022-04-09 08:55:02.696621');
INSERT INTO `django_migrations` VALUES (15, 'auth', '0010_alter_group_name_max_length', '2022-04-09 08:55:02.739557');
INSERT INTO `django_migrations` VALUES (16, 'auth', '0011_update_proxy_permissions', '2022-04-09 08:55:02.750408');
INSERT INTO `django_migrations` VALUES (17, 'auth', '0012_alter_user_first_name_max_length', '2022-04-09 08:55:02.834311');
INSERT INTO `django_migrations` VALUES (18, 'sessions', '0001_initial', '2022-04-09 08:55:02.882135');
INSERT INTO `django_migrations` VALUES (19, 'userBack', '0001_initial', '2022-04-09 08:55:02.902630');
INSERT INTO `django_migrations` VALUES (20, 'userBack', '0002_alter_user_table', '2022-04-09 08:55:02.918273');
INSERT INTO `django_migrations` VALUES (21, 'userBack', '0003_fileupload', '2022-04-11 11:25:30.232863');
INSERT INTO `django_migrations` VALUES (22, 'userBack', '0004_fileupload_image2', '2022-04-11 12:25:43.025267');
INSERT INTO `django_migrations` VALUES (23, 'userBack', '0005_indexbanner_delete_fileupload_alter_user_options_and_more', '2022-04-11 12:38:17.120944');
INSERT INTO `django_migrations` VALUES (24, 'userBack', '0006_remove_indexbanner_alter_time_remove_user_alter_time_and_more', '2022-04-11 12:41:45.371339');
INSERT INTO `django_migrations` VALUES (25, 'userBack', '0007_alter_indexbanner_create_time_and_more', '2022-04-11 12:44:46.452481');
INSERT INTO `django_migrations` VALUES (26, 'userBack', '0008_rename_update_time_indexbanner_alter_time_and_more', '2022-04-12 05:28:32.502231');
INSERT INTO `django_migrations` VALUES (27, 'userBack', '0009_indexnavigate', '2022-04-12 12:31:44.973054');
INSERT INTO `django_migrations` VALUES (28, 'userBack', '0010_indexfloor_indexfloordetail_indexfloorimage', '2022-04-13 08:42:23.646655');
INSERT INTO `django_migrations` VALUES (29, 'userBack', '0011_alter_indexfloordetail_options_and_more', '2022-04-13 08:45:07.674535');
INSERT INTO `django_migrations` VALUES (30, 'userBack', '0012_indexfloorimage_floor_img', '2022-04-13 08:49:42.267680');
INSERT INTO `django_migrations` VALUES (31, 'userBack', '0013_indexfloordetail_name', '2022-04-13 09:53:52.163407');
INSERT INTO `django_migrations` VALUES (32, 'userBack', '0014_heartdetail_petinfo_heartinfo', '2022-04-20 02:09:12.596524');
INSERT INTO `django_migrations` VALUES (33, 'userBack', '0015_alter_heartdetail_options_alter_heartdetail_table', '2022-04-20 02:10:39.939846');
INSERT INTO `django_migrations` VALUES (34, 'userBack', '0016_heardetailimage_petcooperateinfo_petcooperatedetail', '2022-04-20 11:44:35.565099');
INSERT INTO `django_migrations` VALUES (35, 'userBack', '0017_petcooperatedescimg_petcooperateinfo_desc_and_more', '2022-04-22 06:31:29.689105');
INSERT INTO `django_migrations` VALUES (36, 'userBack', '0018_heartlogo_alter_heartinfo_title', '2022-04-26 06:09:46.339417');
INSERT INTO `django_migrations` VALUES (37, 'userBack', '0019_rename_heardetailimage_heartdetailimage_and_more', '2022-04-26 06:11:34.381179');
INSERT INTO `django_migrations` VALUES (38, 'userBack', '0020_heartinfo_pet_topic', '2022-04-26 07:30:39.791239');
INSERT INTO `django_migrations` VALUES (39, 'userBack', '0021_alter_heartinfo_pet_topic', '2022-04-26 07:31:57.011519');
INSERT INTO `django_migrations` VALUES (40, 'userBack', '0022_alter_heartinfo_title', '2022-04-26 08:05:28.491366');
INSERT INTO `django_migrations` VALUES (41, 'userBack', '0023_alter_heartinfo_title_alter_heartlogo_title', '2022-04-26 08:06:15.016198');
INSERT INTO `django_migrations` VALUES (42, 'userBack', '0024_rename_detail_heartinfo_detail_id', '2022-04-26 09:14:57.751404');
INSERT INTO `django_migrations` VALUES (43, 'userBack', '0025_rename_detail_id_heartinfo_detail', '2022-04-26 09:14:57.869500');
INSERT INTO `django_migrations` VALUES (44, 'userBack', '0022_remove_heartinfo_detail_heartdetailimage_heart_and_more', '2022-04-26 09:37:20.343430');
INSERT INTO `django_migrations` VALUES (45, 'userBack', '0023_remove_heartinfo_detail_delete_heartdetail', '2022-04-26 09:38:18.167540');

-- ----------------------------
-- Table structure for django_session
-- ----------------------------
DROP TABLE IF EXISTS `django_session`;
CREATE TABLE `django_session`  (
  `session_key` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `session_data` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `expire_date` datetime(6) NOT NULL,
  PRIMARY KEY (`session_key`) USING BTREE,
  INDEX `django_session_expire_date_a5c62663`(`expire_date` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of django_session
-- ----------------------------
INSERT INTO `django_session` VALUES ('103v7g419vfy2n571gwbhoit3gmqu8a2', '.eJxVjMEOwiAQRP-FsyEg0LIevfsNZNldpGrapLQn47_bJj1o5jbvzbxVwnWpaW0yp4HVRVl1-u0y0lPGHfADx_ukaRqXech6V_RBm75NLK_r4f4dVGx1W4PnTCaIMyzF9YXtlgDQOQudiY6MIHgpiDEb60sfgBx4oDPlwi6qzxfwtThA:1njDqJ:OuK2R6dSo4sdYYMQF4Bzu3eqhAwQe2DQh-wwXV31gB4', '2022-05-10 05:34:31.160721');
INSERT INTO `django_session` VALUES ('tsqb784v58wgwm8h5dpaf64zv1ip1jrx', '.eJxVjMEOwiAQRP-FsyEg0LIevfsNZNldpGrapLQn47_bJj1o5jbvzbxVwnWpaW0yp4HVRVl1-u0y0lPGHfADx_ukaRqXech6V_RBm75NLK_r4f4dVGx1W4PnTCaIMyzF9YXtlgDQOQudiY6MIHgpiDEb60sfgBx4oDPlwi6qzxfwtThA:1nd6td:Ve0780gi9-dIwEsHH5_wlqAzTOwADbhTagBLoXHq0rs', '2022-04-23 08:56:41.846430');

-- ----------------------------
-- Table structure for heart_detail_image
-- ----------------------------
DROP TABLE IF EXISTS `heart_detail_image`;
CREATE TABLE `heart_detail_image`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `alter_time` datetime(6) NULL DEFAULT NULL,
  `del_mark` tinyint(1) NULL DEFAULT NULL,
  `heart_id` bigint NOT NULL,
  `img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `heart_detail_image_heart_id_fcfd7549_fk_heart_info_id`(`heart_id` ASC) USING BTREE,
  CONSTRAINT `heart_detail_image_heart_id_fcfd7549_fk_heart_info_id` FOREIGN KEY (`heart_id`) REFERENCES `heart_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of heart_detail_image
-- ----------------------------
INSERT INTO `heart_detail_image` VALUES (2, '2022-04-26 10:33:59.395885', '2022-04-27 00:52:42.480618', 0, 1, '猫_tfCOYkV.jpg');
INSERT INTO `heart_detail_image` VALUES (3, '2022-04-26 10:35:16.430230', '2022-04-27 00:52:32.954330', 0, 1, '猫_3_AYfADKY.jpg');

-- ----------------------------
-- Table structure for heart_info
-- ----------------------------
DROP TABLE IF EXISTS `heart_info`;
CREATE TABLE `heart_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `alter_time` datetime(6) NULL DEFAULT NULL,
  `del_mark` tinyint(1) NULL DEFAULT NULL,
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int NOT NULL,
  `color` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `desc` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `user_id` bigint NOT NULL,
  `pet_topic` varchar(101) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `heart_info_user_id_746fd4a1_fk_user_id`(`user_id` ASC) USING BTREE,
  CONSTRAINT `heart_info_user_id_746fd4a1_fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of heart_info
-- ----------------------------
INSERT INTO `heart_info` VALUES (1, '2022-04-20 02:13:53.083381', '2022-04-27 00:53:18.289237', 0, '宠物猫', '果果', 20, '黑色', '据说，仙界的猫也是要定期轮班到凡间当值的，谁都偷不了懒，要期限满了才能重回仙界。当然大部分时候，它们都只是假装成一只普通的猫咪，窝在各自的铲屎官那里，吃饭睡觉装高冷，偶尔再牺牲下色相被撸个毛什么的，日子过的挺开心。不过呢，眼前这只下凡的猫咪，这几日就不怎么开心。先前躲在家中角落里的几只小耗子，最近好像聪明得成精了似的，每天晚上都不出来陪它玩耍，不知道藏哪儿去了。 虽然家里有高级猫粮备着，不愁吃喝，也有玩具备着，可终究都是死物，没了活物做玩具，实在无聊的很。失了乐子的猫咪正趴窗台上郁闷着呢，突然家里大门打开，走进来一个看起来刚从大学毕业没多久，还透着几分稚嫩气的年轻姑娘。是铲屎官下班回来了，也是一副蔫儿了吧唧的傻模样。蔫儿人和无聊猫凑在一起，氛围真是特别丧，哪怕一人一猫竭力打起精神，相互逗弄，那团丧气也消不了。很快他们就停止了相互讨好，各犯各的愁去了。但在烦闷之余，猫咪还是抽出几分心思，偷听自家铲屎官跟远方的好友打电话，言语间尽是对公司里那位恶主管的诉苦抱怨，好不委屈。猫咪默默听了，没有马上反应，一直等半夜铲屎官睡熟了，再摇身一变，化出原型。说实话，它本来只想敷衍了事地把历练的期限混满，没想多管闲事。但眼下铲屎官都在外面受委屈了，这事不能不管。只见一道巨大的黑影从窗中跃出，甩动着毛茸茸的大尾巴，在沉睡的城市上空轻盈跳跃，转眼间就从城市的一头到了另一头。正是那位恶主管的住处。黑影窜进那恶主管的梦里，稍微一阵折腾恐吓，那没骨气的家伙就抖得跟只被猫儿玩弄的小耗子似的，连连求饶。“看你还敢不敢乱欺负人！”猫咪仙人绷着脸色呵斥道。“没看见我的铲屎官最近都不开心了吗？”恶主管吓得脸色发青，发誓赌咒说再也不敢欺负部门新来的小姑娘了。猫咪仙人满意地从梦境跳回现实，看那长相油腻猥琐的男子躺床上，双眼紧闭，满头大汗，似乎仍被纠缠在噩梦里。这样应该足够让他醒来以后也心有戚戚，不会再敢作恶了。猫咪仙人得意地舔舔爪子，又从窗口跃出，原路返回，跳至铲屎官所住之处的窗台，重新化作一只人畜无害的小猫咪。屋子里没开灯，却传来些奇怪的动静。猫咪仙人扒着窗台悄悄往里望。它的铲屎官，那个看起来再普通不过的年轻姑娘，趁着猫咪仙人不在，化回了原型——她竟然也是位被派来凡间历练的真仙子——盘腿坐在地板上，面前围了几只小耗子。都是成了精的，伏在仙子面前，抖得跟筛子似的。“我说，你们也配合一下，别成天东躲西藏的，该出来陪玩的时候就得出来啊！”仙子绷着脸色呵斥道。“没看见我养的猫最近都不开心了吗？”', 1, '猫_4.jpg');
INSERT INTO `heart_info` VALUES (2, '2022-04-20 02:53:59.588290', '2022-04-27 00:54:28.865282', 0, '宠物猫', '尚书', 21, '黑色', '据说，仙界的猫也是要定期轮班到凡间当值的，谁都偷不了懒，要期限满了才能重回仙界。当然大部分时候，它们都只是假装成一只普通的猫咪，窝在各自的铲屎官那里，吃饭睡觉装高冷，偶尔再牺牲下色相被撸个毛什么的，日子过的挺开心。不过呢，眼前这只下凡的猫咪，这几日就不怎么开心。先前躲在家中角落里的几只小耗子，最近好像聪明得成精了似的，每天晚上都不出来陪它玩耍，不知道藏哪儿去了。 虽然家里有高级猫粮备着，不愁吃喝，也有玩具备着，可终究都是死物，没了活物做玩具，实在无聊的很。失了乐子的猫咪正趴窗台上郁闷着呢，突然家里大门打开，走进来一个看起来刚从大学毕业没多久，还透着几分稚嫩气的年轻姑娘。是铲屎官下班回来了，也是一副蔫儿了吧唧的傻模样。蔫儿人和无聊猫凑在一起，氛围真是特别丧，哪怕一人一猫竭力打起精神，相互逗弄，那团丧气也消不了。很快他们就停止了相互讨好，各犯各的愁去了。但在烦闷之余，猫咪还是抽出几分心思，偷听自家铲屎官跟远方的好友打电话，言语间尽是对公司里那位恶主管的诉苦抱怨，好不委屈。猫咪默默听了，没有马上反应，一直等半夜铲屎官睡熟了，再摇身一变，化出原型。说实话，它本来只想敷衍了事地把历练的期限混满，没想多管闲事。但眼下铲屎官都在外面受委屈了，这事不能不管。只见一道巨大的黑影从窗中跃出，甩动着毛茸茸的大尾巴，在沉睡的城市上空轻盈跳跃，转眼间就从城市的一头到了另一头。正是那位恶主管的住处。黑影窜进那恶主管的梦里，稍微一阵折腾恐吓，那没骨气的家伙就抖得跟只被猫儿玩弄的小耗子似的，连连求饶。“看你还敢不敢乱欺负人！”猫咪仙人绷着脸色呵斥道。“没看见我的铲屎官最近都不开心了吗？”恶主管吓得脸色发青，发誓赌咒说再也不敢欺负部门新来的小姑娘了。猫咪仙人满意地从梦境跳回现实，看那长相油腻猥琐的男子躺床上，双眼紧闭，满头大汗，似乎仍被纠缠在噩梦里。这样应该足够让他醒来以后也心有戚戚，不会再敢作恶了。猫咪仙人得意地舔舔爪子，又从窗口跃出，原路返回，跳至铲屎官所住之处的窗台，重新化作一只人畜无害的小猫咪。屋子里没开灯，却传来些奇怪的动静。猫咪仙人扒着窗台悄悄往里望。它的铲屎官，那个看起来再普通不过的年轻姑娘，趁着猫咪仙人不在，化回了原型——她竟然也是位被派来凡间历练的真仙子——盘腿坐在地板上，面前围了几只小耗子。都是成了精的，伏在仙子面前，抖得跟筛子似的。“我说，你们也配合一下，别成天东躲西藏的，该出来陪玩的时候就得出来啊！”仙子绷着脸色呵斥道。“没看见我养的猫最近都不开心了吗？”', 1, '猫_3.jpg');
INSERT INTO `heart_info` VALUES (3, '2022-04-20 03:01:49.209426', '2022-04-27 00:56:27.111976', 0, '宠物猫', '果酱', 4, '黑色', '据说，仙界的猫也是要定期轮班到凡间当值的，谁都偷不了懒，要期限满了才能重回仙界。当然大部分时候，它们都只是假装成一只普通的猫咪，窝在各自的铲屎官那里，吃饭睡觉装高冷，偶尔再牺牲下色相被撸个毛什么的，日子过的挺开心。不过呢，眼前这只下凡的猫咪，这几日就不怎么开心。先前躲在家中角落里的几只小耗子，最近好像聪明得成精了似的，每天晚上都不出来陪它玩耍，不知道藏哪儿去了。 虽然家里有高级猫粮备着，不愁吃喝，也有玩具备着，可终究都是死物，没了活物做玩具，实在无聊的很。失了乐子的猫咪正趴窗台上郁闷着呢，突然家里大门打开，走进来一个看起来刚从大学毕业没多久，还透着几分稚嫩气的年轻姑娘。是铲屎官下班回来了，也是一副蔫儿了吧唧的傻模样。蔫儿人和无聊猫凑在一起，氛围真是特别丧，哪怕一人一猫竭力打起精神，相互逗弄，那团丧气也消不了。很快他们就停止了相互讨好，各犯各的愁去了。但在烦闷之余，猫咪还是抽出几分心思，偷听自家铲屎官跟远方的好友打电话，言语间尽是对公司里那位恶主管的诉苦抱怨，好不委屈。猫咪默默听了，没有马上反应，一直等半夜铲屎官睡熟了，再摇身一变，化出原型。说实话，它本来只想敷衍了事地把历练的期限混满，没想多管闲事。但眼下铲屎官都在外面受委屈了，这事不能不管。只见一道巨大的黑影从窗中跃出，甩动着毛茸茸的大尾巴，在沉睡的城市上空轻盈跳跃，转眼间就从城市的一头到了另一头。正是那位恶主管的住处。黑影窜进那恶主管的梦里，稍微一阵折腾恐吓，那没骨气的家伙就抖得跟只被猫儿玩弄的小耗子似的，连连求饶。“看你还敢不敢乱欺负人！”猫咪仙人绷着脸色呵斥道。“没看见我的铲屎官最近都不开心了吗？”恶主管吓得脸色发青，发誓赌咒说再也不敢欺负部门新来的小姑娘了。猫咪仙人满意地从梦境跳回现实，看那长相油腻猥琐的男子躺床上，双眼紧闭，满头大汗，似乎仍被纠缠在噩梦里。这样应该足够让他醒来以后也心有戚戚，不会再敢作恶了。猫咪仙人得意地舔舔爪子，又从窗口跃出，原路返回，跳至铲屎官所住之处的窗台，重新化作一只人畜无害的小猫咪。屋子里没开灯，却传来些奇怪的动静。猫咪仙人扒着窗台悄悄往里望。它的铲屎官，那个看起来再普通不过的年轻姑娘，趁着猫咪仙人不在，化回了原型——她竟然也是位被派来凡间历练的真仙子——盘腿坐在地板上，面前围了几只小耗子。都是成了精的，伏在仙子面前，抖得跟筛子似的。“我说，你们也配合一下，别成天东躲西藏的，该出来陪玩的时候就得出来啊！”仙子绷着脸色呵斥道。“没看见我养的猫最近都不开心了吗？”', 2, '猫_2.jpg');
INSERT INTO `heart_info` VALUES (4, '2022-04-20 03:02:25.310105', '2022-04-27 00:56:12.129043', 0, '宠物猫', '小菲', 2, '黑色', '据说，仙界的猫也是要定期轮班到凡间当值的，谁都偷不了懒，要期限满了才能重回仙界。当然大部分时候，它们都只是假装成一只普通的猫咪，窝在各自的铲屎官那里，吃饭睡觉装高冷，偶尔再牺牲下色相被撸个毛什么的，日子过的挺开心。不过呢，眼前这只下凡的猫咪，这几日就不怎么开心。先前躲在家中角落里的几只小耗子，最近好像聪明得成精了似的，每天晚上都不出来陪它玩耍，不知道藏哪儿去了。 虽然家里有高级猫粮备着，不愁吃喝，也有玩具备着，可终究都是死物，没了活物做玩具，实在无聊的很。失了乐子的猫咪正趴窗台上郁闷着呢，突然家里大门打开，走进来一个看起来刚从大学毕业没多久，还透着几分稚嫩气的年轻姑娘。是铲屎官下班回来了，也是一副蔫儿了吧唧的傻模样。蔫儿人和无聊猫凑在一起，氛围真是特别丧，哪怕一人一猫竭力打起精神，相互逗弄，那团丧气也消不了。很快他们就停止了相互讨好，各犯各的愁去了。但在烦闷之余，猫咪还是抽出几分心思，偷听自家铲屎官跟远方的好友打电话，言语间尽是对公司里那位恶主管的诉苦抱怨，好不委屈。猫咪默默听了，没有马上反应，一直等半夜铲屎官睡熟了，再摇身一变，化出原型。说实话，它本来只想敷衍了事地把历练的期限混满，没想多管闲事。但眼下铲屎官都在外面受委屈了，这事不能不管。只见一道巨大的黑影从窗中跃出，甩动着毛茸茸的大尾巴，在沉睡的城市上空轻盈跳跃，转眼间就从城市的一头到了另一头。正是那位恶主管的住处。黑影窜进那恶主管的梦里，稍微一阵折腾恐吓，那没骨气的家伙就抖得跟只被猫儿玩弄的小耗子似的，连连求饶。“看你还敢不敢乱欺负人！”猫咪仙人绷着脸色呵斥道。“没看见我的铲屎官最近都不开心了吗？”恶主管吓得脸色发青，发誓赌咒说再也不敢欺负部门新来的小姑娘了。猫咪仙人满意地从梦境跳回现实，看那长相油腻猥琐的男子躺床上，双眼紧闭，满头大汗，似乎仍被纠缠在噩梦里。这样应该足够让他醒来以后也心有戚戚，不会再敢作恶了。猫咪仙人得意地舔舔爪子，又从窗口跃出，原路返回，跳至铲屎官所住之处的窗台，重新化作一只人畜无害的小猫咪。屋子里没开灯，却传来些奇怪的动静。猫咪仙人扒着窗台悄悄往里望。它的铲屎官，那个看起来再普通不过的年轻姑娘，趁着猫咪仙人不在，化回了原型——她竟然也是位被派来凡间历练的真仙子——盘腿坐在地板上，面前围了几只小耗子。都是成了精的，伏在仙子面前，抖得跟筛子似的。“我说，你们也配合一下，别成天东躲西藏的，该出来陪玩的时候就得出来啊！”仙子绷着脸色呵斥道。“没看见我养的猫最近都不开心了吗？”', 2, '猫.jpg');
INSERT INTO `heart_info` VALUES (5, '2022-04-20 03:02:42.826717', '2022-04-27 00:55:57.608170', 0, '宠物狗', '调调', 2, '黑色', '据说，仙界的猫也是要定期轮班到凡间当值的，谁都偷不了懒，要期限满了才能重回仙界。当然大部分时候，它们都只是假装成一只普通的猫咪，窝在各自的铲屎官那里，吃饭睡觉装高冷，偶尔再牺牲下色相被撸个毛什么的，日子过的挺开心。不过呢，眼前这只下凡的猫咪，这几日就不怎么开心。先前躲在家中角落里的几只小耗子，最近好像聪明得成精了似的，每天晚上都不出来陪它玩耍，不知道藏哪儿去了。 虽然家里有高级猫粮备着，不愁吃喝，也有玩具备着，可终究都是死物，没了活物做玩具，实在无聊的很。失了乐子的猫咪正趴窗台上郁闷着呢，突然家里大门打开，走进来一个看起来刚从大学毕业没多久，还透着几分稚嫩气的年轻姑娘。是铲屎官下班回来了，也是一副蔫儿了吧唧的傻模样。蔫儿人和无聊猫凑在一起，氛围真是特别丧，哪怕一人一猫竭力打起精神，相互逗弄，那团丧气也消不了。很快他们就停止了相互讨好，各犯各的愁去了。但在烦闷之余，猫咪还是抽出几分心思，偷听自家铲屎官跟远方的好友打电话，言语间尽是对公司里那位恶主管的诉苦抱怨，好不委屈。猫咪默默听了，没有马上反应，一直等半夜铲屎官睡熟了，再摇身一变，化出原型。说实话，它本来只想敷衍了事地把历练的期限混满，没想多管闲事。但眼下铲屎官都在外面受委屈了，这事不能不管。只见一道巨大的黑影从窗中跃出，甩动着毛茸茸的大尾巴，在沉睡的城市上空轻盈跳跃，转眼间就从城市的一头到了另一头。正是那位恶主管的住处。黑影窜进那恶主管的梦里，稍微一阵折腾恐吓，那没骨气的家伙就抖得跟只被猫儿玩弄的小耗子似的，连连求饶。“看你还敢不敢乱欺负人！”猫咪仙人绷着脸色呵斥道。“没看见我的铲屎官最近都不开心了吗？”恶主管吓得脸色发青，发誓赌咒说再也不敢欺负部门新来的小姑娘了。猫咪仙人满意地从梦境跳回现实，看那长相油腻猥琐的男子躺床上，双眼紧闭，满头大汗，似乎仍被纠缠在噩梦里。这样应该足够让他醒来以后也心有戚戚，不会再敢作恶了。猫咪仙人得意地舔舔爪子，又从窗口跃出，原路返回，跳至铲屎官所住之处的窗台，重新化作一只人畜无害的小猫咪。屋子里没开灯，却传来些奇怪的动静。猫咪仙人扒着窗台悄悄往里望。它的铲屎官，那个看起来再普通不过的年轻姑娘，趁着猫咪仙人不在，化回了原型——她竟然也是位被派来凡间历练的真仙子——盘腿坐在地板上，面前围了几只小耗子。都是成了精的，伏在仙子面前，抖得跟筛子似的。“我说，你们也配合一下，别成天东躲西藏的，该出来陪玩的时候就得出来啊！”仙子绷着脸色呵斥道。“没看见我养的猫最近都不开心了吗？”', 2, '狗_2.jpg');
INSERT INTO `heart_info` VALUES (6, '2022-04-26 07:26:21.001623', '2022-04-27 00:55:39.312273', 0, '宠物狗', '黑虎', 3, '白色', '据说，仙界的猫也是要定期轮班到凡间当值的，谁都偷不了懒，要期限满了才能重回仙界。当然大部分时候，它们都只是假装成一只普通的猫咪，窝在各自的铲屎官那里，吃饭睡觉装高冷，偶尔再牺牲下色相被撸个毛什么的，日子过的挺开心。不过呢，眼前这只下凡的猫咪，这几日就不怎么开心。先前躲在家中角落里的几只小耗子，最近好像聪明得成精了似的，每天晚上都不出来陪它玩耍，不知道藏哪儿去了。 虽然家里有高级猫粮备着，不愁吃喝，也有玩具备着，可终究都是死物，没了活物做玩具，实在无聊的很。失了乐子的猫咪正趴窗台上郁闷着呢，突然家里大门打开，走进来一个看起来刚从大学毕业没多久，还透着几分稚嫩气的年轻姑娘。是铲屎官下班回来了，也是一副蔫儿了吧唧的傻模样。蔫儿人和无聊猫凑在一起，氛围真是特别丧，哪怕一人一猫竭力打起精神，相互逗弄，那团丧气也消不了。很快他们就停止了相互讨好，各犯各的愁去了。但在烦闷之余，猫咪还是抽出几分心思，偷听自家铲屎官跟远方的好友打电话，言语间尽是对公司里那位恶主管的诉苦抱怨，好不委屈。猫咪默默听了，没有马上反应，一直等半夜铲屎官睡熟了，再摇身一变，化出原型。说实话，它本来只想敷衍了事地把历练的期限混满，没想多管闲事。但眼下铲屎官都在外面受委屈了，这事不能不管。只见一道巨大的黑影从窗中跃出，甩动着毛茸茸的大尾巴，在沉睡的城市上空轻盈跳跃，转眼间就从城市的一头到了另一头。正是那位恶主管的住处。黑影窜进那恶主管的梦里，稍微一阵折腾恐吓，那没骨气的家伙就抖得跟只被猫儿玩弄的小耗子似的，连连求饶。“看你还敢不敢乱欺负人！”猫咪仙人绷着脸色呵斥道。“没看见我的铲屎官最近都不开心了吗？”恶主管吓得脸色发青，发誓赌咒说再也不敢欺负部门新来的小姑娘了。猫咪仙人满意地从梦境跳回现实，看那长相油腻猥琐的男子躺床上，双眼紧闭，满头大汗，似乎仍被纠缠在噩梦里。这样应该足够让他醒来以后也心有戚戚，不会再敢作恶了。猫咪仙人得意地舔舔爪子，又从窗口跃出，原路返回，跳至铲屎官所住之处的窗台，重新化作一只人畜无害的小猫咪。屋子里没开灯，却传来些奇怪的动静。猫咪仙人扒着窗台悄悄往里望。它的铲屎官，那个看起来再普通不过的年轻姑娘，趁着猫咪仙人不在，化回了原型——她竟然也是位被派来凡间历练的真仙子——盘腿坐在地板上，面前围了几只小耗子。都是成了精的，伏在仙子面前，抖得跟筛子似的。“我说，你们也配合一下，别成天东躲西藏的，该出来陪玩的时候就得出来啊！”仙子绷着脸色呵斥道。“没看见我养的猫最近都不开心了吗？”', 1, '狗.jpg');
INSERT INTO `heart_info` VALUES (7, '2022-04-26 07:58:57.460244', '2022-04-27 00:55:26.353648', 0, '功勋犬', '子弹', 2, '白色', '据说，仙界的猫也是要定期轮班到凡间当值的，谁都偷不了懒，要期限满了才能重回仙界。当然大部分时候，它们都只是假装成一只普通的猫咪，窝在各自的铲屎官那里，吃饭睡觉装高冷，偶尔再牺牲下色相被撸个毛什么的，日子过的挺开心。不过呢，眼前这只下凡的猫咪，这几日就不怎么开心。先前躲在家中角落里的几只小耗子，最近好像聪明得成精了似的，每天晚上都不出来陪它玩耍，不知道藏哪儿去了。 虽然家里有高级猫粮备着，不愁吃喝，也有玩具备着，可终究都是死物，没了活物做玩具，实在无聊的很。失了乐子的猫咪正趴窗台上郁闷着呢，突然家里大门打开，走进来一个看起来刚从大学毕业没多久，还透着几分稚嫩气的年轻姑娘。是铲屎官下班回来了，也是一副蔫儿了吧唧的傻模样。蔫儿人和无聊猫凑在一起，氛围真是特别丧，哪怕一人一猫竭力打起精神，相互逗弄，那团丧气也消不了。很快他们就停止了相互讨好，各犯各的愁去了。但在烦闷之余，猫咪还是抽出几分心思，偷听自家铲屎官跟远方的好友打电话，言语间尽是对公司里那位恶主管的诉苦抱怨，好不委屈。猫咪默默听了，没有马上反应，一直等半夜铲屎官睡熟了，再摇身一变，化出原型。说实话，它本来只想敷衍了事地把历练的期限混满，没想多管闲事。但眼下铲屎官都在外面受委屈了，这事不能不管。只见一道巨大的黑影从窗中跃出，甩动着毛茸茸的大尾巴，在沉睡的城市上空轻盈跳跃，转眼间就从城市的一头到了另一头。正是那位恶主管的住处。黑影窜进那恶主管的梦里，稍微一阵折腾恐吓，那没骨气的家伙就抖得跟只被猫儿玩弄的小耗子似的，连连求饶。“看你还敢不敢乱欺负人！”猫咪仙人绷着脸色呵斥道。“没看见我的铲屎官最近都不开心了吗？”恶主管吓得脸色发青，发誓赌咒说再也不敢欺负部门新来的小姑娘了。猫咪仙人满意地从梦境跳回现实，看那长相油腻猥琐的男子躺床上，双眼紧闭，满头大汗，似乎仍被纠缠在噩梦里。这样应该足够让他醒来以后也心有戚戚，不会再敢作恶了。猫咪仙人得意地舔舔爪子，又从窗口跃出，原路返回，跳至铲屎官所住之处的窗台，重新化作一只人畜无害的小猫咪。屋子里没开灯，却传来些奇怪的动静。猫咪仙人扒着窗台悄悄往里望。它的铲屎官，那个看起来再普通不过的年轻姑娘，趁着猫咪仙人不在，化回了原型——她竟然也是位被派来凡间历练的真仙子——盘腿坐在地板上，面前围了几只小耗子。都是成了精的，伏在仙子面前，抖得跟筛子似的。“我说，你们也配合一下，别成天东躲西藏的，该出来陪玩的时候就得出来啊！”仙子绷着脸色呵斥道。“没看见我养的猫最近都不开心了吗？”', 2, '功勋犬.jpg');

-- ----------------------------
-- Table structure for heart_logo
-- ----------------------------
DROP TABLE IF EXISTS `heart_logo`;
CREATE TABLE `heart_logo`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `alter_time` datetime(6) NULL DEFAULT NULL,
  `del_mark` tinyint(1) NULL DEFAULT NULL,
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `logo` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of heart_logo
-- ----------------------------
INSERT INTO `heart_logo` VALUES (1, '2022-04-26 06:13:34.917496', '2022-04-26 06:13:34.917496', 0, '宠物狗', '宠物狗点开前.png');
INSERT INTO `heart_logo` VALUES (2, '2022-04-26 06:13:49.444931', '2022-04-26 06:13:49.444931', 0, '宠物猫', '宠物猫点开后.png');
INSERT INTO `heart_logo` VALUES (3, '2022-04-26 06:14:01.206611', '2022-04-26 06:14:01.206611', 0, '功勋犬', '功勋犬点开后.png');
INSERT INTO `heart_logo` VALUES (4, '2022-04-26 08:06:38.031001', '2022-04-26 08:06:38.031001', 0, '个人的', '功勋犬点开前.png');

-- ----------------------------
-- Table structure for index_banner
-- ----------------------------
DROP TABLE IF EXISTS `index_banner`;
CREATE TABLE `index_banner`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `del_mark` tinyint(1) NULL DEFAULT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `index` int NOT NULL,
  `alter_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of index_banner
-- ----------------------------
INSERT INTO `index_banner` VALUES (2, '2022-04-12 06:25:03.919360', 0, '宠物缅怀', 'remember.jpg', 1, '2022-04-12 06:25:03.919360');
INSERT INTO `index_banner` VALUES (3, '2022-04-12 06:25:21.752209', 0, '宠物纪念品', '猫_2_UAVQ6em.jpg', 2, '2022-04-28 06:50:05.873649');
INSERT INTO `index_banner` VALUES (4, '2022-04-12 06:25:41.772483', 0, '宠物树葬', 'tree.jpg', 3, '2022-04-12 06:25:41.772483');
INSERT INTO `index_banner` VALUES (5, '2022-04-12 06:26:48.200602', 0, '宠物服务', 'hot.jfif', 4, '2022-04-12 06:26:48.200602');
INSERT INTO `index_banner` VALUES (6, '2022-04-12 06:27:09.681122', 0, '军犬风采', 'luo1.jpg', 5, '2022-04-12 06:27:09.681122');

-- ----------------------------
-- Table structure for index_floor
-- ----------------------------
DROP TABLE IF EXISTS `index_floor`;
CREATE TABLE `index_floor`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `alter_time` datetime(6) NULL DEFAULT NULL,
  `del_mark` tinyint(1) NULL DEFAULT NULL,
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title_img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `floor_index_img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `index` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `title`(`title` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of index_floor
-- ----------------------------
INSERT INTO `index_floor` VALUES (1, '2022-04-13 08:52:10.980780', '2022-04-13 10:46:34.762206', 0, '宠物火化', '宠物火化.png', '火化_htdrOnN.png', 1);
INSERT INTO `index_floor` VALUES (2, '2022-04-13 08:52:53.057768', '2022-04-13 10:46:46.772576', 0, '宠物树葬', '宠物树葬.png', '宠物树葬1_z7wX8XJ.png', 2);
INSERT INTO `index_floor` VALUES (3, '2022-04-13 08:53:12.049167', '2022-04-13 10:47:04.280314', 0, '仪容整理', '仪容整理.png', '仪容_AQDsJW4.png', 3);
INSERT INTO `index_floor` VALUES (4, '2022-04-13 08:53:32.177801', '2022-04-13 10:47:15.923660', 0, '纪念物品', '纪念物品.png', '纪念物品1_QvG5Nug.png', 4);

-- ----------------------------
-- Table structure for index_floor_detail
-- ----------------------------
DROP TABLE IF EXISTS `index_floor_detail`;
CREATE TABLE `index_floor_detail`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `alter_time` datetime(6) NULL DEFAULT NULL,
  `del_mark` tinyint(1) NULL DEFAULT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of index_floor_detail
-- ----------------------------
INSERT INTO `index_floor_detail` VALUES (1, '2022-04-13 10:37:31.937869', '2022-04-13 10:37:31.937869', 0, '火化');
INSERT INTO `index_floor_detail` VALUES (2, '2022-04-13 10:37:39.182107', '2022-04-13 10:37:39.182107', 0, '树葬');
INSERT INTO `index_floor_detail` VALUES (3, '2022-04-13 10:37:47.009749', '2022-04-13 10:39:23.875131', 0, '仪容');
INSERT INTO `index_floor_detail` VALUES (4, '2022-04-13 10:37:53.208590', '2022-04-13 10:37:53.208590', 0, '纪念');
INSERT INTO `index_floor_detail` VALUES (5, '2022-04-13 10:38:34.498709', '2022-04-13 10:38:34.498709', 0, '火化2');
INSERT INTO `index_floor_detail` VALUES (6, '2022-04-13 10:38:40.039567', '2022-04-13 10:38:40.039567', 0, '火化3');
INSERT INTO `index_floor_detail` VALUES (7, '2022-04-13 10:38:46.890917', '2022-04-13 10:38:46.890917', 0, '火化4');
INSERT INTO `index_floor_detail` VALUES (8, '2022-04-13 10:39:03.304524', '2022-04-13 10:39:03.304524', 0, '纪念2');
INSERT INTO `index_floor_detail` VALUES (9, '2022-04-13 10:39:08.000952', '2022-04-13 10:39:08.000952', 0, '纪念3');
INSERT INTO `index_floor_detail` VALUES (10, '2022-04-13 10:39:13.917469', '2022-04-13 10:39:13.917469', 0, '纪念4');
INSERT INTO `index_floor_detail` VALUES (11, '2022-04-13 10:39:32.822310', '2022-04-13 10:39:32.822310', 0, '仪容2');
INSERT INTO `index_floor_detail` VALUES (12, '2022-04-13 10:39:37.211972', '2022-04-13 10:39:37.211972', 0, '仪容3');
INSERT INTO `index_floor_detail` VALUES (13, '2022-04-13 10:39:41.355338', '2022-04-13 10:39:41.355338', 0, '仪容4');
INSERT INTO `index_floor_detail` VALUES (14, '2022-04-13 10:40:02.361760', '2022-04-13 10:40:02.361760', 0, '树葬2');
INSERT INTO `index_floor_detail` VALUES (15, '2022-04-13 10:40:05.690887', '2022-04-13 10:40:12.893301', 0, '树葬3');
INSERT INTO `index_floor_detail` VALUES (16, '2022-04-13 10:40:16.893514', '2022-04-13 10:40:22.058490', 0, '树葬4');

-- ----------------------------
-- Table structure for index_floor_img
-- ----------------------------
DROP TABLE IF EXISTS `index_floor_img`;
CREATE TABLE `index_floor_img`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `alter_time` datetime(6) NULL DEFAULT NULL,
  `del_mark` tinyint(1) NULL DEFAULT NULL,
  `index` int NOT NULL,
  `detail_id` bigint NOT NULL,
  `floor_id` bigint NOT NULL,
  `floor_img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `detail_id`(`detail_id` ASC) USING BTREE,
  INDEX `index_floor_img_floor_id_d7f5ad3d_fk_index_floor_id`(`floor_id` ASC) USING BTREE,
  CONSTRAINT `index_floor_img_detail_id_10f40639_fk_userBack_` FOREIGN KEY (`detail_id`) REFERENCES `index_floor_detail` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `index_floor_img_floor_id_d7f5ad3d_fk_index_floor_id` FOREIGN KEY (`floor_id`) REFERENCES `index_floor` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of index_floor_img
-- ----------------------------
INSERT INTO `index_floor_img` VALUES (1, '2022-04-13 10:40:35.274838', '2022-04-14 07:21:05.665064', 0, 1, 1, 1, '火化1.png');
INSERT INTO `index_floor_img` VALUES (2, '2022-04-13 10:40:52.206521', '2022-04-14 07:21:20.982948', 0, 1, 2, 2, '树葬1.png');
INSERT INTO `index_floor_img` VALUES (3, '2022-04-13 10:41:05.991352', '2022-04-14 07:21:34.365662', 0, 1, 3, 3, '仪容1.png');
INSERT INTO `index_floor_img` VALUES (4, '2022-04-13 10:41:18.037736', '2022-04-14 07:21:47.550218', 0, 1, 4, 4, '纪念品1.png');
INSERT INTO `index_floor_img` VALUES (5, '2022-04-13 10:48:23.184935', '2022-04-14 07:22:14.450161', 0, 2, 5, 1, '火化2.png');
INSERT INTO `index_floor_img` VALUES (6, '2022-04-13 10:48:41.822081', '2022-04-14 07:22:43.583633', 0, 3, 6, 1, '火化3.png');
INSERT INTO `index_floor_img` VALUES (7, '2022-04-13 10:48:58.921454', '2022-04-14 07:22:51.033820', 0, 4, 7, 1, '火化4.png');
INSERT INTO `index_floor_img` VALUES (8, '2022-04-13 10:49:08.670717', '2022-04-14 07:23:06.446223', 0, 2, 14, 2, '树葬2.png');
INSERT INTO `index_floor_img` VALUES (9, '2022-04-13 10:49:46.342390', '2022-04-14 07:23:22.696164', 0, 3, 15, 2, '树葬3.png');
INSERT INTO `index_floor_img` VALUES (10, '2022-04-13 10:49:56.049102', '2022-04-14 07:23:36.606207', 0, 4, 16, 2, '树葬4.png');
INSERT INTO `index_floor_img` VALUES (11, '2022-04-13 10:50:09.495721', '2022-04-14 07:23:47.636085', 0, 2, 11, 3, '仪容2.png');
INSERT INTO `index_floor_img` VALUES (12, '2022-04-13 10:50:23.305813', '2022-04-14 07:24:04.185510', 0, 3, 12, 3, '仪容3.png');
INSERT INTO `index_floor_img` VALUES (13, '2022-04-13 10:50:34.677151', '2022-04-14 07:23:57.404415', 0, 4, 13, 3, '仪容4.png');
INSERT INTO `index_floor_img` VALUES (14, '2022-04-13 10:50:46.669359', '2022-04-14 07:24:15.160431', 0, 2, 8, 4, '纪念品2.png');
INSERT INTO `index_floor_img` VALUES (15, '2022-04-13 10:52:52.879888', '2022-04-14 07:24:22.557932', 0, 3, 9, 4, '纪念品3.png');
INSERT INTO `index_floor_img` VALUES (16, '2022-04-13 10:53:03.637663', '2022-04-14 07:24:28.673896', 0, 4, 10, 4, '纪念品4.png');

-- ----------------------------
-- Table structure for index_navigate
-- ----------------------------
DROP TABLE IF EXISTS `index_navigate`;
CREATE TABLE `index_navigate`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `alter_time` datetime(6) NULL DEFAULT NULL,
  `del_mark` tinyint(1) NULL DEFAULT NULL,
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `index` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `title`(`title` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of index_navigate
-- ----------------------------
INSERT INTO `index_navigate` VALUES (1, '2022-04-12 12:33:03.404194', '2022-04-26 05:35:58.440439', 0, '客户预约', '客户预约.png', 1);
INSERT INTO `index_navigate` VALUES (2, '2022-04-12 12:33:45.709616', '2022-04-26 05:36:23.315897', 0, '我的预约', '我的预约.png', 2);
INSERT INTO `index_navigate` VALUES (3, '2022-04-12 12:34:12.532162', '2022-04-26 05:36:34.134109', 0, '宠物专车', '专车.png', 3);
INSERT INTO `index_navigate` VALUES (4, '2022-04-12 12:34:50.493694', '2022-04-12 12:34:50.493694', 0, '仪容整理', '化妆.png', 4);
INSERT INTO `index_navigate` VALUES (5, '2022-04-12 12:35:24.792987', '2022-04-12 12:35:24.792987', 0, '告别仪式', 'Iconfont.png', 5);
INSERT INTO `index_navigate` VALUES (6, '2022-04-12 12:35:52.230649', '2022-04-26 05:35:30.851753', 0, '纪念品管', '纪念品馆.png', 6);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `del_mark` tinyint(1) NULL DEFAULT NULL,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `topic` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `alter_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `mobile`(`mobile` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, NULL, NULL, '李尚书', '17398827615', 'https://greatmall.oss-cn-chengdu.aliyuncs.com/topic/2022-04-28/7ab4205d555545fbb435b3402e710ef2.jpg', '2022-04-11 12:41:45.000000');
INSERT INTO `user` VALUES (2, '2022-04-11 12:42:16.000000', 0, '李奇凇', '17398827616', 'https://greatmall.oss-cn-chengdu.aliyuncs.com/topic/2022-04-28/45747e1d81164bacae81fd9d9543fa9f.jpg', '2022-04-20 03:00:17.000000');

-- ----------------------------
-- Table structure for userBack_petinfo
-- ----------------------------
DROP TABLE IF EXISTS `userBack_petinfo`;
CREATE TABLE `userBack_petinfo`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `alter_time` datetime(6) NULL DEFAULT NULL,
  `del_mark` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userBack_petinfo
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
