package com.example.myproject.security;

import com.example.myproject.domain.User;
import com.example.myproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        System.out.println(password);

        User user = (User) userService.loadUserByUsername(username);

        if(user != null && (user.getUsername().equals(username)))
        {

            System.out.println(password + " - пароль +  паротль юзера " + user.getPassword());

            System.out.println("Прошел первый иф");

            System.out.println(passwordEncoder.matches(password, user.getPassword()));
            if(!passwordEncoder.matches(password, user.getPassword()))
            {
                System.out.println("не прошел вроверку пароля");
                throw new BadCredentialsException("Wrong password");
            }
            System.out.println("Вернул токен");
            return new UsernamePasswordAuthenticationToken(user, password);
        }
        else {
            System.out.println("выполнил елсе");
            throw new BadCredentialsException("Username not found");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
