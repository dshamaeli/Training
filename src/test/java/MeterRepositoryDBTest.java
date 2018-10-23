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

import static org.junit.Assert.assertEquals;


public class MeterRepositoryDBTest {
    private static final Logger LOG = LoggerFactory.getLogger(AreaTest.class);
    //    final String query = "select data_date, value from meter_data,meter where parent_id = 123;";
    final String query = "select meter_id from NB.Meter where install_date < TO_TIMESTAMP('10-SEP-0214:10:10.123','DD-MON-RRHH24:MI:SS.FF')";
    private BasicDataSource db = Database.createDataSource();


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
    public void createDataSource() throws SQLException {
        Connection conn = db.getConnection();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query);
        assertEquals(2, result.getClass());

    }
}