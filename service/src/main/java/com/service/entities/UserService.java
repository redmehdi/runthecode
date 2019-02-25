package com.service.entities;

import java.util.List;

import com.service.entities.dto.UserDto;

public interface UserService {
	
	boolean add(UserDto t);
	
	boolean addAll(List<UserDto> t);
	
	UserDto getEmail(String name);
	
	boolean remove(Long amount);
	
	boolean update(UserDto dto);
	
	List<UserDto> getUsers();

}
