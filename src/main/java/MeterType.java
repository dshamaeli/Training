
/**
 * Meter type is a standard network classification for a meter. This provides
 * additional information as to the usage of the meter
 * 
 * @author daniel.shamaeli
 */
public class MeterType {
	private String name;
	private Double maxSize;
	private Double maxFlow;
	private Double maxPressure;

	/**
	 * @param name
	 *            display name for this meter type
	 * @param maxSize
	 *            maximum size of the meter in mm between 0 and 1000
	 * @param maxFlow
	 *            maximum flow permitted in l/s between 1 and 100
	 * @param maxPressure
	 *            maximum pressure permitted in m between 1 and 100
	 */
	public MeterType(String name, Double maxSize, Double maxFlow, Double maxPressure) {
		this.name = name;
		this.maxSize = maxSize;
		this.maxFlow = maxFlow;
		this.maxPressure = maxPressure;
	}

	/**
	 * Gets the name of the meter type
	 * 
	 * @return name of the meter type
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets display name for this meter type
	 * 
	 * @param name
	 *            display name for this meter type
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the maximum size of the meter in millimetre
	 */
	public Double getMaxSize() {
		return maxSize;
	}

	/**
	 * saves the maximum size of the meter
	 * 
	 * @param maxSize
	 *            maximum size of the meter in millimetre between 0 and 1000
	 */
	public void setMaxSize(Double maxSize) {
		this.maxSize = maxSize;
	}

	/**
	 * saves the maximum flow permitted in litter/second
	 * 
	 * @return maximum flow permitted in litter/second
	 */
	public Double getMaxFlow() {
		return maxFlow;
	}

	/**
	 * saves maximum flow permitted in litter/second
	 * 
	 * @param maxFlow
	 *            maximum flow permitted in litter/second between 1 and 100
	 */
	public void setMaxFlow(Double maxFlow) {
		this.maxFlow = maxFlow;
	}

	/**
	 * returns maximum pressure permitted in meter
	 * 
	 * @return maximum pressure permitted in meter
	 */
	public Double getMaxPressure() {
		return maxPressure;
	}

	/**
	 * saves maximum pressure permitted in meter
	 * 
	 * @param maxPressure
	 *            maximum pressure permitted in meter between 1 and 100
	 */
	public void setMaxPressure(Double maxPressure) {
		this.maxPressure = maxPressure;
	}

	@Override
	public String toString() {
		return "\ntype name: " + this.name + "\nMaximum size: " + this.maxSize + "\nMaximum flow: " + this.maxFlow
				+ "\nMaximum pressure: " + this.maxPressure;
	}

}
