package com.application.backend.stand;

import java.util.List;

public interface StandService {

    List<StandModel> findAll();

    void registerStand(StandModel stand);

    List<StandModel> findByUser(String userdni);

    void refunding(Integer cant, String book_code, String owner_dni);  // resta las unidades y elimina si units = 0

    void addUnit(Integer cant, String book_code, String user_dni);  // adiciona si ya existe o construye el stand


}
