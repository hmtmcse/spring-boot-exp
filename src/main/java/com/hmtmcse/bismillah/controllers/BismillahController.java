package com.hmtmcse.bismillah.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
