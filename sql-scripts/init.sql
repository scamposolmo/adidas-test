

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# City
# ------------------------------------------------------------

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;

INSERT INTO `city` (`id`, `name`)
VALUES
	(0,'Sevilla'),
	(1,'Zaragoza'),
	(2,'Madrid'),
	(3,'Barcelona');

/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;


# itinerary
# ------------------------------------------------------------

DROP TABLE IF EXISTS `itinerary`;

CREATE TABLE `itinerary` (
  `id` int(11) NOT NULL,
  `arrival_time` int(11) DEFAULT NULL,
  `departure_time` int(11) DEFAULT NULL,
  `destination_city_id` int(11) DEFAULT NULL,
  `origin_city_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt31unavocouvo62xrig4pygw6` (`destination_city_id`),
  KEY `FKo8t13vnjf6mqjv4lk44icu0x7` (`origin_city_id`),
  CONSTRAINT `FKo8t13vnjf6mqjv4lk44icu0x7` FOREIGN KEY (`origin_city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `FKt31unavocouvo62xrig4pygw6` FOREIGN KEY (`destination_city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `itinerary` WRITE;
/*!40000 ALTER TABLE `itinerary` DISABLE KEYS */;

INSERT INTO `itinerary` (`id`, `arrival_time`, `departure_time`, `destination_city_id`, `origin_city_id`)
VALUES
	(0,100,150,0,1),
	(1,32,455,0,2),
	(2,32,32,1,2);

/*!40000 ALTER TABLE `itinerary` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
