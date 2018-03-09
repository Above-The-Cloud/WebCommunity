DROP DATABASE IF EXISTS community;
CREATE DATABASE community Character Set UTF8;
USE community;

CREATE TABLE user_info(
		user_id VARCHAR(100) NOT NULL,
        user_name VARCHAR(100) NOT NULL,
        user_password VARCHAR(100) NOT NULL,
        submission_time DATETIME,
        PRIMARY KEY ( user_ID ))ENGINE=InnoDB DEFAULT CHARSET=utf8; 

create table user_info_extension(
	user_id varchar(100) primary key references user_info,
	user_address varchar(100) null,
	user_email varchar(100) null,
	sybmussion_time datetime)ENGINE=InnoDB DEFAULT CHARSET=utf8; 
	

CREATE TABLE task_publish_info(
	publish_id VARCHAR(100) NOT NULL PRIMARY KEY,
	user_id VARCHAR(100) NOT NULL REFERENCES user_info,
	title VARCHAR(100) NULL,
	content VARCHAR(280) NULL,
	category VARCHAR(40) NULL,
	price int(0),
	viewed bigint(0),
	liked bigint(0),
	submission_time DATETIME)ENGINE=InnoDB DEFAULT CHARSET=utf8; 