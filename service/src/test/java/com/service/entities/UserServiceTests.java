package com.service.entities;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.entities.dto.UserDto;
import com.service.entities.exception.ValidationException;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan({ "com.*" })
@EntityScan("com.*")
@EnableJpaRepositories("com.*")
public class UserServiceTests {

	@Autowired
	private UserService userService;

	@Test
	public void testFindByLastName() {
		UserDto user = null;
		try {
			user = userService.add(UserDtoDataset.newUsers()[0]);
		}
		catch (ParseException | ValidationException e) {
		}
		UserDto retrievedUser = userService.getEmail("email1@smtp.fr");

		assertThat(retrievedUser).extracting(UserDto::getNombre).containsOnly(user.getNombre());
	}

	@Test
	public void testCreationNewUser() {
		final UserDto newUser = UserDtoDataset.newUsers()[0];
		UserDto storedUser = null;
		try {
			storedUser = userService.add(newUser);
		}
		catch (ParseException | ValidationException e) {
		}
		assertThat(storedUser).isNotNull();
	}

	@Test
	public void testFindByEmail() {
		final UserDto newUser = UserDtoDataset.newUsers()[0];
		try {
			userService.add(newUser);
		}
		catch (ParseException | ValidationException e) {
		}
		UserDto findByEmail = userService.getEmail(newUser.getEmail());
		assertThat(findByEmail).extracting(UserDto::getEmail).containsOnly(newUser.getEmail());
	}

	@Test
	public void testCountStoreData() {
		UserDto newUser0 = UserDtoDataset.newUsers()[3];
		UserDto newUser1 = UserDtoDataset.newUsers()[2];
		UserDto newUser2 = UserDtoDataset.newUsers()[1];

		// insert three users
		try {
			userService.add(newUser0);
			userService.add(newUser1);
			userService.add(newUser2);
		}
		catch (ParseException | ValidationException e) {
		}

		List<UserDto> userList = userService.getUsers();
		assertThat(userList).hasSize(3);
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void testDuplicatedUserData() {
		UserDto newUser0 = UserDtoDataset.newUsers()[1];
		UserDto newUser1 = UserDtoDataset.newUsers()[1];

		// insert two users with the same data user
		try {
			userService.add(newUser0);
			userService.add(newUser1);
		}
		catch (ParseException | ValidationException e) {
		}

		UserDto findByEmail = userService.getEmail(newUser0.getEmail());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testStoredUserWithIncorrectEmail() {
		UserDto newUser0 = UserDtoDataset.newUsers()[5];

		// insert user with incorrect email
		try {
			userService.add(newUser0);
		}
		catch (ParseException | ValidationException e) {
		}

		UserDto findByEmail = userService.getEmail(newUser0.getEmail());
	}

}
