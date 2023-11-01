package com.application.backend.controllers.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private String dni;
    private String name;
    private String lastname;
    private String email;
    private String password;
}
