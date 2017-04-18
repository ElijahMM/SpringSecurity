package com.example.Security;

import com.example.Models.User;
import com.example.Repos.UserRepository;
import com.example.Utils.SpringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.Collections;

/**
 * Created by mihai on 04.04.2017.
 */
public class CustomAuthenticationManager implements AuthenticationManager {

    UserRepository userRepository;

    public CustomAuthenticationManager() {
        userRepository = SpringUtils.getBean(UserRepository.class);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        User user = userRepository.getUser(username, password);

        if (user == null) {
            throw new BadCredentialsException("Login Failed");
        }
        return new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList());

    }
}
