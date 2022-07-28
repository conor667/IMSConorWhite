
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS order;

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
	OrderId BIGINT AUTO_increment,
	CustomerId BIGINT,
	FOREIGN KEY (CustomerId) references customers(id)
	PRIMARY KEY (`order`)
);