package com.hmtmcse.bismillah.controllers;

import com.hmtmcse.bismillah.domain.Course;
import com.hmtmcse.bismillah.repository.CourseRepository;
import com.hmtmcse.bismillah.service.CourseCustomService;
import com.hmtmcse.bismillah.service.EmCustomQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller()
@RequestMapping("/course-exp")
public class CourseExpController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseCustomService courseCustomService;

    @Autowired
    private EmCustomQuery emCustomQuery;

    @GetMapping(value = {"/form", "/form/{id}"})
    public String createUpdate() {
        return "course/form";
    }

    @PostMapping("/save")
    public String save() {
        Course course = new Course().name("Course").description("Description").credit(3.0);
        courseRepository.save(course);
        for (Integer i =1; i < 500; i++){
            course = new Course().name("Course " + i).description("Description  " + i).credit(3.0);
            courseRepository.save(course);
        }
        return "form";
    }

    @GetMapping("/list")
    @ResponseBody
    public Iterable<Course> readList() {
        return courseCustomService.getPaginationData("id");
    }

    @GetMapping("/listPagination")
    @ResponseBody
    public Iterable<Course> readPaginationList() {
        return courseCustomService.getWithPagination(1, 10, Sort.Direction.DESC, "id");
    }

    @GetMapping("/listQuery")
    @ResponseBody
    public Iterable<Course> readQueryList() {
        return (Iterable<Course>) emCustomQuery.getAllCourse();
    }

    @GetMapping("/copyTest")
    @ResponseBody
    public Course copyTest() {
        Course course = new Course().name("Bangla").credit(1.5);
        Course fromPost = new Course().description("This is bangla Description");
        BeanUtils.copyProperties(course, fromPost);
        return course;
    }

    @GetMapping("/details")
    public String readDetails() {
        return "readDetails";
    }

    @PostMapping("/update1/{id}")
    public String update1Way(@PathVariable("id") Long id, Course course) {

        // Validate if needed
        course.id(id);
        courseRepository.save(course);
        return "update";
    }

    @PostMapping("/update2/{id}")
    public String update2Way(@PathVariable("id") Long id, Course course) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isPresent()){
            Course updateCourse = courseOptional.get();
            updateCourse.credit(course.credit);
            updateCourse.name(course.name);
            updateCourse.description(course.description);
            courseRepository.save(updateCourse);
        }
        return "update";
    }

    @PostMapping("/delete")
    public String delete() {
        return "delete";
    }

}
