package com.example.MusicApp.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
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

}
