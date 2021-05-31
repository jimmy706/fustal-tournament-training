package com.axonactive.footballtournament.member;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
public class Member {    
   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name="first_name")
    @NotNull(message = MemberMessage.FIRST_NAME_REQUIRED)
    private String firstName;

    @Column(nullable = false, name="last_name")
    @NotNull(message = MemberMessage.LAST_NAME_REQUIRED)
    String lastName;

    @Column(name="age",nullable = false)
    @NotNull(message = MemberMessage.AGE_REQUIRED)
    @Min(value = 18, message = MemberMessage.AGE_SCOPE)
    @Max(value = 60, message = MemberMessage.AGE_SCOPE)
    int age;

    @Column(name = "social_insurance_id", unique = true)
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

    public boolean _isWorkForCompany(String companyId) {
        return socialInsuranceId.split("_")[0].equals(companyId);
    }
}
