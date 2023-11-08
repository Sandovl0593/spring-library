package com.application.backend.persistence;

import com.application.backend.models.StandModel;

import java.util.List;
import java.util.Optional;

public interface IStandDAO {

    List<StandModel> findAll();

    void register(StandModel stand);

    List<StandModel> findByUser(String userdni);

    Optional<StandModel> getStandModelBy(String book_code, String user_dni);

    void reduceUnit(String book_code, String user_dni);  // resta las unidades

    void delete(Integer stand_id);
}
