package com.example.MusicApp.controllers;
;
import com.example.MusicApp.exceptions.ApiRequestException;
import com.example.MusicApp.models.JwtRequest;
import com.example.MusicApp.models.JwtResponse;
import com.example.MusicApp.models.Role;
import com.example.MusicApp.models.User;
import com.example.MusicApp.services.UserService;
import com.example.MusicApp.services.UserServiceImpl;
import com.example.MusicApp.utility.JWTUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Slf4j
@RestController
@RequestMapping("/TruMusic")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);


    private JWTUtility jwtUtility;
    private AuthenticationManager authenticationManager;
    private final UserService userService;
    private UserServiceImpl userServiceImpl;

    @Autowired
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
    @PostMapping(value = "/login", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
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

    @GetMapping(path = "/users", produces = APPLICATION_JSON_VALUE)
    public List <User> getAllUsers() {
        List<User> allUsers;
        try {
            allUsers = userService.getAllUsers();
        } catch (ApiRequestException e) {
            throw new ApiRequestException("Cannot get all users with custom exception");
        }
        return allUsers;
    }
//
    @PostMapping(path = "/user/register", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<User>saveUser(@RequestBody User user) {
        logger.info("User registration {}", user);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping(path = "/role/save", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Role>saveRole(@RequestBody Role role){
        logger.info("Saved Role {}", role);
        return new ResponseEntity<>(userService.saveRole(role), HttpStatus.CREATED);
    }

    @PostMapping(path = "/role/addToUser", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<User>addRoleToUser(@RequestBody RoleToUser userRole){
        userService.addRoleToUser(userRole.getUsername(), userRole.getRoleId());
        return ResponseEntity.ok().build();
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

