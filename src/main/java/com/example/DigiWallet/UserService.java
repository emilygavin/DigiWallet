package com.example.DigiWallet;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public static boolean PasswordValidation(String password)
    {
        if(password.length()>=8)
        {
            Pattern letter = Pattern.compile("[a-zA-z]");
            Pattern digit = Pattern.compile("[0-9]");
            Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
            //Pattern eight = Pattern.compile (".{8}");

            Matcher hasLetter = letter.matcher(password);
            Matcher hasDigit = digit.matcher(password);
            Matcher hasSpecial = special.matcher(password);

            return hasLetter.find() && hasDigit.find() && hasSpecial.find();
        }
        else
            return false;
    }


    public User addNewUser(User user) throws Exception {
        if(user.getEmail().contains(".com") && user.getEmail().contains("@")) {
            if (PasswordValidation(user.getPassword())) {
                return userRepository.save(user);
            }
            else{
                throw new Exception("Invalid Password! (Must have LETTERS, SPECIAL CHARACTERS and NUMBERS in your password with at least 8 digits)");
            }
        }
        else {
            throw new Exception("Invalid Email Address!");
        }
    }

    public User findByIdAndReturnUser(String id) {
        User user = getAllUsers().stream().filter(t -> id.equals(t.getId())).findFirst().orElse(null);
        return user;
    }

    public User addAgeCard(AgeCard ageCard, String id) {
        //Find user to put Age Card into
        User user = findByIdAndReturnUser(id);
        if (user == null) {
            throw new IllegalStateException("User ID has not been registered!");
        } else {
            if (user.getCards().getAgeCard() == null) {
                user.getCards().setAgeCard(ageCard);
                userRepository.save(user);
                return user;
            }
            else {
                throw new IllegalStateException("Age Card already exists!");
            }
        }
    }

    public User addStudentCard(StudentCard studentCard, String id) {
        //Find user to put Age Card into
        User user = findByIdAndReturnUser(id);
        if (user == null) {
            throw new IllegalStateException("User ID has not been registered!");
        } else {
            if (user.getCards().getStudentCard() == null) {
                user.getCards().setStudentCard(studentCard);
                userRepository.save(user);
                return user;
            }
            else {
                throw new IllegalStateException("Student Card already exists!");
            }
        }
    }

    public User addDriversLicense(DriversLicense driversLicense, String id) {
        //Find user to put Driver's License into
        User user = findByIdAndReturnUser(id);
        if (user == null) {
            throw new IllegalStateException("User ID has not been registered!");
        } else {
            if (user.getCards().getDriversLicense() == null) {
                user.getCards().setDriversLicense(driversLicense);
                userRepository.save(user);
                return user;
            }
            else {
                throw new IllegalStateException("Drivers License already exists!");
            }
        }
    }

    public User addPassportCard(PassportCard passportCard, String id) {
        //Find user to put Passport Card into
        User user = findByIdAndReturnUser(id);
        if (user == null) {
            throw new IllegalStateException("User ID has not been registered!");
        } else {
            if (user.getCards().getStudentCard() == null) {
                user.getCards().setPassportCard(passportCard);
                userRepository.save(user);
                return user;
            }
            else {
                throw new IllegalStateException("Passport Card already exists!");
            }
        }
    }

    public void deleteUser(String id) throws Exception {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
        else {
            throw new Exception("User with this ID does not exist!");
        }
    }
}
