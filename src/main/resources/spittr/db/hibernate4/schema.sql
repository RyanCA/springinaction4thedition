drop table if exists spittle;
drop table if exists spitter;

create table spitter (
  id identity,
  firstname varchar(25),
  lastname varchar(25),
  username varchar(25),
  password varchar(25),
  email varchar(50),
);

create table spittle (
  id integer identity primary key,
  spitter integer not null,
  message varchar(2000),
  time datetime,
  foreign key (spitter) references spitter(id)
);
