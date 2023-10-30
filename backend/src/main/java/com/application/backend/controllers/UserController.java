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

    @GetMapping()   // peticion get que muestre la lista de usuarios
    public ArrayList<UserModel> getUsers() {
        return userService.getUsers();
    }

    @PostMapping()  // peticion post para almacenar un usuario en la lista de usuarios del repositorio
    public UserModel setUser(@RequestBody UserModel userModel) {
        return this.userService.setUser(userModel);
    }
}
