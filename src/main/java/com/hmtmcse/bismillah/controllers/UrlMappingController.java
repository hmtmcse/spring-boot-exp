package com.hmtmcse.bismillah.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/url-mapping")
public class UrlMappingController {


    @RequestMapping("{id:[0-9]+}")
    @ResponseBody
    public String isIdInteger(@PathVariable("id") Integer id){
        return "The ID is Integer " + id;
    }

    @RequestMapping("{id:[a-z]+}")
    @ResponseBody
    public String isIdString(@PathVariable("id") String id){
        return "The ID is String " + id;
    }

}
