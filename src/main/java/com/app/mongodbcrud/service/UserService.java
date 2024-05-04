package com.app.mongodbcrud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.mongodbcrud.dto.UserTo;
import com.app.mongodbcrud.model.User;
import com.app.mongodbcrud.repository.UserRepository;
// import com.google.gson.Gson;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> createUser(UserTo userTo) {
        try {
            User newUser = User.builder().email(userTo.getEmail()).name(userTo.getName()).build();
            userRepository.save(newUser);
            return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("Failed to Create the User" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> getAllUsers() {
        try {
            return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to fetch users ->" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> getUser(String userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        try {
            if (userOptional.isPresent()) {
                return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to get the user ->" + e.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }

    public ResponseEntity<String> updateUser(String userId, UserTo updatedUserData) {
        try {
            Optional<User> userOptional = userRepository.findById(userId);
            if (userOptional.isPresent()) {
                User existingUser = userOptional.get();
                existingUser.setEmail(updatedUserData.getEmail());
                existingUser.setName(updatedUserData.getName());
                userRepository.save(existingUser); // update the existing user
                return new ResponseEntity<>("Update user successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update the user ->" + e.getMessage(), HttpStatus.BAD_REQUEST);

        }

    }

    public ResponseEntity<String> deleteUser(String userId) {
        try {
            Optional<User> userOptional = userRepository.findById(userId);
            if (userOptional.isPresent()) {
                userRepository.deleteById(userId);
                return new ResponseEntity<>("User Deleted", HttpStatus.OK);

            } else {
                return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete the user ->" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
