package com.casestudy.tlta.boundry;

import javax.persistence.PersistenceException;

import com.casestudy.tlta.entity.Login;
import com.casestudy.tlta.exception.LoginException;

public interface LoginBoundary {
	public void addUser(Login login) throws LoginException;
	public void addModerator(Login login) throws LoginException;
	public void addAdmin(Login login) throws LoginException;
	public Login getUserById(Integer id) throws LoginException;
	public Login getModeratorById(Integer id) throws LoginException;
	public long deleteUser(Integer id) throws LoginException;
	public Login updatePassword(Login login, String firstName, String lastName) throws LoginException;
	public Login updateFirstName(Login firstName) throws LoginException;
	public Login updateLastName(Login lastName) throws LoginException;
}
