
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;


import org.junit.Assert;
import org.junit.Test;

public class AreaTest {
	private Integer id = 123;
	private String name = "Quality Area 1";
	private AreaType type = AreaType.QUALITY;
	private boolean active = true;
	private Double total = 221.022;
	private Double min = 41.006;
	private Double max = 46.222;

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

		// default test
		testSubject = createTestSubject();
		result = testSubject.isActive();
		assertEquals(this.type, result);
	}

	@Test
	public void testSetisActive() throws Exception {
		Area testSubject;
		Boolean result;
		// default test
		testSubject = createEmptyTestSubject();
		testSubject.setisActive(this.active);
		result = testSubject.isActive();
		assertEquals(this.type, result);
	}

	@Test
	public void testAddSummary() throws Exception {
		Area testSubject;
		Double total = this.total;
		Double max = this.max;
		Double min = this.min;

		// default test
		testSubject = createTestSubject();
		testSubject.addSummary(total, max, min);
	}

	@Test
	public void testGetSummary() throws Exception {
		Area testSubject;
		List<AreaSummary> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getSummary();
	}

	@Test
	public void testGetSummary_1() throws Exception {
		Area testSubject;
		Date start = null;
		Date end = null;
		List<AreaSummary> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getSummary(start, end);
	}

	@Test
	public void testHashCode() throws Exception {
		Area testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.hashCode();
	}

	@Test
	public void testEquals() throws Exception {
		Area testSubject;
		Object obj = null;
		boolean result;

		// test 1
		testSubject = createTestSubject();
		obj = null;
		result = testSubject.equals(obj);
		Assert.assertEquals(false, result);
	}

	@Test
	public void testToString() throws Exception {
		Area testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.toString();
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