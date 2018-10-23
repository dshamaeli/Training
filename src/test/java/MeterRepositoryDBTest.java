import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MeterRepositoryDBTest {
    private static final Logger LOG = LoggerFactory.getLogger(AreaTest.class);
    final String query = "select data_date, value from meter_data,meter where parent_id = ";
    private BasicDataSource db = MeterRepositoryDB.createDataSource();


    @Before
    public void setUp() throws Exception {
        Integer id = 123;
        String name = "Quality Area 1";
        AreaType type = AreaType.QUALITY;
        Boolean active = true;
        Double total = 221.022;
        Double min = 41.006;
        Double max = 46.222;
        Area area = new Area(id, name, type, active);
    }

    @After
    public void tearDown() throws Exception {
        db.close();
    }

    @Test
    public void createDataSource() {
        try {
            Connection conn = db.getConnection();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(query);
            System.out.println(res.next());

        } catch (SQLException e) {

        }

    }
}