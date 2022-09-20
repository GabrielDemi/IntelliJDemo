package com.example.sql;

import com.example.sql.Model.Person;
import com.example.sql.Repository.PersonRepository;
import io.cucumber.java.en.When;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
public class PersonController {

    PersonRepository respo;

    @GetMapping("/person")
    public List getPerson(){
        List list = respo.findAll();
            return list;
    }


}
