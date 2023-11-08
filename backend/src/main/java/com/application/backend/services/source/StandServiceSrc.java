package com.application.backend.services.source;

import com.application.backend.models.StandModel;
import com.application.backend.persistence.source.StandDAOSrc;
import com.application.backend.services.StandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandServiceSrc implements StandService {
    @Autowired
    private StandDAOSrc standDAO;

    @Override
    public List<StandModel> findAll() {
        return standDAO.findAll();
    }

    @Override
    public void registerStand(StandModel stand) {
        standDAO.register(stand);
    }

    @Override
    public List<StandModel> findByUser(String userdni) {
        return standDAO.findByUser(userdni);
    }

    @Override
    public void refunding(String book_code, String owner_dni) {
        standDAO.reduceUnit(book_code, owner_dni);
        StandModel stand = standDAO.getStandModelBy(book_code, owner_dni).get();
        if (stand.getUnits() == 0)
            standDAO.delete(stand.getId());
    }
}
