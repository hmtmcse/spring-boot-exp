package com.hmtmcse.bismillah.controllers.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/form")
public class ApiFormInputController {


    @PostMapping("/create")
    public ResponseEntity<?> create(){
        return null;
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> readDetails(){
        return null;
    }

    @GetMapping("/list")
    public ResponseEntity<?> readList(){
        return null;
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(){
        return null;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(){
        return null;
    }

}
