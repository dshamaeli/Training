package uk.co.crowderconsult;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.co.crowderconsult.Model.area.Area;
import uk.co.crowderconsult.Model.area.AreaType;
import uk.co.crowderconsult.Model.meter.Meter;
import uk.co.crowderconsult.Model.meter.MeterRepositoryHibernate;
import uk.co.crowderconsult.Model.utility.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MeterRepositoryHibernateTest {
    private MeterRepositoryHibernate meterHibernate = new MeterRepositoryHibernate();
    private List<Meter> result = null;

    @Before
    public void setUp() throws SQLException {

        Connection connection = Database.getConnection();
        String insertArea = "insert into area (area_id,name,area_type,is_active) values (321,'Quality Area 1','QUALITY','Y')";//NON-NLS
        String insertMeterType1 = "insert into meter_type (meter_type_id,type_name,max_size,max_flow,min_flow) values (1,'Inlet Meter', 50.00,50.00,20.00)";//NON-NLS
        String insertMeterType2 = "insert into meter_type (meter_type_id,type_name,max_size,max_flow,min_flow) values (2,'Abstraction Meter',650.00,100.00,100.00)";//NON-NLS
        String insertMeter1 = "insert into meter (meter_id,name,install_date,is_active,measurement_data_type,meter_type_id) values (123,'Quality Area 1 Meter', to_date('13-DEC-2017 6:56 PM', 'dd-mon-yyyy hh:mi PM'),'Y','FLOW',1)";//NON-NLS
        String insertMeter2 = "insert into meter (meter_id,name,install_date,is_active,measurement_data_type,meter_type_id) values (753,'Quality Area 1 Meter', to_date('25-DEC-2018 5:56 PM', 'dd-mon-yyyy hh:mi PM'),'Y','FLOW',2)";//NON-NLS
        String insertAreaMeterLookup1 = "insert into AREA_METER_LOOKUP (meter_id,area_id) values (123,321)";//NON-NLS
        String insertAreaMeterLookup2 = "insert into AREA_METER_LOOKUP (meter_id,area_id) values (753,321)";//NON-NLS
        String[] query = {insertArea, insertMeterType1, insertMeterType2, insertMeter1, insertMeter2, insertAreaMeterLookup1, insertAreaMeterLookup2};
        for (String q : query) {
            PreparedStatement preparedStatement = connection.prepareStatement(q);
            preparedStatement.executeUpdate();
        }
    }

    @After
    public void tearDown() throws SQLException {

        Connection connection = Database.getConnection();
        String deleteAreaMeterLookup1 = "delete from AREA_METER_LOOKUP where meter_id=123 and area_id=321 ";//NON-NLS
        String deleteAreaMeterLookup2 = "delete from AREA_METER_LOOKUP where meter_id=753 and area_id=321 ";//NON-NLS
        String deleteMeter1 = "delete from meter where meter_id=123";//NON-NLS
        String deleteMeter2 = "delete from meter where meter_id=753";//NON-NLS
        String deleteMeterType1 = "delete from meter_type where meter_type_id=1";//NON-NLS
        String deleteMeterType2 = "delete from meter_type where meter_type_id=2";//NON-NLS
        String deleteArea = "delete from area where area_id=321";//NON-NLS
        String[] query = {deleteAreaMeterLookup1, deleteAreaMeterLookup2, deleteMeter1, deleteMeter2, deleteMeterType1, deleteMeterType2, deleteArea};
        for (String q : query) {
            PreparedStatement preparedStatement = connection.prepareStatement(q);
            preparedStatement.executeUpdate();
        }
    }

    @Test
    public void getAllMeters() {
        Area area = new Area(321, "Quality Area 1", AreaType.QUALITY, true);
        result = meterHibernate.getAllMeters(area);
        Meter meter = result.get(0);
        System.out.println(meter);
        Assert.assertEquals(123, result.get(0).getId());

    }

    @Test
    public void getOldMeter() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss.SSSZ");
        try {
            Date date = sdf.parse("01-11-2018T12:11:56.235-0700"); //NON-NLS
            result = meterHibernate.getOldMeter(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(123, result.get(0).getId());

    }
}