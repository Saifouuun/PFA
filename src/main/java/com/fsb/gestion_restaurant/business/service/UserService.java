package com.fsb.gestion_restaurant.business.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsb.gestion_restaurant.dao.models.User;
import com.fsb.gestion_restaurant.dao.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

    public User createUser(User user){
        return repo.save(user);
    }
    public User updateUser(User user){
        return repo.save(user);
    }
    public Optional<User> getUserById(Long id) {
        return repo.findById(id); 
    }
    public void deleteUser(Long id) {
        repo.deleteById(id);  // Delete the user by ID from the database
    }
    

}
