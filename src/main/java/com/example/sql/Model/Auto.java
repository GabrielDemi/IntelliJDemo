package com.example.sql.Model;

import javax.persistence.*;
import java.util.Set;

@Table(name = "auto")
@Entity
public class Auto {



        @Id
        @GeneratedValue(
                strategy = GenerationType.IDENTITY)
        @Column(name = "auto_id")
        Long id;
        private String Marke;
        private String Modell;
        private int Baujahr;



    public Auto(String marke, String modell, int baujahr) {
        this.Marke = marke;
        this.Modell = modell;
        this.Baujahr = baujahr;
    }

    public Auto(){
    }

    @ManyToMany(mappedBy = "besitzt")
    Set<Person> besitzen;

    public String getMarke() {
        return Marke;
    }

    public void setMarke(String marke) {
        this.Marke = marke;
    }

    public String getModell() {
        return Modell;
    }

    public void setModell(String modell) {
        this.Modell = modell;
    }

    public int getBaujahr() {
        return Baujahr;
    }

    public void setBaujahr(int baujahr) {
        this.Baujahr = baujahr;
    }
}