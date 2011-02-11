-- create  database GSF_GWS using codeset UTF-8 territory US
-- connect to GSF_GWS
-- grant DBADM,CREATETAB,BINDADD,CONNECT,CREATE_NOT_FENCED,IMPLICIT_SCHEMA,LOAD on database to user gwis

-- connect to GSF_GWS user gwis using pdcitage

drop table GSE_WORKDAYS;

-- GSE_WORKDAYS
-- drop table GSE_WORKDAYS
create table GSE_WORKDAYS (WORK_DAY date not null, START_TIME timestamp not null, END_TIME timestamp);
alter table GSE_WORKDAYS add primary key ("WORK_DAY");

drop table GSE_PREFS;
create table GSE_PREFS (PROP_NAME varchar(256) not null, PROP_VALUE varchar(256));