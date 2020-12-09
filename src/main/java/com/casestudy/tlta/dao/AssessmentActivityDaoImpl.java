package com.casestudy.tlta.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.casestudy.tlta.entity.Assessment;
import com.casestudy.tlta.entity.LearningActivity;

public class AssessmentActivityDaoImpl implements AssessmentActivityDao{
	private EntityManagerFactory emf= 
			Persistence.createEntityManagerFactory("technology-learning-and-tracking-app");
	
	@Override
	public Integer addAssessmentActivity(Assessment assessmentActivity) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {			
			entityManager.getTransaction().begin();
			entityManager.persist(assessmentActivity);
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
	public Assessment searchAssessmentActivityById(Integer id) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {
			//			entityManager.getTransaction().begin(); 
			Assessment assessmentActivity=
					entityManager.find(Assessment.class, id);			
			//			entityManager.getTransaction().commit();
			return assessmentActivity;
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
	public Integer deleteAssessmentActivity(Integer id) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Assessment assessmentActivity= 
					entityManager.find(Assessment.class, id);
			entityManager.remove(assessmentActivity);
			//			entityManager.flush();
			entityManager.getTransaction().commit();	
			return assessmentActivity.getId();
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
	public List<Assessment> getAllAssessmentActivity() throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();

		String jql= "From Assessment a";
		try {			
			entityManager.getTransaction().begin();
			TypedQuery<Assessment> query=
					entityManager.createQuery(jql, Assessment.class);
			List<Assessment> activityList=query.getResultList();
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
	public Assessment updateAssessmentActivity(Assessment assessmentActivity) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Assessment updateassessmentActivity= 
					entityManager.merge(assessmentActivity);			
			entityManager.flush();
			entityManager.getTransaction().commit();	
			return updateassessmentActivity;
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
