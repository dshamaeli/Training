import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Daniel.shamaeli
 */
public class MeterRepositoryJDBC implements MeterRepository {
    private static final Logger LOG = LoggerFactory.getLogger(MeterRepositoryJDBC.class);
    private Statement statement = Database.getStatement();
    private ResultSet result = null;
    private List<Meter> list = new ArrayList<>();


    public MeterRepositoryJDBC() throws SQLException {
    }

    @Override
    public List<Meter> getAllMeters(Area area) {
        Integer area_id = area.getId();
        final String query = "select meter_id from belongs_to where area_id=" + area_id + ";";
        return null;
    }

    @Override
    public List<MeterData> getDataByDate(Meter meter, Date start, Date end) {
        final String query = "select data_date, value from meter_data,meter where parent_id = ";
        return null;
    }

    @Override
    public List<Meter> getOldMeter(Date date) {
        List<Meter> list = new ArrayList<>();
        String query = "select * from Meter where install_date < to_date('10-10-2018 10:10:10','dd-mm-yyyy HH:MI:SS')";
//        String query = "select meter_id from meter where install_date < TO_TIMESTAMP(" + date + ",'DD-MON-RRHH24:MI:SS.FF')";
//        String query = "select meter_id from meter where install_date <" + date;
//        String query = "select * from meter";
        try {
            result = statement.executeQuery(query);
            while (result.next()) {
                Integer meter_id = result.getInt("meter_id");
                String name = result.getString("name");
                Integer meter_type_id = result.getInt("meter_type_id");
                Date install_date = result.getDate("install_date");
                Boolean is_active = result.getBoolean("is_active");
                String type = result.getString("measurment_data_type");
                MeasurementDataType measurement_data_type = MeasurementDataType.convert(type);
                Meter meter = new Meter(meter_id, name, meter_type_id, install_date, is_active, measurement_data_type);
                LOG.info(meter.toString());
                list.add(meter);
            }
        } catch (SQLException e) {
            LOG.error("Error", e);
        }
        return list;
    }
}
