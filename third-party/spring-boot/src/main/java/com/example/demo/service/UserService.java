package com.example.demo.service;


import com.example.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    private MailService mailService;

    private List<User> users = new ArrayList<>(List.of( // users:
            new User("bob@example.com", "password", "Bob"), // bob
            new User("alice@example.com", "password", "Alice"), // alice
            new User("tom@example.com", "password", "Tom"))); // tom

    public UserService(MailService mailService) {
        this.mailService = mailService;
    }

    public User login(String email, String password) {

        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPwd().equals(password)) {
                mailService.sendLoginMail(user);
                return user;
            }
        }
        throw new RuntimeException("login failed.");
    }

    public User getUser(long id) {
        return this.users.stream().filter(user -> user.getId() == id).findFirst().orElseThrow();
    }

    public User register(String email, String password, String name) {
        users.forEach((user) -> {
            if (user.getEmail().equalsIgnoreCase(email)) {
                throw new RuntimeException("email exist.");
            }
        });
        User user = new User(email, password, name);
        users.add(user);
        mailService.sendRegistrationMail(user);
        return user;
    }
}
