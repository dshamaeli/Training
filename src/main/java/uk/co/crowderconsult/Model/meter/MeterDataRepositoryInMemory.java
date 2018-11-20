package uk.co.crowderconsult.Model.meter;

import java.util.*;

/**
 * @author Daniel.shamaeli
 */
public class MeterDataRepositoryInMemory implements MeterDataRepository {

    private Map<Meter, List<MeterData>> map = new HashMap<>();


    @Override
    public List<MeterData> getDataByDate(Meter meter, Date start, Date end) {
        MeterData data;
        Date date;
        List<MeterData> list = new ArrayList<>();
        List<MeterData> datas = map.get(meter);
        Iterator iterator = datas.iterator();
        while (iterator.hasNext()) {
            data = (MeterData) iterator.next();
            date = data.getDate();
            if (date.after(start) && date.before(end)) {
                list.add(data);
            }
        }
        return list;
    }
}
