-- 주소테이블
DROP TABLE IF EXISTS user_address;
CREATE TABLE IF NOT EXISTS user_address(
	address_no int PRIMARY KEY AUTO_INCREMENT,
	post_no int NOT NULL,
	city varchar(255) NOT NULL,
	address_1 varchar(255) NOT NULL,
	address_2 varchar(255) NOT NULL
	)ENGINE = innodb;

-- 유저테이블
DROP TABLE IF EXISTS yyc_user;
CREATE TABLE IF NOT EXISTS yyc_user(
	user_no int PRIMARY KEY AUTO_INCREMENT,
	user_name varchar(255) NOT NULL,
	date_of_birth date,
	gender varchar(5),
	contact_no int NOT NULL,
	address_no int NOT NULL,
	FOREIGN key(address_no)
	REFERENCES user_address(address_no)	
	)ENGINE = innodb;

-- 인증테이블
DROP TABLE IF EXISTS auth;
CREATE TABLE IF NOT EXISTS auth(
	user_no int NOT NULL,
	user_id varchar(255) NOT NULL UNIQUE,
	user_password varchar(255) NOT NULL,
	FOREIGN KEY(user_no)
	REFERENCES yyc_user(user_no)	
	)ENGINE = innodb;

-- 블랙리스트테이블
DROP TABLE IF EXISTS black_list;
CREATE TABLE IF NOT EXISTS black_list(
	black_no int PRIMARY KEY AUTO_INCREMENT,
	user_no int NOT NULL,
	user_name varchar(255) NOT NULL,
	black_address varchar(255) NOT NULL,
	FOREIGN KEY(user_no)
	REFERENCES yyc_user(user_no)
	)ENGINE = innodb;

-- 판매자테이블
DROP TABLE IF EXISTS seller;
CREATE TABLE IF NOT EXISTS seller(
	seller_no int PRIMARY KEY AUTO_INCREMENT,
	seller_name varchar(255) NOT NULL,
	user_no int NOT NULL,
	FOREIGN KEY(user_no)
	REFERENCES yyc_user(user_no)	
	)ENGINE = innodb;

-- 상품테이블
DROP TABLE IF EXISTS product;
CREATE TABLE IF NOT EXISTS product(
	product_no int PRIMARY KEY AUTO_INCREMENT,
	seller_no int NOT NULL,
	product_name varchar(255) NOT NULL,
	product_price int NOT NULL DEFAULT 0, 
	product_stock int NOT NULL DEFAULT 0,
	product_yn varchar(3) NOT NULL,
	FOREIGN KEY(seller_no)
	REFERENCES seller(seller_no)
	)ENGINE = innodb;

-- 주문 테이블
DROP TABLE IF EXISTS order_service;
CREATE TABLE IF NOT EXISTS order_service(
	order_no int PRIMARY KEY AUTO_INCREMENT,
	user_no int NOT NULL,
	seller_no int NOT NULL,
	FOREIGN KEY(user_no)
	REFERENCES yyc_user(user_no),
	FOREIGN KEY(seller_no)
	REFERENCES seller(seller_no)
	)ENGINE = innodb;
	
--  상세주문 테이블
DROP TABLE IF EXISTS detail_order;
CREATE TABLE IF NOT EXISTS detail_order(
	detail_order_no int PRIMARY KEY AUTO_INCREMENT,
	order_no int NOT NULL,
	user_no int NOT NULL,
	seller_no int NOT NULL,
	product_no int NOT NULL,
	date_of_trade date NOT NULL,
	FOREIGN KEY(user_no)
	REFERENCES yyc_user(user_no),
	FOREIGN KEY(order_no)
	REFERENCES order_service(order_no),
	FOREIGN KEY(seller_no)
	REFERENCES seller(seller_no),
	FOREIGN KEY(product_no)
	REFERENCES product(product_no)
	)ENGINE = innodb;
	
-- 테이블 확인
SHOW tables;

