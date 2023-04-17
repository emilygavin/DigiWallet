package com.example.DigiWallet;

import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
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

    @GetMapping(path = "/login")
    @ResponseStatus(HttpStatus.OK)
    public User fetchUser(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) throws Exception {
        return userService.getUser(email, password);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User registerNewUser (@RequestBody User user) throws Exception {
        return userService.addNewUser(user);
    }

    @PostMapping(path = "/addAgeCard/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User AddAgeCard(@RequestBody AgeCard ageCard, @PathVariable String id) {
        return userService.addAgeCard(ageCard, id);
    }

    @PostMapping(path = "/addStudentCard/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User AddStudentCard(@RequestBody StudentCard studentCard, @PathVariable String id) {
        return userService.addStudentCard(studentCard, id);
    }

    @PostMapping(path = "/addDriverslicense/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User AddDriversLicense(@RequestBody DriversLicense driversLicense, @PathVariable String id) {
        return userService.addDriversLicense(driversLicense, id);
    }

    @PostMapping(path = "/addPassportCard/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User AddPassportCard(@RequestBody PassportCard passportCard, @PathVariable String id) {
        return userService.addPassportCard(passportCard, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteUser(@PathVariable String id) throws Exception {
        userService.deleteUser(id);
    }
}
