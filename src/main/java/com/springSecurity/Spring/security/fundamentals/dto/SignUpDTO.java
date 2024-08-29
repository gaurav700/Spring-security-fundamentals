package com.springSecurity.Spring.security.fundamentals.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class SignUpDTO {
    private String email;
    private String password;
    private String name;
}
