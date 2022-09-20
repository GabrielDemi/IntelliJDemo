package com.example.sql.Controller;



import com.example.sql.Model.Person;
import com.example.sql.Model.Testperson;
import com.example.sql.Repository.PersonRepository;
import net.sf.jasperreports.data.http.HttpDataLocation;
import net.sf.jasperreports.data.http.HttpLocationParameter;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.Principal;
import java.sql.ClientInfoStatus;
import java.util.*;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;


@RestController
public class PersonController {

    @Autowired
    PersonRepository respo;

    @GetMapping("/")
    public String index() {
        return "external";
    }

    @GetMapping("/person")
    public List getPerson() {
        List list = respo.findAll();
        return list;
    }

    @GetMapping("/person/{id}")
    public Optional<Person> getPersonById(@PathVariable Long id) {
        try {
            Optional<Person> person = respo.findById(id);
            return person;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/person/ManyToOne")
    public ResponseEntity<List<Person>> getPersonManytoOne() {
        List<Person> person = respo.findPerson();
        return ResponseEntity.ok(person);
    }

    @GetMapping("/person/report")
    public ResponseEntity<byte[]> getPersonReport() throws JRException, FileNotFoundException{
        try {
            //List<Person> list =
            JRBeanCollectionDataSource collect = new JRBeanCollectionDataSource(respo.findAll());
            Map<String, Object> valuesMap = new HashMap<>();
            //JRMapArrayDataSource source = new JRMapArrayDataSource();

            JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/Person2.jrxml"));

            Map<String, Object> Params = new HashMap<String, Object>();

            JasperPrint Report = JasperFillManager.fillReport(compileReport,Params, collect);


            HttpHeaders headers = new HttpHeaders();

            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "Person.pdf");

            return new ResponseEntity<byte[]>(JasperExportManager.exportReportToPdf(Report), headers, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

        @GetMapping("/person/ManyToMany")
    public ResponseEntity<List> getAutoBesitzer(){
        List<Person> person = respo.findBesitzer();
        return ResponseEntity.ok(person);
    }

    @PostMapping("/person")
    public ResponseEntity<Person> save(@RequestBody Person person, UriComponentsBuilder builder) {

        //respo.save(person);
        if (respo.findByName(person.getName()) != null) {
            return new ResponseEntity("Die Person gibt es schon", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            respo.save(person);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/person/{id}").buildAndExpand(person.getId()).toUri());
            return new ResponseEntity<Person>(person,headers,HttpStatus.OK);
        }
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Person person1) {
        try {
          respo.updateById(person1.getName(),person1.getAlter(),person1.getOrt(),id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/person")
    public String deleteAll() {
        respo.deleteAll();
        return ("Alles gelöscht");
    }  

    @DeleteMapping("/person/{id}")
    public String deletById(@PathVariable Long id) {
        respo.deleteById(id);
        return "Die Person wurde gelöscht";
    }
}