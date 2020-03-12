package com.hmtmcse.bismillah.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/course")
public class CourseController {

    @GetMapping(value = {"/form", "/form/{id}"})
    public String createUpdate() {
        return "course/form";
    }

    @PostMapping("/save")
    public String save() {
        return "form";
    }

    @GetMapping("/list")
    public String readList() {
        return "readList";
    }

    @GetMapping("/details")
    public String readDetails() {
        return "readDetails";
    }

    @PostMapping("/update")
    public String update() {
        return "update";
    }

    @PostMapping("/delete")
    public String delete() {
        return "delete";
    }

}
