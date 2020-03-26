package com.hmtmcse.bismillah.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping("/check/{id:^(?!asset).*}/**")
    @ResponseBody
    public String checkIsNotRest(@PathVariable("id") String id, HttpServletRequest request){
        return "Check then not Rest then Anything  -- " + id + " --- " + request.getRequestURI();
    }

    @RequestMapping("/check/rest/**")
    @ResponseBody
    public String checkRestAfterAnyThing(){
        return "Check then Rest then Anything ";
    }

}
