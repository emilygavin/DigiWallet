package com.example.DigiWallet;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DigiWalletApplicationTests {

    @Mock
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testGetUserInvalidEmail() {
        when(userRepository.findByEmail("invalid@gmail.com")).thenReturn(null);

        assertThrows(Exception.class, () -> userService.getUser("invalid@gmail.com", "Password!123"));
    }

    @Test
    public void testAddNewUserSuccess() throws Exception {
        String encryptionKey = "myEncryptionKey";
        User user = new User("John", "Male", "john@gmail.com", "Password!123", null);
        when(userRepository.findByEmail("john@gmail.com")).thenReturn(null);
        when(userRepository.save(any(User.class))).thenReturn(user);

        UserService userService = new UserService(userRepository, encryptionKey);
        User result = userService.addNewUser(user);
        assertNotNull(result);
        assertEquals("John", result.getName());
    }

    @Test
    public void testAddNewUserEmailAlreadyExists() {
        User user = new User("John", "Male", "john@gmail.com", "Password!123", null);
        when(userRepository.findByEmail("john@gmail.com")).thenReturn(user);

        assertThrows(IllegalArgumentException.class, () -> userService.addNewUser(user));
    }

    @Test
    public void testAddNewUserInvalidEmail() {
        User user = new User("John", "Male", "invalid_email", "Password!123", null);
        when(userRepository.findByEmail("invalid_email")).thenReturn(null);

        assertThrows(Exception.class, () -> userService.addNewUser(user));
    }

    @Test
    public void testAddNewUserInvalidPassword() {
        User user = new User("John", "Male", "john@gmail.com", "password", null);
        when(userRepository.findByEmail("john@gmail.com")).thenReturn(null);

        assertThrows(Exception.class, () -> userService.addNewUser(user));
    }

    @Test
    public void addAgeCardSuccess() throws Exception {
        Cards cards = new Cards();
        User user = new User("123", "John Doe", "Male", "john56@gmail.com", "Password!123", "jogn.jpeg", cards);
        String userId = user.getId();
        AgeCard ageCard = new AgeCard("Age Card", "John Doe", "08-04-1966", "MALE", "12345");

        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User savedUser = invocation.getArgument(0);
            return savedUser;
        });

        userService.addNewUser(user);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        User updatedUser = userService.addAgeCard(ageCard, userId);

        assertNotNull(updatedUser);
        assertNotNull(updatedUser.getCards());
        assertNotNull(updatedUser.getCards().getAgeCard());
        assertEquals(ageCard, updatedUser.getCards().getAgeCard());
    }

    @Test
    public void addAgeCardUserNotFound() throws Exception {
        Cards cards = new Cards();
        User user = new User("123", "John Doe", "Male", "john123@gmail.com", "Password!123", "john.jpeg", cards);
        String userId = "456";
        AgeCard ageCard = new AgeCard("Age Card", "John Doe", "08-04-1966", "MALE", "12345");

        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User savedUser = invocation.getArgument(0);
            return savedUser;
        });

        userService.addNewUser(user);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        assertThrows(IllegalStateException.class, () -> userService.addAgeCard(ageCard, userId));
    }

    @Test
    public void ageCardAlreadyExists() throws Exception {
        Cards cards = new Cards();
        User user = new User("123", "John Doe", "Male", "john99@gmail.com", "Password!123", "john.jpeg", cards);
        String userId = "456";
        AgeCard ageCard = new AgeCard("Age Card", "John Doe", "08-04-1966", "MALE", "12345");
        cards.setAgeCard(ageCard);
        user.setCards(cards);

        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User savedUser = invocation.getArgument(0);
            return savedUser;
        });

        userService.addNewUser(user);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        assertThrows(IllegalStateException.class, () -> userService.addAgeCard(ageCard, userId));
    }

    @Test
    public void addDriversLicenseSuccess() throws Exception {
        Cards cards = new Cards();
        User user = new User("123", "John Doe", "Male", "john89@gmail.com", "Password!123", "jogn.jpeg", cards);
        Address address = new Address("Ros Ard", "Chapel Street", "Dublin", "IRELAND");
        String userId = user.getId();
        DriversLicense driversLicense = new DriversLicense("Drivers License", "John Doe", "08-04-1966", "MALE", "IRELAND", "05-04-2012", "05-04-2025", "12345", address, "CAR");

        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User savedUser = invocation.getArgument(0);
            return savedUser;
        });

        userService.addNewUser(user);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        User updatedUser = userService.addDriversLicense(driversLicense, userId);

        assertNotNull(updatedUser);
        assertNotNull(updatedUser.getCards());
        assertNotNull(updatedUser.getCards().getDriversLicense());
        assertEquals(driversLicense, updatedUser.getCards().getDriversLicense());
    }

    @Test
    public void addDriversLicenseUserNotFound() throws Exception {
        Cards cards = new Cards();
        User user = new User("123", "John Doe", "Male", "john123@gmail.com", "Password!123", "john.jpeg", cards);
        String userId = "456";
        Address address = new Address("Ros Ard", "Chapel Street", "Dublin", "IRELAND");
        DriversLicense driversLicense = new DriversLicense("Drivers License", "John Doe", "08-04-1966", "MALE", "IRELAND", "05-04-2012", "05-04-2025", "12345", address, "CAR");

        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User savedUser = invocation.getArgument(0);
            return savedUser;
        });

        userService.addNewUser(user);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        assertThrows(IllegalStateException.class, () -> userService.addDriversLicense(driversLicense, userId));
    }

    @Test
    public void driversLicenseAlreadyExists() throws Exception {
        Cards cards = new Cards();
        User user = new User("123", "John Doe", "Male", "john45@gmail.com", "Password!123", "john.jpeg", cards);
        String userId = "456";
        Address address = new Address("Ros Ard", "Chapel Street", "Dublin", "IRELAND");
        DriversLicense driversLicense = new DriversLicense("Drivers License", "John Doe", "08-04-1966", "MALE", "IRELAND", "05-04-2012", "05-04-2025", "12345", address, "CAR");
        cards.setDriversLicense(driversLicense);
        user.setCards(cards);

        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User savedUser = invocation.getArgument(0);
            return savedUser;
        });

        userService.addNewUser(user);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        assertThrows(IllegalStateException.class, () -> userService.addDriversLicense(driversLicense, userId));
    }

    @Test
    public void addPassportCardSuccess() throws Exception {
        Cards cards = new Cards();
        User user = new User("123", "John Doe", "Male", "john89@gmail.com", "Password!123", "jogn.jpeg", cards);
        String userId = user.getId();
        PassportCard passportCard = new PassportCard("Passport Card", "IRELAND", "John Doe", "IRISH", "PE2374165", "08-04-1966", "MALE", "05-04-2012", "05-04-2025");

        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User savedUser = invocation.getArgument(0);
            return savedUser;
        });

        userService.addNewUser(user);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        User updatedUser = userService.addPassportCard(passportCard, userId);

        assertNotNull(updatedUser);
        assertNotNull(updatedUser.getCards());
        assertNotNull(updatedUser.getCards().getPassportCard());
        assertEquals(passportCard, updatedUser.getCards().getPassportCard());
    }

    @Test
    public void addPassportCardUserNotFound() throws Exception {
        Cards cards = new Cards();
        User user = new User("123", "John Doe", "Male", "john123@gmail.com", "Password!123", "john.jpeg", cards);
        String userId = "456";
        PassportCard passportCard = new PassportCard("Passport Card", "IRELAND", "John Doe", "IRISH", "PE2374165", "08-04-1966", "MALE", "05-04-2012", "05-04-2025");

        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User savedUser = invocation.getArgument(0);
            return savedUser;
        });

        userService.addNewUser(user);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        assertThrows(IllegalStateException.class, () -> userService.addPassportCard(passportCard, userId));
    }

    @Test
    public void passportCardAlreadyExists() throws Exception {
        Cards cards = new Cards();
        User user = new User("123", "John Doe", "Male", "john456@gmail.com", "Password!123", "john.jpeg", cards);
        String userId = "456";
        PassportCard passportCard = new PassportCard("Passport Card", "IRELAND", "John Doe", "IRISH", "PE2374165", "08-04-1966", "MALE", "05-04-2012", "05-04-2025");
        cards.setPassportCard(passportCard);
        user.setCards(cards);

        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User savedUser = invocation.getArgument(0);
            return savedUser;
        });

        userService.addNewUser(user);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        assertThrows(IllegalStateException.class, () -> userService.addPassportCard(passportCard, userId));
    }

    @Test
    public void addStudentCardSuccess() throws Exception {
        Cards cards = new Cards();
        User user = new User("123", "John Doe", "Male", "john89@gmail.com", "Password!123", "jogn.jpeg", cards);
        String userId = user.getId();
        StudentCard studentCard = new StudentCard("Student Card", "John Doe", "08-04-1966", "ATU", "12345", "Software Engineering", "05-04-2025");
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User savedUser = invocation.getArgument(0);
            return savedUser;
        });

        userService.addNewUser(user);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        User updatedUser = userService.addStudentCard(studentCard, userId);

        assertNotNull(updatedUser);
        assertNotNull(updatedUser.getCards());
        assertNotNull(updatedUser.getCards().getStudentCard());
        assertEquals(studentCard, updatedUser.getCards().getStudentCard());
    }

    @Test
    public void addStudentCardUserNotFound() throws Exception {
        Cards cards = new Cards();
        User user = new User("123", "John Doe", "Male", "john123@gmail.com", "Password!123", "john.jpeg", cards);
        String userId = "456";
        StudentCard studentCard = new StudentCard("Student Card", "John Doe", "08-04-1966", "ATU", "12345", "Software Engineering", "05-04-2025");

        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User savedUser = invocation.getArgument(0);
            return savedUser;
        });

        userService.addNewUser(user);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        assertThrows(IllegalStateException.class, () -> userService.addStudentCard(studentCard, userId));
    }

    @Test
    public void studentCardAlreadyExists() throws Exception {
        Cards cards = new Cards();
        User user = new User("123", "John Doe", "Male", "john456@gmail.com", "Password!123", "john.jpeg", cards);
        String userId = "456";
        StudentCard studentCard = new StudentCard("Student Card", "John Doe", "08-04-1966", "ATU", "12345", "Software Engineering", "05-04-2025");
        cards.setStudentCard(studentCard);
        user.setCards(cards);

        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User savedUser = invocation.getArgument(0);
            return savedUser;
        });

        userService.addNewUser(user);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        assertThrows(IllegalStateException.class, () -> userService.addStudentCard(studentCard, userId));
    }
}