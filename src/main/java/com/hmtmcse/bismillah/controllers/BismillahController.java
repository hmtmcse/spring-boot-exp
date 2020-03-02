package com.hmtmcse.bismillah.controllers;


import com.hmtmcse.bismillah.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Controller
public class BismillahController {

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "Bismillah";
    }

    @RequestMapping("/html")
    public String htmlView(){
        return "htmlView";
    }


    @RequestMapping("/validation")
    @ResponseBody
    public String validation(){

        User user = new User();
        user.setWorking(true);
        user.setAboutMe("Its all about me!");
        user.setAge(50);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> violation : violations) {
            System.out.println(violation.getMessage() + " ");
        }

        return "Validation Testing";
    }

}
