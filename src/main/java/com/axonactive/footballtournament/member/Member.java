package com.axonactive.footballtournament.member;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = {"age", "gender"})
public class Member {
    
    private String firstName;

    String lastName;

    int age;

    private Gender gender;

    

}
