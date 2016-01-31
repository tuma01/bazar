-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.16 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- Dumping data for table anunciodb.criterio_value: ~4 rows (approximately)
DELETE FROM `criterio_value`;
/*!40000 ALTER TABLE `criterio_value` DISABLE KEYS */;
INSERT INTO `criterio_value` (`ID_CRITERIO_VALUE`, `NAME`, `NAME_VALUES`, `TYPE_CRITERIO`, `TYPE_FIELD`, `FK_ID_CRITERIO`) VALUES
	(1, 'Ford', 'Modelo', 'MULTIPLE', 'STRING', 1),
	(2, 'Diesel', NULL, 'SINGLE', 'STRING', 2),
	(3, 'Essence', NULL, 'SINGLE', 'STRING', 2),
	(4, 'Toyota', 'MODELO', 'MULTIPLE', 'STRING', 1);
/*!40000 ALTER TABLE `criterio_value` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
