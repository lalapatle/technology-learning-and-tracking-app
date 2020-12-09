package com.casestudy.tlta.dao;

import javax.persistence.PersistenceException;

import com.casestudy.tlta.entity.LearningActivity;
import com.casestudy.tlta.entity.RegisterUser;
import com.casestudy.tlta.entity.UserActivity;

public interface UserActivityDao {
	
	public Integer userRegisterToLearningActivity(UserActivity userActivity, Integer userId, Integer activityId) throws PersistenceException;
	public UserActivity uploadCerificate(UserActivity userActivity,String filePath) throws PersistenceException;
	public UserActivity updateStatus(UserActivity userActivity, String status) throws PersistenceException;
}
