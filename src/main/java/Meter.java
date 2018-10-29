import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A meter is a monitored point on a water network recording measured data such
 * as flow, pressure or level information
 *
 * @author daniel.shamaeli
 */
public class Meter {

    private Integer id;
    private String name;
    private Integer meteTypeId;
    private Date installDate;
    private Boolean active;
    private MeasurementDataType measurementDataType;
    private List<MeterData> dataList = new ArrayList<>();
    private List<Area> areaList = new ArrayList<>();

    public Meter() {
    }

    /**
     * generates A meter which is a monitored point on a water network recording
     * measured data such as flow, pressure or level information
     *
     * @param id                  Unique number that identifies the meter
     * @param name                display name for this meter
     * @param installDate         date that meter was installed
     * @param active              Shows whether the meter is active or not
     * @param measurementDataType data type that the meter measures
     * @see MeterType
     * @see MeasurementDataType
     */
    public Meter(int id, String name, Integer meterTypeId,
                 Date installDate, Boolean active, MeasurementDataType measurementDataType) {
        this.id = id;
        this.meteTypeId = meterTypeId;
        this.name = name;
        this.installDate = installDate;
        this.active = active;
        this.measurementDataType = measurementDataType;
    }

    public Meter(int id, String name, MeterType meterType,
                 Date installDate, Boolean active, MeasurementDataType measurementDataType) {
        this.id = id;
        this.meteTypeId = meterType.getMeterTypeId();
        this.name = name;
        this.installDate = installDate;
        this.active = active;
        this.measurementDataType = measurementDataType;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MeasurementDataType getMeasurementDataType() {
        return measurementDataType;
    }

    public void setMeasurementDataType(MeasurementDataType measurementDataType) {
        this.measurementDataType = measurementDataType;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getMeteTypeId() {
        return meteTypeId;
    }

    public void setMeteTypeId(Integer meteTypeId) {
        this.meteTypeId = meteTypeId;
    }

    public Date getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

    public void addData(Double value) {
        MeterData data = new MeterData(this, value);
        dataList.add(data);
    }

    public List<MeterData> getData() {
        return dataList;
    }

    /**
     * @return List of all parent areas of meter
     */
    public List<Area> getParentAreas() {
        return areaList;
    }

    /**
     * @param area parent area of the meter
     */
    public void addParentArea(Area area) {
        this.areaList.add(area);
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Meter))
            return false;
        if (obj == this)
            return true;
        return this.getId() == ((Meter) obj).getId();
    }

    @Override
    public String toString() {
        return super.toString() + "\nid: " + this.id + "\nname: " + this.name + "\ntype: " + meteTypeId + "\ninstallation date: "
                + this.installDate + "\nStatus: " + this.active + "\nmeasurementDataType: " + this.measurementDataType;
    }

}
