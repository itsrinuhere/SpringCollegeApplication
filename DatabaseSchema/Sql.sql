create table student
(
    studentId text,
    name text ,
    batch text,
    emailId text,
    mobile text
);
create  table  project
(
    uniqueId  text primary key,
    studentId text,
    description text,
    tags text,
    url text,
    verificationURL text
);
create table skill(
                      uniqueId text primary key,
                      studentId text,
                      skill text,
                      domain text
);
create table certification(
                              uniqueId text primary key,
                              studentId text,
                              name text,
                              expire date,
                              verification text,
                              certify text
);
create table internship(
                           uniqueID text primary key ,
                           name text,
                           company text,
                           startDate date,
                           EndDate date,studentid text,verification text
);
-- create table resume();

select * from users;