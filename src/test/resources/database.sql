use training;

-- Create table
create table METER_TYPE
(
  meter_type_id Int not null ,
  type_name     VARCHAR(40),
  max_size      Double comment '0-1000',
  max_flow      Double comment '1-100',
  min_flow      Double comment '1-100'
);

-- Create/Recreate primary, unique and foreign key constraints
alter table METER_TYPE
  add constraint METER_TYPE$PK1 primary key (METER_TYPE_ID);
  
-- Create/Recreate check constraints
alter table METER_TYPE
  add constraint METER_TYPE$FK1
  check ("TYPE_NAME" IS NOT NULL);



-- Create table
create table METER
(
  meter_id             int not null,
  name                 varchar(40) not null,
  install_date         date,
  is_active            boolean,
  measurment_data_type enum('FLOW','LEVEL','PRESSURE'),
  meter_type_id        int
);
-- Create/Recreate primary, unique and foreign key constraints
alter table METER
  add constraint METER_PK$1 primary key (METER_ID);
  
alter table METER
  add constraint METER$FK1 foreign key (METER_TYPE_ID)
  references METER_TYPE (METER_TYPE_ID);

-- Create table
create table METER_DATA
(
  parent_id int not null,
  data_date TIMESTAMP(6) not null,
  value     double
);
-- Create/Recreate primary, unique and foreign key constraints
alter table METER_DATA
  add constraint METER_DATA$PK1 primary key (PARENT_ID, DATA_DATE);
alter table METER_DATA
  add constraint METER_DATA$FK1 foreign key (PARENT_ID)
  references METER (METER_ID);

-- Create table
create table AREA
(
  area_id   int not null,
  name      varchar(40),
  area_type enum('HYDRAULIC','OPERATIONAL','QUALITY'),
  is_active boolean
);
-- Create/Recreate primary, unique and foreign key constraints
alter table AREA
  add constraint AREA$PK1 primary key (AREA_ID);


-- Create table
create table AREA_SUMMARY
(
  parent_id    int not null,
  summary_date TIMESTAMP(6) not null,
  total_flow   double,
  min_flow     double,
  max_flow     double
);
-- Create/Recreate primary, unique and foreign key constraints
alter table AREA_SUMMARY
  add constraint AREA_SUMMARY$PK1 primary key (SUMMARY_DATE, PARENT_ID);
alter table AREA_SUMMARY
  add constraint AREA_SUMMARY$FK1 foreign key (PARENT_ID)
  references AREA (AREA_ID) on delete cascade;


-- Create table
create table AREA_METER_LOOKUP
(
  meter_id int not null,
  area_id  int not null
);
-- Create/Recreate primary, unique and foreign key constraints
alter table AREA_METER_LOOKUP
  add constraint AREA_METER_LOOKUP_$PK1 primary key (METER_ID, AREA_ID);
alter table AREA_METER_LOOKUP
  add constraint AREA_METER_LOOKUP_$FK1 foreign key (METER_ID)
  references METER (METER_ID);
alter table AREA_METER_LOOKUP
  add constraint AREA_METER_LOOKUP_$FK2 foreign key (AREA_ID)
  references AREA (AREA_ID);