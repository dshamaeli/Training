package uk.co.crowderconsult.Model.area;

import java.util.List;

/**
 * @author daniel.shamaeli
 */
public interface AreaRepository {

    /**
     * gives a list of all Areas
     *
     * @return a list of all Areas
     */
    List<Area> getAllAreas();

    /**
     * gives a list of only Active Areas
     *
     * @return a list of only Active Areas
     */
    List<Area> getActiveAreas();

}
