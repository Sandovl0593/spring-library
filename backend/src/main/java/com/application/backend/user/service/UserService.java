package com.application.backend.user.service;

import com.application.backend.user.UserModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserModel> findAll();  // listar los usuarios

    Optional<UserModel> findByDni(String dni);  // mostrar un usuario por dni

    void registerUser(UserModel user);  // agregar un nuevo usuario

    void updateEmPass(String newEmail, String newPass, String dni);  // actualizar datos del usuario

    void deleteByDni(String dni);  // eliminar cuenta (usuario)

    UserDetailsService getUserDetails();
}
