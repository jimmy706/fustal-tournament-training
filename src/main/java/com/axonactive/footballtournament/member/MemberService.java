package com.axonactive.footballtournament.member;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
    }

    public Player getById(Integer id) {
        return memberManager.find(Player.class, id);
    }

    public List<Member> getMemberFromCompany(String companyId) {
        TypedQuery<Member> query = memberManager.createNamedQuery(Player.GET_ALL_QUERY, Member.class);
        List<Member> members = query.getResultList();
        

        return members.stream().filter(player -> player._isWorkForCompany(companyId)).collect(Collectors.toList());
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
