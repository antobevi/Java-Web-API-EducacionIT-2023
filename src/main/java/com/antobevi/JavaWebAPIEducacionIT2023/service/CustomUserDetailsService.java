package com.antobevi.JavaWebAPIEducacionIT2023.service;

import com.antobevi.JavaWebAPIEducacionIT2023.model.WebAppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WebAppUser user = userService.findUserByName(username).get();

        if(user == null) {
            throw new UsernameNotFoundException("User " + username + " not found.");
        }

        return User.withUsername(user.getUsername()).password("{bcrypt}" + user.getPassword()).build();
    }

    /* EJEMPLO CON CONTRASEÑA HARDCODEADA (en texto plano)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if("userExample".equals(username)) {
            return WebAppUser.withUsername("userExample").password("{noop}pass")
                    .roles("USER").build(); // WebAppUser me lo provee Spring
        } else {
            throw new UsernameNotFoundException("WebAppUser " + username + " not found.");
        }

    }
    */

}
