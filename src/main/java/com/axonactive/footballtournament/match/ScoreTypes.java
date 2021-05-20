package com.axonactive.footballtournament.match;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ScoreTypes {
    FIRST_TEAM_SCORE(1),
    SECOND_TEAM_SCORE(2);

    private int score;
}
