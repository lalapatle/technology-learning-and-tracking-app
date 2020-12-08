
package com.casestudy.tlta.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.casestudy.tlta.entity.Login;

//public class LoginDaoImpl implements LoginDao{
//	
//	
//	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-and-tracking-app")	;	
//
//	@Override
//	public void addUser(Login login) throws PersistenceException {
//		// TODO Auto-generated method stub
//		EntityManager entityManager=emf.createEntityManager();
//		try {			
//			entityManager.getTransaction().begin();
//			entityManager.persist(login);
//			entityManager.flush();
//			entityManager.getTransaction().commit();			
//		}catch(PersistenceException e) {
//			entityManager.getTransaction().rollback();
//			throw e;
//		}catch(Exception e) {
//			throw e;
//		}finally {
//			entityManager.close();
//		}	
//		
//	}
//	@Override
//	public Login getUserById(Integer id) throws PersistenceException {
//		// TODO Auto-generated method stub
//		EntityManager entityManager=emf.createEntityManager();
//		try {
//
//			Login login =
//					entityManager.find(Login.class, id);			
//
//			return login;
//		}catch(PersistenceException e) {
//			throw e;
//		}catch(Exception e) {
//			throw e;
//		}finally {
//			entityManager.close();
//		}	
//		
//	}
//	@Override
//	public long deleteUser(Integer id) throws PersistenceException {
//		// TODO Auto-generated method stub
//		EntityManager entityManager=emf.createEntityManager();
//		try {
//			entityManager.getTransaction().begin();
//			Login login= 
//					entityManager.find(Login.class, id);
//			entityManager.remove(id);
//			entityManager.getTransaction().commit();	
//			return login.getId();
//		}catch(PersistenceException e) {
//			entityManager.getTransaction().rollback();
//			throw e;
//		}catch(Exception e) {
//			throw e;
//		}finally {
//			entityManager.close();
//		}	
//	}
//	
//	@Override
//	public Login updatePassword(Login login, String firstName, String lastName) throws PersistenceException {
//		// TODO Auto-generated method stub
//		EntityManager entityManager=emf.createEntityManager();
//		try {
//			entityManager.getTransaction().begin();
//			Login updatePassword= 
//					entityManager.merge(login);			
//			entityManager.flush();
//			entityManager.getTransaction().commit();	
//			return updatePassword;
//		}catch(PersistenceException e) {
//			entityManager.getTransaction().rollback();
//			throw e;
//		}catch(Exception e) {
//			throw e;
//		}finally {
//			entityManager.close();
//		}	
//	}
//	
//	@Override
//	public void addModerator(Login login) throws PersistenceException {
//		// TODO Auto-generated method stub
//		EntityManager entityManager=emf.createEntityManager();
//		try {			
//			entityManager.getTransaction().begin();
//			entityManager.persist(login);
//			entityManager.flush();
//			entityManager.getTransaction().commit();			
//		}catch(PersistenceException e) {
//			entityManager.getTransaction().rollback();
//			throw e;
//		}catch(Exception e) {
//			throw e;
//		}finally {
//			entityManager.close();
//		}	
//	}
//	@Override
//	public void addAdmin(Login login) throws PersistenceException {
//		// TODO Auto-generated method stub
//		EntityManager entityManager=emf.createEntityManager();
//		try {			
//			entityManager.getTransaction().begin();
//			entityManager.persist(login);
//			entityManager.flush();
//			entityManager.getTransaction().commit();			
//		}catch(PersistenceException e) {
//			entityManager.getTransaction().rollback();
//			throw e;
//		}catch(Exception e) {
//			throw e;
//		}finally {
//			entityManager.close();
//		}	
//	}
//
//	@Override
//	public Login getModeratorById(Integer id) throws PersistenceException {
//		// TODO Auto-generated method stub
//		EntityManager entityManager=emf.createEntityManager();
//		try {
//
//			Login login =
//					entityManager.find(Login.class, id);			
//
//			return login;
//		}catch(PersistenceException e) {
//			throw e;
//		}catch(Exception e) {
//			throw e;
//		}finally {
//			entityManager.close();
//		}	
//	}
//
//	@Override
//	public Login updateFirstName(Login login) throws PersistenceException {
//		// TODO Auto-generated method stub
//		EntityManager entityManager=emf.createEntityManager();
//		try {
//			entityManager.getTransaction().begin();
//			Login updateFirstName= 
//					entityManager.merge(login);			
//			entityManager.flush();
//			entityManager.getTransaction().commit();	
//			return updateFirstName;
//		}catch(PersistenceException e) {
//			entityManager.getTransaction().rollback();
//			throw e;
//		}catch(Exception e) {
//			throw e;
//		}finally {
//			entityManager.close();
//		}	
//        
//	}
//	
//	@Override
//	public Login updateLastName(Login login) throws PersistenceException {
//		// TODO Auto-generated method stub
//		EntityManager entityManager=emf.createEntityManager();
//		try {
//			entityManager.getTransaction().begin();
//			Login updateLastName= 
//					entityManager.merge(login);			
//			entityManager.flush();
//			entityManager.getTransaction().commit();	
//			return updateLastName;
//		}catch(PersistenceException e) {
//			entityManager.getTransaction().rollback();
//			throw e;
//		}catch(Exception e) {
//			throw e;
//		}finally {
//			entityManager.close();
//		}	
//        
//	}
//}
//=======



public class LoginDaoImpl implements LoginDao{


	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-and-tracking-app")	;	

	@Override
	public void addUser(Login login) throws PersistenceException {
		// TODO Auto-generated method stub
		EntityManager entityManager=emf.createEntityManager();
		try {			
			entityManager.getTransaction().begin();
			entityManager.persist(login);
			entityManager.flush();
			entityManager.getTransaction().commit();			
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			throw e;
		}catch(Exception e) {
			throw e;
		}finally {
			entityManager.close();
		}	

	}
	@Override
	public void addModerator(Login login) throws PersistenceException {
		// TODO Auto-generated method stub
		EntityManager entityManager=emf.createEntityManager();
		try {			
			entityManager.getTransaction().begin();
			entityManager.persist(login);
			entityManager.flush();
			entityManager.getTransaction().commit();			
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			throw e;
		}catch(Exception e) {
			throw e;
		}finally {
			entityManager.close();
		}	
	}

	@Override
	public void addAdmin(Login login) throws PersistenceException {
		// TODO Auto-generated method stub
		EntityManager entityManager=emf.createEntityManager();
		try {			
			entityManager.getTransaction().begin();
			entityManager.persist(login);
			entityManager.flush();
			entityManager.getTransaction().commit();			
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			throw e;
		}catch(Exception e) {
			throw e;
		}finally {
			entityManager.close();
		}	
	}

	@Override
	public Login getUserById(Integer id) throws PersistenceException {
		// TODO Auto-generated method stub
		EntityManager entityManager=emf.createEntityManager();
		try {

			Login login =
					entityManager.find(Login.class, id);			

			return login;
		}catch(PersistenceException e) {
			throw e;
		}catch(Exception e) {
			throw e;
		}finally {
			entityManager.close();
		}	

	}
	@Override
	public Login getModeratorById(Integer id) throws PersistenceException {
		// TODO Auto-generated method stub
		EntityManager entityManager=emf.createEntityManager();
		try {

			Login login =
					entityManager.find(Login.class, id);			

			return login;
		}catch(PersistenceException e) {
			throw e;
		}catch(Exception e) {
			throw e;
		}finally {
			entityManager.close();
		}	
	}
	@Override
	public long deleteUser(Integer id) throws PersistenceException {
		// TODO Auto-generated method stub
		EntityManager entityManager=emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Login login= 
					entityManager.find(Login.class, id);
			entityManager.remove(id);
			entityManager.getTransaction().commit();	
			return login.getId();
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			throw e;
		}catch(Exception e) {
			throw e;
		}finally {
			entityManager.close();
		}	
	}

	@Override
	public Login updatePassword(Login login, String firstName, String lastName) throws PersistenceException {
		// TODO Auto-generated method stub
		EntityManager entityManager=emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Login updatePassword= 
					entityManager.merge(login);			
			entityManager.flush();
			entityManager.getTransaction().commit();	
			return updatePassword;
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			throw e;
		}catch(Exception e) {
			throw e;
		}finally {
			entityManager.close();
		}	
	}

	@Override
	public Login updateFirstName(Login login) throws PersistenceException {
		// TODO Auto-generated method stub
		EntityManager entityManager=emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Login updateFirstName= 
					entityManager.merge(login);			
			entityManager.flush();
			entityManager.getTransaction().commit();	
			return updateFirstName;
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			throw e;
		}catch(Exception e) {
			throw e;
		}finally {
			entityManager.close();
		}	

	}

	@Override
	public Login updateLastName(Login login) throws PersistenceException {
		// TODO Auto-generated method stub
		EntityManager entityManager=emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Login updateLastName= 
					entityManager.merge(login);			
			entityManager.flush();
			entityManager.getTransaction().commit();	
			return updateLastName;
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			throw e;
		}catch(Exception e) {
			throw e;
		}finally {
			entityManager.close();
		}	

	}
}

