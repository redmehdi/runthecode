package com;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.persistence.entities.impl.UserEntity;
import com.persistence.entities.respository.UserRepository;

@SpringBootApplication
@ComponentScan({"com.*"})
@EntityScan("com.*")
@EnableJpaRepositories("com.*")
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

//	@Bean
//	public CommandLineRunner demo(UserRepository repository) {
//		return (args) -> {
//			// save a couple of customers
//			UserData
//			UserEntity user1 = UserDatas.newUsers()[1];
//			repository.save(user1);
//
//			// fetch all users
//			log.info("Users found with findAll():");
//			log.info("-------------------------------");
//			for (UserEntity user : repository.findAll()) {
//				log.info(user.toString());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
//			repository.findById(1L)
//				.ifPresent(user -> {
//					log.info("User found with findById(1L):");
//					log.info("--------------------------------");
//					log.info(user.toString());
//					log.info("");
//				});
//
//			// fetch user by last name
//			log.info("User found with findByLastName('apellido1'):");
//			log.info("--------------------------------------------");
//			repository.findByApellido("apellido1").forEach(apellido1 -> {
//				log.info(apellido1.toString());
//			});
//			// for (Customer bauer : repository.findByLastName("Bauer")) {
//			// 	log.info(bauer.toString());
//			// }
//			log.info("");
//		};
//	}

}
