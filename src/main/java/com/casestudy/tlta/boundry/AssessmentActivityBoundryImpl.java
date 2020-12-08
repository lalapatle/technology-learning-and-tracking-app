package com.casestudy.tlta.boundry;
import java.util.List;

import javax.persistence.PersistenceException;

import com.casestudy.tlta.dao.AssessmentActivityDao;
import com.casestudy.tlta.dao.AssessmentActivityDaoImpl;
import com.casestudy.tlta.entity.Assessment;
import com.casestudy.tlta.exception.AssesmentException;



public class AssessmentActivityBoundryImpl implements AssessmentActivityBoundry{
	private AssessmentActivityDao assessmentActivityDao= new AssessmentActivityDaoImpl();

	@Override
	public   Integer addAssessmentActivity(Assessment assessmentActivity) throws AssesmentException {
		// TODO Auto-generated method stub
		try {
			
			assessmentActivityDao.addAssessmentActivity(assessmentActivity);			
		}catch(PersistenceException e) {
			throw new AssesmentException(e.getMessage(),e);
		}
		return 1;

	}
	

	@Override
	public Assessment searchAssessmentActivityById(Integer id) throws AssesmentException {
		// TODO Auto-generated method stub
		try {			
			Assessment assessment= assessmentActivityDao.searchAssessmentActivityById(id);
			return assessment;
		}catch(PersistenceException e) {
			throw new AssesmentException (e.getMessage(),e);
		}
	}
	

	@Override
	public Integer deleteAssessmentActivity(Integer id) throws AssesmentException {
		// TODO Auto-generated method stub
		try {			
			Integer Id= assessmentActivityDao.deleteAssessmentActivity(id);
			return Id;
		}catch(PersistenceException e) {
			throw new AssesmentException(e.getMessage(),e);
		}
	}

	@Override
	public List<Assessment> getAllAssessmentActivity() throws AssesmentException {
		// TODO Auto-generated method stub
		try {			
			List<Assessment> assessmentList= 
					assessmentActivityDao.getAllAssessmentActivity();
			return assessmentList;
		}catch(PersistenceException e) {
			throw new  AssesmentException(e.getMessage(),e);
		}
	}

	@Override
	public Assessment updateAssessmentActivity(Assessment assessmentActivity) throws AssesmentException {
		// TODO Auto-generated method stub
		try {			
			Assessment updatedAssessment= 
					assessmentActivityDao.updateAssessmentActivity(assessmentActivity);
			return updatedAssessment;
		}catch(PersistenceException e) {
			throw new AssesmentException(e.getMessage(),e);
		}
	}

	}
	
	
	

