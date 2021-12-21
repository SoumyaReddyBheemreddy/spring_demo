package com.springdemo.validation_rules;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {
    private  String coursePrefix;
    @Override
    public void initialize(CourseCode constraintAnnotation) {
      coursePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result ;
        if(theCode != null)
            result = theCode.startsWith(coursePrefix);
        else
            return true;
        return result;
    }
}
