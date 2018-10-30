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

    private MeterRepositoryJDBC meterDB;
    private List<Meter> result = null;

    @Before
    public void setUp() {
        meterDB = new MeterRepositoryJDBC();
    }

    @Test
    public void getAllMeters() {
        Area area = new Area(321, "Quality Area 1", AreaType.QUALITY, true);
        result = meterDB.getAllMeters(area);
        System.out.println(result.size());
        Assert.assertEquals(123, result.get(0).getId());
    }

    @Test
    public void getOldMeter() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss.SSSZ");
        try {
            Date date = sdf.parse("01-11-2018T12:11:56.235-0700");
            result = meterDB.getOldMeter(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(123, result.get(0).getId());
    }
}