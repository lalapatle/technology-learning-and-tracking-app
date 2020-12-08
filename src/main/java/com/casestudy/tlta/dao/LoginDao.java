package com.casestudy.tlta.dao;

import javax.persistence.PersistenceException;

import com.casestudy.tlta.entity.Login;

public interface LoginDao {

	public void addUser(Login login) throws PersistenceException;

	public void addModerator(Login login) throws PersistenceException;

	public void addAdmin(Login login) throws PersistenceException;

	public Login getUserById(Integer id) throws PersistenceException;

	public Login getModeratorById(Integer id) throws PersistenceException;

	public long deleteUser(Integer id) throws PersistenceException;

	public Login updatePassword(Login login) throws PersistenceException;

	public Login updatePassword(Login login, String email, String lastName) throws PersistenceException;

	public Login updateFirstName(Login login) throws PersistenceException;

	public Login updateLastName(Login login) throws PersistenceException;

}