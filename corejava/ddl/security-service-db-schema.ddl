-- create the database R2_SEC using codeset UTF-8 territory US
-- connect to R2_SEC
-- grant DBADM,CREATETAB,BINDADD,CONNECT,CREATE_NOT_FENCED,IMPLICIT_SCHEMA,LOAD on database to user gwis

-- connect to R2_SEC user gwis

drop table IF EXISTS SEC_PRIN_PERMS;
drop table IF EXISTS SEC_USER_ROLES;
drop table IF EXISTS SEC_USER_GROUPS;
drop table IF EXISTS SEC_GROUP_ROLES;
drop table IF EXISTS SEC_CREDENTIALS;
drop table IF EXISTS SEC_PERMISSIONS;
drop table IF EXISTS SEC_PRINCIPALS;
drop table IF EXISTS SEC_AUDIT_LOG;

-- drop table SEC_PRINCIPALS
create table SEC_PRINCIPALS("PRINCIPAL_ID" varchar(36) not null, "CLASS_NAME" varchar(100) not null, "FULL_PATH" varchar(254) not null, "PARENT_ID" varchar(36), "ALIAS" varchar(36), "CREATED_TIME" timestamp not null, "MODIFIED_TIME" timestamp not null, "DESCRIPTION" varchar(254));
-- alter table SEC_PRINCIPALS add column "ALIAS" varchar(36)
-- alter table SEC_PRINCIPALS add column "DESCRIPTION" varchar(254)
alter table SEC_PRINCIPALS add primary key ("PRINCIPAL_ID");
alter table SEC_PRINCIPALS add constraint UIX_SEC_PRINS unique ("FULL_PATH");

-- drop table SEC_PERMISSIONS
create table SEC_PERMISSIONS("PERMISSION_ID" varchar(36) not null, "CLASS_NAME" varchar(100) not null, "NAME" varchar(254) not null, "ACTIONS" varchar(254) not null, "CREATED_TIME" timestamp not null, "MODIFIED_TIME" timestamp not null);
alter table SEC_PERMISSIONS add primary key ("PERMISSION_ID");

-- drop table SEC_CREDENTIALS
create table SEC_CREDENTIALS("CREDENTIAL_ID" varchar(36) not null, "USER_FULL_PATH" varchar(36) not null, "VALUE" varchar(254) not null, "TYPE" smallint not null, "CLASS_NAME" varchar(100) not null, "UPDATE_REQUIRED" smallint not null, "IS_ENCODED" smallint not null, "IS_ENABLED" smallint not null, "AUTH_FAILURES" smallint not null, "IS_EXPIRED" smallint not null, "CREATED_TIME" timestamp not null, "MODIFIED_TIME" timestamp not null, "PREV_AUTH_TIME" timestamp, "LAST_AUTH_TIME" timestamp, "EXPIRATION_DATE" date);
alter table SEC_CREDENTIALS add primary key ("CREDENTIAL_ID");
-- alter table SEC_CREDENTIALS add foreign key ("USER_FULL_PATH") references SEC_PRINCIPALS("FULL_PATH") on delete cascade

-- drop table SEC_PRIN_PERMS
create table SEC_PRIN_PERMS("PRINCIPAL_ID" varchar(36) not null, "PERMISSION_ID" varchar(36)  not null);
alter table SEC_PRIN_PERMS add primary key ("PRINCIPAL_ID", "PERMISSION_ID");
alter table SEC_PRIN_PERMS add foreign key ("PRINCIPAL_ID") references SEC_PRINCIPALS("PRINCIPAL_ID") on delete cascade;
alter table SEC_PRIN_PERMS add foreign key ("PERMISSION_ID") references SEC_PERMISSIONS("PERMISSION_ID")  on delete cascade;

-- drop table SEC_USER_ROLES
create table SEC_USER_ROLES("USER_FULL_PATH" varchar(36) not null, "ROLE_ID" varchar(36) not null);
alter table SEC_USER_ROLES add primary key ("USER_FULL_PATH", "ROLE_ID");
alter table SEC_USER_ROLES add foreign key ("ROLE_ID") references SEC_PRINCIPALS("PRINCIPAL_ID") on delete cascade;
-- alter table SEC_USER_ROLES add foreign key ("USER_FULL_PATH") references SEC_PRINCIPALS("FULL_PATH") on delete cascade;

-- drop table SEC_USER_GROUPS
create table SEC_USER_GROUPS("USER_FULL_PATH" varchar(36) not null, "GROUP_ID" varchar(36) not null);
alter table SEC_USER_GROUPS add primary key ("USER_FULL_PATH", "GROUP_ID");
alter table SEC_USER_GROUPS add foreign key ("GROUP_ID") references SEC_PRINCIPALS("PRINCIPAL_ID") on delete cascade;
-- alter table SEC_USER_GROUPS add foreign key ("USER_FULL_PATH") references SEC_PRINCIPALS("FULL_PATH") on delete cascade;

-- drop table SEC_GROUP_ROLES
create table SEC_GROUP_ROLES("GROUP_ID" varchar(36) not null, "ROLE_ID" varchar(36) not null);
alter table SEC_GROUP_ROLES add primary key ("GROUP_ID", "ROLE_ID");
alter table SEC_GROUP_ROLES add foreign key ("ROLE_ID") references SEC_PRINCIPALS("PRINCIPAL_ID") on delete cascade;
alter table SEC_GROUP_ROLES add foreign key ("GROUP_ID") references SEC_PRINCIPALS("PRINCIPAL_ID") on delete cascade;

-- SEC_AUDIT_LOG
-- drop table SEC_AUDIT_LOG
create table SEC_AUDIT_LOG (ID varchar(36) not null, ENTITY_TYPE smallint not null, ENTITY_PATH varchar(254) not null,
OP_USER varchar(20) not null, OP_TIME timestamp not null, OP_CODE int not null,
TARGET_ENTITY_PATH varchar(254), PERMISSION_NAME varchar(254),
PERMISSION_CLASS varchar(100), PERMISSION_ACTIONS varchar(254),
MODIFIED_PROPERTY varchar(36), OLD_VALUE varchar(254), NEW_VALUE varchar(254));

alter table SEC_AUDIT_LOG add primary key ("ID");

-- disconnect current;
