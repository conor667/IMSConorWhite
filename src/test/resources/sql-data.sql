INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `item` (`itemName`, `price`, `stock`) VALUES ('spoon', 3, 3);
INSERT INTO `order` (OrderId, customerId) VALUES (1,1);
INSERT INTO `OrderedProducts` (fk_Orderid, fk_itemId, Quantity) values (1L,1L,199);