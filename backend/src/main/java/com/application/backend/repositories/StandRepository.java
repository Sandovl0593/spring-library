package com.application.backend.repositories;

import com.application.backend.models.StandModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StandRepository extends CrudRepository<StandModel, Integer> {

    @Query("SELECT s FROM StandModel s WHERE s.owner = ?1")
    List<StandModel> findByUser(String userdni);

    @Query("SELECT s.id FROM StandModel s WHERE s.book_id = ?1 AND s.owner = ?2")
    Optional<StandModel> getStandModelBy(String book_code, String user_dni);

    @Modifying
    @Query("UPDATE StandModel s SET s.units = s.units - 1 WHERE s.book_id = ?1 AND s.owner = ?2")
    void reduceUnit(String book_code, String user_dni);

}