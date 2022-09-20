package com.example.sql.Controller;

import com.example.sql.Model.Haus;
import com.example.sql.Model.Person;
import com.example.sql.Repository.HausRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HausController {

    @Autowired
    HausRepository respo;

    @GetMapping("/haus")
    public List getHaus() {
        try {
            List list = (List) respo.findAll();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/haus/{id}")
    public Optional<Haus> getHausById(@PathVariable Long id) {
        try {
            Optional<Haus> haus = respo.findById(id);
            return haus;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/haus")
    public ResponseEntity save(@RequestBody Haus haus){
        respo.save(haus);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/haus/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Haus haus) {
        try {
            respo.updateHausById(haus.getAdresse(),haus.getHaus_nr(),haus.getPostleit(),id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/haus")
    public String deleteAll() {
        respo.deleteAll();
        return ("Alles gelöscht");
    }

    @DeleteMapping("/haus/{id}")
    public String deletById(@PathVariable Long id) {
        respo.deleteById(id);
        return "Die Person wurde gelöscht";
    }


}
