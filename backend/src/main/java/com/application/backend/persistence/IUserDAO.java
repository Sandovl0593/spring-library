package com.application.backend.persistence;

import com.application.backend.models.UserModel;

import java.util.List;

public interface IUserDAO {
    List<UserModel> findAll();

}
