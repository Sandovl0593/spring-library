package com.application.backend.services;

import com.application.backend.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserModel> findAll();  // listar los usuarios

    Optional<UserModel> findByDni(String dni);  // mostrar un usuario por dni

    void registerUser(UserModel user);  // agregar un nuevo usuario

    void deleteByDni(String dni);  // eliminar cuenta (usuario)
}
