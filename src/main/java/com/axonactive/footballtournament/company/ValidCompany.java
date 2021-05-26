package com.axonactive.footballtournament.company;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.CONSTRUCTOR, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CompanyValidator.class)
public @interface ValidCompany {
    String message() default "Company is not valid";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
