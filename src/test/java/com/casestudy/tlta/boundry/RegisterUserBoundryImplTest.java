package com.casestudy.tlta.boundry;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.casestudy.tlta.dao.RegisterUserDaoImpl;
import com.casestudy.tlta.entity.RegisterUser;
import com.casestudy.tlta.exception.RegisterUserException;

@RunWith(MockitoJUnitRunner.class)
public class RegisterUserBoundryImplTest {

	@InjectMocks
	private RegisterUserBoundaryImpl register;

	@Mock
	private RegisterUserDaoImpl registerUserDaoImpl;

	@Test
	public void addUserTest() throws RegisterUserException
	{
		RegisterUser login = new RegisterUser();
		login.setId(1);
		login.setFirstName("raksha");
		login.setLastName("sorte");
		login.setEmailId("raksha@gmail.com");
		login.setPassword("123");
		login.setRole(null);
		if(register != null) {
			register.addUser(login);
			verify(registerUserDaoImpl, times(1)).addUser(login);
		}
	}

	@Test
	public void getUserByIdTest() throws RegisterUserException {
		RegisterUser login = new RegisterUser();
		login.setId(2);
		if(register != null) {
		register.getUserById(2);
		verify(registerUserDaoImpl, times(1)).getUserById(2);
		}

	}
	
	
		@Test
	void testGetModeratorById() throws RegisterUserException {
		RegisterUser login = new RegisterUser();
		login.setId(2);
		if(register != null) {
		register.getModeratorById(2);
		verify(registerUserDaoImpl, times(1)).getModeratorById(2);
		}
	}

	@Test
	void testDeleteUser() throws RegisterUserException {
		RegisterUser login = new RegisterUser();
		login.setId(2);
		if(register != null) {
		register.deleteUser(2);
		verify(registerUserDaoImpl, times(1)).deleteUser(2);
		}
	}

	@Test
	void testUpdatePassword() throws RegisterUserException {
		RegisterUser login = new RegisterUser();
		if(register != null) {
			if(login.getPassword() != null) {
			login.setPassword("abc");
			}
		
			register.updatePassword(login);
			verify(registerUserDaoImpl, times(1)).updatePassword(login);
		}
	}

	@Test
	void testUpdateFirstName() throws RegisterUserException {
		RegisterUser login = new RegisterUser();
		if(register != null) {
			if(login.getFirstName() != null) {
			login.setFirstName("Anubhuti");
			}
		
			register.updateFirstName(login);
			verify(registerUserDaoImpl, times(1)).updateFirstName(login);
		}
	}

	@Test
	void testUpdateLastName() throws RegisterUserException {
		RegisterUser login = new RegisterUser();
		if(register != null) {
			if(login.getLastName() != null) {
			login.setLastName("Rane");
			}
		
			register.updateLastName(login);
			verify(registerUserDaoImpl, times(1)).updateLastName(login);
		}
	}
	}



