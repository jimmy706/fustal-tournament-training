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

public class CompanyServiceTest {
    CompanyService companyControl;

    @BeforeEach
    void createInstance() {
        companyControl = new CompanyService();

    }


    @Test
    void when_AddNewCompany_CompanyListIncrease() {
        assertNotNull(companyControl.getCompanies());

        companyControl.add(new Company("Axon Active", "AAVN"));

        assertEquals(1, companyControl.getCompanies().size());
    }

    @Test
    void when_PlayerIsNotCompanyMember_ThrowIllegalArgument() {
        companyControl.add(new Company("Axon Active", "AAVN"));

        assertThrows(IllegalArgumentException.class, ()-> {
            companyControl.addNewPlayer(new Player(new Member("Hello", "World", 69, Gender.FEMALE), "09"), "AAVN");
        });
    }

}
