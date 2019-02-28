package com.service.entities;

import org.springframework.context.annotation.ComponentScan;

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
				new UserDto("nombre1", "apellido1", "54", "13/09/2012", "654654321", "email1@smtp.fr", "TESTSYS"),
				new UserDto("nombre2", "apellido2", "60", "15/02/2017", "56421254", "email2@smtp.fr","TESTSYS"),
				new UserDto("nombre3", "apellido3", "15", "13/01/2018", "65487545", "email3@smtp.fr","TESTSYS"),
				new UserDto("nombre4", "apellido4", "11", "13/06/2014", "98745454", "email4@smtp.fr","TESTSYS"),
				new UserDto("nombre5", "apellido5", "15", "13/05/2015", "987987544", "emai15@smtp.fr","TESTSYS"),
				new UserDto("nombre6", "apellido6", "28", "13/05/2013", "93487987544", "emai15@smtp","TESTSYS"), /** incorrect email*/
				new UserDto("nombre6", "apellido6", "28", "13/05/2013", "000018289384er499", "emai15@smtp.ma","TESTSYS"), /** incorrect mobile phone*/
				};
	}

}
