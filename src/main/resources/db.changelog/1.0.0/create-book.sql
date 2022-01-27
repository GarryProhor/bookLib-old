CREATE TABLE emprecord.book(
    id int,
    isbn varchar(255) not null,
    name varchar(255) not null,
    author varchar(255) not null,
    page int,
    weight double,
    price decimal,
    PRIMARY KEY(id)
)
    Next_command