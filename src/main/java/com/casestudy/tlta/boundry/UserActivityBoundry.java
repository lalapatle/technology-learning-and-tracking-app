package com.casestudy.tlta.boundry;

import javax.persistence.PersistenceException;

import com.casestudy.tlta.entity.UserActivity;
import com.casestudy.tlta.exception.ActivityException;

public interface UserActivityBoundry {

	public Integer uploadCerificate(String filePath,Integer userId,Integer activityId) throws ActivityException;
	public UserActivity updateStatus(UserActivity userActivity,String status) throws ActivityException;
	public Integer userRegisterToLearningActivity(UserActivity userActivity, Integer userId, Integer activityId) throws ActivityException;
}
