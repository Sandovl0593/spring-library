package com.application.backend.stand;

import com.application.backend.book.BookModel;
import com.application.backend.book.BookService;
import com.application.backend.user.UserModel;
import com.application.backend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StandService {
    @Autowired
    private StandDAO standDAO;
    @Autowired
    private BookService bookDAO;
    @Autowired
    private UserService userDAO;

    public List<StandModel> findAll() {
        return standDAO.findAll();
    }

    public void registerStand(StandModel stand) {
        standDAO.register(stand);
    }

    public List<StandModel> findByUser(String userdni) {
        return standDAO.findByUser(userdni);
    }

    public void refunding(Integer cant, String book_code, String owner_dni) {
        standDAO.reduceUnit(cant, book_code, owner_dni);
        StandModel stand = standDAO.getStandModelBy(book_code, owner_dni).get();
        if (stand.getUnits() == 0)
            standDAO.delete(stand.getId());
    }

    public void addUnit(Integer cant, String book_code, String user_dni) {
        Optional<StandModel> findStand = standDAO.getStandModelBy(book_code, user_dni);

        if (findStand.isPresent())
            standDAO.addUnit(cant, book_code, user_dni);
        else {
            BookModel book = bookDAO.findByCode(book_code).get();
            UserModel user = userDAO.findByDni(user_dni).get();
            standDAO.register(StandModel.builder().book_id(book).owner(user).units(cant).build());
        }
    }
}
