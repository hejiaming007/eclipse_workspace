-- create the database R2_RBAC using codeset UTF-8 territory US
-- connect to R2_RBAC 
-- grant DBADM,CREATETAB,BINDADD,CONNECT,CREATE_NOT_FENCED,IMPLICIT_SCHEMA,LOAD on database to user gwis

-- connect to R2_SIGNON user gwis;

drop table if exists SSO_HISTORY;
create table SSO_HISTORY("SESSION_ID" varchar(36) not null, "USER_ID" varchar(18) not null, "LOGIN_TIME" timestamp, "LOGOUT_TIME" timestamp, "USER_LOCATION" varchar(256));
alter table SSO_HISTORY add primary key ("SESSION_ID");

drop table if exists SSO_SITE_GROUPS;
create table SSO_SITE_GROUPS("GROUP_NAME" varchar(36) not null, "GROUP_DESC" varchar(256));
alter table SSO_SITE_GROUPS add primary key ("GROUP_NAME");

drop table if exists SSO_SITES;
create table SSO_SITES("GROUP_NAME" varchar(36) not null, "SITE_NAME" varchar(36) not null, "SITE_DESC" varchar(254) , "SITE_LOCATION" varchar(254));
alter table SSO_SITES add primary key ("GROUP_NAME","SITE_NAME");
alter table SSO_SITES add foreign key ("GROUP_NAME") references SSO_SITE_GROUPS("GROUP_NAME") on delete cascade;

-- disconnect current;
