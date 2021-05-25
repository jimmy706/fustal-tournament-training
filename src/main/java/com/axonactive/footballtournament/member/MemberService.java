package com.axonactive.footballtournament.member;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

public class MemberService {
    @PersistenceContext
    private EntityManager memberManager;

    public void add(Member newMember) {
        validateMember(newMember);
        memberManager.persist(newMember);
    }

    public Member update(Integer memberId, Member updatedMember) {
        validateMember(updatedMember);    
        Member persistenceMember = memberManager.find(Member.class, memberId);
        if(persistenceMember == null) {
            return null;
        }
        return memberManager.merge(persistenceMember);
    }

    public List<Member> getAll() {
        TypedQuery<Member> query = memberManager.createNamedQuery(Member.GET_ALL_QUERY, Member.class);
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

    public Member getById(Integer id) {
        return memberManager.find(Member.class, id);
    }

    public List<Member> getMemberFromCompany(String companyId) {
        TypedQuery<Member> query = memberManager.createNamedQuery(Member.GET_BY_COMPANY, Member.class);

        return query.getResultList();
    }

    public boolean delete(Integer id) {
        Member member = memberManager.find(Member.class, id);
        if(member != null) {
            memberManager.remove(member);
            return true;
        }
        else {
            return false;
        }
    }

    
}
