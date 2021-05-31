package com.axonactive.footballtournament.member.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.axonactive.footballtournament.member.Gender;
import com.axonactive.footballtournament.member.Member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@NamedQueries({
    @NamedQuery(name=Player.GET_ALL_QUERY, query = "SELECT m FROM Member m"),
    @NamedQuery(name=Player.GET_BY_COMPANY, query = "SELECT m FROM Player m WHERE m.socialInsuranceId = :companyId"),
})
public class Player extends Member{
    public static final String QUALIFIER = "com.axonactive.footballtournament.member.";

    public static final String GET_ALL_QUERY = QUALIFIER + "getAll";

    public static final String GET_BY_COMPANY = QUALIFIER + "getByCompany";


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
    
}
