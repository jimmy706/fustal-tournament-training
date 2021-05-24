package com.axonactive.footballtournament.member;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class GenderPersistenceConverter implements AttributeConverter<Gender, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Gender attribute) {
        return (attribute != null)? attribute.getGender() : null;
    }

    @Override
    public Gender convertToEntityAttribute(Integer dbData) {
        Gender gender = Gender.UNKNOW;
        for (Gender each : Gender.values()) {
            if (each.getGender() == dbData) {
                gender = each;
                break;
            }
        }
        return gender;
    }
    
}
