import org.apache.commons.dbcp2.BasicDataSource;

import java.util.Date;
import java.util.List;

/**
 * @author Daniel.shamaeli
 */
public class MeterRepositoryDB implements MeterRepositoryInterface {

    final String query = "select data_date, value from meter_data,meter where parent_id = ";
    final String query2 = "select meter_id from belongs_to where area_id=";

    public static BasicDataSource createDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUsername("nb");
        dataSource.setPassword("NB");
        dataSource.setUrl("jdbc:oracle:thin:@CCVMDBS12:1521:NBBDEV1");
        return dataSource;
    }

    @Override
    public List<Meter> getAllMeters(Area area) {
        return null;
    }

    @Override
    public List<MeterData> getDataByDate(Meter meter, Date start, Date end) {
        return null;
    }

    @Override
    public List<Meter> getOldMeter(Date date) {
        return null;
    }
}
