package com.axonactive.footballtournament.team;

import java.util.ArrayList;
import java.util.List;

import com.axonactive.footballtournament.member.player.Player;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Team {
    
    @NonNull String name;

    @NonNull List<Player> players;

    private String company;

    public Team(String name, String company) {
        this.name = name;
        this.company = company;
        this.players = new ArrayList<>();
    }

    
    public Team(String name, String company, List<Player> players) {
        this.name = name;
        this.company = company;
        this.players = players;
    }

    public void addPlayer(Player newPlayer) {
        players.add(newPlayer);
    }

    

}
