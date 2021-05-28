package com.axonactive.footballtournament.company;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

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
    @NamedQuery(name = Company.GET_ALL_QUERY, query = "SELECT c FROM Company c"),
    @NamedQuery(name = Company.GET_BY_ID, query = "SELECT c FROM Company c WHERE c.id =:companyId")
})
@ValidCompany
public class Company {

    public static final String QUALIFIER = "com.axonactive.footballtournament.company.";

    public static final String GET_ALL_QUERY = QUALIFIER + "getAll";

    public static final String GET_BY_ID = QUALIFIER + "getById";

    @Column(name = "company_name")
    @NotNull(message = CompanyMessage.COMPANY_NAME_REQUIRED)
    String name;

    @Column(unique = true, name = "company_id")
    @NotNull(message = CompanyMessage.COMPANY_ID_REQUIRED)
    String id;


    @OneToOne(cascade = CascadeType.ALL)
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

    public boolean isValid() {
        return name != null && !name.isEmpty() && id != null && !id.isEmpty();
    }

 
}
