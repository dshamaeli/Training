/**
 * 
 */

import java.util.Date;

/**
 * Area Summaries are daily aggregates of Meter Data for all “Flow” Meters that
 * belong to an area.
 * 
 * @author daniel.shamaeli
 *
 */
public class AreaSummary {

	private Integer parentId;
	private Date date;
	private Double totalFlow;
	private Double minFlow;
	private Double maxFlow;

	/**
	 * generates an area summary which is a daily aggregates of Meter Data for
	 * all “Flow” Meters that belong to an area.
	 * 
	 * @param parentId
	 *            ID of parent area
	 * @param totalFlow
	 *            Total flow of all “Flow” Meters in the parent area
	 * @param minFlow
	 *            Minimum flow of all “Flow” Meters in the parent area
	 * @param maxFlow
	 *            Maximum flow of all “Flow” Meters in the parent area
	 */
	public AreaSummary(Integer parentId, Double totalFlow, Double minFlow, Double maxFlow) {
		this.parentId = parentId;
		date = new Date();
		this.totalFlow = totalFlow;
		this.minFlow = minFlow;
		this.maxFlow = maxFlow;
	}

	/**
	 * returns the summary's date
	 * 
	 * @return date of the summary
	 */
	public Date getDate() {
		return date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AreaSummary other = (AreaSummary) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + "\nParent ID: " + this.parentId + "\nDate: " + this.date + "\nTotal Flow: "
				+ this.totalFlow + "\nMin Flow: " + this.minFlow + "\nMax Flow: " + this.maxFlow;
	}

}
