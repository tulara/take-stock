create table products (
  PRODUCT_ID SERIAL PRIMARY KEY,
  TITLE varchar(255) not null,
  AUTHOR varchar(255) not null,
  IN_STOCK integer not null
);

create table inventory (
    PRODUCT_ID integer REFERENCES products(PRODUCT_ID),
    ISBN varchar(15) not null PRIMARY KEY
);