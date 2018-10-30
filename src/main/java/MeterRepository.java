
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
     * @param date specific date after meters installation
     * @return List “old” meters installed before a provided date
     */
    List<Meter> getOldMeter(Date date);

}