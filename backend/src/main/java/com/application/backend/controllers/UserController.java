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

    private Boolean incompleteUser(UserDTO user) {
        return user.getDni().isBlank() || user.getName().isBlank() || user.getLastname().isBlank() ||
                user.getEmail().isBlank() || user.getPassword().isBlank();
    }

    @GetMapping("/all")   // get para mostrar la lista de usuarios (no visible para UI)
    public ResponseEntity<?> getUsers() {
        List<UserDTO> userList = userService.findAll().stream()
                .map(user -> UserDTO.builder().dni(user.getDni())
                        .name(user.getName()).lastname(user.getLastname())
                        .email(user.getEmail()).password(user.getPassword()).build()
                ).toList();
        return ResponseEntity.ok(userList);
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
    public ResponseEntity<?> registerUser(@RequestBody UserDTO user) {
        if (incompleteUser(user))
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

    @PutMapping("/{dni}/{email}/{pass}")  // post para actualizar el email y pass del usuario por su dni (almacenada en Hook React)
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
