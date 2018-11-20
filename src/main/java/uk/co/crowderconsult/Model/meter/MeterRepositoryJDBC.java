package uk.co.crowderconsult.Model.meter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.crowderconsult.Model.area.Area;

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


    public MeterRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    private List<Meter> generateMeter(ResultSet result) throws SQLException {
        List<Meter> list = new ArrayList<>();
        while (result.next()) {
            Integer meterId = result.getInt("meter_id");//NON-NLS
            String name = result.getString("name");//NON-NLS
            Integer meterTypeId = result.getInt("meter_type_id");//NON-NLS
            Date installDate = result.getDate("install_date");//NON-NLS
            Boolean isActive = result.getBoolean("is_active");//NON-NLS
            String type = result.getString("measurement_data_type");//NON-NLS
            MeasurementDataType measurementDataType = MeasurementDataType.valueOf(type);
            Meter meter = new Meter(meterId, name, meterTypeId, installDate, isActive, measurementDataType);
            list.add(meter);
        }
        return list;
    }

    @Override
    public List<Meter> getAllMeters(Area area) {
        ResultSet result;
        Integer areaId = area.getAreaId();
        List<Meter> list = new ArrayList<>();
        String query = "select m.* from Meter m, AREA_METER_LOOKUP a where m.meter_id = a.meter_id and a.area_id = ?"; //NON-NLS
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, areaId);
            result = preparedStatement.executeQuery();
            list = generateMeter(result);
        } catch (SQLException e) {
            LOG.error("getAllMeters query SQLException", e);//NON-NLS
        }

        return list;
    }

    @Override
    public List<Meter> getOldMeter(Date date) {
        ResultSet result;
        java.sql.Date dateSQL = new java.sql.Date(date.getTime());
        List<Meter> list = new ArrayList<>();
        String query = "select * from meter where install_date < ?";//NON-NLS
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, dateSQL);
            result = preparedStatement.executeQuery();
            list = generateMeter(result);
        } catch (SQLException e) {
            LOG.error("getOldMeter query SQLException", e);//NON-NLS
        }
        return list;
    }
}