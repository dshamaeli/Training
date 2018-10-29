-- Create table

create table METERTYPE
(
  meter_type_id NUMBER not null,
  type_name     VARCHAR2(40 CHAR) constraint metertype_nn$1 not null,
  max_size      NUMBER,
  max_flow      NUMBER,
  min_flow      NUMBER
)
tablespace NBSYSSML

comment on table metertype is '';

-- Add comments to the columns
comment on column METERTYPE.max_size
  is '0-1000';
comment on column METERTYPE.max_flow
  is '1-100';
comment on column METERTYPE.min_flow
  is '1-100';
-- Create/Recreate primary, unique and foreign key constraints
alter table METERTYPE
  add constraint METER_TYPE$PK1 primary key (METER_TYPE_ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;


-- Create table
create table METER
(
  meter_id             NUMBER not null,
  name                 VARCHAR2(40 CHAR) not null,
  install_date         DATE,
  is_active            VARCHAR2(1 CHAR),
  measurment_data_type VARCHAR2(8 CHAR),
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
comment on column METER.measurment_data_type
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
  references METERTYPE (METER_TYPE_ID);




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
  maxtrans 255;


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
create table BELONGS_TO
(
  meter_id NUMBER,
  area_id  NUMBER
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
alter table BELONGS_TO
  add constraint BELONGS_TO$FK1 foreign key (AREA_ID)
  references AREA (AREA_ID);
alter table BELONGS_TO
  add constraint BELONGS_TO$FK2 foreign key (METER_ID)
  references METER (METER_ID);


--Add row to meter
insert into meter (meter_id,name,install_date,is_active,measurment_data_type) values (123,'Quality Area 1 Meter', to_date('13-DEC-2017 6:56 PM', 'dd-mon-yyyy hh:mi PM'),'Y','flow');

