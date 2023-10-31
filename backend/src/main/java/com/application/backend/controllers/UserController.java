package com.application.backend.controllers;

import com.application.backend.models.UserModel;
import com.application.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()   // get para mostrar la lista de usuarios
    public ArrayList<UserModel> getUsers() {
        return userService.getUsers();
    }

    @PostMapping()  // post para registrar un nuevo usuario
    public UserModel registerUser(@RequestBody UserModel userModel) {
        return this.userService.registerUser(userModel);
    }

}
