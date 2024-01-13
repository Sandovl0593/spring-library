package com.application.backend.user.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterDTO {

    private String dni;
    private String name;
    private String lastname;
    private String email;
    private String password;
}
