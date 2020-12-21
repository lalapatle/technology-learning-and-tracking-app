package com.casestudy.tlta.boundry;

import java.util.List;

import com.casestudy.tlta.entity.RegisterUser;
import com.casestudy.tlta.exception.RegisterUserException;

public interface RegisterUserBoundary {
	
	public void addUser(RegisterUser login) throws RegisterUserException;
	public RegisterUser getUserById(Integer id) throws RegisterUserException;
	public RegisterUser getModeratorById(Integer id) throws RegisterUserException;
	public Integer deleteUser(Integer id) throws RegisterUserException;
	public RegisterUser updatePassword(RegisterUser login) throws RegisterUserException;
	public RegisterUser updateFirstName(RegisterUser  login) throws RegisterUserException;
	public RegisterUser updateLastName(RegisterUser login) throws RegisterUserException;
	public List<RegisterUser> getAllRegisteredUser() throws RegisterUserException;

	
	
//	public void addUser(RegisterUser login) throws RegisterUserException;
//	public void addModerator(RegisterUser login) throws RegisterUserException;
//	public void addAdmin(RegisterUser login) throws RegisterUserException;
//	public RegisterUser getUserById(Integer id) throws RegisterUserException;
//	public RegisterUser getModeratorById(Integer id) throws RegisterUserException;
//	public Integer deleteUser(Integer id) throws RegisterUserException;
//	public RegisterUser updatePassword(RegisterUser login) throws RegisterUserException;
//	public RegisterUser updateFirstName(RegisterUser firstName) throws RegisterUserException;
//	public RegisterUser updateLastName(RegisterUser lastName) throws RegisterUserException;
//	
	
	
}
