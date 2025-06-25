-- liquibase formatted sql
-- changeset rashmita.subedi:1

-- preconditions onFail:CONTINUE onError:HALT
INSERT INTO bank (version, name, bank_status,code,established_date,branch_code,address)
VALUES (0, 'prabhu','ACTIVE', uuid(), "2018/12/2","hdsy6sjsj","dhading"),
       (0, 'nic','ACTIVE', uuid(), "2016/11/3","hello2hell","pokhara"),
       (0, 'kumari','ACTIVE', uuid(), "2003/4/5","hiielelo","lalitpur");
