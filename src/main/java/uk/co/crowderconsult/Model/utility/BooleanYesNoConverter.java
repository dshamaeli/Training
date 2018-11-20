package uk.co.crowderconsult.Model.utility;

import javax.persistence.AttributeConverter;

public class BooleanYesNoConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return (Boolean.TRUE.equals(attribute)) ? "Y" : "N";
    }


    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "Y".equalsIgnoreCase(dbData);
    }
}
