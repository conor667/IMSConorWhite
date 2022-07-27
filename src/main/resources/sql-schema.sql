drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE customers (
id  bigint KEY auto_increment ,
first_name varchar(20) ,
surname varchar(20) 
);

CREATE TABLE item (
id bigint Key auto_increment,
itemName varchar(20),
price double
);

CREATE TABLE `order` (
OrderID bigint KEY AUTO_increment,
CustomerID bigint ,
TotalCost int,
DateOrdered DATE
);

Create TABLE OrderedItems (
OrdereditemsId bigint key auto_increment,
OrderId int,
Quantity int
);