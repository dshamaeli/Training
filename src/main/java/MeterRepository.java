
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Get a list of Meters assigned to a particular Area
 * 
 * @author daniel.shamaeli
 *
 */
public class MeterRepository implements MeterRepositoryInterface {

	private List<Meter> meterList = new ArrayList<>();

	public List<Meter> getMeters() {
		return meterList;
	}

	public void addMeter(Meter meter) {
		this.meterList.add(meter);
	}

	@Override
	public List<Meter> getAllMeters(Area area) {
		Meter meter;
		List<Area> parentAreas = new ArrayList<>();
		List<Meter> list = new ArrayList<>();
		Iterator<Meter> iterator = meterList.iterator();
		while (iterator.hasNext()) {
			meter = iterator.next();
			parentAreas = meter.getParentAreas();
			Iterator<Area> areas = parentAreas.iterator();
			while (areas.hasNext()) {
				Area parentArea = areas.next();
				if (area.equals(parentArea)) {
					list.add(meter);
				}
			}
		}
		return list;
	}

	@Override
	public List<MeterData> getDataByDate(Meter meter, Date start, Date end) {
		MeterData data;
		Date date;
		List<MeterData> list = new ArrayList<>();
		List<MeterData> dataList = meter.getData();
		Iterator<MeterData> iterator = dataList.iterator();
		while (iterator.hasNext()) {
			data = iterator.next();
			date = data.getDate();
			if (date.after(start) && date.before(end)) {
				list.add(data);
			}
		}
		return list;
	}

	@Override
	public List<Meter> getOldMeter(Date date) {
		Meter meter;
		List<Meter> list = new ArrayList<>();
		Iterator<Meter> iterator = meterList.iterator();
		while (iterator.hasNext()) {
			meter = iterator.next();
			Date installationData = meter.getInstallDate();
			if (date.after(installationData)) {
				list.add(meter);
			}
		}
		return list;
	}

}
