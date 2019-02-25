package com.service.entities;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.Application;
import com.persistence.entities.impl.UserEntity;
import com.persistence.entities.respository.UserRepository;
import com.service.entities.dto.UserDto;
import com.service.entities.dto.util.UserConverter;

@Service
@ComponentScan({"com.*"})
@EntityScan("com.*")
@EnableJpaRepositories("com.*")
@ContextConfiguration(classes = Application.class, loader = AnnotationConfigContextLoader.class)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public boolean add(UserDto dto) {
		try {
			userRepository.save(UserConverter.getUserEntity(dto));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(Long amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UserDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public UserDto getEmail(String email) {

		final List<UserEntity> users = userRepository.findByEmail(email);
		if (users == null || users.isEmpty()) {
			return null;
		}
		return UserConverter.getUserDto(users.get(0));
	}

	@Override
	public List<UserDto> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAll(List<UserDto> t) {
		return false;
	}

}
