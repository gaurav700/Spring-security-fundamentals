package com.springSecurity.Spring.security.fundamentals.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String name;
}
