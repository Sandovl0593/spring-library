package com.application.backend.services;

import com.application.backend.models.UserModel;
import com.application.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    // get para mostrar la lista de usuarios
    public List<UserModel> getUsers() {
        return (List<UserModel>) userRepository.findAll();
    }

    // post para registrar un nuevo usuario
    public UserModel registerUser(UserModel userr) {
        return userRepository.save(userr);
    }
}
