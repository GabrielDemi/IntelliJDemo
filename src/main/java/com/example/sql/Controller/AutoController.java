package com.example.sql.Controller;


import com.example.sql.Model.Auto;
import com.example.sql.Repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AutoController {

    @Autowired
    AutoRepository repos;

    @GetMapping("/auto")
    public List getAuto(){
        List list = repos.findAll();
        return list;
    }

    @GetMapping("/auto/{id}")
    public Optional<Auto> getAutoById(@PathVariable Long id){
        Optional<Auto> person = repos.findById(id);
        return person;
    }

    @PostMapping("auto")
    public ResponseEntity save(@RequestBody Auto auto){
        repos.save(auto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("auto/{id}")
    public ResponseEntity<Void> update(@RequestBody Auto auto,@PathVariable Long id){
        repos.update(auto.getMarke(),auto.getModell(),auto.getBaujahr(),id);
    return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/auto")
    public String deleteAll(){
        repos.deleteAll();
        return "Alles gelöscht";
    }

    @DeleteMapping("/auto/{id}")
    public String deleteAuto(@PathVariable Long id){
        repos.deleteById(id);
        return "Würde gelöscht";
    }
}
