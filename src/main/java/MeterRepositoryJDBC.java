import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Daniel.shamaeli
 */
public class MeterRepositoryJDBC implements MeterRepository {
    private static final Logger LOG = LoggerFactory.getLogger(MeterRepositoryJDBC.class);
    private Connection connection;

    {
        try {
            connection = Database.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ResultSet result = null;


    @Override
    public List<Meter> getAllMeters(Area area) {
        Integer area_id = area.getId();
        final String query = "select meter_id from belongs_to where area_id=" + area_id + ";";
        return null;
    }

    @Override
    public List<Meter> getOldMeter(Date date) {
        java.sql.Date dateSQL = new java.sql.Date(date.getTime());
        List<Meter> list = new ArrayList<>();
        String query = "select * from Meter where install_date < ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, dateSQL);

            result = preparedStatement.executeQuery();
            while (result.next()) {
                Integer meter_id = result.getInt("meter_id");
                String name = result.getString("name");
                Integer meter_type_id = result.getInt("meter_type_id");
                Date install_date = result.getDate("install_date");
                Boolean is_active = result.getBoolean("is_active");
                String type = result.getString("measurment_data_type");
                MeasurementDataType measurement_data_type = MeasurementDataType.convert(type);
                Meter meter = new Meter(meter_id, name, meter_type_id, install_date, is_active, measurement_data_type);
                list.add(meter);
            }
        } catch (SQLException e) {
            LOG.error("Error", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}