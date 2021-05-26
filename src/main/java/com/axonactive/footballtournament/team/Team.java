package com.axonactive.footballtournament.team;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.ValidationException;

import com.axonactive.footballtournament.match.Match;
import com.axonactive.footballtournament.member.player.Player;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@NamedQueries({
    @NamedQuery(name = Team.GET_ALL_QUERY, query = "SELECT t FROM Team t"),
    // @NamedQuery(name = Team.GET_ALL_BY_MATCH, query = "SELECT t FROM Team t WHERE t.matches.matchId = :matchId")
})
public class Team {

    public static final String QUALIFIER = "com.axonactive.footballtournament.team.";

    public static final String GET_ALL_QUERY = QUALIFIER + "getAll";

    public static final String GET_ALL_BY_MATCH = QUALIFIER + "getAllByMatch";

    public static final int MIN_PLAYER = 7;

    public static final int MAX_PLAYER = 12;
    
    @Column(name = "team_name")
    String name;

    @Id
    @GeneratedValue
    private int id;
    
    /**tell Hibernate which variable we are using to represent the parent class in our child class. */
    @OneToMany 
    @JoinTable(name = "Team_Players")
    List<Player> players;

    @Column( nullable = false, name = "company")
    private String company;

    @ManyToMany
    @JoinTable(
        name = "Team_Match",
        joinColumns = {@JoinColumn(name="team_id")},
        inverseJoinColumns = {@JoinColumn(name="match_id")}
    )
    List<Match> matches;

    public Team(String name, String company) {
        this.name = name;
        this.company = company;
        this.players = new ArrayList<>();
        this.matches = new ArrayList<>();
    }

    
    public Team(String name, String company, List<Player> players) {
        this.name = name;
        this.company = company;
        this.players = players;
        this.matches = new ArrayList<>();
    }

    public void addPlayer(Player newPlayer) {
        if(isAddable()){
            players.add(newPlayer);
        }
        else {
            throw new ValidationException("A team must have at least " + MIN_PLAYER + " players and maximum is " + MAX_PLAYER);
        }
    }

    public boolean validateTeamSize() {
        return players.size() >= MIN_PLAYER && players.size() <= MAX_PLAYER;
    }

    public boolean isAddable() {
        return players.size() < 12;
    }

    public boolean validate() {
        return this.players != null && !this.name.isEmpty() && this.matches != null && !this.company.isEmpty();
    }
}
