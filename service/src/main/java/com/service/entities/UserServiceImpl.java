package com.service.entities;

import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.Application;
import com.persistence.entities.impl.UserEntity;
import com.persistence.entities.respository.UserRepository;
import com.service.entities.dto.UserDto;
import com.service.entities.dto.util.UserConverter;
import com.service.entities.exception.ValidationException;

@SpringBootConfiguration
@Import({ Application.class })
@EnableAutoConfiguration
@ComponentScan
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public UserDto add(UserDto dto) throws ParseException, ValidationException {
		UserEntity user = null;
		user = userRepository.save(UserConverter.getUserEntityNew(dto));
		return UserConverter.getUserDto(user);
	}

	//not used at the moment
	@Override
	public boolean remove(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	//not used at the moment
	@Override
	public boolean update(final UserDto dto) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	@Transactional
	public UserDto getEmail(final String email) {

		final List<UserEntity> users = userRepository.findByEmail(email);
		if (users == null || users.isEmpty()) {
			return null;
		}
		return UserConverter.getUserDto(users.get(0));
	}

	@Override
	public List<UserDto> getUsers() {
		return UserConverter.getUserDtos(userRepository.findAll());
	}

	//not used at the moment
	@Override
	public boolean addAll(List<UserDto> t) {
		return false;
	}

	//not used at the moment
	@Override
	public UserDto get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	//not used at the moment
	@Override
	public UserDto findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
