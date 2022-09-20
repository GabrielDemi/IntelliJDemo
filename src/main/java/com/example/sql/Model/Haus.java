package com.example.sql.Model;


import javax.persistence.*;
import java.util.List;

@Table(name = "haus")
@Entity

public class Haus {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "test_sequence")
    @Column(name = "haus_id")
    Long id;
    private String adresse;
    private int haus_nr;
    private int postleit;


    public Haus() {
    }

    public Haus(String adresse, int haus_nr, int postleit) {
        this.adresse = adresse;
        this.haus_nr = haus_nr;
        this.postleit = postleit;

    }

    @OneToMany(mappedBy = "haus")
    private List<Person> person;


    public String getAdresse() {
        return adresse;
    }

    public int getHaus_nr() {
        return haus_nr;
    }

    public int getPostleit() {
        return postleit;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setHaus_nr(int haus_nr) {
        this.haus_nr = haus_nr;
    }

    public void setPostleit(int postleit) {
        this.postleit = postleit;
    }
}

