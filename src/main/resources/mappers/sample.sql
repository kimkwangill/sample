CREATE TABLE `spring_boot_sample` (
	`sample_id` INT(11) NOT NULL AUTO_INCREMENT,
	`subject` VARCHAR(255) NULL,
	`content` TEXT NULL,
	`reg_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`sample_id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1
;