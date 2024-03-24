package com.stcassessment.filemanager.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Constraint(validatedBy = {OneNotNullValidator.class})
public @interface OneNotNull {
  String message() default "{validation.constraints.oneNotNull.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  /** Fields to validate against null. */
  String[] fields() default {};
}
