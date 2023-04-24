package com.example.DigiWallet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DigiWalletApplicationTests {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void getAllUsers() {
		List<User> userList = new ArrayList<>();
		userList.add(new User("John Doe", Gender.MALE, "johndoe@example.com", "password", null));
		when(userRepository.findAll()).thenReturn(userList);
		List<User> result = userService.getAllUsers();
		assertEquals(userList, result);
	}

	@Test
	public void getUserWithValidCredentials() throws Exception {
		User user = new User("John Doe", Gender.MALE, "johndoe@example.com", "password", null);
		when(userRepository.findByEmail("johndoe@example.com")).thenReturn(user);
		User result = userService.getUser("johndoe@example.com", "password");
		assertEquals(user, result);
	}

	@Test
	public void getUserWithInvalidCredentials() {
		assertThrows(Exception.class, () -> {
			when(userRepository.findByEmail("johndoe@example.com")).thenReturn(null);
			userService.getUser("johndoe@example.com", "password");
		});
	}

	@Test
	public void addNewUserWithValidEmailAndPassword() throws Exception {
		User user = new User("John Doe", Gender.MALE, "johndoe@example.com", "password!123", null);
		when(userRepository.findByEmail("johndoe@example.com")).thenReturn(null);
		when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
		User result = userService.addNewUser(user);
		assertEquals(user, result);
	}

	@Test
	public void addNewUserWithInvalidEmail() {
		User user = new User("John Doe", Gender.MALE, "johndoeexample.com", "password", null);
		assertThrows(Exception.class, () -> {
			userService.addNewUser(user);
		});
	}

	@Test
	public void addNewUserWithInvalidPassword() {
		User user = new User("John Doe", Gender.MALE, "johndoe@example.com", "pass", null);
		assertThrows(Exception.class, () -> {
			userService.addNewUser(user);
		});
	}

	@Test
	void testAddAgeCardWithValidInputs() throws Exception {
		// Arrange
		User user = new User("uh3o8yt4293h2p4hug", "John Doe", Gender.MALE, "johndoe@example.com", "password", null);
		userRepository.save(user);
		String id = user.getId();
		AgeCard ageCard = new AgeCard("type", "name", "2000-01-01", Gender.MALE, "12345678");

		// Act
		User result = userService.addAgeCard(ageCard, id);

		// Assert
		assertNotNull(result);
		assertEquals(ageCard, result.getCards().getAgeCard());
	}

	@Test
	void testAddAgeCardWithInvalidInputs() throws Exception {
		// Arrange
		String id = "validId";
		User user = new User("John Doe", Gender.MALE, "johndoe@example.com", "password", null);
		AgeCard ageCard = new AgeCard("type", "name", "2000-01-01", Gender.MALE, "1234");

		when(userRepository.existsById(id)).thenReturn(true);
		when(userRepository.findById(id)).thenReturn(Optional.of(user));

		// Act and Assert
		assertThrows(Exception.class, () -> userService.addAgeCard(ageCard, id));
	}

	@Test
	void testAddStudentCardWithValidInputs() throws Exception {
		// Arrange
		String id = "validId";
		User user = new User("John Doe", Gender.MALE, "johndoe@example.com", "password", null);
		StudentCard studentCard = new StudentCard("type", "name", "2000-01-01", "college", "123456", "courseTitle", "2022-01-01");

		when(userRepository.existsById(id)).thenReturn(true);
		when(userRepository.findById(id)).thenReturn(Optional.of(user));
		when(userRepository.save(user)).thenReturn(user);

		// Act
		User result = userService.addStudentCard(studentCard, id);

		// Assert
		assertNotNull(result);
		assertEquals(studentCard, result.getCards().getStudentCard());
	}

	@Test
	void testAddStudentCardWithInvalidInputs() throws Exception {
		// Arrange
		String id = "validId";
		User user = new User("John Doe", Gender.MALE, "johndoe@example.com", "password", null);
		StudentCard studentCard = new StudentCard("type", "name", "2000-01-01", "college", "1234", "courseTitle", "2022-01-01");

		when(userRepository.existsById(id)).thenReturn(true);
		when(userRepository.findById(id)).thenReturn(Optional.of(user));

		// Act and Assert
		assertThrows(Exception.class, () -> userService.addStudentCard(studentCard, id));
	}

	@Test
	void testAddDriversLicenseWithValidInputs() throws Exception {
		// Arrange
		String id = "validId";
		User user = new User("John Doe", Gender.MALE, "johndoe@example.com", "password", null);
		DriversLicense driversLicense = new DriversLicense("type", "name", "2000-01-01", Gender.MALE, "USA", "2020-01-01", "2025-01-01", "123456", new Address("123 Main St", "Apt 1", "Anytown", "AnyState"), "Class C");

		when(userRepository.existsById(id)).thenReturn(true);
		when(userRepository.findById(id)).thenReturn(Optional.of(user));
		when(userRepository.save(user)).thenReturn(user);

		// Act
		User result = userService.addDriversLicense(driversLicense, id);

		// Assert
		assertNotNull(result);
		assertEquals(driversLicense, result.getCards().getDriversLicense());
	}

	@Test
	void testAddDriversLicenseWithInvalidInputs() throws Exception {
		// Arrange
		String id = "validId";
		User user = new User("John Doe", Gender.MALE, "johndoe@example.com", "password", null);
		DriversLicense driversLicense = new DriversLicense("type", "name", "2000-01-01", Gender.MALE, "USA", "2020-01-01", "2025-01-01", "12", new Address("123 Main St", "Apt 1", "Anytown", "AnyState"), "Class C");

		when(userRepository.existsById(id)).thenReturn(true);
		when(userRepository.findById(id)).thenReturn(Optional.of(user));

		// Act and Assert
		assertThrows(Exception.class, () -> userService.addDriversLicense(driversLicense, id));
	}

	@Test
	void testAddPassportCardWithValidInputs() throws Exception {
		// Arrange
		String id = "validId";
		User user = new User("John Doe", Gender.MALE, "johndoe@example.com", "password", null);
		PassportCard passportCard = new PassportCard("type", "USA", "name", "American", "123456", "2000-01-01", Gender.MALE, "2020-01-01", "2025-01-01");

		when(userRepository.existsById(id)).thenReturn(true);
		when(userRepository.findById(id)).thenReturn(Optional.of(user));
		when(userRepository.save(user)).thenReturn(user);

		// Act
		User result = userService.addPassportCard(passportCard, id);

		// Assert
		assertNotNull(result);
		assertEquals(passportCard, result.getCards().getPassportCard());
	}

	@Test
	void testAddPassportCardWithInvalidInputs() throws Exception {
		// Arrange
		String id = "validId";
		User user = new User("John Doe", Gender.MALE, "johndoe@example.com", "password", null);
		PassportCard passportCard = new PassportCard("type", "USA", "name", "American", "12", "2000-01-01", Gender.MALE, "2020-01-01", "2025-01-01");

		when(userRepository.existsById(id)).thenReturn(true);
		when(userRepository.findById(id)).thenReturn(Optional.of(user));

		// Act and Assert
		assertThrows(Exception.class, () -> userService.addPassportCard(passportCard, id));
	}
}
