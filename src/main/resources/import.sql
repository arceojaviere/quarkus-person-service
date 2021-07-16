-- Persons
insert into PERSON(ID, name, lastname) values('1','Person','One');
insert into PERSON(ID, name, lastname) values('2','Person','Two');
insert into PERSON(ID, name, lastname) values('3','Person','Three');
insert into PERSON(ID, name, lastname) values('4','Person','Four');
insert into PERSON(ID, name, lastname) values('5','Person','Five');
insert into PERSON(ID, name, lastname) values('6','Person','Six');

-- Emails
insert into PERSON_EMAILS(PERSON_ID, EMAIL_ADDRESS) VALUES ('1', 'personone@email1.com');
insert into PERSON_EMAILS(PERSON_ID, EMAIL_ADDRESS) VALUES ('1', 'personone@email2.com');
insert into PERSON_EMAILS(PERSON_ID, EMAIL_ADDRESS) VALUES ('1', 'personone@email3.com');

insert into PERSON_EMAILS(PERSON_ID, EMAIL_ADDRESS) VALUES ('2', 'persontwo@email1.com');

insert into PERSON_EMAILS(PERSON_ID, EMAIL_ADDRESS) VALUES ('3', 'personthree@email1.com');

insert into PERSON_EMAILS(PERSON_ID, EMAIL_ADDRESS) VALUES ('4', 'personfour@email1.com');

insert into PERSON_EMAILS(PERSON_ID, EMAIL_ADDRESS) VALUES ('5', 'personfive@email1.com');

insert into PERSON_EMAILS(PERSON_ID, EMAIL_ADDRESS) VALUES ('6', 'personsix@email1.com');