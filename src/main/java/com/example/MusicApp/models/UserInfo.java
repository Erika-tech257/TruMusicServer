package com.example.MusicApp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
@Table(name = "userInfo")
@Getter
@Setter
@AllArgsConstructor
@Builder
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

    @Column
    private Timestamp lastUpdate;

    //one user to one userInfo
    @OneToOne(cascade = CascadeType.REMOVE)
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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
