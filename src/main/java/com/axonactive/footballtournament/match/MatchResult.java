package com.axonactive.footballtournament.match;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@ToString
public class MatchResult {
    @Getter
    @Setter
    int firstTeamScore;
    
    @Getter
    @Setter
    int secondTeamScore;

    @Getter
    String match;

    private Winner getWinner() {
        if(firstTeamScore > secondTeamScore){
            return Winner.FIRST_TEAM;
        }
        else if(secondTeamScore > firstTeamScore) {
            return Winner.SECOND_TEAM;
        }
        else {
            return Winner.DRAW;
        }
    }

    public void score(ScoreTypes scoreTypes) {
        if(scoreTypes == ScoreTypes.FIRST_TEAM_SCORE) {
            firstTeamScore += 1;
        }
        else {
            secondTeamScore += 1;
        }
    }
}
