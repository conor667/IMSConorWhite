
DROP TABLE IF EXISTS OrderedItems;
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS item;


CREATE TABLE IF NOT EXISTS customers (
    id INT(11) NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(40) DEFAULT NULL,
    surname VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS item (
	ItemId BIGINT AUTO_INCREMENT,
	itemName VARCHAR(20),
	price INT,
	stock INT,
	PRIMARY KEY (`ItemId`)
);

CREATE TABLE IF NOT EXISTS `order` (
	OrderId BIGINT AUTO_INCREMENT,
	CustomerId INT,
	PRIMARY KEY (`OrderId`),
	FOREIGN KEY (`CustomerId`) references customers(`id`)
);

CREATE TABLE IF NOT EXISTS OrderedItems (
	Id BIGINT AUTO_INCREMENT,
	fk_OrderId BIGINT ,
	fk_itemId BIGINT,
	Quantity INT,
	TotalCost INT,
	PRIMARY KEY (`Id`),
	FOREIGN KEY (fk_OrderId) references `order`(OrderId),
	FOREIGN KEY (fk_itemId) references item(ItemId)
);