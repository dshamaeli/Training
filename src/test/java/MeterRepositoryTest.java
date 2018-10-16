
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.junit.Test;

public class MeterRepositoryTest {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
	private Meter[] testMeters = new Meter[3];
	private Area[] parentAreas = new Area[3];

	public MeterRepositoryTest() throws ParseException {

		// Meter info
		Integer[] id = { 111, 112, 113 };
		String[] typeName = { "Inlet", "Abstraction", "Distribution" };
		Double[] maxSize = { 50.00, 650.00, 750.00 };
		Double[] maxFlow = { 50.00, 100.00, 100.00 };
		Double[] maxPressure = { 20.00, 100.00, 100.00 };
		String[] name = { " Quality Area 1 Meter", "Hydraulic Area 1 Meter", "Operationl Area 1 Meter" };
		Date[] installDate = { dateFormat.parse("01-10-2018 12:02:22"), dateFormat.parse("10-10-2018 08:46:11"),
				dateFormat.parse("05-10-2018 22:59:01") };
		Boolean[] active = { true, true, false };
		MeasurementDataType[] measurementDataType = { MeasurementDataType.FLOW, MeasurementDataType.PRESSURE,
				MeasurementDataType.LEVEL };

		// Area info
		Integer[] idArea = { 755, 819, 20 };
		String[] nameArea = { "Quality Area 1", "Hydraulic Area 1", "Operational Area 2" };
		AreaType[] type = { AreaType.QUALITY, AreaType.HYDRAULIC, AreaType.OPERATIONAL };
		Boolean[] isActive = { true, true, false };

		for (int i = 0; i < testMeters.length; i++) {

			this.testMeters[i] = new Meter(id[i], typeName[i], maxSize[i], maxFlow[i], maxPressure[i], name[i],
					installDate[i], active[i], measurementDataType[i]);
			this.parentAreas[i] = new Area(idArea[i], nameArea[i], type[i], isActive[i]);
		}
	}

	private MeterRepository createTestSubject() {
		MeterRepository meterRepository = new MeterRepository();
		for (int i = 0; i < this.testMeters.length; i++) {
			meterRepository.addMeter(this.testMeters[i]);
		}
		return meterRepository;
	}

	// @MethodRef(name = "getAllMeters", signature = "(QArea;)QList<QMeter;>;")
	// @Test
	// public void testGetAllMeters() throws Exception {
	// MeterRepository testSubject;
	// Area area = null;
	// List<Meter> result;
	//
	// // default test
	// testSubject = createTestSubject();
	// result = testSubject.getAllMeters(area);
	// }
	//
	// @MethodRef(name = "getDataByDate", signature =
	// "(QMeter;QDate;QDate;)QList<QMeterData;>;")
	// @Test
	// public void testGetDataByDate() throws Exception {
	// MeterRepository testSubject;
	// Meter meter = null;
	// Date start = null;
	// Date end = null;
	// List<MeterData> result;
	//
	// // default test
	// testSubject = createTestSubject();
	// result = testSubject.getDataByDate(meter, start, end);
	// }

	@Test
	public void testGetOldMeter() throws Exception {
		Date date = this.dateFormat.parse("09-10-2018 14:07:30");
		MeterRepository testSubject;
		List<Meter> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getOldMeter(date);
		assertEquals(2, result.size());

	}
}