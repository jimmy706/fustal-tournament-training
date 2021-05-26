package com.axonactive.footballtournament.member;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.axonactive.footballtournament.member.player.Player;

public class MemberService {
    @PersistenceContext
    private EntityManager memberManager;

    public void add(Player newMember) {
        validateMember(newMember);
        memberManager.persist(newMember);
    }

    public Player update(Integer memberId, Player updatedMember) {
        validateMember(updatedMember);    
        Player persistenceMember = memberManager.find(Player.class, memberId);
        if(persistenceMember == null) {
            return null;
        }

        persistenceMember.setAge(updatedMember.getAge());
        persistenceMember.setFirstName(updatedMember.getFirstName());
        persistenceMember.setLastName(updatedMember.getLastName());
        persistenceMember.setGender(updatedMember.getGender() != null ? updatedMember.getGender() : Gender.UNKNOW);

        return memberManager.merge(persistenceMember);
    }

    public List<Member> getAll() {
        TypedQuery<Member> query = memberManager.createNamedQuery(Player.GET_ALL_QUERY, Member.class);
        return query.getResultList();
    }

    private void validateMember(Member member) {
        if(Objects.isNull(member)) {
            throw new IllegalArgumentException("Member missing");
        }
        else if(!member.isValid()) {
            throw new ValidationException("Some field is missing or wrong");
        }
    }

    public Player getById(Integer id) {
        return memberManager.find(Player.class, id);
    }

    public List<Player> getMemberFromCompany(String companyId) {
        TypedQuery<Player> query = memberManager.createNamedQuery(Player.GET_BY_COMPANY, Player.class);

        return query.getResultList();
    }

    public boolean delete(Integer id) {
        Player member = memberManager.find(Player.class, id);
        if(member != null) {
            memberManager.remove(member);
            return true;
        }
        else {
            return false;
        }
    }

    
}
