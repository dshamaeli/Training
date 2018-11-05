package uk.co.crowderconsult;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Daniel.shamaeli
 * @see AreaRepository
 */
public class AreaRepositoryInMemory implements AreaRepository {

    private List<Area> areaList = new ArrayList<>();

    @Override
    public List<Area> getAllAreas() {

        return this.areaList;
    }

    @Override
    public List<Area> getActiveAreas() {
        List<Area> list = new ArrayList<>();
        Iterator<Area> iterator = areaList.iterator();
        while (iterator.hasNext()) {
            Area area = iterator.next();
            if (area.isActive()) {
                list.add(area);
            }
        }
        return list;
    }
}