-- enable user to enter rows

ALTER USER nb quota unlimited on USERS;

--Add row to area
insert into area (area_id,name,area_type,is_active) values (321,'Quality Area 1','QUALITY','y');
insert into area (area_id,name,area_type,is_active) values (987,'Quality Area 2','QUALITY','N');
insert into area (area_id,name,area_type,is_active) values (556,'Hydraulic Area 1','HYDRAULIC','Y');
insert into area (area_id,name,area_type,is_active) values (864,'Hydraulic Area 1','HYDRAULIC','Y');
insert into area (area_id,name,area_type,is_active) values (777,'Operational Area 1','OPERATIONAL','Y');
insert into area (area_id,name,area_type,is_active) values (256,'Operational Area 2','OPERATIONAL','N');

--Add row to meter_type
insert into meter_type (meter_type_id,type_name,max_size,max_flow,min_flow) values (1,'Inlet Meter', 50.00,50.00,20.00);
insert into meter_type (meter_type_id,type_name,max_size,max_flow,min_flow) values (2,'Abstraction Meter',650.00,100.00,100.00);
insert into meter_type (meter_type_id,type_name,max_size,max_flow,min_flow) values (3,'Distribution Meter',750.00,100.00,100.00 );
insert into meter_type (meter_type_id,type_name,max_size,max_flow,min_flow) values (4,'Outlet Meter', 50.00,50.00,20.00);

--Add row to meter
insert into meter (meter_id,name,install_date,is_active,measurment_data_type,meter_type_id) values (123,'Quality Area 1 Meter', to_date('13-DEC-2017 6:56 PM', 'dd-mon-yyyy hh:mi PM'),'Y','FLOW',1);
insert into meter (meter_id,name,install_date,is_active,measurment_data_type,meter_type_id) values (753,'Quality Area 1 Meter', to_date('25-DEC-2017 5:56 PM', 'dd-mon-yyyy hh:mi PM'),'Y','FLOW',4);
insert into meter (meter_id,name,install_date,is_active,measurment_data_type,meter_type_id) values (258,'Hydraulic Area 1 Meter', to_date('25-OCT-2018 10:56 AM', 'dd-mon-yyyy hh:mi PM'),'Y','PRESSURE',2);
insert into meter (meter_id,name,install_date,is_active,measurment_data_type,meter_type_id) values (951,'Operationl Area 1 Meter', to_date('20-SEP-2018 1:56 PM', 'dd-mon-yyyy hh:mi PM'),'Y','LEVEL',4);

--Add row to belongs to

insert into AREA_METER_LOOKUP (meter_id,area_id) values (123,321);
insert into AREA_METER_LOOKUP (meter_id,area_id) values (753,321);
insert into AREA_METER_LOOKUP (meter_id,area_id) values (258,556);
insert into AREA_METER_LOOKUP (meter_id,area_id) values (951,777);
