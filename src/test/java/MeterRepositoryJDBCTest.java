import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class MeterRepositoryJDBCTest {
    private static final Logger LOG = LoggerFactory.getLogger(AreaTest.class);

    @Before
    public void setUp() {
        Integer id = 123;
        String name = "Quality Area 1";
        AreaType type = AreaType.QUALITY;
        Boolean active = true;
        Double total = 221.022;
        Double min = 41.006;
        Double max = 46.222;
        Area area = new Area(id, name, type, active);
    }

    @Test
    public void createDataSource() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss.SSSZ");
        MeterRepositoryJDBC meterDB = null;
        List<Meter> result = null;
        try {
            meterDB = new MeterRepositoryJDBC();
            Date date = sdf.parse("01-11-2018T12:11:56.235-0700");
            result = meterDB.getOldMeter(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(123, result.get(0).getId());
    }
}