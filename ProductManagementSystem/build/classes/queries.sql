create sequence Seq_Pro_id start with 1000;

drop table Product cascade constraint;

create table Product(
	id number(7),
	name varchar2(50),
	price number(8,2),
	quantity number(6),
	category varchar2(20),
	canBeShippedAbroad varchar2(4),
	primary key (id)
);

select * from PRODUCT;