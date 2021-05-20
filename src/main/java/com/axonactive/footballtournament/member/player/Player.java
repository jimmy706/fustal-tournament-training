package com.axonactive.footballtournament.member.player;

import com.axonactive.footballtournament.member.Gender;
import com.axonactive.footballtournament.member.Member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player extends Member{

    public Player(String firstName, String lastName, int age, Gender gender, String playerNumber) {
        super(firstName, lastName, age, gender);
        this.playerNumber = playerNumber;
    }

    public Player(Member member, String playerNumber) {
        super(member.getFirstName(), member.getLastName(), member.getAge(), member.getGender());
        this.playerNumber = playerNumber;
    }

    private String playerNumber;

    @Override
    public String toString() {
        return super.toString();
    }


    
}
