package com.application.backend.services;

import com.application.backend.models.StandModel;

import java.util.List;

public interface StandService {

    List<StandModel> findAll();

    void registerStand(StandModel stand);

    List<StandModel> findByUser(String userdni);

    void refunding(String book_code, String owner_dni);  // resta las unidades y elimina si units = 0
}
