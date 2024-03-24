CREATE DATABASE  IF NOT EXISTS `ssafysample`;
USE `ssafysample`;

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product`(
  `code` varchar(20) NOT NULL,
  `model` varchar(20) NOT NULL,
  `price` int NOT NULL,
  
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `product` WRITE;
INSERT INTO `product` VALUES ('1234','2021',1234),('16ZD95P-GX50K','2022 그램16',1475900),('NT550XDZ-AD5A','노트북 플러스2',729000);
UNLOCK TABLES;

  -- -----------------------------------------------------
-- Table `ssafysample`.`members`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ssafysample`.`members` ;

CREATE TABLE IF NOT EXISTS `ssafysample`.`members` (
  `user_id` VARCHAR(16) NOT NULL,
  `user_name` VARCHAR(20) NOT NULL,
  `user_password` VARCHAR(16) NOT NULL,
  `email_id` VARCHAR(20) NULL DEFAULT NULL,
  `email_domain` VARCHAR(45) NULL DEFAULT NULL,
  `join_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

insert into `ssafysample`.`members` (user_id, user_name, user_password, email_id, email_domain, join_date)
values 	('ssafy', '김싸피', '1234', 'ssafy', 'ssafy.com', now()), 
		('admin', '관리자', '1234', 'admin', 'google.com', now());

