package com.hmtmcse.bismillah.controllers;

import com.hmtmcse.bismillah.domain.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller()
@RequestMapping("/course")
public class CourseController {


    @GetMapping(value = {"/form"})
    public String form(Model model) {
        model.addAttribute("title", "Create");
        model.addAttribute("formAction", "create");
        model.addAttribute("course", new Course());
        return "course/form";
    }

    @GetMapping(value = {"/form/{id}"})
    public String form(@PathVariable(name = "id") Long id, Model model) {
        String title = "Create";
        String formAction = "create";
        Course course = new Course();
        if (id != null){
            title = "Update";
            formAction = "update";
        }
        model.addAttribute("title", title);
        model.addAttribute("formAction", formAction);
        model.addAttribute("course", course);
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
