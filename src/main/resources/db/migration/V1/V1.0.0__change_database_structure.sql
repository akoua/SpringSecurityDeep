-- DROP TABLE IF EXISTS customer;
-- DROP TABLE IF EXISTS authorities;

CREATE TABLE IF NOT EXISTS customer
(
    customer_id        SERIAL PRIMARY KEY,

    name               varchar(255) NOT NULL,
    email              varchar(255) NOT NULL,
    mobile_number      varchar(20)  NOT NULL,
    pwd                varchar(500) NOT NULL,
    role               varchar(100) NOT NULL,
    created_by         varchar(255),
    created_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Last_modified_by   varchar(255),
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS account
(
    account_id         SERIAL PRIMARY KEY,
    customer_id        int          NOT NULL,
    account_type       varchar(100) NOT NULL,
    branch_address     varchar(200) NOT NULL,
    created_by         varchar(255),
    created_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Last_modified_by   varchar(255),
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT customer_ibfk_1 FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS account_transaction
(
    transaction_id      SERIAL PRIMARY KEY,
    account_id          int            NOT NULL,
    customer_id         int            NOT NULL,
    transaction_date    date           NOT NULL,
    transaction_summary varchar(500)   NOT NULL,
    transaction_type    varchar(100)   NOT NULL,
    transaction_amt     NUMERIC(10, 3) NOT NULL,
    closing_balance     NUMERIC(10, 3) NOT NULL,
    created_by          varchar(255),
    created_date        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Last_modified_by    varchar(255),
    last_modified_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     KEY customer_id (customer_id),
--     KEY account_id (account_id),
    CONSTRAINT accounts_ibfk_2 FOREIGN KEY (account_id) REFERENCES account (account_id) ON DELETE CASCADE,
    CONSTRAINT acct_user_ibfk_1 FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
);
--
CREATE TABLE IF NOT EXISTS loan
(
    loan_id            SERIAL PRIMARY KEY,
    customer_id        int            NOT NULL,
    start_dt           date           NOT NULL,
    loan_type          varchar(100)   NOT NULL,
    total_loan         NUMERIC(10, 3) NOT NULL,
    amount_paid        NUMERIC(10, 3) NOT NULL,
    outstanding_amount NUMERIC(10, 3) NOT NULL,
    created_by         varchar(255),
    created_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Last_modified_by   varchar(255),
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     KEY customer_id (customer_id),
    CONSTRAINT loan_customer_ibfk_1 FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS card
(
    card_id            SERIAL PRIMARY KEY,
    card_number        varchar(100) NOT NULL,
    customer_id        int          NOT NULL,
    card_type          varchar(100) NOT NULL,
    total_limit        int          NOT NULL,
    amount_used        int          NOT NULL,
    available_amount   int          NOT NULL,
    created_by         varchar(255),
    created_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Last_modified_by   varchar(255),
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     KEY customer_id (customer_id),
    CONSTRAINT card_customer_ibfk_1 FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS notice_detail
(
    notice_id          SERIAL PRIMARY KEY,
    notice_summary     varchar(200) NOT NULL,
    notice_detail      varchar(500) NOT NULL,
    notic_beg_dt       date         NOT NULL,
    notic_end_dt       date      DEFAULT NULL,
    created_by         varchar(255),
    created_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Last_modified_by   varchar(255),
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS contact_message
(
    contact_id         SERIAL PRIMARY KEY,
    contact_name       varchar(50)   NOT NULL,
    contact_email      varchar(100)  NOT NULL,
    subject            varchar(500)  NOT NULL,
    message            varchar(2000) NOT NULL,
    created_by         varchar(255),
    created_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Last_modified_by   varchar(255),
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);