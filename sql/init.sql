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
	submission_time datetime)ENGINE=InnoDB DEFAULT CHARSET=utf8; 
	

CREATE TABLE task_publish_info(
	publish_id bigint AUTO_INCREMENT NOT NULL PRIMARY KEY,
	user_id VARCHAR(100) NOT NULL REFERENCES user_info,
	title VARCHAR(100) NULL,
	restriction VARCHAR(280) NULL,
	content VARCHAR(280) NULL,
	category VARCHAR(40) NULL,
	price int(0),
	viewed bigint(0),
	liked bigint(0),
	submission_time DATETIME)ENGINE=InnoDB  AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8; 
	
create table task_publish_image(
	publish_id bigint references task_publish_info,
	image_path VARCHAR(200) ,
	submission_time DATETIME,
	PRIMARY KEY(publish_id,image_path))ENGINE=InnoDB DEFAULT CHARSET=utf8;