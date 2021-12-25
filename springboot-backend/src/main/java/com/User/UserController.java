package com.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers(); // returns a list of users
    }


    @PostMapping("/users")
    public UserModel createUser(@RequestBody UserModel user) {
        return userService.createUser(user);
    }


    @GetMapping("/users/{username}")
    public ResponseEntity<UserModel> getUserById(@PathVariable String username) {
        UserModel user = userService.getEmployeeById(username);
        return ResponseEntity.ok(user);
    }


    @PutMapping("/users/{username}")
    public ResponseEntity<UserModel> updateUser(@PathVariable String username, @RequestBody UserModel userDetails) {
        UserModel updatedUser = userService.updateUser(username, userDetails);
        return ResponseEntity.ok(updatedUser);
    }


    @DeleteMapping("/users/{username}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable String username) {
        userService.deleteEmployee(username);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true); // if the resource didn't exist it was still 'deleted'
        return ResponseEntity.ok(response);
    }
}
