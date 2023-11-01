package com.application.backend.controllers;

import com.application.backend.controllers.dto.UserDTO;
import com.application.backend.models.UserModel;
import com.application.backend.services.source.UserServiceSrc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceSrc userService;

    @GetMapping("/all")   // get para mostrar la lista de usuarios
    public List<UserModel> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/{dni}")  // get para mostrar el usuario por dni
    public ResponseEntity<?> getByDni(@PathVariable String dni) {
        Optional<UserModel> findUser = userService.findByDni(dni);

        if (findUser.isPresent()) {
            UserModel user = findUser.get();
            UserDTO userDTO = UserDTO.builder().dni(user.getDni())
                    .name(user.getName()).lastname(user.getLastname())
                    .email(user.getEmail()).password(user.getPassword())
                    .build();

            return ResponseEntity.ok(userDTO);
        } else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("El usuario no esta registrado");
    }

    @PostMapping()  // post para registrar un nuevo usuario
    public ResponseEntity<?> registerUser(@RequestBody UserModel user) {
        try {
            this.userService.registerUser(user);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario insertado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar el usuario");
        }
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<?> deleteByDni(@PathVariable String dni) {
        try {
            this.userService.deleteByDni(dni);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el usuario");
        }
    }

}
