package com.example.demo.CinemaRelated;

import com.example.demo.Repository.UserRepository;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "\"users\"",schema = "\"cinema\"")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "user_username")
    private String username;
    @Column(name = "user_firstname")
    private String firstname;
    @Column(name = "user_lastname")
    private String lastname;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_role")
    private String role;

    public Users(String username, String firstname, String lastname, String password, String role) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.role = role;
    }

    public Users() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
