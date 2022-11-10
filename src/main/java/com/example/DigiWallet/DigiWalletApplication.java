package com.example.DigiWallet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DigiWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigiWalletApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepository userRepository){
		return args -> {
			Address address = new Address("Ros Ard", "Pool Boy", "Ballinasloe", "Galway", "Ireland", "H53 VX75");
			AgeCard ageCard = new AgeCard("Kayla Waldron", "05/04/2001", Gender.FEMALE, address, "123456");
			StudentCard studentCard = new StudentCard("Kayla Waldron", "31/03/2003", "DCU", "983923850", "Teaching", "31/08/2023");
			Cards card1 = new Cards(ageCard);
			Cards card2 = new Cards(studentCard);
			User user1 = new User("kaylawaldronn@hotmail.com", "Password123", card1);
			User user2 = new User("kaylawaldronn@hotmail.com", "Password123", card2);

			userRepository.insert(user1);
			userRepository.insert(user2);
		};
	}
}
