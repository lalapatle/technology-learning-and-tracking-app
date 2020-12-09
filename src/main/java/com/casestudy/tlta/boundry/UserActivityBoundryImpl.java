package com.casestudy.tlta.boundry;

import javax.persistence.PersistenceException;

import com.casestudy.tlta.dao.UserActivityDao;
import com.casestudy.tlta.dao.UserActivityDaoImpl;
import com.casestudy.tlta.entity.UserActivity;
import com.casestudy.tlta.exception.ActivityException;


public class UserActivityBoundryImpl implements UserActivityBoundry{
	private UserActivityDao userActivityDao= new UserActivityDaoImpl();
	
	@Override
	public UserActivity updateStatus(UserActivity userActivity, String status) throws ActivityException {
		try {			
			UserActivity updatedUserActivity= 
					userActivityDao.updateStatus(userActivity,status);
			
			return updatedUserActivity;
		}catch(PersistenceException e) {
			throw new ActivityException(e.getMessage(),e);
		}
	}
	@Override
	public Integer userRegisterToLearningActivity(UserActivity userActivity, Integer userId, Integer activityId)
			throws ActivityException {
		try {
			Integer userActivityId = userActivityDao.userRegisterToLearningActivity(userActivity, userId, activityId);
			return userActivityId;
		}catch(PersistenceException p) {
			throw new ActivityException(p.getMessage(),p);
		}
		
	}
	@Override
	public Integer uploadCerificate(String filePath, Integer userId, Integer activityId) throws ActivityException {
		try {
			Integer updateId = userActivityDao.uploadCerificate(filePath, userId, activityId);
			return updateId;
		}catch(PersistenceException p) {
			throw new ActivityException(p.getMessage(),p);
		}
		
	}
	
}
