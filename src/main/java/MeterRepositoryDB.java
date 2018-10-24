import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author Daniel.shamaeli
 */
public class MeterRepositoryDB implements MeterRepositoryInterface {

    private Statement statement = Database.getStatement();
    private ResultSet result = null;
    private List<Meter> list = new ArrayList<>();
    Meter meter = new Meter();

    public MeterRepositoryDB() throws SQLException {
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
        final String query = "select meter_id from meter where install_date < TO_TIMESTAMP('10-SEP-0214:10:10.123','DD-MON-RRHH24:MI:SS.FF');";
        try {
            result = statement.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
