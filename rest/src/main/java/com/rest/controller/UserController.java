package com.rest.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rest.controller.exception.UserDataException;
import com.service.entities.UserService;
import com.service.entities.dto.UserDto;
import com.service.entities.exception.ValidationException;

@RestController
@ComponentScan("com.*")
public class UserController {

	@Autowired
	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@RequestMapping("/user")
	public UserDto getUser(@RequestParam(value = "email", defaultValue = "") String email) {
		return service.getEmail(email);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/add")
	public @ResponseStatus(value = HttpStatus.CREATED) void newUser(@RequestBody UserDtoRequest user) {

		UserDto userR = new UserDto(user.getNombre(), user.getApellido(), user.getEdad(), user.getInscriptionDate(),
				user.getTelefono(), user.getEmail(), user.getChangeBy());
		UserDto userDto;
		try {
			userDto = service.add(userR);
		} catch (ParseException | ValidationException e) {
			throw new UserDataException(userR);
		}

		System.out.println("test " + userDto.toString());
	}

}
