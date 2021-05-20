package com.axonactive.footballtournament.team;

import java.util.ArrayList;
import java.util.List;

import com.axonactive.footballtournament.company.Company;
import com.axonactive.footballtournament.member.Member;
import com.axonactive.footballtournament.member.player.Player;

import lombok.Getter;

public class TeamControl {
    @Getter
    private List<Team> companyTeams;

    private List<Company> companies;

    public TeamControl(List<Company> companies) {
        this.companies = companies;
        companyTeams = new ArrayList<>();
        for(int i = 0; i < companies.size(); i++) {
            companyTeams.add(new Team(companies.get(i).getName(), companies.get(i).getId()));
        }
    }

    public void addNewPlayerForTeam(String companyId, Player newPlayer) {
        for(int i = 0; i < companies.size(); i++) {
            Company company = companies.get(i);
            if(company.getId().equals(companyId) && company.getMembers().contains(newPlayer) ){
                Team team = companyTeams.get(i);
                team.addPlayer(newPlayer);
                return;
            }
        }
    }

     public void generatePlayersFromCompanyMembers(String companyId) {
        for(int i = 0; i < companies.size(); i++) {
            Company company = companies.get(i);
            if(company.getId().equals(companyId)){
                Team team = companyTeams.get(i);
                for(Member member : company.getMembers()) {
                    team.addPlayer((Player)member);
                }
            }
        }
    }

    public void listTeams() {
        for(Team team : companyTeams) {
            System.out.println(team);
        }
    }
}
