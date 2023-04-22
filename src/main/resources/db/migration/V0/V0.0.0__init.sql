CREATE TABLE authorities
(
    id        int         NOT NULL,
    username  varchar(45) NOT NULL,
    authority varchar(45) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE customer
(
    id     int         NOT NULL,
    number varchar(45) NOT NULL,
    pwd    varchar     NOT NULL,
    role   varchar(45) NOT NULL,
    PRIMARY KEY (id)
);

