package com.guincha.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.guincha.Model.User;
import com.guincha.Repository.UserRepository;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        // Hash password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == null) {
            user.setRole(User.Role.NORMAL); 
        }
        System.out.println("Registering user: " + user);
        return userRepository.save(user);
    }
    public User updateUser(User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("The update request must include an ID");
        }
        if (user.getUsername() == null && user.getPassword() == null && user.getRole() == null) {
            throw new IllegalArgumentException("The update request must include values for either" +
                    "the username, password or role");
        }


        User currentUser = userRepository.findById(user.getId()).orElseThrow();
        currentUser.merge(user);

        return userRepository.save(currentUser);
    }
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByUserEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
