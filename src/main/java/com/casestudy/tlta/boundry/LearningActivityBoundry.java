package com.casestudy.tlta.boundry;

import java.util.List;

import javax.persistence.PersistenceException;

import com.casestudy.tlta.entity.LearningActivity;
import com.casestudy.tlta.exception.ActivityException;

public interface LearningActivityBoundry {
	public Integer addLearningActivity(LearningActivity learningActivity) throws ActivityException; 
	public LearningActivity searchLearningActivityById(Integer id) throws ActivityException;
	public Integer deleteLearningActivity( Integer id) throws ActivityException; 
	public List<LearningActivity> getAllLearningActivity() throws ActivityException; 
	public LearningActivity updateLearningActivity(LearningActivity learningActivity) throws ActivityException;

}
