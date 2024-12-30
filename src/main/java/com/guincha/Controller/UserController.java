package com.guincha.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.guincha.Model.User;
import com.guincha.Service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

  
    private UserService userService;

    public UserController(UserService userService) {
    	this.userService = userService;
    }
    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
    
    @PostMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
    
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
  
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
