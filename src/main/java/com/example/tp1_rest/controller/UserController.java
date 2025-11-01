package com.example.tp1_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



import  com.example.tp1_rest.model.User;
import com.example.tp1_rest.service.TPRestApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController

public class    UserController {

    private final TPRestApplication userService;

    @Autowired
    public UserController(TPRestApplication userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String home() {
        return "API is running!";
    }
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }


    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }


    @PostMapping("/add")
    public String addUtilisateur(@RequestBody User user) {
        return userService.addUser(user);
    }


    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }


    @DeleteMapping("/supp")
    public String supprimerUser(@RequestParam("id") Integer id) {
        return userService.suppUser(id);
    }
}
