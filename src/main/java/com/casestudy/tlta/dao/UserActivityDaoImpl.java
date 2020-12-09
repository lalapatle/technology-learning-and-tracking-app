package com.casestudy.tlta.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.casestudy.tlta.entity.LearningActivity;
import com.casestudy.tlta.entity.RegisterUser;
import com.casestudy.tlta.entity.UserActivity;


public class UserActivityDaoImpl implements UserActivityDao{

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("technology-learning-and-tracking-app");
	private RegisterUserDao loginDao = new RegisterUserDaoImpl();
	private LearningActivityDao learningActivityDao = new LearningActivityDaoImpl();
	@Override
	public UserActivity uploadCerificate(UserActivity userActivity, String filePath) throws PersistenceException {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			userActivity.setStatus("complete");
			userActivity.setCertificate(filePath);
			UserActivity updatedUserActivity = em.merge(userActivity);
			em.flush();
			em.getTransaction().commit();
			return updatedUserActivity;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
			
		}

	}

	@Override
	public UserActivity updateStatus(UserActivity userActivity, String status) throws PersistenceException {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			userActivity.setStatus(status);		
			UserActivity updatedUserActivity = em.merge(userActivity);
			em.flush();
			em.getTransaction().commit();
			return updatedUserActivity;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
			
		}
	}
	public Integer userRegisterToLearningActivity(UserActivity userActivity, Integer userId, Integer activityId) throws PersistenceException {
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			RegisterUser newUser = loginDao.getUserById(userId);
			LearningActivity newActivity = learningActivityDao.searchLearningActivityById(activityId);
			userActivity.setLearningActivity(newActivity);
			userActivity.setLogin(newUser);
			em.persist(userActivity);
			em.getTransaction().commit();
			return userActivity.getUserActivityId();
		}catch(PersistenceException e) {
			em.getTransaction().rollback();
			throw e;
		}catch(Exception e) {
			throw e;
		}finally {
			em.close();
		}
		
		
	}

}