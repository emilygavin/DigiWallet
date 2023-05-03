package com.example.DigiWallet;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    @GetMapping(path = "/login")
    @ResponseStatus(HttpStatus.OK)
    public User getUserByEmailAndPassword(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) throws Exception {
        return userService.getUser(email, password);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addNewUser(@RequestBody User user) throws Exception {
        return userService.addNewUser(user);
    }

    @PostMapping(path = "/addAgeCard/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User addAgeCard(@RequestBody AgeCard ageCard, @PathVariable String id) {
        return userService.addAgeCard(ageCard, id);
    }

    @PostMapping(path = "/addStudentCard/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User addStudentCard(@RequestBody StudentCard studentCard, @PathVariable String id) {
        return userService.addStudentCard(studentCard, id);
    }

    @PostMapping(path = "/addDriversLicense/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User addDriversLicense(@RequestBody DriversLicense driversLicense, @PathVariable String id) {
        return userService.addDriversLicense(driversLicense, id);
    }

    @PostMapping(path = "/addPassportCard/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User addPassportCard(@RequestBody PassportCard passportCard, @PathVariable String id) {
        return userService.addPassportCard(passportCard, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteUser(@PathVariable String id) throws Exception {
        userService.deleteUser(id);
    }
}
