package com.axonactive.footballtournament.member;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberTest {
    Member member;

    @BeforeEach
    void createMember() {
        member = new Member("Fairy", "Winx", 21, Gender.FEMALE);
    }

    @Test
    void testCompareOfMemberInstances() {
        Member expectedMember = new Member("Fairy", "Winx", 21, Gender.FEMALE);
        assertEquals(expectedMember, member);
    }
}
