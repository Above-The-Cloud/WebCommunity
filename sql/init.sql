DROP DATABASE IF EXISTS community;
CREATE DATABASE community Character Set UTF8;
USE community;

CREATE TABLE user_info(
	user_id VARCHAR(100) NOT NULL,
        user_name VARCHAR(100) NOT NULL,
        user_password VARCHAR(100) NOT NULL,
        submission_time DATETIME,
        PRIMARY KEY ( user_ID ))ENGINE=InnoDB DEFAULT CHARSET=utf8; 

INSERT INTO user_info(user_id, user_name, user_password, submission_time)
	VALUES("18966666666","yiwangchunyu", "123456", current_time());