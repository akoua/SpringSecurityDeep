ALTER TABLE IF EXISTS authority
    ADD COLUMN created_by         varchar(255),
    ADD COLUMN created_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ADD COLUMN Last_modified_by   varchar(255),
    ADD COLUMN last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP;