#创建数据库hrm_db
create database hrm_db;

#使用数据库hrm_db
use hrm_db;

#创建表dept_inf
create table dept_inf(
  id INT(11) not null auto_increment,
  name VARCHAR(50) not null,
  remark VARCHAR(300) DEFAULT NULL ,
  PRIMARY KEY (id)
) engine=innodb auto_increment=10 DEFAULT charset=utf8;
INSERT into dept_inf(id,name,pemark)VALUES (1,'技术部','技术部'),(2,'运营部','运营部'),(3,'财务部','财务部');

#创建表job_inf
create table job_inf(
  id INT(11) not null auto_increment,
  name VARCHAR(50) not null,
  remark VARCHAR(300) DEFAULT NULL ,
  PRIMARY key (id)
  )engine=innodb auto_increment=10 DEFAULT charset=utf8;
INSERT into job_inf(id, name, pemark) VALUES (1,'职员','职员'),(2,'java开发工程师','java开发工程师'),(3,'java中级开发师','java中级开发师');


#创建表user_inf
create table user_inf(
  id INT(11) not null auto_increment,
  loginname VARCHAR(20) NOT NULL ,
  password VARCHAR (16) not NULL ,
  status INT (11) not NULL DEFAULT '1',
  createdate TIMESTAMP not NULL DEFAULT CURRENT_TIMESTAMP ,
  username VARCHAR (20) DEFAULT NULL ,
  PRIMARY key(id)
) engine=innodb auto_increment=2 DEFAULT charset=utf8;
INSERT into user_inf(id, loginname, password, status, createdate, username) VALUES (1,'admin','123456','2','2017-08-21 23:49:34','超级管理员');


#创建表notice_inf
CREATE TABLE notice_inf(
  id INT(11) not null auto_increment,
  title varchar(50) not NULL ,
  content text NOT NULL ,
  create_date TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP ,
  user_id INT (11) DEFAULT NULL ,
  PRIMARY KEY (id),
  key fk_notice_user (user_id),
  CONSTRAINT fk_notice_user FOREIGN key (user_id) REFERENCES user_inf(id)
  ) engine=innodb auto_increment=19 DEFAULT charset=utf8;



#创建表 document_inf
CREATE table document_inf(
  id INT(11) not null auto_increment,
  title VARCHAR (50) not NULL ,
  filename VARCHAR (300) DEFAULT null,
  create_date TIMESTAMP  not NULL   DEFAULT CURRENT_TIMESTAMP ,
  user_id int(11) DEFAULT NULL ,
  PRIMARY KEY (id),
  key fk_document_user (user_id),
  CONSTRAINT fk_document_user FOREIGN key (user_id) REFERENCES user_inf(id)
  ) engine=innodb auto_increment=7 DEFAULT charset=utf8;

#创建employee_inf
create table employee_inf(
  id INT(11) not null auto_increment,
  dept_id int(11) not NULL ,
  job_id int(11) not NULL ,
  name VARCHAR (20) not NULL ,
  card_id VARCHAR (18) not null,
  address varchar(50) not NULL ,
  post_code VARCHAR (50) DEFAULT  NULL ,
  tel VARCHAR (16) DEFAULT NULL ,
  phone VARCHAR (16) DEFAULT NULL ,
  qq_num VARCHAR (10) DEFAULT NULL ,
  email VARCHAR (50) not null,
  sex INT (11) not NULL  DEFAULT '1',
  party VARCHAR (10) DEFAULT null,
  birthday datetime DEFAULT NULL ,
  race VARCHAR(110) default NULL ,
  education varchar(10) DEFAULT NULL ,
  speciality varchar(20) DEFAULT NULL ,
  hobby varchar(100) default NULL ,
  remark varchar(500) DEFAULT NULL ,
  create_date TIMESTAMP  not NULL  DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (id),
  KEY FK_EMP_DEPT (dept_id),
  KEY FK_EMP_JOB (job_id),
  CONSTRAINT FK_EMP_DEPT FOREIGN KEY (dept_id) REFERENCES dept_inf(id),
  CONSTRAINT FK_EMP_JOB FOREIGN KEY (job_id) REFERENCES job_inf(id)
) engine=innodb auto_increment=4 DEFAULT charset=utf8;

INSERT into employee_inf(id, dept_id, job_id, name, card_id, address, post_code, tel, phone, qq_num, email, sex, party, birthday, race, education, speciality, hobby, pemark, create_date)
VALUES (1,1,2,' nazi ','234324','北京','232323','7757575','123333333','323423','ewwrwe@qq.com','0','党员','1980-01-01 00:00:00','汉','本科','计算机','爬山','无','2016-8-19 11:35:38');



drop table if exists city;

create table city (
id int primary key auto_increment, 
name varchar(30), 
state varchar(30), 
country varchar(30)
);

insert into city (name, state, country) values ('San Francisco', 'CA', 'US');


