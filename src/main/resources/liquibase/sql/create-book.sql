CREATE TABLE book(
                     id int8,
                     isbn varchar(255) not null,
                     name varchar(255) not null,
                     author varchar(255) not null,
                     page int8 not null,
                     weight double precision not null,
                     price decimal not null,
                     PRIMARY KEY(id)
);