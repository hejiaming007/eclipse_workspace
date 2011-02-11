-- create  database GSF_GWS using codeset UTF-8 territory US
-- connect to GSF_GWS
-- grant DBADM,CREATETAB,BINDADD,CONNECT,CREATE_NOT_FENCED,IMPLICIT_SCHEMA,LOAD on database to user gwis

-- connect to GSF_GWS2 user gwis using pdcitage;

----------------------------------------
--  Tables for SQLPersistenceManager ---
----------------------------------------

drop table ITM_ITEM_LOCKS;
drop table ITM_ITEM_PROPS;
drop table ITM_ITEMS;

-- ITM_ITEMS
-- drop table ITM_ITEMS
create table ITM_ITEMS (UUID varchar(36) not null, PARENT_UUID varchar(36), ITEM_TYPE varchar(36) not null, PATH varchar(256) not null unique, 
CREATED_USER varchar(20), CREATED_TIME timestamp, MODIFIED_USER varchar(20), MODIFIED_TIME timestamp, DEFINITION_ID varchar(36),
VARCHAR_00 varchar(50),VARCHAR_01 varchar(50),VARCHAR_02 varchar(50),VARCHAR_03 varchar(50),VARCHAR_04 varchar(50),VARCHAR_05 varchar(50),VARCHAR_06 varchar(50),VARCHAR_07 varchar(50),VARCHAR_08 varchar(50),VARCHAR_09 varchar(50),
VARCHAR_10 varchar(50),VARCHAR_11 varchar(50),VARCHAR_12 varchar(50),VARCHAR_13 varchar(50),VARCHAR_14 varchar(50),VARCHAR_15 varchar(50),VARCHAR_16 varchar(50),VARCHAR_17 varchar(50),VARCHAR_18 varchar(50),VARCHAR_19 varchar(50),
SMALLINT_00 smallint,SMALLINT_01 smallint,SMALLINT_02 smallint,SMALLINT_03 smallint,SMALLINT_04 smallint,
INT_00 int,INT_01 int,INT_02 int,INT_03 int,INT_04 int,INT_05 int,INT_06 int,INT_07 int,INT_08 int,INT_09 int,
FLOAT_00 float,FLOAT_01 float,FLOAT_02 float,FLOAT_03 float,FLOAT_04 float,
DOUBLE_00 double,DOUBLE_01 double,DOUBLE_02 double,DOUBLE_03 double,DOUBLE_04 double,
DOUBLE_05 double,DOUBLE_06 double,DOUBLE_07 double,DOUBLE_08 double,DOUBLE_09 double,
BIGINT_00 bigint,BIGINT_01 bigint,BIGINT_02 bigint,BIGINT_03 bigint,BIGINT_04 bigint,
DATE_00 date,DATE_01 date,DATE_02 date,DATE_03 date,DATE_04 date,
TIME_00 time,TIME_01 time,TIME_02 time,TIME_03 time,TIME_04 time,
TIMESTAMP_00 timestamp,TIMESTAMP_01 timestamp,TIMESTAMP_02 timestamp,TIMESTAMP_03 timestamp,TIMESTAMP_04 timestamp);
alter table ITM_ITEMS add primary key ("UUID");

-- ITM_ITEM_PROPS
-- drop table ITM_ITEM_PROPS
create table ITM_ITEM_PROPS (ITEM_UUID varchar(36) not null, PROP_NAME varchar(50) not null, VALUE_INDEX integer not null, VALUE_TYPE integer not null, 
DEFINITION_ID varchar(36), STRING_VALUE varchar(256), BLOB_VALUE blob, CLOB_VALUE clob);
alter table ITM_ITEM_PROPS add primary key ("ITEM_UUID", "PROP_NAME", "VALUE_INDEX");
alter table ITM_ITEM_PROPS add foreign key ("ITEM_UUID") references ITM_ITEMS("UUID") on delete cascade;

-- ITM_ITEM_LOCKS
-- drop table ITM_ITEM_LOCKS
create table ITM_ITEM_LOCKS (ITEM_UUID varchar(36) not null, ITEM_PATH varchar(100) not null, DEEP smallint not null, SESSION_SCOPED smallint not null, SESSION_ID varchar(36), LOCK_OWNER varchar(20) not null, LOCKED_TIME timestamp not null);
alter table ITM_ITEM_LOCKS add primary key ("ITEM_UUID");
alter table ITM_ITEM_LOCKS add foreign key ("ITEM_UUID") references ITM_ITEMS("UUID") on delete cascade;

--disconnect current
