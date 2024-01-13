package com.application.backend.user.controllers;

import com.application.backend.user.dto.LoginDTO;
import com.application.backend.user.dto.RegisterDTO;
import com.application.backend.user.UserModel;
import com.application.backend.user.service.UserService;
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
    UserService userService;

    private Boolean incompleteUser(RegisterDTO user) {
        return user.getDni().isBlank() || user.getName().isBlank() || user.getLastname().isBlank() ||
                user.getEmail().isBlank() || user.getPassword().isBlank();
    }

    @GetMapping("/all")   // get para mostrar la lista de usuarios (no visible para UI)
    public ResponseEntity<?> getUsers() {
        List<RegisterDTO> userList = userService.findAll().stream()
                .map(user -> RegisterDTO.builder().dni(user.getDni())
                        .name(user.getUsername()).lastname(user.getLastname())
                        .email(user.getEmail()).password(user.getPassword()).build()
                ).toList();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{dni}")  // get para mostrar el usuario por dni
    public ResponseEntity<?> getByDni(@PathVariable String dni) {
        Optional<UserModel> findUser = userService.findByDni(dni);

        if (findUser.isPresent()) {
            UserModel user = findUser.get();
            RegisterDTO userDTO = RegisterDTO.builder().dni(user.getDni())
                    .name(user.getUsername()).lastname(user.getLastname())
                    .email(user.getEmail()).password(user.getPassword())
                    .build();

            return ResponseEntity.ok(userDTO);
        } else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("El usuario no esta registrado");
    }

    @PostMapping("/register")  // post para registrar un nuevo usuario
    public ResponseEntity<?> registerUser(@RequestBody RegisterDTO user) {
        if (this.incompleteUser(user))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registro incompleto");
        try {
            this.userService.registerUser(UserModel.builder().dni(user.getDni())
                    .name(user.getName()).lastname(user.getLastname())
                    .email(user.getEmail()).password(user.getPassword()).build());
            return ResponseEntity.status(HttpStatus.OK).body("Usuario insertado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar el usuario");
        }
    }

    @PostMapping("/login")  // post para registrar un nuevo usuario
    public ResponseEntity<?> LogIn(@RequestBody LoginDTO user) {
        return userService.logInUser(user);
    }

    @PutMapping("/{dni}/{email}/{pass}")  // put para actualizar el email y pass del usuario por su dni (almacenada en Hook React)
    public ResponseEntity<?> updateEmailPass(@PathVariable String dni, @PathVariable String email, @PathVariable String pass) {
        try {
            this.userService.updateEmPass(email, pass, dni);
            return ResponseEntity.status(HttpStatus.OK).body("Datos del usuario actualizados");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error de actualizacion del usuario");
        }
    }

    @DeleteMapping("/{dni}")  // delete para eliminar el usuario
    public ResponseEntity<?> deleteByDni(@PathVariable String dni) {
        try {
            this.userService.deleteByDni(dni);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el usuario");
        }
    }

}
