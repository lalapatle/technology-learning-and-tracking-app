package com.casestudy.tlta.boundry;

import java.util.List;

import javax.persistence.PersistenceException;

import com.casestudy.tlta.entity.LearningActivity;
import com.casestudy.tlta.exception.ActivityException;
import com.casestudy.tlta.exception.AssesmentException;

public interface LearningActivityBoundry {
	public Integer addLearningActivity(LearningActivity learningActivity) throws ActivityException, AssesmentException; 
	public LearningActivity searchLearningActivityById(Integer id) throws ActivityException;
	public Integer deleteLearningActivity( Integer id) throws ActivityException; 
	public List<LearningActivity> getAllLearningActivity() throws ActivityException; 
	public LearningActivity updateLearningActivity(LearningActivity learningActivity) throws ActivityException;

}
