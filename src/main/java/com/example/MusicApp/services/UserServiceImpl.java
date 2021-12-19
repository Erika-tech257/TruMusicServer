package com.example.MusicApp.services;

import com.example.MusicApp.models.Role;
import com.example.MusicApp.models.User;
import com.example.MusicApp.repositories.RoleRepository;
import com.example.MusicApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl( UserRepository userRepository,
                          RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

    }

    @Override
    public User getUser(String username) {
        return null;
    }

    //TODO:Throwing Errors from User Repository with User findByName(String username) it is commented out for now

//    @Override
//    public void addRoleToUser(String username, String roleName) {
//        User user = userRepository.findByName(username);
//        Role role = roleRepository.findByName(roleName);
//        user.getRoles().add(role);
//    }

//    @Override
//    public User getUser(String username) {
//        return userRepository.findByName(username);
//    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Integer userId) {
        boolean exists = userRepository.existsById(userId);
        if(!exists) {
            throw new IllegalStateException("User with id " + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }

}
