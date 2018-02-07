CREATE SEQUENCE stock_seq start with 101;

CREATE TABLE stock_master(stock VARCHAR2(20), quote NUMBER(7,2));

CREATE TABLE order_master(order_id NUMBER PRIMARY KEY,stock VARCHAR2(20),
quote NUMBER(7,2),order_amount NUMBER(9,2),
commission NUMBER(7,2));

INSERT INTO stock_master values('reliance industries', 894.95);
INSERT INTO stock_master values('TATA steel', 410.65);
INSERT INTO stock_master values('LNT', 1344.95);

drop sequence stock_seq;
drop table order_master;
