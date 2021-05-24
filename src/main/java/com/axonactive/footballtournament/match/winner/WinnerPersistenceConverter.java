package com.axonactive.footballtournament.match.winner;

import javax.persistence.AttributeConverter;




public class WinnerPersistenceConverter implements AttributeConverter<Winner, Integer>{
   

    @Override
    public Integer convertToDatabaseColumn(Winner attribute) {
        return attribute != null ? attribute.getWinner() : null;
    }

    @Override
    public Winner convertToEntityAttribute(Integer dbData) {
        Winner winner = Winner.UNKNOW;

        for(Winner value : Winner.values()) {
            if(value.getWinner() == dbData){
                winner = value;
                break;
            }
        }

        return winner;
    }
    
}
