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

    @GetMapping("/alluser")
    public List<User> allUserList(){
        return userService.getAllUserList();
    }

    @GetMapping("/getuser/{id}")
    public User getUser(@PathVariable("id") String id) {
        return userService.getUser(id);
    }

    @PostMapping(value="/postuser")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping(value="/updateuser/{id}")
    public void updateUser(@RequestBody User user, @PathVariable("id") String id) {
        userService.updateUser(user, id);
    }

    @DeleteMapping(value="/deleteuser/{id}")
    public void deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
    }
}
