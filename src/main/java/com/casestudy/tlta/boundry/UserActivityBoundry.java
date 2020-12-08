package com.casestudy.tlta.boundry;

import com.casestudy.tlta.entity.UserActivity;
import com.casestudy.tlta.exception.ActivityException;

public interface UserActivityBoundry {

	public UserActivity uploadCerificate(UserActivity userActivity,String filePath) throws ActivityException;
	public UserActivity updateStatus(UserActivity userActivity,String status) throws ActivityException;
}
