package com.casestudy.tlta.boundry;

import javax.persistence.PersistenceException;

import com.casestudy.tlta.dao.UserActivityDao;
import com.casestudy.tlta.dao.UserActivityDaoImpl;
import com.casestudy.tlta.entity.UserActivity;
import com.casestudy.tlta.exception.ActivityException;


public class UserActivityBoundryImpl implements UserActivityBoundry{
	private UserActivityDao userActivityDao= new UserActivityDaoImpl();
	@Override
	public UserActivity uploadCerificate(UserActivity userActivity, String filePath) throws ActivityException {
		try {			
			UserActivity updatedUserActivity= 
					userActivityDao.uploadCerificate(userActivity,filePath);
			
			return updatedUserActivity;
		}catch(PersistenceException e) {
			throw new ActivityException(e.getMessage(),e);
		}
	}
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
}
