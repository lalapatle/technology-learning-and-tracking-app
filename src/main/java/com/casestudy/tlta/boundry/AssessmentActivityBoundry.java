package com.casestudy.tlta.boundry;

import java.util.List;

import com.casestudy.tlta.entity.Assessment;
import com.casestudy.tlta.exception.AssesmentException;

public interface AssessmentActivityBoundry {
	public Integer addAssessmentActivity(Assessment assessmentActivity) throws AssesmentException; 
	public Assessment searchAssessmentActivityById(Integer id) throws AssesmentException;
	public Integer deleteAssessmentActivity(Integer id) throws AssesmentException;
	public List<Assessment> getAllAssessmentActivity() throws AssesmentException; 
	public Assessment updateAssessmentActivity(Assessment assessmentActivity) throws AssesmentException;
  
}
