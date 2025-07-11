package com.bank.bank.Aspect;

import com.bank.bank.validation.UniqueBankCodeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueBankCodeValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueBankCode {
    String message() default "Bank code already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}