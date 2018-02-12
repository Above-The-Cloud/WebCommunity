DROP DATABASE IF EXISTS community;
CREATE DATABASE community Character Set UTF8;
USE community;

CREATE TABLE user_info(
        user_name VARCHAR(100) NOT NULL,
        user_password VARCHAR(100) NOT NULL,
        submission_time DATETIME,
        PRIMARY KEY ( user_name ))ENGINE=InnoDB DEFAULT CHARSET=utf8; 

INSERT INTO user_info(user_name, user_password, submission_time)
	VALUES("yiwangchunyu", "123456", current_time());