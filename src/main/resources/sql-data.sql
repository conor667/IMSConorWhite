INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `ims`.`item` (`itemName`, `price`, `stock`) VALUES ('phone', 299, 3);
INSERT INTO `ims`.`order` (customerId) VALUES (1);
INSERT INTO `ims`.`Ordereditems` (fk_OrderId, fk_itemId, Quantity) VALUES (1, 1, 2);
