package com.example.DigiWallet;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

@Service
public class UserService {

    private final UserRepository userRepository;
    private String ENCRYPTION_KEY;

    public UserService(UserRepository userRepository, String encryptionKey) {
        this.userRepository = userRepository;
        this.ENCRYPTION_KEY = encryptionKey;
    }

    public void setEncryptionKey(String encryptionKey) {
        this.ENCRYPTION_KEY = encryptionKey;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     *  Fetch user by email and password, and decrypt password before checking
     */
    public User getUser(String email, String password) throws Exception {
        User user = userRepository.findByEmail(email);
        if (user == null || !decrypt(user.getPassword()).equals(password)) {
            throw new Exception("Invalid email or password");
        } else {
            return user;
        }
    }

    /**
     * Validate password by letters, digits and special characters
     */
    public static boolean PasswordValidation(String password)
    {
        if(password.length()>=8)
        {
            Pattern letter = Pattern.compile("[a-zA-z]");
            Pattern digit = Pattern.compile("[0-9]");
            Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

            Matcher hasLetter = letter.matcher(password);
            Matcher hasDigit = digit.matcher(password);
            Matcher hasSpecial = special.matcher(password);

            return hasLetter.find() && hasDigit.find() && hasSpecial.find();
        }
        else
            return false;
    }


    /**
     * Add new user, encrypt password before saving
     */
    public User addNewUser(User user) throws Exception {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("User with this Email already exists!");
        } else {
            if (user.getEmail().contains(".com") && user.getEmail().contains("@")) {
                if (PasswordValidation(user.getPassword())) {
                    user.setPassword(encrypt(user.getPassword()));
                    return userRepository.save(user);
                } else {
                    throw new Exception("Invalid Password! (Must have LETTER(S), SPECIAL CHARACTER(S) and NUMBER(S) in your password and be at least 8 characters long)");
                }
            } else {
                throw new Exception("Invalid Email Address!");
            }
        }
    }

    /**
     * Generates a secret key for encryption.
     */
    private SecretKey generateKey() throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] keyBytes = sha.digest(ENCRYPTION_KEY.getBytes(StandardCharsets.UTF_8));
        return new SecretKeySpec(keyBytes, "AES");
    }

    /**
     * Encrypts a password.
     */
    public String encrypt(String password) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, generateKey());
        byte[] encryptedBytes = cipher.doFinal(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    /**
     * Decrypts an encrypted password.
     */
    public String decrypt(String encryptedPassword) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, generateKey());
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedPassword);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    /**
     * Finds a user by ID and returns the user.
     */
    public User findByIdAndReturnUser(String id) {
        User user = getAllUsers().stream().filter(t -> id.equals(t.getId())).findFirst().orElse(null);
        return user;
    }

    /**
     * Adds an age card to a user.
     */
    public User addAgeCard(AgeCard ageCard, String id) {
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

    /**
     * Adds a student card to a user.
     */
    public User addStudentCard(StudentCard studentCard, String id) {
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

    /**
     * Adds a driver's license to a user.
     */
    public User addDriversLicense(DriversLicense driversLicense, String id) {
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

    /**
     * Adds a passport card to a user.
     */
    public User addPassportCard(PassportCard passportCard, String id) {
        User user = findByIdAndReturnUser(id);
        if (user == null) {
            throw new IllegalStateException("User ID has not been registered!");
        }
        else {
            if (user.getCards().getPassportCard() == null) {
                user.getCards().setPassportCard(passportCard);
                userRepository.save(user);
                return user;
            }
            else {
                throw new IllegalStateException("Passport Card already exists!");
            }
        }
    }

    /**
     * Deletes a user by ID.
     */
    public void deleteUser(String id) throws Exception {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
        else {
            throw new Exception("User with this ID does not exist!");
        }
    }
}
