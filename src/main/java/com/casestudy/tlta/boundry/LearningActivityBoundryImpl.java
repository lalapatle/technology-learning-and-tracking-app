package com.casestudy.tlta.boundry;

import java.util.List;

import javax.persistence.PersistenceException;

import com.casestudy.tlta.dao.LearningActivityDao;
import com.casestudy.tlta.dao.LearningActivityDaoImpl;
import com.casestudy.tlta.entity.LearningActivity;
import com.casestudy.tlta.exception.ActivityException;

public class LearningActivityBoundryImpl implements LearningActivityBoundry{
	private LearningActivityDao learningActivityDao=new LearningActivityDaoImpl();
	@Override
	public Integer addLearningActivity(LearningActivity learningActivity) throws ActivityException {
		try {
			return learningActivityDao.addLearningActivity(learningActivity);
		}catch(PersistenceException e) {
			throw new ActivityException(e.getMessage(),e);
		}
	}

	@Override
	public LearningActivity searchLearningActivityById(Integer id) throws ActivityException {
		try {
			LearningActivity learningActivity=learningActivityDao.searchLearningActivityById(id);
			return learningActivity;
		}catch(PersistenceException e) {
			throw new ActivityException(e.getMessage(),e);
		}
	}

	@Override
	public Integer deleteLearningActivity(Integer id) throws ActivityException {
		try {
		Integer deletedId=learningActivityDao.deleteLearningActivity(id);
		return deletedId;
		}catch(PersistenceException e) {
			throw new ActivityException(e.getMessage(),e);
		}
	}

	@Override
	public List<LearningActivity> getAllLearningActivity() throws ActivityException {
		 try {            
	            List<LearningActivity> activityList=
	            		learningActivityDao.getAllLearningActivity();
	            return activityList;
	        }catch(PersistenceException e) {
	            throw new ActivityException(e.getMessage(),e);
	        }
	}

	@Override
	public LearningActivity updateLearningActivity(LearningActivity learningActivity) throws ActivityException {
		try {            
			LearningActivity updateLearningActivity=learningActivityDao.updateLearningActivity(learningActivity);
			return updateLearningActivity;
        }catch(PersistenceException e) {
            throw new ActivityException(e.getMessage(),e);
        }
	}

}
