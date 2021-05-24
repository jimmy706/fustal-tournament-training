package com.axonactive.footballtournament.company;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


import com.axonactive.footballtournament.member.Gender;
import com.axonactive.footballtournament.member.player.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompanyTest {
    Company company;

    @BeforeEach
    void createCompany() {
        company = new Company("Axon Active", "AAVN");
    }

    @Test
    public void shouldCompanyTeamExist() {
        assertNotNull(company.getTeam(),"Each company should has a team");
    }

    @Test
    void when_AddPlayerNotAMember_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, ()-> {
            company.addPlayer(new Player("Pixy", "Dev", 23, "AAVN123", Gender.FEMALE, "12"));
        });
    }
}
