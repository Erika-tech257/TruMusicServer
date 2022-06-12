package com.example.MusicApp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
public class UserInfo implements Serializable{

    public UserInfo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer userinfo_id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String email;

    @Override
    public String toString() {
        return "UserInfo{" +
                "userinfo_id=" + userinfo_id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
