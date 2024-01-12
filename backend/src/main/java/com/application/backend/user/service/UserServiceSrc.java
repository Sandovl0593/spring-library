package com.application.backend.user.service;

import com.application.backend.user.UserDAO;
import com.application.backend.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceSrc implements UserService {

    @Autowired
    private UserDAO userDAO;

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

    @Override
    public UserDetailsService getUserDetails() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String userdni) throws UsernameNotFoundException {
                return (UserDetails) userDAO.findByDni(userdni).get();
            }
        };
    }
}
