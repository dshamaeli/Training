-- Create table
create table METER_TYPE
(
  meter_type_id NUMBER not null,
  type_name     VARCHAR2(40 CHAR),
  max_size      NUMBER,
  max_flow      NUMBER,
  min_flow      NUMBER
)
tablespace NBSYSSML
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column METER_TYPE.max_size
  is '0-1000';
comment on column METER_TYPE.max_flow
  is '1-100';
comment on column METER_TYPE.min_flow
  is '1-100';
-- Create/Recreate primary, unique and foreign key constraints
alter table METER_TYPE
  add constraint METER_TYPE$PK1 primary key (METER_TYPE_ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
-- Create/Recreate check constraints
alter table METER_TYPE
  add constraint METERTYPE_NN$1
  check ("TYPE_NAME" IS NOT NULL);



-- Create table
create table METER
(
  meter_id             NUMBER not null,
  name                 VARCHAR2(40 CHAR) not null,
  install_date         DATE,
  is_active            VARCHAR2(1 CHAR),
  measurement_data_type VARCHAR2(8 CHAR),
  meter_type_id        NUMBER
)
tablespace NBSYSSML
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns
comment on column METER.is_active
  is 'Y/N';
comment on column METER.measurement_data_type
  is 'Flow/Level/Pressure';
-- Create/Recreate primary, unique and foreign key constraints
alter table METER
  add constraint METER_PK$1 primary key (METER_ID)
  using index
  tablespace NBSYSSML
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table METER
  add constraint METER$FK1 foreign key (METER_TYPE_ID)
  references METER_TYPE (METER_TYPE_ID);




-- Create table
create table METER_DATA
(
  parent_id NUMBER not null,
  data_date TIMESTAMP(6) not null,
  value     NUMBER
)
tablespace NBSYSSML
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints
alter table METER_DATA
  add constraint METER_DATA$PK1 primary key (PARENT_ID, DATA_DATE)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table METER_DATA
  add constraint METER_DATA$FK1 foreign key (PARENT_ID)
  references METER (METER_ID);


-- Create table
-- Create table
create table AREA
(
  area_id   NUMBER not null,
  name      VARCHAR2(40 CHAR),
  area_type VARCHAR2(40 CHAR),
  is_active VARCHAR2(1 CHAR)
)
tablespace NBSYSSML
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column AREA.area_type
  is 'Hydraulic/Operational/Quality';
comment on column AREA.is_active
  is 'Y/N';
-- Create/Recreate primary, unique and foreign key constraints 
alter table AREA
  add constraint AREA$PK1 primary key (AREA_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 80K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate check constraints 
alter table AREA
  add constraint AREA$C1
  check (is_active IN ('Y','N'));


-- Create table
create table AREA_SUMMARY
(
  parent_id    NUMBER not null,
  summary_date TIMESTAMP(6) not null,
  total_flow   NUMBER,
  min_flow     NUMBER,
  max_flow     NUMBER
)
tablespace NBSYSSML
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints
alter table AREA_SUMMARY
  add constraint AREA_SUMMARY$PK1 primary key (SUMMARY_DATE, PARENT_ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table AREA_SUMMARY
  add constraint AREA_SUMMARY$FK1 foreign key (PARENT_ID)
  references AREA (AREA_ID) on delete cascade;


-- Create table
create table AREA_METER_LOOKUP
(
  meter_id NUMBER not null,
  area_id  NUMBER not null
)
tablespace NBSYSSML
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints
alter table AREA_METER_LOOKUP
  add constraint AREA_METER_LOOKUP_$PK1 primary key (METER_ID, AREA_ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table AREA_METER_LOOKUP
  add constraint AREA_METER_LOOKUP_$FK1 foreign key (METER_ID)
  references METER (METER_ID);
alter table AREA_METER_LOOKUP
  add constraint AREA_METER_LOOKUP_$FK2 foreign key (AREA_ID)
  references AREA (AREA_ID);
  ALTER USER nb quota unlimited on USERS;

-- enables user to enter rows

ALTER USER nb quota unlimited on USERS;
