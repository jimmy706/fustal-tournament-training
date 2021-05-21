package com.axonactive.footballtournament.company;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.ObjectNotFoundException;

import com.axonactive.footballtournament.member.Member;
import com.axonactive.footballtournament.member.player.Player;

import lombok.Getter;

public class CompanyControl {
    @Getter
    private List<Company> companies;

    public CompanyControl() {
        this.companies = new ArrayList<>();
    }

    public void addCompany(Company newCompany) {
        companies.add(newCompany);
    }

    public void addNewMember(String companyId, Member newMember) throws ObjectNotFoundException {
        Company pickedCompany = companies.stream()
                                    .filter(company -> company.getId().equals(companyId))
                                    .findAny()
                                    .orElse(null);
        if(pickedCompany != null) {
            pickedCompany.addMember(newMember);
        }
        else {
            throw new ObjectNotFoundException("Company not found");
        }
    }


    public void addNewPlayer(Player newPlayer, String companyId) {
        Company pickedCompany = companies.stream()
                                    .filter(company -> company.getId().equals(companyId))
                                    .findAny()
                                    .orElse(null);
        
        if(pickedCompany != null) {
            pickedCompany.addPlayer(newPlayer);
        }
    }
    
}
