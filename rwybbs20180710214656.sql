/*
MySQL Backup
Database: rwybbs
Backup Time: 2018-07-10 21:46:56
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `rwybbs`.`testuser`;
DROP TABLE IF EXISTS `rwybbs`.`users`;
CREATE TABLE `testuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
CREATE TABLE `users` (
  `uid` int(6) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `upassword` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `umailbox` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` char(11) COLLATE utf8_unicode_ci NOT NULL,
  `takegold` int(6) NOT NULL DEFAULT '10000',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `upicture` varchar(200) CHARACTER SET utf8 NOT NULL DEFAULT 'upload/headpicture/thumb.jpg',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `uname` (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
BEGIN;
LOCK TABLES `rwybbs`.`testuser` WRITE;
DELETE FROM `rwybbs`.`testuser`;
INSERT INTO `rwybbs`.`testuser` (`id`,`username`,`password`) VALUES (1, '陈鹏', '123456'),(2, '李向阳', '654321');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `rwybbs`.`users` WRITE;
DELETE FROM `rwybbs`.`users`;
INSERT INTO `rwybbs`.`users` (`uid`,`uname`,`upassword`,`umailbox`,`phone_number`,`takegold`,`createdate`,`upicture`) VALUES (1, 'rwy123', '123456', 'rwy123@qq.com', '12456658795', 9254, '2018-07-09 12:15:44', 'upload/headpicture/rwy123/20170717153105/1500276665777133354241.jpg'),(2, 'lijie', '123456', '123456789@qq.com', '12345678910', 9981, '2017-07-17 16:59:19', 'upload/headpicture/thumb.jpg'),(3, 'lichaocheng', '123456', '119110123@qq.com', '12345678977', 1000, '2017-07-17 15:51:07', 'upload/headpicture/thumb.jpg'),(10, 'wanghejie', '123456', '1234567111@qq.com', '12345674545', 9998, '2017-07-17 16:56:02', 'upload/headpicture/thumb.jpg'),(26, 'somertang', '123456789', '1274992216@qq.com', '13007492194', 10000, '2017-07-17 15:51:07', 'upload/headpicture/thumb.jpg'),(29, 'test123', '123456', '1101548721@qq.com', '13863218944', 10000, '2017-07-18 20:37:23', 'upload/headpicture/thumb.jpg'),(30, 'test789', '123456', '123654872@qq.com', '13945689512', 10000, '2017-07-18 20:40:22', 'upload/headpicture/thumb.jpg'),(32, 'lcc555888', 'lcc555888', 'lcc555888@qq.com', '11111111111', 10000, '2017-07-18 22:43:27', 'upload/headpicture/lcc555888/20170718224319/1500388999878986026674.png'),(33, 'a497055129', 'wa980814', '497055129@qq.com', '11111111111', 9979, '2018-07-09 16:23:08', 'upload/headpicture/thumb.jpg'),(35, '123456', '123456', '140051753@qq.com', '1511639838', 9997, '2017-12-20 21:07:38', 'upload/headpicture/thumb.jpg'),(37, 'dasiy12', 'abc123', '23343443@qq.com', '18265789262', 10000, '2017-12-18 19:53:29', 'upload/headpicture/thumb.jpg'),(38, '810226', '810226', '810226001@qq.com', '17673111810', 9973, '2018-07-09 15:57:44', 'upload/headpicture/thumb.jpg'),(39, 'test33', 'test33', 'test33@qq.com', '56465451564', 10000, '2018-07-10 17:04:23', 'upload/headpicture/thumb.jpg'),(40, '11', '1tt', '1tt@qq.com', '12312321312', 10000, '2018-07-10 17:15:13', 'upload/headpicture/thumb.jpg'),(41, '22', 'dsaf ', 'dsafdsf@qq,com', '12143214214', 10000, '2018-07-10 21:31:37', 'upload/headpicture/thumb.jpg'),(42, '33', 'dsaf ', 'dsafdsf@qq,com', '12143214214', 10000, '2018-07-10 21:31:37', 'upload/headpicture/thumb.jpg');
UNLOCK TABLES;
COMMIT;
