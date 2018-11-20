package uk.co.crowderconsult.meter;

import uk.co.crowderconsult.area.Area;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Get a list of Meters assigned to a particular Area
 *
 * @author daniel.shamaeli
 */
public class MeterRepositoryInMemory implements MeterRepository {

    private List<Meter> meterList = new ArrayList<>();

    public List<Meter> getMeters() {
        return meterList;
    }

    /**
     * Adds meter to the repository
     *
     * @param meter meter
     */
    public void addMeter(Meter meter) {
        this.meterList.add(meter);
    }

    @Override
    public List<Meter> getAllMeters(Area area) {
        Meter meter;
        List<Area> parentAreas;
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
