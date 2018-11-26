package uk.co.crowderconsult.Model.meter;


import uk.co.crowderconsult.Model.area.Area;
import uk.co.crowderconsult.Model.utility.BooleanYesNoConverter;
import uk.co.crowderconsult.Model.utility.MeasurementDataTypeConverter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A meter is a monitored point on a water network recording measured data such
 * as flow, pressure or level information
 *
 * @author daniel.shamaeli
 */
@Entity
@Table(name = "Meter")
public class Meter {

    @Id
    @Column(name = "meter_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "meter_type_id")
    private Integer meteTypeId;
    @Column(name = "install_date")
    private Date installDate;
    @Convert(converter = BooleanYesNoConverter.class)
    @Column(name = "is_active")
    private Boolean active;
    @Column(name = "measurement_data_type")
    @Convert(converter = MeasurementDataTypeConverter.class)
    private MeasurementDataType measurementDataType;
    @OneToMany(targetEntity = Area.class)
    @JoinTable(
            name = "area_meter_lookup",
            joinColumns = {@JoinColumn(name = "area_id")},
            inverseJoinColumns = {@JoinColumn(name = "meter_id")}
    )
    private List<Area> areaList = new ArrayList<>();

    /**
     * generates A meter which is a monitored point on a water network recording
     * measured data such as flow, pressure or level information
     */
    public Meter() {
    }


    /**
     * Generates a meter by meter type ID
     *
     * @param id                  Unique number that identifies the meter
     * @param name                display name for this meter
     * @param meterTypeId         Id of meter type
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


    /**
     * Generates a meter by meter type object
     *
     * @param id                  Unique number that identifies the meter
     * @param name                display name for this meter
     * @param meterType           Id of meter type
     * @param installDate         date that meter was installed
     * @param active              Shows whether the meter is active or not
     * @param measurementDataType data type that the meter measures
     * @see MeterType
     * @see MeasurementDataType
     */
    public Meter(int id, String name, MeterType meterType,
                 Date installDate, Boolean active, MeasurementDataType measurementDataType) {
        this.id = id;
        this.meteTypeId = meterType.getMeterTypeId();
        this.name = name;
        this.installDate = installDate;
        this.active = active;
        this.measurementDataType = measurementDataType;
    }


    /**
     * @return meter ID
     */
    public int getId() {
        return id;
    }

    /**
     * @param id meter ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return meters's name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name set meters name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return meter's measurement data type
     */
    public MeasurementDataType getMeasurementDataType() {
        return measurementDataType;
    }

    /**
     * @param measurementDataType meter's measurement data type
     */
    public void setMeasurementDataType(MeasurementDataType measurementDataType) {
        this.measurementDataType = measurementDataType;
    }

    /**
     * @return meter activation status
     */
    public Boolean isActive() {
        return active;
    }

    /**
     * @param active sets meter activation status
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * @return meter type
     */
    public Integer getMeteTypeId() {
        return meteTypeId;
    }

    /**
     * @param meteTypeId sets meter type ID
     */
    public void setMeteTypeId(Integer meteTypeId) {
        this.meteTypeId = meteTypeId;
    }

    /**
     * @return meter's installation date
     */
    public Date getInstallDate() {
        return installDate;
    }

    /**
     * @param installDate sets meter installation date
     */
    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }


    /**
     * @return List of all parent areas of meter
     */
    public List<Area> getParentAreas() {
        return areaList;
    }

    /**
     * Adds meter to an area
     *
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
