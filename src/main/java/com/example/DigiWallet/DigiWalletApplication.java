package com.example.DigiWallet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DigiWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigiWalletApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepository userRepository){
		return args -> {
			Address address = new Address("Ros Ard", "Pool Boy", "Ballinasloe", "Galway", "Ireland", "H53 VX75");

			AgeCard ageCard = new AgeCard("Emily Gavin", "05/04/2001", Gender.FEMALE, address, "123456");
			StudentCard studentCard = new StudentCard("Emily Gavin", "31/03/2003", "DCU", "983923850", "Teaching", "31/08/2023");
			DriversLicense driversLicense = new DriversLicense("Emily Gavin", "05-04-2001", Gender.FEMALE, "IRELAND", "31-03-2013", "13-08-2028", "12345678", address, "Car");
			PassportCard passportCard = new PassportCard("Ireland", "Emily Gavin", "Irish", "05-04-2001", Gender.FEMALE, "14-12-2015", "24-06-2023");

			Cards cards = new Cards();
			cards.setAgeCard(ageCard);
			cards.setStudentCard(studentCard);
			cards.setPassportCard(passportCard);
			cards.setDriversLicense(driversLicense);

			List<User> users = Arrays.asList(
					new User("3948gujv028v2b35inj3", "emilygavin@hotmail.com", "Password123", cards)
			);

			//userRepository.insert(users);
		};
	}
}
