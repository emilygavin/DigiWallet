package com.example.DigiWallet;

import org.springframework.beans.factory.annotation.Value;
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
	CommandLineRunner runner(){
		return args -> {};
	}

	@Value("${encryption.key}")
	private String ENCRYPTION_KEY;

	@Bean
	public String encryptionKey() {
		return ENCRYPTION_KEY;
	}
}
