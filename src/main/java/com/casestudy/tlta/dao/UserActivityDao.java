package com.casestudy.tlta.dao;

import javax.persistence.PersistenceException;

import com.casestudy.tlta.entity.UserActivity;
import com.casestudy.tlta.exception.ActivityException;

public interface UserActivityDao {
	
	public UserActivity uploadCerificate(UserActivity userActivity,String filePath) throws PersistenceException;
	public UserActivity updateStatus(UserActivity userActivity, String status) throws PersistenceException;
}
