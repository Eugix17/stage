package com.exprivia.stage.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.exprivia.stage.entities.User;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private List<User> userList = new ArrayList<>(Arrays.asList(new User("1", "Eugenio", "Fatone", "fatoneugenio@gmail.com"),
                                                                new User("2", "Vincenzo", "Ferraro", "vincenzoferraro@gmail.com"),
                                                                new User("3", "Giuseppe", "Caggiano", "giuseppecaggiano@gmail.com")));    

    public List<User> getAllUserList(){
        return userList;
    }
    
    public User getUser(String id){
        return userList.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }

    public void addUser(User user){
        userList.add(user);
    }

    public void updateUser(User user, String id){
        int n = 0;
        for(User userr: userList){
            if (userr.getId().equals(id)){
                userList.set(n, user);
            }
            n++;
        }
    }

    public void deleteUser(String id) {
        userList.removeIf(user -> user.getId().equals(id));
    }
}
