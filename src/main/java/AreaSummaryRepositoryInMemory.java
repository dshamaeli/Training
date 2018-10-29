import java.util.*;

public class AreaSummaryRepositoryInMemory implements AreaSummaryRepository {

    private Map<Area, List<AreaSummary>> map = new HashMap<>();


    @Override
    public List<AreaSummary> getSummaryByDate(Area area, Date start, Date end) {
        AreaSummary summary;
        Date date;
        List<AreaSummary> list = new ArrayList<>();
        List<AreaSummary> areaSummaries = map.get(area);
        Iterator iterator = areaSummaries.iterator();
        while (iterator.hasNext()) {
            summary = (AreaSummary) iterator.next();
            date = summary.getDate();
            if (date.after(start) && date.before(end)) {
                list.add(summary);
            }
        }
        return list;
    }
}
