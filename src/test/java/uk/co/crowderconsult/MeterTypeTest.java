package uk.co.crowderconsult;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.co.crowderconsult.meter.MeterType;


public class MeterTypeTest {

    MeterType type;
    Integer id = 123;
    String name = "Inlet Meter";
    Double maxSize = 50.00;
    Double maxFlow = 30.00;
    Double maxPressure = 20.00;

    @Before
    public void setUp() throws Exception {
        type = new MeterType(id, name, maxSize, maxFlow, maxPressure);
    }

    @Test
    public void getMeterTypeId() {
        Assert.assertEquals(id, type.getMeterTypeId());
    }

    @Test
    public void setMeterTypeId() {
        Integer newId = 258;
        type.setMeterTypeId(newId);
        Assert.assertEquals(newId, type.getMeterTypeId());
    }

    @Test
    public void getMeterTypeName() {
        Assert.assertEquals(name, type.getMeterTypeName());
    }

    @Test
    public void setMeterTypeName() {
        String newName = "Outlet";
        type.setMeterTypeName(newName);
        Assert.assertEquals(newName, type.getMeterTypeName());
    }

    @Test
    public void getMaxSize() {
        Assert.assertEquals(maxSize, type.getMaxSize());
    }

    @Test
    public void setMaxSize() {
        Double newMaxSize = 100.00;
        type.setMaxSize(newMaxSize);
        Assert.assertEquals(newMaxSize, type.getMaxSize());
    }

    @Test
    public void getMaxFlow() {
        Assert.assertEquals(maxFlow, type.getMaxFlow());
    }

    @Test
    public void setMaxFlow() {
        Double newMaxFlow = 100.00;
        type.setMaxFlow(newMaxFlow);
        Assert.assertEquals(newMaxFlow, type.getMaxFlow());
    }

    @Test
    public void getMaxPressure() {
        Assert.assertEquals(maxPressure, type.getMaxPressure());
    }

    @Test
    public void setMaxPressure() {
        Double newMaxPressure = 100.00;
        type.setMaxPressure(newMaxPressure);
        Assert.assertEquals(newMaxPressure, type.getMaxPressure());
    }

    @Test
    public void toStringTest() {
        System.out.println(type.toString());
    }
}