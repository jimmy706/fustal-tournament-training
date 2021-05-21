package com.axonactive.footballtournament.company;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.ejb.ObjectNotFoundException;

import com.axonactive.footballtournament.member.Gender;
import com.axonactive.footballtournament.member.Member;
import com.axonactive.footballtournament.member.player.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompanyControlTest {
    CompanyControl companyControl;

    @BeforeEach
    void createInstance() {
        companyControl = new CompanyControl();

    }


    @Test
    void when_AddNewCompany_CompanyListIncrease() {
        assertNotNull(companyControl.getCompanies());

        companyControl.addCompany(new Company("Axon Active", "AAVN"));

        assertEquals(1, companyControl.getCompanies().size());
    }

    @Test
    void when_PlayerIsCompanyMember_AddToCompanyPlayersTeam() {
        companyControl.addCompany(new Company("Axon Active", "AAVN"));

        Member member = new Member("John", "Wick", 31, Gender.MALE);

        try {
            companyControl.addNewMember("AAVN", member);
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        }

        companyControl.addNewPlayer(new Player(member, "09"), "AAVN");

        Company aavn = companyControl.getCompanies().get(0);
        
        assertEquals(1, aavn.getMembers().size());
        assertEquals(1, aavn.getCompanyTeam().size());
    }

    @Test
    void when_PlayerIsNotCompanyMember_ThrowIllegalArgument() {
        companyControl.addCompany(new Company("Axon Active", "AAVN"));

        assertThrows(IllegalArgumentException.class, ()-> {
            companyControl.addNewPlayer(new Player(new Member("Hello", "World", 69, Gender.FEMALE), "09"), "AAVN");
        });
    }

}
