package com.hmtmcse.bismillah.models;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;



@Accessors(fluent = true)
@Data
public class FormInput {


    @NotNull(message = "Please enter your name.")
    public String name;

    @AssertTrue(message = "Please accept agreement for continue.")
    public Boolean isAcceptAgreement = false;

    @Size(min = 5, max = 200, message = "Please write yourself between 5 and 200 characters.")
    public String aboutMe;

    @Min(value = 18, message = "Age should not be less than 18.")
    @Max(value = 150, message = "Age should not be greater than 150.")
    public Integer age;


    @Email(message = "Please enter valid email.")
    public String email;

}
