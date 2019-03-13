package org.praveenmk.microservice.learn.userdetails;

import org.praveenmk.microservice.learn.userdetails.model.UserDetails;
import org.praveenmk.microservice.learn.userdetails.repository.UserDetailsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class UserDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDetailsApplication.class, args);
	}

	@Bean
	public CommandLineRunner setup(UserDetailsRepository userDetailsRepository) {
		return (args) -> {
			userDetailsRepository.save(new UserDetails("Praveen", "praveen.mk@outlook.com", "7356091889" ));
			userDetailsRepository.save(new UserDetails("Praveen -1 ", "praveen.mk-1@outlook.com", "7356091889" ));
			userDetailsRepository.save(new UserDetails("Praveen -2", "praveen.mk-2@outlook.com", "7356091889" ));
		};
	}

}
