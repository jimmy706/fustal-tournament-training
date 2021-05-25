package com.axonactive.footballtournament.member.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import com.axonactive.footballtournament.member.Gender;
import com.axonactive.footballtournament.member.Member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Player extends Member{
    @Column(name = "player_number")
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
