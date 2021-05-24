package com.axonactive.footballtournament.match;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.axonactive.footballtournament.team.Team;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Match {

    @Column
    @Id
    private String matchId;

    @Column
    private String firstTeam;

    @Column
    private String secondTeam;



    @Column(name = "start_datetime", columnDefinition = "DATETIME")
    LocalDateTime startDateTime;

    @Column(name = "end_datetime", columnDefinition = "DATETIME")
    LocalDateTime endDateTime;

    String location;

    public Match(String firstTeam, String secondTeam, LocalDateTime startDateTime, LocalDateTime endDateTime, String location ){
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Match [endDateTime=" + endDateTime + ", firstTeam=" + firstTeam+ ", secondTeam=" + secondTeam + ", startDateTime=" + startDateTime + "]";
    }

    
}
