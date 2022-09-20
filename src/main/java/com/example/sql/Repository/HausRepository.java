package com.example.sql.Repository;

import com.example.sql.Model.Haus;
import com.example.sql.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface HausRepository extends JpaRepository<Haus, Long> {

    @Modifying
    @Query(value = "Update haus set adresse = :adresse, haus_nr = :haus_nr, postleit = :postleit where haus_id = :haus_id", nativeQuery = true)
    void updateHausById(@Param("adresse") String adresse, @Param("haus_nr") int haus_nr, @Param("postleit") int postleit, @Param("haus_id") long id);

}
