
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `weekdish`;
CREATE TABLE `weekdish` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `whichWeekDay` varchar(100) NOT NULL,
  `mealtime` varchar(100) NOT NULL,
  `dishType` varchar(100) NOT NULL,
  `dishName` varchar(100) NOT NULL COMMENT '菜名',
  `dishPrice` float DEFAULT 0.0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `weekdish` VALUES ('1', '周一', '早餐', '点心', '奶油小面包',"3.0");
