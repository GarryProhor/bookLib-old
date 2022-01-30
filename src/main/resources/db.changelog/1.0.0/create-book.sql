CREATE TABLE book(
    id int auto_increment,
    isbn varchar(255) not null,
    name varchar(255) not null,
    author varchar(255) not null,
    page int,
    weight double,
    price decimal,
    PRIMARY KEY(id)
);
