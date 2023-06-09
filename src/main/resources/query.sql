-- Database: enterprise

-- DROP DATABASE IF EXISTS enterprise;

CREATE DATABASE enterprise
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
	
	-- Database: enterprise
-- DROP DATABASE IF EXISTS enterprise;

CREATE DATABASE enterprise
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

\c enterprise;

create table account(
	_id varchar(255),
	address varchar(255),
	businessAddress varchar(255),
	businessName varchar(255),
	name varchar(255),
	password varchar(255),
	profilePicture varchar(2550),
	type varchar(255),
	username varchar(255)
);

COPY account (_id, address, businessAddress, businessName, name, password, profilePicture, type, username)
	FROM 'test.csv'
	DELIMITER ';'
	CSV HEADER;



create table products(
	_id varchar(255),
	description varchar(25500),
	image varchar(25500),
	name varchar(2550),
	price varchar(255),
	vendor varchar(255)
);

COPY products (_id, description, image, name, price, vendor)
	FROM 'products.csv'
	DELIMITER ','
	CSV HEADER;


create table orders(
	_id varchar(255),
	activity varchar(25500),
	orderAddress varchar(2550),
	ordererName varchar(25500),
	productList varchar(2550)
);

COPY orders (_id, activity, orderAddress, ordererName, productList)
	FROM 'orders.csv'
	DELIMITER ';'
	CSV HEADER;

select * from account;

select * from products;

select * from orders;