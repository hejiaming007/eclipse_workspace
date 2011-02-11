-- ########################################################################
-- Copyright. The HSBC Software Development (GuangDong) Limited 2005. All rights reserved.
--
-- This software is only to be used for the purpose for which it has been
-- provided. No part of it is to be reproduced, disassembled, transmitted,
-- stored in a retrieval sysytem, nor translated in any human or computer
-- language in any way for any purposes whatsoever without the prior written
-- consent of the HSBC Software Development (GuangDong) Limited.
-- Infringement of copyright is a serious civil and criminal offence, which can
-- result in heavy fines and payment of substantial damages.
-- ########################################################################

-- <b>Creation Time:</b> 2006 1:58:01 PM
-- @author William Ou
-- @author Byron Lan
-- @version 0.0.1.1
-- @since gwis-workflow 0.0.4.1

-- create  database GSF_GWS using codeset UTF-8 territory US
-- connect to GSF_GWS
-- grant DBADM,CREATETAB,BINDADD,CONNECT,CREATE_NOT_FENCED,IMPLICIT_SCHEMA,LOAD on database to user gwis

-- connect to GSF_GWS2 user gwis using pdcitage;

drop view if exists  GWS_Q_ACTIVITIES;
drop view if exists  GWS_Q_PROCESSES;
drop view if exists  GWS_Q_WORK_LISTS;
drop view if exists  GWS_Q_ACTV_LOCKS;
drop view if exists  GWS_Q_PROC_LOCKS;

drop table if exists  GWS_TRANSITIONS;
drop table if exists  GWS_WORK_LISTS;
drop table if exists  GWS_AUDIT_LOG;
drop table if exists  GWS_LOCKS;
drop table if exists  GWS_SCHEDULES;
drop table if exists  GWS_ACTIVITIES;
drop table if exists  GWS_PROCESSES;
drop table if exists  GWS_OPER_REPORT;
drop table if exists  GWS_VOLUME_REPORT;

-- GWS_PROCESSES
-- drop table GWS_PROCESSES
create table GWS_PROCESSES (UUID varchar(36) not null, PATH varchar(100) not null unique, STATE integer not null, DEFINITION_PATH varchar(256) not null,
PARENT_UUID varchar(36), DATA_PATH varchar(100) not null, START_ACTV varchar(36), COMPLETER varchar(20), COMPLETION_TIME timestamp,
CREATED_TIME timestamp not null, CREATED_USER varchar(20) not null, MODIFIED_TIME timestamp, MODIFIED_USER varchar(20));
alter table GWS_PROCESSES add primary key ("UUID");
-- create index GWS_PROC_DEF_PATH on GWS_PROCESSES ("DEFINITION_PATH");
-- create index GWS_PROC_STATE on GWS_PROCESSES ("STATE");
-- GWS_Q_PROCESSES
--create view GWS_Q_PROCESSES as select GWS_PROCESSES.*, CASE WHEN GWS_LOCKS.OBJECT_PATH is not null THEN 1 ELSE 0 END as LOCKED, SESSION_SCOPED from GWS_PROCESSES left outer join GWS_LOCKS on (GWS_LOCKS.OBJECT_PATH = GWS_PROCESSES.PATH);

-- GWS_ACTIVITIES
-- drop table GWS_ACTIVITIES
create table GWS_ACTIVITIES (UUID varchar(36) not null, PATH varchar(100) not null unique, STATE integer not null, DEFINITION_PATH varchar(100) not null,
PARENT_UUID varchar(36), PROCESS_UUID varchar(36) not null, DATA_PATH varchar(100) not null, NEXT_STEP varchar(256), COMPLETER varchar(20), COMPLETION_TIME timestamp,
EXECUTED smallint not null, CREATED_TIME timestamp not null, CREATED_USER varchar(20) not null, MODIFIED_TIME timestamp, MODIFIED_USER varchar(20));
alter table GWS_ACTIVITIES add foreign key ("PROCESS_UUID") references GWS_PROCESSES("UUID") on delete cascade;
alter table GWS_ACTIVITIES add primary key ("UUID");
-- create index GWS_ACTV_DEF_PATH on GWS_ACTIVITIES ("DEFINITION_PATH");
-- create index GWS_ACTV_STATE on GWS_ACTIVITIES ("STATE");
-- drop index  GWS_ACTV_DEF_PATH;
CREATE INDEX GWS_ACTV_UUID ON "GWS_ACTIVITIES" ("PROCESS_UUID" ASC);
CREATE INDEX GWS_ACTV_STATE ON "GWS_ACTIVITIES" ("DEFINITION_PATH" ASC, "STATE" DESC);

-- GWS_ACTIVITIES
--create view GWS_Q_ACTIVITIES as select GWS_ACTIVITIES.*, CASE WHEN GWS_LOCKS.OBJECT_PATH is not null THEN 1 ELSE 0 END as LOCKED, SESSION_SCOPED, CASE WHEN GWS_SCHEDULES.OBJECT_PATH is not null THEN 1 ELSE 0 END as SCHEDULED, SCHEDULED_ACTION from GWS_ACTIVITIES left outer join GWS_LOCKS on (GWS_LOCKS.OBJECT_PATH = GWS_ACTIVITIES.PATH) left outer join GWS_SCHEDULES on (GWS_SCHEDULES.OBJECT_PATH = GWS_ACTIVITIES.PATH)

-- GWS_LOCKS
-- drop table GWS_LOCKS
create table GWS_LOCKS (OBJECT_PATH varchar(100) not null, LOCK_OWNER varchar(20) not null, LOCKED_TIME timestamp not null,
SESSION_SCOPED smallint not null, SESSION_ID varchar(36), LIVE_TIME bigint not null);
alter table GWS_LOCKS add primary key ("OBJECT_PATH");

-- GWS_Q_ACTV_LOCKS
create view GWS_Q_ACTV_LOCKS as select GWS_LOCKS.* from GWS_ACTIVITIES join GWS_LOCKS on (GWS_LOCKS.OBJECT_PATH = GWS_ACTIVITIES.PATH);

-- GWS_Q_PROC_LOCKS
create view GWS_Q_PROC_LOCKS as select GWS_LOCKS.* from GWS_PROCESSES join GWS_LOCKS on (GWS_LOCKS.OBJECT_PATH = GWS_PROCESSES.PATH);

-- GWS_SCHEDULES
-- drop table GWS_SCHEDULES
create table GWS_SCHEDULES (OBJECT_PATH varchar(100) not null, SCHEDULE_OWNER varchar(20) not null, SCHEDULED_TIME timestamp not null, SCHEDULED_ACTION smallint not null);
alter table GWS_SCHEDULES add primary key ("OBJECT_PATH");

-- GWS_TRANSITIONS
-- drop table GWS_TRANSITIONS
create table GWS_TRANSITIONS (UUID varchar(36) not null, DEFINITION_PATH varchar(100) not null,
PROCESS_UUID varchar(36) not null, FROM_ACTV_UUID varchar(36) not null, TO_ACTV_UUID varchar(36) not null);
alter table GWS_TRANSITIONS add primary key ("UUID");
alter table GWS_TRANSITIONS add foreign key ("FROM_ACTV_UUID") references GWS_ACTIVITIES("UUID");
alter table GWS_TRANSITIONS add foreign key ("TO_ACTV_UUID") references GWS_ACTIVITIES("UUID");
alter table GWS_TRANSITIONS add foreign key ("PROCESS_UUID") references GWS_PROCESSES("UUID") on delete cascade;
CREATE INDEX GWS_PROCESS_UUID ON "GWS_TRANSITIONS" ("PROCESS_UUID" ASC);

-- GWS_WORK_LIST
-- drop table GWS_WORK_LISTS
create table GWS_WORK_LISTS (WORK_LIST_PATH varchar(256) not null, ACTV_PATH varchar(100) not null, CREATED_TIME timestamp not null, ACTIVATED smallint not null);
alter table GWS_WORK_LISTS add primary key ("WORK_LIST_PATH", "ACTV_PATH");
alter table GWS_WORK_LISTS add foreign key ("ACTV_PATH") references GWS_ACTIVITIES("PATH") on delete cascade;
-- create index GWS_WORKLIST_STATE on GWS_WORK_LISTS ("ACTIVATED");
CREATE INDEX GWS_ACTV_PATH ON "GWS_WORK_LISTS" ("ACTV_PATH" ASC) ;

-- GWS_AUDIT_LOG
-- drop table GWS_AUDIT_LOG
create table GWS_AUDIT_LOG (ID varchar(36) not null, OBJECT_TYPE smallint not null, OBJECT_PATH varchar(100) not null, SESSION_ID varchar(36) not null,
OP_USER varchar(20) not null, OP_TIME timestamp not null, OP_CODE int not null, DEFINITION_PATH varchar(100) not null, SESSION_SCOPED smallint,
WORK_LIST_PATH varchar(256), NEXT_OBJECT_PATH varchar(100), NEXT_DEF_PATH varchar(100), NEXT_WORK_LIST_PATH varchar(256));
alter table GWS_AUDIT_LOG add primary key ("ID");
CREATE INDEX GWS_OP_CODE ON GWS_AUDIT_LOG (OBJECT_PATH,OBJECT_TYPE,OP_CODE,SESSION_SCOPED);
CREATE INDEX GWS_NEXT_WL_PATH ON GWS_AUDIT_LOG (OP_CODE,WORK_LIST_PATH,NEXT_WORK_LIST_PATH,OP_TIME);

-- GWS_Q_PROCESSES
create view GWS_Q_PROCESSES as select GWS_PROCESSES.*, CASE WHEN GWS_LOCKS.OBJECT_PATH is not null THEN 1 ELSE 0 END as LOCKED, SESSION_SCOPED from GWS_PROCESSES left outer join GWS_LOCKS on (GWS_LOCKS.OBJECT_PATH = GWS_PROCESSES.PATH);

-- GWS_Q_ACTIVITIES
create view GWS_Q_ACTIVITIES as select GWS_ACTIVITIES.*, CASE WHEN GWS_LOCKS.OBJECT_PATH is not null THEN 1 ELSE 0 END as LOCKED, LOCK_OWNER, SESSION_SCOPED, LOCKED_TIME, CASE WHEN GWS_SCHEDULES.OBJECT_PATH is not null THEN 1 ELSE 0 END as SCHEDULED, SCHEDULED_ACTION, GWS_WORK_LISTS.WORK_LIST_PATH, GWS_WORK_LISTS.ACTIVATED from GWS_ACTIVITIES left outer join GWS_LOCKS on (GWS_LOCKS.OBJECT_PATH = GWS_ACTIVITIES.PATH) left outer join GWS_SCHEDULES on (GWS_SCHEDULES.OBJECT_PATH = GWS_ACTIVITIES.PATH) left outer join GWS_WORK_LISTS on (GWS_WORK_LISTS.ACTV_PATH = GWS_ACTIVITIES.PATH);

-- GWS_Q_WORK_LISTS
-- create view GWS_Q_WORK_LISTS as select GWS_WORK_LISTS.ACTV_PATH, GWS_Q_ACTIVITIES.* from GWS_WORK_LISTS left outer join GWS_Q_ACTIVITIES on (GWS_Q_ACTIVITIES.PATH = GWS_WORK_LISTS.ACTV_PATH);
create view GWS_Q_WORK_LISTS as select GWS_ACTIVITIES.*, CASE WHEN GWS_LOCKS.OBJECT_PATH is not null THEN 1 ELSE 0 END as LOCKED, LOCK_OWNER, SESSION_SCOPED, LOCKED_TIME, CASE WHEN GWS_SCHEDULES.OBJECT_PATH is not null THEN 1 ELSE 0 END as SCHEDULED, SCHEDULED_ACTION, GWS_WORK_LISTS.WORK_LIST_PATH, GWS_WORK_LISTS.ACTIVATED, GWS_WORK_LISTS.ACTV_PATH from GWS_ACTIVITIES left outer join GWS_LOCKS on (GWS_LOCKS.OBJECT_PATH = GWS_ACTIVITIES.PATH) left outer join GWS_SCHEDULES on (GWS_SCHEDULES.OBJECT_PATH = GWS_ACTIVITIES.PATH) left outer join GWS_WORK_LISTS on (GWS_WORK_LISTS.ACTV_PATH = GWS_ACTIVITIES.PATH);

-- GWS_OPER_REPORT
-- drop table GWS_OPER_REPORT
create table GWS_OPER_REPORT (ACTV_PATH varchar(100) not null, OP_TIME timestamp not null, OP_USER varchar(20), FROM_WORK_LIST_PATH varchar(256), TO_WORK_LIST_PATH varchar(256) not null, PROCESS_TIME integer);
alter table GWS_OPER_REPORT add primary key ("ACTV_PATH", "OP_TIME");

-- GWS_VOLUME_REPORT
-- drop table GWS_VOLUME_REPORT
create table GWS_VOLUME_REPORT (WORK_LIST_PATH varchar(256) not null, START_TIME timestamp not null, END_TIME timestamp not null, TYPE integer not null, VOLUME integer);
alter table GWS_VOLUME_REPORT add primary key ("WORK_LIST_PATH", "START_TIME", "END_TIME","TYPE");

--disconnect current
