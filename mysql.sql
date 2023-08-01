CREATE DATABASE product;
USE product;
drop database product;
CREATE TABLE products (
    productId INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255)
);

CREATE TABLE  reviews (
    reviewId INT AUTO_INCREMENT PRIMARY KEY,
    productId INT NOT NULL,
    customerName VARCHAR(100) NOT NULL,
    rating INT NOT NULL,
    comment VARCHAR(255),
    FOREIGN KEY (productId) REFERENCES products (productId)
);
desc reviews;
desc products;
drop database product;
desc reviews;
desc products;
drop database product;
select * from products;
select * from reviews;
show tables ;