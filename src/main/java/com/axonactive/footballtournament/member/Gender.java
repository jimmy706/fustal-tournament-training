package com.axonactive.footballtournament.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE (1),
    FEMALE (2),
    UNKNOW (3);

    private int gender;


}
