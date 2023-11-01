package com.application.backend.persistence.source;

import com.application.backend.models.UserModel;
import com.application.backend.persistence.IUserDAO;
import com.application.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDAOSrc implements IUserDAO {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserModel> findAll() {
        return (List<UserModel>) userRepository.findAll();
    }

    @Override
    public Optional<UserModel> findByDni(String dni) {
        return userRepository.findById(dni);
    }

    @Override
    public void register(UserModel user) {
        userRepository.save(user);
    }

    @Override
    public void deleteByDni(String dni) {
        userRepository.deleteById(dni);
    }
}
