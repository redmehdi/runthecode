package com.service.entities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.entities.dto.UserDto;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan({"com.*"})
@EntityScan("com.*")
@EnableJpaRepositories("com.*")
public class UserServiceTests {
	
    @Autowired
    private UserService UserService;

    @Test
    public void testFindByLastName() {
    	boolean user= UserService.add(UserDtoDataset.newUsers()[0]);
    	UserDto test= null;
		if(user = true)
    		test = UserService.getEmail("email1@smtp.fr");

//        assertThat(findByLastName).extracting(CustomerEntity::getLastName).containsOnly(customer.getLastName());
    }
}
