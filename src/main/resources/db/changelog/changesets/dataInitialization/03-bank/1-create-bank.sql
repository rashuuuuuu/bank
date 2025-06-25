-- liquibase formatted sql
-- changeset rashmita.subedi:1

CREATE TABLE IF NOT EXISTS bank
(
    id                      BIGINT AUTO_INCREMENT     NOT NULL PRIMARY KEY,
    version                 BIGINT                    NOT NULL,
    name                    VARCHAR(255)              NOT NULL,
    address                 VARCHAR(255)              NOT NULL,
    code                    VARCHAR(255)              NOT NULL,
    established_date        DATE                      NOT NULL,
    bank_status             VARCHAR(255)              NOT NULL,
    branch_code             VARCHAR(255)              NOT NULL
    );
-- --changeset rashmita.subedi:2
-- --precondition-on-fail:MARK_RAN
-- --preconditions
-- --precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM information_schema.table_constraints WHERE constraint_schema = (SELECT DATABASE()) AND table_name = 'bank' AND constraint_name = 'FK_BANK_ON_BANK_STATUS'
-- ALTER TABLE bank
--     ADD CONSTRAINT FK_BANK_ON_BANK_STATUS FOREIGN KEY (bank_status) REFERENCES bank_status (id);

-- --changeset rashmita.subedi:3
-- --precondition-on-fail:MARK_RAN
-- --preconditions
-- --precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM information_schema.table_constraints WHERE constraint_schema = (SELECT DATABASE()) AND table_name = 'bank' AND constraint_name = 'FK_BANK_ON_BANK_TYPE'
-- ALTER TABLE bank
--     ADD CONSTRAINT FK_BANK_ON_BANK_TYPE FOREIGN KEY (bank_type) REFERENCES bank_type (id);