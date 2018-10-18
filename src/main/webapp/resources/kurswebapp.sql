-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.21-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных kurswebapp
CREATE DATABASE IF NOT EXISTS `kurswebapp` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `kurswebapp`;

-- Дамп структуры для таблица kurswebapp.order_toys
CREATE TABLE IF NOT EXISTS `order_toys` (
  `ORDER_ID` int(11) NOT NULL,
  `TOYS_ID` int(11) NOT NULL,
  PRIMARY KEY (`ORDER_ID`,`TOYS_ID`),
  KEY `FK_4qca4p4xaqln011r8b0o5hgb` (`TOYS_ID`),
  KEY `FK_iqgeqlr1vj2g84llrxwnj7rhh` (`ORDER_ID`),
  CONSTRAINT `FK_4qca4p4xaqln011r8b0o5hgb` FOREIGN KEY (`TOYS_ID`) REFERENCES `toys` (`toy_id`),
  CONSTRAINT `FK_iqgeqlr1vj2g84llrxwnj7rhh` FOREIGN KEY (`ORDER_ID`) REFERENCES `personsorder` (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы kurswebapp.order_toys: ~7 rows (приблизительно)
/*!40000 ALTER TABLE `order_toys` DISABLE KEYS */;
INSERT INTO `order_toys` (`ORDER_ID`, `TOYS_ID`) VALUES
	(3, 5),
	(4, 5),
	(3, 6),
	(4, 6),
	(3, 7),
	(4, 7),
	(4, 8);
/*!40000 ALTER TABLE `order_toys` ENABLE KEYS */;

-- Дамп структуры для таблица kurswebapp.persons
CREATE TABLE IF NOT EXISTS `persons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы kurswebapp.persons: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `persons` DISABLE KEYS */;
INSERT INTO `persons` (`id`, `address`, `email`, `name`, `telephone`) VALUES
	(3, 'Черкаси, вул. Шевченка, 23', 'osadchii@gmail.com', 'Олександр', '+32434535'),
	(4, 'Уол Стрит,12', 'ivan@mail.ru', 'Іван', '+3435353535');
/*!40000 ALTER TABLE `persons` ENABLE KEYS */;

-- Дамп структуры для таблица kurswebapp.personsorder
CREATE TABLE IF NOT EXISTS `personsorder` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `total` double DEFAULT NULL,
  `person_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `FK_4mvn1qcho7rm36x2amugs7yd7` (`person_id`),
  CONSTRAINT `FK_4mvn1qcho7rm36x2amugs7yd7` FOREIGN KEY (`person_id`) REFERENCES `persons` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы kurswebapp.personsorder: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `personsorder` DISABLE KEYS */;
INSERT INTO `personsorder` (`orderId`, `total`, `person_id`) VALUES
	(3, 111, 3),
	(4, 156.6, 4);
/*!40000 ALTER TABLE `personsorder` ENABLE KEYS */;

-- Дамп структуры для таблица kurswebapp.toys
CREATE TABLE IF NOT EXISTS `toys` (
  `toy_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`toy_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы kurswebapp.toys: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `toys` DISABLE KEYS */;
INSERT INTO `toys` (`toy_id`, `name`, `price`) VALUES
	(5, 'Машинка', 12),
	(6, 'Літачок', 34),
	(7, 'Кубик', 65),
	(8, 'Робот', 45.6);
/*!40000 ALTER TABLE `toys` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
