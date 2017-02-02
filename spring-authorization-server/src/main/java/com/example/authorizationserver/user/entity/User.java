package com.example.authorizationserver.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * User entity.
 */
@RedisHash("users")
public class User {

    @NotNull
    @Id
    private String id;

    @NotNull
    @Size(min = 1, max = 50)
    private String firstname;

    @NotNull
    @Size(min = 1, max = 50)
    private String lastname;

    @Indexed
    @NotNull
    @Size(min = 3, max = 100)
    @Pattern(regexp = "^.*@.*.[A-Za-z]{1,10}$")
    private String email;

    @NotNull
    @Size(min = 5, max = 100)
    private String password;

    @Reference
    private List<Role> roles = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getUserId() {
        return email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
