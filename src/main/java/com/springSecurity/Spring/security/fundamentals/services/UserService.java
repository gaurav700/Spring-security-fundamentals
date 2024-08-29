package com.springSecurity.Spring.security.fundamentals.services;

import com.springSecurity.Spring.security.fundamentals.dto.LoginDTO;
import com.springSecurity.Spring.security.fundamentals.dto.SignUpDTO;
import com.springSecurity.Spring.security.fundamentals.dto.UserDTO;
import com.springSecurity.Spring.security.fundamentals.entities.UserEntity;
import com.springSecurity.Spring.security.fundamentals.exceptions.ResourceNotFoundException;
import com.springSecurity.Spring.security.fundamentals.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(()-> new BadCredentialsException("user with email  "+username+ " not found"));
    }

    public UserDTO signUp(SignUpDTO sign) {
        Optional<UserEntity> userEntityOptional = userRepository.findByEmail(sign.getEmail());
        if(userEntityOptional.isPresent()){
            throw new BadCredentialsException("User with email already exists "+ sign.getEmail());
        }
        UserEntity userEntity = modelMapper.map(sign, UserEntity.class);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        UserEntity user = userRepository.save(userEntity);
        return  modelMapper.map(user, UserDTO.class);
    }

    public UserEntity getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User with id "+id+" not found"));
    }

}
