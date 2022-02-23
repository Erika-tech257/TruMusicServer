package com.example.MusicApp.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.MusicApp.models.JwtRequest;
import com.example.MusicApp.models.JwtResponse;
import com.example.MusicApp.models.Role;
import com.example.MusicApp.models.User;
import com.example.MusicApp.services.UserService;
import com.example.MusicApp.services.UserServiceImpl;
import com.example.MusicApp.utility.JWTUtility;
import com.fasterxml.jackson.databind.ObjectMapper;
import javassist.bytecode.stackmap.TypeData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.OK;


@Slf4j
@RestController
@RequestMapping("/TruMusic")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    private final UserService userService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    public UserController(JWTUtility jwtUtility, AuthenticationManager authenticationManager, UserService userService) {
        this.jwtUtility = jwtUtility;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

//ResponseEntity represents the whole HTTP response: status code, headers, and body
    //ResponseEntity is generic


//    @PostMapping(value = "/login")
//    public ResponseEntity<User> login(@RequestParam(name = "username") String username){
//        return new ResponseEntity<>(userService.getUser(username), OK);
//
//    }

    //once authentication is done, need to create jwt token, then wrap token
    // in jwt response and send it back
    @PostMapping(value = "/login")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetails userDetails = userServiceImpl.loadUserByUsername(jwtRequest.getUsername());
        final String token = jwtUtility.generateToken(userDetails);

        return new JwtResponse(token);
    }


    @GetMapping(path = "/users")
    public List <User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(path = "/user/register")
    public ResponseEntity<User>saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping(path = "/role/save")
    public ResponseEntity<Role>saveRole(@RequestBody Role role){
        return new ResponseEntity<>(userService.saveRole(role), HttpStatus.CREATED);
    }

    @PostMapping(path = "/role/addToUser")
    public ResponseEntity<User>addRoleToUser(@RequestBody RoleToUser userRole){
        userService.addRoleToUser(userRole.getUsername(), userRole.getRoleId());
        return ResponseEntity.ok().build();
    }


    //TODO: CREATE UNTIL CLASS FOR TOKEN REDUCE REDUNDANCY

    @GetMapping(path = "/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response){
        String authHeader = request.getHeader(AUTHORIZATION);
        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            try {
                String refreshToken = authHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refreshToken);
                String username = decodedJWT.getSubject();
                User user = userService.getUser(username);
                String accessToken = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10080 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("accessToken", accessToken);
                tokens.put("refreshToken", refreshToken);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
                Map<String, String> error = new HashMap<>();
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            logger.trace("Error creating refresh token in UserController");
            throw new RuntimeException("Refresh token is missing");

        }
    }
}
//Want the username and roleName and pass it as an object
//Basically a DTO

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class RoleToUser {
    private String username;
    private Integer roleId;
}

