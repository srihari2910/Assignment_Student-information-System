create database sisdb;
use sisdb;

create table Students
(
student_id int primary key auto_increment,
first_name varchar(50) not null,
last_name varchar(50) not null,
date_of_birth Date,
email varchar(200) unique,
phone_number varchar(15)
);

create table Teacher
(
teacher_id int primary key auto_increment,
first_name varchar(100),
last_name varchar(100),
email varchar(100) unique
);

create table Courses
(
course_id int primary key auto_increment,
course_name varchar(100),
credits int,
teacher_id int,
foreign key (teacher_id) references Teacher(teacher_id)
);

create table enrollments
(
enrollment_id int primary key auto_increment,
student_id int,
course_id int,
enrollment_date date,
foreign key (student_id) references Students(student_id) on delete cascade,
foreign key (course_id) references Courses(course_id)
);

create table Payments
(
payment_id int primary key,
student_id int,
amount int,
payment_date date,
foreign key (student_id) references Students(student_id)
);

insert into Students (first_name,last_name,date_of_birth,email,phone_number) values ('aswin','k','2001-10-30','aswin.kumar@gmail.com','637367907');
insert into Students (first_name,last_name,date_of_birth,email,phone_number) values ('vijay','s','2001-10-29','vijay.kumar@gmail.com','9834657895');
insert into Students (first_name,last_name,date_of_birth,email,phone_number) values ('vishnu','m','2001-01-30','vishnu.m@gmail.com','6345678594');
insert into Students (first_name,last_name,date_of_birth,email,phone_number) values ('srinath','l','2001-05-15','srinath.r@gmail.com','7367907356');
insert into Students (first_name,last_name,date_of_birth,email,phone_number) values ('subiksha','k','2001-08-20','subi.a@gmail.com','67367907423');
insert into Students (first_name,last_name,date_of_birth,email,phone_number) values ('ayesha','k','2001-04-24','ayesha.s@gmail.com','9894356767');
insert into Students (first_name,last_name,date_of_birth,email,phone_number) values ('vikram','s','2001-06-20','vikram.kumar@gmail.com','9894975432');
insert into Students (first_name,last_name,date_of_birth,email,phone_number) values ('krishna','k','2001-08-04','sri.krishna@gmail.com','8098165117');
insert into Students (first_name,last_name,date_of_birth,email,phone_number) values ('ajay','g','2001-01-15','ajay.k@gmail.com','9597844463');
insert into Students (first_name,last_name,date_of_birth,email,phone_number) values ('gopi','v','2001-12-20','gopi.krish@gmail.com','9942560570');

insert into Teacher (teacher_id,first_name,last_name,email) values ('1','harish','n','harish.n@gmail.com');
insert into Teacher (teacher_id,first_name,last_name,email) values ('2','murali','m','murali.m@gmail.com');
insert into Teacher (teacher_id,first_name,last_name,email) values ('3','pradeep','v','pradeep.n@gmail.com');
insert into Teacher (teacher_id,first_name,last_name,email) values ('4','radha','n','radha.n@gmail.com');
insert into Teacher (teacher_id,first_name,last_name,email) values ('5','vignesh','h','vicky.s@gmail.com');
insert into Teacher (teacher_id,first_name,last_name,email) values ('6','dhilip','n','dhilip.g@gmail.com');
insert into Teacher (teacher_id,first_name,last_name,email) values ('7','rahul','e','rahul.e@gmail.com');
insert into Teacher (teacher_id,first_name,last_name,email) values ('8','muhil','a','muhil.a@gmail.com');
insert into Teacher (teacher_id,first_name,last_name,email) values ('9','bala','b','bala.b@gmail.com');
insert into Teacher (teacher_id,first_name,last_name,email) values ('10','raja','s','raja.s@gmail.com');

insert into Courses (course_id, course_name, credits, teacher_id) values (1, 'Data Structures', 4, 1);
insert into Courses (course_id, course_name, credits, teacher_id) values (2, 'Database Systems', 3, 2);
insert into Courses (course_id, course_name, credits, teacher_id) values (3, 'Operating Systems', 4, 3);
insert into Courses (course_id, course_name, credits, teacher_id) values (4, 'Computer Networks', 3, 4);
insert into Courses (course_id, course_name, credits, teacher_id) values (5, 'Software Engineering', 3, 5);
insert into Courses (course_id, course_name, credits, teacher_id) values (6, 'Machine Learning', 4, 6);
insert into Courses (course_id, course_name, credits, teacher_id) values (7, 'Web Development', 3, 7);
insert into Courses (course_id, course_name, credits, teacher_id) values (8, 'Cloud Computing', 3, 8);
insert into Courses (course_id, course_name, credits, teacher_id) values (9, 'Cybersecurity', 3, 9);
insert into Courses (course_id, course_name, credits, teacher_id) values (10, 'Artificial Intelligence', 4, 10);

insert into Enrollments (enrollment_id, student_id, course_id, enrollment_date) values
(1, 1, 1, '2024-07-01'),
(2, 2, 2, '2024-07-02'),
(3, 3, 3, '2024-07-03'),
(4, 4, 4, '2024-07-04'),
(5, 5, 5, '2024-07-05'),
(6, 6, 6, '2024-07-06'),
(7, 7, 7, '2024-07-07'),
(8, 8, 8, '2024-07-08'),
(9, 9, 9, '2024-07-09'),
(10, 10, 10, '2024-07-10');

insert into Payments (payment_id, student_id, amount, payment_date) values
(1, 1, 5000, '2024-07-01'),
(2, 2, 4500, '2024-07-02'),
(3, 3, 4800, '2024-07-03'),
(4, 4, 4700, '2024-07-04'),
(5, 5, 4600, '2024-07-05'),
(6, 6, 5000, '2024-07-06'),
(7, 7, 4900, '2024-07-07'),
(8, 8, 4800, '2024-07-08'),
(9, 9, 4700, '2024-07-09'),
(10, 10, 4600, '2024-07-10');

-- Task 2

insert into students(first_name,last_name,date_of_birth,email,phone_number) values('John','Doe','1995-08-15','john.doe@example.com','1234567890');

insert into enrollments(student_id,course_id,enrollment_date) values(1,1,current_date());

update teacher set email='harish.a@gmail.com' where teacher_id=1;

delete from enrollments where student_id=2 and course_id=2;

update courses set teacher_id=4 where course_id=1;

alter table Payments drop foreign key payments_ibfk_1;

alter table Payments
add constraint fk_payments_student
foreign key (student_id) references Students(student_id)
on delete cascade;

delete from students where student_id=9;

update payments set amount=1000 where payment_id=1;


-- Task 3
select s.first_name, SUM(p.amount) as total_payment
from students s join payments p on s.student_id = p.student_id
where s.student_id = 1
group by s.first_name;

select c.course_name, COUNT(e.student_id) as num_students
from courses c left join enrollments e on c.course_id = e.course_id
group by c.course_name;

select s.first_name from students s
left join enrollments e on s.student_id = e.student_id
where e.course_id is null;

select s.first_name, s.last_name, c.course_name
from students s
join enrollments e on s.student_id = e.student_id
join courses c on e.course_id = c.course_id;

select t.first_name, t.last_name, c.course_name
from teacher t
left join courses c on t.teacher_id = c.teacher_id;

select s.first_name, e.enrollment_date
from students s
join enrollments e on s.student_id = e.student_id
where e.course_id = 1;

select s.first_name from students s
left join payments p on s.student_id = p.student_id
where p.payment_id is null;

select c.course_name from courses c
left join enrollments e on c.course_id = e.course_id
where e.enrollment_id is null;

select student_id
from enrollments
group by student_id
having COUNT(course_id) > 1;

select t.first_name from teacher t
left join courses c on t.teacher_id = c.teacher_id
where c.course_id is null;

-- Task 4

select avg(enrollment_count) from (
  select COUNT(*) as enrollment_count from enrollments group by course_id
) as sub;

select s.first_name, p.amount from students s
join payments p on s.student_id = p.student_id
where p.amount = (select MAX(amount) from Payments);

select course_id from enrollments
group by course_id
having COUNT(*) = (select MAX(enrollment_count) from (select COUNT(*) as enrollment_count from enrollments group by course_id) as sub);

select t.teacher_id, t.first_name,
  (select SUM(p.amount)
   from payments p
   join enrollments e on p.student_id = e.student_id
   where e.course_id in (select course_id from courses where teacher_id = t.teacher_id)
  ) as total_payments from teacher t;
  
select student_id from enrollments
group by student_id
having count(distinct course_id) = (select count(*) from courses);

select teacher_id from teacher where teacher_id not in (select teacher_id from courses);

select avg(TIMESTAMPDIFF(year, date_of_birth, CURDATE())) as avg_age from students;

select course_id from Courses where course_id not in (select distinct course_id from enrollments);

select student_id, course_id,(select SUM(amount) from payments where student_id = e.student_id) as total_payment
from enrollments e;

select student_id from payments group by student_id having COUNT(payment_id) > 1;

select s.student_id, s.first_name, SUM(p.amount) as total_payment
from students s
join payments p on s.student_id = p.student_id
group by s.student_id;

select c.course_name, COUNT(e.student_id)
from courses c join enrollments e on c.course_id = e.course_id
group by c.course_name;

select s.student_id, AVG(p.amount) as avg_payment
from students s
join payments p on s.student_id = p.student_id
group by s.student_id;
use sisdb;
select * from students;

select * from students;