import java.util.Date;
import java.util.List;

public interface AreaSummaryRepository {

    List<AreaSummary> getSummaryByDate(Area area, Date start, Date end);
}
