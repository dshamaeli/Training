package uk.co.crowderconsult.utility;

import javax.persistence.AttributeConverter;

public class EnumConverter<E extends Enum<E>> implements AttributeConverter<E, String> {
    Class<E> type;

    @Override
    public String convertToDatabaseColumn(E attribute) {
        return attribute.name().toUpperCase();
    }

    @Override
    public E convertToEntityAttribute(String dbData) {
        for (Enum<E> value : type.getEnumConstants()) {
            if (value.name().equalsIgnoreCase(dbData)) {
                return (E) value;
            }
        }
        return null;
    }
}
