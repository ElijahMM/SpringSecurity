package com.example.Security;

import com.example.Models.User;
import com.example.Repos.UserRepository;
import com.example.Utils.SpringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;

/**
 * Created by mihai on 30.03.2017.
 */
public class TokenAuthenticationService {

    static final long EXPIRATION_TIME = 10000000;
    static final String SECRET = "JoiVineri";
    static final String TOKEN_PREFIX = "Elijah";
    static final String HEADER_STRING = "Authorization";

    static UserRepository userRepository = SpringUtils.getBean(UserRepository.class);

    public static void addAuthentication(HttpServletResponse response, String username) {
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        User user = userRepository.getUserByName(username);
        user.setToken(JWT);
        userRepository.saveAndFlush(user);
        response.setContentType("application/json");

        try {
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(user));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);

        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            return user != null ? new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()) : null;
        }
        return null;
    }

}
