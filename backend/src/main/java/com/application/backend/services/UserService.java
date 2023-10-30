package com.application.backend.services;

import com.application.backend.models.UserModel;
import com.application.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel setUser(UserModel userr) {
        return userRepository.save(userr);
    }
}
