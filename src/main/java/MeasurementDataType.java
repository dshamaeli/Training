/**
 * @author daniel.shamaeli
 */
public enum MeasurementDataType {
    FLOW, LEVEL, PRESSURE;

    public static MeasurementDataType convert(String type) {
        switch (type.toUpperCase()) {
            case "FLOW":
                return FLOW;
            case "LEVEL":
                return LEVEL;
            case "PRESSURE":
                return PRESSURE;
            default:
                throw new IllegalArgumentException("Invalid value " + type);
        }
    }

}
