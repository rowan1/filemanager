package com.stcassessment.filemanager.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Objects;

public class OneNotNullValidator implements ConstraintValidator<OneNotNull, Object> {
  private String[] fields;

  @Override
  public void initialize(final OneNotNull oneNotNull) {
    fields = oneNotNull.fields();
  }

  @Override
  public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
    final BeanWrapperImpl beanWrapper = new BeanWrapperImpl(obj);

    return Arrays.stream(fields).map(beanWrapper::getPropertyValue).filter(Objects::isNull).count()
            <= 1;
  }
}
