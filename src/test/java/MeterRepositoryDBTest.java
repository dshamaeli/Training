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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;


public class MeterRepositoryDBTest {
    private static final Logger LOG = LoggerFactory.getLogger(AreaTest.class);

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
    }

    @Test
    public void createDataSource() throws SQLException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy'T'HH:mm:ssZ");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        MeterRepositoryDB meterDB = new MeterRepositoryDB();
        meterDB.getOldMeter(sdf.parse("10-10-2018T14:10:10-0000"));
    }
}