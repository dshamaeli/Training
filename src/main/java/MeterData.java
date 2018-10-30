import java.util.Date;

/**
 * Meter data are records of network data at a point in time e.g. flow through a
 * pipe, level of water in a tank.
 *
 * @author daniel.shamaeli
 */
public class MeterData {
    private Meter parent;
    private Date date;
    private Double value;

    /**
     * @param parent Id of meter that owns the data
     * @param value  recorded numeric value of up to 3 decimal places
     */
    public MeterData(Meter parent, Double value) {
        this.parent = parent;
        this.value = value;
        this.date = new Date();
    }

    /**
     * @return returns date that data is created
     */
    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "parent: " + this.parent + "\ndate: " + this.date + "\nvalue: " + this.value; //NON-NLS
    }

}
