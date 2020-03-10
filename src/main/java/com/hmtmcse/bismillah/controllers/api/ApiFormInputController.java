package com.hmtmcse.bismillah.controllers.api;


import com.hmtmcse.bismillah.models.FormInput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        List<FormInput> list = new ArrayList<>();
        list.add(FormInput.builder().name("Name 1").age(20).aboutMe("About Me 1").email("email1@email.com").isAcceptAgreement(true).build());
        list.add(FormInput.builder().name("Name 2").age(50).aboutMe("About Me 2").email("email2@email.com").isAcceptAgreement(true).build());
        list.add(FormInput.builder().name("Name 3").age(18).aboutMe("About Me 3").email("email3@email.com").isAcceptAgreement(true).build());
        list.add(FormInput.builder().name("Name 4").age(28).aboutMe("About Me 4").email("email4@email.com").isAcceptAgreement(true).build());
        list.add(FormInput.builder().name("Name 5").age(30).aboutMe("About Me 5").email("email5@email.com").isAcceptAgreement(false).build());
        list.add(FormInput.builder().name("Name 6").age(40).aboutMe("About Me 6").email("email6@email.com").isAcceptAgreement(false).build());
        return ResponseEntity.ok(list);
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
