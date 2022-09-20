package com.example.sql.Repository;

import com.example.sql.Model.Haus;
import com.example.sql.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person, Long> {

  //  @Query(value = "Insert into person values(:name, :alter, :ort, :id)", nativeQuery = true)
   // Person saveWithhaus(@Param("name") String name, @Param("alter") int alter, @Param("ort") String ort,@Param("id"));

 // @Query(value = "Select * From mensch mensch Where mensch.name = :name", nativeQuery = true)
  Person findByName(@Param("name") String name);
@Modifying
    @Query(value = "Update person set name = :name, alter = :alter, ort = :ort where person_id = :id", nativeQuery = true)
    void updateById(@Param("name") String name, @Param("alter") int alter, @Param("ort") String ort, @Param("id") long id);

    @Query(value = "Select * from person inner join haus on haus.haus_id = person.haus_id", nativeQuery = true)
    Person findPersonWithHaus(@Param("id")long id);

    @Query(value = "Select * from person", nativeQuery = true)
    List<Person> findPerson();

    @Query(value = "Select * from auto_besitzen",nativeQuery = true)
    List findBesitzer();

    List<Person> findAllById(int i);
}