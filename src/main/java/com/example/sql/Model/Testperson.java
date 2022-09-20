package com.example.sql.Model;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Testperson {

    public static List<Person> generator(){
        return Arrays.asList(
                new Person("Günter",20,"Köln"),
                new Person("Max",22,"Köln"),
                new Person("Mike",10,"Bonn")
        );
    }
}
