package com.casestudy.tlta.boundry;

import javax.persistence.PersistenceException;

import com.casestudy.tlta.dao.LoginDao;
import com.casestudy.tlta.dao.LoginDaoImpl;
import com.casestudy.tlta.entity.Login;
import com.casestudy.tlta.exception.LoginException;


public class LoginBoundaryImpl implements LoginBoundary{
	private LoginDao loginDao= new LoginDaoImpl();

	@Override
	public void addUser(Login login) throws LoginException {
		try {
			//validate product
			loginDao.addUser(login);			
		}catch(PersistenceException e) {
			throw new LoginException(e.getMessage(),e);
		}
		
	}

	@Override
	public void addModerator(Login login) throws LoginException {
		try {
			//validate product
			loginDao.addModerator(login);			
		}catch(PersistenceException e) {
			throw new LoginException(e.getMessage(),e);
		}
		
		
	}

	@Override
	public void addAdmin(Login login) throws LoginException {
		try {
			//validate product
			loginDao.addAdmin(login);			
		}catch(PersistenceException e) {
			throw new LoginException(e.getMessage(),e);
		}
		
		
	}

	@Override
	public Login getUserById(Integer id) throws LoginException {
		try {			
			Login login=loginDao.getUserById(id);
			return login;
		}catch(PersistenceException e) {
			throw new LoginException(e.getMessage(),e);
		}
	}

	@Override
	public Login getModeratorById(Integer id) throws LoginException {
		try {			
			Login login=loginDao.getModeratorById(id);
			return login;
		}catch(PersistenceException e) {
			throw new LoginException(e.getMessage(),e);
		}
	}

	@Override
	public long deleteUser(Integer id) throws LoginException {
		try {			
			long Id= loginDao.deleteUser(id);
			return Id;
		}catch(PersistenceException e) {
			throw new LoginException(e.getMessage(),e);
		}
	}
	

	
	@Override
	public Login updatePassword(Login login) throws LoginException {
			try { 
			
			Login updatedPassword= loginDao.updatePassword(login);
			
			return updatedPassword;
			}catch(PersistenceException e) {
			throw new LoginException(e.getMessage(),e);
			}
	}

	@Override
	public Login updateFirstName(Login firstName) throws LoginException {
		try {			
			Login updatedFirstName= 
					loginDao.updateFirstName(firstName);
			return updatedFirstName;
		}catch(PersistenceException e) {
			throw new LoginException(e.getMessage(),e);
		}
	}

	@Override
	public Login updateLastName(Login lastName) throws LoginException {
		try {			
			Login updatedLastName= 
					loginDao.updateFirstName(lastName);
			return updatedLastName;
		}catch(PersistenceException e) {
			throw new LoginException(e.getMessage(),e);
		}
	
}






}
