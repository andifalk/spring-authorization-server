package com.example.authorizationserver.user.boundary;

import com.example.authorizationserver.user.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
