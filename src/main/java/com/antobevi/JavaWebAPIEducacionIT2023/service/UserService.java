package com.antobevi.JavaWebAPIEducacionIT2023.service;

import com.antobevi.JavaWebAPIEducacionIT2023.model.WebAppUser;
import com.antobevi.JavaWebAPIEducacionIT2023.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    public Optional<WebAppUser> findUserByName(String name) {
        return usersRepository.findByName(name);
    }

    public WebAppUser saveUser(WebAppUser webAppUser) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        webAppUser.setPassword(bCryptPasswordEncoder.encode(webAppUser.getPassword()));

        return usersRepository.save(webAppUser);
    }

}
