package com.axonactive.footballtournament.match;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.axonactive.footballtournament.team.Team;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class Match {
    
    @NotNull private Team firstTeam;

    @NotNull Team secondTeam;

    private String matchId;

    @NotNull LocalDateTime startDateTime;

    @NotNull LocalDateTime endDateTime;

    @NotNull String location;

    public Match(Team firstTeam, Team secondTeam, LocalDateTime startDateTime, LocalDateTime endDateTime, String location ){
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.location = location;
        this.matchId = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Match [endDateTime=" + endDateTime + ", firstTeam=" + firstTeam.getName() + ", matchId=" + matchId + ", secondTeam=" + secondTeam.getName()+ ", startDateTime=" + startDateTime + "]";
    }

    
}
