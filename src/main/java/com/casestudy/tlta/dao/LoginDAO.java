package com.casestudy.tlta.dao;

import javax.persistence.PersistenceException;

import com.casestudy.tlta.entity.Login;

public interface LoginDAO {
	public void addUser(Login login) throws PersistenceException;
	public void addModerator(Login login) throws PersistenceException;
	public void addAdmin(Login login) throws PersistenceException;
	public Login getUserById(Integer id) throws PersistenceException;
	public Login getModeratorById(Integer id) throws PersistenceException;
	public long deleteUser(Integer id) throws PersistenceException;
	public Login updatePassword(Login login, String firstName, String lastName) throws PersistenceException;
	public Login updateFirstName(String firstName) throws PersistenceException;
	public Login updateLastName(String lastName) throws PersistenceException;
}
