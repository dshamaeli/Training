package uk.co.crowderconsult.utility;

import uk.co.crowderconsult.meter.MeasurementDataType;

import javax.persistence.AttributeConverter;
import java.util.EnumSet;

public class MeasurementDataTypeConverter implements AttributeConverter<MeasurementDataType, String> {


    @Override
    public String convertToDatabaseColumn(MeasurementDataType attribute) {
        return attribute.name().toUpperCase();
    }

    @Override
    public MeasurementDataType convertToEntityAttribute(String dbData) {
        for (MeasurementDataType value : EnumSet.allOf(MeasurementDataType.class)) {
            if (value.name().equalsIgnoreCase(dbData)) {
                return value;
            }
        }
        return null;
    }
}
