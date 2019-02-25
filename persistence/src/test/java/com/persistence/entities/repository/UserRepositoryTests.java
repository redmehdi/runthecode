package com.persistence.entities.repository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.persistence.entities.impl.ContactEntity;
import com.persistence.entities.impl.UserEntity;
import com.persistence.entities.repository.dataset.UserDataset;
import com.persistence.entities.respository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository users;
	
	@Test
	public void testFindByLastName() {
		UserEntity newUser = UserDataset.newUsers()[0];
		entityManager.merge(newUser);
		List<UserEntity> findByLastName = users.findByApellido(newUser.getApellido());
		assertThat(findByLastName).extracting(UserEntity::getApellido).containsOnly(newUser.getApellido());
	}
	
	@Test
	public void testFindByEmail() {
		UserEntity newUser = UserDataset.newUsers()[3];
		entityManager.persist(newUser);
		List<UserEntity> findByLastName = users.findByEmail(newUser.getContact().getEmail());
//		assertThat(findByLastName.get(0).getContact()).extracting(ContactEntity::getEmail).containsOnly(newUser.getContact().getEmail());
	}

	@Test
	public void testCreateNewUser() {
//		CustomerEntity customer1 = ContactDataset.newCustomers()[0];
//		entityManager.persist(customer1);
//		assertThat(findById.get()).extracting(CustomerEntity::getEmail).containsOnly(customer1.getEmail());
	}

	@Test
	public void testCreateAccountForUser() {
//		CustomerEntity customer1 = new CustomerEntity("Redouane", "Redouane", "nameuser1", "lastname1",
//				"nameuser1@sdsad.com");
//		UserEntity account1 = UserDataset.newAccounts()[0];
//		customer1.setAccount(account1);
//		entityManager.persist(customer1);
//
//		List<CustomerEntity> accountUser = users.findByLastName(customer1.getLastName());
//
//		assertThat(accountUser).extracting(CustomerEntity::getAccount).containsOnly(account1);
	}

	@Test
	public void testCreateUserDesposit() {
//		CustomerEntity customer1  = ContactDataset.newCustomers()[1];
//		UserEntity accountUser = UserDataset.newAccounts()[1];
//		customer1.setAccount(accountUser);
//		entityManager.persist(customer1);
//		
//		// deposit money
//		//retrieve user
//		Optional<CustomerEntity> userCustomer = users.findById(customer1.getId());
//		UserEntity accountEntity = userCustomer !=null? userCustomer.get().getAccount():null;
//		RecordEntity record = RecordDataset.newRecords()[0];
//		record.setAccount(accountEntity);
//		accountUser.addRecored(record);
//		
//		entityManager.persist(record);
//		
//
//		assertThat(userCustomer.get().getAccount().getRecords()).extracting(RecordEntity::getAmount).containsOnly(record.getAmount());
	}
//
//	@Test
//	public void testCreateUserWithDrawal() {
//		CustomerEntity customer1 = new CustomerEntity("Redouane", "Redouane", "nameuser1", "lastname1",
//				"nameuser1@sdsad.com");
//		AccountEntity accountFirst = new AccountEntity("redouane", "Redouane", customer1, BigDecimal.valueOf(233424233),
//				"EURO");
//		customer1.setAccount(accountFirst);
//		RecordEntity record = new RecordEntity(BigDecimal.valueOf(874398709L), BigDecimal.valueOf(398423874398709L),
//				TransnationalType.DEPOSIT, "redouane", "redouane");
//		customer1.setAccount(accountFirst);
//		entityManager.persist(customer1);
//		accountFirst.addRecored(record);
//		entityManager.persist(accountFirst);
//
//		List<CustomerEntity> findByLastName = customers.findByLastName(customer1.getLastName());
//
//		assertThat(findByLastName).extracting(CustomerEntity::getLastName).containsOnly(customer1.getLastName());
//	}

}