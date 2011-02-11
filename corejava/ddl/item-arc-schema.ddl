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
-- @author Steven Ye
-- @version 0.0.1.1
-- @since gwis-item-arc 0.0.1.1

-- db2 CREATE DATABASE GWSR2_ARC USING CODESET UTF-8 TERRITORY US

-- db2 GRANT DBADM,CREATETAB,BINDADD,CONNECT,CREATE_NOT_FENCED,IMPLICIT_SCHEMA,LOAD ON DATABASE  TO USER GWIS

-- CACHE SITE

drop table ARC_CACHE_ITEMS;

--==============================================================
-- Table : ARC_CACHE_ITEMS
--==============================================================
create table ARC_CACHE_ITEMS(   DOC_ID               DECIMAL(22)            not null,   DOC_ENTRYDATE        DATE                   not null,   DOC_ONRET            DECIMAL(22)            not null,   DOC_OFFRET           DECIMAL(22)            not null,   DOC_FILESIZE         DECIMAL(22)            not null,   DOC_DOCCLASS_ID      DECIMAL(22)            not null,   DOC_SUBTYPE_ID       DECIMAL(22)            not null,   DOC_PROP00001        DATE                   not null,   DOC_PROP00002        VARCHAR(20),   DOC_PROP00003        CHAR(3),   DOC_PROP00004        CHAR(3),   DOC_PROP00005        CHAR(3),   DOC_PROP00006        CHAR(3),   DOC_PROP00007        VARCHAR(12),   DOC_PROP00008        DECIMAL(22)    ,   DOC_PROP00009        VARCHAR(5),   DOC_PROP00010        VARCHAR(22),   DOC_PROP00011        VARCHAR(20),   DOC_PROP00012        CHAR(2),   DOC_PROP00013        VARCHAR(16),   DOC_PROP00014        VARCHAR(24),   DOC_PROP00015        CHAR(3),   DOC_PROP00016        VARCHAR(20),   DOC_PROP00017        VARCHAR(3),   DOC_PROP00018        VARCHAR(8),   DOC_PROP00019        VARCHAR(10)   ,   DOC_PROP00020        VARCHAR(30)   ,   DOC_PROP00021        VARCHAR(3)  ,   DOC_FILENAME         VARCHAR(1200)          not null,   DOC_FILENUM          DECIMAL(22)            not null,   DOC_PROP00022        VARCHAR(65),   DOC_PROP00023        VARCHAR(70),   DOC_PROP00024        VARCHAR(10),   DOC_PROP00025        VARCHAR(65),   DOC_PROP00026        VARCHAR(55),   DOC_PROP00027        VARCHAR(20),   DOC_PROP00028        VARCHAR(8),   DOC_PROP00029        VARCHAR(10),   DOC_PROP00030        VARCHAR(23),   DOC_PROP00031        VARCHAR(3),   DOC_PROP00032        VARCHAR(3),   DOC_PROP00033        VARCHAR(10),   DOC_PROP00034        VARCHAR(30),  DOC_PROP00035        VARCHAR(36));
create index ARC_DOC_FILENAME on ARC_CACHE_ITEMS("DOC_FILENAME");

drop table ARC_ITEM_PARMS;

--==============================================================
-- Table : ARC_ITEM_PARMS
--==============================================================
create table ARC_ITEM_PARMS(   ITEM_PARM_NAME       VARCHAR(50)            not null,   ITEM_PARM_VALUE      VARCHAR(50)            not null,   constraint P_Key_1 primary key (ITEM_PARM_NAME));

drop table ARC_ITEM_PROPS;

--==============================================================
-- Table : ARC_ITEM_PROPS
--==============================================================
create table ARC_ITEM_PROPS(   ITEM_UUID            varchar(36)            not null,   PROP_NAME            varchar(50)            not null,   VALUE_INDEX          integer                not null,   VALUE_TYPE           varchar(20)            not null,   STRING_VALUE         varchar(256),   PROP_INDEX           integer                not null,   constraint P_Key_1 primary key (ITEM_UUID, PROP_NAME, VALUE_INDEX));

drop table ARC_ITEM_LOCKS;

--==============================================================
-- Table : ARC_ITEM_LOCKS
--==============================================================
create table ARC_ITEM_LOCKS(   ITEM_UUID            varchar(36)            not null,   ITEM_PATH            varchar(100)           not null,   DEEP                 smallint               not null,   SESSION_SCOPED       smallint               not null,   SESSION_ID           varchar(36),   LOCK_OWNER           varchar(20)            not null,   LOCKED_TIME          timestamp              not null,   constraint P_Key_1 primary key (ITEM_UUID));


-- SERVER SITE

drop table ARC_SERVER_ITEMS;

--==============================================================
-- Table : ARC_SERVER_ITEMS
--==============================================================
create table ARC_SERVER_ITEMS(   DOC_ID             DECIMAL(22)            not null,   DOC_ENTRYDATE        DATE                   not null,   DOC_ONRET            DECIMAL(22)            not null,   DOC_OFFRET           DECIMAL(22)            not null,   DOC_FILESIZE         DECIMAL(22)            not null,   DOC_DOCCLASS_ID      DECIMAL(22)            not null,   DOC_SUBTYPE_ID       DECIMAL(22)            not null,   DOC_PROP00001        DATE                   not null,   DOC_PROP00002        VARCHAR(20),   DOC_PROP00003        CHAR(3),   DOC_PROP00004        CHAR(3),   DOC_PROP00005        CHAR(3),   DOC_PROP00006        CHAR(3),   DOC_PROP00007        VARCHAR(12),   DOC_PROP00008        DECIMAL(22)      ,   DOC_PROP00009        VARCHAR(5),   DOC_PROP00010        VARCHAR(22),   DOC_PROP00011        VARCHAR(20),   DOC_PROP00012        CHAR(2),   DOC_PROP00013        VARCHAR(16),   DOC_PROP00014        VARCHAR(24),   DOC_PROP00015        CHAR(3),   DOC_PROP00016        VARCHAR(20),   DOC_PROP00017        VARCHAR(3),   DOC_PROP00018        VARCHAR(8),   DOC_PROP00019        VARCHAR(10)     ,   DOC_PROP00020        VARCHAR(30)     ,   DOC_PROP00021        VARCHAR(3)       ,   DOC_FILENAME         VARCHAR(1200)          not null,   DOC_FILENUM          DECIMAL(22)            not null,   DOC_PROP00022        VARCHAR(65),   DOC_PROP00023        VARCHAR(70),   DOC_PROP00024        VARCHAR(10),   DOC_PROP00025        VARCHAR(65),   DOC_PROP00026        VARCHAR(55),   DOC_PROP00027        VARCHAR(20),   DOC_PROP00028        VARCHAR(8),   DOC_PROP00029        VARCHAR(10),   DOC_PROP00030        VARCHAR(23),   DOC_PROP00031        VARCHAR(3),   DOC_PROP00032        VARCHAR(3),   DOC_PROP00033        VARCHAR(10),   DOC_PROP00034        VARCHAR(30),  DOC_PROP00035        VARCHAR(36));

comment on column ARC_SERVER_ITEMS.DOC_PROP00003 is'file statusdeleted = 0normal = 1';



