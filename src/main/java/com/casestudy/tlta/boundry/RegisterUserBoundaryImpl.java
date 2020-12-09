package com.casestudy.tlta.boundry;

import javax.persistence.PersistenceException;

import com.casestudy.tlta.dao.RegisterUserDao;
import com.casestudy.tlta.dao.RegisterUserDaoImpl;
import com.casestudy.tlta.entity.RegisterUser;
import com.casestudy.tlta.exception.LoginException;


public class RegisterUserBoundaryImpl implements RegisterUserBoundary{
	private RegisterUserDao loginDao= new RegisterUserDaoImpl();

	@Override
	public void addUser(RegisterUser login) throws LoginException {
		try {
			//validate product
			loginDao.addUser(login);			
		}catch(PersistenceException e) {
			throw new LoginException(e.getMessage(),e);
		}
		
	}

//	@Override
//	public void addModerator(RegisterUser login) throws LoginException {
//		try {
//			//validate product
//			loginDao.addModerator(login);			
//		}catch(PersistenceException e) {
//			throw new LoginException(e.getMessage(),e);
//		}
//		
//		
//	}
//
//	@Override
//	public void addAdmin(RegisterUser login) throws LoginException {
//		try {
//			//validate product
//			loginDao.addAdmin(login);			
//		}catch(PersistenceException e) {
//			throw new LoginException(e.getMessage(),e);
//		}
//		
//		
//	}

	@Override
	public RegisterUser getUserById(Integer id) throws LoginException {
		try {			
			RegisterUser login=loginDao.getUserById(id);
			return login;
		}catch(PersistenceException e) {
			throw new LoginException(e.getMessage(),e);
		}
	}

	@Override
	public RegisterUser getModeratorById(Integer id) throws LoginException {
		try {			
			RegisterUser login=loginDao.getModeratorById(id);
			return login;
		}catch(PersistenceException e) {
			throw new LoginException(e.getMessage(),e);
		}
	}

	@Override
	public Integer deleteUser(Integer id) throws LoginException {
		try {			
			Integer Id= loginDao.deleteUser(id);
			return Id;
		}catch(PersistenceException e) {
			throw new LoginException(e.getMessage(),e);
		}
	}
	

	
	@Override
	public RegisterUser updatePassword(RegisterUser login) throws LoginException {
			try { 
			
			RegisterUser updatedPassword= loginDao.updatePassword(login);
			
			return updatedPassword;
			}catch(PersistenceException e) {
			throw new LoginException(e.getMessage(),e);
			}
	}

	@Override
	public RegisterUser updateFirstName(RegisterUser firstName) throws LoginException {
		try {			
			RegisterUser updatedFirstName= 
					loginDao.updateFirstName(firstName);
			return updatedFirstName;
		}catch(PersistenceException e) {
			throw new LoginException(e.getMessage(),e);
		}
	}

	@Override
	public RegisterUser updateLastName(RegisterUser lastName) throws LoginException {
		try {			
			RegisterUser updatedLastName= 
					loginDao.updateFirstName(lastName);
			return updatedLastName;
		}catch(PersistenceException e) {
			throw new LoginException(e.getMessage(),e);
		}
	
}






}
