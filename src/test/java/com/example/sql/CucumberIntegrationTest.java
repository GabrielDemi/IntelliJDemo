package com.example.sql;

import com.example.sql.Model.Person;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources")
public class CucumberIntegrationTest {

}