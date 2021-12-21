package com.springdemo.validation_rules;

import javax.validation.constraints.*;

public class Customer {
    private String firstName;
    @NotNull(message = "is required")
    @Size(min=1,message = "is required")
    private String lastName;
    @NotNull(message = "is required")
    @Min(value=0,message="must be greater than or equal to zero")
    @Max(value=10,message = "must be less than or equal to 10")
    private Integer freePass;
    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message ="Only 5 chars/digits")
    private String postalCode;
    @CourseCode(value="TOPS",message = "must start with TOPS")
    private String courseCode;
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePass() {
        return freePass;
    }

    public void setFreePass(Integer freePass) {
        this.freePass = freePass;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
