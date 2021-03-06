package com.casestudy.tlta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.casestudy.tlta.entity.RegisterUser;

public class RegisterUserDaoImpl implements RegisterUserDao{

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("technology-learning-and-tracking-app");
	@Override
	public void addUser(RegisterUser login) throws PersistenceException {
		
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
	public RegisterUser getUserById(Integer id) throws PersistenceException {
		// TODO Auto-generated method stub
		EntityManager entityManager=emf.createEntityManager();
		try {

			RegisterUser login =
					entityManager.find(RegisterUser.class, id);			

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
	public RegisterUser getModeratorById(Integer id) throws PersistenceException {
		
		EntityManager entityManager=emf.createEntityManager();
		try {

			RegisterUser login =
					entityManager.find(RegisterUser.class, id);			

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
	public Integer deleteUser(Integer id) throws PersistenceException {
		// TODO Auto-generated method stub
		EntityManager entityManager=emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			RegisterUser login= 
					entityManager.find(RegisterUser.class, id);
			entityManager.remove(login);
			entityManager.getTransaction().commit();	
			return id;
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
	public RegisterUser updatePassword(RegisterUser login, String firstName, String lastName) throws PersistenceException {
		// TODO Auto-generated method stub
		EntityManager entityManager=emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			RegisterUser updatePassword= 
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
	public RegisterUser updateFirstName(RegisterUser login) throws PersistenceException {
		// TODO Auto-generated method stub
		EntityManager entityManager=emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			RegisterUser updateFirstName= 
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
	public RegisterUser updateLastName(RegisterUser login) throws PersistenceException {
		// TODO Auto-generated method stub
		EntityManager entityManager=emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			RegisterUser updateLastName= 
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
	@Override
	public RegisterUser updatePassword(RegisterUser login) throws PersistenceException {
		// TODO Auto-generated method stub
		EntityManager entityManager=emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			RegisterUser updatePassword= 
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
	public List<RegisterUser> getAllRegisteredUser() throws PersistenceException {
		// TODO Auto-generated method stub
		EntityManager entityManager=emf.createEntityManager();

		String jql= "From RegisterUser a";
		try {			
			entityManager.getTransaction().begin();
			TypedQuery<RegisterUser> query=
					entityManager.createQuery(jql,RegisterUser.class);
			List<RegisterUser> userList=query.getResultList();
			entityManager.getTransaction().commit();			
			return userList;
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





