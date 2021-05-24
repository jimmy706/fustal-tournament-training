package com.axonactive.footballtournament.team;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.ValidationException;

import com.axonactive.footballtournament.member.player.Player;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode
@NoArgsConstructor
public class Team {

    public static final int MIN_PLAYER = 7;

    public static final int MAX_PLAYER = 12;
    
    String name;

    @Id
    private int id;
    
    @OneToMany
    List<Player> players;

    @Column
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

}
