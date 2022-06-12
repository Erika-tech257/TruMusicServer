package com.example.MusicApp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "User")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Column(unique = true)
    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = "^[a-zA-Z0-9]{5,12}$",
            message = "Username must be 5 to 12 length with no special characters")
    private String username;

    @Column
    @NotBlank(message = "Password is mandatory")
    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}$",
            message = "Password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit")
    private String password;

    //many roles to one user
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    //one userinfo to one user
    @OneToOne(cascade = CascadeType.REMOVE)
    UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
