package com.axonactive.footballtournament.member.player;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.axonactive.footballtournament.member.Gender;
import com.axonactive.footballtournament.member.Member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
public class Player extends Member{
    private String playerNumber;

    public Player(String firstName, String lastName, int age, String insuranceId, Gender gender, String playerNumber) {
        super(firstName, lastName, age, insuranceId, gender);
        this.playerNumber = playerNumber;
    }

    public Player(Member member, String playerNumber) {
        super(member.getFirstName(), member.getLastName(), member.getAge(), member.getSocialInsuranceId(), member.getGender());
        this.playerNumber = playerNumber;
    }

    @Override
    public boolean isValid() {
        return super.isValid() && !playerNumber.isEmpty();
    }

    
}
