package com.axonactive.footballtournament.tournament;

import java.util.ArrayList;
import java.util.List;

import com.axonactive.footballtournament.team.Team;

import lombok.Getter;

public class FutstalTournementControl  {
    @Getter
    private List<Team> registeredTeams;

    public FutstalTournementControl() {
        this.registeredTeams = new ArrayList<>();
    }

    public void registerForTournement(Team team) {

        if(isEnoughPlayer(team)) {
            registeredTeams.add(team);
        }
        else {
            throw new IllegalArgumentException("A team must have at least 7 players and maximum is 12");
        }
    }

    public boolean isEnoughPlayer(Team team) {
        int teamSize = team.getPlayers().size();

        return teamSize >= 7 && teamSize <= 12;            
    }

    
}
