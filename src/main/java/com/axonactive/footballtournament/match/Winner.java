package com.axonactive.footballtournament.match;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Winner {
    UNKNOW(0),
    FIRST_TEAM (1),
    SECOND_TEAM (2),
    DRAW(3);

    private int winner;
}
