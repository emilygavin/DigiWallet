package com.example.DigiWallet;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
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

			AgeCard ageCard = new AgeCard("Age Card", "Emily Gavin", "05/04/2001", Gender.FEMALE, address, "123456");
			StudentCard studentCard = new StudentCard("Student Card","Emily Gavin", "31/03/2003", "DCU", "983923850", "Teaching", "31/08/2023");
			DriversLicense driversLicense = new DriversLicense("Drivers License","Emily Gavin", "05-04-2001", Gender.FEMALE, "IRELAND", "31-03-2013", "13-08-2028", "12345678", address, "Car");
			PassportCard passportCard = new PassportCard("Passport Card","Ireland", "Emily Gavin", "Irish", "05-04-2001", Gender.FEMALE, "14-12-2015", "24-06-2023");

			Cards cards = new Cards();
			cards.setAgeCard(ageCard);
			cards.setStudentCard(studentCard);
			cards.setPassportCard(passportCard);
			cards.setDriversLicense(driversLicense);

			List<User> users = Arrays.asList(
					new User("Emily Gavin", Gender.FEMALE, "emilygavin@hotmail.com", "Password123", cards)
			);

//			OkHttpClient client = new OkHttpClient().newBuilder().build();
//			MediaType mediaType = MediaType.parse("application/json");
//			RequestBody body = RequestBody.create(mediaType, "{\n    \"collection\":\"user\",\n    \"database\":\"digiwallet\",\n    \"dataSource\":\"DigiWalletCluster2\",\n    \"projection\": {\"_id\": 1}\n\n}");
//			Request request = new Request.Builder()
//					.url("https://eu-west-1.aws.data.mongodb-api.com/app/data-tgrxq/endpoint/data/v1/action/findOne")
//					.method("POST", body)
//					.addHeader("Content-Type", "application/json")
//					.addHeader("Access-Control-Request-Headers", "*")
//					.addHeader("api-key", "06hSUyPcpttJInXMG0VolbqAZVS8KNmLr7ueaIllMYpOTYvYCrQCxqJMARh5ayAH")
//					.build();
//			Response response = client.newCall(request).execute();

			//userRepository.insert(users);
		};
	}
}
