/*
MySQL Backup
Database: rwydata
Backup Time: 2018-07-10 21:46:30
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `rwydata`.`administrator`;
DROP TABLE IF EXISTS `rwydata`.`area`;
DROP TABLE IF EXISTS `rwydata`.`attractions_classes`;
DROP TABLE IF EXISTS `rwydata`.`comments`;
DROP TABLE IF EXISTS `rwydata`.`forum`;
DROP TABLE IF EXISTS `rwydata`.`recycled`;
DROP TABLE IF EXISTS `rwydata`.`reply`;
DROP TABLE IF EXISTS `rwydata`.`users`;
DROP TABLE IF EXISTS `rwydata`.`vr_attractions`;
DROP PROCEDURE IF EXISTS `rwydata`.`synuser`;
DROP PROCEDURE IF EXISTS `rwydata`.`upsetuser`;
CREATE TABLE `administrator` (
  `aid` int(2) NOT NULL AUTO_INCREMENT,
  `aname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `account` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `apassword` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `gmalevel` int(1) NOT NULL DEFAULT '0',
  `last_login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`aid`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `area` (
  `attractions_area_id` int(2) NOT NULL,
  `attractions_area_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`attractions_area_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `attractions_classes` (
  `attractions_classes_id` int(2) NOT NULL AUTO_INCREMENT,
  `attractions_classes_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`attractions_classes_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `comments` (
  `cid` int(8) NOT NULL AUTO_INCREMENT,
  `attractions_id` int(6) NOT NULL,
  `comment_uid` int(6) NOT NULL,
  `Publish_content` text COLLATE utf8_unicode_ci NOT NULL,
  `Pubdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cid`),
  KEY `attractions_id` (`attractions_id`),
  KEY `comment_uid` (`comment_uid`),
  CONSTRAINT `attractions_id` FOREIGN KEY (`attractions_id`) REFERENCES `vr_attractions` (`attractions_id`) ON DELETE CASCADE,
  CONSTRAINT `comment_uid` FOREIGN KEY (`comment_uid`) REFERENCES `users` (`uid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `forum` (
  `post_id` int(10) NOT NULL AUTO_INCREMENT,
  `post_uid` int(6) NOT NULL,
  `post_tiltle` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `post_content` text COLLATE utf8_unicode_ci NOT NULL,
  `post_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`post_id`),
  KEY `post_uid` (`post_uid`) USING BTREE,
  CONSTRAINT `post_uid` FOREIGN KEY (`post_uid`) REFERENCES `users` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `recycled` (
  `recycled_id` int(6) NOT NULL AUTO_INCREMENT,
  `recycled_attractions_id` int(6) NOT NULL,
  `recycled_aid` int(2) NOT NULL,
  `recycled_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`recycled_id`),
  KEY `recycled_attractions_id` (`recycled_attractions_id`),
  KEY `recycled_aid` (`recycled_aid`),
  CONSTRAINT `recycled_aid` FOREIGN KEY (`recycled_aid`) REFERENCES `administrator` (`aid`),
  CONSTRAINT `recycled_attractions_id` FOREIGN KEY (`recycled_attractions_id`) REFERENCES `vr_attractions` (`attractions_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `reply` (
  `reply_id` int(10) NOT NULL,
  `reply_post_id` int(10) NOT NULL,
  `reply_uid` int(6) NOT NULL,
  `reply_content` text COLLATE utf8_unicode_ci NOT NULL,
  `reply_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`reply_id`),
  KEY `reply_post_id` (`reply_post_id`),
  KEY `reply_uid` (`reply_uid`),
  CONSTRAINT `reply_post_id` FOREIGN KEY (`reply_post_id`) REFERENCES `forum` (`post_id`),
  CONSTRAINT `reply_uid` FOREIGN KEY (`reply_uid`) REFERENCES `users` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `users` (
  `uid` int(6) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `upassword` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `umailbox` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` char(11) COLLATE utf8_unicode_ci NOT NULL,
  `takegold` int(6) NOT NULL DEFAULT '10',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `upicture` varchar(200) CHARACTER SET utf8 NOT NULL DEFAULT 'upload/headpicture/thumb.jpg',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `uname` (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `vr_attractions` (
  `attractions_id` int(6) NOT NULL AUTO_INCREMENT,
  `attractions_cover` varchar(1000) CHARACTER SET utf8 NOT NULL,
  `attractions_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `attractions_resource` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `attractions_cost` int(3) NOT NULL,
  `attractions_introduce` text COLLATE utf8_unicode_ci NOT NULL,
  `attractions_area_id` int(2) NOT NULL,
  `attractions_classes_id` int(2) NOT NULL,
  `attractions_popularity` int(7) NOT NULL DEFAULT '0',
  `attractions_uploader_uid` int(6) NOT NULL,
  `attractions_status` int(1) NOT NULL DEFAULT '0',
  `attractions_uploadtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `refusal_reason` text CHARACTER SET utf8,
  `introduction_voice` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`attractions_id`),
  KEY `attractions_classes_id` (`attractions_classes_id`),
  KEY `attractions_area_id` (`attractions_area_id`),
  KEY `attractions_uploader_uid` (`attractions_uploader_uid`),
  CONSTRAINT `attractions_area_id` FOREIGN KEY (`attractions_area_id`) REFERENCES `area` (`attractions_area_id`),
  CONSTRAINT `attractions_classes_id` FOREIGN KEY (`attractions_classes_id`) REFERENCES `attractions_classes` (`attractions_classes_id`),
  CONSTRAINT `attractions_uploader_uid` FOREIGN KEY (`attractions_uploader_uid`) REFERENCES `users` (`uid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE DEFINER=`root`@`localhost` PROCEDURE `synuser`(IN `synuid` int,IN `synuname` varchar(20),IN `synupassword` varchar(20),IN `synumailbox` varchar(30),IN `synphone_number` char(11),IN `syntakegold` int,IN `syncreatedate` timestamp,IN `synupicture` varchar(200))
BEGIN
	#Routine body goes here...
	INSERT INTO rwybbs.users
	VALUES(synuid,synuname,synupassword,synumailbox,synphone_number,syntakegold,syncreatedate,synupicture);
END;
CREATE DEFINER=`root`@`localhost` PROCEDURE `upsetuser`(IN `synuid` int,IN `synuname` varchar(20),IN `synupassword` varchar(20),IN `synumailbox` varchar(30),IN `synphone_number` char(11),IN `syntakegold` int,IN `syncreatedate` timestamp,IN `synupicture` varchar(200))
BEGIN
	#Routine body goes here...
	UPDATE 
	rwybbs.users
	SET 
	uname=synuname,
	upassword=synupassword,
	umailbox=synumailbox,
	phone_number=synphone_number,
	takegold=syntakegold,
	createdate=syncreatedate,
	upicture=synupicture
	WHERE
	uid=synuid;
END;
BEGIN;
LOCK TABLES `rwydata`.`administrator` WRITE;
DELETE FROM `rwydata`.`administrator`;
INSERT INTO `rwydata`.`administrator` (`aid`,`aname`,`account`,`apassword`,`gmalevel`,`last_login_time`) VALUES (1, 'Healer', '123456', '123456', 1, '2018-07-09 16:24:11'),(16, 'wtz', '123', '123', 0, '2017-07-18 17:38:24'),(17, 'dfaf', 'add', 'dd', 0, '2017-07-15 11:33:31'),(18, 'dd', 'dd', 'dd', 0, '2017-07-15 11:33:36'),(19, 'ee', 'ee', 'w', 0, '2017-07-15 16:55:29');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `rwydata`.`area` WRITE;
DELETE FROM `rwydata`.`area`;
INSERT INTO `rwydata`.`area` (`attractions_area_id`,`attractions_area_name`) VALUES (1, '北京市'),(2, '天津市'),(3, '上海市'),(4, '重庆市'),(5, '河北省'),(6, '山西省'),(7, '辽宁省'),(8, '吉林省'),(9, '黑龙江省'),(10, '江苏省'),(11, '浙江省'),(12, '安徽省'),(13, '福建省'),(14, '江西省'),(15, '山东省'),(16, '河南省'),(17, '湖北省'),(18, '湖南省'),(19, '广东省'),(20, '海南省'),(21, '四川省'),(22, '贵州省'),(23, '云南省'),(24, '陕西省'),(25, '甘肃省'),(26, '青海省'),(27, '台湾省'),(28, '内蒙古自治区'),(29, '广西壮族自治区'),(30, '西藏自治区'),(31, '宁夏回族自治区'),(32, '新疆维吾尔自治区'),(33, '香港特别行政区'),(34, '澳门特别行政区');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `rwydata`.`attractions_classes` WRITE;
DELETE FROM `rwydata`.`attractions_classes`;
INSERT INTO `rwydata`.`attractions_classes` (`attractions_classes_id`,`attractions_classes_name`) VALUES (1, '城市风光'),(2, '秀美山水'),(3, '辽阔草原');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `rwydata`.`comments` WRITE;
DELETE FROM `rwydata`.`comments`;
INSERT INTO `rwydata`.`comments` (`cid`,`attractions_id`,`comment_uid`,`Publish_content`,`Pubdate`) VALUES (17, 126, 2, '介绍的很详细，也很好看', '2017-07-18 17:59:01'),(18, 127, 1, '风', '2017-07-18 18:18:33'),(19, 128, 32, '水立方好美！', '2017-07-18 23:21:40'),(20, 126, 1, '很漂亮', '2017-11-06 18:19:43'),(22, 126, 1, 'www', '2017-12-17 16:08:34');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `rwydata`.`forum` WRITE;
DELETE FROM `rwydata`.`forum`;
INSERT INTO `rwydata`.`forum` (`post_id`,`post_uid`,`post_tiltle`,`post_content`,`post_date`) VALUES (1, 1, 'ahfei', 'fjdafheifiejkjahg', '2017-07-20 16:27:21');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `rwydata`.`recycled` WRITE;
DELETE FROM `rwydata`.`recycled`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `rwydata`.`reply` WRITE;
DELETE FROM `rwydata`.`reply`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `rwydata`.`users` WRITE;
DELETE FROM `rwydata`.`users`;
INSERT INTO `rwydata`.`users` (`uid`,`uname`,`upassword`,`umailbox`,`phone_number`,`takegold`,`createdate`,`upicture`) VALUES (1, 'rwy123', '123456', 'rwy123@qq.com', '12456658795', 9254, '2018-07-09 12:15:44', 'upload/headpicture/rwy123/20170717153105/1500276665777133354241.jpg'),(2, 'lijie', '123456', '123456789@qq.com', '12345678910', 9981, '2017-07-17 16:59:19', 'upload/headpicture/thumb.jpg'),(3, 'lichaocheng', '123456', '119110123@qq.com', '12345678977', 1000, '2017-07-17 15:51:07', 'upload/headpicture/thumb.jpg'),(10, 'wanghejie', '123456', '1234567111@qq.com', '12345674545', 9998, '2017-07-17 16:56:02', 'upload/headpicture/thumb.jpg'),(26, 'somertang', '123456789', '1274992216@qq.com', '13007492194', 10000, '2017-07-17 15:51:07', 'upload/headpicture/thumb.jpg'),(29, 'test123', '123456', '1101548721@qq.com', '13863218944', 10000, '2017-07-18 20:37:23', 'upload/headpicture/thumb.jpg'),(30, 'test789', '123456', '123654872@qq.com', '13945689512', 10000, '2017-07-18 20:40:22', 'upload/headpicture/thumb.jpg'),(32, 'lcc555888', 'lcc555888', 'lcc555888@qq.com', '11111111111', 10000, '2017-07-18 22:43:27', 'upload/headpicture/lcc555888/20170718224319/1500388999878986026674.png'),(33, 'a497055129', 'wa980814', '497055129@qq.com', '11111111111', 9979, '2018-07-09 16:23:08', 'upload/headpicture/thumb.jpg'),(35, '123456', '123456', '140051753@qq.com', '1511639838', 9997, '2017-12-20 21:07:38', 'upload/headpicture/thumb.jpg'),(37, 'dasiy12', 'abc123', '23343443@qq.com', '18265789262', 10000, '2017-12-18 19:53:29', 'upload/headpicture/thumb.jpg'),(38, '810226', '810226', '810226001@qq.com', '17673111810', 9973, '2018-07-09 15:57:44', 'upload/headpicture/thumb.jpg'),(39, 'test33', 'test33', 'test33@qq.com', '56465451564', 10000, '2018-07-10 17:04:23', 'upload/headpicture/thumb.jpg'),(40, '11', '1tt', '1tt@qq.com', '12312321312', 10000, '2018-07-10 17:15:13', 'upload/headpicture/thumb.jpg'),(41, '22', 'dsaf ', 'dsafdsf@qq,com', '12143214214', 10000, '2018-07-10 21:31:37', 'upload/headpicture/thumb.jpg'),(42, '33', 'dsaf ', 'dsafdsf@qq,com', '12143214214', 10000, '2018-07-10 21:31:37', 'upload/headpicture/thumb.jpg');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `rwydata`.`vr_attractions` WRITE;
DELETE FROM `rwydata`.`vr_attractions`;
INSERT INTO `rwydata`.`vr_attractions` (`attractions_id`,`attractions_cover`,`attractions_name`,`attractions_resource`,`attractions_cost`,`attractions_introduce`,`attractions_area_id`,`attractions_classes_id`,`attractions_popularity`,`attractions_uploader_uid`,`attractions_status`,`attractions_uploadtime`,`refusal_reason`,`introduction_voice`) VALUES (125, 'upload/rwy123/20170717150148/15002749089459085845883.jpg', '百里杜鹃大草原', 'upload/rwy123/20170717150148/bailidu', 2, '百里杜鹃位于贵州西北部，毕节市中部，南与黔西县相邻，西北与大方县接壤，东与金沙县偎依，总面积600余平方公里，享有“、地球彩带、杜鹃王国、养身福地、清凉世界”之美誉。是国家5A级旅游景区、国家生态旅游示范区、世界唯一的杜鹃花国家森林公园、国家风景名胜区、国家自然保护区；是全国低碳旅游实验区、亚洲·大中华区十大自然原生态旅游景区、世界上最大的天然花园；是中国春观花、夏避暑、秋休闲、冬赏雪等生态旅游胜地。', 22, 3, 18, 1, 1, '2018-07-09 16:28:42', NULL, 'upload/rwy123/20170717150148/reader.wav'),(126, 'upload/rwy123/20170717150314/1500274994868587422609.jpg', '北京自然博物馆', 'upload/rwy123/20170717150314/kl', 0, '北京自然博物馆位于首都南城中轴线上的天桥地区，背靠世界文化遗产天坛公园，面对现代化的天桥剧场, 具有特殊的文化环境。它的前身是成立于1951年4月的中央自然博物馆筹备处，1962年正式命名为北京自然博物馆。\r 北京自然博物馆是新中国依靠自己的力量筹建的第一座大型自然历史博物馆，主要从事古生物、动物、植物和人类学等领域的标本收藏、科学研究和科学普及工作。', 1, 1, 106, 1, 1, '2017-07-17 17:20:10', NULL, 'upload/rwy123/20170717150314/reader.wav'),(127, 'upload/rwy123/20170717150755/15002752751793230668827.jpg', '黄果树瀑布', 'upload/rwy123/20170717150755/output', 1, '黄果树瀑布，即黄果树大瀑布。古称白水河瀑布，亦名“黄葛墅”瀑布或“黄桷树”瀑布，因本地广泛分布着“黄葛榕”而得名。位于中国贵州省安顺市镇宁布依族苗族自治县，属珠江水系西江干流南盘江支流北盘江支流打帮河的支流可布河下游白水河段水系，为黄果树瀑布群中规模最大的一级瀑布，是世界著名大瀑布之一。以水势浩大著称。', 22, 2, 10, 1, 1, '2017-07-17 17:20:10', NULL, 'upload/rwy123/20170717150755/reader.wav'),(128, 'upload/rwy123/20170717151948/15002759882972272276346.jpg', '水立方', 'upload/rwy123/20170717151948/shuilifang', 0, '国家游泳中心又称“水立方”(Water Cube)位于北京奥林匹克公园内，是北京为2008年夏季奥运会修建的主游泳馆，也是2008年北京奥运会标志性建筑物之一。\r 它的设计方案，是经全球设计竞赛产生的“水的立方”([H2O]3)方案。其与国家体育场(俗称鸟巢)分列于北京城市中轴线北端的两侧，共同形成相对完整的北京历史文化名城形象。', 1, 1, 32, 1, 1, '2017-07-17 17:20:10', NULL, 'upload/rwy123/20170717151948/reader.wav'),(129, 'upload/rwy123/20170717152141/1500276101311587689150.jpg', '北海海底世界', 'upload/rwy123/20170717152141', 0, '北海海底世界座落于北海海滨公园内，是以展示海洋生物为主，集观赏、旅游、青少年科普教育为一体的大型综合性海洋馆，分为A、B两区。A区主要为淡水鱼区，B区为海洋生物区，总储水量近6000吨，其展示方式、规模和鱼类品种在全国海洋馆中名列前茅，使游客可以不出国门，一览世界第三代海洋馆的壮丽海底景观。在这里，每天都会有多场精彩刺激的水下表演等着您。', 29, 1, 18, 1, 1, '2017-07-17 15:29:24', NULL, 'upload/rwy123/20170717152141/reader.wav'),(130, 'upload/rwy123/20170717152308/15002761880339943801423.jpg', '贵州双乳峰', 'upload/rwy123/20170717152308/guizhoushuangru', 0, '双乳峰景区位于贵州省贞丰县城境内，是喀斯特的峰林绝品，是鬼斧神工的自然造化，酷似女性的乳房。这里的布依族群众一直把它当作“大地母亲”和“生命之源”来崇拜。\r\n据地理学家考证，在中国绝无仅有，其他国家也没有类似发现，堪称“天下奇观”。', 22, 2, 12, 1, 1, '2018-07-09 16:29:36', NULL, 'upload/rwy123/20170717152308/reader.wav'),(131, 'upload/rwy123/20170717152421/1500276261427724688866.jpg', '河南法王寺卧佛', 'upload/rwy123/20170717152421/henanfawang', 2, '嵩山大法王寺位于登封嵩山之太室山南麓，嵩岳寺之东北。相传建于汉明帝永平十四年（71）。\r\n寺据嵩山之胜，为天下名刹之一。 1987年，重修古寺，恢复寺院面积六万多平方米，重修殿堂五千多平方米，修复雕塑神像四十七尊。佛教活动和旅游事业蓬勃发展，大法王寺已成为旅游观光的一个亮点，他的爱国爱教精神受到各级领导、海内外宗教界人士和广大游客高度赞誉。如今大法王寺宗风再振，名声远扬，千年古刹，光辉重现。', 16, 2, 8, 1, 1, '2018-07-09 16:31:00', NULL, 'upload/rwy123/20170717152421/reader.wav'),(132, 'upload/rwy123/20170717152552/15002763521568067523657.jpg', '天涯海角爱情石', 'upload/rwy123/20170717152552/tianyahaijiao', 5, '天涯海角游览区，位于三亚市天涯区，距主城区西南约23公里处，背对马岭山，面向茫茫大海，是海南建省20年第一旅游名胜，新中国成立60周年海南第一旅游品牌，国家AAAA级旅游景区。景区海湾沙滩上大小百块石耸立，“天涯石”、“海角石”、“日月石”和“南天一柱”突兀其间。', 20, 2, 13, 1, 1, '2018-07-09 16:31:23', NULL, 'upload/rwy123/20170717152552/reader.wav'),(133, 'upload/rwy123/20170717152726/15002764466567130307131.jpg', '张家界', 'upload/rwy123/20170717152726', 0, '张家界是湖南省辖地级市，原名大庸市，辖2个市辖区（永定区、武陵源区）、2个县（慈利县、桑植县）。位于湖南西北部，澧水中上游，属武陵山区腹地。 张家界因旅游建市，是中国最重要的旅游城市之一，是湘鄂渝黔革命根据地的发源地和中心区域。\r 1982年9月，张家界国家森林公园成为中国第一个国家森林公园。\r 1988年8月，张家界武陵源风景名胜区被列入国家重点风景名胜区；', 18, 2, 20, 1, 1, '2017-07-17 17:20:10', NULL, 'upload/rwy123/20170717152726/reader.wav'),(136, 'upload/lcc555888/20170718231039/1500390639956904969949.png', '测试文件', 'upload/lcc555888/20170718231039/output', 1, '这是测试文件', 18, 1, 8, 32, 1, '2017-07-18 23:13:27', NULL, 'upload/lcc555888/20170718231039/reader.wav');
UNLOCK TABLES;
COMMIT;
CREATE DEFINER = `root`@`localhost` TRIGGER `同步用户` AFTER INSERT ON `users` FOR EACH ROW call synuser(new.uid,
new.uname,
new.upassword,
new.umailbox,
new.phone_number,
new.takegold,
new.createdate,
new.upicture
);;
CREATE DEFINER = `root`@`localhost` TRIGGER `修改用户` AFTER UPDATE ON `users` FOR EACH ROW call upsetuser(new.uid,
new.uname,
new.upassword,
new.umailbox,
new.phone_number,
new.takegold,
new.createdate,
new.upicture
);;
