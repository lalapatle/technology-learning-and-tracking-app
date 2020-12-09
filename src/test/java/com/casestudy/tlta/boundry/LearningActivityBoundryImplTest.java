package com.casestudy.tlta.boundry;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.casestudy.tlta.dao.LearningActivityDaoImpl;
import com.casestudy.tlta.entity.Assessment;
import com.casestudy.tlta.entity.LearningActivity;
import com.casestudy.tlta.exception.ActivityException;
import com.casestudy.tlta.exception.AssesmentException;

@RunWith(MockitoJUnitRunner.class)
class LearningActivityBoundryImplTest {
	@InjectMocks
	private LearningActivityBoundryImpl learningImpl;

	@Mock
	private LearningActivityDaoImpl learningActivityDaoImpl;
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAddLearningActivity() throws ActivityException, ParseException, AssesmentException {
		LearningActivity learning = new LearningActivity();
		String date = "2020-05-20";
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		Assessment assess = new Assessment(1,"java","MCQ",date1, 25.30);
		learning.setId(1);
		learning.setActivity_name("Java");
		learning.setActivity_link("www.google.com");
		learning.setActivity_level("Intermediate");
		learning.setActivity_realsedate(date1);
		learning.setActivity_time(24.30);
		learning.setAssesment(assess);
		if(learningImpl != null) {
			learningImpl.addLearningActivity(learning);
			verify(learningActivityDaoImpl, times(1)).addLearningActivity(learning);
		}
	}

	@Test
	void testSearchLearningActivityById() throws ActivityException {
		LearningActivity learning = new LearningActivity();
		if(learningImpl != null) {
			if(learning.getId() != null) {
				learning.setId(2);
			}
			learningImpl.searchLearningActivityById(2);
		verify(learningActivityDaoImpl, times(1)).searchLearningActivityById(2);
		}
	}

	@Test
	void testDeleteLearningActivity() throws ActivityException {
		LearningActivity learning = new LearningActivity();
		if(learningImpl != null) {
			if(learning.getId() != null) {
				learning.setId(2);
			}
			learningImpl.deleteLearningActivity(2);
		verify(learningActivityDaoImpl, times(1)).deleteLearningActivity(2);
		}
	}

	@Test
	void testGetAllLearningActivity() throws ActivityException {
		LearningActivity learning = new LearningActivity();
		if(learningImpl != null) {
			if(learning.getId() != null) {
				learningImpl.getAllLearningActivity();
				verify(learningActivityDaoImpl, times(1)).getAllLearningActivity();
			}
		}
	}

	@Test
	void testUpdateLearningActivity() throws ActivityException {
		LearningActivity learning = new LearningActivity();
		if(learningImpl != null) {
			if(learning.getId() != null) {
			learning.setActivity_name("C#");
			}
		
			learningImpl.updateLearningActivity(learning);
			verify(learningActivityDaoImpl, times(1)).updateLearningActivity(learning);
		}
	}

}
