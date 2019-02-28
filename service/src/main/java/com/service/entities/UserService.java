package com.service.entities;

import java.text.ParseException;
import java.util.List;

import com.service.entities.dto.UserDto;
import com.service.entities.exception.ValidationException;

public interface UserService {
	
	UserDto add(UserDto t)throws ParseException, ValidationException;
	
	boolean addAll(List<UserDto> t);
	
	UserDto getEmail(String name);
	
	boolean remove(String email);
	
	boolean update(UserDto dto);
	
	List<UserDto> getUsers();
	
	UserDto get(String id);

	UserDto findById(String id);

}
