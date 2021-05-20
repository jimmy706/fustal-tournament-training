package com.axonactive.footballtournament.company;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.axonactive.footballtournament.member.Member;
import com.axonactive.footballtournament.member.player.Player;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Company {

    @NotNull String name;

    @NotNull String id;

    @NotNull List<Member> members;

    List<Player> companyTeam;

    public Company(String name, String id) {
        this.name = name;
        this.id = id;
        this.members = new ArrayList<>();
        this.companyTeam = new ArrayList<>();
    }
    
    public void addMember(Member newMember) {
        System.out.println("Adding new member: \n " + newMember);
        members.add((newMember));
    }

    public void addPlayer(Player player) {
        if(members.contains(player)) {
            companyTeam.add(player);
        }
        else {
            throw new IllegalArgumentException("Player must be working for company!");
        }
    }

}
