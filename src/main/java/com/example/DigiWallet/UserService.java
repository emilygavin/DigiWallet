package com.example.DigiWallet;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addNewUser(User user){
        return userRepository.save(user);
    }

    public User findById(String id) {
        User user = getAllUsers().stream().filter(t -> id.equals(t.getId())).findFirst().orElse(null);
        return user;
    }
}
