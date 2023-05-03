package com.example.DigiWallet;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DigiWalletApplicationTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("John", "Male", "john@gmail.com", "Password!123", null));
        userList.add(new User("Mary", "Female", "mary@gmail.com", "Password!456", null));
        when(userRepository.findAll()).thenReturn(userList);

        assertEquals(2, userService.getAllUsers().size());
    }

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
}