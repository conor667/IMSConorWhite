CREATE DATABASE ims;

USE ims;

CREATE TABLE customers (
id  bigint KEY auto_increment ,
first_name varchar(20) ,
surname varchar(20) 
);

CREATE TABLE item (
ItemId bigint Key auto_increment,
itemName varchar(20),
price double,
stock int
);

CREATE TABLE `order` (
OrderId bigint KEY AUTO_increment,
CustomerId bigint ,
FOREIGN KEY (CustomerId) references customers(id)
);

Create TABLE OrderedItems (
Id bigint key auto_increment,
fk_OrderId bigint ,
fk_itemId bigint,
Quantity int,
TotalCost int,
FOREIGN KEY (fk_OrderId) references `order`(OrderId),
FOREIGN KEY (fk_ItemId) references item(ItemId)
);

