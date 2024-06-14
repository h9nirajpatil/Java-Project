package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    public User createUser(String username, String password){
        // set user attributes
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository3.save(user);
        return user;
    }

    public void deleteUser(int userId){

        userRepository3.deleteById(userId);

    }

    public User updateUser(Integer id, String password) {
        User user=userRepository3.findById(id).get();


        user.setPassword(password); //set the new password
        userRepository3.save(user);
        return user;
    }
}