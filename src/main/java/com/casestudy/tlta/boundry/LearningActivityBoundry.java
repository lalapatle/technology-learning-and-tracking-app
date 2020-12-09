package com.casestudy.tlta.boundry;

import java.util.List;

import javax.persistence.PersistenceException;

import com.casestudy.tlta.entity.Assessment;
import com.casestudy.tlta.entity.LearningActivity;
import com.casestudy.tlta.exception.ActivityException;
import com.casestudy.tlta.exception.AssesmentException;

public interface LearningActivityBoundry {
//	public Integer addLearningActivity(LearningActivity learningActivity) throws ActivityException; 
	public Integer addLearningActivity(LearningActivity learningActivity) throws PersistenceException, AssesmentException, ActivityException;
	public LearningActivity searchLearningActivityById(Integer id) throws ActivityException;
	public Integer deleteLearningActivity( Integer id) throws ActivityException; 
	public List<LearningActivity> getAllLearningActivity() throws ActivityException; 
	public LearningActivity updateLearningActivity(LearningActivity learningActivity) throws ActivityException;

}
