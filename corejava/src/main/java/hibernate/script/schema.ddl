drop table if exists EVENTS;
create table EVENTS("EVENT_ID" varchar(40) not null, "EVENT_DATE" timestamp, "TITLE" varchar(10));

drop table if exists PERSON_EVENT;
create table PERSON_EVENT("EVENT_ID" varchar(40) not null, "PERSON_ID" varchar(40) not null);

drop table if exists PERSON;
create table PERSON("PERSON_ID" varchar(40) not null, "AGE" int(2), "FIRSTNAME" varchar(10), "LASTNAME" varchar(10));

drop table if exists PERSON_EMAIL_ADDR;
create table PERSON_EMAIL_ADDR("PERSON_ID" varchar(40) not null, "EMAIL_ADDR" varchar(100) not null);
