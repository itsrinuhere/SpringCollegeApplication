create table certification
(
    uniqueid     text not null
        primary key,
    studentid    text,
    name         text,
    expire       date,
    verification text,
    certify      text
);
create table experience
(
    experienceid   text not null
        primary key,
    userid         text not null,
    experiencetype text not null,
    exfrom         date,
    exto           date,
    company        text,
    designation    text
);
create table faculty
(
    userid        text not null
        primary key,
    name          text,
    gender        text,
    dob           date,
    department    text,
    contactnumber text,
    address       text,
    designation   text,
    emailid       text,
    url           text
);