package uk.co.crowderconsult;

import org.junit.Before;
import org.junit.Test;
import uk.co.crowderconsult.area.Area;
import uk.co.crowderconsult.area.AreaType;
import uk.co.crowderconsult.meter.MeasurementDataType;
import uk.co.crowderconsult.meter.Meter;
import uk.co.crowderconsult.meter.MeterRepositoryInMemory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MeterRepositoryInMemoryTest {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
    private Meter[] testMeters = new Meter[3];
    private Area[] parentAreas = new Area[3];

    //	public MeterRepositoryInMemoryTest() throws ParseException {
    @Before
    public void setUp() throws Exception {
        // Meter info
        Integer[] id = {111, 112, 113};
        String[] typeName = {"Inlet", "Abstraction", "Distribution"};
        Double[] maxSize = {50.00, 650.00, 750.00};
        Double[] maxFlow = {50.00, 100.00, 100.00};
        Double[] maxPressure = {20.00, 100.00, 100.00};
        Integer[] type_id = {123, 456, 789};
        String[] name = {" Quality Area 1 Meter", "Hydraulic Area 1 Meter", "Operationl Area 1 Meter"};
        Date[] installDate = {dateFormat.parse("01-10-2018 12:02:22"), dateFormat.parse("10-10-2018 08:46:11"),
                dateFormat.parse("05-10-2018 22:59:01")};
        Boolean[] active = {true, true, false};
        MeasurementDataType[] measurementDataType = {MeasurementDataType.FLOW, MeasurementDataType.PRESSURE,
                MeasurementDataType.LEVEL};

        // Area info
        Integer[] idArea = {755, 819, 20};
        String[] nameArea = {"Quality Area 1", "Hydraulic Area 1", "Operational Area 2"};
        AreaType[] type = {AreaType.QUALITY, AreaType.HYDRAULIC, AreaType.OPERATIONAL};
        Boolean[] isActive = {true, true, false};

        for (int i = 0; i < testMeters.length; i++) {

            this.testMeters[i] = new Meter(id[i], name[i], type_id[i],
                    installDate[i], active[i], measurementDataType[i]);
            this.parentAreas[i] = new Area(idArea[i], nameArea[i], type[i], isActive[i]);
        }
    }

    private MeterRepositoryInMemory createTestSubject() {
        MeterRepositoryInMemory meterRepository = new MeterRepositoryInMemory();
        for (int i = 0; i < this.testMeters.length; i++) {
            meterRepository.addMeter(this.testMeters[i]);
        }
        return meterRepository;
    }


    @Test
    public void testGetOldMeter() throws Exception {
        Date date = this.dateFormat.parse("09-10-2018 14:07:30");
        MeterRepositoryInMemory testSubject;
        List<Meter> result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.getOldMeter(date);
        assertEquals(2, result.size());

    }
}