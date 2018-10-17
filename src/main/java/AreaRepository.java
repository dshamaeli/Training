
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AreaRepository implements AreaRepositoryInterface {

	// lists
	private List<Area> areaList = new ArrayList<Area>();

	@Override
	public List<Area> getAllAreas() {

		return this.areaList;
	}

	@Override
	public List<Area> getActiveAreas() {
		ArrayList<Area> list = new ArrayList<>();
		Iterator<Area> iterator = areaList.iterator();
		while (iterator.hasNext()) {
			Area area = iterator.next();
			if (area.isActive()) {
				list.add(area);
			} else
				return null;
		}
		return list;
	}
}