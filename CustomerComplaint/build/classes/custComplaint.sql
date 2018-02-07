--DROP TABLE complaint;
CREATE TABLE complaint(
complaintid number PRIMARY KEY,
accountid number,
branchcode varchar2(20),
emailid varchar2(20),
category varchar2(20),
description varchar2(300),
priority varchar2(10),
status varchar2(20)
);


CREATE SEQUENCE hibernate_sequence;

INSERT INTO COMPLAINT VALUES (3145, 6873842, 'FCFC2', 'tina@igate.com', 'Internate Banking', 'Net Banking account is locked','High','Closed');

INSERT INTO COMPLAINT VALUES (3146, 6873845, 'FCFC2', 'paiva@igate.com', 'Internate Banking', 'Net Banking account is locked','High','Work in progress');

select * from complaint;
--Commit;