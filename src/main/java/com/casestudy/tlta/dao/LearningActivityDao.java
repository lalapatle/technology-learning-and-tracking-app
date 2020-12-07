package com.casestudy.tlta.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import com.casestudy.tlta.entity.LearningActivity;

public interface LearningActivityDao {
	public Integer addLearningActivity(LearningActivity learningActivity) throws PersistenceException; 
	public LearningActivity searchLearningActivityById(Integer id) throws PersistenceException;
	public Integer deleteLearningActivity( Integer id) throws PersistenceException; 
	public List<LearningActivity> getAllLearningActivity() throws PersistenceException; 
	public LearningActivity updateLearningActivity(LearningActivity learningActivity) throws PersistenceException;
}
