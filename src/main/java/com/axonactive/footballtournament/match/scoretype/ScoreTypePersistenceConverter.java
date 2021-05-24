package com.axonactive.footballtournament.match.scoretype;

import javax.persistence.AttributeConverter;

public class ScoreTypePersistenceConverter implements AttributeConverter<ScoreTypes, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ScoreTypes attr) {
        return attr != null ? attr.getScore() : null;
    }

    @Override
    public ScoreTypes convertToEntityAttribute(Integer dbData) {
        ScoreTypes result = ScoreTypes.FIRST_TEAM_SCORE;
        for(ScoreTypes st : ScoreTypes.values()){
            if(st.getScore() == dbData) {
                result = st;
                break;
            }
        }

        return result;
    }
    
}
