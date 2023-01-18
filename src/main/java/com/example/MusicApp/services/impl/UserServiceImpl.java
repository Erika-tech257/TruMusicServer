package com.example.MusicApp.services.impl;

import com.example.MusicApp.exceptions.UserInfoNotFoundException;
import com.example.MusicApp.models.Role;
import com.example.MusicApp.models.User;
import com.example.MusicApp.models.UserInfo;
import com.example.MusicApp.repositories.RoleRepository;
import com.example.MusicApp.repositories.UserInfoRepository;
import com.example.MusicApp.repositories.UserRepository;
import com.example.MusicApp.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserInfoRepository userInfoRepository;
    private final RoleRepository roleRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository, PasswordEncoder passwordEncoder, UserInfoRepository userInfoRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userInfoRepository = userInfoRepository;
    }

    //userDetails takes in username, password and authorities
    //loop through each user role to provide authorities

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = userRepository.findByUsername(username);
        if( user == null) {
            throw new UsernameNotFoundException("Username not found");
        } else {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the DB", user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the DB", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, Integer roleId) {
        log.info("Adding role {} to user {}", roleId, username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByRoleId(roleId);
        user.getRoles().add(role);
    }

    @Override
    public void getUser(String username) {
        log.info("Fetching user {}", username);
        userRepository.findByUsername(username);
    }

    public List<Role> getAllRoles() {
        log.info("Fetching all roles");
        return roleRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public void deleteUser(Integer id){
        boolean exists = userRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("User with id " + id + " does not exist");
        }
        log.info("Deleting user {}", id);
        userRepository.deleteById(id);
    }

    @Override
    public User getUserByUserInfo(UserInfo userInfo){
        User user;
        try {
            user = userInfoRepository.findUserInfoByUser(userInfo);
            logger.info("This user is associated with this userinfo {}", userInfo);
        }catch (UserInfoNotFoundException e){
            throw new UserInfoNotFoundException(e.getMessage());
        }
        return user;
    }

}
