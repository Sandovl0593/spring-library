package com.application.backend.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserModel, String> {

    @Modifying
    @Query("UPDATE UserModel u SET u.email = ?1, u.password = ?2 WHERE u.dni = ?3")
    void updateEmPass(String newEmail, String newPass, String dni);

    @Query("SELECT u FROM UserModel u WHERE u.email = ?1")
    Optional<UserModel> getUserByEmail(String email);
}