package com.casestudy.tlta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.casestudy.tlta.entity.LearningActivity;

public class LearningActivityDaoImpl implements LearningActivityDao{
	private EntityManagerFactory emf= 
			Persistence.createEntityManagerFactory("technology-learning-and-tracking-app");

	@Override
	public Integer addLearningActivity(LearningActivity learningActivity) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {			
			entityManager.getTransaction().begin();
			entityManager.persist(learningActivity);
			entityManager.flush();
			entityManager.getTransaction().commit();	
			return 1;
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
	public LearningActivity searchLearningActivityById(Integer id) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {
			//			entityManager.getTransaction().begin(); 
			LearningActivity learningActivity=
					entityManager.find(LearningActivity.class, id);			
			//			entityManager.getTransaction().commit();
			return learningActivity;
		}catch(PersistenceException e) {
			//			entityManager.getTransaction().rollback();
			throw e;
		}catch(Exception e) {
			throw e;
		}finally {
			entityManager.close();
		}	

	}

	@Override
	public Integer deleteLearningActivity(Integer id) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			LearningActivity learningActivity= 
					entityManager.find(LearningActivity.class, id);
			entityManager.remove(learningActivity);
			//			entityManager.flush();
			entityManager.getTransaction().commit();	
			return learningActivity.getId();
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
	public List<LearningActivity> getAllLearningActivity() throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();

		String jql= "From LearningActivity a";
		try {			
			entityManager.getTransaction().begin();
			TypedQuery<LearningActivity> query=
					entityManager.createQuery(jql, LearningActivity.class);
			List<LearningActivity> activityList=query.getResultList();
			entityManager.getTransaction().commit();			
			return activityList;
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
	public LearningActivity updateLearningActivity(LearningActivity learningActivity) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			LearningActivity updateLearningActivity= 
					entityManager.merge(learningActivity);			
			entityManager.flush();
			entityManager.getTransaction().commit();	
			return updateLearningActivity;
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

