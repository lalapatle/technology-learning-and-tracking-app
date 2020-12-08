package com.casestudy.tlta.boundry;

import javax.persistence.PersistenceException;

import com.casestudy.tlta.entity.RegisterUser;
import com.casestudy.tlta.exception.LoginException;

public interface LoginBoundary {
	public void addUser(RegisterUser login) throws LoginException;
	public void addModerator(RegisterUser login) throws LoginException;
	public void addAdmin(RegisterUser login) throws LoginException;
	public RegisterUser getUserById(Integer id) throws LoginException;
	public RegisterUser getModeratorById(Integer id) throws LoginException;
	public long deleteUser(Integer id) throws LoginException;
	public RegisterUser updatePassword(RegisterUser login) throws LoginException;
	public RegisterUser updateFirstName(RegisterUser firstName) throws LoginException;
	public RegisterUser updateLastName(RegisterUser lastName) throws LoginException;
	
}
