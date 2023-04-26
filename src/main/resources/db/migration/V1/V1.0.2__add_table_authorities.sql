CREATE TABLE IF NOT EXISTS authority
(
    authority_id SERIAL PRIMARY KEY,
    customer_id  int         NOT NULL,
    name         varchar(50) NOT NULL,
    CONSTRAINT authority_ibfk_1 FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
);