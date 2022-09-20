package com.example.sql.Model;

import io.cucumber.datatable.DataTable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "person")
@Entity
public class Person {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "test_sequence")
    @Column(name = "person_id")
    private Long id;
    private String name;
    private int alter;
    private String ort;


    public Person() {
    }

    @ManyToOne
    @JoinColumn(name = "Haus_id")
    private Haus haus;

    @ManyToMany
    Set<Auto> besitzt;

    @ManyToMany
    @JoinTable(
            name = "auto_besitzen",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "auto_id"))
    Set<Auto> besitzen;


    public Person(String name, int alter, String ort) {
        this.name = name;
        this.alter = alter;
        this.ort = ort;
    }


    public String getName() {
        return name;
    }

    public int getAlter() {
        return alter;
    }

    public String getOrt() {
        return ort;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public Haus getHaus() {
        return haus;
    }

    public void setHaus(Haus haus) {
        this.haus = haus;
    }

    public Long getId() {
        return id;
    }

    /*   public void setClass(String name, int alter, String ort) {
        this.name = name;
        this.alter = alter;
        this.ort = ort;
    }*/

    public  void setClass(DataTable personDetails){
        this.name = name;
        this.alter = alter;
        this.ort = ort;
    }

}
