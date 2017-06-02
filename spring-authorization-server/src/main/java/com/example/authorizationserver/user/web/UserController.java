package com.example.authorizationserver.user.web;

import com.example.authorizationserver.user.boundary.UserService;
import com.example.authorizationserver.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("allUsers")
    public List<User> populateUsers() {
        return this.userService.findAll();
    }

    @RequestMapping("/userlist")
    public String findAll() {
        return "userlist";
    }
}
