import java.util.Date;
import java.util.List;

public interface MeterDataRepository {

    /**
     * give a list of Meter Data for a Meter between a provided start and end
     * date
     *
     * @param meter meter that hold the data
     * @param start start date of measurement
     * @param end   end date of measurement
     * @return list of Meter Data
     */
    List<MeterData> getDataByDate(Meter meter, Date start, Date end);
}
