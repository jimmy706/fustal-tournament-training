package com.axonactive.footballtournament.match;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.JoinColumn;

import com.axonactive.footballtournament.team.Team;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@NamedQueries({
    @NamedQuery(name=Match.GET_ALL_QUERY, query = "SELECT m FROM Match m")
})
public class Match {

    public static final String QUALIFIER = "com.axonactive.footballtournament.match.";

    public static final String GET_ALL_QUERY = QUALIFIER + "getAll";

    @Column(name = "match_id")
    @Id
    @GeneratedValue
    private Integer matchId;

    @Column(name = "start_datetime", columnDefinition = "TIMESTAMP")
    LocalDateTime startDateTime;

    @Column(name = "end_datetime", columnDefinition = "TIMESTAMP")
    LocalDateTime endDateTime;

    @Column
    String location;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "Team_Match",
        joinColumns = {@JoinColumn(name="match_id")},
        inverseJoinColumns = {@JoinColumn(name="team_id")}
    )
    Set<Team> teams;

    public Match( LocalDateTime startDateTime, LocalDateTime endDateTime, String location ){
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.location = location;
        this.teams = new HashSet<>();
    }

    public void addTeam(Team team) {
        if(!teams.contains(team)) {
            teams.add(team);
        }
        else {
            throw new IllegalArgumentException("Team already existed");
        }
    }
 
    public boolean isValid() {
        return this.teams.size() == 2;
    }
}
