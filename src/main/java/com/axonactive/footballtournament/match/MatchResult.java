package com.axonactive.footballtournament.match;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.axonactive.footballtournament.match.scoretype.ScoreTypes;
import com.axonactive.footballtournament.match.winner.Winner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity
public class MatchResult {

    @Column
    int firstTeamScore;

    @Column
    int secondTeamScore;

    @JoinColumn
    @OneToOne
    Match match;

    @Column
    @Id
    private int id;

    public MatchResult(int firstTeamScore, int secondTeamScore, Match match){
        this.firstTeamScore = firstTeamScore;
        this.secondTeamScore = secondTeamScore;
        this.match = match;
    }

    public Winner getWinner() {
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
