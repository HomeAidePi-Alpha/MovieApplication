package com.User;

import com.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> getAllUsers() {
        return userRepository.findAll(); // returns a list of users
    }


    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }


    public UserModel getEmployeeById(String username) {
        return userRepository.findById(username)
                .orElseThrow(() -> new ResourceNotFoundException("User With the username: " + username + " does not exist!"));
    }


    public UserModel updateUser(String username, UserModel userDetails) {
        UserModel user = userRepository.findById(username)
                .orElseThrow(() -> new ResourceNotFoundException("User With the username: " + username + " does not exist!"));

        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setEmail(userDetails.getEmail());

        return userRepository.save(user);
    }


    public void deleteEmployee(String username) {
        UserModel user = userRepository.findById(username)
                .orElseThrow(() -> new ResourceNotFoundException("User With the username: " + username + " does not exist!"));
        userRepository.delete(user);
    }
}
