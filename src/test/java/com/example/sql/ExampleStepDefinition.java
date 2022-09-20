package com.example.sql;

import com.example.sql.Model.Person;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.sql.SQLOutput;

public class ExampleStepDefinition {

    @Autowired
    BasicWebInteraction clientObject;

    @When("the client calls /person$")
    public void the_client_issues_GET_person() throws Throwable {
        ResponseResults response = clientObject.executeGet("http://localhost:8080/person");
        //clientObject.executeGet("http://www.google.com");
        System.out.println("Testing step 1");
        System.out.println(response);
    }

    @Then("the client get a list from all person who is saved in the database")
    public void the_client_get_Person_list() throws Throwable {
        System.out.println("Alle Personen");
    }

    @Then("the client receives a person-list from database")
    public void the_client_receives_a_person_list_from_database() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("second step is working");
    }

    @When("the client makes calls \\/person\\/Id")
    public void the_client_makes_calls_person_id(DataTable dataTable) throws IOException {

        var personDetails = dataTable.asMaps();
        Long id;
        id = Long.valueOf(personDetails.get(0).get("person id"));
        ResponseResults response = clientObject.executeGet("http://localhost:8080/person/"+id+"");
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        System.out.println("Step 1");
        System.out.println(response);
    }

    @Then("the client receives a person with the same Id")
    public void the_client_receives_a_person_with_the_same_id() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("Step 2");
    }


    @When("the client makes a post to \\/person with the following parameters")
    public void the_client_makes_a_post_to_person_with_the_following_parameters(DataTable dataTable) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        var personDetails = dataTable.asMaps();
        Person person = new Person();

        person.setName(personDetails.get(0).get("person name"));
        person.setAlter(Integer.parseInt(personDetails.get(0).get("person alter")));
        person.setOrt(personDetails.get(0).get("person ort"));
        ResponseResults response = clientObject.executePost("http://localhost:8080/person", person);
        System.out.println(response);
        // throw new PendingException();
    }

    @Then("the client get a ok")
    public void the_client_get_a_ok() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("Ok");
    }

    @Then("the perosn get saved in the database")
    public void the_perosn_get_saved_in_the_database() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("Saved");
    }

    @When("the client makes a put to \\/person\\/id with following parameters")
    public void the_client_makes_a_put_to_person_id_with_following_parameters(io.cucumber.datatable.DataTable dataTable) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

        var personDetails = dataTable.asMaps();
        Person person = new Person();
        Long id;
        id = Long.valueOf(personDetails.get(0).get("person id"));

        person.setName(personDetails.get(0).get("person name"));
        person.setAlter(Integer.parseInt(personDetails.get(0).get("person alter")));
        person.setOrt(personDetails.get(0).get("person ort"));
        ResponseResults response = clientObject.executePut("http://localhost:8080/person/"+id+"", person);
        System.out.println(response);
    }

    @Then("the client gets a ok")
    public void the_client_gets_a_ok() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Ok");
    }

    @Then("the person with the same id get updated")
    public void the_person_with_the_same_id_get_updated() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Person is updated");
    }

    @When("the client makes a delete to \\/person\\/id")
    public void the_client_makes_a_delete_to_person_id(io.cucumber.datatable.DataTable dataTable) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        var persondetail = dataTable.asMaps();
        Long id = null;
        id = Long.valueOf(persondetail.get(0).get("person id"));
        ResponseResults response = clientObject.executeDelete("http://localhost:8080/person/"+id+"");
    }

    @Then("the client gets a Ok")
    public void the_client_gets_a_ok_delete() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Ok");
    }
    @Then("the person gets deleted")
    public void the_person_gets_deleted() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("is deleted");
    }
}
