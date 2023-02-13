package com.arifunver.backendwithspring.service;

import com.arifunver.backendwithspring.exception.UserNotFoundException;
import com.arifunver.backendwithspring.model.User;
import com.arifunver.backendwithspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public User oneUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    public String deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }
        userRepository.deleteById(userId);
        return "User" + userId + " has been deleted.";
    }

    public User updateUser(Long userId, User newUser) {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(userId));

        // ----------------- OR ------------------------------------

        /*User oldUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        oldUser.setUsername(newUser.getUsername());
        oldUser.setName(newUser.getName());
        oldUser.setEmail(newUser.getEmail());
        userRepository.save(oldUser);*/
    }
}
