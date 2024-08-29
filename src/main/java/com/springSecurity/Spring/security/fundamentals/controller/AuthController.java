package com.springSecurity.Spring.security.fundamentals.controller;

import com.springSecurity.Spring.security.fundamentals.dto.LoginDTO;
import com.springSecurity.Spring.security.fundamentals.dto.SignUpDTO;
import com.springSecurity.Spring.security.fundamentals.dto.UserDTO;
import com.springSecurity.Spring.security.fundamentals.services.AuthService;
import com.springSecurity.Spring.security.fundamentals.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody SignUpDTO sign){
        UserDTO userDTO = userService.signUp(sign);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO login, HttpServletRequest request, HttpServletResponse response) {
        String token = authService.login(login);
        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return ResponseEntity.ok(token);
    }
}
