package com.service.entities;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import com.persistence.entities.impl.UserEntity;
import com.service.entities.dto.UserDto;

@ComponentScan("com.*")
public final class UserDtoDataset {

	// Disallow construction
	private UserDtoDataset() {
	}

	/**
	 * An array of five accounts that should exist in the database.
	 * 
	 * @return An array of four {@link UserEntity}
	 */
	public static UserDto[] newUsers() {
		return new UserDto[] {
				new UserDto(null, "nombre1", "apellido1", 54L, "13/09/2012", "654654321", "email1@smtp.fr", "TESTSYS"),
				new UserDto(null, "nombre2", "apellido2", 60L, "15/02/2017", "56421254", "email2@smtp.fr","TESTSYS"),
				new UserDto(null, "nombre3", "apellido3", 15L, "13/01/2018", "65487545", "email3@smtp.fr","TESTSYS"),
				new UserDto(null, "nombre4", "apellido4", 11L, "13/06/2014", "98745454", "email4@smtp.fr","TESTSYS"),
				new UserDto(null, "nombre5", "apellido5", 15L, "13/05/2015", "987987544", "emai15@smtp.fr","TESTSYS") };
	}

}
