package com.casestudy.tlta.dao;

import javax.persistence.PersistenceException;

import com.casestudy.tlta.entity.UserActivity;

public interface UserActivityDao {

	UserActivity uploadCerificate(UserActivity userActivity, String filePath) throws PersistenceException;

	UserActivity updateStatus(UserActivity userActivity, String status) throws PersistenceException;

}
