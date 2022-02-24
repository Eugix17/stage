package com.exprivia.stage.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.exprivia.stage.entities.User;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private List<User> usersList = new ArrayList<>(Arrays.asList(new User("1", "Eugenio", "Fatone", "fatoneugenio@gmail.com"),
                                                                new User("2", "Vincenzo", "Ferraro", "vincenzoferraro@gmail.com"),
                                                                new User("3", "Giuseppe", "Caggiano", "giuseppecaggiano@gmail.com")));    

    public List<User> getUsersList(){
        return usersList;
    }
    
    public User getUser(String id){
        return usersList.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }

    public void addUser(User user){
        usersList.add(user);
    }

    public void updateUser(User user, String id){
        int n = 0;
        for(User userr: usersList){
            if (userr.getId().equals(id)){
                usersList.set(n, user);
            }
            n++;
        }
    }

    public void deleteUser(String id) {
        usersList.removeIf(user -> user.getId().equals(id));
    }
}
