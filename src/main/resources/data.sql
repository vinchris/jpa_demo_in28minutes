insert into course(id, fullname,created_date,last_updated_date)
values(1001L, 'JPA in 50 steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
insert into course(id, fullname,created_date,last_updated_date)
values(1002, 'JPA in 100 steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
insert into course(id, fullname,created_date,last_updated_date)
values(1003, 'JPA in 150 steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());

insert into student (id, name) values(2001, 'Cristi');
insert into student (id, name) values(2002, 'Max');
insert into student (id, name) values(2003, 'Alice');
insert into student (id, name) values(2004, 'Jessica');

insert into passport (id, number) values(4001, 'E12345667');
insert into passport (id, number) values(4002, 'E12345668');
insert into passport (id, number) values(4003, 'E12345669');
insert into passport (id, number) values(4004, 'F12345667');

insert into review (id, rating, description) values(5001, '5', 'Great');
insert into review (id, rating, description) values(5002, '5', 'Good course');
insert into review (id, rating, description) values(5003, '4', 'Very detailed, I liked it');
insert into review (id, rating, description) values(5004, '5', 'Insightful and useful');