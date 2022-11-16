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
    private UserRepository userRepository;

    @GetMapping
    public List<User> fetchAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User registerNewUser (@RequestBody User user){
        return userService.addNewUser(user);
    }

    @PostMapping(path = "/addAgeCard/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void AddAgeCardDetails(@RequestBody AgeCard ageCard, @PathVariable String id) {

        //Find sensor to insert metrics into
        User user = userService.findById(id);
        if (user == null) {
            throw new IllegalStateException("User ID has not been registered!");
        } else {
            if (user.getCards().get(0).getAgeCard() == null) {
                //user.getCards().get(0).getAgeCard().setAgeCard(ageCard);
                user.getCards().get(0).getAgeCard().setName(ageCard.getName());
                user.getCards().get(0).getAgeCard().setGender(ageCard.getGender());
                user.getCards().get(0).getAgeCard().setAddress(ageCard.getAddress());
                user.getCards().get(0).getAgeCard().setDateOfBirth(ageCard.getDateOfBirth());
                user.getCards().get(0).getAgeCard().setCardNumber(ageCard.getCardNumber());
                userRepository.save(user);
            }
            else {
                throw new IllegalStateException("Age Card already exists!");
            }
        }
    }
}
