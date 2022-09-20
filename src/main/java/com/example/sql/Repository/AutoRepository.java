package com.example.sql.Repository;

import com.example.sql.Model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AutoRepository extends JpaRepository<Auto,Long> {


    @Modifying
    @Query(value = "Update auto set marke = :marke, modell = :modell, baujahr = :baujahr where auto_id = :auto_id", nativeQuery = true)
    void update(@Param("marke") String marke, @Param("modell") String modell, @Param("baujahr") int baujahr, @Param("auto_id") long id);
}
