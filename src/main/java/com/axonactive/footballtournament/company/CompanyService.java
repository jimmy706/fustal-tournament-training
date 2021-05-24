package com.axonactive.footballtournament.company;

import java.util.ArrayList;
import java.util.List;


import com.axonactive.footballtournament.member.player.Player;

import lombok.Getter;

public class CompanyService {
    @Getter
    private List<Company> companies;

    public CompanyService() {
        this.companies = new ArrayList<>();
    }

    public void add(Company newCompany) {
        companies.add(newCompany);
    }

    // public void addNewMember(String companyId, Member newMember) throws ObjectNotFoundException {
    //     Company pickedCompany = companies.stream()
    //                                 .filter(company -> company.getId().equals(companyId))
    //                                 .findAny()
    //                                 .orElse(null);
    //     if(pickedCompany != null) {
    //         pickedCompany.addMember(newMember);
    //     }
    //     else {
    //         throw new ObjectNotFoundException("Company not found");
    //     }
    // }


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
