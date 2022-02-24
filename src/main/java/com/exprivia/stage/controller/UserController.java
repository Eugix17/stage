package com.exprivia.stage.controller;

import java.util.List;

import com.exprivia.stage.entities.User;
import com.exprivia.stage.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getusers")
    public List<User> getUsersList(){
        return userService.getUsersList();
    }

    @GetMapping("/getuser/{id}")
    public User getUser(@PathVariable("id") String id) {
        return userService.getUser(id);
    }

    @PostMapping(value="/createuser")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "User is created successfully";
    }

    @PutMapping(value="/updateuser/{id}")
    public String updateUser(@RequestBody User user, @PathVariable("id") String id) {
        userService.updateUser(user, id);
        return "User is updated successfully";
    }

    @DeleteMapping(value="/deleteuser/{id}")
    public String deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return "User is deleted successfully";
    }
}
