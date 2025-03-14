create table Person
(
   id integer not null,
   name varchar(255) not null,
   location varchar(255),
   birth_date timestamp,
   primary key(id)
);

INSERT INTO Person (id, name, location, birth_date ) 
VALUES(10001,  'Raja', 'Hyderabad', current_date);
INSERT INTO Person (id, name, location, birth_date ) 
VALUES(10002,  'Sathya', 'Bangalore', current_date);
INSERT INTO Person (id, name, location, birth_date ) 
VALUES(10003,  'Mani', 'Chennai', current_date);