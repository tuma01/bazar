CREATE TABLE `pays` (
	`PYS_ID` INT(11) NOT NULL AUTO_INCREMENT,
	`PYS_NAME` VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci',
	`PYS_CODE_A1` VARCHAR(2) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`PYS_CODE_A2` VARCHAR(2) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`CREATED_BY` VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci',
	`CREATED_DATE` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`MODIFIED_BY` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`MODIFIED_DATE` DATETIME NULL DEFAULT NULL,
	PRIMARY KEY (`PYS_ID`),
	UNIQUE INDEX `UK_PYS_NAME` (`PYS_NAME`)
)
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1
;