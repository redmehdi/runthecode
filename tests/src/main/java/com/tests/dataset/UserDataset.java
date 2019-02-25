package com.tests.dataset;

import java.util.Date;

import com.persistence.entities.impl.UserEntity;

public final class UserDataset {

	// Disallow construction
	private UserDataset() {
	}

	/**
	 * An array of five accounts that should exist in the database. 
	 * 
	 * @return An array of four {@link UserEntity}
	 */
	public static UserEntity[] newUsers() {
		return new UserEntity[] {
				new UserEntity("TESTSYS", "TESTSYS", ContactDataset.newContacts()[0], "nombre1", "apellido1", 45, new Date()),
				new UserEntity("TESTSYS", "TESTSYS", ContactDataset.newContacts()[1], "nombre2", "apellido2", 28, new Date()),
				new UserEntity("TESTSYS", "TESTSYS", ContactDataset.newContacts()[2], "nombre3", "apellido3", 16, new Date()),
				new UserEntity("TESTSYS", "TESTSYS", ContactDataset.newContacts()[3], "nombre4", "apellido4", 90, new Date()) };
	}

}
