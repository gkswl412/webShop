
create table member2(
	mid number primary key,
	mpassword varchar2(20),
	mname varchar2(50),
	phone varchar2(20),
	address varchar2(100),
	email varchar2(20)
);

insert into member2 
values(1, '1234', 'jeonghyeon', 
'010-5720-6629','서울시 송파구', 'gkswl412@naver.com');

select * from member2;

create table t_member(
	id varchar2(10) primary key,
	pwd varchar2(20),
	name varchar2(50),
	email varchar2(20),
	joinDate date
);

insert into t_member values('gkswl412','1234','박정현',
'gkswl412@naver.com','2021-10-22');

select * from t_member;