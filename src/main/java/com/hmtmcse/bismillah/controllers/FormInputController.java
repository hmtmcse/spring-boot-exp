package com.hmtmcse.bismillah.controllers;


import com.hmtmcse.bismillah.models.FormInput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class FormInputController {


    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("formInput", FormInput.builder().build());
        return "form";
    }


    @PostMapping("/formValidation")
    public String formValidation(@Valid FormInput formInput, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        return "formView";
    }

    @GetMapping("/formValidation")
    public String formValidation() {
        return "redirect:/form";
    }
}
