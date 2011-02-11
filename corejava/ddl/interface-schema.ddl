--##
-- Copyright. The HSBC Software Development (GuangDong) Limited 2006. All
-- rights reserved.
--
-- This software is only to be used for the purpose for which it has been
-- provided. No part of it is to be reproduced, disassembled, transmitted,
-- stored in a retrieval sysytem, nor translated in any human or computer
-- language in any way for any purposes whatsoever without the prior written
-- consent of the HSBC Software Development (GuangDong) Limited.
-- Infringement of copyright is a serious civil and criminal offence, which can
-- result in heavy fines and payment of substantial damages.
--##

--##
-- <b><code>interface-schema</code></b>
-- <p/>
-- Interface DB2 table schema
-- <p/>
-- <b>Creation Time:</b> Dec 13, 2006 7:49:31 PM
-- @author <a href="mailto:Jian Z LAN/ITD GLTC/HDPG/HSBC@HSBC">Byron Lan</a>
-- @version 0.0.1.1
--
-- @since gwis-interface 0.0.0.1
--##
-- create the database SOA_ITF using codeset UTF-8 territory US
-- connect to SOA_ITF
-- grant DBADM,CREATETAB,BINDADD,CONNECT,CREATE_NOT_FENCED,IMPLICIT_SCHEMA,LOAD on database to user gwis

-- connect to GSF_GWS2 user gwis using pdcitage;

----------------------------------------
--  Tables for SQLPersistenceManager ---
----------------------------------------

drop table ITF_IN_DOCS;
drop table ITF_OUT_DOCS;
drop table ITF_RECIP_ITEMS;
drop table ITF_TEMPLATES;
drop table ITF_ADDRESSES;
drop table ITF_GLOSSARY;

drop table ITF_ITEM_PROPS;
drop table ITF_ITEM_LOCKS;
drop table ITF_ITEMS;
drop view ITF_Q_RECIP_ITEMS;

-- ITF_ITEMS
-- drop table ITF_ITEMS
create table ITF_ITEMS (UUID varchar(36) not null, PARENT_UUID varchar(36), ITEM_TYPE varchar(36) not null, PATH varchar(256) not null unique,
CREATED_USER varchar(20), CREATED_TIME timestamp, MODIFIED_USER varchar(20), MODIFIED_TIME timestamp, DEFINITION_ID varchar(36));
alter table ITF_ITEMS add primary key ("UUID");

-- ITF_ITEM_PROPS
-- drop table ITF_ITEM_PROPS
create table ITF_ITEM_PROPS (ITEM_UUID varchar(36) not null, PROP_NAME varchar(50) not null, VALUE_INDEX integer not null, VALUE_TYPE integer not null,
DEFINITION_ID varchar(36), STRING_VALUE varchar(256),  BLOB_VALUE blob(2m), CLOB_VALUE clob(2m));
alter table ITF_ITEM_PROPS add primary key ("ITEM_UUID", "PROP_NAME", "VALUE_INDEX");
alter table ITF_ITEM_PROPS add foreign key ("ITEM_UUID") references ITF_ITEMS("UUID") on delete cascade;

-- ITF_ITEM_LOCKS
-- drop table ITF_ITEM_LOCKS
create table ITF_ITEM_LOCKS (ITEM_UUID varchar(36) not null, ITEM_PATH varchar(100) not null, DEEP smallint not null, SESSION_SCOPED smallint not null,
SESSION_ID varchar(36), LOCK_OWNER varchar(36) not null, LOCKED_TIME timestamp not null);
alter table ITF_ITEM_LOCKS add primary key ("ITEM_UUID");
alter table ITF_ITEM_LOCKS add foreign key ("ITEM_UUID") references ITF_ITEMS("UUID") on delete cascade;

-- ITF_IN_DOCS
-- drop table ITF_IN_DOCS
create table ITF_IN_DOCS (UUID varchar(36) not null, GATEWAY varchar(20) not null, COSYSTEM_ITEM_ID varchar(100),
STATUS smallint, SUBJECT varchar(200), PRIORITY smallint, SENDER_REF varchar(200), ORIGIN varchar(20), ORIGINATED_USER varchar(20),
ORIGINATED_TIME timestamp, SENDER_LOCATIONS varchar(1024), SENDER_CONTACTS varchar(1024),
OUR_REF varchar(200), YOUR_REF varchar(200), TELEPHONE_NO varchar(20),
DESTINATION_ID varchar(20), PAGE_COUNT integer, RECEIVED_SEQ varchar(20),
FORM_ID varchar(20), SITE varchar(20), BATCH_NAME varchar(50), PROCESS_CATEGORY varchar(20), MAINT_TYPE varchar(20));
alter table ITF_IN_DOCS add primary key ("UUID");
alter table ITF_IN_DOCS add foreign key ("UUID") references ITF_ITEMS("UUID") on delete cascade;

-- ITF_OUT_DOCS
-- drop table ITF_OUT_DOCS
create table ITF_OUT_DOCS (UUID varchar(36) not null, GATEWAY varchar(20) not null, COSYSTEM_ITEM_ID varchar(100),
SUBJECT varchar(200), OUR_REF varchar(200), YOUR_REF varchar(200), MERGE_ENABLED smallint,
SEND_ENABLED smallint, CONFIRMED smallint, CONFIRMED_USER varchar(20), CONFIRMED_TIME timestamp,
SENDER_LOCATIONS varchar(1024), SENDER_CONTACTS varchar(1024), TEMPLATE_NAME varchar(50), RESOURCE_NAMES varchar(500));
alter table ITF_OUT_DOCS add primary key ("UUID");
alter table ITF_OUT_DOCS add foreign key ("UUID") references ITF_ITEMS("UUID") on delete cascade;

-- ITF_RECIP_ITEMS
-- drop table ITF_RECIP_ITEMS
create table ITF_RECIP_ITEMS (UUID varchar(36) not null, STATUS integer, SENDER_REF varchar(20), SENT_USER varchar(20), SENT_TIME timestamp, RECEIVER_LOCATIONS varchar(1024), RECEIVER_CONTACTS varchar(1024));
alter table ITF_RECIP_ITEMS add primary key ("UUID");
alter table ITF_RECIP_ITEMS add foreign key ("UUID") references ITF_ITEMS("UUID") on delete cascade;

-- ITF_TEMPLATES
-- drop table ITF_TEMPLATES
create table ITF_TEMPLATES (UUID varchar(36) not null, DOC_TYPES varchar(50) not null);
alter table ITF_TEMPLATES add primary key ("UUID");
alter table ITF_TEMPLATES add foreign key ("UUID") references ITF_ITEMS("UUID") on delete cascade;

-- ITF_ADDRESSES
-- drop table ITF_ADDRESSES
create table ITF_ADDRESSES (NAME varchar(36) not null, GATEWAY varchar(20) not null, CLASS_NAME varchar(100), LOCATIONS varchar(1024),
CONTACTS varchar(1024), DESCRIPTION varchar(100), FAX_TYPE varchar(20), LETTER_POSTAL_CODE varchar(256), LETTER_ZONE varchar(20));
alter table ITF_ADDRESSES add primary key ("NAME", "GATEWAY");

-- ITF_GLOSSARY
-- drop table ITF_GLOSSARY
create table ITF_GLOSSARY (CATEGORY varchar(36) not null, WORD varchar(36) not null, DEFINITION varchar(1024));
alter table ITF_GLOSSARY add primary key ("CATEGORY", "WORD");

-- ITF_Q_RECIP_ITEMS
-- drop view ITF_Q_RECIP_ITEMS
create view ITF_Q_RECIP_ITEMS as select ITF_ITEMS.UUID, PARENT_UUID, ITEM_TYPE, PATH, CREATED_USER, CREATED_TIME,
MODIFIED_USER, MODIFIED_TIME, GATEWAY, COSYSTEM_ITEM_ID, SUBJECT,OUR_REF,YOUR_REF,MERGE_ENABLED,SEND_ENABLED,CONFIRMED,
CONFIRMED_USER,CONFIRMED_TIME,SENDER_LOCATIONS, SENDER_CONTACTS,TEMPLATE_NAME,RESOURCE_NAMES, STATUS, SENDER_REF,
SENT_USER, SENT_TIME, RECEIVER_LOCATIONS, RECEIVER_CONTACTS from ITF_ITEMS, ITF_OUT_DOCS, ITF_RECIP_ITEMS where ITF_ITEMS.UUID = ITF_RECIP_ITEMS.UUID and
ITF_OUT_DOCS.UUID = ITF_ITEMS.PARENT_UUID;

--disconnect current;
