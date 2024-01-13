package com.application.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDAO {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAll() {
        return (List<UserModel>) userRepository.findAll();
    }

    public Optional<UserModel> findByDni(String dni) {
        return userRepository.findById(dni);
    }

    public void register(UserModel user) {
        userRepository.save(user);
    }

    public void updateEmPass(String newEmail, String newPass, String dni) {
        userRepository.updateEmPass(newEmail, newPass, dni);
    }

    public Optional<UserModel> getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public void deleteByDni(String dni) {
        userRepository.deleteById(dni);
    }
}
