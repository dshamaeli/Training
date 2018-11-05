import java.util.ArrayList;
import java.util.List;

/**
 * An area is a geographical region used to logically group part of a water
 * network.
 *
 * @author daniel.shamaeli
 */
public class Area {

    private Integer areaId;
    private String areaName;
    private AreaType areaType;
    private Boolean isActive;
    private List<Meter> metersList = new ArrayList<>();

    /**
     * Generates an area. An area is a geographical region used to logically
     * group part of a water network.
     *
     * @param areaId   Unique number that identifies the area.
     * @param areaName Display name for this area.
     * @param areaType Shows the area type. One of Hydraulic, Operational or Quality.
     * @param isActive flag to show if the area is active(true) or not(False).
     */
    public Area(Integer areaId, String areaName, AreaType areaType, Boolean isActive) {
        this.areaId = areaId;
        this.areaName = areaName;
        this.areaType = areaType;
        this.isActive = isActive;
    }

    /**
     * returns ID of the area
     *
     * @return areaId
     */
    public Integer getId() {
        return areaId;
    }

    /**
     * set ID of the Area
     *
     * @param areaId ID of the Area
     */
    public void setId(Integer areaId) {
        this.areaId = areaId;
    }


    /**
     * returns name of the area
     *
     * @return areaName
     */
    public String getName() {
        return areaName;
    }

    /**
     * sets name of the area
     *
     * @param areaName of the area
     */
    public void setName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * returns type of the area
     *
     * @return type of the area
     */
    public AreaType getType() {
        return this.areaType;
    }

    /**
     * sets type of the area
     *
     * @param areaType one of Hydraulic, Operational or Quality
     */
    public void setType(AreaType areaType) {
        this.areaType = areaType;
    }

    /**
     * @return <code>true</code> if area is active and <code>false</code>
     * otherwise
     */
    public Boolean isActive() {
        return isActive;
    }

    /**
     * Activate or deactivate an area
     *
     * @param isActive <code>true</code> to activate and <code>false</code> to
     *                 deactivate an area
     */
    public void setisActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Adds meter to this repository
     *
     * @param meter meter that should be added to the repository
     */
    public void addmeter(Meter meter) {
        metersList.add(meter);
    }

    /**
     * @return List<Meter> a list of Meters assigned to this Area
     */
    public List<Meter> getAllMeters() {
        return this.metersList;
    }

    @Override
    public int hashCode() {
        return this.areaId;
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
        return super.toString() + "\nID: " + this.areaId + "\nName: " + this.areaName + "\nArea Type:" + this.areaType //NON-NLS
                + "\nActivation Status: " + this.isActive; //NON-NLS
    }


}