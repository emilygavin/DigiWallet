package com.example.DigiWallet;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping
    public List<User> fetchAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User registerNewUser (@RequestBody User user){
        return userService.addNewUser(user);
    }
}
