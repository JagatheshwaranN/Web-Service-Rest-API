insert into user_details(id, name, dob) values (10001, 'John', current_date);
insert into user_details(id, name, dob) values (10002, 'Alex', current_date);
insert into user_details(id, name, dob) values (10003, 'Erick', current_date);

insert into post(id, description, user_id) values (20001, 'I want to learn AWS', 10001);
insert into post(id, description, user_id) values (20002, 'I want to learn SpringBoot', 10001);
insert into post(id, description, user_id) values (20003, 'I want to learn SpingMVC', 10002);
insert into post(id, description, user_id) values (20004, 'I want to learn Rest API', 10002);