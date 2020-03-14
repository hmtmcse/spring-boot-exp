package com.hmtmcse.bismillah.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller()
@RequestMapping("/course")
public class CourseController {


    @GetMapping(value = {"/form/{id}", "/form"})
    public String form(@PathVariable(required = false, name = "id") Long id, Model model) {
        String title = "Create";
        if (id != null){
            title = "Update";
        }
        model.addAttribute("title", title);
        return "course/form";
    }

    @PostMapping("/create")
    public String create(){
        return "redirect:/form";
    }

    @GetMapping("/readDetails")
    public String readDetails(){
        return "redirect:/form";
    }

    @GetMapping("/readList")
    public String readList(){
        return "redirect:/form";
    }

    @PostMapping("/update")
    public String update(){
        return "redirect:/form";
    }

    @GetMapping("/delete")
    public String delete(){
        return "redirect:/form";
    }

}
