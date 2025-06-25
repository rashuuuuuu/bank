-- liquibase formatted sql
-- changeset rashmita.subedi:1

-- preconditions onFail:CONTINUE onError:HALT
-- precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM bank_status
INSERT INTO bank_status (description, icon, name,version)
VALUES
    ('ACTIVE', 'active', 'ACTIVE',0),
    ('INACTIVE', 'deleted', 'INACTIVE',0);
