package com.application.backend.stand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StandDAO {
    @Autowired
    private StandRepository standRepository;

    public List<StandModel> findAll() {
        return (List<StandModel>) standRepository.findAll();
    }

    public void register(StandModel stand) {
        standRepository.save(stand);
    }

    public List<StandModel> findByUser(String userdni) {
        return standRepository.findByUser(userdni);
    }

    public Optional<StandModel> getStandModelBy(String book_code, String user_dni) {
        return standRepository.getStandModelBy(book_code, user_dni);
    }

    public void reduceUnit(Integer cant, String book_code, String user_dni) {
        standRepository.reduceUnit(cant, book_code, user_dni);
    }

    public void addUnit(Integer cant, String book_code, String user_dni) {
        standRepository.addUnit(cant, book_code, user_dni);
    }

    public void delete(Integer stand_id) {
        standRepository.deleteById(stand_id);
    }

}

