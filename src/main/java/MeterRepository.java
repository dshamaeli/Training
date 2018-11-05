package uk.co.crowderconsult;

import java.util.Date;
import java.util.List;

/**
 * @author daniel.shamaeli
 */
public interface MeterRepository {
    /**
     * Gets a list of Meters assigned to a particular Area
     *
     * @param area area that list of Meters assigned to it is required
     * @return list of Meters
     */
    List<Meter> getAllMeters(Area area);


    /**
     * Finds “old” meters installed before a provided date
     *
     * @param date specific date after meters installation
     * @return List “old” meters installed before a provided date
     */
    List<Meter> getOldMeter(Date date);

}