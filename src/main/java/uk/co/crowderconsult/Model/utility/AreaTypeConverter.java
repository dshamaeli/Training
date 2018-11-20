package uk.co.crowderconsult.Model.utility;

import uk.co.crowderconsult.Model.area.AreaType;

import javax.persistence.AttributeConverter;
import java.util.EnumSet;

public class AreaTypeConverter implements AttributeConverter<AreaType, String> {
    @Override
    public String convertToDatabaseColumn(AreaType attribute) {
        return attribute.name().toUpperCase();
    }

    @Override
    public AreaType convertToEntityAttribute(String dbData) {
        for (AreaType value : EnumSet.allOf(AreaType.class)) {
            if (value.name().equalsIgnoreCase(dbData)) {
                return value;
            }
        }
        return null;
    }
}
