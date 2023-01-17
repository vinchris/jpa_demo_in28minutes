insert into course(id, name,created_date,last_updated_date)
values(1001, 'Data JPA in 50 steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
insert into course(id, name,created_date,last_updated_date)
values(1002, 'Spring JPA in 100 steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
insert into course(id, name,created_date,last_updated_date)
values(1003, 'Hibernate in 150 steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
insert into course(id, name,created_date,last_updated_date)
values(1004, 'Dummy Course 1',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
insert into course(id, name,created_date,last_updated_date)
values(1005, 'Dummy Course 2',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
insert into course(id, name,created_date,last_updated_date)
values(1006, 'Dummy Course 3',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
insert into course(id, name,created_date,last_updated_date)
values(1007, 'Dummy Course 4',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
insert into course(id, name,created_date,last_updated_date)
values(1008, 'Dummy Course 5',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
insert into course(id, name,created_date,last_updated_date)
values(1009, 'Dummy Course 6',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());

insert into passport (id, number) values(4001, 'E1234567');
insert into passport (id, number) values(4002, 'E1234568');
insert into passport (id, number) values(4003, 'E1234569');
insert into passport (id, number) values(4004, 'F1234567');

insert into student (id, name, passport_id) values(2001, 'Cristi', 4001);
insert into student (id, name, passport_id) values(2002, 'Max', 4002);
insert into student (id, name, passport_id) values(2003, 'Alice', 4003);
insert into student (id, name, passport_id) values(2004, 'Jessica', 4004);

insert into review (id, rating, description, course_id) values(5001, '5', 'Great', 1001);
insert into review (id, rating, description, course_id) values(5002, '5', 'Good course', 1001);
insert into review (id, rating, description, course_id) values(5003, '4', 'Very detailed, I liked it', 1002);
insert into review (id, rating, description, course_id) values(5004, '5', 'Insightful and useful', 1003);

insert into student_course(student_id, course_id) values(2001, 1001);
insert into student_course(student_id, course_id) values(2002, 1001);
insert into student_course(student_id, course_id) values(2003, 1001);
insert into student_course(student_id, course_id) values(2001, 1003);