import java.util.Date;
import java.util.List;

/**
 * @author Daniel.shamaeli
 */
public class MeterRepositoryDB implements MeterRepositoryInterface {


    @Override
    public List<Meter> getAllMeters(Area area) {
        final String query = "select meter_id from belongs_to where area_id=";
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
        return null;
    }
}
