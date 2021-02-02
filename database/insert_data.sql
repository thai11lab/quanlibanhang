use estatejdbc82019;

insert into role(code,name) values('MANAGER','Quản lí');
insert into role(code,name) values('STAFF','Nhân viên');

insert into user(username,password,fullname,status) values('damanhthai','123456','Đàm Anh Thái',1);
insert into user(username,password,fullname,status) values('nguyenvanb','123456','Nguyễn Văn B',1);
insert into user(username,password,fullname,status) values('nguyenvanc','123456','Nguyễn Văn C',1);
insert into user(username,password,fullname,status) values('nguyenvand','123456','Nguyễn Văn D',1);

insert into user_role(userid,roleid)values(1,1);
insert into user_role(userid,roleid)values(2,2);
insert into user_role(userid,roleid)values(3,2);
insert into user_role(userid,roleid)values(4,2);