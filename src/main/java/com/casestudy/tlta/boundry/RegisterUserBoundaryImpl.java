package com.casestudy.tlta.boundry;

import java.util.List;

import javax.persistence.PersistenceException;

import com.casestudy.tlta.dao.RegisterUserDao;
import com.casestudy.tlta.dao.RegisterUserDaoImpl;
import com.casestudy.tlta.entity.RegisterUser;
import com.casestudy.tlta.exception.RegisterUserException;


public  class RegisterUserBoundaryImpl implements RegisterUserBoundary{
	private RegisterUserDao loginDao= new RegisterUserDaoImpl();

	@Override
	public void addUser(RegisterUser login) throws RegisterUserException {
		try {
			//validate product
			loginDao.addUser(login);			
		}catch(PersistenceException e) {
			throw new RegisterUserException(e.getMessage(),e);
		}
		
	}


	@Override
	public RegisterUser getUserById(Integer id) throws RegisterUserException {
		try {			
			RegisterUser login=loginDao.getUserById(id);
			return login;
		}catch(PersistenceException e) {
			throw new RegisterUserException(e.getMessage(),e);
		}
	}

	@Override
	public RegisterUser getModeratorById(Integer id) throws RegisterUserException {
		try {			
			RegisterUser login=loginDao.getModeratorById(id);
			return login;
		}catch(PersistenceException e) {
			throw new RegisterUserException(e.getMessage(),e);
		}
	}

	@Override
	public Integer deleteUser(Integer id) throws RegisterUserException {
		try {			
			Integer Id= loginDao.deleteUser(id);
			return Id;
		}catch(PersistenceException e) {
			throw new RegisterUserException(e.getMessage(),e);
		}
	}
	

	
	@Override
	public RegisterUser updatePassword(RegisterUser login) throws RegisterUserException {
			try { 
			
			RegisterUser updatedPassword= loginDao.updatePassword(login);
			
			return updatedPassword;
			}catch(PersistenceException e) {
			throw new RegisterUserException(e.getMessage(),e);
			}
	}

	@Override
	public RegisterUser updateFirstName(RegisterUser firstName) throws RegisterUserException {
		try {			
			RegisterUser updatedFirstName= 
					loginDao.updateFirstName(firstName);
			return updatedFirstName;
		}catch(PersistenceException e) {
			throw new RegisterUserException(e.getMessage(),e);
		}
	}

	@Override
	public RegisterUser updateLastName(RegisterUser lastName) throws RegisterUserException {
		try {			
			RegisterUser updatedLastName= 
					loginDao.updateFirstName(lastName);
			return updatedLastName;
		}catch(PersistenceException e) {
			throw new RegisterUserException(e.getMessage(),e);
		}
	
}

	public List<RegisterUser> getAllRegisteredUser() throws RegisterUserException{
		try {			
			List<RegisterUser> assessmentList= 
					loginDao.getAllRegisteredUser();
			return assessmentList;
		}catch(PersistenceException e) {
			throw new RegisterUserException(e.getMessage(),e);
		}
		
	}




}
