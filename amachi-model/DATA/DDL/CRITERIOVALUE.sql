CREATE TABLE `criteriovalue` (
	`criterioValueId` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`nameCriterio` VARCHAR(150) NOT NULL,
	`typeCriterio` VARCHAR(255) NULL DEFAULT NULL,
	`typeField` VARCHAR(255) NULL DEFAULT NULL,
	`fk_criterioId` INT(11) NOT NULL,
	PRIMARY KEY (`criterioValueId`),
	UNIQUE INDEX `UK_NAMECRITERIO_CRITERIO` (`nameCriterio`, `fk_criterioId`),
	INDEX `FK_CRITERIOVALUE_CRITERIO` (`fk_criterioId`),
	CONSTRAINT `FK_CRITERIOVALUE_CRITERIO` FOREIGN KEY (`fk_criterioId`) REFERENCES `criterio` (`criterioId`)
)
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB
;