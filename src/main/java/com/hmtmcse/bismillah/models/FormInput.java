package com.hmtmcse.bismillah.models;

import lombok.Builder;
import javax.validation.constraints.*;


@Builder
public class FormInput {


    @NotNull(message = "Please enter your name.")
    private String name;

    @AssertTrue(message = "Please accept agreement for continue.")
    private Boolean isAcceptAgreement = false;

    @Size(min = 5, max = 200, message = "Please write yourself between 5 and 200 characters.")
    private String aboutMe;

    @Min(value = 18, message = "Age should not be less than 18.")
    @Max(value = 150, message = "Age should not be greater than 150.")
    private Integer age;


    @Email(message = "Please enter valid email.")
    private String email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsAcceptAgreement() {
        return isAcceptAgreement;
    }


    public void setIsAcceptAgreement(Boolean acceptAgreement) {
        isAcceptAgreement = acceptAgreement;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
