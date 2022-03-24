package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User create(@RequestBody User newUser) throws Exception {
        newUser.setUid();

        User result = userRepository.findByUid(newUser.getUid());
        if (result != null) {
            throw new Exception("user already exist");
        }

        return userRepository.save(newUser);
    }

    @GetMapping
    public List<User> findAll(User user) throws Exception {
        Example<User> example = Example.of(user);
        return userRepository.findAll(example);
    }

}
