package com.application.backend.user.service;

import com.application.backend.user.UserDAO;
import com.application.backend.user.UserModel;
import com.application.backend.user.dto.JwtAuthDTO;
import com.application.backend.user.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private  UserDAO userDAO;

    private  PasswordEncoder passwordEncoder;

    @Autowired
    private  JwtService jwtService;

    private  AuthenticationManager authenticationManager;

    public List<UserModel> findAll() {
        return userDAO.findAll();
    }

    public Optional<UserModel> findByDni(String dni) {
        return userDAO.findByDni(dni);
    }

    public void registerUser(UserModel user) {
        userDAO.register(user);
        JwtAuthDTO response = new JwtAuthDTO();
        response.setToken(jwtService.generateToken(user));
    }

    public ResponseEntity<?> logInUser(LoginDTO login) {
        Optional<UserModel> findUser = userDAO.getUserByEmail(login.getEmail());
        if (!findUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("El usuario no existe");
        }
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
        JwtAuthDTO response = new JwtAuthDTO();
        response.setToken(jwtService.generateToken(findUser.get()));
        return ResponseEntity.status(HttpStatus.OK).body("Usuario ingresado");
    }

    public void updateEmPass(String newEmail, String newPass, String dni) {  // actualizar datos del usuario
        userDAO.updateEmPass(newEmail, newPass, dni);

    }

    public void deleteByDni(String dni) {
        userDAO.deleteByDni(dni);
    }

    public UserDetailsService getUserDetails() {
        return userdni -> userDAO.findByDni(userdni).get();
    }
}
