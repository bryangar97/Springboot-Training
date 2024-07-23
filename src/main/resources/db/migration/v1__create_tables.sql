CREATE TABLE product (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  short_description varchar(255) NOT NULL,
  description varchar(255) NOT NULL,
  price double NOT NULL,
  stock int NOT NULL,
  rating double NOT NULL
);