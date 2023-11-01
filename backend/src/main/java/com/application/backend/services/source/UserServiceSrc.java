package com.application.backend.services.source;

import com.application.backend.models.UserModel;
import com.application.backend.persistence.source.UserDAOSrc;
import com.application.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceSrc implements UserService {

    @Autowired
    private UserDAOSrc userDAO;

    @Override
    public List<UserModel> findAll() {
        return userDAO.findAll();
    }

    @Override
    public Optional<UserModel> findByDni(String dni) {
        return userDAO.findByDni(dni);
    }

    @Override
    public void registerUser(UserModel user) {
        userDAO.register(user);
    }

    @Override
    public void updateEmPass(String newEmail, String newPass, String dni) {  // actualizar datos del usuario
        userDAO.updateEmPass(newEmail, newPass, dni);
    }

    @Override
    public void deleteByDni(String dni) {
        userDAO.deleteByDni(dni);
    }

}
