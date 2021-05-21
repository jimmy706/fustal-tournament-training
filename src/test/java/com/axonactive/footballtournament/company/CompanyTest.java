package com.axonactive.footballtournament.company;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import com.axonactive.footballtournament.member.Gender;
import com.axonactive.footballtournament.member.Member;
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
        assertNotNull(company.getCompanyTeam(),"Each company should has a team");
    }

    @Test
    public void testAddMember() {
        Member newMember = new Member("John", "Doe", 21, Gender.MALE);

        List<Member> membersExpected = Arrays.asList(newMember);
        company.addMember(newMember);
        List<Member> companyMembers = company.getMembers();

        assertEquals(companyMembers, membersExpected);        
    }

    @Test
    void when_AddPlayerNotAMember_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, ()-> {
            company.addPlayer(new Player("Pixy", "Dev", 23, Gender.FEMALE, "12"));
        });
    }
}
