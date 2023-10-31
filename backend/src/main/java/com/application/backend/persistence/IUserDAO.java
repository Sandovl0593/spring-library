package com.application.backend.persistence;

import com.application.backend.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {
    List<UserModel> findAll();  // listar los usuarios

    Optional<UserModel> findByDni(String dni);  // mostrar un usuario por dni

    void save(UserModel user);  // agregar un nuevo usuario

    void deleteByDni(String dni);  // eliminar cuenta (usuario)
}
