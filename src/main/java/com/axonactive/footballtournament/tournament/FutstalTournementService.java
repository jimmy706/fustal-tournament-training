package com.axonactive.footballtournament.tournament;

import java.util.ArrayList;
import java.util.List;

import com.axonactive.footballtournament.team.Team;

import lombok.Getter;

public class FutstalTournementService  {

    @Getter
    private List<Team> registeredTeams;

    public FutstalTournementService() {
        this.registeredTeams = new ArrayList<>();
    }

    public void registerForTournement(Team team) {
        if(team.validateTeamSize()) {
            registeredTeams.add(team);
        }
        else {
            throw new IllegalArgumentException("A team must have at least " + Team.MIN_PLAYER + " players and maximum is " + Team.MAX_PLAYER);
        }
    }

    public boolean isEnoughPlayer(Team team) {
        int teamSize = team.getPlayers().size();

        return teamSize >= 7 && teamSize <= 12;            
    }

    
}
