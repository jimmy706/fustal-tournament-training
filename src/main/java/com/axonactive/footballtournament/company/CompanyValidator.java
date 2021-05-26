package com.axonactive.footballtournament.company;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CompanyValidator implements ConstraintValidator<ValidCompany, Company> {

    @Override
    public boolean isValid(Company company, ConstraintValidatorContext context) {

        return company.getName() != null && 
        !company.getName().isEmpty() &&
        company.getId() != null &&
        !company.getId().isEmpty();
    }
    
}
