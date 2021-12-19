//package com.example.MusicApp.controllers;
//
//import com.example.MusicApp.models.Role;
//import com.example.MusicApp.models.User;
//import com.example.MusicApp.services.UserService;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequestMapping("/TruMusic")
//public class UserController {
//
//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    //ResponseEntity represents the whole HTTP response: status code, headers, and body
//    //ResponseEntity is generic
//
//    @GetMapping(path = "/users")
//    public ResponseEntity<List<User>>getAllUsers(){
//        return ResponseEntity.ok().body(userService.getAllUsers());
//    }
//
//    @PostMapping(path = "/user/register")
//    public ResponseEntity<User>saveUser(@RequestBody User user) {
//        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
//    }
//
//    @PostMapping(path = "/role/save")
//    public ResponseEntity<Role>saveRole(@RequestBody Role role){
//        return new ResponseEntity<Role>(userService.saveRole(role), HttpStatus.CREATED);
//    }
//
//    //not returning a body so just call the build method
//
//    @PostMapping(path = "/role/addToUser")
//    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUser userRole){
//        userService.addRoleToUser(userRole.getUsername(), userRole.getRoleName());
//        return ResponseEntity.ok().build();
//    }
//}
////Want the username and roleName and pass it as an object
////@Data includes getters and setters
//
//@Data
//class RoleToUser {
//    private String username;
//    private String roleName;
//}