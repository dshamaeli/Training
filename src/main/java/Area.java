/**
 * 
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * An area is a geographical region used to logically group part of a water
 * network.
 * 
 * @author daniel.shamaeli
 *
 */
public class Area {

	private static final Logger LOG = LoggerFactory.getLogger(Area.class);
	private Integer id;
	private String name;
	private AreaType type;
	private Boolean isActive;
	private List<AreaSummary> summaryList = new ArrayList<>();
	private List<Meter> metersList = new ArrayList<>();

	/**
	 * Generates an area. An area is a geographical region used to logically
	 * group part of a water network.
	 * 
	 * @param id
	 *            Unique number that identifies the area.
	 * @param name
	 *            Display name for this area.
	 * @param type
	 *            Shows the area type. One of Hydraulic, Operational or Quality.
	 * @param isActive
	 *            flag to show if the area is active(true) or not(False).
	 */
	public Area(Integer id, String name, AreaType type, Boolean isActive) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.isActive = isActive;
	}

	/**
	 * returns ID of the area
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * set ID of the Area
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * returns name of the area
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets name of the area
	 * 
	 * @param name
	 *            of the area
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * returns type of the area
	 * 
	 * @return type of the area
	 */
	public AreaType getType() {
		return this.type;
	}

	/**
	 * sets type of the area
	 * 
	 * @param type
	 *            one of Hydraulic, Operational or Quality
	 */
	public void setType(AreaType type) {
		this.type = type;
	}

	/**
	 * 
	 * 
	 * @return <code>true</code> if area is active and <code>false</code>
	 *         otherwise
	 */
	public Boolean isActive() {
		return isActive;
	}

	/**
	 * Activate or deactivate an area
	 * 
	 * @param isActive
	 *            <code>true</code> to activate and <code>false</code> to
	 *            deactivate an area
	 */
	public void setisActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * Add summary to the area
	 * 
	 * @param total
	 * @param max
	 * @param min
	 * @see AreaSummary
	 */
	public void addSummary(Double total, Double max, Double min) {
		AreaSummary areaSummary = new AreaSummary(this.id, total, max, min);
		summaryList.add(areaSummary);
	}

	public List<AreaSummary> getSummary() {
		return this.summaryList;
	}

	/**
	 * gives a list of Area Data for an Area between a provided start and end
	 * date
	 * 
	 * @param start
	 *            start date of the summary
	 * @param end
	 *            end date of the summary
	 * @return list of Area Data
	 */
	public List<AreaSummary> getSummary(Date start, Date end) {
		List<AreaSummary> list = new ArrayList<>();
		Iterator<AreaSummary> iterator = summaryList.iterator();
		while (iterator.hasNext()) {
			AreaSummary summary = iterator.next();
			Date date = summary.getDate();
			if (date.after(start) && date.before(end)) {
				list.add(summary);
			}
		}
		return list;
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Area))
			return false;
		if (obj == this)
			return true;
		return this.getId() == ((Area) obj).getId();
	}

	@Override
	public String toString() {
		return super.toString() + "\nID: " + this.id + "\nName: " + this.name + "\nArea Type:" + this.type
				+ "\nActivation Status: " + this.isActive;
	}

	public List<Meter> getAllMeters() {
		return this.metersList;
	}

}