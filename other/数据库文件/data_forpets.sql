-- customer表
drop database if exists petweb;
create database petweb;
use petweb;
create table customer(
	custid int primary key auto_increment,
	custname varchar(20) not null unique,
	custpassword varchar(32) not null,
	custsex TINYINT(1),
	custemail varchar(200),
	custaddress VARCHAR(300)
);
insert into customer(custname,custpassword,custsex,custemail,custaddress) values('admin','admin',0,'admin@jh.com','品川区南大井1-1-1');
select * from customer;

-- company表
DROP TABLE IF EXISTS company;
CREATE TABLE company (
	compid INT PRIMARY KEY auto_increment,
	compusername VARCHAR ( 20 ) NOT NULL UNIQUE,
	comppassword VARCHAR ( 32 ) NOT NULL,
	compname VARCHAR ( 32 ) NOT NULL,
	compemail VARCHAR ( 200 ),
	legalname VARCHAR ( 200 ) ,
	compaddress VARCHAR(255)
);
INSERT INTO company ( compusername, comppassword, compname, compemail, legalname ,compaddress)
VALUES
	( 'admin', 'admin', '日本工学院株式会社', 'admin@gmail.com', '大田太郎','太田区1-1-1' );
SELECT * FROM company;

-- pets表
DROP TABLE IF EXISTS pets;
CREATE TABLE pets (
	id INT PRIMARY KEY auto_increment,
	petsname VARCHAR ( 20 ) NOT NULL UNIQUE,
	species VARCHAR(40) NOT NULL,
	amount INTEGER (3) NOT NULL,
	instruction VARCHAR(255)
-- 	差一个bolb类型的图片（手动添加）
);

INSERT INTO pets (petsname,species,amount,instruction)
VALUES
	('ももちゃん','cat',10,'可愛いももちゃんだよ、今後の人生は一緒に過ごしましょう！');
SELECT * FROM pets;