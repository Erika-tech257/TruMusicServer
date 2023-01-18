package com.example.MusicApp.controllers;

import com.example.MusicApp.mapper.CustomMapper;
import com.example.MusicApp.models.*;
import com.example.MusicApp.repositories.RoleRepository;
import com.example.MusicApp.services.UserService;
import com.example.MusicApp.services.impl.UserServiceImpl;
import com.example.MusicApp.utility.JWTUtility;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequiredArgsConstructor
@RestController
@RequestMapping("/TruMusic")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    private final JWTUtility jwtUtility;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final UserServiceImpl userServiceImpl;
    private final CustomMapper customMapper;
    private final RoleRepository roleRepository;

//    @Autowired
//    public UserController(JWTUtility jwtUtility, AuthenticationManager authenticationManager, UserService userService, CustomMapper customMapper, UserServiceImpl userServiceImpl) {
//        this.jwtUtility = jwtUtility;
//        this.authenticationManager = authenticationManager;
//        this.userService = userService;
//        this.customMapper = customMapper;
//        this.userServiceImpl = userServiceImpl;
//    }

//ResponseEntity represents the whole HTTP response: status code, headers, and body
    //ResponseEntity is generic


//    @PostMapping(value = "/login")
//    public ResponseEntity<User> login(@RequestParam(name = "username") String username){
//        return new ResponseEntity<>(userService.getUser(username), OK);
//
//    }

    /**
     * once authentication is done, need to create jwt token, then wrap token in jwt response and send it back
     * @param jwtRequest
     * @return
     * @throws Exception
     */

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
        final UserDetails userDetails = userServiceImpl.loadUserByUsername(jwtRequest.getUsername());  //NullPointer Error
        final String token = jwtUtility.generateToken(userDetails);
        return new JwtResponse(token);
    }

    @GetMapping(path = "/user/{username}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void getUser(@PathVariable("username") String username) {
        userService.getUser(username);
    }

    @GetMapping(path = "/userInfo/")

    @PostMapping(path = "/user/register", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<User>saveUser(@RequestBody User user) {
        logger.info("User registration {}", user);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }


    @PostMapping(path = "/role/addToUser", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<User>addRoleToUser(@RequestBody RoleToUser userRole){
        userService.addRoleToUser(userRole.getUsername(), userRole.getRoleId());
        return ResponseEntity.ok().build();
    }

    /**
     *   Custom Mapper implementation
     */
    @GetMapping(path = "/all", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List <Role> getAll(){
        return userServiceImpl.getAllRoles();
    }

    @PostMapping(path = "/update", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Role role){
        role.setName(role.getName());
        customMapper.insert(role);
    }
}

/**
 * Want the username and roleName and pass it as an object Basically a DTO
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class RoleToUser {
    private String username;
    private Integer roleId;
}

