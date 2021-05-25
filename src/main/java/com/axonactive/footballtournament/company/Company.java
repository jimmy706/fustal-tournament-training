package com.axonactive.footballtournament.company;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import com.axonactive.footballtournament.member.Member;
import com.axonactive.footballtournament.member.player.Player;
import com.axonactive.footballtournament.team.Team;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@NamedQueries({
    @NamedQuery(name = Company.GET_ALL_QUERY, query = "SELECT c FROM Company c")
})
public class Company {

    public static final String QUALIFIER = "com.axonactive.footballtournament.company.";

    public static final String GET_ALL_QUERY = QUALIFIER + "getAll";

    @Column(name = "company_name")
    String name;

    @Column(unique = true, name = "company_id")
    String id;


    @OneToOne
    @JoinColumn(name = "team")
    Team team;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int keyId;

    public Company(String name, String id) {
        this.name = name;
        this.id = id;
        this.team = new Team(name, id);
    }
    

    public void addPlayer(Player player) {
        if(isWorkingForCompany(player)) {
            team.addPlayer(player);
        }
        else {
            throw new IllegalArgumentException("Player must be working for company!");
        }
    }

    public boolean isWorkingForCompany(Member member) {
        return id.equals(member.getSocialInsuranceId());
    }
}
