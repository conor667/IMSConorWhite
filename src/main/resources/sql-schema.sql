CREATE DATABASE ims;

USE ims;

CREATE TABLE customers (
id  bigint KEY auto_increment ,
first_name varchar(20) ,
surname varchar(20) 
);
DROP TABLE customers;

CREATE TABLE item (
id bigint Key auto_increment,
itemName varchar(20),
price double
);

CREATE TABLE `order` (
OrderId bigint KEY AUTO_increment,
CustomerId bigint ,
FOREIGN KEY (CustomerId) references customers(id)
);
DROP TABLE `order`;

SELECT * FROM customers;
SELECT * FROM item;
SELECT * FROM `order`;
SELECT * FROM OrderedItems;

Create TABLE OrderedItems (
Id bigint key auto_increment,
OrderId bigint ,
ItemId bigint,
Quantity int,
FOREIGN KEY (OrderId) references `order`(OrderId),
FOREIGN KEY (ItemId) references item (id)
);
DROP TABLE OrderedItems;

SELECT * FROM customers;
SELECT * FROM `order`;
