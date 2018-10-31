import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AreaRepositoryJDBCTest {
    private static final Logger LOG = LoggerFactory.getLogger(AreaTest.class);

    private AreaRepositoryJDBC areaDB;
    private List<Area> result = null;

    @Before
    public void setUp() {
        areaDB = new AreaRepositoryJDBC();
    }

    @Test
    public void getAllAreas() {
        Integer id = 321;
        result = areaDB.getAllAreas();
        Assert.assertEquals(id, result.get(0).getId());
    }

    @Test
    public void getActiveAreas() {
        result = areaDB.getActiveAreas();
        Assert.assertEquals(4, result.size());
    }
}