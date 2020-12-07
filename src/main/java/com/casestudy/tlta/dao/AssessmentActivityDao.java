package com.casestudy.tlta.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import com.casestudy.tlta.entity.Assessment;
import com.casestudy.tlta.entity.LearningActivity;

public interface AssessmentActivityDao {
	public Integer addAssessmentActivity(Assessment assessmentActivity) throws PersistenceException; 
	public Assessment searchAssessmentActivityById(Integer id) throws PersistenceException;
	public Integer deleteAssessmentActivity(Integer id) throws PersistenceException; 
	public List<Assessment> getAllAssessmentActivity() throws PersistenceException; 
	public Assessment updateAssessmentActivity(Assessment assessmentActivity) throws PersistenceException;
}

