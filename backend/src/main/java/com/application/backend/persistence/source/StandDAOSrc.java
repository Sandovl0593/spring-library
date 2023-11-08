package com.application.backend.persistence.source;

import com.application.backend.models.StandModel;
import com.application.backend.persistence.IStandDAO;
import com.application.backend.repositories.StandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StandDAOSrc implements IStandDAO {
    @Autowired
    private StandRepository standRepository;

    @Override
    public List<StandModel> findAll() {
        return (List<StandModel>) standRepository.findAll();
    }

    @Override
    public void register(StandModel stand) {
        standRepository.save(stand);
    }

    @Override
    public List<StandModel> findByUser(String userdni) {
        return standRepository.findByUser(userdni);
    }

    @Override
    public Optional<StandModel> getStandModelBy(String book_code, String user_dni) {
        return standRepository.getStandModelBy(book_code, user_dni);
    }

    @Override
    public void reduceUnit(String book_code, String user_dni) {
        standRepository.reduceUnit(book_code, user_dni);
    }

    @Override
    public void delete(Integer stand_id) {
        standRepository.deleteById(stand_id);
    }
}

