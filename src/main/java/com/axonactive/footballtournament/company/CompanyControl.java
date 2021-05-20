package com.axonactive.footballtournament.company;

import java.util.ArrayList;
import java.util.List;

import com.axonactive.footballtournament.member.Member;

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

    public void addNewMember(String companyId, Member newMember) {
        for(Company company : companies) {
            if(company.getId().equals(companyId)) {
                company.addMember(newMember);
            }
        }
    }

    public boolean isPlayerWorkingForCompny(Member member, String companyId) {
        for(Company company : companies) {
            if(company.getId().equals(companyId)) {
                return company.getMembers().contains(member);
            }
        }
        return false;
    }

    public void listCompanies() {
        for(Company company : companies){
            System.out.println(company);
        }
    }
}
