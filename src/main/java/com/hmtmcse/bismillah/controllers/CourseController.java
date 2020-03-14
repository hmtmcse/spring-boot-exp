package com.hmtmcse.bismillah.controllers;

import com.hmtmcse.bismillah.domain.Course;
import com.hmtmcse.bismillah.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;


@Controller()
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(value = {"/form"})
    public String form(Model model) {
        model.addAttribute("title", "Create");
        model.addAttribute("formAction", "create");
        model.addAttribute("course", new Course());
        return "course/form";
    }

    @PostMapping("/create")
    public String create(@Valid Course course, BindingResult bindingResult, Model model) {
        model.addAttribute("title", "Create");
        model.addAttribute("formAction", "create");
        if (bindingResult.hasErrors()) {
            return "course/form";
        }
        courseRepository.save(course);
        return "redirect:/course/readList";
    }

    @GetMapping(value = {"/form/{id}"})
    public String edit(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("title", "Update");
        model.addAttribute("formAction", "update");
        if (id == null) {
            return "redirect:/course/readList";
        }
        model.addAttribute("course", courseRepository.findById(id));
        return "course/form";
    }

    @PostMapping("/update")
    public String update(@Valid Course course, BindingResult bindingResult, Model model) {
        model.addAttribute("title", "Update");
        model.addAttribute("formAction", "update");
        if (bindingResult.hasErrors()) {
            return "course/form";
        }
        courseRepository.save(course);
        return "redirect:/course/readList";
    }

    @GetMapping(value = {"/readList", "/"})
    public String readList(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return "course/readList";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        Optional<Course> course = courseRepository.findById(id);
        course.ifPresent(value -> courseRepository.delete(value));
        return "redirect:/course/readList";
    }

}
