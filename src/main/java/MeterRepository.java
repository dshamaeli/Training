
import java.util.Date;
import java.util.List;

/**
 * @author daniel.shamaeli
 */
public interface MeterRepository {
    /**
     * @param area area that list of Meters assigned to it is required
     * @return
     */
    List<Meter> getAllMeters(Area area);

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

    /**
     * @param date specific date after meters installation
     * @return List “old” meters installed before a provided date
     */
    List<Meter> getOldMeter(Date date);

}