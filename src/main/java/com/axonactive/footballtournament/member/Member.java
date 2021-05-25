package com.axonactive.footballtournament.member;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQueries({
    @NamedQuery(name=Member.GET_ALL_QUERY, query = "SELECT m FROM Member m"),
    @NamedQuery(name=Member.GET_BY_COMPANY, query = "SELECT m FROM Member m WHERE m.socialInsuranceId = :companyId")
})
public class Member {    
    public static final String QUALIFIER = "com.axonactive.footballtournament.member.";

    public static final String GET_ALL_QUERY = QUALIFIER + "getAll";

    public static final String GET_BY_COMPANY = QUALIFIER + "getByCompany";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name="first_name")
    private String firstName;

    @Column(nullable = false, name="last_name")
    String lastName;

    @Column(name="age")
    int age;

    @Column(name = "social_insurance_id")
    private String socialInsuranceId;    

    @Convert(converter = GenderPersistenceConverter.class)
    private Gender gender;

    public Member(String firstName, String lastName, int age, String socialInsuranceId, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.socialInsuranceId = socialInsuranceId;
        this.gender = gender;
    }

    public Member(String firstName, String lastName, int age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public boolean isValid() {
        return getFullName().length() > 0 && age > 18 && age < 60;
    }
    

}
