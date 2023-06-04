create database SMS;

use SMS;

create table Customer(
customer_id int AUTO_INCREMENT not null primary key,
customer_name varchar(50)
);

create table Employee(
employee_id int AUTO_INCREMENT primary key,
employee_name varchar(50),
salary double,
supervisor_id int
);

create table Product(
product_id int AUTO_INCREMENT not null primary key,
product_name varchar(50),
list_price double
);

create table Orders(
order_id int AUTO_INCREMENT primary key,
order_date date,
customer_id int,
employee_id int,
total double,
FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);

create table LineItem(
order_id int,
product_id int,
quantity int,
price double,
CONSTRAINT PK_LineItem PRIMARY KEY (order_id,product_id)
);
INSERT INTO sms.customer(customer_name) values
(N'Thái Minh Đạt'),
(N'Phan Duy Khang'),
(N'Nguyễn Nhật Minh'),
(N'Huỳnh Nguyễn Đức Huy');

INSERT INTO sms.employee(employee_name, salary, supervisor_id) values
(N'Thái Minh Đạt',2000, 1),
(N'Phan Duy Khang',1500,1),
(N'Nguyễn Nhật Minh',1300,1),
(N'Huỳnh Nguyễn Đức Huy',1300,1);

INSERT INTO sms.product(product_name,list_price) values
('TV', 400),
('tu lanh',120),
('may giac',210),
('Laptop gamming XP8000',1450),
('tay nghe AKG',98);

INSERT INTO sms.orders(order_date, customer_id, employee_id, total) values
('2023-05-26',1,2,3),
('2023-05-06',2,3,2),
('2023-05-08',3,1,4),
('2023-03-06',4,2,1),
('2023-03-06',1,4,3),
('2023-12-23',3,2,1);

insert into sms.lineitem(order_id, product_id, quantity, price) values
(1,1,12,)
select * from sms.orders;