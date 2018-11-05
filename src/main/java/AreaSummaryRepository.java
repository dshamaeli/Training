package uk.co.crowderconsult;

import java.util.Date;
import java.util.List;

/**
 * @author Daniel.shamaeli
 */
public interface AreaSummaryRepository {

    /**
     * Gets list of Area Data for an Area between a provided start and end date
     *
     * @param area  particular area of interest
     * @param start start date
     * @param end   end date
     * @return list of Area Data
     */
    List<AreaSummary> getSummaryByDate(Area area, Date start, Date end);
}
