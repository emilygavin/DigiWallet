package com.example.DigiWallet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
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

			List<Cards> card = new ArrayList<>();
			card.add(ageCard);
			card.add(studentCard);

			User user1 = new User("EmilyGavin@hotmail.com", "Password123", card);

			userRepository.insert(user1);
		};
	}
}
