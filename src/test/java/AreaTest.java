
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaTest {
    private static final Logger LOG = LoggerFactory.getLogger(AreaTest.class);
    private Integer id = 123;
    private String name = "Quality Area 1";
    private AreaType type = AreaType.QUALITY;
    private boolean active = true;

    private Area createTestSubject() {
        return new Area(id, name, type, active);

    }

    private Area createEmptyTestSubject() {
        return new Area(null, null, null, null);

    }

    @Test
    public void testGetId() throws Exception {
        Area testSubject;
        Integer result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.getId();
        LOG.trace(String.valueOf(result));
        assertEquals(this.id, result);
    }

    @Test
    public void testSetId() throws Exception {
        Area testSubject;
        Integer id = this.id;
        Integer result;

        // default test
        testSubject = createEmptyTestSubject();
        testSubject.setId(id);
        result = testSubject.getId();
        assertEquals(id, result);
    }

    @Test
    public void testGetName() throws Exception {
        Area testSubject;
        String result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.getName();
        assertEquals(this.name, result);
    }

    @Test
    public void testSetName() throws Exception {
        Area testSubject;
        String name = this.name;
        String result;

        // default test
        testSubject = createEmptyTestSubject();
        testSubject.setName(name);
        result = testSubject.getName();
        assertEquals(name, result);
    }

    @Test
    public void testGetType() throws Exception {
        Area testSubject;
        AreaType result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.getType();
        assertEquals(this.type, result);
    }

    @Test
    public void testSetType() throws Exception {
        Area testSubject;
        AreaType type = this.type;
        AreaType result;
        // default test
        testSubject = createEmptyTestSubject();
        testSubject.setType(type);
        result = testSubject.getType();
        assertEquals(this.type, result);
    }

    @Test
    public void testIsActive() throws Exception {
        Area testSubject;
        Boolean result;
        testSubject = createTestSubject();
        result = testSubject.isActive();
        assertEquals(this.active, result);
    }

    @Test
    public void testSetisActive() throws Exception {
        Area testSubject;
        Boolean result;
        testSubject = createEmptyTestSubject();
        testSubject.setisActive(this.active);
        result = testSubject.isActive();
        assertEquals(this.active, result);
    }


    @Test
    public void testHashCode() throws Exception {
        Area testSubject;
        Integer result;
        testSubject = createTestSubject();
        result = testSubject.hashCode();
        assertEquals(this.id, result);
    }

    @Test
    public void testEquals() throws Exception {
        Area testSubject;
        Object obj = null;
        boolean result;
        testSubject = createTestSubject();
        result = testSubject.equals(obj);
        LOG.debug("hello");
        Assert.assertEquals(false, result);
    }

    @Test
    public void testToString() throws Exception {
        Area testSubject;
        String result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.toString();
        System.out.println(result);
    }

    @Test
    public void testAddmeter() throws Exception {
        Area testSubject;
        Meter meter = new Meter();
        testSubject = createTestSubject();
        testSubject.addmeter(meter);
    }

    @Test
    public void testGetAllMeters() throws Exception {
        Area testSubject;
        List<Meter> result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.getAllMeters();
    }
}